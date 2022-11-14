package com.facebook.appevents.internal;

import android.content.Context;
import com.android.billingclient.api.zzam;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.vungle.warren.log.LogEntry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventsLoggerUtility.kt */
public final class AppEventsLoggerUtility {
    public static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = zzam.hashMapOf(new Pair(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), new Pair(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));
    public static final AppEventsLoggerUtility INSTANCE = new AppEventsLoggerUtility();

    /* compiled from: AppEventsLoggerUtility.kt */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static final JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(graphAPIActivityType, "activityType");
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        String userID = AppEventsLogger.Companion.getUserID();
        if (userID != null) {
            jSONObject.put("app_user_id", userID);
        }
        Utility utility = Utility.INSTANCE;
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, str, z, context);
        try {
            Utility utility2 = Utility.INSTANCE;
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (Exception e) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        Utility utility3 = Utility.INSTANCE;
        JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
        if (dataProcessingOptions != null) {
            Iterator<String> keys = dataProcessingOptions.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, dataProcessingOptions.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
