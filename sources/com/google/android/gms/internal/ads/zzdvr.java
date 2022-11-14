package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdvr implements zzddy, zzbcz, zzdbd, zzdbx, zzdby, zzdcr, zzdbg, zzamt, zzfcy {
    public final List<Object> zza;
    public final zzdvf zzb;
    public long zzc;

    public zzdvr(zzdvf zzdvf, zzcop zzcop) {
        this.zzb = zzdvf;
        this.zza = Collections.singletonList(zzcop);
    }

    private final void zzi(Class<?> cls, String str, Object... objArr) {
        zzdvf zzdvf = this.zzb;
        List<Object> list = this.zza;
        String simpleName = cls.getSimpleName();
        zzdvf.zza(list, simpleName.length() != 0 ? "Event-".concat(simpleName) : new String("Event-"), str, objArr);
    }

    public final void onAdClicked() {
        zzi(zzbcz.class, "onAdClicked", new Object[0]);
    }

    public final void zza(String str, String str2) {
        zzi(zzamt.class, "onAppEvent", str, str2);
    }

    public final void zzb(Context context) {
        zzi(zzdby.class, "onResume", context);
    }

    public final void zzbD(Context context) {
        zzi(zzdby.class, "onDestroy", context);
    }

    public final void zzbF() {
        zzi(zzdbx.class, "onAdImpression", new Object[0]);
    }

    public final void zzbG(Context context) {
        zzi(zzdby.class, "onPause", context);
    }

    public final void zzbT(zzbdd zzbdd) {
        zzi(zzdbg.class, "onAdFailedToLoad", Integer.valueOf(zzbdd.zza), zzbdd.zzb, zzbdd.zzc);
    }

    public final void zzbU() {
        long elapsedRealtime = zzs.zzj().elapsedRealtime();
        long j = this.zzc;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime - j);
        zze.zza(sb.toString());
        zzi(zzdcr.class, "onAdLoaded", new Object[0]);
    }

    public final void zzbV(zzfcr zzfcr, String str) {
        zzi(zzfcq.class, "onTaskCreated", str);
    }

    public final void zzbW(zzfcr zzfcr, String str) {
        zzi(zzfcq.class, "onTaskStarted", str);
    }

    public final void zzbX(zzfcr zzfcr, String str, Throwable th) {
        zzi(zzfcq.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzbY(zzfcr zzfcr, String str) {
        zzi(zzfcq.class, "onTaskSucceeded", str);
    }

    public final void zzc() {
        zzi(zzdbd.class, "onAdOpened", new Object[0]);
    }

    public final void zzd() {
        zzi(zzdbd.class, "onAdClosed", new Object[0]);
    }

    public final void zze() {
        zzi(zzdbd.class, "onAdLeftApplication", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzf(zzcca zzcca, String str, String str2) {
        zzi(zzdbd.class, "onRewarded", zzcca, str, str2);
    }

    public final void zzg() {
        zzi(zzdbd.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzh() {
        zzi(zzdbd.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzj(zzcbk zzcbk) {
        this.zzc = zzs.zzj().elapsedRealtime();
        zzi(zzddy.class, "onAdRequest", new Object[0]);
    }

    public final void zzq(zzeyq zzeyq) {
    }
}
