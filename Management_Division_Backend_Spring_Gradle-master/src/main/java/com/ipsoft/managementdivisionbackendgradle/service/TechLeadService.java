package com.ipsoft.managementdivisionbackendgradle.service;

import com.ipsoft.managementdivisionbackendgradle.dto.TechLeadDTO;

public interface TechLeadService {
    void addTechLead(TechLeadDTO techLeadDTO);
    TechLeadDTO getTechLead(String id);
    void deleteTechLead(String id);
    void updateTechLead(TechLeadDTO techLeadDTO);
}
