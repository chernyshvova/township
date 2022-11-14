package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcua implements zzgjg<Set<zzdhz<zzo>>> {
    public final zzgju<zzcts> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<JSONObject> zzc;

    public zzcua(zzgju<zzcts> zzgju, zzgju<Executor> zzgju2, zzgju<JSONObject> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcts zzb2 = this.zza.zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        if (this.zzc.zzb() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdhz(zzb2, zzfqo));
        }
        zzgjp.zzb(set);
        return set;
    }
}
