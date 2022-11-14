package com.applovin.impl.adview;

import android.os.Handler;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.adview.j */
public final class C0754j {

    /* renamed from: a */
    public final C1314v f448a;

    /* renamed from: b */
    public final Handler f449b;

    /* renamed from: c */
    public final Set<C0757b> f450c = new HashSet();

    /* renamed from: d */
    public final AtomicInteger f451d = new AtomicInteger();

    /* renamed from: com.applovin.impl.adview.j$a */
    public interface C0756a {
        /* renamed from: a */
        void mo9504a();

        /* renamed from: b */
        boolean mo9505b();
    }

    /* renamed from: com.applovin.impl.adview.j$b */
    public static class C0757b {

        /* renamed from: a */
        public final String f455a;

        /* renamed from: b */
        public final C0756a f456b;

        /* renamed from: c */
        public final long f457c;

        public C0757b(String str, long j, C0756a aVar) {
            this.f455a = str;
            this.f457c = j;
            this.f456b = aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m526a() {
            return this.f455a;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m528b() {
            return this.f457c;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public C0756a m531c() {
            return this.f456b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0757b)) {
                return false;
            }
            String str = this.f455a;
            String str2 = ((C0757b) obj).f455a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.f455a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("CountdownProxy{identifier='");
            GeneratedOutlineSupport.outline33(outline24, this.f455a, '\'', ", countdownStepMillis=");
            outline24.append(this.f457c);
            outline24.append('}');
            return outline24.toString();
        }
    }

    public C0754j(Handler handler, C1188m mVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (mVar != null) {
            this.f449b = handler;
            this.f448a = mVar.mo10922B();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m517a(final C0757b bVar, final int i) {
        this.f449b.postDelayed(new Runnable() {
            public void run() {
                C0756a b = bVar.m531c();
                if (!b.mo9505b()) {
                    C1314v b2 = C0754j.this.f448a;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ending countdown for ");
                    outline24.append(bVar.m526a());
                    b2.mo11372b("CountdownManager", outline24.toString());
                } else if (C0754j.this.f451d.get() == i) {
                    try {
                        b.mo9504a();
                    } catch (Throwable th) {
                        C1314v b3 = C0754j.this.f448a;
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Encountered error on countdown step for: ");
                        outline242.append(bVar.m526a());
                        b3.mo11373b("CountdownManager", outline242.toString(), th);
                    }
                    C0754j.this.m517a(bVar, i);
                } else {
                    C1314v b4 = C0754j.this.f448a;
                    StringBuilder outline243 = GeneratedOutlineSupport.outline24("Killing duplicate countdown from previous generation: ");
                    outline243.append(bVar.m526a());
                    b4.mo11375d("CountdownManager", outline243.toString());
                }
            }
        }, bVar.m528b());
    }

    /* renamed from: a */
    public void mo9651a() {
        HashSet hashSet = new HashSet(this.f450c);
        C1314v vVar = this.f448a;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Starting ");
        outline24.append(hashSet.size());
        outline24.append(" countdowns...");
        vVar.mo11372b("CountdownManager", outline24.toString());
        int incrementAndGet = this.f451d.incrementAndGet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            C0757b bVar = (C0757b) it.next();
            C1314v vVar2 = this.f448a;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Starting countdown: ");
            outline242.append(bVar.m526a());
            outline242.append(" for generation ");
            outline242.append(incrementAndGet);
            outline242.append("...");
            vVar2.mo11372b("CountdownManager", outline242.toString());
            m517a(bVar, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void mo9652a(String str, long j, C0756a aVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f449b != null) {
            C1314v vVar = this.f448a;
            vVar.mo11372b("CountdownManager", "Adding countdown: " + str);
            this.f450c.add(new C0757b(str, j, aVar));
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    /* renamed from: b */
    public void mo9653b() {
        this.f448a.mo11372b("CountdownManager", "Removing all countdowns...");
        mo9654c();
        this.f450c.clear();
    }

    /* renamed from: c */
    public void mo9654c() {
        this.f448a.mo11372b("CountdownManager", "Stopping countdowns...");
        this.f451d.incrementAndGet();
        this.f449b.removeCallbacksAndMessages((Object) null);
    }
}
