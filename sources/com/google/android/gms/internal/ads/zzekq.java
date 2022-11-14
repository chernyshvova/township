package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzekq implements zzddy, zzdcr, zzdbg, zzdbx, zzbcz, zzdbd, zzddo, zzamt, zzdbt {
    @VisibleForTesting
    public final BlockingQueue<Pair<String, String>> zza = new ArrayBlockingQueue(((Integer) zzbex.zzc().zzb(zzbjn.zzfY)).intValue());
    public final AtomicReference<zzbfe> zzb = new AtomicReference<>();
    public final AtomicReference<zzbfy> zzc = new AtomicReference<>();
    public final AtomicReference<zzbha> zzd = new AtomicReference<>();
    public final AtomicReference<zzbfh> zze = new AtomicReference<>();
    public final AtomicReference<zzbgf> zzf = new AtomicReference<>();
    public final AtomicBoolean zzg = new AtomicBoolean(true);
    public final AtomicBoolean zzh = new AtomicBoolean(false);
    public final AtomicBoolean zzi = new AtomicBoolean(false);
    @Nullable
    public final zzfdh zzj;

    public zzekq(@Nullable zzfdh zzfdh) {
        this.zzj = zzfdh;
    }

    @TargetApi(5)
    private final void zzt() {
        if (this.zzh.get() && this.zzi.get()) {
            for (Pair zzekg : this.zza) {
                zzevk.zza(this.zzc, new zzekg(zzekg));
            }
            this.zza.clear();
            this.zzg.set(false);
        }
    }

    public final void onAdClicked() {
        zzevk.zza(this.zzb, zzekb.zza);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return;
     */
    @android.annotation.TargetApi(5)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzg     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0036
            java.util.concurrent.BlockingQueue<android.util.Pair<java.lang.String, java.lang.String>> r0 = r3.zza     // Catch:{ all -> 0x0042 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0034
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.internal.ads.zzcgs.zzd(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzfdh r0 = r3.zzj     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r1 = "dae_action"
            com.google.android.gms.internal.ads.zzfdg r1 = com.google.android.gms.internal.ads.zzfdg.zza(r1)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "dae_name"
            r1.zzc(r2, r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = "dae_data"
            r1.zzc(r4, r5)     // Catch:{ all -> 0x0042 }
            r0.zza(r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzbfy> r0 = r3.zzc     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzeke r1 = new com.google.android.gms.internal.ads.zzeke     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzevk.zza(r0, r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekq.zza(java.lang.String, java.lang.String):void");
    }

    public final void zzbF() {
        zzevk.zza(this.zzb, zzekc.zza);
    }

    public final void zzbT(zzbdd zzbdd) {
        zzevk.zza(this.zzb, new zzeki(zzbdd));
        zzevk.zza(this.zzb, new zzekj(zzbdd));
        zzevk.zza(this.zze, new zzekk(zzbdd));
        this.zzg.set(false);
        this.zza.clear();
    }

    public final synchronized void zzbU() {
        zzevk.zza(this.zzb, zzekm.zza);
        zzevk.zza(this.zze, zzekn.zza);
        this.zzi.set(true);
        zzt();
    }

    public final void zzc() {
        zzevk.zza(this.zzb, zzeko.zza);
        zzevk.zza(this.zzf, zzekp.zza);
        zzevk.zza(this.zzf, zzeka.zza);
    }

    public final void zzd() {
        zzevk.zza(this.zzb, zzejz.zza);
        zzevk.zza(this.zzf, zzekh.zza);
    }

    public final void zze() {
        zzevk.zza(this.zzb, zzekl.zza);
    }

    public final void zzf(zzcca zzcca, String str, String str2) {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi(zzbdd zzbdd) {
        zzevk.zza(this.zzf, new zzekf(zzbdd));
    }

    public final void zzj(zzcbk zzcbk) {
    }

    public final void zzk(@NonNull zzbdr zzbdr) {
        zzevk.zza(this.zzd, new zzekd(zzbdr));
    }

    public final synchronized zzbfe zzl() {
        return this.zzb.get();
    }

    public final synchronized zzbfy zzm() {
        return this.zzc.get();
    }

    public final void zzn(zzbfe zzbfe) {
        this.zzb.set(zzbfe);
    }

    public final void zzo(zzbfy zzbfy) {
        this.zzc.set(zzbfy);
        this.zzh.set(true);
        zzt();
    }

    public final void zzp(zzbha zzbha) {
        this.zzd.set(zzbha);
    }

    public final void zzq(zzeyq zzeyq) {
        this.zzg.set(true);
        this.zzi.set(false);
    }

    public final void zzr(zzbfh zzbfh) {
        this.zze.set(zzbfh);
    }

    public final void zzs(zzbgf zzbgf) {
        this.zzf.set(zzbgf);
    }
}
