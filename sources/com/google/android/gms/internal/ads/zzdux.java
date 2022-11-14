package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdux implements zzfcy {
    public final Map<zzfcr, Long> zza = new HashMap();
    public final zzduq zzb;
    public final Clock zzc;
    public final Map<zzfcr, zzduw> zzd = new HashMap();

    public zzdux(zzduq zzduq, Set<zzduw> set, Clock clock) {
        this.zzb = zzduq;
        for (zzduw next : set) {
            this.zzd.put(next.zzc, next);
        }
        this.zzc = clock;
    }

    private final void zze(zzfcr zzfcr, boolean z) {
        zzfcr zzb2 = this.zzd.get(zzfcr).zzb;
        String str = true != z ? "f." : "s.";
        if (this.zza.containsKey(zzb2)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzb2).longValue();
            Map<String, String> zzc2 = this.zzb.zzc();
            String zzc3 = this.zzd.get(zzfcr).zza;
            String concat = zzc3.length() != 0 ? "label.".concat(zzc3) : new String("label.");
            String valueOf = String.valueOf(Long.toString(elapsedRealtime));
            zzc2.put(concat, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final void zzbV(zzfcr zzfcr, String str) {
    }

    public final void zzbW(zzfcr zzfcr, String str) {
        this.zza.put(zzfcr, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    public final void zzbX(zzfcr zzfcr, String str, Throwable th) {
        String str2;
        if (this.zza.containsKey(zzfcr)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzfcr).longValue();
            Map<String, String> zzc2 = this.zzb.zzc();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            if (valueOf2.length() != 0) {
                str2 = "f.".concat(valueOf2);
            } else {
                str2 = new String("f.");
            }
            zzc2.put(concat, str2);
        }
        if (this.zzd.containsKey(zzfcr)) {
            zze(zzfcr, false);
        }
    }

    public final void zzbY(zzfcr zzfcr, String str) {
        String str2;
        if (this.zza.containsKey(zzfcr)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzfcr).longValue();
            Map<String, String> zzc2 = this.zzb.zzc();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            if (valueOf2.length() != 0) {
                str2 = "s.".concat(valueOf2);
            } else {
                str2 = new String("s.");
            }
            zzc2.put(concat, str2);
        }
        if (this.zzd.containsKey(zzfcr)) {
            zze(zzfcr, true);
        }
    }
}
