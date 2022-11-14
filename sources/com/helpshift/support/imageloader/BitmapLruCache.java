package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.core.graphics.BitmapCompat;
import com.helpshift.util.HSLogger;

public class BitmapLruCache {
    public static final int CACHE_SIZE = 8388608;
    public static final float MEMORY_FRACTION = 0.15f;
    public static final String TAG = "Helpshift_BtmpLruCache";
    public final LruCache<String, Bitmap> cache;

    public BitmapLruCache() {
        int round = Math.round(((float) Runtime.getRuntime().maxMemory()) * 0.15f);
        this.cache = new LruCache<String, Bitmap>(round >= 8388608 ? 8388608 : round) {
            public int sizeOf(@NonNull String str, @NonNull Bitmap bitmap) {
                return BitmapCompat.getAllocationByteCount(bitmap);
            }
        };
    }

    private int maxSize() {
        return this.cache.maxSize();
    }

    public void clear() {
        this.cache.evictAll();
    }

    @Nullable
    public Bitmap get(String str) {
        if (str == null) {
            return null;
        }
        HSLogger.m3237d(TAG, "Bitmap loaded from cache with key: " + str);
        return this.cache.get(str);
    }

    public void set(@NonNull String str, @NonNull Bitmap bitmap) {
        if (BitmapCompat.getAllocationByteCount(bitmap) > maxSize()) {
            this.cache.remove(str);
        } else {
            this.cache.put(str, bitmap);
        }
    }
}
