package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzdam;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevm<RequestComponentT extends zzdam<AdT>, AdT> implements zzevv<RequestComponentT, AdT> {
    public final zzevv<RequestComponentT, AdT> zza;
    @GuardedBy("this")
    @Nullable
    public RequestComponentT zzb;

    public zzevm(zzevv<RequestComponentT, AdT> zzevv) {
        this.zza = zzevv;
    }

    /* renamed from: zza */
    public final synchronized RequestComponentT zzd() {
        return this.zzb;
    }

    public final synchronized zzfqn<AdT> zzb(zzevw zzevw, zzevu<RequestComponentT> zzevu, @Nullable RequestComponentT requestcomponentt) {
        this.zzb = requestcomponentt;
        if (zzevw.zza != null) {
            zzcyl zzc = requestcomponentt.zzc();
            return zzc.zzc(zzc.zza(zzfqe.zza(zzevw.zza)));
        }
        return ((zzevl) this.zza).zzb(zzevw, zzevu, requestcomponentt);
    }

    public final /* bridge */ /* synthetic */ zzfqn zzc(zzevw zzevw, zzevu zzevu, @Nullable Object obj) {
        return zzb(zzevw, zzevu, (zzdam) null);
    }
}
