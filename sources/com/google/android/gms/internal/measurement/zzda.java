package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzda extends ContentObserver {
    public zzda(zzcy zzcy, Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzdh.zza();
    }
}
