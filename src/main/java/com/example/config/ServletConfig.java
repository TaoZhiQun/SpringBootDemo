package com.example.config;

import com.example.util.TestServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ServletConfig {
    @Bean
    public TestServlet testServlet(){
        return new TestServlet();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(TestServlet testServlet){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(testServlet);
        registrationBean.setEnabled(true);
        registrationBean.addUrlMappings("/servlet/test");
        return registrationBean;
    }
}
