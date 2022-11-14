package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.appsflyer.internal.av */
public abstract class C1428av<T> {
    public final FutureTask<T> AFInAppEventParameterName = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (C1428av.this.AFInAppEventParameterName()) {
                return C1428av.this.valueOf();
            }
            return null;
        }
    });
    public final String[] AFInAppEventType;
    public final String AFKeystoreWrapper;
    public final Context values;

    public C1428av(Context context, String str, String... strArr) {
        this.values = context;
        this.AFKeystoreWrapper = str;
        this.AFInAppEventType = strArr;
    }

    public final boolean AFInAppEventParameterName() {
        try {
            ProviderInfo resolveContentProvider = this.values.getPackageManager().resolveContentProvider(this.AFKeystoreWrapper, 128);
            if (resolveContentProvider == null || !Arrays.asList(this.AFInAppEventType).contains(C1381ac.valueOf(this.values.getPackageManager(), resolveContentProvider.packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.values(e.getMessage(), e);
            return false;
        }
    }

    @Nullable
    public T AFInAppEventType() {
        try {
            return this.AFInAppEventParameterName.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            AFLogger.values(e.getMessage(), e);
            return null;
        }
    }

    public abstract T valueOf();
}
