package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzw extends zzr {
    public final Context mContext;

    public zzw(Context context) {
        this.mContext = context;
    }

    private final void zzl() {
        if (!GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid())) {
            throw new SecurityException(GeneratedOutlineSupport.outline10(52, "Calling UID ", Binder.getCallingUid(), " is not Google Play services."));
        }
    }

    public final void zzj() {
        zzl();
        Storage instance = Storage.getInstance(this.mContext);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = instance.getSavedDefaultGoogleSignInAccount();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            googleSignInOptions = instance.getSavedDefaultGoogleSignInOptions();
        }
        GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        try {
            if (build.blockingConnect().isSuccess()) {
                if (savedDefaultGoogleSignInAccount != null) {
                    Auth.GoogleSignInApi.revokeAccess(build);
                } else {
                    build.clearDefaultAccountAndReconnect();
                }
            }
        } finally {
            build.disconnect();
        }
    }

    public final void zzk() {
        zzl();
        zzp.zzd(this.mContext).clear();
    }
}
