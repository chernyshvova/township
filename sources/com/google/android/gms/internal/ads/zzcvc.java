package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcvc extends zzcxi {
    @Nullable
    public final zzcmr zzc;
    public final int zzd;
    public final Context zze;
    public final zzcuk zzf;
    public final zzdkb zzg;
    public boolean zzh = false;

    public zzcvc(zzcxh zzcxh, Context context, @Nullable zzcmr zzcmr, int i, zzcuk zzcuk, zzdkb zzdkb) {
        super(zzcxh);
        this.zzc = zzcmr;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcuk;
        this.zzg = zzdkb;
    }

    public final void zzT() {
        super.zzT();
        zzcmr zzcmr = this.zzc;
        if (zzcmr != null) {
            zzcmr.destroy();
        }
    }

    public final void zza(zzaxm zzaxm) {
        zzcmr zzcmr = this.zzc;
        if (zzcmr != null) {
            zzcmr.zzax(zzaxm);
        }
    }

    /* JADX WARNING: type inference failed for: r3v10, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(android.app.Activity r3, com.google.android.gms.internal.ads.zzaxz r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzar
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x005d
            com.google.android.gms.ads.internal.zzs.zzc()
            boolean r0 = com.google.android.gms.ads.internal.util.zzr.zzJ(r3)
            if (r0 == 0) goto L_0x005d
            java.lang.String r5 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzcgs.zzi(r5)
            r5 = 11
            com.google.android.gms.internal.ads.zzbdd r5 = com.google.android.gms.internal.ads.zzezr.zzd(r5, r1, r1)
            r4.zze(r5)
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzbjn.zzas
            com.google.android.gms.internal.ads.zzbjl r5 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r4 = r5.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzfgy r4 = new com.google.android.gms.internal.ads.zzfgy
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbw r5 = com.google.android.gms.ads.internal.zzs.zzq()
            android.os.Looper r5 = r5.zza()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzeyq r3 = r2.zza
            com.google.android.gms.internal.ads.zzeyp r3 = r3.zzb
            com.google.android.gms.internal.ads.zzeyh r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x005d:
            boolean r0 = r2.zzh
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)
        L_0x0066:
            boolean r0 = r2.zzh
            if (r0 != 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzdkb r0 = r2.zzg     // Catch:{ zzdka -> 0x0073 }
            r0.zza(r5, r3, r1)     // Catch:{ zzdka -> 0x0073 }
            r3 = 1
            r2.zzh = r3
            return
        L_0x0073:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzbdd r3 = com.google.android.gms.internal.ads.zzezr.zza(r3)
            r4.zze(r3)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvc.zzb(android.app.Activity, com.google.android.gms.internal.ads.zzaxz, boolean):void");
    }

    public final int zzc() {
        return this.zzd;
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
