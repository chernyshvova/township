package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzezw implements zzdbg {
    @GuardedBy("this")
    public final HashSet<zzcfy> zza = new HashSet<>();
    public final Context zzb;
    public final zzcgh zzc;

    public zzezw(Context context, zzcgh zzcgh) {
        this.zzb = context;
        this.zzc = zzcgh;
    }

    public final synchronized void zzb(HashSet<zzcfy> hashSet) {
        this.zza.clear();
        this.zza.addAll(hashSet);
    }

    public final synchronized void zzbT(zzbdd zzbdd) {
        if (zzbdd.zza != 3) {
            this.zzc.zzc(this.zza);
        }
    }

    public final Bundle zzc() {
        return this.zzc.zzk(this.zzb, this);
    }
}
