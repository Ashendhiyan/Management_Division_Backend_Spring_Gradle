package com.ipsoft.managementdivisionbackendgradle.api;

import com.ipsoft.managementdivisionbackendgradle.dto.ProjectDTO;
import com.ipsoft.managementdivisionbackendgradle.dto.ProjectGetDTO;
import com.ipsoft.managementdivisionbackendgradle.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Project")
public class ProjectAPI {
    @Autowired
    ProjectService projectService;
    @PostMapping
    public ResponseEntity<String> saveProject(@RequestBody ProjectDTO projectDTO){
        System.out.println(projectDTO.toString());
        projectService.addProject(projectDTO);
        return new ResponseEntity<>("Save Project....!!", HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<ProjectGetDTO> getProjectById(String id){
        return new ResponseEntity<>(projectService.getProjectById(id),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody ProjectDTO projectDTO){
        System.out.println("reach");
        System.out.println(projectDTO.toString());
        projectService.updateProject(projectDTO);
        return new ResponseEntity<>("Update Project....!!", HttpStatus.OK);
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteProject(String id){
        projectService.deleteProject(id);
        return new ResponseEntity<>("Project Deleted Successfully",HttpStatus.OK);
    }
}
