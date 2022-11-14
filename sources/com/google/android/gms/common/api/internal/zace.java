package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zab;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zace extends zab implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static Api.AbstractClientBuilder<? extends zae, SignInOptions> zaa = com.google.android.gms.signin.zab.zaa;
    public final Context zab;
    public final Handler zac;
    public final Api.AbstractClientBuilder<? extends zae, SignInOptions> zad;
    public Set<Scope> zae;
    public ClientSettings zaf;
    public zae zag;
    public zach zah;

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        this(context, handler, clientSettings, zaa);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zab(zak zak) {
        ConnectionResult zaa2 = zak.zaa();
        if (zaa2.isSuccess()) {
            zau zau = (zau) Preconditions.checkNotNull(zak.zab());
            ConnectionResult zab2 = zau.zab();
            if (!zab2.isSuccess()) {
                String valueOf = String.valueOf(zab2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.zah.zaa(zab2);
                this.zag.disconnect();
                return;
            }
            this.zah.zaa(zau.zaa(), this.zae);
        } else {
            this.zah.zaa(zaa2);
        }
        this.zag.disconnect();
    }

    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zag.zaa(this);
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zah.zaa(connectionResult);
    }

    @WorkerThread
    public final void onConnectionSuspended(int i) {
        this.zag.disconnect();
    }

    @WorkerThread
    public final void zaa(zach zach) {
        zae zae2 = this.zag;
        if (zae2 != null) {
            zae2.disconnect();
        }
        this.zaf.zaa(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder = this.zad;
        Context context = this.zab;
        Looper looper = this.zac.getLooper();
        ClientSettings clientSettings = this.zaf;
        this.zag = (zae) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zac(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.zah = zach;
        Set<Scope> set = this.zae;
        if (set == null || set.isEmpty()) {
            this.zac.post(new zacg(this));
        } else {
            this.zag.zab();
        }
    }

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder) {
        this.zab = context;
        this.zac = handler;
        this.zaf = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.zae = clientSettings.getRequiredScopes();
        this.zad = abstractClientBuilder;
    }

    public final void zaa() {
        zae zae2 = this.zag;
        if (zae2 != null) {
            zae2.disconnect();
        }
    }

    @BinderThread
    public final void zaa(zak zak) {
        this.zac.post(new zacf(this, zak));
    }
}
