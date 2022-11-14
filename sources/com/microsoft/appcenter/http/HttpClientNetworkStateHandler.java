package com.microsoft.appcenter.http;

import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HttpClientNetworkStateHandler extends HttpClientDecorator implements NetworkStateHelper.Listener {
    public final Set<Call> mCalls = new HashSet();
    public final NetworkStateHelper mNetworkStateHelper;

    public class Call extends HttpClientCallDecorator {
        public Call(HttpClientNetworkStateHandler httpClientNetworkStateHandler, HttpClient httpClient, String str, String str2, Map<String, String> map, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
            super(httpClient, str, str2, map, callTemplate, serviceCallback);
        }
    }

    public HttpClientNetworkStateHandler(HttpClient httpClient, NetworkStateHelper networkStateHelper) {
        super(httpClient);
        this.mNetworkStateHelper = networkStateHelper;
        networkStateHelper.mListeners.add(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.microsoft.appcenter.http.ServiceCall callAsync(java.lang.String r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, com.microsoft.appcenter.http.HttpClient.CallTemplate r13, com.microsoft.appcenter.http.ServiceCallback r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call r8 = new com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call     // Catch:{ all -> 0x0056 }
            com.microsoft.appcenter.http.HttpClient r2 = r9.mDecoratedApi     // Catch:{ all -> 0x0056 }
            r0 = r8
            r1 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0056 }
            com.microsoft.appcenter.utils.NetworkStateHelper r10 = r9.mNetworkStateHelper     // Catch:{ all -> 0x0056 }
            java.util.concurrent.atomic.AtomicBoolean r11 = r10.mConnected     // Catch:{ all -> 0x0056 }
            boolean r11 = r11.get()     // Catch:{ all -> 0x0056 }
            r12 = 1
            r13 = 0
            if (r11 != 0) goto L_0x0042
            android.net.ConnectivityManager r11 = r10.mConnectivityManager     // Catch:{ all -> 0x0056 }
            android.net.Network[] r11 = r11.getAllNetworks()     // Catch:{ all -> 0x0056 }
            if (r11 != 0) goto L_0x0024
            goto L_0x003d
        L_0x0024:
            int r14 = r11.length     // Catch:{ all -> 0x0056 }
            r0 = 0
        L_0x0026:
            if (r0 >= r14) goto L_0x003d
            r1 = r11[r0]     // Catch:{ all -> 0x0056 }
            android.net.ConnectivityManager r2 = r10.mConnectivityManager     // Catch:{ all -> 0x0056 }
            android.net.NetworkInfo r1 = r2.getNetworkInfo(r1)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x003a
            boolean r1 = r1.isConnected()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x003a
            r10 = 1
            goto L_0x003e
        L_0x003a:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x003d:
            r10 = 0
        L_0x003e:
            if (r10 == 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r12 = 0
        L_0x0042:
            if (r12 == 0) goto L_0x0048
            r8.run()     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x0048:
            java.util.Set<com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call> r10 = r9.mCalls     // Catch:{ all -> 0x0056 }
            r10.add(r8)     // Catch:{ all -> 0x0056 }
            java.lang.String r10 = "AppCenter"
            java.lang.String r11 = "Call triggered with no network connectivity, waiting network to become available..."
            com.microsoft.appcenter.utils.AppCenterLog.debug(r10, r11)     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r9)
            return r8
        L_0x0056:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x005a
        L_0x0059:
            throw r10
        L_0x005a:
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpClientNetworkStateHandler.callAsync(java.lang.String, java.lang.String, java.util.Map, com.microsoft.appcenter.http.HttpClient$CallTemplate, com.microsoft.appcenter.http.ServiceCallback):com.microsoft.appcenter.http.ServiceCall");
    }

    public synchronized void close() throws IOException {
        this.mNetworkStateHelper.mListeners.remove(this);
        this.mCalls.clear();
        this.mDecoratedApi.close();
    }

    public synchronized void onNetworkStateUpdated(boolean z) {
        if (z) {
            if (this.mCalls.size() > 0) {
                AppCenterLog.debug("AppCenter", "Network is available. " + this.mCalls.size() + " pending call(s) to submit now.");
                for (Call run : this.mCalls) {
                    run.run();
                }
                this.mCalls.clear();
            }
        }
    }

    public void reopen() {
        this.mNetworkStateHelper.mListeners.add(this);
        this.mDecoratedApi.reopen();
    }
}
