package com.buttercms.springstarterbuttercms.controller.dto;

import com.buttercms.model.Category;
import com.buttercms.model.Post;
import com.buttercms.model.Tag;

import java.util.List;

public class BlogsDto {
    private final String seoTitle;
    private final String seoDescription;
    private final String breadcrumbText;
    private final String subCollection;
    private final Category category;
    private final Tag tag;
    private final List<Post> posts;
    private final List<Category> categories;
    private final List<Tag> tags;

    public BlogsDto(String seoTitle,
                    String seoDescription,
                    String breadcrumbText,
                    String subCollection,
                    Category category,
                    Tag tag,
                    List<Post> posts,
                    List<Category> categories,
                    List<Tag> tags) {
        this.seoTitle = seoTitle;
        this.seoDescription = seoDescription;
        this.breadcrumbText = breadcrumbText;
        this.subCollection = subCollection;
        this.category = category;
        this.tag = tag;
        this.posts = posts;
        this.categories = categories;
        this.tags = tags;
    }


    public String getSeoTitle() {
        return seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public String getBreadcrumbText() {
        return breadcrumbText;
    }

    public String getSubCollection() {
        return subCollection;
    }

    public Category getCategory() {
        return category;
    }

    public Tag getTag() {
        return tag;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
