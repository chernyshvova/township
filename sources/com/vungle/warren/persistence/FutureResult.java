package com.vungle.warren.persistence;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureResult<T> implements Future<T> {
    public static final String TAG = FutureResult.class.getSimpleName();
    public final Future<T> future;

    public FutureResult(Future<T> future2) {
        this.future = future2;
    }

    public boolean cancel(boolean z) {
        return this.future.cancel(z);
    }

    @Nullable
    public T get() {
        try {
            return this.future.get();
        } catch (InterruptedException unused) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("future.get() Interrupted on Thread ");
            outline24.append(Thread.currentThread().getName());
            Log.w(str, outline24.toString());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Log.e(TAG, "error on execution", e);
            return null;
        }
    }

    public boolean isCancelled() {
        return this.future.isCancelled();
    }

    public boolean isDone() {
        return this.future.isDone();
    }

    @Nullable
    public T get(long j, @NonNull TimeUnit timeUnit) {
        try {
            return this.future.get(j, timeUnit);
        } catch (InterruptedException unused) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("future.get() Interrupted on Thread ");
            outline24.append(Thread.currentThread().getName());
            Log.w(str, outline24.toString());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Log.e(TAG, "error on execution", e);
            return null;
        } catch (TimeoutException unused2) {
            String str2 = TAG;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("future.get() Timeout on Thread ");
            outline242.append(Thread.currentThread().getName());
            Log.w(str2, outline242.toString());
            return null;
        }
    }
}
