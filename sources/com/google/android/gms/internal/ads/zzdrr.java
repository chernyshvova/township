package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdrr implements zzgjg<zzazh> {
    public final zzgju<zzeyw> zza;

    public zzdrr(zzgju<zzeyw> zzgju) {
        this.zza = zzgju;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzazh zzazh;
        if (((zzdau) this.zza).zza().zzo.zza == 3) {
            zzazh = zzazh.REWARDED_INTERSTITIAL;
        } else {
            zzazh = zzazh.REWARD_BASED_VIDEO_AD;
        }
        zzgjp.zzb(zzazh);
        return zzazh;
    }
}
