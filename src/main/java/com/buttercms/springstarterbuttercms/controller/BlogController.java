package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.CategoriesResponse;
import com.buttercms.model.CategoryResponse;
import com.buttercms.model.PostResponse;
import com.buttercms.model.PostsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        PostResponse post = butterCMSClient.getPost(slug);
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("post", post.getData());
        model.addAttribute("categories", categories.getData());
        return "blog-post";
    }

    @GetMapping("/blogs/category/{category_slug}")
    public String blogByCategory(@PathVariable String category_slug,  Model model) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("category_slug", category_slug);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        CategoryResponse category = butterCMSClient.getCategory(category_slug, Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("category", category.getData());
        model.addAttribute("categories", categories.getData());
        return "blogs";
    }
}
