package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestProgress.kt */
public final class RequestProgress {
    public final Handler callbackHandler;
    public long lastReportedProgress;
    public long maxProgress;
    public long progress;
    public final GraphRequest request;
    public final long threshold = FacebookSdk.getOnProgressThreshold();

    public RequestProgress(Handler handler, GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        this.callbackHandler = handler;
        this.request = graphRequest;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
    }

    /* renamed from: reportProgress$lambda-0  reason: not valid java name */
    public static final void m3542reportProgress$lambda0(GraphRequest.Callback callback, long j, long j2) {
        ((GraphRequest.OnProgressCallback) callback).onProgress(j, j2);
    }

    public final void addProgress(long j) {
        long j2 = this.progress + j;
        this.progress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportProgress();
        }
    }

    public final void addToMax(long j) {
        this.maxProgress += j;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            GraphRequest.Callback callback = this.request.getCallback();
            long j = this.maxProgress;
            if (j > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                long j2 = this.progress;
                Handler handler = this.callbackHandler;
                if ((handler == null ? null : Boolean.valueOf(handler.post(new Runnable(j2, j) {
                    public final /* synthetic */ long f$1;
                    public final /* synthetic */ long f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r4;
                    }

                    public final void run() {
                        RequestProgress.m3542reportProgress$lambda0(GraphRequest.Callback.this, this.f$1, this.f$2);
                    }
                }))) == null) {
                    ((GraphRequest.OnProgressCallback) callback).onProgress(j2, j);
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
