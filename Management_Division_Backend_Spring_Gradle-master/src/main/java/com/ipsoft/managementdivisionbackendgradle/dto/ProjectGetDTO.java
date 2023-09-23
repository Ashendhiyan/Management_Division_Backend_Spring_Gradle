package com.ipsoft.managementdivisionbackendgradle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectGetDTO {
    private String projectID;
    private String projectName;
    private String handOverDate;
    private String deathLine;
    private TechLeadDTO techLeadDTO;
}
