package com.buttercms.springstarterbuttercms.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.buttercms.springstarterbuttercms.configuration.Constants.*;

// TODO - remove hardcoded strings and place them into constants (although it messes up thymeleaf's autocompletion, reconsider)
// TODO - split thymeleaf into fragments to avoid duplicating code
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
        model.addAttribute("seoTitle", BLOG_SEO_TITLE);
        model.addAttribute("seoDescription", BLOG_SEO_DESCRIPTION);
        return "blogs";
    }

    @GetMapping("/blog/{slug}")
    public String blogById(@PathVariable String slug, Model model) {
        Post post = butterCMSClient.getPost(slug).getData();
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("post", post);
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", post.getSeoTitle());
        model.addAttribute("seoDescription", post.getMetaDescription());
        return "blog-post";
    }

    @GetMapping("/blog/category/{category_slug}")
    public String blogByCategory(@PathVariable String category_slug, Model model) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("category_slug", category_slug);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        CategoryResponse category = butterCMSClient.getCategory(category_slug, Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("category", category.getData());
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", BLOG_CATEGORY_SEO_TITLE);
        model.addAttribute("seoDescription", BLOG_CATEGORY_SEO_DESCRIPTION);
        return "blogs";
    }

    @GetMapping("/blog/tag/{tag_slug}")
    public String blogByTag(@PathVariable String tag_slug, Model model) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("tag_slug", tag_slug);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        TagResponse tag = butterCMSClient.getTag(tag_slug, Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("tag", tag.getData());
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", BLOG_TAG_SEO_TITLE);
        model.addAttribute("seoDescription", BLOG_TAG_SEO_DESCRIPTION);
        return "blogs";
    }

   // @GetMapping("/blog/search")
   // public String search(@RequestParam String searchTerm, Model model) {
   //     List<Post> posts = butterCMSClient.getPosts(Collections.emptyMap()).getData();
   //     List<Post> searchResult = posts.stream()
   //             .filter(post -> post.getTitle().contains(searchTerm))
   //             .collect(Collectors.toList());
   //     model.addAttribute("posts", searchResult);
   //     return searchResult.isEmpty() ? "No blog posts found matching this query." : "blogs";
   // }

}
