package com.ipsoft.managementdivisionbackendgradle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project {
    @Id
    String projectId;
    String projectName;
    String handOverDate;
    String deathLine;
    @ManyToOne
    @JoinColumn(name = "empId",nullable = false)
    TechLead techLead;
}
