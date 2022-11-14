package com.facebook;

import android.os.Handler;
import com.android.billingclient.api.zzam;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphRequestBatch.kt */
public final class GraphRequestBatch extends AbstractList<GraphRequest> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final AtomicInteger idGenerator = new AtomicInteger();
    public String batchApplicationId;
    public Handler callbackHandler;
    public List<Callback> callbacks;

    /* renamed from: id */
    public final String f2749id;
    public List<GraphRequest> requests;
    public int timeoutInMilliseconds;

    /* compiled from: GraphRequestBatch.kt */
    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    /* compiled from: GraphRequestBatch.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GraphRequestBatch.kt */
    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    public GraphRequestBatch() {
        this.f2749id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    private final List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.Companion.executeBatchAndWait(this);
    }

    private final GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.Companion.executeBatchAsync(this);
    }

    public final void addCallback(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
    }

    public void clear() {
        this.requests.clear();
    }

    public /* bridge */ boolean contains(GraphRequest graphRequest) {
        return super.contains(graphRequest);
    }

    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    public final String getId() {
        return this.f2749id;
    }

    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    public int getSize() {
        return this.requests.size();
    }

    public final int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public /* bridge */ int indexOf(GraphRequest graphRequest) {
        return super.indexOf(graphRequest);
    }

    public /* bridge */ int lastIndexOf(GraphRequest graphRequest) {
        return super.lastIndexOf(graphRequest);
    }

    public final /* bridge */ GraphRequest remove(int i) {
        return removeAt(i);
    }

    public GraphRequest removeAt(int i) {
        return this.requests.remove(i);
    }

    public final void removeCallback(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback);
    }

    public final void setBatchApplicationId(String str) {
        this.batchApplicationId = str;
    }

    public final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    public final void setTimeout(int i) {
        if (i >= 0) {
            this.timeoutInMilliseconds = i;
            return;
        }
        throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.".toString());
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return false;
        }
        return contains((GraphRequest) obj);
    }

    public GraphRequest get(int i) {
        return this.requests.get(i);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return -1;
        }
        return indexOf((GraphRequest) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return -1;
        }
        return lastIndexOf((GraphRequest) obj);
    }

    public GraphRequest set(int i, GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "element");
        return this.requests.set(i, graphRequest);
    }

    public boolean add(GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "element");
        return this.requests.add(graphRequest);
    }

    public /* bridge */ boolean remove(GraphRequest graphRequest) {
        return super.remove(graphRequest);
    }

    public void add(int i, GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "element");
        this.requests.add(i, graphRequest);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return false;
        }
        return remove((GraphRequest) obj);
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        Intrinsics.checkNotNullParameter(collection, "requests");
        this.f2749id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
        this.f2749id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(zzam.asList(graphRequestArr));
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        this.f2749id = String.valueOf(idGenerator.incrementAndGet());
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
    }
}
