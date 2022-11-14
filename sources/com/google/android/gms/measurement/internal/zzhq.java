package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhq implements zzky {
    public final /* synthetic */ zzhb zza;

    public zzhq(zzhb zzhb) {
        this.zza = zzhb;
    }

    public final void zza(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zza("auto", "_err", bundle, str);
        } else {
            this.zza.zza("auto", "_err", bundle);
        }
    }
}
