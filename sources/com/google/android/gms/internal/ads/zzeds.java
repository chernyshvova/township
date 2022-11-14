package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeds {
    public final List<zzbdt> zza = Collections.synchronizedList(new ArrayList());
    public final Map<String, zzbdt> zzb = Collections.synchronizedMap(new HashMap());
    public zzeyh zzc = null;
    public zzeye zzd = null;

    public final void zza(zzeyh zzeyh) {
        this.zzc = zzeyh;
    }

    public final void zzb(zzeye zzeye) {
        String str = zzeye.zzw;
        if (!this.zzb.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzeye.zzv.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzeye.zzv.getString(next));
                } catch (JSONException unused) {
                }
            }
            zzbdt zzbdt = new zzbdt(zzeye.zzE, 0, (zzbdd) null, bundle);
            this.zza.add(zzbdt);
            this.zzb.put(str, zzbdt);
        }
    }

    public final void zzc(zzeye zzeye, long j, @Nullable zzbdd zzbdd) {
        String str = zzeye.zzw;
        if (this.zzb.containsKey(str)) {
            if (this.zzd == null) {
                this.zzd = zzeye;
            }
            zzbdt zzbdt = this.zzb.get(str);
            zzbdt.zzb = j;
            zzbdt.zzc = zzbdd;
        }
    }

    public final zzdaw zzd() {
        return new zzdaw(this.zzd, "", this, this.zzc);
    }

    public final List<zzbdt> zze() {
        return this.zza;
    }
}
