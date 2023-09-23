package com.ipsoft.managementdivisionbackendgradle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String handOverDate;
    private String deathLine;
    private String tlId;
}
