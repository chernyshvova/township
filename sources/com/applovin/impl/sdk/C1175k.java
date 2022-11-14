package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1304n;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.k */
public class C1175k implements AppLovinBroadcastManager.Receiver {

    /* renamed from: b */
    public static AlertDialog f2127b;

    /* renamed from: c */
    public static final AtomicBoolean f2128c = new AtomicBoolean();

    /* renamed from: a */
    public final C1181l f2129a;

    /* renamed from: d */
    public C1304n f2130d;

    /* renamed from: com.applovin.impl.sdk.k$a */
    public interface C1180a {
        /* renamed from: a */
        void mo10910a();

        /* renamed from: b */
        void mo10911b();
    }

    public C1175k(C1181l lVar, C1188m mVar) {
        this.f2129a = lVar;
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo10905a(long j, final C1188m mVar, final C1180a aVar) {
        if (j > 0) {
            AlertDialog alertDialog = f2127b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (f2128c.getAndSet(true)) {
                    if (j < this.f2130d.mo11333a()) {
                        C1314v B = mVar.mo10922B();
                        B.mo11372b("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.f2130d.mo11333a() + "ms)");
                        this.f2130d.mo11336d();
                    } else {
                        C1314v B2 = mVar.mo10922B();
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Skip scheduling consent alert - one scheduled already with remaining time of ");
                        outline24.append(this.f2130d.mo11333a());
                        outline24.append(" milliseconds");
                        B2.mo11375d("ConsentAlertManager", outline24.toString());
                        return;
                    }
                }
                C1314v B3 = mVar.mo10922B();
                B3.mo11372b("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
                this.f2130d = C1304n.m2612a(j, mVar, new Runnable() {
                    public void run() {
                        String str;
                        C1314v vVar;
                        if (C1175k.this.f2129a.mo10915d()) {
                            mVar.mo10922B().mo11376e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                            return;
                        }
                        Activity a = mVar.mo10967ae().mo10434a();
                        if (a == null || !C1264h.m2521a(mVar.mo10932L())) {
                            if (a == null) {
                                vVar = mVar.mo10922B();
                                str = "No parent Activity found - rescheduling consent alert...";
                            } else {
                                vVar = mVar.mo10922B();
                                str = "No internet available - rescheduling consent alert...";
                            }
                            vVar.mo11376e("ConsentAlertManager", str);
                            C1175k.f2128c.set(false);
                            C1175k.this.mo10905a(((Long) mVar.mo10946a(C1085b.f1555aK)).longValue(), mVar, aVar);
                            return;
                        }
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                AlertDialog unused = C1175k.f2127b = new AlertDialog.Builder(mVar.mo10967ae().mo10434a()).setTitle((CharSequence) mVar.mo10946a(C1085b.f1556aL)).setMessage((CharSequence) mVar.mo10946a(C1085b.f1557aM)).setCancelable(false).setPositiveButton((CharSequence) mVar.mo10946a(C1085b.f1558aN), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo10910a();
                                        dialogInterface.dismiss();
                                        C1175k.f2128c.set(false);
                                    }
                                }).setNegativeButton((CharSequence) mVar.mo10946a(C1085b.f1559aO), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo10911b();
                                        dialogInterface.dismiss();
                                        C1175k.f2128c.set(false);
                                        long longValue = ((Long) mVar.mo10946a(C1085b.f1554aJ)).longValue();
                                        C11761 r0 = C11761.this;
                                        C1175k.this.mo10905a(longValue, mVar, aVar);
                                    }
                                }).create();
                                C1175k.f2127b.show();
                            }
                        });
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        if (this.f2130d != null) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                this.f2130d.mo11334b();
            } else if ("com.applovin.application_resumed".equals(action)) {
                this.f2130d.mo11335c();
            }
        }
    }
}
