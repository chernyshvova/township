package com.swrve.sdk;

import android.app.NotificationChannel;

public class SwrveNotificationConfig {
    public String accentColorHex;
    public Class<?> activityClass;
    public NotificationChannel defaultNotificationChannel;
    public int iconDrawableId;
    public int iconMaterialDrawableId;
    public int largeIconDrawableId;
    public SwrveNotificationFilter notificationFilter;

    public static class Builder {
        public String accentColorHex;
        public Class<?> activityClass;
        public NotificationChannel defaultNotificationChannel;
        public int iconDrawableId;
        public int iconMaterialDrawableId;
        public int largeIconDrawableId;
        public SwrveNotificationFilter notificationFilter;

        public Builder(int i, int i2, NotificationChannel notificationChannel) {
            this.iconDrawableId = i;
            this.iconMaterialDrawableId = i2;
            this.defaultNotificationChannel = notificationChannel;
        }

        public Builder accentColorHex(String str) {
            this.accentColorHex = str;
            return this;
        }

        public Builder activityClass(Class<?> cls) {
            this.activityClass = cls;
            return this;
        }

        public SwrveNotificationConfig build() {
            return new SwrveNotificationConfig(this);
        }

        public Builder largeIconDrawableId(int i) {
            this.largeIconDrawableId = i;
            return this;
        }

        public Builder notificationFilter(SwrveNotificationFilter swrveNotificationFilter) {
            this.notificationFilter = swrveNotificationFilter;
            return this;
        }
    }

    public String getAccentColorHex() {
        return this.accentColorHex;
    }

    public Class<?> getActivityClass() {
        return this.activityClass;
    }

    public NotificationChannel getDefaultNotificationChannel() {
        return this.defaultNotificationChannel;
    }

    public int getIconDrawableId() {
        return this.iconDrawableId;
    }

    public int getIconMaterialDrawableId() {
        return this.iconMaterialDrawableId;
    }

    public int getLargeIconDrawableId() {
        return this.largeIconDrawableId;
    }

    public SwrveNotificationFilter getNotificationFilter() {
        return this.notificationFilter;
    }

    public SwrveNotificationConfig(Builder builder) {
        this.activityClass = builder.activityClass;
        this.iconDrawableId = builder.iconDrawableId;
        this.iconMaterialDrawableId = builder.iconMaterialDrawableId;
        this.defaultNotificationChannel = builder.defaultNotificationChannel;
        this.largeIconDrawableId = builder.largeIconDrawableId;
        this.accentColorHex = builder.accentColorHex;
        this.notificationFilter = builder.notificationFilter;
    }
}
