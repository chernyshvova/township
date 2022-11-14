package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p041authapi.zzi;
import com.google.android.gms.internal.p041authapi.zzr;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzi, zzg);
    public static final CredentialsApi CredentialsApi = new zzi();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzj, zzh);
    public static final GoogleSignInApi GoogleSignInApi = new zzf();
    @KeepForSdk
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API = AuthProxy.API;
    @KeepForSdk
    @Deprecated
    public static final ProxyApi ProxyApi = AuthProxy.ProxyApi;
    public static final Api.ClientKey<zzr> zzg = new Api.ClientKey<>();
    public static final Api.ClientKey<zzg> zzh = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<zzr, AuthCredentialsOptions> zzi = new zzc();
    public static final Api.AbstractClientBuilder<zzg, GoogleSignInOptions> zzj = new zzd();

    @Deprecated
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        public static final AuthCredentialsOptions zzk = new Builder().zzc();
        public final String zzl = null;
        public final boolean zzm;

        @Deprecated
        public static class Builder {
            public Boolean zzn = Boolean.FALSE;

            public Builder forceEnableSaveDialog() {
                this.zzn = Boolean.TRUE;
                return this;
            }

            public AuthCredentialsOptions zzc() {
                return new AuthCredentialsOptions(this);
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.zzm = builder.zzn.booleanValue();
        }

        public final Bundle toBundle() {
            Bundle outline5 = GeneratedOutlineSupport.outline5("consumer_package", (String) null);
            outline5.putBoolean("force_save_dialog", this.zzm);
            return outline5;
        }
    }
}
