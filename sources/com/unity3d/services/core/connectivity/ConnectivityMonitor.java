package com.unity3d.services.core.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectivityMonitor {
    public static int _connected = -1;
    public static Set<IConnectivityListener> _listeners = null;
    public static boolean _listening = false;
    public static int _networkType = -1;
    public static boolean _webappMonitoring = false;
    public static boolean _wifi = false;

    /* renamed from: com.unity3d.services.core.connectivity.ConnectivityMonitor$1 */
    public static /* synthetic */ class C18281 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$connectivity$ConnectivityEvent */
        public static final /* synthetic */ int[] f2842xede9def6;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.unity3d.services.core.connectivity.ConnectivityEvent[] r0 = com.unity3d.services.core.connectivity.ConnectivityEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2842xede9def6 = r0
                r1 = 1
                com.unity3d.services.core.connectivity.ConnectivityEvent r2 = com.unity3d.services.core.connectivity.ConnectivityEvent.CONNECTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2842xede9def6     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.unity3d.services.core.connectivity.ConnectivityEvent r3 = com.unity3d.services.core.connectivity.ConnectivityEvent.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2842xede9def6     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.core.connectivity.ConnectivityEvent r2 = com.unity3d.services.core.connectivity.ConnectivityEvent.NETWORK_CHANGE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.connectivity.ConnectivityMonitor.C18281.<clinit>():void");
        }
    }

    public static void addListener(IConnectivityListener iConnectivityListener) {
        if (_listeners == null) {
            _listeners = Collections.newSetFromMap(new ConcurrentHashMap());
        }
        _listeners.add(iConnectivityListener);
        updateListeningStatus();
    }

    public static void connected() {
        if (_connected != 1) {
            DeviceLog.debug("Unity Ads connectivity change: connected");
            initConnectionStatus();
            Set<IConnectivityListener> set = _listeners;
            if (set != null) {
                for (IConnectivityListener onConnected : set) {
                    onConnected.onConnected();
                }
            }
            sendToWebview(ConnectivityEvent.CONNECTED, _wifi, _networkType);
        }
    }

    public static void connectionStatusChanged() {
        NetworkInfo activeNetworkInfo;
        boolean z = true;
        if (_connected == 1 && (activeNetworkInfo = ((ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() != 1) {
                z = false;
            }
            int i = -1;
            try {
                i = ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
            } catch (SecurityException unused) {
                DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
            }
            boolean z2 = _wifi;
            if (z != z2 || (i != _networkType && !z2)) {
                _wifi = z;
                _networkType = i;
                DeviceLog.debug("Unity Ads connectivity change: network change");
                sendToWebview(ConnectivityEvent.NETWORK_CHANGE, z, i);
            }
        }
    }

    public static void disconnected() {
        if (_connected != 0) {
            _connected = 0;
            DeviceLog.debug("Unity Ads connectivity change: disconnected");
            Set<IConnectivityListener> set = _listeners;
            if (set != null) {
                for (IConnectivityListener onDisconnected : set) {
                    onDisconnected.onDisconnected();
                }
            }
            sendToWebview(ConnectivityEvent.DISCONNECTED, false, 0);
        }
    }

    public static void initConnectionStatus() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = false;
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                _connected = 0;
                return;
            }
            _connected = 1;
            if (activeNetworkInfo.getType() == 1) {
                z = true;
            }
            _wifi = z;
            if (!z) {
                try {
                    _networkType = ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
                } catch (SecurityException unused) {
                    DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
                }
            }
        }
    }

    public static void removeListener(IConnectivityListener iConnectivityListener) {
        Set<IConnectivityListener> set = _listeners;
        if (set != null) {
            set.remove(iConnectivityListener);
            updateListeningStatus();
        }
    }

    public static void sendToWebview(ConnectivityEvent connectivityEvent, boolean z, int i) {
        WebViewApp currentApp;
        if (_webappMonitoring && (currentApp = WebViewApp.getCurrentApp()) != null && currentApp.isWebAppLoaded()) {
            int ordinal = connectivityEvent.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.DISCONNECTED, new Object[0]);
                } else if (ordinal == 2) {
                    if (z) {
                        currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.NETWORK_CHANGE, Boolean.valueOf(z), 0);
                        return;
                    }
                    currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.NETWORK_CHANGE, Boolean.valueOf(z), Integer.valueOf(i));
                }
            } else if (z) {
                currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.CONNECTED, Boolean.valueOf(z), 0);
            } else {
                currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.CONNECTED, Boolean.valueOf(z), Integer.valueOf(i));
            }
        }
    }

    public static void setConnectionMonitoring(boolean z) {
        _webappMonitoring = z;
        updateListeningStatus();
    }

    public static void startListening() {
        if (!_listening) {
            _listening = true;
            initConnectionStatus();
            if (Build.VERSION.SDK_INT < 21) {
                ConnectivityChangeReceiver.register();
            } else {
                ConnectivityNetworkCallback.register();
            }
        }
    }

    public static void stopAll() {
        _listeners = null;
        _webappMonitoring = false;
        updateListeningStatus();
    }

    public static void stopListening() {
        if (_listening) {
            _listening = false;
            if (Build.VERSION.SDK_INT < 21) {
                ConnectivityChangeReceiver.unregister();
            } else {
                ConnectivityNetworkCallback.unregister();
            }
        }
    }

    public static void updateListeningStatus() {
        Set<IConnectivityListener> set;
        if (_webappMonitoring || ((set = _listeners) != null && !set.isEmpty())) {
            startListening();
        } else {
            stopListening();
        }
    }
}
