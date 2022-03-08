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

    public ExceptionHandlingController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @ExceptionHandler(ButterCMSResponseException.class)
    public String invalidToken() {
        String token = butterCMSClient.getAuthToken();
        // TODO - ask whether the same error message should be logged for both invalid and missing token -> it looks like it based on the react starter project
        logger.error("Your Butter token might be set to an invalid value. Please verify your token is correct.");
        return token == null ? "404" : "invalid-token";
    }
}
