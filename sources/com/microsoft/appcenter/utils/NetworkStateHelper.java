package com.microsoft.appcenter.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetworkStateHelper implements Closeable {
    @SuppressLint({"StaticFieldLeak"})
    public static NetworkStateHelper sSharedInstance;
    public final AtomicBoolean mConnected = new AtomicBoolean();
    public final ConnectivityManager mConnectivityManager;
    public final Set<Listener> mListeners = new CopyOnWriteArraySet();
    public ConnectivityManager.NetworkCallback mNetworkCallback;

    public interface Listener {
        void onNetworkStateUpdated(boolean z);
    }

    @VisibleForTesting
    public NetworkStateHelper(Context context) {
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            this.mNetworkCallback = new ConnectivityManager.NetworkCallback() {
                public void onAvailable(Network network) {
                    NetworkStateHelper networkStateHelper = NetworkStateHelper.this;
                    if (networkStateHelper != null) {
                        AppCenterLog.debug("AppCenter", "Network " + network + " is available.");
                        if (networkStateHelper.mConnected.compareAndSet(false, true)) {
                            networkStateHelper.notifyNetworkStateUpdated(true);
                            return;
                        }
                        return;
                    }
                    throw null;
                }

                /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
                /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onLost(android.net.Network r6) {
                    /*
                        r5 = this;
                        com.microsoft.appcenter.utils.NetworkStateHelper r0 = com.microsoft.appcenter.utils.NetworkStateHelper.this
                        if (r0 == 0) goto L_0x0048
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Network "
                        r1.append(r2)
                        r1.append(r6)
                        java.lang.String r2 = " is lost."
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        java.lang.String r2 = "AppCenter"
                        com.microsoft.appcenter.utils.AppCenterLog.debug(r2, r1)
                        android.net.ConnectivityManager r1 = r0.mConnectivityManager
                        android.net.Network[] r1 = r1.getAllNetworks()
                        r2 = 1
                        r3 = 0
                        if (r1 == 0) goto L_0x0039
                        int r4 = r1.length
                        if (r4 == 0) goto L_0x0039
                        android.net.Network[] r4 = new android.net.Network[r2]
                        r4[r3] = r6
                        boolean r6 = java.util.Arrays.equals(r1, r4)
                        if (r6 == 0) goto L_0x0037
                        goto L_0x0039
                    L_0x0037:
                        r6 = 0
                        goto L_0x003a
                    L_0x0039:
                        r6 = 1
                    L_0x003a:
                        if (r6 == 0) goto L_0x0047
                        java.util.concurrent.atomic.AtomicBoolean r6 = r0.mConnected
                        boolean r6 = r6.compareAndSet(r2, r3)
                        if (r6 == 0) goto L_0x0047
                        r0.notifyNetworkStateUpdated(r3)
                    L_0x0047:
                        return
                    L_0x0048:
                        r6 = 0
                        throw r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.NetworkStateHelper.C29721.onLost(android.net.Network):void");
                }
            };
            this.mConnectivityManager.registerNetworkCallback(builder.build(), this.mNetworkCallback);
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Cannot access network state information.", e);
            this.mConnected.set(true);
        }
    }

    public static synchronized NetworkStateHelper getSharedInstance(Context context) {
        NetworkStateHelper networkStateHelper;
        synchronized (NetworkStateHelper.class) {
            if (sSharedInstance == null) {
                sSharedInstance = new NetworkStateHelper(context);
            }
            networkStateHelper = sSharedInstance;
        }
        return networkStateHelper;
    }

    public void close() {
        this.mConnected.set(false);
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
    }

    public final void notifyNetworkStateUpdated(boolean z) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Network has been ");
        outline24.append(z ? "connected." : "disconnected.");
        AppCenterLog.debug("AppCenter", outline24.toString());
        for (Listener onNetworkStateUpdated : this.mListeners) {
            onNetworkStateUpdated.onNetworkStateUpdated(z);
        }
    }
}
