package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcpl implements zzgjg<zzcbv> {
    public final zzgju<Context> zza;

    public zzcpl(zzgju<Context> zzgju) {
        this.zza = zzgju;
    }

    /* renamed from: zza */
    public final zzcbv zzb() {
        Context zza2 = ((zzcou) this.zza).zza();
        zzbuh zza3 = zzs.zzp().zza(zza2, zzcgy.zza());
        zzbub<JSONObject> zzbub = zzbue.zza;
        zza3.zza("google.afma.request.getAdDictionary", zzbub, zzbub);
        zzbuh zza4 = zzs.zzp().zza(zza2, zzcgy.zza());
        zzbub<JSONObject> zzbub2 = zzbue.zza;
        return new zzcbu(zza2, zza4.zza("google.afma.sdkConstants.getSdkConstants", zzbub2, zzbub2));
    }
}
