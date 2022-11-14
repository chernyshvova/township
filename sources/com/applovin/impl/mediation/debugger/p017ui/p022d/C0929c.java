package com.applovin.impl.mediation.debugger.p017ui.p022d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.C1262f;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.c */
public class C0929c {

    /* renamed from: b */
    public C0932b f1025b;

    /* renamed from: c */
    public boolean f1026c;

    /* renamed from: d */
    public SpannedString f1027d;

    /* renamed from: e */
    public SpannedString f1028e;

    /* renamed from: f */
    public String f1029f;

    /* renamed from: g */
    public String f1030g;

    /* renamed from: h */
    public int f1031h;

    /* renamed from: i */
    public int f1032i;

    /* renamed from: j */
    public int f1033j;

    /* renamed from: k */
    public int f1034k;

    /* renamed from: l */
    public int f1035l;

    /* renamed from: m */
    public int f1036m;

    /* renamed from: n */
    public boolean f1037n;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.c$a */
    public static class C0931a {

        /* renamed from: a */
        public final C0932b f1038a;

        /* renamed from: b */
        public boolean f1039b;

        /* renamed from: c */
        public SpannedString f1040c;

        /* renamed from: d */
        public SpannedString f1041d;

        /* renamed from: e */
        public String f1042e;

        /* renamed from: f */
        public String f1043f;

        /* renamed from: g */
        public int f1044g = 0;

        /* renamed from: h */
        public int f1045h = 0;

        /* renamed from: i */
        public int f1046i = ViewCompat.MEASURED_STATE_MASK;

        /* renamed from: j */
        public int f1047j = ViewCompat.MEASURED_STATE_MASK;

        /* renamed from: k */
        public int f1048k = 0;

        /* renamed from: l */
        public int f1049l = 0;

        /* renamed from: m */
        public boolean f1050m;

        public C0931a(C0932b bVar) {
            this.f1038a = bVar;
        }

        /* renamed from: a */
        public C0931a mo10177a(int i) {
            this.f1045h = i;
            return this;
        }

        /* renamed from: a */
        public C0931a mo10178a(Context context) {
            this.f1045h = C1368R.C1369drawable.applovin_ic_disclosure_arrow;
            this.f1049l = C1262f.m2502a(C1368R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        /* renamed from: a */
        public C0931a mo10179a(SpannedString spannedString) {
            this.f1040c = spannedString;
            return this;
        }

        /* renamed from: a */
        public C0931a mo10180a(String str) {
            return mo10179a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        /* renamed from: a */
        public C0931a mo10181a(boolean z) {
            this.f1039b = z;
            return this;
        }

        /* renamed from: a */
        public C0929c mo10182a() {
            return new C0929c(this);
        }

        /* renamed from: b */
        public C0931a mo10183b(int i) {
            this.f1047j = i;
            return this;
        }

        /* renamed from: b */
        public C0931a mo10184b(SpannedString spannedString) {
            this.f1041d = spannedString;
            return this;
        }

        /* renamed from: b */
        public C0931a mo10185b(String str) {
            return mo10184b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        /* renamed from: b */
        public C0931a mo10186b(boolean z) {
            this.f1050m = z;
            return this;
        }

        /* renamed from: c */
        public C0931a mo10187c(int i) {
            this.f1049l = i;
            return this;
        }

        /* renamed from: c */
        public C0931a mo10188c(String str) {
            this.f1042e = str;
            return this;
        }

        /* renamed from: d */
        public C0931a mo10189d(String str) {
            this.f1043f = str;
            return this;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.c$b */
    public enum C0932b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);
        

        /* renamed from: g */
        public final int f1058g;

        /* access modifiers changed from: public */
        C0932b(int i) {
            this.f1058g = i;
        }

        /* renamed from: a */
        public int mo10190a() {
            return this.f1058g;
        }

        /* renamed from: b */
        public int mo10191b() {
            if (this == SECTION) {
                return C1368R.layout.list_section;
            }
            if (this == SECTION_CENTERED) {
                return C1368R.layout.list_section_centered;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? C1368R.layout.list_item_detail : C1368R.layout.list_item_right_detail;
        }
    }

    public C0929c(C0931a aVar) {
        this.f1031h = 0;
        this.f1032i = 0;
        this.f1033j = ViewCompat.MEASURED_STATE_MASK;
        this.f1034k = ViewCompat.MEASURED_STATE_MASK;
        this.f1035l = 0;
        this.f1036m = 0;
        this.f1025b = aVar.f1038a;
        this.f1026c = aVar.f1039b;
        this.f1027d = aVar.f1040c;
        this.f1028e = aVar.f1041d;
        this.f1029f = aVar.f1042e;
        this.f1030g = aVar.f1043f;
        this.f1031h = aVar.f1044g;
        this.f1032i = aVar.f1045h;
        this.f1033j = aVar.f1046i;
        this.f1034k = aVar.f1047j;
        this.f1035l = aVar.f1048k;
        this.f1036m = aVar.f1049l;
        this.f1037n = aVar.f1050m;
    }

    public C0929c(C0932b bVar) {
        this.f1031h = 0;
        this.f1032i = 0;
        this.f1033j = ViewCompat.MEASURED_STATE_MASK;
        this.f1034k = ViewCompat.MEASURED_STATE_MASK;
        this.f1035l = 0;
        this.f1036m = 0;
        this.f1025b = bVar;
    }

    /* renamed from: a */
    public static C0931a m1175a(C0932b bVar) {
        return new C0931a(bVar);
    }

    /* renamed from: h */
    public static int m1176h() {
        return C0932b.COUNT.mo10190a();
    }

    /* renamed from: p */
    public static C0931a m1177p() {
        return m1175a(C0932b.RIGHT_DETAIL);
    }

    /* renamed from: b */
    public boolean mo10124b() {
        return this.f1026c;
    }

    /* renamed from: c */
    public int mo10125c() {
        return this.f1034k;
    }

    /* renamed from: c_ */
    public SpannedString mo10146c_() {
        return this.f1028e;
    }

    /* renamed from: d_ */
    public boolean mo10147d_() {
        return this.f1037n;
    }

    /* renamed from: e */
    public int mo10142e() {
        return this.f1031h;
    }

    /* renamed from: f */
    public int mo10143f() {
        return this.f1032i;
    }

    /* renamed from: g */
    public int mo10144g() {
        return this.f1036m;
    }

    /* renamed from: i */
    public int mo10170i() {
        return this.f1025b.mo10190a();
    }

    /* renamed from: j */
    public int mo10171j() {
        return this.f1025b.mo10191b();
    }

    /* renamed from: k */
    public SpannedString mo10172k() {
        return this.f1027d;
    }

    /* renamed from: l */
    public String mo10173l() {
        return this.f1029f;
    }

    /* renamed from: m */
    public String mo10174m() {
        return this.f1030g;
    }

    /* renamed from: n */
    public int mo10175n() {
        return this.f1033j;
    }

    /* renamed from: o */
    public int mo10176o() {
        return this.f1035l;
    }
}
