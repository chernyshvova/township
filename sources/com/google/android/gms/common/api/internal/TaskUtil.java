package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class TaskUtil {
    @KeepForSdk
    public static void setResultOrApiException(@RecentlyNonNull Status status, @RecentlyNonNull TaskCompletionSource<Void> taskCompletionSource) {
        setResultOrApiException(status, (Object) null, taskCompletionSource);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static Task<Void> toVoidTaskThatFailsOnFalse(@RecentlyNonNull Task<Boolean> task) {
        return task.continueWith(new zacl());
    }

    @KeepForSdk
    public static <ResultT> boolean trySetResultOrApiException(@RecentlyNonNull Status status, @Nullable ResultT resultt, @RecentlyNonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            return taskCompletionSource.trySetResult(resultt);
        }
        return taskCompletionSource.trySetException(new ApiException(status));
    }

    @KeepForSdk
    public static <TResult> void setResultOrApiException(@RecentlyNonNull Status status, @Nullable TResult tresult, @RecentlyNonNull TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(tresult);
        } else {
            taskCompletionSource.setException(new ApiException(status));
        }
    }
}
