package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgn {
    public static final /* synthetic */ int zza = 0;
    public static volatile zzca zzf = zzca.UNKNOWN;
    public final Context zzb;
    public final Executor zzc;
    public final Task<zzfit> zzd;
    public final boolean zze;

    public zzfgn(@NonNull Context context, @NonNull Executor executor, @NonNull Task<zzfit> task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static void zza(zzca zzca) {
        zzf = zzca;
    }

    public static zzfgn zzb(@NonNull Context context, @NonNull Executor executor, boolean z) {
        return new zzfgn(context, executor, Tasks.call(executor, new zzfgk(context, z)), z);
    }

    private final Task<Boolean> zzh(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfgl.zza);
        }
        zzbv zza2 = zzcb.zza();
        zza2.zza(this.zzb.getPackageName());
        zza2.zzb(j);
        zza2.zzg(zzf);
        if (exc != null) {
            zza2.zzc(zzfko.zzb(exc));
            zza2.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zza2.zze(str2);
        }
        if (str != null) {
            zza2.zzf(str);
        }
        return this.zzd.continueWith(this.zzc, new zzfgm(zza2, i));
    }

    public final Task<Boolean> zzc(int i, long j) {
        return zzh(i, j, (Exception) null, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzd(int i, long j, Exception exc) {
        return zzh(i, j, exc, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zze(int i, long j, String str, Map<String, String> map) {
        return zzh(i, j, (Exception) null, str, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzf(int i, String str) {
        return zzh(i, 0, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzg(int i, long j, String str) {
        return zzh(i, j, (Exception) null, (String) null, (Map<String, String>) null, str);
    }
}
