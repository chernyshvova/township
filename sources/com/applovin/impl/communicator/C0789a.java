package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.a */
public class C0789a {

    /* renamed from: a */
    public final Context f528a;

    /* renamed from: b */
    public final Set<C0790b> f529b = new HashSet(32);

    /* renamed from: c */
    public final Object f530c = new Object();

    public C0789a(Context context) {
        this.f528a = context;
    }

    /* renamed from: a */
    private C0790b m614a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (C0790b next : this.f529b) {
            if (str.equals(next.mo9738a()) && appLovinCommunicatorSubscriber.equals(next.mo9740b())) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9736a(com.applovin.communicator.AppLovinCommunicatorSubscriber r7, java.lang.String r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x006c
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r8)
            if (r0 != 0) goto L_0x0009
            goto L_0x006c
        L_0x0009:
            java.lang.Object r0 = r6.f530c
            monitor-enter(r0)
            com.applovin.impl.communicator.b r1 = r6.m614a((java.lang.String) r8, (com.applovin.communicator.AppLovinCommunicatorSubscriber) r7)     // Catch:{ all -> 0x0069 }
            r2 = 1
            if (r1 == 0) goto L_0x004f
            java.lang.String r3 = "AppLovinCommunicator"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "Attempting to re-subscribe subscriber ("
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = ") to topic ("
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            r4.append(r8)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = ")"
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0069 }
            com.applovin.impl.sdk.C1314v.m2663i(r3, r7)     // Catch:{ all -> 0x0069 }
            boolean r7 = r1.mo9741c()     // Catch:{ all -> 0x0069 }
            if (r7 != 0) goto L_0x004d
            r1.mo9739a(r2)     // Catch:{ all -> 0x0069 }
            android.content.Context r7 = r6.f528a     // Catch:{ all -> 0x0069 }
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)     // Catch:{ all -> 0x0069 }
            android.content.IntentFilter r3 = new android.content.IntentFilter     // Catch:{ all -> 0x0069 }
            r3.<init>(r8)     // Catch:{ all -> 0x0069 }
            r7.registerReceiver(r1, r3)     // Catch:{ all -> 0x0069 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r2
        L_0x004f:
            com.applovin.impl.communicator.b r1 = new com.applovin.impl.communicator.b     // Catch:{ all -> 0x0069 }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x0069 }
            java.util.Set<com.applovin.impl.communicator.b> r7 = r6.f529b     // Catch:{ all -> 0x0069 }
            r7.add(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            android.content.Context r7 = r6.f528a
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>(r8)
            r7.registerReceiver(r1, r0)
            return r2
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        L_0x006c:
            java.lang.String r0 = "AppLovinCommunicator"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to subscribe - invalid subscriber ("
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = ") or topic ("
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = ")"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.applovin.impl.sdk.C1314v.m2663i(r0, r7)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.communicator.C0789a.mo9736a(com.applovin.communicator.AppLovinCommunicatorSubscriber, java.lang.String):boolean");
    }

    /* renamed from: b */
    public void mo9737b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        C0790b a;
        if (StringUtils.isValidString(str)) {
            synchronized (this.f530c) {
                a = m614a(str, appLovinCommunicatorSubscriber);
            }
            if (a != null) {
                a.mo9739a(false);
                AppLovinBroadcastManager.getInstance(this.f528a).unregisterReceiver(a);
            }
        }
    }
}
