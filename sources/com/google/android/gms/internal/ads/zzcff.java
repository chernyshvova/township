package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcff implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzcfh zza;
    public final String zzb;

    public zzcff(zzcfh zzcfh, String str) {
        this.zza = zzcfh;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzcfg zza2 : this.zza.zzb) {
                zza2.zza(sharedPreferences, this.zzb, str);
            }
        }
    }
}
