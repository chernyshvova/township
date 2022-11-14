package com.helpshift.network.connectivity;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class HSConnectivityManager implements HSNetworkConnectivityCallback {
    public static HSConnectivityManager instance;
    public Set<HSNetworkConnectivityCallback> connectivityCallbacks = Collections.synchronizedSet(new LinkedHashSet());
    public Context context;
    public HSAndroidConnectivityManager hsAndroidConnectivityManager;
    public HSAndroidConnectivityManagerProvider hsAndroidConnectivityManagerProvider;

    /* renamed from: com.helpshift.network.connectivity.HSConnectivityManager$1 */
    public static /* synthetic */ class C26571 {

        /* renamed from: $SwitchMap$com$helpshift$network$connectivity$HSConnectivityStatus */
        public static final /* synthetic */ int[] f3344x93e38345;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.helpshift.network.connectivity.HSConnectivityStatus[] r0 = com.helpshift.network.connectivity.HSConnectivityStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3344x93e38345 = r0
                com.helpshift.network.connectivity.HSConnectivityStatus r1 = com.helpshift.network.connectivity.HSConnectivityStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f3344x93e38345     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.helpshift.network.connectivity.HSConnectivityStatus r1 = com.helpshift.network.connectivity.HSConnectivityStatus.NOT_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.network.connectivity.HSConnectivityManager.C26571.<clinit>():void");
        }
    }

    public HSConnectivityManager(Context context2) {
        this.context = context2;
        this.hsAndroidConnectivityManagerProvider = new HSAndroidConnectivityManagerProvider();
    }

    public static HSConnectivityManager getInstance(Context context2) {
        if (instance == null) {
            instance = new HSConnectivityManager(context2);
        }
        return instance;
    }

    private void startListenNetworkStatus() {
        if (this.hsAndroidConnectivityManager == null) {
            this.hsAndroidConnectivityManager = this.hsAndroidConnectivityManagerProvider.getOSConnectivityManager(this.context);
        }
        this.hsAndroidConnectivityManager.startListeningConnectivityChange(this);
    }

    private void stopListenNetworkStatus() {
        HSAndroidConnectivityManager hSAndroidConnectivityManager = this.hsAndroidConnectivityManager;
        if (hSAndroidConnectivityManager != null) {
            hSAndroidConnectivityManager.stopListeningConnectivityChange();
            this.hsAndroidConnectivityManager = null;
        }
    }

    public HSConnectivityType getConnectivityType() {
        if (this.hsAndroidConnectivityManager == null) {
            this.hsAndroidConnectivityManager = this.hsAndroidConnectivityManagerProvider.getOSConnectivityManager(this.context);
        }
        return this.hsAndroidConnectivityManager.getConnectivityType();
    }

    public void onNetworkAvailable() {
        if (!this.connectivityCallbacks.isEmpty()) {
            for (HSNetworkConnectivityCallback onNetworkAvailable : this.connectivityCallbacks) {
                onNetworkAvailable.onNetworkAvailable();
            }
        }
    }

    public void onNetworkUnavailable() {
        if (!this.connectivityCallbacks.isEmpty()) {
            for (HSNetworkConnectivityCallback onNetworkUnavailable : this.connectivityCallbacks) {
                onNetworkUnavailable.onNetworkUnavailable();
            }
        }
    }

    public synchronized void registerNetworkConnectivityListener(@NonNull HSNetworkConnectivityCallback hSNetworkConnectivityCallback) {
        boolean isEmpty = this.connectivityCallbacks.isEmpty();
        this.connectivityCallbacks.add(hSNetworkConnectivityCallback);
        if (isEmpty) {
            startListenNetworkStatus();
        } else {
            int ordinal = this.hsAndroidConnectivityManager.getConnectivityStatus().ordinal();
            if (ordinal == 1) {
                hSNetworkConnectivityCallback.onNetworkAvailable();
            } else if (ordinal == 2) {
                hSNetworkConnectivityCallback.onNetworkUnavailable();
            }
        }
    }

    public synchronized void unregisterNetworkConnectivityListener(@NonNull HSNetworkConnectivityCallback hSNetworkConnectivityCallback) {
        this.connectivityCallbacks.remove(hSNetworkConnectivityCallback);
        if (this.connectivityCallbacks.isEmpty()) {
            stopListenNetworkStatus();
        }
    }
}
