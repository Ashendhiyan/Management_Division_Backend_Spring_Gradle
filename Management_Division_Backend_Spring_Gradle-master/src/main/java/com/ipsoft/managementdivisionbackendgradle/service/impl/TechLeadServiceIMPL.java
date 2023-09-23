package com.ipsoft.managementdivisionbackendgradle.service.impl;

import com.ipsoft.managementdivisionbackendgradle.dto.TechLeadDTO;
import com.ipsoft.managementdivisionbackendgradle.entity.TechLead;
import com.ipsoft.managementdivisionbackendgradle.repo.TechLeadREPO;
import com.ipsoft.managementdivisionbackendgradle.service.ProjectService;
import com.ipsoft.managementdivisionbackendgradle.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TechLeadServiceIMPL implements TechLeadService {
    @Autowired
    private TechLeadREPO techLeadREPO;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addTechLead(TechLeadDTO techLeadDTO) {
        if(techLeadREPO.existsById(techLeadDTO.getEmpId()) || techLeadREPO.existsTechLeadByNic(techLeadDTO.getNic()) ) {
            throw new RuntimeException(techLeadDTO.getEmpId() + " Id or " + techLeadDTO.getNic() + " TechLead NIC is duplicated!!");
        }else{
            techLeadREPO.save(modelMapper.map(techLeadDTO, TechLead.class));
        }
    }

    @Override
    public TechLeadDTO getTechLead(String id) {
        Optional<TechLead> byId = techLeadREPO.findById(id);
        if(!byId.isPresent())
            throw new RuntimeException(id+" TechLead cannot find...!!");
        return modelMapper.map(byId.get(),TechLeadDTO.class);
    }

    @Override
    public void deleteTechLead(String id) {
        if(!techLeadREPO.existsById(id))
        throw new RuntimeException(id+" Cannot find TechLead...!!");
        techLeadREPO.deleteById(id);
    }

    @Override
    public void updateTechLead(TechLeadDTO techLeadDTO) {
        if(!techLeadREPO.existsById(techLeadDTO.getEmpId()))
            throw new RuntimeException(techLeadDTO.getEmpId()+" Cannot find TechLead...!!");
        techLeadREPO.save(modelMapper.map(techLeadDTO, TechLead.class));
    }

}
