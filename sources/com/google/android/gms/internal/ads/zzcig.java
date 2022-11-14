package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzcig extends TextureView implements zzcjc {
    public final zzcit zza = new zzcit();
    public final zzcjd zzb;

    public zzcig(Context context) {
        super(context);
        this.zzb = new zzcjd(context, this);
    }

    public void zzA(int i) {
    }

    public void zzB(int i) {
    }

    public abstract String zza();

    public abstract void zzb(zzcif zzcif);

    public abstract void zzc(String str);

    public abstract void zzd();

    public abstract void zze();

    public abstract void zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract void zzi(int i);

    public abstract void zzj(float f, float f2);

    public abstract int zzk();

    public abstract int zzl();

    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract int zzp();

    public abstract void zzq();

    public void zzw(String str, String[] strArr) {
        zzc(str);
    }

    public void zzx(int i) {
    }

    public void zzy(int i) {
    }

    public void zzz(int i) {
    }
}
