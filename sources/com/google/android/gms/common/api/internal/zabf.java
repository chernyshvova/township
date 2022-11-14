package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabf implements Runnable {
    public final /* synthetic */ GoogleApiManager.zaa zaa;

    public zabf(GoogleApiManager.zaa zaa2) {
        this.zaa = zaa2;
    }

    public final void run() {
        this.zaa.zao();
    }
}
