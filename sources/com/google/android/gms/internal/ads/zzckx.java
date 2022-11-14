package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzckx implements Releasable {
    public final Context zza;
    public final String zzb;
    public final WeakReference<zzciz> zzc;

    public zzckx(zzciz zzciz) {
        this.zza = zzciz.getContext();
        this.zzb = zzs.zzc().zze(this.zza, zzciz.zzt().zza);
        this.zzc = new WeakReference<>(zzciz);
    }

    public static /* synthetic */ void zzo(zzckx zzckx, String str, Map map) {
        zzciz zzciz = (zzciz) zzckx.zzc.get();
        if (zzciz != null) {
            zzciz.zze("onPrecacheEvent", map);
        }
    }

    public void release() {
    }

    public abstract boolean zza(String str);

    public boolean zzb(String str, String[] strArr) {
        return zza(str);
    }

    public void zzc(int i) {
    }

    public void zzd(int i) {
    }

    public void zze(int i) {
    }

    public void zzf(int i) {
    }

    public abstract void zzg();

    @VisibleForTesting
    public final void zzh(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        Handler handler = zzcgl.zza;
        zzcks zzcks = r0;
        zzcks zzcks2 = new zzcks(this, str, str2, j, j2, j3, j4, j5, z, i, i2);
        handler.post(zzcks);
    }

    @VisibleForTesting
    public final void zzi(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzcgl.zza.post(new zzckt(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    public final void zzl(String str, String str2, int i) {
        zzcgl.zza.post(new zzcku(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zzm(String str, String str2, long j) {
        zzcgl.zza.post(new zzckv(this, str, str2, j));
    }

    @VisibleForTesting
    public final void zzn(String str, @Nullable String str2, String str3, @Nullable String str4) {
        zzcgl.zza.post(new zzckw(this, str, str2, str3, str4));
    }
}
