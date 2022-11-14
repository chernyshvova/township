package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class zzs extends zzq<Bundle> {
    public zzs(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zza(bundle2);
    }

    public final boolean zza() {
        return false;
    }
}
