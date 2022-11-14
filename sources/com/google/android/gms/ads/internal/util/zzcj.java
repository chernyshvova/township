package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzchr;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcj {
    public final View zza;
    public Activity zzb;
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public final ViewTreeObserver.OnGlobalLayoutListener zzf;

    public zzcj(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzb = activity;
        this.zza = view;
        this.zzf = onGlobalLayoutListener;
    }

    private final void zzf() {
        ViewTreeObserver zzh;
        if (!this.zzc) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzf;
            Activity activity = this.zzb;
            if (!(activity == null || (zzh = zzh(activity)) == null)) {
                zzh.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            zzs.zzz();
            zzchr.zza(this.zza, this.zzf);
            this.zzc = true;
        }
    }

    private final void zzg() {
        Activity activity = this.zzb;
        if (activity != null && this.zzc) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzf;
            ViewTreeObserver zzh = zzh(activity);
            if (zzh != null) {
                zzs.zze();
                zzh.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzc = false;
        }
    }

    public static ViewTreeObserver zzh(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    public final void zza(Activity activity) {
        this.zzb = activity;
    }

    public final void zzb() {
        this.zze = true;
        if (this.zzd) {
            zzf();
        }
    }

    public final void zzc() {
        this.zze = false;
        zzg();
    }

    public final void zzd() {
        this.zzd = true;
        if (this.zze) {
            zzf();
        }
    }

    public final void zze() {
        this.zzd = false;
        zzg();
    }
}
