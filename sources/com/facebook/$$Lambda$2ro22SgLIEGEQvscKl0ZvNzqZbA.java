package com.facebook;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import org.json.JSONObject;

/* renamed from: com.facebook.-$$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA implements FacebookSdk.GraphRequestCreator {
    public static final /* synthetic */ $$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA INSTANCE = new $$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA();

    private /* synthetic */ $$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA() {
    }

    public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return FacebookSdk.m3528graphRequestCreator$lambda0(accessToken, str, jSONObject, callback);
    }
}
