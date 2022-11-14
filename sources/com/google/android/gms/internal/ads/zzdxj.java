package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdxj {
    public final zzdww zza;
    public final zzdsp zzb;
    public final Object zzc = new Object();
    @GuardedBy("lock")
    public final List<zzdxi> zzd;
    @GuardedBy("lock")
    public boolean zze;

    public zzdxj(zzdww zzdww, zzdsp zzdsp) {
        this.zza = zzdww;
        this.zzb = zzdsp;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List<zzbrm> list) {
        String zzbyb;
        synchronized (this.zzc) {
            if (!this.zze) {
                for (zzbrm next : list) {
                    List<zzdxi> list2 = this.zzd;
                    String str = next.zza;
                    zzdso zzc2 = this.zzb.zzc(str);
                    if (zzc2 == null) {
                        zzbyb = "";
                    } else {
                        zzbyb zzbyb2 = zzc2.zzb;
                        if (zzbyb2 == null) {
                            zzbyb = "";
                        } else {
                            zzbyb = zzbyb2.toString();
                        }
                    }
                    String str2 = zzbyb;
                    boolean z = next.zzb;
                    list2.add(new zzdxi(str, str2, z ? 1 : 0, next.zzd, next.zzc));
                }
                this.zze = true;
            }
        }
    }

    public final void zza() {
        this.zza.zzb(new zzdxh(this));
    }

    public final JSONArray zzb() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zze()) {
                    zzd(this.zza.zzd());
                } else {
                    zza();
                    return jSONArray;
                }
            }
            for (zzdxi zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
            return jSONArray;
        }
    }
}
