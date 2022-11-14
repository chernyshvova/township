package com.google.android.gms.internal.ads;

import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdm {
    public final Clock zza;
    public final Map<String, List<String>> zzb = new HashMap();
    public final Map<String, Long> zzc = new HashMap();

    public zzfdm(Clock clock) {
        this.zza = clock;
    }

    private final void zzd(String str, String str2) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, new ArrayList());
        }
        this.zzb.get(str).add(str2);
    }

    public final void zza(String str) {
        if (this.zzc.containsKey(str)) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            long longValue = this.zzc.remove(str).longValue();
            StringBuilder sb = new StringBuilder(20);
            sb.append(elapsedRealtime - longValue);
            zzd(str, sb.toString());
            return;
        }
        this.zzc.put(str, Long.valueOf(this.zza.elapsedRealtime()));
    }

    public final void zzb(String str, String str2) {
        if (this.zzc.containsKey(str)) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            long longValue = this.zzc.remove(str).longValue();
            StringBuilder sb = new StringBuilder(str2.length() + 20);
            sb.append(str2);
            sb.append(elapsedRealtime - longValue);
            zzd(str, sb.toString());
            return;
        }
        this.zzc.put(str, Long.valueOf(this.zza.elapsedRealtime()));
    }

    public final List<zzfdl> zzc() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.zzb.entrySet()) {
            int i = 0;
            if (((List) next.getValue()).size() > 1) {
                for (String zzfdl : (List) next.getValue()) {
                    String str = (String) next.getKey();
                    i++;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                    sb.append(str);
                    sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
                    sb.append(i);
                    arrayList.add(new zzfdl(sb.toString(), zzfdl));
                }
            } else {
                arrayList.add(new zzfdl((String) next.getKey(), (String) ((List) next.getValue()).get(0)));
            }
        }
        return arrayList;
    }
}
