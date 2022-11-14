package com.applovin.impl.mediation.debugger.p017ui.p023e;

import android.os.Bundle;
import android.widget.ListView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p017ui.C0890a;
import com.applovin.impl.mediation.debugger.p017ui.p019b.p020a.C0916a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0927a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.C1368R;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.e.a */
public class C0937a extends C0890a {

    /* renamed from: a */
    public C1188m f1065a;

    /* renamed from: b */
    public List<C0883b> f1066b;

    /* renamed from: c */
    public C0933d f1067c;

    /* renamed from: d */
    public List<C0929c> f1068d;

    /* renamed from: e */
    public ListView f1069e;

    public C0937a() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    /* renamed from: a */
    private List<C0929c> m1218a(List<C0883b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final C0883b next : list) {
            arrayList.add(new C0916a(this, next) {
                /* renamed from: f */
                public int mo10143f() {
                    if (C0937a.this.f1065a.mo10930J().mo10224c() == null || !C0937a.this.f1065a.mo10930J().mo10224c().equals(next.mo10075h())) {
                        return 0;
                    }
                    return C1368R.C1369drawable.applovin_ic_check_mark_borderless;
                }

                /* renamed from: g */
                public int mo10144g() {
                    if (C0937a.this.f1065a.mo10930J().mo10224c() == null || !C0937a.this.f1065a.mo10930J().mo10224c().equals(next.mo10075h())) {
                        return super.mo10144g();
                    }
                    return -16776961;
                }

                /* renamed from: m */
                public String mo10174m() {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Please restart the app to show ads from the network: ");
                    outline24.append(next.mo10076i());
                    outline24.append(CodelessMatcher.CURRENT_CLASS_NAME);
                    return outline24.toString();
                }
            });
        }
        return arrayList;
    }

    public void initialize(List<C0883b> list, final C1188m mVar) {
        this.f1065a = mVar;
        this.f1066b = list;
        this.f1068d = m1218a(list);
        C09381 r2 = new C0933d(this) {
            /* renamed from: a */
            public int mo10118a(int i) {
                return C0937a.this.f1068d.size();
            }

            /* renamed from: b */
            public int mo10120b() {
                return 1;
            }

            /* renamed from: b */
            public C0929c mo10121b(int i) {
                return new C0929c.C0931a(C0929c.C0932b.SECTION_CENTERED).mo10180a("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").mo10182a();
            }

            /* renamed from: c */
            public List<C0929c> mo10122c(int i) {
                return C0937a.this.f1068d;
            }
        };
        this.f1067c = r2;
        r2.mo10193a((C0933d.C0935a) new C0933d.C0935a() {
            /* renamed from: a */
            public void mo10111a(C0927a aVar, C0929c cVar) {
                if (StringUtils.isValidString(mVar.mo10930J().mo10224c())) {
                    mVar.mo10930J().mo10218a(((C0916a) cVar).mo10141d().mo10075h());
                } else {
                    mVar.mo10930J().mo10222b(((C0916a) cVar).mo10141d().mo10075h());
                    Utils.showAlert("Restart Required", cVar.mo10174m(), C0937a.this);
                }
                C0937a.this.f1067c.notifyDataSetChanged();
            }
        });
        this.f1067c.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(C1368R.layout.list_view);
        ListView listView = (ListView) findViewById(C1368R.C1370id.listView);
        this.f1069e = listView;
        listView.setAdapter(this.f1067c);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f1068d = m1218a(this.f1066b);
        this.f1067c.mo10202i();
    }
}
