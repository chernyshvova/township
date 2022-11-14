package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphRequestAsyncTask.kt */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<? extends GraphResponse>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    public final HttpURLConnection connection;
    public Exception exception;
    public final GraphRequestBatch requests;

    /* compiled from: GraphRequestAsyncTask.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        this.connection = httpURLConnection;
        this.requests = graphRequestBatch;
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground((Void[]) objArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Exception getException() {
        return this.exception;
    }

    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                onPostExecute((List<GraphResponse>) (List) obj);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @VisibleForTesting(otherwise = 4)
    public void onPreExecute() {
        Handler handler;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onPreExecute();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.isDebugEnabled()) {
                    Utility utility = Utility.INSTANCE;
                    String str = TAG;
                    String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    Utility.logd(str, format);
                }
                if (this.requests.getCallbackHandler() == null) {
                    if (Thread.currentThread() instanceof HandlerThread) {
                        handler = new Handler();
                    } else {
                        handler = new Handler(Looper.getMainLooper());
                    }
                    this.requests.setCallbackHandler(handler);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public String toString() {
        StringBuilder outline26 = GeneratedOutlineSupport.outline26("{RequestAsyncTask: ", " connection: ");
        outline26.append(this.connection);
        outline26.append(", requests: ");
        outline26.append(this.requests);
        outline26.append("}");
        String sb = outline26.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return sb;
    }

    @VisibleForTesting(otherwise = 4)
    public List<GraphResponse> doInBackground(Void... voidArr) {
        List<GraphResponse> executeConnectionAndWait;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(voidArr, NativeProtocol.WEB_DIALOG_PARAMS);
            if (this.connection == null) {
                executeConnectionAndWait = this.requests.executeAndWait();
            } else {
                executeConnectionAndWait = GraphRequest.Companion.executeConnectionAndWait(this.connection, this.requests);
            }
            return executeConnectionAndWait;
        } catch (Exception e) {
            this.exception = e;
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void onPostExecute(List<GraphResponse> list) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(list, "result");
                super.onPostExecute(list);
                Exception exc = this.exception;
                if (exc != null) {
                    Utility utility = Utility.INSTANCE;
                    String str = TAG;
                    String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    Utility.logd(str, format);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(graphRequestArr, graphRequestArr.length)));
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
        Intrinsics.checkNotNullParameter(collection, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(graphRequestArr, graphRequestArr.length)));
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
        Intrinsics.checkNotNullParameter(collection, "requests");
    }
}
