package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeqa implements zzeqp<zzeqb> {
    public final zzcfb zza;
    public final zzfqo zzb;
    public final Context zzc;

    public zzeqa(zzcfb zzcfb, zzfqo zzfqo, Context context) {
        this.zza = zzcfb;
        this.zzb = zzfqo;
        this.zzc = context;
    }

    public final zzfqn<zzeqb> zza() {
        return this.zzb.zzb(new zzepz(this));
    }

    public final /* synthetic */ zzeqb zzb() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zza.zzb(this.zzc)) {
            return new zzeqb((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzj = this.zza.zzj(this.zzc);
        String str4 = zzj == null ? "" : zzj;
        String zzk = this.zza.zzk(this.zzc);
        if (zzk == null) {
            str = "";
        } else {
            str = zzk;
        }
        String zzl = this.zza.zzl(this.zzc);
        if (zzl == null) {
            str2 = "";
        } else {
            str2 = zzl;
        }
        String zzm = this.zza.zzm(this.zzc);
        if (zzm == null) {
            str3 = "";
        } else {
            str3 = zzm;
        }
        return new zzeqb(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzbex.zzc().zzb(zzbjn.zzaa) : null);
    }
}
