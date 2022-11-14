package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzepx implements zzeqo<Bundle> {
    public final String zza;

    public zzepx(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        ((Bundle) obj).putString("rtb", this.zza);
    }
}
