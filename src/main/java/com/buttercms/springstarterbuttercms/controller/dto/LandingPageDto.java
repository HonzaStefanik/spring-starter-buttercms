package com.buttercms.springstarterbuttercms.controller.dto;

import com.buttercms.model.Post;
import com.buttercms.springstarterbuttercms.model.landingpage.Field;
import com.buttercms.springstarterbuttercms.model.landingpage.Fields;
import com.buttercms.springstarterbuttercms.model.landingpage.Section;

import java.util.List;
import java.util.stream.Collectors;

public class LandingPageDto {
    private final Fields fields;
    private final List<Post> posts;

    public LandingPageDto(Fields fields, List<Post> posts) {
        this.fields = fields;
        this.posts = posts;
    }

    public Fields getFields() {
        return fields;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Section> extractSections(Fields fields) {
        return fields.getFields()
                .stream()
                .map(Field::getSection)
                .collect(Collectors.toList());
    }
}
