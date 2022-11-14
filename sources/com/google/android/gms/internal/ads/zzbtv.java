package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbtv implements zzbsl, zzbtu {
    public final zzbtu zza;
    public final HashSet<AbstractMap.SimpleEntry<String, zzbps<? super zzbtu>>> zzb = new HashSet<>();

    public zzbtv(zzbtu zzbtu) {
        this.zza = zzbtu;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final void zzb(String str, String str2) {
        zzbsk.zzb(this, str, str2);
    }

    public final void zzc() {
        String str;
        Iterator<AbstractMap.SimpleEntry<String, zzbps<? super zzbtu>>> it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzbps) next.getValue()).toString());
            if (valueOf.length() != 0) {
                str = "Unregistering eventhandler: ".concat(valueOf);
            } else {
                str = new String("Unregistering eventhandler: ");
            }
            zze.zza(str);
            this.zza.zzm((String) next.getKey(), (zzbps) next.getValue());
        }
        this.zzb.clear();
    }

    public final void zzd(String str, JSONObject jSONObject) {
        zzbsk.zzc(this, str, jSONObject);
    }

    public final void zze(String str, Map map) {
        zzbsk.zzd(this, str, map);
    }

    public final void zzl(String str, zzbps<? super zzbtu> zzbps) {
        this.zza.zzl(str, zzbps);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbps));
    }

    public final void zzm(String str, zzbps<? super zzbtu> zzbps) {
        this.zza.zzm(str, zzbps);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbps));
    }

    public final void zzr(String str, JSONObject jSONObject) {
        zzbsk.zza(this, str, jSONObject);
    }
}
