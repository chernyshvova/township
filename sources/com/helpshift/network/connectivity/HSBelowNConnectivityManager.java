package com.helpshift.network.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.helpshift.util.HSLogger;

public class HSBelowNConnectivityManager extends BroadcastReceiver implements HSAndroidConnectivityManager {
    public static final String TAG = "Helpshift_BelowNConnMan";
    public Context context;
    public HSNetworkConnectivityCallback networkListener;

    /* renamed from: com.helpshift.network.connectivity.HSBelowNConnectivityManager$1 */
    public static /* synthetic */ class C26561 {

        /* renamed from: $SwitchMap$com$helpshift$network$connectivity$HSConnectivityStatus */
        public static final /* synthetic */ int[] f3343x93e38345;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.helpshift.network.connectivity.HSConnectivityStatus[] r0 = com.helpshift.network.connectivity.HSConnectivityStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3343x93e38345 = r0
                com.helpshift.network.connectivity.HSConnectivityStatus r1 = com.helpshift.network.connectivity.HSConnectivityStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f3343x93e38345     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.helpshift.network.connectivity.HSConnectivityStatus r1 = com.helpshift.network.connectivity.HSConnectivityStatus.NOT_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.network.connectivity.HSBelowNConnectivityManager.C26561.<clinit>():void");
        }
    }

    public HSBelowNConnectivityManager(Context context2) {
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

    @NonNull
    public HSConnectivityStatus getConnectivityStatus() {
        HSConnectivityStatus hSConnectivityStatus = HSConnectivityStatus.UNKNOWN;
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            return hSConnectivityStatus;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return HSConnectivityStatus.NOT_CONNECTED;
        }
        return HSConnectivityStatus.CONNECTED;
    }

    @NonNull
    public HSConnectivityType getConnectivityType() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            return HSConnectivityType.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return HSConnectivityType.UNKNOWN;
        }
        HSConnectivityType hSConnectivityType = HSConnectivityType.UNKNOWN;
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return HSConnectivityType.WIFI;
        }
        return type == 0 ? HSConnectivityType.MOBILE_DATA : hSConnectivityType;
    }

    public void onReceive(Context context2, Intent intent) {
        if (intent != null && intent.getExtras() != null && this.networkListener != null) {
            int ordinal = getConnectivityStatus().ordinal();
            if (ordinal == 1) {
                this.networkListener.onNetworkAvailable();
            } else if (ordinal == 2) {
                this.networkListener.onNetworkUnavailable();
            }
        }
    }

    public void startListeningConnectivityChange(HSNetworkConnectivityCallback hSNetworkConnectivityCallback) {
        this.networkListener = hSNetworkConnectivityCallback;
        try {
            this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception while registering network receiver", e);
        }
    }

    public void stopListeningConnectivityChange() {
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception while unregistering network receiver", e);
        }
    }
}
