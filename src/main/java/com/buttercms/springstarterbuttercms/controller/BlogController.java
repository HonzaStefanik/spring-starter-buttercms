package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//TODO remove hardcoded strings and place them into constants

@Controller
public class BlogController {
    private final IButterCMSClient butterCMSClient;

    public BlogController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/blog/")
    public String blogs(Model model) {
        PostsResponse posts = butterCMSClient.getPosts(Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("categories", categories.getData());
        return "blogs";
    }

    @GetMapping("/blog/{slug}")
    public String blogById(@PathVariable String slug,  Model model) {
        PostResponse post = butterCMSClient.getPost(slug);
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("post", post.getData());
        model.addAttribute("categories", categories.getData());
        return "blog-post";
    }

    @GetMapping("/blog/category/{category_slug}")
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

    @GetMapping("/blog/tag/{tag_slug}")
    public String blogByTag(@PathVariable String tag_slug,  Model model) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("tag_slug", tag_slug);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        TagResponse tag = butterCMSClient.getTag(tag_slug, Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("tag", tag.getData());
        model.addAttribute("categories", categories.getData());
        return "blogs";
    }
}
