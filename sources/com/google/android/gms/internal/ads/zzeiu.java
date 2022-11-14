package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeiu implements zzedn<zzcvj> {
    public final Context zza;
    public final zzcwg zzb;
    @Nullable
    public final zzbki zzc;
    public final zzfqo zzd;
    public final zzfcx zze;

    public zzeiu(Context context, zzcwg zzcwg, zzfcx zzfcx, zzfqo zzfqo, @Nullable zzbki zzbki) {
        this.zza = context;
        this.zzb = zzcwg;
        this.zze = zzfcx;
        this.zzd = zzfqo;
        this.zzc = zzbki;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzeyq r1, com.google.android.gms.internal.ads.zzeye r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbki r1 = r0.zzc
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzeyj r1 = r2.zzs
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zza(com.google.android.gms.internal.ads.zzeyq, com.google.android.gms.internal.ads.zzeye):boolean");
    }

    public final zzfqn<zzcvj> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzcvk zzd2 = this.zzb.zzd(new zzcxx(zzeyq, zzeye, (String) null), new zzeis(this, new View(this.zza), (zzcmr) null, zzeiq.zza, zzeye.zzu.get(0)));
        zzeit zzk = zzd2.zzk();
        zzeyj zzeyj = zzeye.zzs;
        zzbkd zzbkd = new zzbkd(zzk, zzeyj.zzb, zzeyj.zza);
        zzfcx zzfcx = this.zze;
        return zzfci.zzd(new zzeir(this, zzbkd), this.zzd, zzfcr.CUSTOM_RENDER_SYN, zzfcx).zzj(zzfcr.CUSTOM_RENDER_ACK).zze(zzfqe.zza(zzd2.zzh())).zzi();
    }

    public final /* synthetic */ void zzc(zzbkd zzbkd) throws Exception {
        this.zzc.zze(zzbkd);
    }
}
