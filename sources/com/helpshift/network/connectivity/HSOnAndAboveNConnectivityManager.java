package com.helpshift.network.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.helpshift.util.HSLogger;

@RequiresApi(api = 24)
public class HSOnAndAboveNConnectivityManager extends ConnectivityManager.NetworkCallback implements HSAndroidConnectivityManager {
    public static final String TAG = "Helpshift_AboveNConnMan";
    public Context context;
    public HSNetworkConnectivityCallback networkListener;

    public HSOnAndAboveNConnectivityManager(Context context2) {
        this.context = context2;
    }

    private ConnectivityManager getConnectivityManager() {
        try {
            return (ConnectivityManager) this.context.getSystemService("connectivity");
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception while getting connectivity manager", e);
            return null;
        }
    }

    private TelephonyManager getTelephonyManager() {
        try {
            return (TelephonyManager) this.context.getSystemService("phone");
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception while getting telephony manager", e);
            return null;
        }
    }

    @RequiresApi(api = 24)
    @NonNull
    public HSConnectivityStatus getConnectivityStatus() {
        HSConnectivityStatus hSConnectivityStatus = HSConnectivityStatus.UNKNOWN;
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            return hSConnectivityStatus;
        }
        if (connectivityManager.getActiveNetwork() != null) {
            return HSConnectivityStatus.CONNECTED;
        }
        return HSConnectivityStatus.NOT_CONNECTED;
    }

    @NonNull
    public HSConnectivityType getConnectivityType() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            return HSConnectivityType.UNKNOWN;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return HSConnectivityType.UNKNOWN;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            return HSConnectivityType.UNKNOWN;
        }
        HSConnectivityType hSConnectivityType = HSConnectivityType.UNKNOWN;
        if (networkCapabilities.hasTransport(1)) {
            return HSConnectivityType.WIFI;
        }
        return networkCapabilities.hasTransport(0) ? HSConnectivityType.MOBILE_DATA : hSConnectivityType;
    }

    public void onAvailable(@NonNull Network network) {
        HSNetworkConnectivityCallback hSNetworkConnectivityCallback = this.networkListener;
        if (hSNetworkConnectivityCallback != null) {
            hSNetworkConnectivityCallback.onNetworkAvailable();
        }
    }

    public void onLost(@NonNull Network network) {
        HSNetworkConnectivityCallback hSNetworkConnectivityCallback = this.networkListener;
        if (hSNetworkConnectivityCallback != null) {
            hSNetworkConnectivityCallback.onNetworkUnavailable();
        }
    }

    public void onUnavailable() {
        HSNetworkConnectivityCallback hSNetworkConnectivityCallback = this.networkListener;
        if (hSNetworkConnectivityCallback != null) {
            hSNetworkConnectivityCallback.onNetworkUnavailable();
        }
    }

    @RequiresApi(api = 24)
    public void startListeningConnectivityChange(HSNetworkConnectivityCallback hSNetworkConnectivityCallback) {
        this.networkListener = hSNetworkConnectivityCallback;
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(this);
            } catch (Exception e) {
                HSLogger.m3242e(TAG, "Exception while registering network callback", e);
            }
        }
        if (getConnectivityStatus() == HSConnectivityStatus.NOT_CONNECTED) {
            hSNetworkConnectivityCallback.onNetworkUnavailable();
        }
    }

    @RequiresApi(api = 24)
    public void stopListeningConnectivityChange() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this);
            } catch (Exception e) {
                HSLogger.m3242e(TAG, "Exception while unregistering network callback", e);
            }
        }
        this.networkListener = null;
    }
}
