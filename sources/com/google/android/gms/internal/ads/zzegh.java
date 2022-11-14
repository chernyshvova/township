package com.google.android.gms.internal.ads;

import com.facebook.GraphRequest;
import com.google.android.gms.common.util.PlatformVersion;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegh implements zzegb<zzdlv> {
    public final zzdkp zza;
    public final zzfqo zzb;
    public final zzdom zzc;
    public final zzezo<zzdqu> zzd;
    public final zzdra zze;

    public zzegh(zzdkp zzdkp, zzfqo zzfqo, zzdom zzdom, zzezo<zzdqu> zzezo, zzdra zzdra) {
        this.zza = zzdkp;
        this.zzb = zzfqo;
        this.zzc = zzdom;
        this.zzd = zzezo;
        this.zze = zzdra;
    }

    private final zzfqn<zzdlv> zzg(zzeyq zzeyq, zzeye zzeye, JSONObject jSONObject) {
        zzfqn<zzdqu> zzb2 = this.zzd.zzb();
        zzfqn<zzdma> zza2 = this.zzc.zza(zzeyq, zzeye, jSONObject);
        return zzfqe.zzn(zzb2, zza2).zza(new zzegg(this, zza2, zzb2, zzeyq, zzeye, jSONObject), this.zzb);
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        zzeyj zzeyj = zzeye.zzs;
        return (zzeyj == null || zzeyj.zzc == null) ? false : true;
    }

    public final zzfqn<List<zzfqn<zzdlv>>> zzb(zzeyq zzeyq, zzeye zzeye) {
        return zzfqe.zzi(zzfqe.zzi(this.zzd.zzb(), new zzegc(this, zzeye), this.zzb), new zzegd(this, zzeyq, zzeye), this.zzb);
    }

    public final /* synthetic */ zzdlv zzc(zzfqn zzfqn, zzfqn zzfqn2, zzeyq zzeyq, zzeye zzeye, JSONObject jSONObject) throws Exception {
        zzdma zzdma = (zzdma) zzfqn.get();
        zzdqu zzdqu = (zzdqu) zzfqn2.get();
        zzdmb zzc2 = this.zza.zzc(new zzcxx(zzeyq, zzeye, (String) null), new zzdmm(zzdma), new zzdlc(jSONObject, zzdqu));
        zzc2.zzi().zzb();
        zzc2.zzj().zza(zzdqu);
        zzc2.zzk().zza(zzdma.zzR());
        zzc2.zzl().zza(this.zze);
        return zzc2.zzh();
    }

    public final /* synthetic */ zzfqn zzd(zzdqu zzdqu, JSONObject jSONObject) throws Exception {
        this.zzd.zzc(zzfqe.zza(zzdqu));
        if (jSONObject.optBoolean("success")) {
            return zzfqe.zza(jSONObject.getJSONObject(GraphRequest.FORMAT_JSON).getJSONArray("ads"));
        }
        throw new zzbtw("process json failed");
    }

    public final /* synthetic */ zzfqn zze(zzeyq zzeyq, zzeye zzeye, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzfqe.zzc(new zzdxy(3));
        }
        if (zzeyq.zza.zza.zzk <= 1) {
            return zzfqe.zzj(zzg(zzeyq, zzeye, jSONArray.getJSONObject(0)), zzegf.zza, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zza(Math.min(length, zzeyq.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzeyq.zza.zza.zzk);
        for (int i = 0; i < zzeyq.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzeyq, zzeye, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzfqe.zzc(new zzdxy(3)));
            }
        }
        return zzfqe.zza(arrayList);
    }

    public final /* synthetic */ zzfqn zzf(zzeye zzeye, zzdqu zzdqu) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfR)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(AnalyticsEventKey.RESPONSE, zzeye.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzfqe.zzi(zzdqu.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzege(this, zzdqu), this.zzb);
    }
}
