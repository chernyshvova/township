package com.swrve.sdk.device;

import android.content.Context;
import android.telephony.TelephonyManager;

public class AndroidTelephonyManagerWrapper implements ITelephonyManager {
    public final TelephonyManager manager;

    public AndroidTelephonyManagerWrapper(Context context) {
        this.manager = (TelephonyManager) context.getSystemService("phone");
    }

    public String getSimCountryIso() {
        TelephonyManager telephonyManager = this.manager;
        if (telephonyManager != null) {
            return telephonyManager.getSimCountryIso();
        }
        return null;
    }

    public String getSimOperator() {
        TelephonyManager telephonyManager = this.manager;
        if (telephonyManager != null) {
            return telephonyManager.getSimOperator();
        }
        return null;
    }

    public String getSimOperatorName() {
        TelephonyManager telephonyManager = this.manager;
        if (telephonyManager != null) {
            return telephonyManager.getSimOperatorName();
        }
        return null;
    }
}
