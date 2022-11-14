package com.microsoft.appcenter.http;

import android.os.AsyncTask;
import com.microsoft.appcenter.http.DefaultHttpClientCallTask;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

public class DefaultHttpClient implements HttpClient, DefaultHttpClientCallTask.Tracker {
    public final boolean mCompressionEnabled;
    public final Set<DefaultHttpClientCallTask> mTasks = new HashSet();

    public DefaultHttpClient(boolean z) {
        this.mCompressionEnabled = z;
    }

    public ServiceCall callAsync(String str, String str2, Map<String, String> map, HttpClient.CallTemplate callTemplate, final ServiceCallback serviceCallback) {
        DefaultHttpClientCallTask defaultHttpClientCallTask = new DefaultHttpClientCallTask(str, str2, map, callTemplate, serviceCallback, this, this.mCompressionEnabled);
        try {
            defaultHttpClientCallTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (RejectedExecutionException e) {
            HandlerUtils.runOnUiThread(new Runnable(this) {
                public void run() {
                    serviceCallback.onCallFailed(e);
                }
            });
        }
        return new ServiceCall(this, defaultHttpClientCallTask) {
        };
    }

    public synchronized void close() {
        if (this.mTasks.size() > 0) {
            AppCenterLog.debug("AppCenter", "Cancelling " + this.mTasks.size() + " network call(s).");
            for (DefaultHttpClientCallTask cancel : this.mTasks) {
                cancel.cancel(true);
            }
            this.mTasks.clear();
        }
    }

    public void reopen() {
    }
}
