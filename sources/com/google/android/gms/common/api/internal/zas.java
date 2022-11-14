package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zas implements zabo {
    public final Context zaa;
    public final zaar zab;
    public final Looper zac;
    public final zaaz zad;
    public final zaaz zae;
    public final Map<Api.AnyClientKey<?>, zaaz> zaf;
    public final Set<SignInConnectionListener> zag = Collections.newSetFromMap(new WeakHashMap());
    @Nullable
    public final Api.Client zah;
    @Nullable
    public Bundle zai;
    @Nullable
    public ConnectionResult zaj = null;
    @Nullable
    public ConnectionResult zak = null;
    public boolean zal = false;
    public final Lock zam;
    @GuardedBy("mLock")
    public int zan = 0;

    public zas(Context context, zaar zaar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, @Nullable Api.Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.zaa = context;
        zaar zaar2 = zaar;
        this.zab = zaar2;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zaaz zaaz = r3;
        zaaz zaaz2 = new zaaz(context2, zaar2, lock2, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends zae, SignInOptions>) null, arrayList2, new zau(this, (zar) null));
        this.zad = zaaz;
        this.zae = new zaaz(context2, this.zab, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zat(this, (zar) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            arrayMap.put(put, this.zad);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.zae);
        }
        this.zaf = Collections.unmodifiableMap(arrayMap);
    }

    public static zas zaa(Context context, zaar zaar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) next.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) next.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> zac2 = next2.zac();
            if (arrayMap.containsKey(zac2)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(zac2)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zaq zaq = arrayList.get(i);
            i++;
            zaq zaq2 = zaq;
            if (arrayMap3.containsKey(zaq2.zaa)) {
                arrayList2.add(zaq2);
            } else if (arrayMap4.containsKey(zaq2.zaa)) {
                arrayList3.add(zaq2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zas(context, zaar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zah() {
        ConnectionResult connectionResult;
        if (zab(this.zaj)) {
            if (zab(this.zak) || zaj()) {
                int i = this.zan;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.zan = 0;
                        return;
                    }
                    ((zaar) Preconditions.checkNotNull(this.zab)).zaa(this.zai);
                }
                zai();
                this.zan = 0;
                return;
            }
            ConnectionResult connectionResult2 = this.zak;
            if (connectionResult2 == null) {
                return;
            }
            if (this.zan == 1) {
                zai();
                return;
            }
            zaa(connectionResult2);
            this.zad.zac();
        } else if (this.zaj == null || !zab(this.zak)) {
            ConnectionResult connectionResult3 = this.zaj;
            if (connectionResult3 != null && (connectionResult = this.zak) != null) {
                if (this.zae.zac < this.zad.zac) {
                    connectionResult3 = connectionResult;
                }
                zaa(connectionResult3);
            }
        } else {
            this.zae.zac();
            zaa((ConnectionResult) Preconditions.checkNotNull(this.zaj));
        }
    }

    @GuardedBy("mLock")
    private final void zai() {
        for (SignInConnectionListener onComplete : this.zag) {
            onComplete.onComplete();
        }
        this.zag.clear();
    }

    @GuardedBy("mLock")
    private final boolean zaj() {
        ConnectionResult connectionResult = this.zak;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    @Nullable
    private final PendingIntent zak() {
        if (this.zah == null) {
            return null;
        }
        return PendingIntent.getActivity(this.zaa, System.identityHashCode(this.zab), this.zah.getSignInIntent(), 134217728);
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(@NonNull T t) {
        if (!zac((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zad.zab(t);
        }
        if (!zaj()) {
            return this.zae.zab(t);
        }
        t.setFailedResult(new Status(4, (String) null, zak()));
        return t;
    }

    @GuardedBy("mLock")
    public final void zac() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zac();
        this.zae.zac();
        zai();
    }

    public final boolean zad() {
        this.zam.lock();
        try {
            boolean z = true;
            if (!this.zad.zad() || (!this.zae.zad() && !zaj() && this.zan != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zae() {
        this.zam.lock();
        try {
            return this.zan == 2;
        } finally {
            this.zam.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void zaf() {
        this.zad.zaf();
        this.zae.zaf();
    }

    public final void zag() {
        this.zam.lock();
        try {
            boolean zae2 = zae();
            this.zae.zac();
            this.zak = new ConnectionResult(4);
            if (zae2) {
                new com.google.android.gms.internal.base.zas(this.zac).post(new zar(this));
            } else {
                zai();
            }
        } finally {
            this.zam.unlock();
        }
    }

    private final boolean zac(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        zaaz zaaz = this.zaf.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zaaz, "GoogleApiClient is not configured to use the API required for this call.");
        return zaaz.equals(this.zae);
    }

    @GuardedBy("mLock")
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    public static boolean zab(@Nullable ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(@NonNull T t) {
        if (!zac((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zad.zaa(t);
        }
        if (!zaj()) {
            return this.zae.zaa(t);
        }
        t.setFailedResult(new Status(4, (String) null, zak()));
        return t;
    }

    @GuardedBy("mLock")
    @Nullable
    public final ConnectionResult zaa(@NonNull Api<?> api) {
        if (!Objects.equal(this.zaf.get(api.zac()), this.zae)) {
            return this.zad.zaa(api);
        }
        if (zaj()) {
            return new ConnectionResult(4, zak());
        }
        return this.zae.zaa(api);
    }

    @GuardedBy("mLock")
    public final void zaa() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zaa();
        this.zae.zaa();
    }

    @GuardedBy("mLock")
    public final ConnectionResult zaa(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final boolean zaa(SignInConnectionListener signInConnectionListener) {
        this.zam.lock();
        try {
            if ((zae() || zad()) && !this.zae.zad()) {
                this.zag.add(signInConnectionListener);
                if (this.zan == 0) {
                    this.zan = 1;
                }
                this.zak = null;
                this.zae.zaa();
                return true;
            }
            this.zam.unlock();
            return false;
        } finally {
            this.zam.unlock();
        }
    }

    @GuardedBy("mLock")
    private final void zaa(ConnectionResult connectionResult) {
        int i = this.zan;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zan = 0;
            }
            this.zab.zaa(connectionResult);
        }
        zai();
        this.zan = 0;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaa(int i, boolean z) {
        this.zab.zaa(i, z);
        this.zak = null;
        this.zaj = null;
    }

    /* access modifiers changed from: private */
    public final void zaa(@Nullable Bundle bundle) {
        Bundle bundle2 = this.zai;
        if (bundle2 == null) {
            this.zai = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public final void zaa(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append(str).append("authClient").println(CertificateUtil.DELIMITER);
        this.zae.zaa(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(CertificateUtil.DELIMITER);
        this.zad.zaa(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
