package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbom {
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza;
    @Nullable
    public final NativeCustomTemplateAd.OnCustomClickListener zzb;
    @GuardedBy("this")
    @Nullable
    public NativeCustomTemplateAd zzc;

    public zzbom(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomTemplateAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzf(zzbnc zzbnc) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzc;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzbnd zzbnd = new zzbnd(zzbnc);
        this.zzc = zzbnd;
        return zzbnd;
    }

    public final zzbnp zza() {
        return new zzbol(this, (zzboj) null);
    }

    @Nullable
    public final zzbnm zzb() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbok(this, (zzboj) null);
    }
}
