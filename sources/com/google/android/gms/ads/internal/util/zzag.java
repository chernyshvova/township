package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzfqo;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzag implements Runnable {
    public final zzau zza;
    public final zzfqo zzb;

    public zzag(zzau zzau, zzfqo zzfqo) {
        this.zza = zzau;
        this.zzb = zzfqo;
    }

    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
