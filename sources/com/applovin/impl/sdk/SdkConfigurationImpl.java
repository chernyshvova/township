package com.applovin.impl.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class SdkConfigurationImpl implements AppLovinSdkConfiguration {

    /* renamed from: a */
    public final C1188m f1286a;

    public SdkConfigurationImpl(C1188m mVar) {
        this.f1286a = mVar;
    }

    public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
        String str = (String) this.f1286a.mo10946a(C1085b.f1776eY);
        return "applies".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.APPLIES : "does_not_apply".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY : AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
    }

    public String getCountryCode() {
        return (String) this.f1286a.mo10946a(C1085b.f1777eZ);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinSdkConfiguration{consentDialogState=");
        outline24.append(getConsentDialogState());
        outline24.append(", countryCode=");
        outline24.append(getCountryCode());
        outline24.append('}');
        return outline24.toString();
    }
}
