package com.iab.omid.library.vungle.walking.p055a;

import com.iab.omid.library.vungle.walking.p055a.C2917b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.vungle.walking.a.c */
public class C2920c implements C2917b.C2918a {

    /* renamed from: a */
    public final BlockingQueue<Runnable> f3566a = new LinkedBlockingQueue();

    /* renamed from: b */
    public final ThreadPoolExecutor f3567b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f3566a);

    /* renamed from: c */
    public final ArrayDeque<C2917b> f3568c = new ArrayDeque<>();

    /* renamed from: d */
    public C2917b f3569d = null;

    /* renamed from: a */
    public final void mo36869a() {
        C2917b poll = this.f3568c.poll();
        this.f3569d = poll;
        if (poll != null) {
            poll.executeOnExecutor(this.f3567b, new Object[0]);
        }
    }

    /* renamed from: b */
    public void mo36870b(C2917b bVar) {
        bVar.f3564a = this;
        this.f3568c.add(bVar);
        if (this.f3569d == null) {
            mo36869a();
        }
    }
}
