package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzenf implements zzeqo<Bundle> {
    public final double zza;
    public final boolean zzb;

    public zzenf(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzezi.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        bundle.putBundle(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zza2);
        Bundle zza3 = zzezi.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
