package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzcv extends ContentObserver {
    public final /* synthetic */ zzct zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcv(zzct zzct, Handler handler) {
        super((Handler) null);
        this.zza = zzct;
    }

    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
