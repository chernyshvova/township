package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzs;
import com.helpshift.conversation.domainmodel.ConversationController;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbtt {
    public final Object zza = new Object();
    public final Context zzb;
    public final String zzc;
    public final zzcgy zzd;
    public final zzbd<zzbso> zze;
    public final zzbd<zzbso> zzf;
    @Nullable
    public zzbts zzg;
    public int zzh = 1;

    public zzbtt(Context context, zzcgy zzcgy, String str, zzbd<zzbso> zzbd, zzbd<zzbso> zzbd2) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzcgy;
        this.zze = zzbd;
        this.zzf = zzbd2;
    }

    public final zzbts zza(@Nullable zzfb zzfb) {
        zzbts zzbts = new zzbts(this.zzf);
        zzche.zze.execute(new zzbsy(this, (zzfb) null, zzbts));
        zzbts.zze(new zzbti(this, zzbts), new zzbtj(this, zzbts));
        return zzbts;
    }

    public final zzbtn zzb(@Nullable zzfb zzfb) {
        synchronized (this.zza) {
            synchronized (this.zza) {
                zzbts zzbts = this.zzg;
                if (zzbts != null && this.zzh == 0) {
                    zzbts.zze(new zzbsz(this), zzbta.zza);
                }
            }
            zzbts zzbts2 = this.zzg;
            if (zzbts2 != null) {
                if (zzbts2.zzh() != -1) {
                    int i = this.zzh;
                    if (i == 0) {
                        zzbtn zza2 = this.zzg.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzh = 2;
                        zza((zzfb) null);
                        zzbtn zza3 = this.zzg.zza();
                        return zza3;
                    } else {
                        zzbtn zza4 = this.zzg.zza();
                        return zza4;
                    }
                }
            }
            this.zzh = 2;
            zzbts zza5 = zza((zzfb) null);
            this.zzg = zza5;
            zzbtn zza6 = zza5.zza();
            return zza6;
        }
    }

    public final /* synthetic */ void zzc(zzbso zzbso) {
        if (zzbso.zzj()) {
            this.zzh = 1;
        }
    }

    public final /* synthetic */ void zzd(zzfb zzfb, zzbts zzbts) {
        try {
            zzbsw zzbsw = new zzbsw(this.zzb, this.zzd, (zzfb) null, (zza) null);
            zzbsw.zzh(new zzbtb(this, zzbts, zzbsw));
            zzbsw.zzl("/jsLoaded", new zzbte(this, zzbts, zzbsw));
            zzcb zzcb = new zzcb();
            zzbtf zzbtf = new zzbtf(this, (zzfb) null, zzbsw, zzcb);
            zzcb.zzb(zzbtf);
            zzbsw.zzl("/requestReload", zzbtf);
            if (this.zzc.endsWith(".js")) {
                zzbsw.zzc(this.zzc);
            } else if (this.zzc.startsWith("<html>")) {
                zzbsw.zzg(this.zzc);
            } else {
                zzbsw.zzf(this.zzc);
            }
            zzr.zza.postDelayed(new zzbth(this, zzbts, zzbsw), ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT);
        } catch (Throwable th) {
            zzcgs.zzg("Error creating webview.", th);
            zzs.zzg().zzg(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbts.zzg();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zze(com.google.android.gms.internal.ads.zzbts r4, com.google.android.gms.internal.ads.zzbso r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            int r1 = r4.zzh()     // Catch:{ all -> 0x0027 }
            r2 = -1
            if (r1 == r2) goto L_0x0025
            int r1 = r4.zzh()     // Catch:{ all -> 0x0027 }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0025
        L_0x0012:
            r4.zzg()     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzfqo r4 = com.google.android.gms.internal.ads.zzche.zze     // Catch:{ all -> 0x0027 }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzbtd.zza(r5)     // Catch:{ all -> 0x0027 }
            r4.execute(r5)     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtt.zze(com.google.android.gms.internal.ads.zzbts, com.google.android.gms.internal.ads.zzbso):void");
    }
}
