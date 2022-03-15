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
        return new BlogsDto(
                BLOG_SEO_TITLE,
                BLOG_SEO_DESCRIPTION,
                ALL_BLOGS,
                null,
                null,
                null,
                posts,
                categories,
                null
        );
    }

    public BlogsDto getBlogsBySlug(String slug) {
        Post post = butterCMSClient.getPost(slug).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        return new BlogsDto(
                post.getSeoTitle(),
                post.getMetaDescription(),
                post.getTitle(),
                post.getTitle(),
                null,
                null,
                Collections.singletonList(post),
                categories,
                null
        );
    }

    public BlogsDto getBlogsByCategory(String categorySlug) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("category_slug", categorySlug);
        }};
        List<Post> posts = butterCMSClient.getPosts(queryParams).getData();
        Category category = butterCMSClient.getCategory(categorySlug, Collections.emptyMap()).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        String categoryName = category.getName();
        return new BlogsDto(
                BLOG_CATEGORY_SEO_TITLE + categoryName,
                BLOG_CATEGORY_SEO_DESCRIPTION + categoryName,
                BLOGS_BY_CATEGORY,
                "Category: " + categoryName,
                category,
                null,
                posts,
                categories,
                null
        );
    }

    public BlogsDto getBlogsByTag(String tagSlug) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("tag_slug", tagSlug);
        }};
        List<Post> posts = butterCMSClient.getPosts(queryParams).getData();
        Tag tag = butterCMSClient.getTag(tagSlug, Collections.emptyMap()).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        String tagName = tag.getName();
        return new BlogsDto(
                BLOG_TAG_SEO_TITLE + tagName,
                BLOG_TAG_SEO_DESCRIPTION + tagName,
                BLOGS_BY_TAG,
                "Tag: " + tagName,
                null,
                tag,
                posts,
                categories,
                null
        );
    }

    public BlogsDto searchBlogs(String searchTerm) {
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("query", searchTerm);
        }};
        List<Post> posts = butterCMSClient.getPosts(queryParams).getData();
        List<Category> categories = butterCMSClient.getCategories(Collections.emptyMap()).getData();
        return new BlogsDto(
                BLOG_SEARCH_SEO_TITLE + searchTerm,
                BLOG_SEARCH_SEO_DESCRIPTION + searchTerm,
                SEARCH_RESULTS,
                "Search: " + searchTerm,
                null,
                null,
                posts,
                categories,
                null
        );
    }
}
