package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.springstarterbuttercms.service.PageCollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    private final PageCollectionService pageCollectionService;

    public IndexController(PageCollectionService pageCollectionService) {
        this.pageCollectionService = pageCollectionService;
    }

    @GetMapping("/")
    public String index(Model model) {
        pageCollectionService.addDataToLandingPage(model);
        return "index";
    }
}
