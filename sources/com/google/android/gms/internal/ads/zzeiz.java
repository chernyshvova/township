package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeiz<AdT> implements zzedn<AdT> {
    @Nullable
    public final zzbki zza;
    public final zzfqo zzb;
    public final zzfcx zzc;
    public final zzeji zzd;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzfqo, com.google.android.gms.internal.ads.zzfcx] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzbki, com.google.android.gms.internal.ads.zzfqo] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzbki, com.google.android.gms.internal.ads.zzeji] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzeiz(com.google.android.gms.internal.ads.zzfcx r1, com.google.android.gms.internal.ads.zzfcx r2, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzfqo r3, com.google.android.gms.internal.ads.zzbki r4, com.google.android.gms.internal.ads.zzeji r5) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzc = r1
            r0.zzb = r2
            r0.zza = r3
            r0.zzd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiz.<init>(com.google.android.gms.internal.ads.zzfcx, com.google.android.gms.internal.ads.zzfqo, com.google.android.gms.internal.ads.zzbki, com.google.android.gms.internal.ads.zzeji, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzeyq r1, com.google.android.gms.internal.ads.zzeye r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbki r1 = r0.zza
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiz.zza(com.google.android.gms.internal.ads.zzeyq, com.google.android.gms.internal.ads.zzeye):boolean");
    }

    public final zzfqn<AdT> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzchj zzchj = new zzchj();
        zzeje zzeje = new zzeje();
        zzeje.zzd(new zzeiy(this, zzchj, zzeyq, zzeye, zzeje));
        zzeyj zzeyj = zzeye.zzs;
        zzbkd zzbkd = new zzbkd(zzeje, zzeyj.zzb, zzeyj.zza);
        zzfcx zzfcx = this.zzc;
        return zzfci.zzd(new zzeix(this, zzbkd), this.zzb, zzfcr.CUSTOM_RENDER_SYN, zzfcx).zzj(zzfcr.CUSTOM_RENDER_ACK).zze(zzchj).zzi();
    }

    public final /* synthetic */ void zzc(zzbkd zzbkd) throws Exception {
        this.zza.zze(zzbkd);
    }
}
