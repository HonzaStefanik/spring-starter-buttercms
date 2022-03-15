package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.springstarterbuttercms.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/")
    public String blogs(Model model) {
        blogService.addBlogData(model);
        return "blogs";
    }

    @GetMapping("/blog/{slug}")
    public String blogById(@PathVariable String slug, Model model) {
        blogService.addBlogDataByBlog(model, slug);
        return "blog-post";
    }

    @GetMapping("/blog/category/{categorySlug}")
    public String blogByCategory(@PathVariable String categorySlug, Model model) {
        blogService.addBlogDataByCategory(model, categorySlug);
        return "blogs";
    }

    @GetMapping("/blog/tag/{tagSlug}")
    public String blogByTag(@PathVariable String tagSlug, Model model) {
        blogService.addBlogDataByTags(model, tagSlug);
        return "blogs";
    }

    @PostMapping("/blog/search")
    public String search(@RequestParam String searchTerm, Model model) {
        blogService.addBlogDataBySearch(model, searchTerm);
        return "blogs";
    }

}
