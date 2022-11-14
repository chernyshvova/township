package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaaz implements zabo, zap {
    public final Map<Api.AnyClientKey<?>, Api.Client> zaa;
    public final Map<Api.AnyClientKey<?>, ConnectionResult> zab = new HashMap();
    public int zac;
    public final zaar zad;
    public final zabn zae;
    public final Lock zaf;
    public final Condition zag;
    public final Context zah;
    public final GoogleApiAvailabilityLight zai;
    public final zabb zaj;
    @Nullable
    public final ClientSettings zak;
    public final Map<Api<?>, Boolean> zal;
    @Nullable
    public final Api.AbstractClientBuilder<? extends zae, SignInOptions> zam;
    @NotOnlyInitialized
    public volatile zaaw zan;
    @Nullable
    public ConnectionResult zao = null;

    public zaaz(Context context, zaar zaar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, @Nullable ClientSettings clientSettings, Map<Api<?>, Boolean> map2, @Nullable Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zabn zabn) {
        this.zah = context;
        this.zaf = lock;
        this.zai = googleApiAvailabilityLight;
        this.zaa = map;
        this.zak = clientSettings;
        this.zal = map2;
        this.zam = abstractClientBuilder;
        this.zad = zaar;
        this.zae = zabn;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zaq zaq = arrayList.get(i);
            i++;
            zaq.zaa(this);
        }
        this.zaj = new zabb(this, looper);
        this.zag = lock.newCondition();
        this.zan = new zaao(this);
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaf.lock();
        try {
            this.zan.zaa(bundle);
        } finally {
            this.zaf.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zaf.lock();
        try {
            this.zan.zaa(i);
        } finally {
            this.zaf.unlock();
        }
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(@NonNull T t) {
        t.zab();
        return this.zan.zaa(t);
    }

    public final boolean zaa(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(@NonNull T t) {
        t.zab();
        return this.zan.zab(t);
    }

    @GuardedBy("mLock")
    public final void zac() {
        if (this.zan.zab()) {
            this.zab.clear();
        }
    }

    public final boolean zad() {
        return this.zan instanceof zaaa;
    }

    public final boolean zae() {
        return this.zan instanceof zaaf;
    }

    @GuardedBy("mLock")
    public final void zaf() {
        if (zad()) {
            ((zaaa) this.zan).zad();
        }
    }

    public final void zag() {
    }

    public final void zah() {
        this.zaf.lock();
        try {
            this.zan = new zaaf(this, this.zak, this.zal, this.zai, this.zam, this.zaf, this.zah);
            this.zan.zaa();
            this.zag.signalAll();
        } finally {
            this.zaf.unlock();
        }
    }

    public final void zai() {
        this.zaf.lock();
        try {
            this.zad.zab();
            this.zan = new zaaa(this);
            this.zan.zaa();
            this.zag.signalAll();
        } finally {
            this.zaf.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void zaa() {
        this.zan.zac();
    }

    @GuardedBy("mLock")
    public final ConnectionResult zab() {
        zaa();
        while (zae()) {
            try {
                this.zag.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (zad()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    public final ConnectionResult zaa(long j, TimeUnit timeUnit) {
        zaa();
        long nanos = timeUnit.toNanos(j);
        while (zae()) {
            if (nanos <= 0) {
                try {
                    zac();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zag.awaitNanos(nanos);
            }
        }
        if (zad()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    @Nullable
    public final ConnectionResult zaa(@NonNull Api<?> api) {
        Api.AnyClientKey<?> zac2 = api.zac();
        if (!this.zaa.containsKey(zac2)) {
            return null;
        }
        if (this.zaa.get(zac2).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zab.containsKey(zac2)) {
            return this.zab.get(zac2);
        }
        return null;
    }

    public final void zaa(@Nullable ConnectionResult connectionResult) {
        this.zaf.lock();
        try {
            this.zao = connectionResult;
            this.zan = new zaao(this);
            this.zan.zaa();
            this.zag.signalAll();
        } finally {
            this.zaf.unlock();
        }
    }

    public final void zaa(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z) {
        this.zaf.lock();
        try {
            this.zan.zaa(connectionResult, api, z);
        } finally {
            this.zaf.unlock();
        }
    }

    public final void zaa(zaay zaay) {
        this.zaj.sendMessage(this.zaj.obtainMessage(1, zaay));
    }

    public final void zaa(RuntimeException runtimeException) {
        this.zaj.sendMessage(this.zaj.obtainMessage(2, runtimeException));
    }

    public final void zaa(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zan);
        for (Api next : this.zal.keySet()) {
            printWriter.append(str).append(next.zad()).println(CertificateUtil.DELIMITER);
            ((Api.Client) Preconditions.checkNotNull(this.zaa.get(next.zac()))).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }
}
