package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebs implements zzfcy {
    public final Map<zzfcr, String> zza = new HashMap();
    public final Map<zzfcr, String> zzb = new HashMap();
    public final zzfdg zzc;

    public zzebs(Set<zzebr> set, zzfdg zzfdg) {
        this.zzc = zzfdg;
        for (zzebr next : set) {
            this.zza.put(next.zzb, next.zza);
            this.zzb.put(next.zzc, next.zza);
        }
    }

    public final void zzbV(zzfcr zzfcr, String str) {
    }

    public final void zzbW(zzfcr zzfcr, String str) {
        String str2;
        zzfdg zzfdg = this.zzc;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "task.".concat(valueOf);
        } else {
            str2 = new String("task.");
        }
        zzfdg.zzd(str2);
        if (this.zza.containsKey(zzfcr)) {
            zzfdg zzfdg2 = this.zzc;
            String valueOf2 = String.valueOf(this.zza.get(zzfcr));
            zzfdg2.zzd(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."));
        }
    }

    public final void zzbX(zzfcr zzfcr, String str, Throwable th) {
        String str2;
        zzfdg zzfdg = this.zzc;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "task.".concat(valueOf);
        } else {
            str2 = new String("task.");
        }
        zzfdg.zze(str2, "f.");
        if (this.zzb.containsKey(zzfcr)) {
            zzfdg zzfdg2 = this.zzc;
            String valueOf2 = String.valueOf(this.zzb.get(zzfcr));
            zzfdg2.zze(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "f.");
        }
    }

    public final void zzbY(zzfcr zzfcr, String str) {
        String str2;
        zzfdg zzfdg = this.zzc;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "task.".concat(valueOf);
        } else {
            str2 = new String("task.");
        }
        zzfdg.zze(str2, "s.");
        if (this.zzb.containsKey(zzfcr)) {
            zzfdg zzfdg2 = this.zzc;
            String valueOf2 = String.valueOf(this.zzb.get(zzfcr));
            zzfdg2.zze(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "s.");
        }
    }
}
