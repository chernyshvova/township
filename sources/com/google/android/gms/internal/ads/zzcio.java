package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcio {
    public final Context zza;
    public final zzciz zzb;
    public final ViewGroup zzc;
    public zzcin zzd;

    public zzcio(Context context, ViewGroup viewGroup, zzcmr zzcmr) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcmr;
        this.zzd = null;
    }

    public final void zza(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcin zzcin = this.zzd;
        if (zzcin != null) {
            zzcin.zzm(i, i2, i3, i4);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4, int i5, boolean z, zzciy zzciy) {
        if (this.zzd == null) {
            zzbju.zza(this.zzb.zzq().zzc(), this.zzb.zzi(), "vpr2");
            Context context = this.zza;
            zzciz zzciz = this.zzb;
            zzcin zzcin = new zzcin(context, zzciz, i5, z, zzciz.zzq().zzc(), zzciy);
            this.zzd = zzcin;
            this.zzc.addView(zzcin, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzd.zzm(i, i2, i3, i4);
            this.zzb.zzg(false);
        }
    }

    public final zzcin zzc() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzd;
    }

    public final void zzd() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcin zzcin = this.zzd;
        if (zzcin != null) {
            zzcin.zzq();
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcin zzcin = this.zzd;
        if (zzcin != null) {
            zzcin.zzD();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf(int i) {
        Preconditions.checkMainThread("setPlayerBackgroundColor must be called from the UI thread.");
        zzcin zzcin = this.zzd;
        if (zzcin != null) {
            zzcin.zzl(i);
        }
    }
}
