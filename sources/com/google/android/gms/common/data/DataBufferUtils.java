package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class DataBufferUtils {
    @RecentlyNonNull
    @KeepForSdk
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
    @RecentlyNonNull
    @KeepForSdk
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";

    @RecentlyNonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(@RecentlyNonNull DataBuffer<E> dataBuffer) {
        ArrayList<T> arrayList = new ArrayList<>(dataBuffer.getCount());
        try {
            for (E freeze : dataBuffer) {
                arrayList.add(freeze.freeze());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(@RecentlyNonNull DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(@RecentlyNonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        return (metadata == null || metadata.getString(KEY_NEXT_PAGE_TOKEN) == null) ? false : true;
    }

    public static boolean hasPrevPage(@RecentlyNonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        return (metadata == null || metadata.getString(KEY_PREV_PAGE_TOKEN) == null) ? false : true;
    }
}
