package com.buttercms.springstarterbuttercms.model.landingpage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TestimonialsSection extends Section {
    private String headline;
    @JsonProperty("testimonial")
    private List<Testimonial> testimonials;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public List<Testimonial> getTestimonials() {
        return testimonials;
    }

    public void setTestimonials(List<Testimonial> testimonials) {
        this.testimonials = testimonials;
    }

    public static class Testimonial {
        private String quote;
        private String name;
        private String title;

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
