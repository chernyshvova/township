package com.google.android.gms.internal.ads;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzako extends PhoneStateListener {
    public final /* synthetic */ zzakp zza;

    public /* synthetic */ zzako(zzakp zzakp, zzakl zzakl) {
        this.zza = zzakp;
    }

    @RequiresApi(31)
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        zzakp.zzd(this.zza, true != (overrideNetworkType == 3 || overrideNetworkType == 4) ? 5 : 10);
    }

    public final void onServiceStateChanged(@Nullable ServiceState serviceState) {
        String serviceState2 = serviceState == null ? "" : serviceState.toString();
        zzakp.zzd(this.zza, true != (serviceState2.contains("nrState=CONNECTED") || serviceState2.contains("nrState=NOT_RESTRICTED")) ? 5 : 10);
    }
}
