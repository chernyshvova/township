package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {

    /* renamed from: a */
    public final Context f521a;

    /* renamed from: b */
    public final ScheduledThreadPoolExecutor f522b;

    /* renamed from: c */
    public final Map<String, Queue<CommunicatorMessageImpl>> f523c = new HashMap();

    /* renamed from: d */
    public final Object f524d = new Object();

    public MessagingServiceImpl(Context context) {
        this.f521a = context;
        this.f522b = m611a();
    }

    /* renamed from: a */
    private Queue<CommunicatorMessageImpl> m610a(String str) {
        LinkedList linkedList;
        synchronized (this.f524d) {
            Queue queue = this.f523c.get(str);
            linkedList = queue != null ? new LinkedList(queue) : new LinkedList();
        }
        return linkedList;
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m611a() {
        return new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:com.applovin.communicator");
                thread.setPriority(10);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    /* renamed from: a */
    private void m612a(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (appLovinCommunicatorMessage.sticky) {
            synchronized (this.f524d) {
                Queue queue = this.f523c.get(appLovinCommunicatorMessage.getTopic());
                if (queue != null) {
                    queue.add(appLovinCommunicatorMessage);
                    if (queue.size() > 100) {
                        queue.remove();
                    }
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(appLovinCommunicatorMessage);
                    this.f523c.put(appLovinCommunicatorMessage.getTopic(), linkedList);
                }
            }
        }
    }

    /* renamed from: a */
    private void m613a(final CommunicatorMessageImpl communicatorMessageImpl) {
        this.f522b.execute(new Runnable() {
            public void run() {
                AppLovinBroadcastManager.getInstance(MessagingServiceImpl.this.f521a).sendBroadcastSync(communicatorMessageImpl, (Map<String, Object>) null);
            }
        });
    }

    public void maybeFlushStickyMessages(String str) {
        for (CommunicatorMessageImpl a : m610a(str)) {
            m613a(a);
        }
    }

    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        m613a((CommunicatorMessageImpl) appLovinCommunicatorMessage);
        m612a(appLovinCommunicatorMessage);
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }
}
