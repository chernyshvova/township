package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.utils.C1304n;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
public class C1065b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public final C1188m f1445a;

    /* renamed from: b */
    public final C1067a f1446b;

    /* renamed from: c */
    public C1304n f1447c;

    /* renamed from: d */
    public final Object f1448d = new Object();

    /* renamed from: e */
    public long f1449e;

    /* renamed from: com.applovin.impl.sdk.b$a */
    public interface C1067a {
        void onAdExpired();
    }

    public C1065b(C1188m mVar, C1067a aVar) {
        this.f1445a = mVar;
        this.f1446b = aVar;
    }

    /* renamed from: b */
    private void m1595b() {
        C1304n nVar = this.f1447c;
        if (nVar != null) {
            nVar.mo11336d();
            this.f1447c = null;
        }
    }

    /* renamed from: c */
    private void m1596c() {
        synchronized (this.f1448d) {
            m1595b();
        }
    }

    /* renamed from: d */
    private void m1597d() {
        boolean z;
        synchronized (this.f1448d) {
            long currentTimeMillis = this.f1449e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                mo10641a();
                z = true;
            } else {
                mo10642a(currentTimeMillis);
                z = false;
            }
        }
        if (z) {
            this.f1446b.onAdExpired();
        }
    }

    /* renamed from: a */
    public void mo10641a() {
        synchronized (this.f1448d) {
            m1595b();
            this.f1445a.mo10972aj().unregisterReceiver(this);
        }
    }

    /* renamed from: a */
    public void mo10642a(long j) {
        synchronized (this.f1448d) {
            mo10641a();
            this.f1449e = System.currentTimeMillis() + j;
            this.f1445a.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.f1445a.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.f1445a.mo10946a(C1084a.f1498I)).booleanValue() || !this.f1445a.mo10965ac().mo11386a()) {
                this.f1447c = C1304n.m2612a(j, this.f1445a, new Runnable() {
                    public void run() {
                        C1065b.this.mo10641a();
                        C1065b.this.f1446b.onAdExpired();
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            m1596c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            m1597d();
        }
    }
}
