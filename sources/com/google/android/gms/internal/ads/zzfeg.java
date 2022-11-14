package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfeg {
    public boolean zza;

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb(Context context) {
        zzffp.zza(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzffd.zza().zzb(context);
            zzfey.zza().zzb(context);
            zzffn.zza(context);
            zzffa.zza().zzc(context);
        }
    }
}
