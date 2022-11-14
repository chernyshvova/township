package com.vungle.warren.network;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.List;
import okhttp3.Call;
import okhttp3.HttpUrl;

public class APIFactory {
    public static final String TAG = "APIFactory";
    public HttpUrl baseUrl;
    public Call.Factory okHttpClient;

    public APIFactory(@NonNull Call.Factory factory, @NonNull String str) {
        HttpUrl httpUrl = HttpUrl.get(str);
        this.baseUrl = httpUrl;
        this.okHttpClient = factory;
        List<String> list = httpUrl.pathSegments;
        if (!"".equals(list.get(list.size() - 1))) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("baseUrl must end in /: ", str));
        }
    }

    @NonNull
    public VungleApi createAPI() {
        return new VungleApiImpl(this.baseUrl, this.okHttpClient);
    }
}
