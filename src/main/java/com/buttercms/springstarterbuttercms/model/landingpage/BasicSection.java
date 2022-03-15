package com.buttercms.springstarterbuttercms.model.landingpage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasicSection extends Section {
    private String headline;
    @JsonProperty("subheadline")
    private String subHeadline;
    private String image;
    @JsonProperty("button_label")
    private String buttonLabel;
    @JsonProperty("button_url")
    private String buttonUrl;

    public BasicSection() {
    }

    public BasicSection(String headline, String subHeadline, String image, String buttonLabel, String buttonUrl) {
        this.headline = headline;
        this.subHeadline = subHeadline;
        this.image = image;
        this.buttonLabel = buttonLabel;
        this.buttonUrl = buttonUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSubHeadline() {
        return subHeadline;
    }

    public void setSubHeadline(String subHeadline) {
        this.subHeadline = subHeadline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public void setButtonLabel(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
    }
}
