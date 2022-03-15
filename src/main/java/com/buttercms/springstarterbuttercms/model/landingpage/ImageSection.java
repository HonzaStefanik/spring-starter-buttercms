package com.buttercms.springstarterbuttercms.model.landingpage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageSection extends Section {
    private String headline;
    @JsonProperty("subheadline")
    private String subHeadline;
    private String image;
    @JsonProperty("image_position")
    private String imagePosition;
    @JsonProperty("button_label")
    private String buttonLabel;
    @JsonProperty("button_url")
    private String buttonUrl;

    public ImageSection() {
    }

    public ImageSection(String headline, String subHeadline, String image, String imagePosition, String buttonLabel, String buttonUrl) {
        this.headline = headline;
        this.subHeadline = subHeadline;
        this.image = image;
        this.imagePosition = imagePosition;
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

    public String getImagePosition() {
        return imagePosition;
    }

    public void setImagePosition(String imagePosition) {
        this.imagePosition = imagePosition;
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
