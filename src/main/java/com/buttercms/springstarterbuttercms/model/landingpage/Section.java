package com.buttercms.springstarterbuttercms.model.landingpage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "scroll_anchor_id",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicSection.class, name = "home"),
        @JsonSubTypes.Type(value = ImageSection.class, name = "about"),
        @JsonSubTypes.Type(value = ImageSection.class, name = "tryit"),
        @JsonSubTypes.Type(value = FeaturesSection.class, name = "features"),
        @JsonSubTypes.Type(value = TestimonialsSection.class, name = "testimonials")
})
public abstract class Section {
    @JsonProperty("scroll_anchor_id")
    private String scrollAnchorId;

    public Section() {
    }

    public Section(String scrollAnchorId) {
        this.scrollAnchorId = scrollAnchorId;
    }

    public String getScrollAnchorId() {
        return scrollAnchorId;
    }

    public void setScrollAnchorId(String scrollAnchorId) {
        this.scrollAnchorId = scrollAnchorId;
    }
}