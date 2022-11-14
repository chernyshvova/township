package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzj implements DynamiteModule.VersionPolicy {
    public final zzn zza(Context context, String str, zzm zzm) throws DynamiteModule.LoadingException {
        int i;
        zzn zzn = new zzn();
        int zzb = zzm.zzb(context, str);
        zzn.zza = zzb;
        int i2 = 0;
        if (zzb != 0) {
            i = zzm.zza(context, str, false);
            zzn.zzb = i;
        } else {
            i = zzm.zza(context, str, true);
            zzn.zzb = i;
        }
        int i3 = zzn.zza;
        if (i3 != 0) {
            i2 = i3;
        } else if (i == 0) {
            zzn.zzc = 0;
            return zzn;
        }
        if (i >= i2) {
            zzn.zzc = 1;
        } else {
            zzn.zzc = -1;
        }
        return zzn;
    }
}
