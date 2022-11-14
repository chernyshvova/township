package com.swrve.sdk.conversations.engine.model;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.HashMap;

public class ControlActions implements Serializable {
    public static final Object CALL_ACTION = NotificationCompat.CATEGORY_CALL;
    public static final Object DEEPLINK_ACTION = "deeplink";
    public static final String DEEPLINK_URL_URI_KEY = "url";
    public static final Object VISIT_URL_ACTION = "visit";
    public static final String VISIT_URL_REFERER_KEY = "refer";
    public static final String VISIT_URL_URI_KEY = "url";
    public HashMap<String, Object> actionItems = new HashMap<>();

    public Uri getCallUri() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("tel:");
        outline24.append(this.actionItems.get(CALL_ACTION).toString());
        return Uri.parse(outline24.toString());
    }

    public HashMap<String, String> getDeepLinkDetails() {
        return (HashMap) this.actionItems.get(DEEPLINK_ACTION);
    }

    public HashMap<String, String> getVisitDetails() {
        return (HashMap) this.actionItems.get(VISIT_URL_ACTION);
    }

    public void includeAction(String str, Object obj) {
        this.actionItems.put(str, obj);
    }

    public boolean isCall() {
        return this.actionItems.containsKey(CALL_ACTION);
    }

    public boolean isDeepLink() {
        return this.actionItems.containsKey(DEEPLINK_ACTION);
    }

    public boolean isVisit() {
        return this.actionItems.containsKey(VISIT_URL_ACTION);
    }
}
