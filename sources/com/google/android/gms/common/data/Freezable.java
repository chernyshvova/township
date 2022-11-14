package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public interface Freezable<T> {
    @RecentlyNonNull
    T freeze();

    boolean isDataValid();
}
