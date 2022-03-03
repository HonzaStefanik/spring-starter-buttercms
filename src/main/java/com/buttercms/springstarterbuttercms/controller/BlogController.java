package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.CategoriesResponse;
import com.buttercms.model.PostsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;

@Controller
public class BlogController {
    private final IButterCMSClient butterCMSClient;

    public BlogController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/blogs/")
    public String blogs(Model model) {
        PostsResponse posts = butterCMSClient.getPosts(Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("categories", categories.getData());
        return "blogs";
    }

    @GetMapping("/blogs/{slug}")
    public String blogById(@PathVariable String slug,  Model model) {
        //PostResponse posts = butterCMSClient.getPost(slug);
        return "blog-post";
    }
}
