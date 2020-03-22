package com.atfcm.airportlogistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页映射
        registry.addViewController("/admin").setViewName("dashboard");
        registry.addViewController("/admin/login").setViewName("loginAdmin");
        //登录后重定向映射的映射  防止表单重复提交
        registry.addViewController("/admin/main").setViewName("dashboard");
    }
}
