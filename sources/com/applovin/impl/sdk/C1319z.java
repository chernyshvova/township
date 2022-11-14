package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.sdk.z */
public class C1319z {

    /* renamed from: b */
    public static final AtomicBoolean f2585b = new AtomicBoolean();

    /* renamed from: a */
    public final C1188m f2586a;

    /* renamed from: c */
    public final AtomicBoolean f2587c = new AtomicBoolean();

    /* renamed from: d */
    public final AtomicBoolean f2588d = new AtomicBoolean();

    /* renamed from: e */
    public final AtomicInteger f2589e = new AtomicInteger();

    /* renamed from: f */
    public Date f2590f;

    /* renamed from: g */
    public Date f2591g;

    public C1319z(final C1188m mVar) {
        this.f2586a = mVar;
        final Application application = (Application) mVar.mo10932L();
        application.registerActivityLifecycleCallbacks(new C1256a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                C1319z.this.m2684e();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                C1319z.this.f2589e.set(i);
                if (i == 20) {
                    C1319z.this.m2685f();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (Utils.isCurrentProcessInForeground()) {
                        C1319z.this.m2684e();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C1319z.this.m2685f();
                }
            }
        }, intentFilter);
        if (((Boolean) mVar.mo10946a(C1085b.f1694cu)).booleanValue() && f2585b.compareAndSet(false, true)) {
            final Intent intent = new Intent(application, AppKilledService.class);
            application.startService(intent);
            mVar.mo10972aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
                    application.stopService(intent);
                    mVar.mo10972aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2684e() {
        if (this.f2588d.compareAndSet(true, false)) {
            m2687h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2685f() {
        if (this.f2588d.compareAndSet(false, true)) {
            m2686g();
        }
    }

    /* renamed from: g */
    private void m2686g() {
        this.f2586a.mo10922B().mo11372b("SessionTracker", "Application Paused");
        this.f2586a.mo10972aj().sendBroadcastSync(new Intent("com.applovin.application_paused"), (Map<String, Object>) null);
        if (!this.f2587c.get()) {
            boolean booleanValue = ((Boolean) this.f2586a.mo10946a(C1085b.f1739dn)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.f2586a.mo10946a(C1085b.f1741dp)).longValue());
            if (this.f2590f == null || System.currentTimeMillis() - this.f2590f.getTime() >= millis) {
                ((EventServiceImpl) this.f2586a.mo11007w()).trackEvent("paused");
                if (booleanValue) {
                    this.f2590f = new Date();
                }
            }
            if (!booleanValue) {
                this.f2590f = new Date();
            }
        }
    }

    /* renamed from: h */
    private void m2687h() {
        this.f2586a.mo10922B().mo11372b("SessionTracker", "Application Resumed");
        boolean booleanValue = ((Boolean) this.f2586a.mo10946a(C1085b.f1739dn)).booleanValue();
        long longValue = ((Long) this.f2586a.mo10946a(C1085b.f1740do)).longValue();
        this.f2586a.mo10972aj().sendBroadcastSync(new Intent("com.applovin.application_resumed"), (Map<String, Object>) null);
        if (!this.f2587c.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.f2591g == null || System.currentTimeMillis() - this.f2591g.getTime() >= millis) {
                ((EventServiceImpl) this.f2586a.mo11007w()).trackEvent("resumed");
                if (booleanValue) {
                    this.f2591g = new Date();
                }
            }
            if (!booleanValue) {
                this.f2591g = new Date();
            }
            this.f2586a.mo10939T().mo10757a(C1103f.f1933k);
        }
    }

    /* renamed from: a */
    public boolean mo11386a() {
        return this.f2588d.get();
    }

    /* renamed from: b */
    public int mo11387b() {
        return this.f2589e.get();
    }

    /* renamed from: c */
    public void mo11388c() {
        this.f2587c.set(true);
    }

    /* renamed from: d */
    public void mo11389d() {
        this.f2587c.set(false);
    }
}
