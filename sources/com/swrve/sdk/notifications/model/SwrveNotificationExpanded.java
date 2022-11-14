package com.swrve.sdk.notifications.model;

public class SwrveNotificationExpanded {
    public String body;
    public String iconUrl;
    public String title;

    public String getBody() {
        return this.body;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
