package com.vungle.warren;

public final class VungleSettings {
    public static final long MEGABYTE = 1048576;
    public final boolean androidIdOptedOut;
    public final boolean disableRefresh;
    public final long maximumStorageForCleverCache;
    public final long minimumSpaceForAd;
    public final long minimumSpaceForInit;

    public static class Builder {
        public boolean androidIdOptedOut;
        public boolean disableRefresh;
        public long maximumStorageForCleverCache = 104857600;
        public long minimumSpaceForAd = 52428800;
        public long minimumSpaceForInit = 53477376;

        public VungleSettings build() {
            return new VungleSettings(this);
        }

        public Builder disableBannerRefresh() {
            this.disableRefresh = true;
            return this;
        }

        public Builder setAndroidIdOptOut(boolean z) {
            this.androidIdOptedOut = z;
            return this;
        }

        public Builder setMaximumStorageForCleverCache(long j) {
            this.maximumStorageForCleverCache = j;
            return this;
        }

        public Builder setMinimumSpaceForAd(long j) {
            this.minimumSpaceForAd = j;
            return this;
        }

        public Builder setMinimumSpaceForInit(long j) {
            this.minimumSpaceForInit = j;
            return this;
        }
    }

    public boolean getAndroidIdOptOut() {
        return this.androidIdOptedOut;
    }

    public boolean getBannerRefreshDisabled() {
        return this.disableRefresh;
    }

    public long getMaximumStorageForCleverCache() {
        return this.maximumStorageForCleverCache;
    }

    public long getMinimumSpaceForAd() {
        return this.minimumSpaceForAd;
    }

    public long getMinimumSpaceForInit() {
        return this.minimumSpaceForInit;
    }

    public VungleSettings(Builder builder) {
        this.minimumSpaceForAd = builder.minimumSpaceForAd;
        this.minimumSpaceForInit = builder.minimumSpaceForInit;
        this.androidIdOptedOut = builder.androidIdOptedOut;
        this.disableRefresh = builder.disableRefresh;
        this.maximumStorageForCleverCache = builder.maximumStorageForCleverCache;
    }
}
