package com.applovin.impl.mediation.debugger.p017ui.p018a;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0878a;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0879b;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0881d;
import com.applovin.impl.mediation.debugger.p017ui.p019b.p020a.C0916a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0936e;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.b */
public class C0899b extends C0933d {

    /* renamed from: a */
    public final C0878a f916a;
    @Nullable

    /* renamed from: b */
    public final C0879b f917b;

    /* renamed from: d */
    public final List<C0929c> f918d = m1069c();

    /* renamed from: e */
    public final List<C0929c> f919e = m1070d();

    /* renamed from: f */
    public final List<C0929c> f920f = m1071e();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$a */
    public class C0900a extends C0916a {

        /* renamed from: o */
        public final C0879b f922o;

        public C0900a(C0879b bVar, @Nullable String str, boolean z) {
            super(bVar.mo10052a(), C0899b.this.f1061c);
            this.f922o = bVar;
            this.f1027d = StringUtils.createSpannedString(bVar.mo10054c(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.f1028e = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f1026c = z;
        }

        /* renamed from: a */
        public C0879b mo10123a() {
            return this.f922o;
        }

        /* renamed from: b */
        public boolean mo10124b() {
            return this.f1026c;
        }

        /* renamed from: c */
        public int mo10125c() {
            return -12303292;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$b */
    public enum C0901b {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public C0899b(C0878a aVar, @Nullable C0879b bVar, Context context) {
        super(context);
        this.f916a = aVar;
        this.f917b = bVar;
        notifyDataSetChanged();
    }

    /* renamed from: c */
    private List<C0929c> m1069c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(m1072f());
        arrayList.add(m1073g());
        if (this.f917b != null) {
            arrayList.add(m1074h());
        }
        return arrayList;
    }

    /* renamed from: d */
    private List<C0929c> m1070d() {
        C0879b bVar = this.f917b;
        if (bVar != null && !bVar.mo10056e()) {
            return new ArrayList();
        }
        List<C0879b> a = this.f916a.mo10050e().mo10058a();
        ArrayList arrayList = new ArrayList(a.size());
        for (C0879b next : a) {
            C0879b bVar2 = this.f917b;
            if (bVar2 == null || bVar2.mo10053b().equals(next.mo10053b())) {
                arrayList.add(new C0900a(next, next.mo10055d() != null ? next.mo10055d().mo10061a() : "", this.f917b == null));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private List<C0929c> m1071e() {
        C0879b bVar = this.f917b;
        if (bVar != null && bVar.mo10056e()) {
            return new ArrayList();
        }
        List<C0879b> b = this.f916a.mo10050e().mo10059b();
        ArrayList arrayList = new ArrayList(b.size());
        for (C0879b next : b) {
            C0879b bVar2 = this.f917b;
            if (bVar2 == null || bVar2.mo10053b().equals(next.mo10053b())) {
                arrayList.add(new C0900a(next, (String) null, this.f917b == null));
                for (C0881d next2 : next.mo10057f()) {
                    arrayList.add(C0929c.m1177p().mo10180a(next2.mo10061a()).mo10185b(next2.mo10062b()).mo10186b(true).mo10182a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private C0929c m1072f() {
        return C0929c.m1177p().mo10180a("ID").mo10185b(this.f916a.mo10045a()).mo10182a();
    }

    /* renamed from: g */
    private C0929c m1073g() {
        return C0929c.m1177p().mo10180a("Ad Format").mo10185b(this.f916a.mo10047c()).mo10182a();
    }

    /* renamed from: h */
    private C0929c m1074h() {
        return C0929c.m1177p().mo10180a("Selected Network").mo10185b(this.f917b.mo10054c()).mo10182a();
    }

    /* renamed from: a */
    public int mo10118a(int i) {
        List<C0929c> list;
        C0901b bVar = C0901b.INFO;
        if (i == 0) {
            list = this.f918d;
        } else {
            C0901b bVar2 = C0901b.BIDDERS;
            list = i == 1 ? this.f919e : this.f920f;
        }
        return list.size();
    }

    /* renamed from: a */
    public String mo10119a() {
        return this.f916a.mo10046b();
    }

    /* renamed from: b */
    public int mo10120b() {
        C0901b bVar = C0901b.COUNT;
        return 3;
    }

    /* renamed from: b */
    public C0929c mo10121b(int i) {
        C0901b bVar = C0901b.INFO;
        if (i == 0) {
            return new C0936e("INFO");
        }
        C0901b bVar2 = C0901b.BIDDERS;
        return i == 1 ? new C0936e("BIDDERS") : new C0936e("WATERFALL");
    }

    /* renamed from: c */
    public List<C0929c> mo10122c(int i) {
        C0901b bVar = C0901b.INFO;
        if (i == 0) {
            return this.f918d;
        }
        C0901b bVar2 = C0901b.BIDDERS;
        return i == 1 ? this.f919e : this.f920f;
    }
}
