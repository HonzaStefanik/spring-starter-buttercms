package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PageResponse;
import com.buttercms.model.PostsResponse;
import com.buttercms.springstarterbuttercms.service.ButterCMSService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {
    private final IButterCMSClient butterCMSClient;

    public IndexController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("page", "1");
            put("page_size", "2");
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        // TODO - load page via this call
        // PageResponse<LandingPage> indexPage =
        //        butterCMSClient.getPage("*", "landing-page-with-components", Collections.emptyMap(), LandingPage.class);
        model.addAttribute("posts", posts.getData());
        return "index";
    }
}
