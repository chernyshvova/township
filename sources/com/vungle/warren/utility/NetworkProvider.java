package com.vungle.warren.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.PermissionChecker;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkProvider {
    public static NetworkProvider INSTANCE = null;
    public static final long NETWORK_CHECK_DELAY = 30000;
    public static final String TAG = "NetworkProvider";
    public static final int TYPE_NONE = -1;
    @Nullable

    /* renamed from: cm */
    public final ConnectivityManager f2851cm;
    public final Context ctx;
    public final AtomicInteger currentNetwork = new AtomicInteger();
    public boolean enabled;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public final Set<NetworkListener> listeners = new CopyOnWriteArraySet();
    public ConnectivityManager.NetworkCallback networkCallback;
    public Runnable typeRunnable = new Runnable() {
        public void run() {
            if (!NetworkProvider.this.listeners.isEmpty()) {
                NetworkProvider.this.onNetworkChanged();
                NetworkProvider.this.handler.postDelayed(NetworkProvider.this.typeRunnable, 30000);
            }
        }
    };

    public interface NetworkListener {
        void onChanged(int i);
    }

    public NetworkProvider(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.ctx = applicationContext;
        this.f2851cm = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        this.currentNetwork.set(getCurrentNetworkType());
    }

    public static synchronized NetworkProvider getInstance(Context context) {
        NetworkProvider networkProvider;
        synchronized (NetworkProvider.class) {
            if (INSTANCE == null) {
                INSTANCE = new NetworkProvider(context);
            }
            networkProvider = INSTANCE;
        }
        return networkProvider;
    }

    @SuppressLint({"newApi"})
    private ConnectivityManager.NetworkCallback getNetworkCallback() {
        ConnectivityManager.NetworkCallback networkCallback2 = this.networkCallback;
        if (networkCallback2 != null) {
            return networkCallback2;
        }
        C20501 r0 = new ConnectivityManager.NetworkCallback() {
            @RequiresApi(api = 21)
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NetworkProvider.this.onNetworkChanged();
            }

            @RequiresApi(api = 21)
            public void onLost(Network network) {
                super.onLost(network);
                NetworkProvider.this.onNetworkChanged();
            }
        };
        this.networkCallback = r0;
        return r0;
    }

    private void postToListeners(final int i) {
        this.handler.post(new Runnable() {
            public void run() {
                for (NetworkListener onChanged : NetworkProvider.this.listeners) {
                    onChanged.onChanged(i);
                }
            }
        });
    }

    @SuppressLint({"newApi"})
    private synchronized void setEnableNetworkListener(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            if (this.f2851cm != null) {
                if (z) {
                    try {
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        builder.addCapability(12);
                        this.f2851cm.registerNetworkCallback(builder.build(), getNetworkCallback());
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                    }
                } else {
                    this.f2851cm.unregisterNetworkCallback(getNetworkCallback());
                }
            }
        } else {
            return;
        }
        return;
    }

    public void addListener(NetworkListener networkListener) {
        this.listeners.add(networkListener);
        setEnableNetworkListener(true);
    }

    public int getCurrentNetworkType() {
        int i = -1;
        if (this.f2851cm == null || PermissionChecker.checkCallingOrSelfPermission(this.ctx, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            this.currentNetwork.set(-1);
            return -1;
        }
        NetworkInfo activeNetworkInfo = this.f2851cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            i = activeNetworkInfo.getType();
        }
        int andSet = this.currentNetwork.getAndSet(i);
        if (i != andSet) {
            String str = TAG;
            Log.d(str, "on network changed: " + andSet + "->" + i);
            postToListeners(i);
        }
        setEnableNetworkListener(!this.listeners.isEmpty());
        return i;
    }

    public void onNetworkChanged() {
        getCurrentNetworkType();
    }

    public void removeListener(NetworkListener networkListener) {
        this.listeners.remove(networkListener);
        setEnableNetworkListener(!this.listeners.isEmpty());
    }
}
