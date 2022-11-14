package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzdyw;
import com.google.android.gms.internal.ads.zzdyx;
import com.google.android.gms.internal.ads.zzfqo;
import com.google.android.gms.internal.ads.zzgjg;
import com.google.android.gms.internal.ads.zzgjp;
import com.google.android.gms.internal.ads.zzgju;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzae implements zzgjg<zzad> {
    public final zzgju<Executor> zza;
    public final zzgju<zzdyw> zzb;

    public zzae(zzgju<Executor> zzgju, zzgju<zzdyw> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    /* renamed from: zza */
    public final zzad zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzad(zzfqo, ((zzdyx) this.zzb).zzb());
    }
}
