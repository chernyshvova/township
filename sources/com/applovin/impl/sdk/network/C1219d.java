package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.network.d */
public class C1219d extends BroadcastReceiver {

    /* renamed from: a */
    public final List<C1220a> f2319a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.sdk.network.d$a */
    public interface C1220a {
        /* renamed from: a */
        void mo11014a();

        /* renamed from: b */
        void mo11015b();
    }

    public C1219d(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: a */
    public static boolean m2259a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        Object obj = extras.get("networkInfo");
        if (obj instanceof NetworkInfo) {
            return ((NetworkInfo) obj).isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public void mo11141a(C1220a aVar) {
        this.f2319a.add(aVar);
    }

    /* renamed from: b */
    public void mo11142b(C1220a aVar) {
        this.f2319a.remove(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && !isInitialStickyBroadcast()) {
            ArrayList arrayList = new ArrayList(this.f2319a);
            boolean a = m2259a(intent);
            Iterator it = arrayList.iterator();
            if (a) {
                while (it.hasNext()) {
                    ((C1220a) it.next()).mo11014a();
                }
                return;
            }
            while (it.hasNext()) {
                ((C1220a) it.next()).mo11015b();
            }
        }
    }
}
