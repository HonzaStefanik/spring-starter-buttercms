package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.exception.ButterCMSResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

    private final IButterCMSClient butterCMSClient;
    private final String INVALID_TOKEN = "Invalid token.";

    public ExceptionHandlingController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    //Invalid token == env missing
    @ExceptionHandler(ButterCMSResponseException.class)
    public String invalidToken(ButterCMSResponseException exception) {
        if (exception.getMessage().contains(INVALID_TOKEN)) {
            String token = butterCMSClient.getAuthToken();
            logger.error("Your Butter token might be set to an invalid value. Please verify your token is correct.");
            return token == null ? "404" : "invalid-token";
        }
        throw exception;
    }
}
