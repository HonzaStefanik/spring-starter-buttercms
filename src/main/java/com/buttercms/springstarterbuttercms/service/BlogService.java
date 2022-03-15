package com.buttercms.springstarterbuttercms.service;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.buttercms.springstarterbuttercms.configuration.Constants.*;

@Service
public class BlogService {
    private final IButterCMSClient butterCMSClient;

    public BlogService(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    public void addBlogData(Model model) {
        PostsResponse posts = butterCMSClient.getPosts(Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", BLOG_SEO_TITLE);
        model.addAttribute("seoDescription", BLOG_SEO_DESCRIPTION);
        model.addAttribute("breadcrumbText", ALL_BLOGS);
    }

    public void addBlogDataByBlog(Model model, String slug) {
        Post post = butterCMSClient.getPost(slug).getData();
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("post", post);
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", post.getSeoTitle());
        model.addAttribute("seoDescription", post.getMetaDescription());
        model.addAttribute("breadcrumbText", post.getTitle());
        model.addAttribute("subCollection", post.getTitle());
    }

    public void addBlogDataByCategory(Model model, String categorySlug) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("category_slug", categorySlug);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        CategoryResponse category = butterCMSClient.getCategory(categorySlug, Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        String categoryName = category.getData().getName();
        model.addAttribute("posts", posts.getData());
        model.addAttribute("category", category.getData());
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", BLOG_CATEGORY_SEO_TITLE + categoryName);
        model.addAttribute("seoDescription", BLOG_CATEGORY_SEO_DESCRIPTION + categoryName);
        model.addAttribute("breadcrumbText", BLOGS_BY_CATEGORY);
        model.addAttribute("subCollection", "Category: " + categoryName);
    }

    public void addBlogDataByTags(Model model, String tagSlug) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("tag_slug", tagSlug);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        TagResponse tag = butterCMSClient.getTag(tagSlug, Collections.emptyMap());
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        String tagName = tag.getData().getName();
        model.addAttribute("posts", posts.getData());
        model.addAttribute("tag", tag.getData());
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", BLOG_TAG_SEO_TITLE + tagName);
        model.addAttribute("seoDescription", BLOG_TAG_SEO_DESCRIPTION + tagName);
        model.addAttribute("breadcrumbText", BLOGS_BY_TAG);
        model.addAttribute("subCollection", "Tag: " + tagName);
    }

    public void addBlogDataBySearch(Model model, String searchTerm) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("query", searchTerm);
        }};
        PostsResponse posts = butterCMSClient.getPosts(queryParams);
        CategoriesResponse categories = butterCMSClient.getCategories(Collections.emptyMap());
        model.addAttribute("posts", posts.getData());
        model.addAttribute("categories", categories.getData());
        model.addAttribute("seoTitle", BLOG_SEARCH_SEO_TITLE + searchTerm);
        model.addAttribute("seoDescription", BLOG_SEARCH_SEO_DESCRIPTION + searchTerm);
        model.addAttribute("breadcrumbText", SEARCH_RESULTS);
        model.addAttribute("subCollection", "Search: " + searchTerm);
    }
}
