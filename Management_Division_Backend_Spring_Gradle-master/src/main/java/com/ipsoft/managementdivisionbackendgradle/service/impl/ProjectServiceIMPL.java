package com.ipsoft.managementdivisionbackendgradle.service.impl;

import com.ipsoft.managementdivisionbackendgradle.dto.ProjectDTO;
import com.ipsoft.managementdivisionbackendgradle.dto.ProjectGetDTO;
import com.ipsoft.managementdivisionbackendgradle.entity.Project;
import com.ipsoft.managementdivisionbackendgradle.entity.TechLead;
import com.ipsoft.managementdivisionbackendgradle.repo.ProjectREPO;
import com.ipsoft.managementdivisionbackendgradle.repo.TechLeadREPO;
import com.ipsoft.managementdivisionbackendgradle.service.ProjectService;
import com.ipsoft.managementdivisionbackendgradle.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProjectServiceIMPL implements ProjectService {
    @Autowired
    Convertor convertor;
    @Autowired
    ProjectREPO projectREPO;
    @Autowired
    TechLeadREPO techLeadREPO;
    @Override
    public void addProject(ProjectDTO projectDTO) {
        if(projectREPO.existsById(projectDTO.getProjectId()))
            throw new RuntimeException(projectDTO.getProjectId()+" is not valid id...!!");
        Optional<TechLead> techLead=techLeadREPO.findById(projectDTO.getTlId());
        if(!techLead.isPresent())
            throw new RuntimeException(projectDTO.getTlId()+" is not valid TechLeadId...!!");
        //Project project = convertor.projectDTOtoProjectEntity(projectDTO, techLead);
        projectREPO.save(convertor.projectDTOtoProjectEntity(projectDTO, techLead.get()));
    }

    @Override
    public ProjectGetDTO getProjectById(String id) {
        if (!projectREPO.existsById(id))
            throw new RuntimeException(id+" Project id is not valid id...!!");
        return convertor.ProjectEntityToProjectGetDTO(projectREPO.findById(id).get());
    }

    @Override
    public void updateProject(ProjectDTO projectDTO) {
        if(!projectREPO.existsById(projectDTO.getProjectId()))
            throw new RuntimeException(projectDTO.getProjectId()+" Project Id is not valid id...!!");
        Optional<TechLead> techLead=techLeadREPO.findById(projectDTO.getTlId());
        if(!techLead.isPresent())
            throw new RuntimeException(projectDTO.getTlId()+" is not valid TechLeadId...!!");
        projectREPO.save(convertor.projectDTOtoProjectEntity(projectDTO, techLead.get()));
    }

    @Override
    public void deleteProject(String id) {
        if(!projectREPO.existsById(id))
            throw new RuntimeException(id+" Project Id is not valid id...!!");
        System.out.println(id);
        projectREPO.deleteById(id);
    }

}
