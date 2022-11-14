package com.facebook;

import android.os.Handler;
import com.facebook.internal.FileLruCache;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressNoopOutputStream.kt */
public final class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    public final Handler callbackHandler;
    public GraphRequest currentRequest;
    public RequestProgress currentRequestProgress;
    public int maxProgress;
    public final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    public ProgressNoopOutputStream(Handler handler) {
        this.callbackHandler = handler;
    }

    public final void addProgress(long j) {
        GraphRequest graphRequest = this.currentRequest;
        if (graphRequest != null) {
            if (this.currentRequestProgress == null) {
                RequestProgress requestProgress = new RequestProgress(this.callbackHandler, graphRequest);
                this.currentRequestProgress = requestProgress;
                this.progressMap.put(graphRequest, requestProgress);
            }
            RequestProgress requestProgress2 = this.currentRequestProgress;
            if (requestProgress2 != null) {
                requestProgress2.addToMax(j);
            }
            this.maxProgress += (int) j;
        }
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    public void write(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, FileLruCache.BufferFile.FILE_NAME_PREFIX);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, FileLruCache.BufferFile.FILE_NAME_PREFIX);
        addProgress((long) i2);
    }

    public void write(int i) {
        addProgress(1);
    }
}
