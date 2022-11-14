package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.h */
public class C1169h extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public static int f2109a = -1;

    /* renamed from: b */
    public final AudioManager f2110b;

    /* renamed from: c */
    public final Context f2111c;

    /* renamed from: d */
    public final C1188m f2112d;

    /* renamed from: e */
    public final Set<C1171a> f2113e = new HashSet();

    /* renamed from: f */
    public final Object f2114f = new Object();

    /* renamed from: g */
    public boolean f2115g;

    /* renamed from: h */
    public int f2116h;

    /* renamed from: com.applovin.impl.sdk.h$a */
    public interface C1171a {
        /* renamed from: a */
        void mo9481a(int i);
    }

    public C1169h(C1188m mVar) {
        this.f2112d = mVar;
        Context L = mVar.mo10932L();
        this.f2111c = L;
        this.f2110b = (AudioManager) L.getSystemService("audio");
    }

    /* renamed from: a */
    public static boolean m1994a(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: b */
    private void m1995b() {
        this.f2112d.mo10922B().mo11372b("AudioSessionManager", "Observing ringer mode...");
        this.f2116h = f2109a;
        this.f2111c.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.f2112d.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f2112d.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    private void m1996b(final int i) {
        if (!this.f2115g) {
            C1314v B = this.f2112d.mo10922B();
            B.mo11372b("AudioSessionManager", "Ringer mode is " + i);
            synchronized (this.f2114f) {
                for (final C1171a next : this.f2113e) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            next.mo9481a(i);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: c */
    private void m1997c() {
        this.f2112d.mo10922B().mo11372b("AudioSessionManager", "Stopping observation of mute switch state...");
        this.f2111c.unregisterReceiver(this);
        this.f2112d.mo10972aj().unregisterReceiver(this);
    }

    /* renamed from: a */
    public int mo10887a() {
        return this.f2110b.getRingerMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10888a(com.applovin.impl.sdk.C1169h.C1171a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2114f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f2113e     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f2113e     // Catch:{ all -> 0x0020 }
            r1.add(r3)     // Catch:{ all -> 0x0020 }
            java.util.Set<com.applovin.impl.sdk.h$a> r3 = r2.f2113e     // Catch:{ all -> 0x0020 }
            int r3 = r3.size()     // Catch:{ all -> 0x0020 }
            r1 = 1
            if (r3 != r1) goto L_0x001e
            r2.m1995b()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1169h.mo10888a(com.applovin.impl.sdk.h$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10889b(com.applovin.impl.sdk.C1169h.C1171a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2114f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f2113e     // Catch:{ all -> 0x001f }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f2113e     // Catch:{ all -> 0x001f }
            r1.remove(r3)     // Catch:{ all -> 0x001f }
            java.util.Set<com.applovin.impl.sdk.h$a> r3 = r2.f2113e     // Catch:{ all -> 0x001f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x001d
            r2.m1997c()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1169h.mo10889b(com.applovin.impl.sdk.h$a):void");
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            m1996b(this.f2110b.getRingerMode());
        }
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2115g = true;
            this.f2116h = this.f2110b.getRingerMode();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2115g = false;
            if (this.f2116h != this.f2110b.getRingerMode()) {
                this.f2116h = f2109a;
                m1996b(this.f2110b.getRingerMode());
            }
        }
    }
}
