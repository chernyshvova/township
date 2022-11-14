package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbut<I, O> implements zzfpl<I, O> {
    public final zzbtz<O> zza;
    public final zzbua<I> zzb;
    public final String zzc = "google.afma.activeView.handleUpdate";
    public final zzfqn<zzbtu> zzd;

    public zzbut(zzfqn<zzbtu> zzfqn, String str, zzbua<I> zzbua, zzbtz<O> zzbtz) {
        this.zzd = zzfqn;
        this.zzb = zzbua;
        this.zza = zzbtz;
    }

    public final zzfqn<O> zza(I i) throws Exception {
        return zzb(i);
    }

    public final zzfqn<O> zzb(I i) {
        return zzfqe.zzi(this.zzd, new zzbur(this, i), zzche.zzf);
    }

    public final /* synthetic */ zzfqn zzc(Object obj, zzbtu zzbtu) throws Exception {
        zzchj zzchj = new zzchj();
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        zzbpr.zzp.zzb(uuid, new zzbus(this, zzchj));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbtu.zzr(this.zzc, jSONObject);
        return zzchj;
    }
}
