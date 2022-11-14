package com.facebook.devicerequests.internal;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.facebook.devicerequests.internal.DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 */
/* compiled from: DeviceRequestsHelper.kt */
public final class C1548x8b27078b implements NsdManager.RegistrationListener {
    public final /* synthetic */ String $nsdServiceName;
    public final /* synthetic */ String $userCode;

    public C1548x8b27078b(String str, String str2) {
        this.$nsdServiceName = str;
        this.$userCode = str2;
    }

    public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        Intrinsics.checkNotNullParameter(nsdServiceInfo, "serviceInfo");
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        DeviceRequestsHelper.cleanUpAdvertisementService(this.$userCode);
    }

    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        Intrinsics.checkNotNullParameter(nsdServiceInfo, "NsdServiceInfo");
        if (!Intrinsics.areEqual(this.$nsdServiceName, nsdServiceInfo.getServiceName())) {
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            DeviceRequestsHelper.cleanUpAdvertisementService(this.$userCode);
        }
    }

    public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        Intrinsics.checkNotNullParameter(nsdServiceInfo, "serviceInfo");
    }

    public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        Intrinsics.checkNotNullParameter(nsdServiceInfo, "serviceInfo");
    }
}
