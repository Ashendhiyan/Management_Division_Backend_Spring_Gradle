package com.ipsoft.managementdivisionbackendgradle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TechLead {
    @Id
    String empId;
    String name;
    String dob;
    String nic;
    @Column(columnDefinition = "LONGTEXT")
    String profile;

    @OneToMany(mappedBy = "techLead",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    List<Project> projects = new ArrayList<>();
}
