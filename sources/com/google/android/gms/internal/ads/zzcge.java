package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcge {
    @VisibleForTesting
    public long zza = -1;
    @VisibleForTesting
    public long zzb = -1;
    @GuardedBy("lock")
    @VisibleForTesting
    public int zzc = -1;
    @VisibleForTesting
    public int zzd = -1;
    @VisibleForTesting
    public long zze = 0;
    @VisibleForTesting
    public final String zzf;
    @GuardedBy("lock")
    @VisibleForTesting
    public int zzg = 0;
    @GuardedBy("lock")
    @VisibleForTesting
    public int zzh = 0;
    public final Object zzi = new Object();
    public final zzg zzj;

    public zzcge(String str, zzg zzg2) {
        this.zzf = str;
        this.zzj = zzg2;
    }

    private final void zzg() {
        if (zzblf.zza.zze().booleanValue()) {
            synchronized (this.zzi) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final void zza() {
        synchronized (this.zzi) {
            this.zzg++;
        }
    }

    public final void zzb() {
        synchronized (this.zzi) {
            this.zzh++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzbdk r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.zzi
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzg r1 = r10.zzj     // Catch:{ all -> 0x0074 }
            long r1 = r1.zzr()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ all -> 0x0074 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0074 }
            long r5 = r10.zzb     // Catch:{ all -> 0x0074 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzbjn.zzaE     // Catch:{ all -> 0x0074 }
            com.google.android.gms.internal.ads.zzbjl r6 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x0074 }
            java.lang.Object r5 = r6.zzb(r5)     // Catch:{ all -> 0x0074 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0074 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0074 }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.zzd = r1     // Catch:{ all -> 0x0074 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzg r1 = r10.zzj     // Catch:{ all -> 0x0074 }
            int r1 = r1.zzt()     // Catch:{ all -> 0x0074 }
            r10.zzd = r1     // Catch:{ all -> 0x0074 }
        L_0x003b:
            r10.zzb = r12     // Catch:{ all -> 0x0074 }
            r10.zza = r12     // Catch:{ all -> 0x0074 }
            goto L_0x0042
        L_0x0040:
            r10.zza = r12     // Catch:{ all -> 0x0074 }
        L_0x0042:
            android.os.Bundle r11 = r11.zzc     // Catch:{ all -> 0x0074 }
            r12 = 1
            if (r11 == 0) goto L_0x0053
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x0074 }
            if (r11 == r12) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0053:
            int r11 = r10.zzc     // Catch:{ all -> 0x0074 }
            int r11 = r11 + r12
            r10.zzc = r11     // Catch:{ all -> 0x0074 }
            int r11 = r10.zzd     // Catch:{ all -> 0x0074 }
            int r11 = r11 + r12
            r10.zzd = r11     // Catch:{ all -> 0x0074 }
            if (r11 != 0) goto L_0x0069
            r11 = 0
            r10.zze = r11     // Catch:{ all -> 0x0074 }
            com.google.android.gms.ads.internal.util.zzg r11 = r10.zzj     // Catch:{ all -> 0x0074 }
            r11.zzu(r3)     // Catch:{ all -> 0x0074 }
            goto L_0x0072
        L_0x0069:
            com.google.android.gms.ads.internal.util.zzg r11 = r10.zzj     // Catch:{ all -> 0x0074 }
            long r11 = r11.zzv()     // Catch:{ all -> 0x0074 }
            long r3 = r3 - r11
            r10.zze = r3     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0074:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcge.zzc(com.google.android.gms.internal.ads.zzbdk, long):void");
    }

    public final void zzd() {
        zzg();
    }

    public final void zze() {
        zzg();
    }

    public final Bundle zzf(Context context, String str) {
        Bundle bundle;
        String str2;
        synchronized (this.zzi) {
            bundle = new Bundle();
            if (this.zzj.zzC()) {
                str2 = "";
            } else {
                str2 = this.zzf;
            }
            bundle.putString("session_id", str2);
            bundle.putLong("basets", this.zzb);
            bundle.putLong("currts", this.zza);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzc);
            bundle.putInt("preqs_in_session", this.zzd);
            bundle.putLong("time_in_session", this.zze);
            bundle.putInt("pclick", this.zzg);
            bundle.putInt("pimp", this.zzh);
            Context zza2 = zzcby.zza(context);
            int identifier = zza2.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
            boolean z = false;
            if (identifier == 0) {
                zzcgs.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            } else {
                try {
                    if (identifier == zza2.getPackageManager().getActivityInfo(new ComponentName(zza2.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                        z = true;
                    } else {
                        zzcgs.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zzcgs.zzi("Fail to fetch AdActivity theme");
                    zzcgs.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                }
            }
            bundle.putBoolean("support_transparent_background", z);
        }
        return bundle;
    }
}
