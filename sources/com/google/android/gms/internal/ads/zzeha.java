package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeha {
    public final Clock zza;
    public final zzehb zzb;
    public final List<String> zzc = Collections.synchronizedList(new ArrayList());
    public final boolean zzd;
    public final zzeds zze;

    public zzeha(Clock clock, zzehb zzehb, zzeds zzeds) {
        this.zza = clock;
        this.zzb = zzehb;
        this.zzd = ((Boolean) zzbex.zzc().zzb(zzbjn.zzfa)).booleanValue();
        this.zze = zzeds;
    }

    public static /* synthetic */ void zzd(zzeha zzeha, String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 33);
        sb.append(str);
        sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
        sb.append(i);
        sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            sb2 = GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length()), sb2, CodelessMatcher.CURRENT_CLASS_NAME, str2);
        }
        zzeha.zzc.add(sb2);
    }

    public final <T> zzfqn<T> zza(zzeyh zzeyh, zzeye zzeye, zzfqn<T> zzfqn) {
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzeye.zzw;
        if (str != null) {
            zzfqe.zzp(zzfqn, new zzegz(this, elapsedRealtime, str, zzeye, zzeyh), zzche.zzf);
        }
        return zzfqn;
    }

    public final String zzb() {
        return TextUtils.join("_", this.zzc);
    }
}
