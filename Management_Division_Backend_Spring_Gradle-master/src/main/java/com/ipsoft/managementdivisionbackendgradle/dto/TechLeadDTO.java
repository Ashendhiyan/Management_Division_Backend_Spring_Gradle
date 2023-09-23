package com.ipsoft.managementdivisionbackendgradle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechLeadDTO {
        private String empId;
        private String name;
        private String dob;
        private String nic;
        private String profile;
}
