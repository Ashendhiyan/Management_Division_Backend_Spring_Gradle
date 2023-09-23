package com.ipsoft.managementdivisionbackendgradle.config;

import com.ipsoft.managementdivisionbackendgradle.service.impl.TechLeadServiceIMPL;
import com.ipsoft.managementdivisionbackendgradle.util.Convertor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackageClasses = {TechLeadServiceIMPL.class, Convertor.class})
public class WebRootConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
