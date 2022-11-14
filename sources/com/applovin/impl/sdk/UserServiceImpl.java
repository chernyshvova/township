package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;

public class UserServiceImpl implements AppLovinUserService {

    /* renamed from: a */
    public final C1188m f1287a;

    public UserServiceImpl(C1188m mVar) {
        this.f1287a = mVar;
    }

    public void preloadConsentDialog() {
        this.f1287a.mo10942W().mo10914c();
    }

    public void showConsentDialog(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.f1287a.mo10942W().mo10913a(activity, onConsentDialogDismissListener);
    }

    public String toString() {
        return "UserService{}";
    }
}
