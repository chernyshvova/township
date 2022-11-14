package com.appsflyer.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.conversation.domainmodel.ConversationController;

/* renamed from: com.appsflyer.internal.v */
public final class C1492v {

    /* renamed from: com.appsflyer.internal.v$b */
    public static final class C1493b {
        public static final C1492v values = new C1492v();
    }

    public static boolean values(@NonNull Context context, @NonNull String[] strArr) {
        for (String values : strArr) {
            if (C1381ac.values(context, values)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final Location AFInAppEventType(@NonNull Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
            Location lastKnownLocation = values(context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) ? locationManager.getLastKnownLocation("network") : null;
            Location lastKnownLocation2 = values(context, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) ? locationManager.getLastKnownLocation("gps") : null;
            if (lastKnownLocation2 == null && lastKnownLocation == null) {
                lastKnownLocation = null;
            } else if (lastKnownLocation2 != null || lastKnownLocation == null) {
                if ((lastKnownLocation == null && lastKnownLocation2 != null) || ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT >= lastKnownLocation.getTime() - lastKnownLocation2.getTime()) {
                    lastKnownLocation = lastKnownLocation2;
                }
            }
            if (lastKnownLocation != null) {
                return lastKnownLocation;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
