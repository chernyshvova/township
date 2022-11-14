package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbul<I, O> implements zzbtx<I, O> {
    public final zzbtz<O> zza;
    public final zzbua<I> zzb;
    public final zzbtt zzc;
    public final String zzd;

    public zzbul(zzbtt zzbtt, String str, zzbua<I> zzbua, zzbtz<O> zzbtz) {
        this.zzc = zzbtt;
        this.zzd = str;
        this.zzb = zzbua;
        this.zza = zzbtz;
    }

    public static /* synthetic */ void zzc(zzbul zzbul, zzbtn zzbtn, zzbtu zzbtu, Object obj, zzchj zzchj) {
        try {
            zzs.zzc();
            String uuid = UUID.randomUUID().toString();
            zzbpr.zzp.zzb(uuid, new zzbuk(zzbul, zzbtn, zzchj));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbul.zzb.zzb(obj));
            zzbtu.zzr(zzbul.zzd, jSONObject);
        } catch (Exception e) {
            zzchj.zzd(e);
            zzcgs.zzg("Unable to invokeJavascript", e);
            zzbtn.zza();
        } catch (Throwable th) {
            zzbtn.zza();
            throw th;
        }
    }

    public final zzfqn<O> zza(@Nullable I i) throws Exception {
        return zzb(i);
    }

    public final zzfqn<O> zzb(I i) {
        zzchj zzchj = new zzchj();
        zzbtn zzb2 = this.zzc.zzb((zzfb) null);
        zzb2.zze(new zzbui(this, zzb2, i, zzchj), new zzbuj(this, zzchj, zzb2));
        return zzchj;
    }
}
