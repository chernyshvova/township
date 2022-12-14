package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaaf implements zaaw {
    public final zaaz zaa;
    public final Lock zab;
    public final Context zac;
    public final GoogleApiAvailabilityLight zad;
    @Nullable
    public ConnectionResult zae;
    public int zaf;
    public int zag = 0;
    public int zah;
    public final Bundle zai = new Bundle();
    public final Set<Api.AnyClientKey> zaj = new HashSet();
    @Nullable
    public zae zak;
    public boolean zal;
    public boolean zam;
    public boolean zan;
    @Nullable
    public IAccountAccessor zao;
    public boolean zap;
    public boolean zaq;
    @Nullable
    public final ClientSettings zar;
    public final Map<Api<?>, Boolean> zas;
    @Nullable
    public final Api.AbstractClientBuilder<? extends zae, SignInOptions> zat;
    public ArrayList<Future<?>> zau = new ArrayList<>();

    public zaaf(zaaz zaaz, @Nullable ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, @Nullable Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zaaz;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    public static String zac(int i) {
        return i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zad() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GACConnecting", this.zaa.zad.zac());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zab(new ConnectionResult(8, (PendingIntent) null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult == null) {
            return true;
        }
        this.zaa.zac = this.zaf;
        zab(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zae() {
        if (this.zah == 0) {
            if (!this.zam || this.zan) {
                ArrayList arrayList = new ArrayList();
                this.zag = 1;
                this.zah = this.zaa.zaa.size();
                for (Api.AnyClientKey next : this.zaa.zaa.keySet()) {
                    if (!this.zaa.zab.containsKey(next)) {
                        arrayList.add(this.zaa.zaa.get(next));
                    } else if (zad()) {
                        zaf();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zau.add(zaba.zaa().submit(new zaal(this, arrayList)));
                }
            }
        }
    }

    @GuardedBy("mLock")
    private final void zaf() {
        this.zaa.zai();
        zaba.zaa().execute(new zaae(this));
        zae zae2 = this.zak;
        if (zae2 != null) {
            if (this.zap) {
                zae2.zaa((IAccountAccessor) Preconditions.checkNotNull(this.zao), this.zaq);
            }
            zaa(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zaa.zab.keySet()) {
            ((Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(anyClientKey))).disconnect();
        }
        this.zaa.zae.zaa(this.zai.isEmpty() ? null : this.zai);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zag() {
        this.zam = false;
        this.zaa.zad.zac = Collections.emptySet();
        for (Api.AnyClientKey next : this.zaj) {
            if (!this.zaa.zab.containsKey(next)) {
                this.zaa.zab.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private final void zah() {
        ArrayList<Future<?>> arrayList = this.zau;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.zau.clear();
    }

    /* access modifiers changed from: private */
    public final Set<Scope> zai() {
        if (this.zar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zar.getRequiredScopes());
        Map<Api<?>, ClientSettings.zaa> zaa2 = this.zar.zaa();
        for (Api next : zaa2.keySet()) {
            if (!this.zaa.zab.containsKey(next.zac())) {
                hashSet.addAll(zaa2.get(next).zaa);
            }
        }
        return hashSet;
    }

    @GuardedBy("mLock")
    public final void zaa() {
        this.zaa.zab.clear();
        this.zam = false;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zas.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(next.zac()));
            z |= next.zaa().getPriority() == 1;
            boolean booleanValue = this.zas.get(next).booleanValue();
            if (client.requiresSignIn()) {
                this.zam = true;
                if (booleanValue) {
                    this.zaj.add(next.zac());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(client, new zaah(this, next, booleanValue));
        }
        if (z) {
            this.zam = false;
        }
        if (this.zam) {
            Preconditions.checkNotNull(this.zar);
            Preconditions.checkNotNull(this.zat);
            this.zar.zaa(Integer.valueOf(System.identityHashCode(this.zaa.zad)));
            zaam zaam = new zaam(this, (zaae) null);
            Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder = this.zat;
            Context context = this.zac;
            Looper looper = this.zaa.zad.getLooper();
            ClientSettings clientSettings = this.zar;
            this.zak = (zae) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zac(), (GoogleApiClient.ConnectionCallbacks) zaam, (GoogleApiClient.OnConnectionFailedListener) zaam);
        }
        this.zah = this.zaa.zaa.size();
        this.zau.add(zaba.zaa().submit(new zaag(this, hashMap)));
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void zac() {
    }

    @GuardedBy("mLock")
    public final boolean zab() {
        zah();
        zaa(true);
        this.zaa.zaa((ConnectionResult) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r7 != false) goto L_0x0024;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zab(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Api$BaseClientBuilder r0 = r6.zaa()
            int r0 = r0.getPriority()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0024
            boolean r7 = r5.hasResolution()
            if (r7 == 0) goto L_0x0014
        L_0x0012:
            r7 = 1
            goto L_0x0022
        L_0x0014:
            com.google.android.gms.common.GoogleApiAvailabilityLight r7 = r4.zad
            int r3 = r5.getErrorCode()
            android.content.Intent r7 = r7.getErrorResolutionIntent(r3)
            if (r7 == 0) goto L_0x0021
            goto L_0x0012
        L_0x0021:
            r7 = 0
        L_0x0022:
            if (r7 == 0) goto L_0x002d
        L_0x0024:
            com.google.android.gms.common.ConnectionResult r7 = r4.zae
            if (r7 == 0) goto L_0x002c
            int r7 = r4.zaf
            if (r0 >= r7) goto L_0x002d
        L_0x002c:
            r1 = 1
        L_0x002d:
            if (r1 == 0) goto L_0x0033
            r4.zae = r5
            r4.zaf = r0
        L_0x0033:
            com.google.android.gms.common.api.internal.zaaz r7 = r4.zaa
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.zab
            com.google.android.gms.common.api.Api$AnyClientKey r6 = r6.zac()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaaf.zab(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zab(ConnectionResult connectionResult) {
        zah();
        zaa(!connectionResult.hasResolution());
        this.zaa.zaa(connectionResult);
        this.zaa.zae.zaa(connectionResult);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zab(int i) {
        if (this.zag == i) {
            return true;
        }
        Log.w("GACConnecting", this.zaa.zad.zac());
        String valueOf = String.valueOf(this);
        GeneratedOutlineSupport.outline30(valueOf.length() + 23, "Unexpected callback in ", valueOf, "GACConnecting");
        GeneratedOutlineSupport.outline29(33, "mRemainingConnections=", this.zah, "GACConnecting");
        String zac2 = zac(this.zag);
        String zac3 = zac(i);
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline3(zac3, GeneratedOutlineSupport.outline3(zac2, 70)));
        sb.append("GoogleApiClient connecting is in step ");
        sb.append(zac2);
        sb.append(" but received callback for step ");
        sb.append(zac3);
        Log.e("GACConnecting", sb.toString(), new Exception());
        zab(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaa(zak zak2) {
        if (zab(0)) {
            ConnectionResult zaa2 = zak2.zaa();
            if (zaa2.isSuccess()) {
                zau zau2 = (zau) Preconditions.checkNotNull(zak2.zab());
                ConnectionResult zab2 = zau2.zab();
                if (!zab2.isSuccess()) {
                    String valueOf = String.valueOf(zab2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GACConnecting", sb.toString(), new Exception());
                    zab(zab2);
                    return;
                }
                this.zan = true;
                this.zao = (IAccountAccessor) Preconditions.checkNotNull(zau2.zaa());
                this.zap = zau2.zac();
                this.zaq = zau2.zad();
                zae();
            } else if (zaa(zaa2)) {
                zag();
                zae();
            } else {
                zab(zaa2);
            }
        }
    }

    @GuardedBy("mLock")
    public final void zaa(@Nullable Bundle bundle) {
        if (zab(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zad()) {
                zaf();
            }
        }
    }

    @GuardedBy("mLock")
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zab(1)) {
            zab(connectionResult, api, z);
            if (zad()) {
                zaf();
            }
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        this.zaa.zad.zaa.add(t);
        return t;
    }

    @GuardedBy("mLock")
    public final void zaa(int i) {
        zab(new ConnectionResult(8, (PendingIntent) null));
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zaa(ConnectionResult connectionResult) {
        return this.zal && !connectionResult.hasResolution();
    }

    @GuardedBy("mLock")
    private final void zaa(boolean z) {
        zae zae2 = this.zak;
        if (zae2 != null) {
            if (zae2.isConnected() && z) {
                zae2.zaa();
            }
            zae2.disconnect();
            ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.zar);
            this.zao = null;
        }
    }
}
