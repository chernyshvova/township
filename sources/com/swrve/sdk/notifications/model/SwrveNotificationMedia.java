package com.swrve.sdk.notifications.model;

public class SwrveNotificationMedia {
    public String body;
    public String fallbackSd;
    public MediaType fallbackType;
    public String fallbackUrl;
    public String subtitle;
    public String title;
    public MediaType type;
    public String url;

    public enum MediaType {
        IMAGE
    }

    public String getBody() {
        return this.body;
    }

    public String getFallbackSd() {
        return this.fallbackSd;
    }

    public MediaType getFallbackType() {
        return this.fallbackType;
    }

    public String getFallbackUrl() {
        return this.fallbackUrl;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public MediaType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setFallbackSd(String str) {
        this.fallbackSd = str;
    }

    public void setFallbackType(MediaType mediaType) {
        this.fallbackType = mediaType;
    }

    public void setFallbackUrl(String str) {
        this.fallbackUrl = str;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(MediaType mediaType) {
        this.type = mediaType;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
