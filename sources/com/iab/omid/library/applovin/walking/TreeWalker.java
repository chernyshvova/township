package com.iab.omid.library.applovin.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p045b.C2841a;
import com.iab.omid.library.applovin.p046c.C2850a;
import com.iab.omid.library.applovin.p046c.C2852b;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2859d;
import com.iab.omid.library.applovin.p047d.C2861f;
import com.iab.omid.library.applovin.p048e.C2862a;
import com.iab.omid.library.applovin.walking.C2871a;
import com.iab.omid.library.applovin.walking.p049a.C2877c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C2850a.C2851a {

    /* renamed from: a */
    public static TreeWalker f3447a = new TreeWalker();

    /* renamed from: b */
    public static Handler f3448b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    public static Handler f3449c = null;

    /* renamed from: l */
    public static final Runnable f3450l = new Runnable() {
        public void run() {
            TreeWalker.getInstance().m3432h();
        }
    };

    /* renamed from: m */
    public static final Runnable f3451m = new Runnable() {
        public void run() {
            if (TreeWalker.f3449c != null) {
                TreeWalker.f3449c.post(TreeWalker.f3450l);
                TreeWalker.f3449c.postDelayed(TreeWalker.f3451m, 200);
            }
        }
    };

    /* renamed from: d */
    public List<TreeWalkerTimeLogger> f3452d = new ArrayList();

    /* renamed from: e */
    public int f3453e;

    /* renamed from: f */
    public boolean f3454f = false;

    /* renamed from: g */
    public final List<C2862a> f3455g = new ArrayList();

    /* renamed from: h */
    public C2852b f3456h = new C2852b();

    /* renamed from: i */
    public C2871a f3457i = new C2871a();

    /* renamed from: j */
    public C2881b f3458j = new C2881b(new C2877c());

    /* renamed from: k */
    public long f3459k;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    /* renamed from: a */
    private void m3423a(long j) {
        if (this.f3452d.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f3452d) {
                next.onTreeProcessed(this.f3453e, TimeUnit.NANOSECONDS.toMillis(j));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f3453e, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3424a(View view, C2850a aVar, JSONObject jSONObject, C2882c cVar, boolean z) {
        aVar.mo36756a(view, jSONObject, this, cVar == C2882c.PARENT_VIEW, z);
    }

    /* renamed from: a */
    private void m3425a(String str, View view, JSONObject jSONObject) {
        C2850a b = this.f3456h.mo36759b();
        String a = this.f3457i.mo36799a(str);
        if (a != null) {
            JSONObject a2 = b.mo36755a(view);
            C2856b.m3361a(a2, str);
            C2856b.m3366b(a2, a);
            C2856b.m3363a(jSONObject, a2);
        }
    }

    /* renamed from: a */
    private boolean m3426a(View view, JSONObject jSONObject) {
        String a = this.f3457i.mo36798a(view);
        if (a == null) {
            return false;
        }
        C2856b.m3361a(jSONObject, a);
        C2856b.m3360a(jSONObject, Boolean.valueOf(this.f3457i.mo36807d(view)));
        this.f3457i.mo36808e();
        return true;
    }

    /* renamed from: b */
    private boolean m3428b(View view, JSONObject jSONObject) {
        C2871a.C2872a b = this.f3457i.mo36802b(view);
        if (b == null) {
            return false;
        }
        C2856b.m3359a(jSONObject, b);
        return true;
    }

    public static TreeWalker getInstance() {
        return f3447a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m3432h() {
        m3433i();
        mo36791d();
        m3434j();
    }

    /* renamed from: i */
    private void m3433i() {
        this.f3453e = 0;
        this.f3455g.clear();
        this.f3454f = false;
        Iterator<C2839a> it = C2841a.m3285a().mo36712c().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().mo36675b()) {
                    this.f3454f = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f3459k = C2859d.m3375a();
    }

    /* renamed from: j */
    private void m3434j() {
        m3423a(C2859d.m3375a() - this.f3459k);
    }

    /* renamed from: k */
    private void m3435k() {
        if (f3449c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f3449c = handler;
            handler.post(f3450l);
            f3449c.postDelayed(f3451m, 200);
        }
    }

    /* renamed from: l */
    private void m3436l() {
        Handler handler = f3449c;
        if (handler != null) {
            handler.removeCallbacks(f3451m);
            f3449c = null;
        }
    }

    /* renamed from: a */
    public void mo36787a() {
        m3435k();
    }

    /* renamed from: a */
    public void mo36757a(View view, C2850a aVar, JSONObject jSONObject, boolean z) {
        C2882c c;
        if (C2861f.m3392d(view) && (c = this.f3457i.mo36804c(view)) != C2882c.UNDERLYING_VIEW) {
            JSONObject a = aVar.mo36755a(view);
            C2856b.m3363a(jSONObject, a);
            if (!m3426a(view, a)) {
                boolean z2 = z || m3428b(view, a);
                if (this.f3454f && c == C2882c.OBSTRUCTION_VIEW && !z2) {
                    this.f3455g.add(new C2862a(view));
                }
                m3424a(view, aVar, a, c, z2);
            }
            this.f3453e++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f3452d.contains(treeWalkerTimeLogger)) {
            this.f3452d.add(treeWalkerTimeLogger);
        }
    }

    /* renamed from: b */
    public void mo36789b() {
        mo36790c();
        this.f3452d.clear();
        f3448b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f3458j.mo36826a();
            }
        });
    }

    /* renamed from: c */
    public void mo36790c() {
        m3436l();
    }

    @VisibleForTesting
    /* renamed from: d */
    public void mo36791d() {
        this.f3457i.mo36805c();
        long a = C2859d.m3375a();
        C2850a a2 = this.f3456h.mo36758a();
        if (this.f3457i.mo36803b().size() > 0) {
            Iterator<String> it = this.f3457i.mo36803b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.mo36755a((View) null);
                m3425a(next, this.f3457i.mo36801b(next), a3);
                C2856b.m3358a(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f3458j.mo36828b(a3, hashSet, a);
            }
        }
        if (this.f3457i.mo36800a().size() > 0) {
            JSONObject a4 = a2.mo36755a((View) null);
            m3424a((View) null, a2, a4, C2882c.PARENT_VIEW, false);
            C2856b.m3358a(a4);
            this.f3458j.mo36827a(a4, this.f3457i.mo36800a(), a);
            if (this.f3454f) {
                for (C2839a a5 : C2841a.m3285a().mo36712c()) {
                    a5.mo36673a(this.f3455g);
                }
            }
        } else {
            this.f3458j.mo36826a();
        }
        this.f3457i.mo36806d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f3452d.contains(treeWalkerTimeLogger)) {
            this.f3452d.remove(treeWalkerTimeLogger);
        }
    }
}
