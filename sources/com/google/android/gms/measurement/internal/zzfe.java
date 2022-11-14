package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfe {
    public final String zza;
    public final boolean zzb;
    public boolean zzc;
    public boolean zzd;
    public final /* synthetic */ zzfc zze;

    public zzfe(zzfc zzfc, String str, boolean z) {
        this.zze = zzfc;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = z;
    }

    @WorkerThread
    public final boolean zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzf().getBoolean(this.zza, this.zzb);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(boolean z) {
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.putBoolean(this.zza, z);
        edit.apply();
        this.zzd = z;
    }
}
