package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final IButterCMSClient butterCMSClient;

    public IndexController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
