package com.vungle.warren.downloader;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.downloader.DownloadRequest;

public class AssetPriority implements Comparable {
    public final Integer firstPriority;
    public final Integer secondPriority;

    public AssetPriority(int i, @DownloadRequest.Priority int i2) {
        this.firstPriority = Integer.valueOf(i);
        this.secondPriority = Integer.valueOf(i2);
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof AssetPriority)) {
            return -1;
        }
        AssetPriority assetPriority = (AssetPriority) obj;
        int compareTo = this.firstPriority.compareTo(assetPriority.firstPriority);
        return compareTo == 0 ? this.secondPriority.compareTo(assetPriority.secondPriority) : compareTo;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AssetPriority{firstPriority=");
        outline24.append(this.firstPriority);
        outline24.append(", secondPriority=");
        outline24.append(this.secondPriority);
        outline24.append('}');
        return outline24.toString();
    }
}
