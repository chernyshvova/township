package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaj {
    public final ArrayMap<ApiKey<?>, ConnectionResult> zaa = new ArrayMap<>();
    public final ArrayMap<ApiKey<?>, String> zab = new ArrayMap<>();
    public final TaskCompletionSource<Map<ApiKey<?>, String>> zac = new TaskCompletionSource<>();
    public int zad;
    public boolean zae = false;

    public zaj(Iterable<? extends HasApiKey<?>> iterable) {
        for (HasApiKey apiKey : iterable) {
            this.zaa.put(apiKey.getApiKey(), null);
        }
        this.zad = this.zaa.keySet().size();
    }

    public final Set<ApiKey<?>> zaa() {
        return this.zaa.keySet();
    }

    public final Task<Map<ApiKey<?>, String>> zab() {
        return this.zac.getTask();
    }

    public final void zaa(ApiKey<?> apiKey, ConnectionResult connectionResult, @Nullable String str) {
        this.zaa.put(apiKey, connectionResult);
        this.zab.put(apiKey, str);
        this.zad--;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad != 0) {
            return;
        }
        if (this.zae) {
            this.zac.setException(new AvailabilityException(this.zaa));
            return;
        }
        this.zac.setResult(this.zab);
    }
}
