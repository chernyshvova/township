package com.applovin.impl.mediation.debugger.p017ui.p021c;

import android.os.Bundle;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p017ui.C0890a;
import com.applovin.impl.mediation.debugger.p017ui.p021c.C0925b;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0927a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.c.a */
public class C0922a extends C0890a {

    /* renamed from: a */
    public C0925b f998a;

    /* renamed from: b */
    public ListView f999b;

    public C0922a() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(final C0883b bVar) {
        setTitle(bVar.mo10076i());
        C0925b bVar2 = new C0925b(bVar, this);
        this.f998a = bVar2;
        bVar2.mo10193a((C0933d.C0935a) new C0933d.C0935a() {
            /* renamed from: a */
            public void mo10111a(C0927a aVar, C0929c cVar) {
                C0922a aVar2;
                String str;
                int a = aVar.mo10164a();
                C0925b.C0926a aVar3 = C0925b.C0926a.TEST_ADS;
                String str2 = "Instructions";
                if (a == 4) {
                    C1188m v = bVar.mo10090v();
                    C0883b.C0885b c = bVar.mo10069c();
                    if (C0883b.C0885b.READY == c) {
                        C0922a.this.startActivity(MaxDebuggerMultiAdActivity.class, v.mo10967ae(), new C0890a.C0892a<MaxDebuggerMultiAdActivity>() {
                            /* renamed from: a */
                            public void mo10108a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                maxDebuggerMultiAdActivity.initialize(bVar);
                            }
                        });
                        return;
                    } else if (C0883b.C0885b.DISABLED == c) {
                        v.mo10930J().mo10225d();
                        str = cVar.mo10174m();
                        aVar2 = C0922a.this;
                        str2 = "Restart Required";
                        Utils.showAlert(str2, str, aVar2);
                    }
                }
                str = cVar.mo10174m();
                aVar2 = C0922a.this;
                Utils.showAlert(str2, str, aVar2);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1368R.layout.list_view);
        ListView listView = (ListView) findViewById(C1368R.C1370id.listView);
        this.f999b = listView;
        listView.setAdapter(this.f998a);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f998a.mo10161a().mo10080m().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f998a.mo10162c();
            this.f998a.mo10202i();
        }
    }
}
