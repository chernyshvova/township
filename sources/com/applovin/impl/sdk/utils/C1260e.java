package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1188m;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.utils.e */
public class C1260e implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public static final Set<C1260e> f2439a = new HashSet();

    /* renamed from: b */
    public final C1304n f2440b;

    /* renamed from: c */
    public final C1188m f2441c;

    public C1260e(long j, C1188m mVar, final Runnable runnable) {
        this.f2440b = C1304n.m2612a(j, mVar, new Runnable() {
            public void run() {
                C1260e.this.mo11276a();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.f2441c = mVar;
        f2439a.add(this);
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public static C1260e m2499a(long j, C1188m mVar, Runnable runnable) {
        return new C1260e(j, mVar, runnable);
    }

    /* renamed from: a */
    public void mo11276a() {
        this.f2440b.mo11336d();
        this.f2441c.mo10972aj().unregisterReceiver(this);
        f2439a.remove(this);
    }

    /* renamed from: b */
    public long mo11277b() {
        return this.f2440b.mo11333a();
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2440b.mo11334b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2440b.mo11335c();
        }
    }
}
