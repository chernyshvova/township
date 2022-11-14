package com.swrve.sdk;

import android.content.Context;
import org.json.JSONObject;

public interface SwrveSilentPushListener {
    void onSilentPush(Context context, JSONObject jSONObject);
}
