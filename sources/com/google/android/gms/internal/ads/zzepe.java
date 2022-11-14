package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzs;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzepe implements zzeqp<zzepf> {
    public final zzfqo zza;
    public final Context zzb;
    public final Set<String> zzc;

    public zzepe(zzfqo zzfqo, Context context, Set<String> set) {
        this.zza = zzfqo;
        this.zzb = context;
        this.zzc = set;
    }

    public final zzfqn<zzepf> zza() {
        return this.zza.zzb(new zzepd(this));
    }

    public final /* synthetic */ zzepf zzb() throws Exception {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdo)).booleanValue()) {
            Set<String> set = this.zzc;
            if (set.contains("rewarded") || set.contains("interstitial") || set.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) || set.contains("banner")) {
                return new zzepf(zzs.zzr().zzc(this.zzb));
            }
        }
        return new zzepf((String) null);
    }
}
