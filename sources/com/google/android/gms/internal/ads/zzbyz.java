package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbyz {
    public final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    @Nullable
    public final NativeCustomFormatAd.OnCustomClickListener zzb;
    @GuardedBy("this")
    @Nullable
    public NativeCustomFormatAd zzc;

    public zzbyz(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzf(zzbnc zzbnc) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbza zzbza = new zzbza(zzbnc);
        this.zzc = zzbza;
        return zzbza;
    }

    public final zzbnp zza() {
        return new zzbyy(this, (zzbyw) null);
    }

    @Nullable
    public final zzbnm zzb() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbyx(this, (zzbyw) null);
    }
}
