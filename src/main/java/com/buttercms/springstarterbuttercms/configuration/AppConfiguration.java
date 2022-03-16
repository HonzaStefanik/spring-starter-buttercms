package com.buttercms.springstarterbuttercms.configuration;

import com.buttercms.ButterCMSClient;
import com.buttercms.IButterCMSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${buttercms.token}")
    private String token;

    // TODO - add it to the client once that functionality is implemented
    @Value("${buttercms.preview}")
    private boolean preview;

    @Bean
    public IButterCMSClient butterCMSClient() {
        return new ButterCMSClient(token);
    }
}
