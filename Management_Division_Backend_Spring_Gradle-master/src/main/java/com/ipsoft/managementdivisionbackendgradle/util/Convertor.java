package com.ipsoft.managementdivisionbackendgradle.util;

import com.ipsoft.managementdivisionbackendgradle.dto.ProjectDTO;
import com.ipsoft.managementdivisionbackendgradle.dto.ProjectGetDTO;
import com.ipsoft.managementdivisionbackendgradle.dto.TechLeadDTO;
import com.ipsoft.managementdivisionbackendgradle.entity.Project;
import com.ipsoft.managementdivisionbackendgradle.entity.TechLead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Convertor {
    @Autowired
    ModelMapper modelMapper;
    public Project projectDTOtoProjectEntity(ProjectDTO projectDTO, TechLead techLead){
        Project project = modelMapper.map(projectDTO, Project.class);
        project.setTechLead(modelMapper.map(techLead,TechLead.class));
        return project;
    }

    public ProjectGetDTO ProjectEntityToProjectGetDTO(Project project){
        TechLeadDTO techLeadDTO = modelMapper.map(project.getTechLead(), TechLeadDTO.class);
        ProjectGetDTO projectGetDTO = modelMapper.map(project, ProjectGetDTO.class);
        projectGetDTO.setTechLeadDTO(techLeadDTO);
        return projectGetDTO;
    }
}
