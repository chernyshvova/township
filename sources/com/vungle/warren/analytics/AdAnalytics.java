package com.vungle.warren.analytics;

import androidx.annotation.NonNull;
import com.google.gson.JsonObject;

public interface AdAnalytics {
    String[] ping(@NonNull String[] strArr);

    String[] retryUnsent();

    /* renamed from: ri */
    void mo21860ri(JsonObject jsonObject);

    void saveVungleUrls(String[] strArr);
}
