package com.facebook;

import com.facebook.GraphRequest;
import com.helpshift.analytics.AnalyticsEventKey;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GraphRequest.kt */
public final class GraphRequest$Companion$newMyFriendsRequest$wrapper$1 implements GraphRequest.Callback {
    public final /* synthetic */ GraphRequest.GraphJSONArrayCallback $callback;

    public GraphRequest$Companion$newMyFriendsRequest$wrapper$1(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.$callback = graphJSONArrayCallback;
    }

    public void onCompleted(GraphResponse graphResponse) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        if (this.$callback != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                jSONArray = null;
            } else {
                jSONArray = jSONObject.optJSONArray("data");
            }
            this.$callback.onCompleted(jSONArray, graphResponse);
        }
    }
}
