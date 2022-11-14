package com.facebook;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AccessToken.kt */
public final class AccessToken$Companion$createFromNativeLinkingIntent$1 implements Utility.GraphMeRequestWithCacheCallback {
    public final /* synthetic */ AccessToken.AccessTokenCreationCallback $accessTokenCallback;
    public final /* synthetic */ String $applicationId;
    public final /* synthetic */ Bundle $extras;

    public AccessToken$Companion$createFromNativeLinkingIntent$1(Bundle bundle, AccessToken.AccessTokenCreationCallback accessTokenCreationCallback, String str) {
        this.$extras = bundle;
        this.$accessTokenCallback = accessTokenCreationCallback;
        this.$applicationId = str;
    }

    public void onFailure(FacebookException facebookException) {
        this.$accessTokenCallback.onError(facebookException);
    }

    public void onSuccess(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            str = null;
        } else {
            try {
                str = jSONObject.getString("id");
            } catch (Exception unused) {
                this.$accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                return;
            }
        }
        if (str != null) {
            this.$extras.putString("user_id", str);
            this.$accessTokenCallback.onSuccess(AccessToken.Companion.createFromBundle((List<String>) null, this.$extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), this.$applicationId));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
