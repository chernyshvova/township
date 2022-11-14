package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzu;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class GmsSignatureVerifier {
    public static final zzz zza;
    public static final zzz zzb;

    static {
        zzy zzy = new zzy();
        zzy.zza("com.google.android.gms");
        zzy.zzb(204200000);
        zzy.zzc(zzu.zzk(zzm.zzd.zzc(), zzm.zzb.zzc()));
        zzy.zzd(zzu.zzk(zzm.zzc.zzc(), zzm.zza.zzc()));
        zza = zzy.zze();
        zzy zzy2 = new zzy();
        zzy2.zza("com.android.vending");
        zzy2.zzb(82240000);
        zzy2.zzc(zzu.zzj(zzm.zzd.zzc()));
        zzy2.zzd(zzu.zzj(zzm.zzc.zzc()));
        zzb = zzy2.zze();
    }
}
