package com.swrve.sdk.localstorage;

public class SwrveCacheItem {
    public String category;
    public String rawData;
    public String userId;

    public SwrveCacheItem(String str, String str2, String str3) {
        this.userId = str;
        this.category = str2;
        this.rawData = str3;
    }
}
