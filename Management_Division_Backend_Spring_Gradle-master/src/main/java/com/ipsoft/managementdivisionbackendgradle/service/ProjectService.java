package com.ipsoft.managementdivisionbackendgradle.service;

import com.ipsoft.managementdivisionbackendgradle.dto.ProjectDTO;
import com.ipsoft.managementdivisionbackendgradle.dto.ProjectGetDTO;

public interface ProjectService {
    void addProject(ProjectDTO projectDTO);
    ProjectGetDTO getProjectById(String id);
    void updateProject(ProjectDTO projectDTO);
    void deleteProject(String id);
}
