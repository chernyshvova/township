package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzdam;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevl<RequestComponentT extends zzdam<AdT>, AdT> implements zzevv<RequestComponentT, AdT> {
    @GuardedBy("this")
    @Nullable
    public RequestComponentT zza;

    /* renamed from: zza */
    public final synchronized RequestComponentT zzd() {
        return this.zza;
    }

    public final synchronized zzfqn<AdT> zzb(zzevw zzevw, zzevu<RequestComponentT> zzevu, @Nullable RequestComponentT requestcomponentt) {
        zzcyl zzc;
        if (requestcomponentt != null) {
            this.zza = requestcomponentt;
        } else {
            this.zza = (zzdam) zzevu.zza(zzevw.zzb).zzf();
        }
        zzc = this.zza.zzc();
        return zzc.zzc(zzc.zzb());
    }

    public final /* bridge */ /* synthetic */ zzfqn zzc(zzevw zzevw, zzevu zzevu, @Nullable Object obj) {
        return zzb(zzevw, zzevu, (zzdam) null);
    }
}
