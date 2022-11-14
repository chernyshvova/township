package com.applovin.impl.mediation.debugger.p017ui.p018a;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0878a;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0879b;
import com.applovin.impl.mediation.debugger.p017ui.C0890a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0927a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0936e;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.sdk.C1368R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.c */
public class C0902c extends C0890a {

    /* renamed from: a */
    public List<C0878a> f928a;

    /* renamed from: b */
    public C1188m f929b;

    /* renamed from: c */
    public C0933d f930c;

    /* renamed from: d */
    public List<C0929c> f931d;

    /* renamed from: e */
    public ListView f932e;

    /* renamed from: a */
    private List<C0929c> m1084a(List<C0878a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C0878a next : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.mo10045a(), ViewCompat.MEASURED_STATE_MASK));
            spannableStringBuilder.append(new SpannedString("\n"));
            spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.mo10047c(), ViewCompat.MEASURED_STATE_MASK));
            arrayList.add(C0929c.m1175a(C0929c.C0932b.DETAIL).mo10179a(StringUtils.createSpannedString(next.mo10046b(), ViewCompat.MEASURED_STATE_MASK, 18, 1)).mo10184b(new SpannedString(spannableStringBuilder)).mo10178a((Context) this).mo10181a(true).mo10182a());
        }
        return arrayList;
    }

    public void initialize(final List<C0878a> list, final C1188m mVar) {
        this.f928a = list;
        this.f929b = mVar;
        this.f931d = m1084a(list);
        C09031 r0 = new C0933d(this) {
            /* renamed from: a */
            public int mo10118a(int i) {
                return list.size();
            }

            /* renamed from: b */
            public int mo10120b() {
                return 1;
            }

            /* renamed from: b */
            public C0929c mo10121b(int i) {
                return new C0936e("");
            }

            /* renamed from: c */
            public List<C0929c> mo10122c(int i) {
                return C0902c.this.f931d;
            }
        };
        this.f930c = r0;
        r0.mo10193a((C0933d.C0935a) new C0933d.C0935a() {
            /* renamed from: a */
            public void mo10111a(final C0927a aVar, C0929c cVar) {
                C0902c.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, mVar.mo10967ae(), new C0890a.C0892a<MaxDebuggerAdUnitDetailActivity>() {
                    /* renamed from: a */
                    public void mo10108a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                        maxDebuggerAdUnitDetailActivity.initialize((C0878a) list.get(aVar.mo10165b()), (C0879b) null, mVar);
                    }
                });
            }
        });
        this.f930c.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Ad Units");
        setContentView(C1368R.layout.list_view);
        ListView listView = (ListView) findViewById(C1368R.C1370id.listView);
        this.f932e = listView;
        listView.setAdapter(this.f930c);
    }
}
