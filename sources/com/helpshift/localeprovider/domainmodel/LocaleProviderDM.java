package com.helpshift.localeprovider.domainmodel;

import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.util.StringUtils;
import java.util.Locale;

public class LocaleProviderDM {
    public Device device;
    public Locale previousLocale;
    public SDKConfigurationDM sdkConfigurationDM;

    public LocaleProviderDM(SDKConfigurationDM sDKConfigurationDM, Platform platform) {
        this.sdkConfigurationDM = sDKConfigurationDM;
        this.device = platform.getDevice();
    }

    public void backupApplicationLocale() {
        if (this.previousLocale == null) {
            this.previousLocale = this.device.getLocale();
        }
    }

    public Locale getCurrentLocale() {
        Locale locale;
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.SDK_LANGUAGE);
        if (StringUtils.isEmpty(string)) {
            return Locale.getDefault();
        }
        if (string.contains("_")) {
            String[] split = string.split("_");
            locale = new Locale(split[0], split[1]);
        } else {
            locale = new Locale(string);
        }
        return locale;
    }

    public Locale getCurrentLocaleFromStorage() {
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.SDK_LANGUAGE);
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        if (!string.contains("_")) {
            return new Locale(string);
        }
        String[] split = string.split("_");
        return new Locale(split[0], split[1]);
    }

    public String getDefaultLanguage() {
        return Locale.getDefault().toString();
    }

    public String getSDKLanguage() {
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.SDK_LANGUAGE);
        return StringUtils.isEmpty(string) ? "" : string;
    }

    public void restoreApplicationLocale() {
        Locale locale = this.previousLocale;
        if (locale != null) {
            this.device.changeLocale(locale);
            this.previousLocale = null;
        }
    }
}
