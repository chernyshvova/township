package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfi {
    public final String zza;
    public final String zzb = null;
    public boolean zzc;
    public String zzd;
    public final /* synthetic */ zzfc zze;

    public zzfi(zzfc zzfc, String str, String str2) {
        this.zze = zzfc;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzf().getString(this.zza, (String) null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(String str) {
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.putString(this.zza, str);
        edit.apply();
        this.zzd = str;
    }
}
