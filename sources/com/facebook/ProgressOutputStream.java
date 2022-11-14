package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.FileLruCache;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressOutputStream.kt */
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    public long batchProgress;
    public RequestProgress currentRequestProgress;
    public long lastReportedProgress;
    public final long maxProgress;
    public final Map<GraphRequest, RequestProgress> progressMap;
    public final GraphRequestBatch requests;
    public final long threshold = FacebookSdk.getOnProgressThreshold();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        Intrinsics.checkNotNullParameter(outputStream, "out");
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        Intrinsics.checkNotNullParameter(map, "progressMap");
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
    }

    private final void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j);
        }
        long j2 = this.batchProgress + j;
        this.batchProgress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private final void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback next : this.requests.getCallbacks()) {
                if (next instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    if ((callbackHandler == null ? null : Boolean.valueOf(callbackHandler.post(new Runnable(this) {
                        public final /* synthetic */ ProgressOutputStream f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            ProgressOutputStream.m3541reportBatchProgress$lambda0(GraphRequestBatch.Callback.this, this.f$1);
                        }
                    }))) == null) {
                        ((GraphRequestBatch.OnProgressCallback) next).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    /* renamed from: reportBatchProgress$lambda-0  reason: not valid java name */
    public static final void m3541reportBatchProgress$lambda0(GraphRequestBatch.Callback callback, ProgressOutputStream progressOutputStream) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(progressOutputStream, "this$0");
        ((GraphRequestBatch.OnProgressCallback) callback).onBatchProgress(progressOutputStream.requests, progressOutputStream.getBatchProgress(), progressOutputStream.getMaxProgress());
    }

    public void close() throws IOException {
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
    }

    public final long getBatchProgress() {
        return this.batchProgress;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    public void write(byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, FileLruCache.BufferFile.FILE_NAME_PREFIX);
        this.out.write(bArr);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, FileLruCache.BufferFile.FILE_NAME_PREFIX);
        this.out.write(bArr, i, i2);
        addProgress((long) i2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        addProgress(1);
    }
}
