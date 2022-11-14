package com.iab.omid.library.applovin.walking.p049a;

import com.iab.omid.library.applovin.walking.p049a.C2874b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.applovin.walking.a.c */
public class C2877c implements C2874b.C2875a {

    /* renamed from: a */
    public final BlockingQueue<Runnable> f3477a = new LinkedBlockingQueue();

    /* renamed from: b */
    public final ThreadPoolExecutor f3478b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f3477a);

    /* renamed from: c */
    public final ArrayDeque<C2874b> f3479c = new ArrayDeque<>();

    /* renamed from: d */
    public C2874b f3480d = null;

    /* renamed from: a */
    private void m3466a() {
        C2874b poll = this.f3479c.poll();
        this.f3480d = poll;
        if (poll != null) {
            poll.mo36814a(this.f3478b);
        }
    }

    /* renamed from: a */
    public void mo36816a(C2874b bVar) {
        this.f3480d = null;
        m3466a();
    }

    /* renamed from: b */
    public void mo36819b(C2874b bVar) {
        bVar.mo36812a((C2874b.C2875a) this);
        this.f3479c.add(bVar);
        if (this.f3480d == null) {
            m3466a();
        }
    }
}
