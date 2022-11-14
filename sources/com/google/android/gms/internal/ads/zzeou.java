package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeou implements zzeqo<Bundle> {
    public final zzeyd zza;

    public zzeou(zzeyd zzeyd) {
        this.zza = zzeyd;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzeyd zzeyd = this.zza;
        if (zzeyd != null) {
            bundle.putBoolean("render_in_browser", zzeyd.zzb());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
