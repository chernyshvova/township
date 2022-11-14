package com.swrve.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;

public class SwrveAssetsQueueItem {
    public final int campaignId;
    public final String digest;
    public final boolean isExternalSource;
    public final boolean isImage;
    public final String name;

    public SwrveAssetsQueueItem(int i, String str, String str2, boolean z, boolean z2) {
        this.campaignId = i;
        this.name = str;
        this.digest = str2;
        this.isImage = z;
        this.isExternalSource = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SwrveAssetsQueueItem.class != obj.getClass()) {
            return false;
        }
        SwrveAssetsQueueItem swrveAssetsQueueItem = (SwrveAssetsQueueItem) obj;
        if (this.isImage != swrveAssetsQueueItem.isImage) {
            return false;
        }
        String str = this.name;
        if (str == null ? swrveAssetsQueueItem.name != null : !str.equals(swrveAssetsQueueItem.name)) {
            return false;
        }
        String str2 = this.digest;
        String str3 = swrveAssetsQueueItem.digest;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int getCampaignId() {
        return this.campaignId;
    }

    public String getDigest() {
        return this.digest;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.digest;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + (this.isImage ? 1 : 0);
    }

    public boolean isExternalSource() {
        return this.isExternalSource;
    }

    public boolean isImage() {
        return this.isImage;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("SwrveAssetsQueueItem{campaignId='");
        outline24.append(this.campaignId);
        outline24.append('\'');
        outline24.append(", name='");
        GeneratedOutlineSupport.outline33(outline24, this.name, '\'', ", digest='");
        GeneratedOutlineSupport.outline33(outline24, this.digest, '\'', ", isImage=");
        outline24.append(this.isImage);
        outline24.append(", isExternalSource=");
        outline24.append(this.isExternalSource);
        outline24.append('}');
        return outline24.toString();
    }
}
