package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeny implements Callable {
    public final zzenz zza;

    public zzeny(zzenz zzenz) {
        this.zza = zzenz;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzs.zzc();
        zzawy zzb = zzs.zzg().zzl().zzb();
        Bundle bundle = null;
        if (zzb != null && (!zzs.zzg().zzl().zzd() || !zzs.zzg().zzl().zzh())) {
            if (zzb.zzh()) {
                zzb.zzf();
            }
            zzawo zze = zzb.zze();
            if (zze != null) {
                str2 = zze.zzb();
                str = zze.zzc();
                str3 = zze.zzd();
                if (str2 != null) {
                    zzs.zzg().zzl().zze(str2);
                }
                if (str3 != null) {
                    zzs.zzg().zzl().zzi(str3);
                }
            } else {
                str2 = zzs.zzg().zzl().zzf();
                str3 = zzs.zzg().zzl().zzj();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzs.zzg().zzl().zzh()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzs.zzg().zzl().zzd()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzeoa(bundle);
    }
}
