package com.swrve.sdk.config;

import com.facebook.appevents.codeless.CodelessMatcher;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveInitMode;
import com.swrve.sdk.SwrveNotificationConfig;
import com.swrve.sdk.SwrvePushNotificationListener;
import com.swrve.sdk.SwrveSilentPushListener;
import com.swrve.sdk.config.SwrveInAppMessageConfig;
import com.swrve.sdk.messaging.SwrveOrientation;
import com.vungle.warren.VungleSettings;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class SwrveConfigBase {
    public boolean abTestDetailsEnabled;
    public boolean androidIdLoggingEnabled;
    public String appStore = "google";
    public String appVersion;
    public boolean autoDownloadCampaignsAndResources = true;
    public boolean autoStartLastUser = true;
    public File cacheDir;
    public URL contentUrl = null;
    public String dbName = "swrve.db";
    public URL defaultContentUrl = null;
    public URL defaultEventsUrl = null;
    public URL defaultIdentityUrl = null;
    public SwrveEmbeddedMessageConfig embeddedMessageConfig = null;
    public URL eventsUrl = null;
    public int httpTimeout = 60000;
    public URL identityUrl = null;
    public SwrveInAppMessageConfig inAppMessageConfig = new SwrveInAppMessageConfig.Builder().build();
    public SwrveInitMode initMode = SwrveInitMode.AUTO;
    public String language;
    public boolean loggingEnabled = true;
    public int maxEventsPerFlush = 50;
    public long maxSqliteDbSize = VungleSettings.MEGABYTE;
    public int minSampleSize = 1;
    public List<String> modelBlackList;
    public long newSessionInterval = 30000;
    public SwrveNotificationConfig notificationConfig;
    public SwrvePushNotificationListener notificationListener;
    public SwrveOrientation orientation = SwrveOrientation.Both;
    public SwrveStack selectedStack = SwrveStack.US;
    public boolean sendQueuedEventsOnResume = true;
    public SwrveSilentPushListener silentPushListener;

    public SwrveConfigBase() {
        ArrayList arrayList = new ArrayList();
        this.modelBlackList = arrayList;
        arrayList.add("Calypso AppCrawler");
    }

    private String getStackHostPrefix() {
        return getSelectedStack() == SwrveStack.EU ? "eu-" : "";
    }

    public void generateUrls(int i) throws MalformedURLException {
        String stackHostPrefix = getStackHostPrefix();
        this.defaultEventsUrl = new URL("https://" + i + CodelessMatcher.CURRENT_CLASS_NAME + stackHostPrefix + "api.swrve.com");
        this.defaultContentUrl = new URL("https://" + i + CodelessMatcher.CURRENT_CLASS_NAME + stackHostPrefix + "content.swrve.com");
        this.defaultIdentityUrl = new URL("https://" + i + CodelessMatcher.CURRENT_CLASS_NAME + stackHostPrefix + "identity.swrve.com");
    }

    public String getAppStore() {
        return this.appStore;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public File getCacheDir() {
        return this.cacheDir;
    }

    public URL getContentUrl() {
        URL url = this.contentUrl;
        return url == null ? this.defaultContentUrl : url;
    }

    public String getDbName() {
        return this.dbName;
    }

    public SwrveEmbeddedMessageConfig getEmbeddedMessageConfig() {
        return this.embeddedMessageConfig;
    }

    public URL getEventsUrl() {
        URL url = this.eventsUrl;
        return url == null ? this.defaultEventsUrl : url;
    }

    public int getHttpTimeout() {
        return this.httpTimeout;
    }

    public URL getIdentityUrl() {
        URL url = this.identityUrl;
        return url == null ? this.defaultIdentityUrl : url;
    }

    public SwrveInAppMessageConfig getInAppMessageConfig() {
        return this.inAppMessageConfig;
    }

    public SwrveInitMode getInitMode() {
        return this.initMode;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getMaxEventsPerFlush() {
        return this.maxEventsPerFlush;
    }

    public long getMaxSqliteDbSize() {
        return this.maxSqliteDbSize;
    }

    public int getMinSampleSize() {
        return this.minSampleSize;
    }

    public List<String> getModelBlackList() {
        return this.modelBlackList;
    }

    public long getNewSessionInterval() {
        return this.newSessionInterval;
    }

    public SwrveNotificationConfig getNotificationConfig() {
        return this.notificationConfig;
    }

    public SwrvePushNotificationListener getNotificationListener() {
        return this.notificationListener;
    }

    public SwrveOrientation getOrientation() {
        return this.orientation;
    }

    public SwrveStack getSelectedStack() {
        return this.selectedStack;
    }

    public SwrveSilentPushListener getSilentPushListener() {
        return this.silentPushListener;
    }

    public boolean isABTestDetailsEnabled() {
        return this.abTestDetailsEnabled;
    }

    public boolean isAndroidIdLoggingEnabled() {
        return this.androidIdLoggingEnabled;
    }

    public boolean isAutoDownloadCampaignsAndResources() {
        return this.autoDownloadCampaignsAndResources;
    }

    public boolean isAutoStartLastUser() {
        return this.autoStartLastUser;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public boolean isSendQueuedEventsOnResume() {
        return this.sendQueuedEventsOnResume;
    }

    public void setABTestDetailsEnabled(boolean z) {
        this.abTestDetailsEnabled = z;
    }

    public void setAndroidIdLoggingEnabled(boolean z) {
        this.androidIdLoggingEnabled = z;
    }

    public SwrveConfigBase setAppStore(String str) {
        this.appStore = str;
        return this;
    }

    public SwrveConfigBase setAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public SwrveConfigBase setAutoDownloadCampaignsAndResources(boolean z) {
        this.autoDownloadCampaignsAndResources = z;
        return this;
    }

    public void setAutoStartLastUser(boolean z) {
        this.autoStartLastUser = z;
    }

    public void setCacheDir(File file) {
        this.cacheDir = file;
    }

    public SwrveConfigBase setContentUrl(URL url) {
        this.contentUrl = url;
        return this;
    }

    public SwrveConfigBase setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public void setEmbeddedMessageConfig(SwrveEmbeddedMessageConfig swrveEmbeddedMessageConfig) {
        this.embeddedMessageConfig = swrveEmbeddedMessageConfig;
    }

    public SwrveConfigBase setEventsUrl(URL url) {
        this.eventsUrl = url;
        return this;
    }

    public void setHttpTimeout(int i) {
        this.httpTimeout = i;
    }

    public SwrveConfigBase setIdentityUrl(URL url) {
        this.identityUrl = url;
        return this;
    }

    public void setInAppMessageConfig(SwrveInAppMessageConfig swrveInAppMessageConfig) {
        this.inAppMessageConfig = swrveInAppMessageConfig;
    }

    public void setInitMode(SwrveInitMode swrveInitMode) {
        this.initMode = swrveInitMode;
    }

    public SwrveConfigBase setLanguage(Locale locale) {
        this.language = SwrveHelper.toLanguageTag(locale);
        return this;
    }

    public void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }

    public SwrveConfigBase setMaxEventsPerFlush(int i) {
        this.maxEventsPerFlush = i;
        return this;
    }

    public SwrveConfigBase setMaxSqliteDbSize(long j) {
        this.maxSqliteDbSize = j;
        return this;
    }

    public void setMinSampleSize(int i) {
        this.minSampleSize = i;
    }

    public void setModelBlackList(List<String> list) {
        this.modelBlackList = list;
    }

    public SwrveConfigBase setNewSessionInterval(long j) {
        this.newSessionInterval = j;
        return this;
    }

    public void setNotificationConfig(SwrveNotificationConfig swrveNotificationConfig) {
        this.notificationConfig = swrveNotificationConfig;
    }

    public void setNotificationListener(SwrvePushNotificationListener swrvePushNotificationListener) {
        this.notificationListener = swrvePushNotificationListener;
    }

    public SwrveConfigBase setOrientation(SwrveOrientation swrveOrientation) {
        this.orientation = swrveOrientation;
        return this;
    }

    public void setSelectedStack(SwrveStack swrveStack) {
        this.selectedStack = swrveStack;
    }

    public void setSendQueuedEventsOnResume(boolean z) {
        this.sendQueuedEventsOnResume = z;
    }

    public void setSilentPushListener(SwrveSilentPushListener swrveSilentPushListener) {
        this.silentPushListener = swrveSilentPushListener;
    }
}
