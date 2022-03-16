package com.buttercms.springstarterbuttercms.controller.dto;

import com.buttercms.model.Category;
import com.buttercms.model.Post;
import com.buttercms.model.Tag;

import java.util.List;

public class BlogsDto {
    private String seoTitle;
    private String seoDescription;
    private String breadcrumbText;
    private String subCollection;
    private Category category;
    private Tag tag;
    private List<Post> posts;
    private List<Category> categories;
    private List<Tag> tags;

    public BlogsDto() {
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getBreadcrumbText() {
        return breadcrumbText;
    }

    public void setBreadcrumbText(String breadcrumbText) {
        this.breadcrumbText = breadcrumbText;
    }

    public String getSubCollection() {
        return subCollection;
    }

    public void setSubCollection(String subCollection) {
        this.subCollection = subCollection;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
