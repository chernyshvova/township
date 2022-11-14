package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjg {
    public final Collection<zzbjf<?>> zza = new ArrayList();
    public final Collection<zzbjf<String>> zzb = new ArrayList();
    public final Collection<zzbjf<String>> zzc = new ArrayList();

    public final void zza(zzbjf zzbjf) {
        this.zza.add(zzbjf);
    }

    public final void zzb(zzbjf<String> zzbjf) {
        this.zzb.add(zzbjf);
    }

    public final void zzc(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbjf next : this.zza) {
            if (next.zzm() == 1) {
                next.zzb(editor, next.zzc(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzcgs.zzf("Flag Json is null.");
        }
    }

    public final List<String> zzd() {
        ArrayList arrayList = new ArrayList();
        for (zzbjf<String> zzb2 : this.zzb) {
            String str = (String) zzbex.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbjo.zza());
        return arrayList;
    }

    public final List<String> zze() {
        List<String> zzd = zzd();
        for (zzbjf<String> zzb2 : this.zzc) {
            String str = (String) zzbex.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                zzd.add(str);
            }
        }
        zzd.addAll(zzbjo.zzb());
        return zzd;
    }
}
