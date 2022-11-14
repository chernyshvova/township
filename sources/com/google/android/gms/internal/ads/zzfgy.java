package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgy {
    public final Context zza;
    public final Looper zzb;

    public zzfgy(@NonNull Context context, @NonNull Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(@NonNull String str) {
        zzfho zza2 = zzfhs.zza();
        zza2.zzb(this.zza.getPackageName());
        zza2.zza(zzfhr.BLOCKED_IMPRESSION);
        zzfhl zza3 = zzfhm.zza();
        zza3.zzb(str);
        zza3.zza(zzfhk.BLOCKED_REASON_BACKGROUND);
        zza2.zzc(zza3);
        new zzfgz(this.zza, this.zzb, (zzfhs) zza2.zzah()).zza();
    }
}
