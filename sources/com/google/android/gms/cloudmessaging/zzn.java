package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class zzn extends zzq<Void> {
    public zzn(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zza(null);
        } else {
            zza(new zzp(4, "Invalid response to one way request"));
        }
    }

    public final boolean zza() {
        return true;
    }
}
