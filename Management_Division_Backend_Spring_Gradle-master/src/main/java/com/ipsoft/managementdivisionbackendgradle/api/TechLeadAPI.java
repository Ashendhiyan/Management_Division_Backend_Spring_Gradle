package com.ipsoft.managementdivisionbackendgradle.api;

import com.ipsoft.managementdivisionbackendgradle.dto.TechLeadDTO;
import com.ipsoft.managementdivisionbackendgradle.entity.TechLead;
import com.ipsoft.managementdivisionbackendgradle.repo.TechLeadREPO;
import com.ipsoft.managementdivisionbackendgradle.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/techLead")
public class TechLeadAPI {
    @Autowired
    TechLeadService techLeadService;

    @Autowired
    TechLeadREPO techLeadREPO;

    @PostMapping
    public ResponseEntity<String> saveTechLead(
            @RequestParam("id") String empId,
            @RequestParam("name") String name,
            @RequestParam(value = "dob",required = false) String dob,
            @RequestParam("nic") String nic,
            @RequestParam("profile") MultipartFile profile
    ) {

        try {
            techLeadService.addTechLead(new TechLeadDTO(empId, name,dob, nic, Base64.getEncoder().encodeToString(profile.getBytes())));
        } catch (IOException e) {
            throw new RuntimeException("Image not found...!!");
        }
        return new ResponseEntity<>("TechLead Saved....!!", HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<byte[]> getImage(String id ){
        TechLead techLead = techLeadREPO.findById(id).get();
        byte[] bytes = Base64.getDecoder().decode(techLead.getProfile());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytes,httpHeaders,HttpStatus.OK);
    }


//    @GetMapping(params = "id")
//    public ResponseEntity<TechLeadDTO> getTechLeadById(String id){
//        return new ResponseEntity<>(techLeadService.getTechLead(id),HttpStatus.OK);
//    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteTechLeadById(String id){
        techLeadService.deleteTechLead(id);
         return new ResponseEntity<>("TechLead Delete success...!!",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateTechLead(
            @RequestParam("id") String empId,
            @RequestParam("name") String name,
            @RequestParam(value = "dob",required = false) String dob,
            @RequestParam("nic") String nic,
            @RequestParam("profile") MultipartFile profile
    ){
        try {
            techLeadService.updateTechLead(new TechLeadDTO(empId, name,dob, nic, Base64.getEncoder().encodeToString(profile.getBytes())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>("TechLead Updated....!!", HttpStatus.OK);
    }

}
