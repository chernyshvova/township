package com.applovin.impl.mediation.debugger.p017ui.p019b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.applovin.impl.adview.C0653a;
import com.applovin.impl.mediation.debugger.p017ui.C0890a;
import com.applovin.impl.mediation.debugger.p017ui.p019b.C0918b;
import com.applovin.impl.mediation.debugger.p017ui.p019b.p020a.C0916a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0927a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.sdk.AppLovinContentProviderUtils;
import com.applovin.impl.sdk.C1008a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a */
public class C0909a extends C0890a {

    /* renamed from: a */
    public C0918b f946a;

    /* renamed from: b */
    public DataSetObserver f947b;

    /* renamed from: c */
    public FrameLayout f948c;

    /* renamed from: d */
    public ListView f949d;

    /* renamed from: e */
    public C0653a f950e;

    /* renamed from: a */
    private void m1093a() {
        Uri cacheJPEGImageWithFileName;
        Bitmap a = this.f946a.mo10192a(this.f949d);
        if (a != null && (cacheJPEGImageWithFileName = AppLovinContentProviderUtils.cacheJPEGImageWithFileName(a, "mediation_debugger_screenshot.jpeg")) != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/jpeg");
            intent.putExtra("android.intent.extra.STREAM", cacheJPEGImageWithFileName);
            intent.addFlags(1);
            startActivity(Intent.createChooser(intent, "Share Mediation Debugger"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1094a(final Context context) {
        if (StringUtils.isValidString(this.f946a.mo10155g()) && !this.f946a.mo10151c()) {
            this.f946a.mo10149a(true);
            runOnUiThread(new Runnable() {
                public void run() {
                    Utils.showAlert(C0909a.this.f946a.mo10154f(), C0909a.this.f946a.mo10155g(), context);
                }
            });
        }
    }

    /* renamed from: b */
    private void m1099b() {
        m1101c();
        C0653a aVar = new C0653a(this, 50, 16842874);
        this.f950e = aVar;
        aVar.setColor(-3355444);
        this.f948c.addView(this.f950e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f948c.bringChildToFront(this.f950e);
        this.f950e.mo9422a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1101c() {
        C0653a aVar = this.f950e;
        if (aVar != null) {
            aVar.mo9423b();
            this.f948c.removeView(this.f950e);
            this.f950e = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(C1368R.layout.list_view);
        this.f948c = (FrameLayout) findViewById(16908290);
        this.f949d = (ListView) findViewById(C1368R.C1370id.listView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1368R.C1371menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f946a.unregisterDataSetObserver(this.f947b);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (C1368R.C1370id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m1093a();
        return true;
    }

    public void onStart() {
        super.onStart();
        this.f949d.setAdapter(this.f946a);
        if (!this.f946a.mo10150a()) {
            m1099b();
        }
    }

    public void setListAdapter(C0918b bVar, final C1008a aVar) {
        DataSetObserver dataSetObserver;
        C0918b bVar2 = this.f946a;
        if (!(bVar2 == null || (dataSetObserver = this.f947b) == null)) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f946a = bVar;
        this.f947b = new DataSetObserver() {
            public void onChanged() {
                C0909a.this.m1101c();
                C0909a aVar = C0909a.this;
                aVar.m1094a((Context) aVar);
            }
        };
        m1094a((Context) this);
        this.f946a.registerDataSetObserver(this.f947b);
        this.f946a.mo10193a((C0933d.C0935a) new C0933d.C0935a() {
            /* renamed from: a */
            public void mo10111a(C0927a aVar, final C0929c cVar) {
                C0909a aVar2;
                String str;
                String str2;
                int a = aVar.mo10164a();
                C0918b.C0921b bVar = C0918b.C0921b.MAX;
                if (a == 1) {
                    Utils.showAlert(cVar.mo10173l(), cVar.mo10174m(), C0909a.this);
                    return;
                }
                C0918b.C0921b bVar2 = C0918b.C0921b.ADS;
                if (a == 3) {
                    int b = aVar.mo10165b();
                    C0918b.C0920a aVar3 = C0918b.C0920a.AD_UNITS;
                    if (b != 0) {
                        int b2 = aVar.mo10165b();
                        C0918b.C0920a aVar4 = C0918b.C0920a.SELECT_LIVE_NETWORKS;
                        if (b2 != 1) {
                            return;
                        }
                        if (C0909a.this.f946a.mo10156h().size() <= 0) {
                            aVar2 = C0909a.this;
                            str = "Complete Integrations";
                            str2 = "Please complete integrations in order to access this.";
                        } else if (C0909a.this.f946a.mo10152d().mo10930J().mo10221a()) {
                            Utils.showAlert("Restart Required", cVar.mo10174m(), C0909a.this);
                            return;
                        } else {
                            C0909a.this.startActivity(MaxDebuggerTestLiveNetworkActivity.class, aVar, new C0890a.C0892a<MaxDebuggerTestLiveNetworkActivity>() {
                                /* renamed from: a */
                                public void mo10108a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                    maxDebuggerTestLiveNetworkActivity.initialize(C0909a.this.f946a.mo10156h(), C0909a.this.f946a.mo10152d());
                                }
                            });
                            return;
                        }
                    } else if (C0909a.this.f946a.mo10153e().size() > 0) {
                        C0909a.this.startActivity(MaxDebuggerAdUnitsListActivity.class, aVar, new C0890a.C0892a<MaxDebuggerAdUnitsListActivity>() {
                            /* renamed from: a */
                            public void mo10108a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                maxDebuggerAdUnitsListActivity.initialize(C0909a.this.f946a.mo10153e(), C0909a.this.f946a.mo10152d());
                            }
                        });
                        return;
                    } else {
                        aVar2 = C0909a.this;
                        str = "No live ad units";
                        str2 = "Please setup or enable your MAX ad units on https://applovin.com.";
                    }
                    Utils.showAlert(str, str2, aVar2);
                    return;
                }
                C0918b.C0921b bVar3 = C0918b.C0921b.INCOMPLETE_NETWORKS;
                if (a != 4) {
                    C0918b.C0921b bVar4 = C0918b.C0921b.COMPLETED_NETWORKS;
                    if (a != 5) {
                        return;
                    }
                }
                if (cVar instanceof C0916a) {
                    C0909a.this.startActivity(MaxDebuggerDetailActivity.class, aVar, new C0890a.C0892a<MaxDebuggerDetailActivity>() {
                        /* renamed from: a */
                        public void mo10108a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                            maxDebuggerDetailActivity.initialize(((C0916a) cVar).mo10141d());
                        }
                    });
                }
            }
        });
    }
}
