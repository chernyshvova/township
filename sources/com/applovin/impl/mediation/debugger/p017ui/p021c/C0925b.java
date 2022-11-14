package com.applovin.impl.mediation.debugger.p017ui.p021c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0882a;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0886c;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0887d;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0936e;
import com.applovin.impl.sdk.utils.C1262f;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.C1368R;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.c.b */
public class C0925b extends C0933d {

    /* renamed from: a */
    public final C0883b f1003a;

    /* renamed from: b */
    public List<C0929c> f1004b;

    /* renamed from: d */
    public final List<C0929c> f1005d;

    /* renamed from: e */
    public final List<C0929c> f1006e;

    /* renamed from: f */
    public final List<C0929c> f1007f;

    /* renamed from: g */
    public final List<C0929c> f1008g;

    /* renamed from: h */
    public SpannedString f1009h;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.c.b$a */
    public enum C0926a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    public C0925b(C0883b bVar, Context context) {
        super(context);
        this.f1003a = bVar;
        if (bVar.mo10067a() == C0883b.C0884a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f1009h = new SpannedString(spannableString);
        } else {
            this.f1009h = new SpannedString("");
        }
        this.f1004b = m1157d();
        this.f1005d = m1153a(bVar.mo10085r());
        this.f1006e = m1152a(bVar.mo10087t());
        this.f1007f = m1155b(bVar.mo10086s());
        this.f1008g = m1162h();
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private int m1150a(boolean z) {
        return z ? C1368R.C1369drawable.applovin_ic_check_mark_bordered : C1368R.C1369drawable.applovin_ic_x_mark;
    }

    /* renamed from: a */
    private C0929c m1151a(C0883b.C0885b bVar) {
        C0929c.C0931a p = C0929c.m1177p();
        if (bVar == C0883b.C0885b.READY) {
            p.mo10178a(this.f1061c);
        }
        return p.mo10180a("Test Mode").mo10185b(bVar.mo10092a()).mo10183b(bVar.mo10093b()).mo10189d(bVar.mo10094c()).mo10181a(true).mo10182a();
    }

    /* renamed from: a */
    private List<C0929c> m1152a(C0886c cVar) {
        ArrayList arrayList = new ArrayList(1);
        if (cVar.mo10095a()) {
            boolean b = cVar.mo10096b();
            arrayList.add(C0929c.m1175a(b ? C0929c.C0932b.RIGHT_DETAIL : C0929c.C0932b.DETAIL).mo10180a("Cleartext Traffic").mo10184b(b ? null : this.f1009h).mo10189d(cVar.mo10097c()).mo10177a(m1150a(b)).mo10187c(m1154b(b)).mo10181a(true ^ b).mo10182a());
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C0929c> m1153a(List<C0887d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (C0887d next : list) {
                boolean c = next.mo10100c();
                arrayList.add(C0929c.m1175a(c ? C0929c.C0932b.RIGHT_DETAIL : C0929c.C0932b.DETAIL).mo10180a(next.mo10098a()).mo10184b(c ? null : this.f1009h).mo10189d(next.mo10099b()).mo10177a(m1150a(c)).mo10187c(m1154b(c)).mo10181a(!c).mo10182a());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m1154b(boolean z) {
        return C1262f.m2502a(z ? C1368R.color.applovin_sdk_checkmarkColor : C1368R.color.applovin_sdk_xmarkColor, this.f1061c);
    }

    /* renamed from: b */
    private List<C0929c> m1155b(List<C0882a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (C0882a next : list) {
                boolean c = next.mo10065c();
                arrayList.add(C0929c.m1175a(c ? C0929c.C0932b.RIGHT_DETAIL : C0929c.C0932b.DETAIL).mo10180a(next.mo10063a()).mo10184b(c ? null : this.f1009h).mo10189d(next.mo10064b()).mo10177a(m1150a(c)).mo10187c(m1154b(c)).mo10181a(!c).mo10182a());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private C0929c m1156c(List<String> list) {
        return C0929c.m1177p().mo10180a("Region/VPN Required").mo10185b(CollectionUtils.implode(list, RESTClient.COMMA_SEPARATOR, list.size())).mo10182a();
    }

    /* renamed from: d */
    private List<C0929c> m1157d() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(m1158e());
        arrayList.add(m1160f());
        arrayList.add(m1161g());
        return arrayList;
    }

    /* renamed from: e */
    private C0929c m1158e() {
        C0929c.C0931a b = C0929c.m1177p().mo10180a("SDK").mo10185b(this.f1003a.mo10077j());
        if (TextUtils.isEmpty(this.f1003a.mo10077j())) {
            b.mo10177a(m1150a(this.f1003a.mo10071d())).mo10187c(m1154b(this.f1003a.mo10071d()));
        }
        return b.mo10182a();
    }

    /* renamed from: e */
    private String m1159e(int i) {
        return (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i) ? "Initialized" : MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i ? "Failure" : MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i ? "Initializing..." : "Waiting to Initialize...";
    }

    /* renamed from: f */
    private C0929c m1160f() {
        C0929c.C0931a b = C0929c.m1177p().mo10180a("Adapter").mo10185b(this.f1003a.mo10078k());
        if (TextUtils.isEmpty(this.f1003a.mo10078k())) {
            b.mo10177a(m1150a(this.f1003a.mo10072e())).mo10187c(m1154b(this.f1003a.mo10072e()));
        }
        return b.mo10182a();
    }

    /* renamed from: g */
    private C0929c m1161g() {
        C0929c.C0931a b;
        boolean z = false;
        if (this.f1003a.mo10090v().mo10924D().mo10232b()) {
            b = C0929c.m1177p().mo10180a("Initialize with Activity Context").mo10189d("Please ensure that you are initializing the AppLovin MAX SDK with an Activity Context.").mo10177a(m1150a(false)).mo10187c(m1154b(false));
            z = true;
        } else {
            b = C0929c.m1177p().mo10180a("Initialization Status").mo10185b(m1159e(this.f1003a.mo10068b()));
        }
        return b.mo10181a(z).mo10182a();
    }

    /* renamed from: h */
    private List<C0929c> m1162h() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.f1003a.mo10089u())) {
            arrayList.add(C0929c.m1175a(C0929c.C0932b.DETAIL).mo10180a(this.f1003a.mo10089u()).mo10182a());
        }
        if (this.f1003a.mo10069c() != C0883b.C0885b.NOT_SUPPORTED) {
            if (this.f1003a.mo10081n() != null) {
                arrayList.add(m1156c(this.f1003a.mo10081n()));
            }
            arrayList.add(m1151a(this.f1003a.mo10069c()));
        }
        return arrayList;
    }

    /* renamed from: a */
    public int mo10118a(int i) {
        List<C0929c> list;
        C0926a aVar = C0926a.INTEGRATIONS;
        if (i == 0) {
            list = this.f1004b;
        } else {
            C0926a aVar2 = C0926a.PERMISSIONS;
            if (i == 1) {
                list = this.f1005d;
            } else {
                C0926a aVar3 = C0926a.CONFIGURATION;
                if (i == 2) {
                    list = this.f1006e;
                } else {
                    C0926a aVar4 = C0926a.DEPENDENCIES;
                    list = i == 3 ? this.f1007f : this.f1008g;
                }
            }
        }
        return list.size();
    }

    /* renamed from: a */
    public C0883b mo10161a() {
        return this.f1003a;
    }

    /* renamed from: b */
    public int mo10120b() {
        C0926a aVar = C0926a.COUNT;
        return 5;
    }

    /* renamed from: b */
    public C0929c mo10121b(int i) {
        C0926a aVar = C0926a.INTEGRATIONS;
        if (i == 0) {
            return new C0936e("INTEGRATIONS");
        }
        C0926a aVar2 = C0926a.PERMISSIONS;
        if (i == 1) {
            return new C0936e("PERMISSIONS");
        }
        C0926a aVar3 = C0926a.CONFIGURATION;
        if (i == 2) {
            return new C0936e("CONFIGURATION");
        }
        C0926a aVar4 = C0926a.DEPENDENCIES;
        return i == 3 ? new C0936e("DEPENDENCIES") : new C0936e("TEST ADS");
    }

    /* renamed from: c */
    public List<C0929c> mo10122c(int i) {
        C0926a aVar = C0926a.INTEGRATIONS;
        if (i == 0) {
            return this.f1004b;
        }
        C0926a aVar2 = C0926a.PERMISSIONS;
        if (i == 1) {
            return this.f1005d;
        }
        C0926a aVar3 = C0926a.CONFIGURATION;
        if (i == 2) {
            return this.f1006e;
        }
        C0926a aVar4 = C0926a.DEPENDENCIES;
        return i == 3 ? this.f1007f : this.f1008g;
    }

    /* renamed from: c */
    public void mo10162c() {
        this.f1004b = m1157d();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }
}
