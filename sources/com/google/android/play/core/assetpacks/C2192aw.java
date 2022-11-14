package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.C2284a;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2315ck;
import com.google.android.play.core.listener.C2330a;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.aw */
public final class C2192aw {

    /* renamed from: a */
    public final C2292ag f2922a;

    /* renamed from: b */
    public final Set<StateUpdatedListener<StateT>> f2923b = new HashSet();

    /* renamed from: c */
    public final C2232cp f2924c;
    public final IntentFilter c$com$google$android$play$core$listener$b;

    /* renamed from: d */
    public final C2215bw f2925d;
    public final Context d$com$google$android$play$core$listener$b;

    /* renamed from: e */
    public final C2315ck<C2281w> f2926e;
    public C2330a e$com$google$android$play$core$listener$b = null;

    /* renamed from: f */
    public final C2207bn f2927f;
    public volatile boolean f$com$google$android$play$core$listener$b = false;

    /* renamed from: g */
    public final C2218bz f2928g;

    /* renamed from: h */
    public final C2284a f2929h;

    /* renamed from: i */
    public final C2315ck<Executor> f2930i;

    /* renamed from: j */
    public final C2315ck<Executor> f2931j;

    /* renamed from: k */
    public final Handler f2932k;

    public C2192aw(Context context, C2232cp cpVar, C2215bw bwVar, C2315ck<C2281w> ckVar, C2218bz bzVar, C2207bn bnVar, C2284a aVar, C2315ck<Executor> ckVar2, C2315ck<Executor> ckVar3) {
        C2292ag agVar = new C2292ag("AssetPackServiceListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE");
        this.f2922a = agVar;
        this.c$com$google$android$play$core$listener$b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.d$com$google$android$play$core$listener$b = applicationContext != null ? applicationContext : context;
        this.f2932k = new Handler(Looper.getMainLooper());
        this.f2924c = cpVar;
        this.f2925d = bwVar;
        this.f2926e = ckVar;
        this.f2928g = bzVar;
        this.f2927f = bnVar;
        this.f2929h = aVar;
        this.f2930i = ckVar2;
        this.f2931j = ckVar3;
    }

    /* renamed from: a */
    public final void mo33171a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f2922a.mo33278a(6, "Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
            if (bundleExtra2 != null) {
                C2284a aVar = this.f2929h;
                synchronized (aVar) {
                    for (String str : bundleExtra2.keySet()) {
                        Object obj = bundleExtra2.get(str);
                        if (obj != null && aVar.f3227a.get(str) == null) {
                            aVar.f3227a.put(str, obj);
                        }
                    }
                }
            }
            AssetPackState a = AssetPackState.m2820a(bundleExtra, stringArrayList.get(0), this.f2928g, C2194ay.f2942a);
            this.f2922a.mo33278a(3, "ListenerRegistryBroadcastReceiver.onReceive: %s", new Object[]{a});
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f2927f.f2975a = pendingIntent;
            }
            this.f2931j.mo33293a().execute(new C2190au(this, bundleExtra, a));
            this.f2930i.mo33293a().execute(new C2191av(this, bundleExtra));
            return;
        }
        this.f2922a.mo33278a(6, "Empty bundle received from broadcast.", new Object[0]);
    }

    /* renamed from: c */
    public final void mo33172c() {
        C2330a aVar;
        if ((this.f$com$google$android$play$core$listener$b || !this.f2923b.isEmpty()) && this.e$com$google$android$play$core$listener$b == null) {
            C2330a aVar2 = new C2330a(this);
            this.e$com$google$android$play$core$listener$b = aVar2;
            this.d$com$google$android$play$core$listener$b.registerReceiver(aVar2, this.c$com$google$android$play$core$listener$b);
        }
        if (!this.f$com$google$android$play$core$listener$b && this.f2923b.isEmpty() && (aVar = this.e$com$google$android$play$core$listener$b) != null) {
            this.d$com$google$android$play$core$listener$b.unregisterReceiver(aVar);
            this.e$com$google$android$play$core$listener$b = null;
        }
    }
}
