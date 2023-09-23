package com.ipsoft.managementdivisionbackendgradle.repo;

import com.ipsoft.managementdivisionbackendgradle.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TechLeadREPO extends JpaRepository<TechLead,String> {
    boolean existsTechLeadByNic(String nic);
}
