package com.vungle.warren.network;

import androidx.annotation.Keep;
import com.google.gson.JsonObject;
import java.util.Map;

@Keep
public interface VungleApi {
    Call<JsonObject> ads(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> bustAnalytics(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> cacheBust(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> config(String str, JsonObject jsonObject);

    Call<Void> pingTPAT(String str, String str2);

    Call<JsonObject> reportAd(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> reportNew(String str, String str2, Map<String, String> map);

    /* renamed from: ri */
    Call<JsonObject> mo22127ri(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> sendLog(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject);
}
