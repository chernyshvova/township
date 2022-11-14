package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;

/* renamed from: com.appsflyer.internal.u */
public final class C1489u {

    /* renamed from: com.appsflyer.internal.u$a */
    public static final class C1490a {
        public final String AFInAppEventParameterName;
        public final String AFInAppEventType;
        public final String valueOf;

        public C1490a(@NonNull String str, @Nullable String str2, @Nullable String str3) {
            this.AFInAppEventType = str;
            this.valueOf = str2;
            this.AFInAppEventParameterName = str3;
        }
    }

    /* renamed from: com.appsflyer.internal.u$e */
    public static final class C1491e {
        public static final C1489u values = new C1489u();
    }

    public static boolean values(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static C1490a values(@NonNull Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "unknown";
        String str5 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                int i = 0;
                if (21 <= Build.VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i]);
                        if (!values(networkInfo)) {
                            i++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else if (!values(connectivityManager.getNetworkInfo(1))) {
                    if (!values(connectivityManager.getNetworkInfo(0))) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (values(activeNetworkInfo)) {
                            if (1 != activeNetworkInfo.getType()) {
                                if (activeNetworkInfo.getType() == 0) {
                                }
                            }
                        }
                    }
                    str4 = "MOBILE";
                }
                str4 = "WIFI";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager.getSimOperatorName();
            try {
                str2 = telephonyManager.getNetworkOperatorName();
                if ((str2 == null || str2.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str2 = "CDMA";
                }
            } catch (Throwable th) {
                th = th;
                String str6 = str;
                str3 = null;
                str5 = str6;
                AFLogger.values("Exception while collecting network info. ", th);
                String str7 = str3;
                str = str5;
                str2 = str7;
                return new C1490a(str4, str2, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = null;
            AFLogger.values("Exception while collecting network info. ", th);
            String str72 = str3;
            str = str5;
            str2 = str72;
            return new C1490a(str4, str2, str);
        }
        return new C1490a(str4, str2, str);
    }
}
