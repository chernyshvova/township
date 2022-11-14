package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class AvailabilityException extends Exception {
    public final ArrayMap<ApiKey<?>, ConnectionResult> zaa;

    public AvailabilityException(@RecentlyNonNull ArrayMap<ApiKey<?>, ConnectionResult> arrayMap) {
        this.zaa = arrayMap;
    }

    @NonNull
    public ConnectionResult getConnectionResult(@RecentlyNonNull GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        boolean z = this.zaa.get(apiKey) != null;
        String zaa2 = apiKey.zaa();
        StringBuilder sb = new StringBuilder(String.valueOf(zaa2).length() + 58);
        sb.append("The given API (");
        sb.append(zaa2);
        sb.append(") was not part of the availability request.");
        Preconditions.checkArgument(z, sb.toString());
        return (ConnectionResult) Preconditions.checkNotNull(this.zaa.get(apiKey));
    }

    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (ApiKey next : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull(this.zaa.get(next));
            if (connectionResult.isSuccess()) {
                z = false;
            }
            String zaa2 = next.zaa();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(zaa2).length() + 2);
            sb.append(zaa2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join(RESTClient.SEMICOLON_SEPARATOR, arrayList));
        return sb2.toString();
    }

    @NonNull
    public ConnectionResult getConnectionResult(@RecentlyNonNull HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        boolean z = this.zaa.get(apiKey) != null;
        String zaa2 = apiKey.zaa();
        StringBuilder sb = new StringBuilder(String.valueOf(zaa2).length() + 58);
        sb.append("The given API (");
        sb.append(zaa2);
        sb.append(") was not part of the availability request.");
        Preconditions.checkArgument(z, sb.toString());
        return (ConnectionResult) Preconditions.checkNotNull(this.zaa.get(apiKey));
    }
}
