package com.vungle.warren.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.google.gson.JsonObject;
import com.vungle.warren.network.converters.Converter;
import com.vungle.warren.network.converters.EmptyResponseConverter;
import com.vungle.warren.network.converters.JsonConverter;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class VungleApiImpl implements VungleApi {
    public static final String CONFIG = "config";
    public static final Converter<ResponseBody, Void> emptyResponseConverter = new EmptyResponseConverter();
    public static final Converter<ResponseBody, JsonObject> jsonConverter = new JsonConverter();
    @VisibleForTesting
    public HttpUrl baseUrl;
    @VisibleForTesting
    public Call.Factory okHttpClient;

    public VungleApiImpl(@NonNull HttpUrl httpUrl, @NonNull Call.Factory factory) {
        this.baseUrl = httpUrl;
        this.okHttpClient = factory;
    }

    private <T> Call<T> createNewGetCall(String str, @NonNull String str2, @Nullable Map<String, String> map, Converter<ResponseBody, T> converter) {
        HttpUrl.Builder newBuilder = HttpUrl.get(str2).newBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str3 = (String) next.getKey();
                String str4 = (String) next.getValue();
                if (str3 != null) {
                    if (newBuilder.encodedQueryNamesAndValues == null) {
                        newBuilder.encodedQueryNamesAndValues = new ArrayList();
                    }
                    newBuilder.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str3, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                    newBuilder.encodedQueryNamesAndValues.add(str4 != null ? HttpUrl.canonicalize(str4, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                } else {
                    throw new NullPointerException("name == null");
                }
            }
        }
        Request.Builder defaultBuilder = defaultBuilder(str, newBuilder.build().url);
        defaultBuilder.method("GET", (RequestBody) null);
        return new OkHttpCall(((OkHttpClient) this.okHttpClient).newCall(defaultBuilder.build()), converter);
    }

    private Call<JsonObject> createNewPostCall(String str, @NonNull String str2, JsonObject jsonObject) {
        String jsonElement = jsonObject != null ? jsonObject.toString() : "";
        Request.Builder defaultBuilder = defaultBuilder(str, str2);
        defaultBuilder.method("POST", RequestBody.create((MediaType) null, jsonElement));
        return new OkHttpCall(((OkHttpClient) this.okHttpClient).newCall(defaultBuilder.build()), jsonConverter);
    }

    @NonNull
    private Request.Builder defaultBuilder(@NonNull String str, @NonNull String str2) {
        Request.Builder builder = new Request.Builder();
        builder.url(str2);
        builder.addHeader(GraphRequest.USER_AGENT_HEADER, str);
        builder.addHeader("Vungle-Version", "5.10.0");
        builder.addHeader("Content-Type", "application/json");
        return builder;
    }

    public Call<JsonObject> ads(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> bustAnalytics(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> cacheBust(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> config(String str, JsonObject jsonObject) {
        return createNewPostCall(str, GeneratedOutlineSupport.outline18(new StringBuilder(), this.baseUrl.url, CONFIG), jsonObject);
    }

    public Call<Void> pingTPAT(String str, String str2) {
        return createNewGetCall(str, str2, (Map<String, String>) null, emptyResponseConverter);
    }

    public Call<JsonObject> reportAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> reportNew(String str, String str2, Map<String, String> map) {
        return createNewGetCall(str, str2, map, jsonConverter);
    }

    /* renamed from: ri */
    public Call<JsonObject> mo22127ri(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> sendLog(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }
}
