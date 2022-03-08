package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.exception.ButterCMSResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(ButterCMSResponseException.class)
    public String invalidToken() {
        logger.error("Your Butter token is set to an invalid value. Please verify your token is correct.");
        return "404";
    }
}
