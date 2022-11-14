package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zas;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zah implements Handler.Callback {
    @NotOnlyInitialized
    public final zak zaa;
    public final ArrayList<GoogleApiClient.ConnectionCallbacks> zab = new ArrayList<>();
    @VisibleForTesting
    public final ArrayList<GoogleApiClient.ConnectionCallbacks> zac = new ArrayList<>();
    public final ArrayList<GoogleApiClient.OnConnectionFailedListener> zad = new ArrayList<>();
    public volatile boolean zae = false;
    public final AtomicInteger zaf = new AtomicInteger(0);
    public boolean zag = false;
    public final Handler zah;
    public final Object zai = new Object();

    public zah(Looper looper, zak zak) {
        this.zaa = zak;
        this.zah = new zas(looper, this);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.zai) {
                if (this.zae && this.zaa.isConnected() && this.zab.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zaa.getConnectionHint());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", GeneratedOutlineSupport.outline9(45, "Don't know how to handle message: ", i), new Exception());
        return false;
    }

    public final void zaa() {
        this.zae = false;
        this.zaf.incrementAndGet();
    }

    public final void zab() {
        this.zae = true;
    }

    public final void zac(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            if (!this.zab.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(valueOf.length() + 52);
                sb.append("unregisterConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            } else if (this.zag) {
                this.zac.add(connectionCallbacks);
            }
        }
    }

    public final boolean zab(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            contains = this.zab.contains(connectionCallbacks);
        }
        return contains;
    }

    @VisibleForTesting
    public final void zaa(@Nullable Bundle bundle) {
        Preconditions.checkHandlerThread(this.zah, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zai) {
            boolean z = true;
            Preconditions.checkState(!this.zag);
            this.zah.removeMessages(1);
            this.zag = true;
            if (this.zac.size() != 0) {
                z = false;
            }
            Preconditions.checkState(z);
            ArrayList arrayList = new ArrayList(this.zab);
            int i = this.zaf.get();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.zae || !this.zaa.isConnected() || this.zaf.get() != i) {
                    break;
                } else if (!this.zac.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zac.clear();
            this.zag = false;
        }
    }

    public final boolean zab(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            contains = this.zad.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public final void zac(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            if (!this.zad.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(valueOf.length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    @VisibleForTesting
    public final void zaa(int i) {
        Preconditions.checkHandlerThread(this.zah, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.zah.removeMessages(1);
        synchronized (this.zai) {
            this.zag = true;
            ArrayList arrayList = new ArrayList(this.zab);
            int i2 = this.zaf.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.zae || this.zaf.get() != i2) {
                    break;
                } else if (this.zab.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zac.clear();
            this.zag = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        return;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zaa(com.google.android.gms.common.ConnectionResult r8) {
        /*
            r7 = this;
            android.os.Handler r0 = r7.zah
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.Preconditions.checkHandlerThread(r0, r1)
            android.os.Handler r0 = r7.zah
            r1 = 1
            r0.removeMessages(r1)
            java.lang.Object r0 = r7.zai
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0049 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r7.zad     // Catch:{ all -> 0x0049 }
            r1.<init>(r2)     // Catch:{ all -> 0x0049 }
            java.util.concurrent.atomic.AtomicInteger r2 = r7.zaf     // Catch:{ all -> 0x0049 }
            int r2 = r2.get()     // Catch:{ all -> 0x0049 }
            int r3 = r1.size()     // Catch:{ all -> 0x0049 }
            r4 = 0
        L_0x0022:
            if (r4 >= r3) goto L_0x0047
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x0049 }
            int r4 = r4 + 1
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r5 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r5     // Catch:{ all -> 0x0049 }
            boolean r6 = r7.zae     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0045
            java.util.concurrent.atomic.AtomicInteger r6 = r7.zaf     // Catch:{ all -> 0x0049 }
            int r6 = r6.get()     // Catch:{ all -> 0x0049 }
            if (r6 == r2) goto L_0x0039
            goto L_0x0045
        L_0x0039:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r6 = r7.zad     // Catch:{ all -> 0x0049 }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0022
            r5.onConnectionFailed(r8)     // Catch:{ all -> 0x0049 }
            goto L_0x0022
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0049:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x004c:
            throw r8
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zah.zaa(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void zaa(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            if (this.zab.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(valueOf.length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.zab.add(connectionCallbacks);
            }
        }
        if (this.zaa.isConnected()) {
            Handler handler = this.zah;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void zaa(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            if (this.zad.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(valueOf.length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.zad.add(onConnectionFailedListener);
            }
        }
    }
}
