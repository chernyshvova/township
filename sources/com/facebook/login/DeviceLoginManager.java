package com.facebook.login;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Collection;

public class DeviceLoginManager extends LoginManager {
    public static volatile DeviceLoginManager instance;
    @Nullable
    public String deviceAuthTargetUserId;
    public Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        Class<DeviceLoginManager> cls = DeviceLoginManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (instance == null) {
                synchronized (cls) {
                    if (instance == null) {
                        instance = new DeviceLoginManager();
                    }
                }
            }
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LoginClient.Request createLoginRequest = super.createLoginRequest(collection);
            Uri deviceRedirectUri2 = getDeviceRedirectUri();
            if (deviceRedirectUri2 != null) {
                createLoginRequest.setDeviceRedirectUriString(deviceRedirectUri2.toString());
            }
            String deviceAuthTargetUserId2 = getDeviceAuthTargetUserId();
            if (deviceAuthTargetUserId2 != null) {
                createLoginRequest.setDeviceAuthTargetUserId(deviceAuthTargetUserId2);
            }
            return createLoginRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Nullable
    public String getDeviceAuthTargetUserId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceAuthTargetUserId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public Uri getDeviceRedirectUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceRedirectUri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setDeviceAuthTargetUserId(@Nullable String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.deviceAuthTargetUserId = str;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setDeviceRedirectUri(Uri uri) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.deviceRedirectUri = uri;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
