package com.google.android.gms.internal.ads;

import android.app.NotificationManager;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.swrve.sdk.SwrveNotificationConstants;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzcop implements zzcsd {
    @GuardedBy("AppComponent.class")
    public static zzcop zza;

    public static zzcop zza(Context context, zzbvh zzbvh, int i) {
        zzcop zzb = zzb(context, i);
        zzb.zzi().zza(zzbvh);
        return zzb;
    }

    @Deprecated
    public static zzcop zzb(Context context, int i) {
        synchronized (zzcop.class) {
            if (zza == null) {
                return zzc(new zzcgy(212104000, i, true, false), context, new zzcpo());
            }
            zzcop zzcop = zza;
            return zzcop;
        }
    }

    @Deprecated
    public static synchronized zzcop zzc(zzcgy zzcgy, Context context, zzcrb zzcrb) {
        zzcop zzcop;
        synchronized (zzcop.class) {
            if (zza == null) {
                zzcqj zzcqj = new zzcqj((zzcpp) null);
                zzcor zzcor = new zzcor();
                zzcor.zza(zzcgy);
                zzcor.zzb(context);
                zzcqj.zza(new zzcos(zzcor, (zzcoq) null));
                zzcqj.zzb(new zzcrc(zzcrb));
                zza = zzcqj.zzc();
                zzbjn.zza(context);
                zzs.zzg().zze(context, zzcgy);
                zzs.zzi().zza(context);
                zzs.zzc().zzc(context);
                zzs.zzc().zzd(context);
                zzs.zzc().zzn(context);
                zzd.zza(context);
                zzs.zzf().zza(context);
                zzs.zzc();
                if (PlatformVersion.isAtLeastO()) {
                    if (!Arrays.asList(context.databaseList()).contains("AdMobOfflineBufferedPings.db")) {
                        ((NotificationManager) context.getSystemService(SwrveNotificationConstants.PUSH_BUNDLE)).deleteNotificationChannel("offline_notification_channel");
                    }
                }
                zzs.zzx().zza(context);
                zzcfc.zzd(context);
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue()) {
                    if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzap)).booleanValue()) {
                        zzayx zzayx = new zzayx(new zzazd(context));
                        zzecb zzecb = new zzecb(new zzebx(context), zza.zzg());
                        zzs.zzc();
                        new zzect(context, zzcgy, zzayx, zzecb, UUID.randomUUID().toString(), zza.zzd()).zza(zzs.zzg().zzl().zzC());
                    }
                }
            }
            zzcop = zza;
        }
        return zzcop;
    }

    public final zzerh zzA(zzcbk zzcbk, int i) {
        return zzB(new zzeso(zzcbk, i));
    }

    public abstract zzerh zzB(zzeso zzeso);

    public abstract zzdwc zzC();

    public abstract zzfdh zzd();

    public abstract Executor zze();

    public abstract ScheduledExecutorService zzf();

    public abstract zzfqo zzg();

    public abstract zzdds zzh();

    public abstract zzdss zzi();

    public abstract zzcrl zzj();

    public abstract zzcwf zzk();

    public abstract zzeut zzl();

    public abstract zzcul zzm();

    public abstract zzcuw zzn();

    public abstract zzeti zzo();

    public abstract zzdjs zzp();

    public abstract zzewl zzq();

    public abstract zzdko zzr();

    public abstract zzdrn zzs();

    public abstract zzexx zzt();

    public abstract zze zzu();

    public abstract zzt zzv();

    public abstract zzb zzw();

    public abstract zzedj zzx();

    public abstract zzezo<zzdqu> zzy();

    public abstract zzdxo zzz();
}
