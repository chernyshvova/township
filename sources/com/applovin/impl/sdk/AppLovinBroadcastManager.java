package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppLovinBroadcastManager {

    /* renamed from: f */
    public static AppLovinBroadcastManager f1260f;

    /* renamed from: g */
    public static final Object f1261g = new Object();

    /* renamed from: a */
    public final Context f1262a;

    /* renamed from: b */
    public final HashMap<Receiver, ArrayList<C1004b>> f1263b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, ArrayList<C1004b>> f1264c = new HashMap<>();

    /* renamed from: d */
    public final ArrayList<C1003a> f1265d = new ArrayList<>();

    /* renamed from: e */
    public final Handler f1266e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.this.m1352a();
            } else {
                super.handleMessage(message);
            }
        }
    };

    public interface Receiver {
        void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map);
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$a */
    public static class C1003a {

        /* renamed from: a */
        public final Intent f1268a;
        @Nullable

        /* renamed from: b */
        public final Map<String, Object> f1269b;

        /* renamed from: c */
        public final List<C1004b> f1270c;

        public C1003a(Intent intent, @Nullable Map<String, Object> map, List<C1004b> list) {
            this.f1268a = intent;
            this.f1269b = map;
            this.f1270c = list;
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$b */
    public static class C1004b {

        /* renamed from: a */
        public final IntentFilter f1271a;

        /* renamed from: b */
        public final Receiver f1272b;

        /* renamed from: c */
        public boolean f1273c;

        /* renamed from: d */
        public boolean f1274d;

        public C1004b(IntentFilter intentFilter, Receiver receiver) {
            this.f1271a = intentFilter;
            this.f1272b = receiver;
        }
    }

    public AppLovinBroadcastManager(Context context) {
        this.f1262a = context;
    }

    /* renamed from: a */
    private List<C1004b> m1351a(Intent intent) {
        synchronized (this.f1263b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1262a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            List<C1004b> list = this.f1264c.get(action);
            if (list == null) {
                return null;
            }
            ArrayList<C1004b> arrayList = null;
            for (C1004b bVar : list) {
                if (!bVar.f1273c) {
                    C1004b bVar2 = bVar;
                    if (bVar.f1271a.match(action, resolveTypeIfNeeded, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(bVar2);
                        bVar2.f1273c = true;
                        arrayList = arrayList2;
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            for (C1004b bVar3 : arrayList) {
                bVar3.f1273c = false;
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r0 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r3 = r2[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r3 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r4 = r3.f1270c.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r4.hasNext() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r5 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r5 == null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r5.f1274d != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r5.f1272b.onReceive(r9.f1262a, r3.f1268a, r3.f1269b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1352a() {
        /*
            r9 = this;
        L_0x0000:
            java.util.HashMap<com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = r9.f1263b
            monitor-enter(r0)
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r1 = r9.f1265d     // Catch:{ all -> 0x0049 }
            int r1 = r1.size()     // Catch:{ all -> 0x0049 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x000d:
            com.applovin.impl.sdk.AppLovinBroadcastManager$a[] r2 = new com.applovin.impl.sdk.AppLovinBroadcastManager.C1003a[r1]     // Catch:{ all -> 0x0049 }
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r3 = r9.f1265d     // Catch:{ all -> 0x0049 }
            r3.toArray(r2)     // Catch:{ all -> 0x0049 }
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r3 = r9.f1265d     // Catch:{ all -> 0x0049 }
            r3.clear()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            r0 = 0
        L_0x001b:
            if (r0 >= r1) goto L_0x0000
            r3 = r2[r0]
            if (r3 != 0) goto L_0x0022
            goto L_0x0046
        L_0x0022:
            java.util.List<com.applovin.impl.sdk.AppLovinBroadcastManager$b> r4 = r3.f1270c
            java.util.Iterator r4 = r4.iterator()
        L_0x0028:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.next()
            com.applovin.impl.sdk.AppLovinBroadcastManager$b r5 = (com.applovin.impl.sdk.AppLovinBroadcastManager.C1004b) r5
            if (r5 == 0) goto L_0x0028
            boolean r6 = r5.f1274d
            if (r6 != 0) goto L_0x0028
            com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver r5 = r5.f1272b
            android.content.Context r6 = r9.f1262a
            android.content.Intent r7 = r3.f1268a
            java.util.Map<java.lang.String, java.lang.Object> r8 = r3.f1269b
            r5.onReceive(r6, r7, r8)
            goto L_0x0028
        L_0x0046:
            int r0 = r0 + 1
            goto L_0x001b
        L_0x0049:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x004c:
            throw r1
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.m1352a():void");
    }

    public static AppLovinBroadcastManager getInstance(Context context) {
        AppLovinBroadcastManager appLovinBroadcastManager;
        synchronized (f1261g) {
            if (f1260f == null) {
                f1260f = new AppLovinBroadcastManager(context.getApplicationContext());
            }
            appLovinBroadcastManager = f1260f;
        }
        return appLovinBroadcastManager;
    }

    public void registerReceiver(Receiver receiver, IntentFilter intentFilter) {
        synchronized (this.f1263b) {
            C1004b bVar = new C1004b(intentFilter, receiver);
            ArrayList arrayList = this.f1263b.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f1263b.put(receiver, arrayList);
            }
            arrayList.add(bVar);
            Iterator<String> actionsIterator = intentFilter.actionsIterator();
            while (actionsIterator.hasNext()) {
                String next = actionsIterator.next();
                ArrayList arrayList2 = this.f1264c.get(next);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f1264c.put(next, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r5, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r4 = this;
            java.util.HashMap<com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = r4.f1263b
            monitor-enter(r0)
            java.util.List r1 = r4.m1351a((android.content.Intent) r5)     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x000c
            r5 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r5
        L_0x000c:
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r2 = r4.f1265d     // Catch:{ all -> 0x0026 }
            com.applovin.impl.sdk.AppLovinBroadcastManager$a r3 = new com.applovin.impl.sdk.AppLovinBroadcastManager$a     // Catch:{ all -> 0x0026 }
            r3.<init>(r5, r6, r1)     // Catch:{ all -> 0x0026 }
            r2.add(r3)     // Catch:{ all -> 0x0026 }
            android.os.Handler r5 = r4.f1266e     // Catch:{ all -> 0x0026 }
            r6 = 1
            boolean r5 = r5.hasMessages(r6)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0024
            android.os.Handler r5 = r4.f1266e     // Catch:{ all -> 0x0026 }
            r5.sendEmptyMessage(r6)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r6
        L_0x0026:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.sendBroadcast(android.content.Intent, java.util.Map):boolean");
    }

    public void sendBroadcastSync(Intent intent, @Nullable Map<String, Object> map) {
        List<C1004b> a = m1351a(intent);
        if (a != null) {
            for (C1004b next : a) {
                if (!next.f1274d) {
                    next.f1272b.onReceive(this.f1262a, intent, map);
                }
            }
        }
    }

    public void sendBroadcastSyncWithPendingBroadcasts(Intent intent, @Nullable Map<String, Object> map) {
        if (sendBroadcast(intent, map)) {
            m1352a();
        }
    }

    public boolean sendBroadcastWithAdObject(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("ad", obj);
        return sendBroadcast(new Intent(str), hashMap);
    }

    public void unregisterReceiver(Receiver receiver) {
        synchronized (this.f1263b) {
            List<C1004b> remove = this.f1263b.remove(receiver);
            if (remove != null) {
                for (C1004b bVar : remove) {
                    bVar.f1274d = true;
                    Iterator<String> actionsIterator = bVar.f1271a.actionsIterator();
                    while (actionsIterator.hasNext()) {
                        String next = actionsIterator.next();
                        List list = this.f1264c.get(next);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (((C1004b) it.next()).f1272b == receiver) {
                                    bVar.f1274d = true;
                                    it.remove();
                                }
                            }
                            if (list.size() <= 0) {
                                this.f1264c.remove(next);
                            }
                        }
                    }
                }
            }
        }
    }
}
