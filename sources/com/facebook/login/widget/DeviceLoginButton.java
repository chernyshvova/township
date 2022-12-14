package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

public class DeviceLoginButton extends LoginButton {
    public Uri deviceRedirectUri;

    public class DeviceLoginClickListener extends LoginButton.LoginClickListener {
        public DeviceLoginClickListener() {
            super();
        }

        public LoginManager getLoginManager() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                DeviceLoginManager instance = DeviceLoginManager.getInstance();
                instance.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
                instance.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
                instance.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
                return instance;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    public LoginButton.LoginClickListener getNewLoginClickListener() {
        return new DeviceLoginClickListener();
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeviceLoginButton(Context context) {
        super(context);
    }
}
