package com.vungle.warren.downloader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.downloader.Downloader;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class DownloadRequest {
    public AtomicBoolean cancelled;
    public final String cookieString;

    /* renamed from: id */
    public final String f2848id;
    public final int networkType;
    public final String path;
    public final boolean pauseOnConnectionLost;
    public AtomicReference<AssetPriority> priority;
    public final String url;

    public @interface Priority {
        public static final int CRITICAL = -2147483647;
        public static final int HIGH = 1;
        public static final int HIGHEST = 0;
        public static final int LOWEST = Integer.MAX_VALUE;
    }

    public DownloadRequest(@NonNull String str, String str2) {
        this(3, 0, str, str2, false, (String) null);
    }

    public void cancel() {
        this.cancelled.set(true);
    }

    public AssetPriority getPriority() {
        return this.priority.get();
    }

    public boolean isCancelled() {
        return this.cancelled.get();
    }

    public void setPriority(AssetPriority assetPriority) {
        this.priority.set(assetPriority);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("DownloadRequest{networkType=");
        outline24.append(this.networkType);
        outline24.append(", priority=");
        outline24.append(this.priority);
        outline24.append(", url='");
        GeneratedOutlineSupport.outline33(outline24, this.url, '\'', ", path='");
        GeneratedOutlineSupport.outline33(outline24, this.path, '\'', ", pauseOnConnectionLost=");
        outline24.append(this.pauseOnConnectionLost);
        outline24.append(", id='");
        GeneratedOutlineSupport.outline33(outline24, this.f2848id, '\'', ", cookieString='");
        GeneratedOutlineSupport.outline33(outline24, this.cookieString, '\'', ", cancelled=");
        outline24.append(this.cancelled);
        outline24.append('}');
        return outline24.toString();
    }

    public DownloadRequest(@NonNull String str, String str2, String str3) {
        this(3, 0, str, str2, false, str3);
    }

    public DownloadRequest(@Downloader.NetworkType int i, @Priority int i2, @NonNull String str, @NonNull String str2, boolean z, String str3) {
        this(i, new AssetPriority(i2, 0), str, str2, z, str3);
    }

    public DownloadRequest(@Downloader.NetworkType int i, AssetPriority assetPriority, @NonNull String str, @NonNull String str2, boolean z, String str3) {
        this.priority = new AtomicReference<>();
        this.cancelled = new AtomicBoolean(false);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Url or path is empty");
        }
        this.networkType = i;
        this.priority.set(assetPriority);
        this.url = str;
        this.path = str2;
        this.f2848id = UUID.nameUUIDFromBytes((str2 + "_" + str).getBytes()).toString();
        this.pauseOnConnectionLost = z;
        this.cookieString = str3;
    }
}
