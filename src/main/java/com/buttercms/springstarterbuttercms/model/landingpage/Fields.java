package com.buttercms.springstarterbuttercms.model.landingpage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Fields {
    private Seo seo;
    @JsonProperty("body")
    private List<Field> fields;

    public Seo getSeo() {
        return seo;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
