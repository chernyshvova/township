package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcwy implements zzdcr, zzdbx {
    public final Context zza;
    @Nullable
    public final zzcmr zzb;
    public final zzeye zzc;
    public final zzcgy zzd;
    @GuardedBy("this")
    @Nullable
    public IObjectWrapper zze;
    @GuardedBy("this")
    public boolean zzf;

    public zzcwy(Context context, @Nullable zzcmr zzcmr, zzeye zzeye, zzcgy zzcgy) {
        this.zza = context;
        this.zzb = zzcmr;
        this.zzc = zzeye;
        this.zzd = zzcgy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzc() {
        /*
            r12 = this;
            monitor-enter(r12)
            com.google.android.gms.internal.ads.zzeye r0 = r12.zzc     // Catch:{ all -> 0x00e5 }
            boolean r0 = r0.zzO     // Catch:{ all -> 0x00e5 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r12)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzcmr r0 = r12.zzb     // Catch:{ all -> 0x00e5 }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r12)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzbzl r0 = com.google.android.gms.ads.internal.zzs.zzr()     // Catch:{ all -> 0x00e5 }
            android.content.Context r1 = r12.zza     // Catch:{ all -> 0x00e5 }
            boolean r0 = r0.zza(r1)     // Catch:{ all -> 0x00e5 }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r12)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzcgy r0 = r12.zzd     // Catch:{ all -> 0x00e5 }
            int r1 = r0.zzb     // Catch:{ all -> 0x00e5 }
            int r0 = r0.zzc     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r3 = 23
            r2.<init>(r3)     // Catch:{ all -> 0x00e5 }
            r2.append(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "."
            r2.append(r1)     // Catch:{ all -> 0x00e5 }
            r2.append(r0)     // Catch:{ all -> 0x00e5 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzeye r0 = r12.zzc     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzeyz r0 = r0.zzQ     // Catch:{ all -> 0x00e5 }
            java.lang.String r8 = r0.zza()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdr     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x00e5 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00e5 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00e5 }
            r1 = 1
            if (r0 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzeye r0 = r12.zzc     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzeyz r0 = r0.zzQ     // Catch:{ all -> 0x00e5 }
            int r0 = r0.zzb()     // Catch:{ all -> 0x00e5 }
            if (r0 != r1) goto L_0x0065
            com.google.android.gms.internal.ads.zzbzm r0 = com.google.android.gms.internal.ads.zzbzm.zzc     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzbzn r2 = com.google.android.gms.internal.ads.zzbzn.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00e5 }
        L_0x0062:
            r10 = r0
            r9 = r2
            goto L_0x0073
        L_0x0065:
            com.google.android.gms.internal.ads.zzbzm r0 = com.google.android.gms.internal.ads.zzbzm.HTML_DISPLAY     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzeye r2 = r12.zzc     // Catch:{ all -> 0x00e5 }
            int r2 = r2.zzf     // Catch:{ all -> 0x00e5 }
            if (r2 != r1) goto L_0x0070
            com.google.android.gms.internal.ads.zzbzn r2 = com.google.android.gms.internal.ads.zzbzn.ONE_PIXEL     // Catch:{ all -> 0x00e5 }
            goto L_0x0062
        L_0x0070:
            com.google.android.gms.internal.ads.zzbzn r2 = com.google.android.gms.internal.ads.zzbzn.BEGIN_TO_RENDER     // Catch:{ all -> 0x00e5 }
            goto L_0x0062
        L_0x0073:
            com.google.android.gms.internal.ads.zzbzl r3 = com.google.android.gms.ads.internal.zzs.zzr()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzcmr r0 = r12.zzb     // Catch:{ all -> 0x00e5 }
            android.webkit.WebView r5 = r0.zzG()     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            com.google.android.gms.internal.ads.zzeye r0 = r12.zzc     // Catch:{ all -> 0x00e5 }
            java.lang.String r11 = r0.zzah     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zzf(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00e5 }
            r12.zze = r0     // Catch:{ all -> 0x00e5 }
            goto L_0x00a0
        L_0x008c:
            com.google.android.gms.internal.ads.zzbzl r3 = com.google.android.gms.ads.internal.zzs.zzr()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzcmr r0 = r12.zzb     // Catch:{ all -> 0x00e5 }
            android.webkit.WebView r5 = r0.zzG()     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zzd(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00e5 }
            r12.zze = r0     // Catch:{ all -> 0x00e5 }
        L_0x00a0:
            com.google.android.gms.internal.ads.zzcmr r0 = r12.zzb     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r12.zze     // Catch:{ all -> 0x00e5 }
            if (r2 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzbzl r2 = com.google.android.gms.ads.internal.zzs.zzr()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = r12.zze     // Catch:{ all -> 0x00e5 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x00e5 }
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzcmr r0 = r12.zzb     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r12.zze     // Catch:{ all -> 0x00e5 }
            r0.zzak(r2)     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzbzl r0 = com.google.android.gms.ads.internal.zzs.zzr()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r12.zze     // Catch:{ all -> 0x00e5 }
            r0.zzh(r2)     // Catch:{ all -> 0x00e5 }
            r12.zzf = r1     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdu     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x00e5 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00e5 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00e5 }
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzcmr r0 = r12.zzb     // Catch:{ all -> 0x00e5 }
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00e5 }
            r1.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = "onSdkLoaded"
            r0.zze(r2, r1)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r12)
            return
        L_0x00e3:
            monitor-exit(r12)
            return
        L_0x00e5:
            r0 = move-exception
            monitor-exit(r12)
            goto L_0x00e9
        L_0x00e8:
            throw r0
        L_0x00e9:
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwy.zzc():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzbF() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0008
            r3.zzc()     // Catch:{ all -> 0x0024 }
        L_0x0008:
            com.google.android.gms.internal.ads.zzeye r0 = r3.zzc     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.zzO     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zze     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzcmr r0 = r3.zzb     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "onSdkImpression"
            r0.zze(r2, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)
            return
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwy.zzbF():void");
    }

    public final synchronized void zzbU() {
        if (!this.zzf) {
            zzc();
        }
    }
}
