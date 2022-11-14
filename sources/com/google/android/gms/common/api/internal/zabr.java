package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zao;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabr<T> implements OnCompleteListener<T> {
    public final GoogleApiManager zaa;
    public final int zab;
    public final ApiKey<?> zac;
    public final long zad;

    @VisibleForTesting
    public zabr(GoogleApiManager googleApiManager, int i, ApiKey<?> apiKey, long j) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
    }

    @Nullable
    public static ConnectionTelemetryConfiguration zaa(GoogleApiManager.zaa<?> zaa2, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = ((BaseGmsClient) zaa2.zab()).getTelemetryConfiguration();
        if (telemetryConfiguration != null) {
            boolean z = false;
            if (telemetryConfiguration.getMethodInvocationTelemetryEnabled() && ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) == null || ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i))) {
                z = true;
            }
            if (z && zaa2.zam() < telemetryConfiguration.getMaxMethodInvocationsLogged()) {
                return telemetryConfiguration;
            }
        }
        return null;
    }

    @WorkerThread
    public final void onComplete(@NonNull Task<T> task) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long j2;
        int i6;
        if (this.zaa.zad()) {
            boolean z = true;
            boolean z2 = this.zad > 0;
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if (config == null) {
                i3 = 5000;
                i2 = 0;
                i = 100;
            } else if (config.getMethodInvocationTelemetryEnabled()) {
                boolean methodTimingTelemetryEnabled = z2 & config.getMethodTimingTelemetryEnabled();
                i3 = config.getBatchPeriodMillis();
                int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                int version = config.getVersion();
                GoogleApiManager.zaa zaa2 = this.zaa.zaa(this.zac);
                if (zaa2 != null && zaa2.zab().isConnected() && (zaa2.zab() instanceof BaseGmsClient)) {
                    ConnectionTelemetryConfiguration zaa3 = zaa(zaa2, this.zab);
                    if (zaa3 != null) {
                        if (!zaa3.getMethodTimingTelemetryEnabled() || this.zad <= 0) {
                            z = false;
                        }
                        maxMethodInvocationsInBatch = zaa3.getMaxMethodInvocationsLogged();
                        methodTimingTelemetryEnabled = z;
                    } else {
                        return;
                    }
                }
                i2 = version;
                i = maxMethodInvocationsInBatch;
            } else {
                return;
            }
            GoogleApiManager googleApiManager = this.zaa;
            if (task.isSuccessful()) {
                i5 = 0;
                i4 = 0;
            } else {
                if (task.isCanceled()) {
                    i5 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        int statusCode = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult == null) {
                            i6 = -1;
                        } else {
                            i6 = connectionResult.getErrorCode();
                        }
                        i4 = i6;
                        i5 = statusCode;
                    } else {
                        i5 = 101;
                    }
                }
                i4 = -1;
            }
            if (z2) {
                j2 = this.zad;
                j = System.currentTimeMillis();
            } else {
                j2 = 0;
                j = 0;
            }
            googleApiManager.zaa(new zao(this.zab, i5, i4, j2, j), i2, (long) i3, i);
        }
    }

    @Nullable
    public static <T> zabr<T> zaa(GoogleApiManager googleApiManager, int i, ApiKey<?> apiKey) {
        if (!googleApiManager.zad()) {
            return null;
        }
        boolean z = true;
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null) {
            if (!config.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            z = config.getMethodTimingTelemetryEnabled();
            GoogleApiManager.zaa zaa2 = googleApiManager.zaa(apiKey);
            if (zaa2 != null && zaa2.zab().isConnected() && (zaa2.zab() instanceof BaseGmsClient)) {
                ConnectionTelemetryConfiguration zaa3 = zaa(zaa2, i);
                if (zaa3 == null) {
                    return null;
                }
                zaa2.zan();
                z = zaa3.getMethodTimingTelemetryEnabled();
            }
        }
        return new zabr(googleApiManager, i, apiKey, z ? System.currentTimeMillis() : 0);
    }
}
