package com.ipsoft.managementdivisionbackendgradle.config;

import com.ipsoft.managementdivisionbackendgradle.api.TechLeadAPI;
import com.ipsoft.managementdivisionbackendgradle.util.Convertor;
import com.ipsoft.managementdivisionbackendgradle.util.ImageConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {TechLeadAPI.class})
public class WebAppConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(2000000);
        return commonsMultipartResolver;
    }
}
