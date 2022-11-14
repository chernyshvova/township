package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzerk implements zzeqp<zzerl> {
    public final Executor zza;
    public final String zzb;
    @Nullable
    public final PackageInfo zzc;
    public final zzcfw zzd;

    public zzerk(zzcfw zzcfw, Executor executor, String str, @Nullable PackageInfo packageInfo, int i, byte[] bArr) {
        this.zzd = zzcfw;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final zzfqn<zzerl> zza() {
        return zzfqe.zzg(zzfqe.zzj(zzfqe.zza(this.zzb), zzeri.zza, this.zza), Throwable.class, new zzerj(this), this.zza);
    }

    public final /* synthetic */ zzfqn zzb(Throwable th) throws Exception {
        return zzfqe.zza(new zzerl(this.zzb));
    }
}
