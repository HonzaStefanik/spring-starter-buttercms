package com.buttercms.springstarterbuttercms.service;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.Category;
import com.buttercms.model.Post;
import com.buttercms.model.Tag;
import com.buttercms.springstarterbuttercms.controller.dto.BlogsDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.buttercms.springstarterbuttercms.controller.dto.ConstDtoValues.*;

@Service
public class BlogService {
    private final IButterCMSClient butterCMSClient;

    public BlogService(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    public BlogsDto getBlogs() {
        List<Post> posts = butterCMSClient.getPosts(Collections.emptyMap()).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        BlogsDto dto = new BlogsDto();
        dto.setSeoTitle(BLOG_SEO_TITLE);
        dto.setSeoDescription(BLOG_SEO_DESCRIPTION);
        dto.setBreadcrumbText(ALL_BLOGS);
        dto.setPosts(posts);
        dto.setCategories(categories);
        return dto;
    }

    public BlogsDto getBlogsBySlug(String slug) {
        Post post = butterCMSClient.getPost(slug).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        BlogsDto dto = new BlogsDto();
        dto.setSeoTitle(post.getSeoTitle());
        dto.setSeoDescription(post.getMetaDescription());
        dto.setBreadcrumbText(post.getTitle());
        dto.setSubCollection(post.getTitle());
        dto.setCategories(categories);
        dto.setPosts(Collections.singletonList(post));
        dto.setFeaturedImageUrl(post.getFeaturedImage());
        return dto;
    }

    public BlogsDto getBlogsByCategory(String categorySlug) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("category_slug", categorySlug);
        }};
        List<Post> posts = butterCMSClient.getPosts(queryParams).getData();
        Category category = butterCMSClient.getCategory(categorySlug, Collections.emptyMap()).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        String categoryName = category.getName();
        BlogsDto dto = new BlogsDto();
        dto.setSeoTitle(BLOG_CATEGORY_SEO_TITLE + categoryName);
        dto.setSeoDescription(BLOG_CATEGORY_SEO_DESCRIPTION + categoryName);
        dto.setBreadcrumbText(BLOGS_BY_CATEGORY);
        dto.setSubCollection("Category: " + categoryName);
        dto.setPosts(posts);
        dto.setCategories(categories);
        return dto;
    }

    public BlogsDto getBlogsByTag(String tagSlug) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("tag_slug", tagSlug);
        }};
        List<Post> posts = butterCMSClient.getPosts(queryParams).getData();
        Tag tag = butterCMSClient.getTag(tagSlug, Collections.emptyMap()).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        String tagName = tag.getName();
        BlogsDto dto = new BlogsDto();
        dto.setSeoTitle(BLOG_TAG_SEO_TITLE + tagName);
        dto.setSeoDescription(BLOG_TAG_SEO_DESCRIPTION + tagName);
        dto.setBreadcrumbText(BLOGS_BY_TAG);
        dto.setSubCollection("Tag: " + tagName);
        dto.setPosts(posts);
        dto.setCategories(categories);
        return dto;

    }

    public BlogsDto searchBlogs(String searchTerm) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("query", searchTerm);
        }};
        List<Post> posts = butterCMSClient.getSearchPosts(queryParams).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        BlogsDto dto = new BlogsDto();
        dto.setSeoTitle(BLOG_SEARCH_SEO_TITLE + searchTerm);
        dto.setSeoDescription(BLOG_SEARCH_SEO_DESCRIPTION + searchTerm);
        dto.setBreadcrumbText(SEARCH_RESULTS);
        dto.setSubCollection("Search: " + searchTerm);
        dto.setPosts(posts);
        dto.setCategories(categories);
        return dto;
    }
}
