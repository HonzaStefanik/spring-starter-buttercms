package com.buttercms.springstarterbuttercms.model.landingpage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Field {
    private String type;
    @JsonProperty("fields")
    private Section section;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
