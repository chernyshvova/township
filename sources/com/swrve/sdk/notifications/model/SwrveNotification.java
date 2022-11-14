package com.swrve.sdk.notifications.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.swrve.sdk.SwrveLogger;
import java.util.List;

public class SwrveNotification {
    public String accent;
    public List<SwrveNotificationButton> buttons;
    public SwrveNotificationCampaign campaign;
    public SwrveNotificationChannel channel;
    public String channelId;
    public SwrveNotificationExpanded expanded;
    public String iconUrl;
    public String lockScreenMsg;
    public SwrveNotificationMedia media;
    public int notificationId;
    public int priority;
    public String subtitle;
    public String ticker;
    public String title;
    public int version;
    public VisibilityType visibility;

    public enum VisibilityType {
        PUBLIC,
        PRIVATE,
        SECRET
    }

    public static SwrveNotification fromJson(String str) {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            return (SwrveNotification) gsonBuilder.create().fromJson(str, SwrveNotification.class);
        } catch (JsonParseException e) {
            SwrveLogger.m2753e("Could not parse Rich Push json: %s", e, str);
            return null;
        }
    }

    public String getAccent() {
        return this.accent;
    }

    public List<SwrveNotificationButton> getButtons() {
        return this.buttons;
    }

    public SwrveNotificationCampaign getCampaign() {
        return this.campaign;
    }

    public SwrveNotificationChannel getChannel() {
        return this.channel;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public SwrveNotificationExpanded getExpanded() {
        return this.expanded;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getLockScreenMsg() {
        return this.lockScreenMsg;
    }

    public SwrveNotificationMedia getMedia() {
        return this.media;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTicker() {
        return this.ticker;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVersion() {
        return this.version;
    }

    public VisibilityType getVisibility() {
        return this.visibility;
    }

    public void setAccent(String str) {
        this.accent = str;
    }

    public void setButtons(List<SwrveNotificationButton> list) {
        this.buttons = list;
    }

    public void setCampaign(SwrveNotificationCampaign swrveNotificationCampaign) {
        this.campaign = swrveNotificationCampaign;
    }

    public void setChannel(SwrveNotificationChannel swrveNotificationChannel) {
        this.channel = swrveNotificationChannel;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setExpanded(SwrveNotificationExpanded swrveNotificationExpanded) {
        this.expanded = swrveNotificationExpanded;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setLockScreenMsg(String str) {
        this.lockScreenMsg = str;
    }

    public void setMedia(SwrveNotificationMedia swrveNotificationMedia) {
        this.media = swrveNotificationMedia;
    }

    public void setNotificationId(int i) {
        this.notificationId = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTicker(String str) {
        this.ticker = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setVisibility(VisibilityType visibilityType) {
        this.visibility = visibilityType;
    }
}
