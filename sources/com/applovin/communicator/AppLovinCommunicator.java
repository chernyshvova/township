package com.applovin.communicator;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.communicator.C0789a;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import java.util.Collections;
import java.util.List;

public final class AppLovinCommunicator {

    /* renamed from: a */
    public static AppLovinCommunicator f52a;

    /* renamed from: b */
    public static final Object f53b = new Object();

    /* renamed from: c */
    public C1188m f54c;

    /* renamed from: d */
    public C1314v f55d;

    /* renamed from: e */
    public final C0789a f56e;

    /* renamed from: f */
    public final MessagingServiceImpl f57f;

    public AppLovinCommunicator(Context context) {
        this.f56e = new C0789a(context);
        this.f57f = new MessagingServiceImpl(context);
    }

    /* renamed from: a */
    private void m44a(String str) {
        C1314v vVar = this.f55d;
        if (vVar != null) {
            vVar.mo11372b("AppLovinCommunicator", str);
        }
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f53b) {
            if (f52a == null) {
                f52a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return f52a;
    }

    /* renamed from: a */
    public void mo9283a(C1188m mVar) {
        this.f54c = mVar;
        this.f55d = mVar.mo10922B();
        m44a("Attached SDK instance: " + mVar + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f57f;
    }

    public boolean respondsToTopic(String str) {
        return this.f54c.mo10969ag().mo10901a(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (this.f56e.mo9736a(appLovinCommunicatorSubscriber, next)) {
                this.f57f.maybeFlushStickyMessages(next);
            } else {
                m44a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + next);
            }
        }
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinCommunicator{sdk=");
        outline24.append(this.f54c);
        outline24.append('}');
        return outline24.toString();
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            m44a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + next);
            this.f56e.mo9737b(appLovinCommunicatorSubscriber, next);
        }
    }
}
