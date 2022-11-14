package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.vungle.warren.VungleApiClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzere implements zzeqp<zzerf> {
    public final Context zza;
    public final ScheduledExecutorService zzb;
    public final Executor zzc;
    public final int zzd;
    public final zzcfw zze;

    public zzere(zzcfw zzcfw, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, byte[] bArr) {
        this.zze = zzcfw;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
    }

    public final zzfqn<zzerf> zza() {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzaF)).booleanValue()) {
            return zzfqe.zzc(new Exception("Did not ad Ad ID into query param."));
        }
        return zzfqe.zzf((zzfpv) zzfqe.zzh(zzfqe.zzj(zzfpv.zzw(this.zze.zza(this.zza, this.zzd)), zzerc.zza, this.zzc), ((Long) zzbex.zzc().zzb(zzbjn.zzaG)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzerd(this), this.zzc);
    }

    public final /* synthetic */ zzerf zzb(Throwable th) {
        String str;
        zzbev.zza();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, VungleApiClient.ANDROID_ID);
        }
        return new zzerf((AdvertisingIdClient.Info) null, str);
    }
}
