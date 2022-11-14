package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzko implements zzky {
    public final /* synthetic */ zzkl zza;

    public zzko(zzkl zzkl) {
        this.zza = zzkl;
    }

    public final void zza(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzk.zzq().zze().zza("AppId not known when logging error event");
        } else {
            this.zza.zzp().zza((Runnable) new zzkq(this, str, bundle));
        }
    }
}
