package com.swrve.sdk;

import android.graphics.Bitmap;

public class SwrveNotificationDetails {
    public String body;
    public String expandedBody;
    public String expandedTitle;
    public Bitmap mediaBitmap;
    public String mediaUrl;
    public String title;

    public String getBody() {
        return this.body;
    }

    public String getExpandedBody() {
        return this.expandedBody;
    }

    public String getExpandedTitle() {
        return this.expandedTitle;
    }

    public Bitmap getMediaBitmap() {
        return this.mediaBitmap;
    }

    public String getMediaUrl() {
        return this.mediaUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setExpandedBody(String str) {
        this.expandedBody = str;
    }

    public void setExpandedTitle(String str) {
        this.expandedTitle = str;
    }

    public void setMediaBitmap(Bitmap bitmap) {
        this.mediaBitmap = bitmap;
    }

    public void setMediaUrl(String str) {
        this.mediaUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
