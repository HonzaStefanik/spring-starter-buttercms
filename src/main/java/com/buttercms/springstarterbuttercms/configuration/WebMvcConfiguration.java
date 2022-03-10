package com.buttercms.springstarterbuttercms.configuration;

import com.buttercms.springstarterbuttercms.controller.interceptor.CommonElementsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final CommonElementsInterceptor commonElementsInterceptor;

    public WebMvcConfiguration(CommonElementsInterceptor commonElementsInterceptor) {
        this.commonElementsInterceptor = commonElementsInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonElementsInterceptor);
    }
}
