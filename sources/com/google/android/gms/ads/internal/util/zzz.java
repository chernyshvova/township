package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbap;

@TargetApi(26)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzz extends zzy {
    public final zzbap zzq(Context context, TelephonyManager telephonyManager) {
        zzs.zzc();
        if (zzr.zzE(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzbap.ENUM_TRUE : zzbap.ENUM_FALSE;
        }
        return zzbap.ENUM_FALSE;
    }
}
