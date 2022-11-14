package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zab {
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaa = new zaa();
    public static final Api<SignInOptions> zab = new Api<>("SignIn.API", zaa, zac);
    public static final Api.ClientKey<SignInClientImpl> zac = new Api.ClientKey<>();
    @ShowFirstParty
    public static final Api.ClientKey<SignInClientImpl> zad = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<SignInClientImpl, zac> zae = new zad();
    public static final Scope zaf = new Scope(Scopes.PROFILE);
    public static final Scope zag = new Scope("email");
    public static final Api<zac> zah = new Api<>("SignIn.INTERNAL_API", zae, zad);
}
