package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaz {
    public final ApiKey<?> zaa;
    public final TaskCompletionSource<Boolean> zab = new TaskCompletionSource<>();

    public zaz(ApiKey<?> apiKey) {
        this.zaa = apiKey;
    }

    public final ApiKey<?> zaa() {
        return this.zaa;
    }

    public final TaskCompletionSource<Boolean> zab() {
        return this.zab;
    }
}
