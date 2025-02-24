package com.caoliang.springboot.fileUpload.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringBootWebMvcConfiger implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/files/**").addResourceLocations("file:/Users/caoliang/Downloads/Java_project/spring-boot-learning-processing/spring-boot-learning-processing/spring-boot-file-upload/src/main/resources/static/");
    }
}
