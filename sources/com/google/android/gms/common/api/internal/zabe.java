package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabe implements Runnable {
    public final /* synthetic */ int zaa;
    public final /* synthetic */ GoogleApiManager.zaa zab;

    public zabe(GoogleApiManager.zaa zaa2, int i) {
        this.zab = zaa2;
        this.zaa = i;
    }

    public final void run() {
        this.zab.zaa(this.zaa);
    }
}
