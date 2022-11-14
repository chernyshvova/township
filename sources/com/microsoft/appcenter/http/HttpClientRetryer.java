package com.microsoft.appcenter.http;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.microsoft.appcenter.http.HttpClient;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HttpClientRetryer extends HttpClientDecorator {
    @VisibleForTesting
    public static final long[] RETRY_INTERVALS = {TimeUnit.SECONDS.toMillis(10), TimeUnit.MINUTES.toMillis(5), TimeUnit.MINUTES.toMillis(20)};
    public final Handler mHandler;
    public final Random mRandom = new Random();

    public class RetryableCall extends HttpClientCallDecorator {
        public int mRetryCount;

        public RetryableCall(HttpClient httpClient, String str, String str2, Map<String, String> map, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
            super(httpClient, str, str2, map, callTemplate, serviceCallback);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
            r0 = ((com.microsoft.appcenter.http.HttpException) r6).mHttpResponse.headers.get("x-ms-retry-after-ms");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCallFailed(java.lang.Exception r6) {
            /*
                r5 = this;
                int r0 = r5.mRetryCount
                long[] r1 = com.microsoft.appcenter.http.HttpClientRetryer.RETRY_INTERVALS
                int r1 = r1.length
                if (r0 >= r1) goto L_0x0079
                boolean r0 = com.microsoft.appcenter.http.HttpUtils.isRecoverableError(r6)
                if (r0 == 0) goto L_0x0079
                boolean r0 = r6 instanceof com.microsoft.appcenter.http.HttpException
                r1 = 0
                if (r0 == 0) goto L_0x0029
                r0 = r6
                com.microsoft.appcenter.http.HttpException r0 = (com.microsoft.appcenter.http.HttpException) r0
                com.microsoft.appcenter.http.HttpResponse r0 = r0.mHttpResponse
                java.util.Map<java.lang.String, java.lang.String> r0 = r0.headers
                java.lang.String r3 = "x-ms-retry-after-ms"
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 == 0) goto L_0x0029
                long r3 = java.lang.Long.parseLong(r0)
                goto L_0x002a
            L_0x0029:
                r3 = r1
            L_0x002a:
                int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0046
                long[] r0 = com.microsoft.appcenter.http.HttpClientRetryer.RETRY_INTERVALS
                int r1 = r5.mRetryCount
                int r2 = r1 + 1
                r5.mRetryCount = r2
                r1 = r0[r1]
                r3 = 2
                long r1 = r1 / r3
                com.microsoft.appcenter.http.HttpClientRetryer r0 = com.microsoft.appcenter.http.HttpClientRetryer.this
                java.util.Random r0 = r0.mRandom
                int r3 = (int) r1
                int r0 = r0.nextInt(r3)
                long r3 = (long) r0
                long r3 = r3 + r1
            L_0x0046:
                java.lang.String r0 = "Try #"
                java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
                int r1 = r5.mRetryCount
                r0.append(r1)
                java.lang.String r1 = " failed and will be retried in "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " ms"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                boolean r1 = r6 instanceof java.net.UnknownHostException
                if (r1 == 0) goto L_0x006c
                java.lang.String r1 = " (UnknownHostException)"
                java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r0, r1)
            L_0x006c:
                java.lang.String r1 = "AppCenter"
                com.microsoft.appcenter.utils.AppCenterLog.warn(r1, r0, r6)
                com.microsoft.appcenter.http.HttpClientRetryer r6 = com.microsoft.appcenter.http.HttpClientRetryer.this
                android.os.Handler r6 = r6.mHandler
                r6.postDelayed(r5, r3)
                goto L_0x007e
            L_0x0079:
                com.microsoft.appcenter.http.ServiceCallback r0 = r5.mServiceCallback
                r0.onCallFailed(r6)
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpClientRetryer.RetryableCall.onCallFailed(java.lang.Exception):void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientRetryer(HttpClient httpClient) {
        super(httpClient);
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
    }

    public ServiceCall callAsync(String str, String str2, Map<String, String> map, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
        RetryableCall retryableCall = new RetryableCall(this.mDecoratedApi, str, str2, map, callTemplate, serviceCallback);
        retryableCall.run();
        return retryableCall;
    }
}
