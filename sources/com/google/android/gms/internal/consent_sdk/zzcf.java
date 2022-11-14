package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzcf implements ThreadFactory {
    public final zzcg zza;
    public final String zzb;

    public zzcf(zzcg zzcg, String str) {
        this.zza = zzcg;
        this.zzb = str;
    }

    public final Thread newThread(Runnable runnable) {
        return this.zza.zza(this.zzb, runnable);
    }
}
