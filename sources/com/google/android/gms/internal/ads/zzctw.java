package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzctw implements zzgjg<zzavv> {
    public final zzgju<zzeye> zza;
    public final zzgju<zzcgy> zzb;
    public final zzgju<JSONObject> zzc;
    public final zzgju<String> zzd;

    public zzctw(zzgju<zzeye> zzgju, zzgju<zzcgy> zzgju2, zzgju<JSONObject> zzgju3, zzgju<String> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        ((zzcxy) this.zza).zza();
        String zzb2 = this.zzd.zzb();
        boolean equals = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(zzb2);
        zzs.zzc();
        return new zzavv(UUID.randomUUID().toString(), ((zzcpd) this.zzb).zza(), zzb2, this.zzc.zzb(), false, equals);
    }
}
