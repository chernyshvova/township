package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdlj implements zzgjg<zzavv> {
    public final zzgju<zzcgy> zza;
    public final zzgju<String> zzb;

    public zzdlj(zzgju<zzcgy> zzgju, zzgju<String> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcgy zza2 = ((zzcpd) this.zza).zza();
        zzs.zzc();
        return new zzavv(UUID.randomUUID().toString(), zza2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, new JSONObject(), false, true);
    }
}
