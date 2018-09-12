package com.mycompany.innocent.authentification;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/bank").setViewName("bank");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}