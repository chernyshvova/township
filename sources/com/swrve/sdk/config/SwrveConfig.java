package com.swrve.sdk.config;

public class SwrveConfig extends SwrveConfigBase {
    public boolean gAIDLoggingEnabled;
    public boolean pushRegistrationAutomatic = true;

    public boolean isGAIDLoggingEnabled() {
        return this.gAIDLoggingEnabled;
    }

    public boolean isPushRegistrationAutomatic() {
        return this.pushRegistrationAutomatic;
    }

    public void setGAIDLoggingEnabled(boolean z) {
        this.gAIDLoggingEnabled = z;
    }

    public void setPushRegistrationAutomatic(boolean z) {
        this.pushRegistrationAutomatic = z;
    }
}
