package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.springstarterbuttercms.controller.dto.BlogsDto;
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
        BlogsDto blogsDto = blogService.getBlogs();
        model.addAttribute("posts", blogsDto.getPosts());
        model.addAttribute("categories", blogsDto.getCategories());
        model.addAttribute("seoTitle", blogsDto.getSeoTitle());
        model.addAttribute("seoDescription", blogsDto.getSeoDescription());
        model.addAttribute("breadcrumbText", blogsDto.getBreadcrumbText());
        return "blogs";
    }

    @GetMapping("/blog/{slug}")
    public String blogById(@PathVariable String slug, Model model) {
        BlogsDto blogsDto = blogService.getBlogsBySlug(slug);
        model.addAttribute("post", blogsDto.getPosts().get(0));
        model.addAttribute("categories", blogsDto.getCategories());
        model.addAttribute("seoTitle", blogsDto.getSeoTitle());
        model.addAttribute("seoDescription", blogsDto.getSeoDescription());
        model.addAttribute("breadcrumbText", blogsDto.getBreadcrumbText());
        model.addAttribute("subCollection", blogsDto.getSubCollection());
        return "blog-post";
    }

    @GetMapping("/blog/category/{categorySlug}")
    public String blogByCategory(@PathVariable String categorySlug, Model model) {
        BlogsDto blogsDto = blogService.getBlogsByCategory(categorySlug);
        model.addAttribute("posts", blogsDto.getPosts());
        model.addAttribute("category", blogsDto.getCategory());
        model.addAttribute("categories", blogsDto.getCategories());
        model.addAttribute("seoTitle", blogsDto.getSeoTitle());
        model.addAttribute("seoDescription", blogsDto.getSeoDescription());
        model.addAttribute("breadcrumbText", blogsDto.getBreadcrumbText());
        model.addAttribute("subCollection", blogsDto.getSubCollection());
        return "blogs";
    }

    @GetMapping("/blog/tag/{tagSlug}")
    public String blogByTag(@PathVariable String tagSlug, Model model) {
        BlogsDto blogsDto = blogService.getBlogsByTag(tagSlug);
        model.addAttribute("posts", blogsDto.getPosts());
        model.addAttribute("tag", blogsDto.getTag());
        model.addAttribute("categories", blogsDto.getCategories());
        model.addAttribute("seoTitle", blogsDto.getSeoTitle());
        model.addAttribute("seoDescription", blogsDto.getSeoDescription());
        model.addAttribute("breadcrumbText", blogsDto.getBreadcrumbText());
        model.addAttribute("subCollection", blogsDto.getSubCollection());
        return "blogs";
    }

    @PostMapping("/blog/search")
    public String search(@RequestParam String searchTerm, Model model) {
        BlogsDto blogsDto = blogService.searchBlogs(searchTerm);
        model.addAttribute("posts", blogsDto.getPosts());
        model.addAttribute("categories", blogsDto.getCategories());
        model.addAttribute("seoTitle", blogsDto.getSeoTitle());
        model.addAttribute("seoDescription", blogsDto.getSeoDescription());
        model.addAttribute("breadcrumbText", blogsDto.getBreadcrumbText());
        model.addAttribute("subCollection", blogsDto.getSubCollection());
        return "blogs";
    }

}
