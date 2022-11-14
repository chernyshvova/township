package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeoq implements zzeqo<Bundle> {
    public final Bundle zza;

    public zzeoq(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzezi.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        zza2.putBundle("android_mem_info", this.zza);
        bundle.putBundle(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zza2);
    }
}
