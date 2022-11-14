package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfg {
    public final String zza;
    public final long zzb;
    public boolean zzc;
    public long zzd;
    public final /* synthetic */ zzfc zze;

    public zzfg(zzfc zzfc, String str, long j) {
        this.zze = zzfc;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j;
    }

    @WorkerThread
    public final long zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzf().getLong(this.zza, this.zzb);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(long j) {
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.putLong(this.zza, j);
        edit.apply();
        this.zzd = j;
    }
}
