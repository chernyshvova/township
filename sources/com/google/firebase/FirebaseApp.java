package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.p003os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.EventBus;
import com.google.firebase.components.EventBus$$Lambda$1;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.internal.DataCollectionConfigStorage;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class FirebaseApp {
    @GuardedBy("LOCK")
    public static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
    public static final Object LOCK = new Object();
    public static final Executor UI_EXECUTOR = new UiExecutor((C23551) null);
    public final Context applicationContext;
    public final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    public final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
    public final ComponentRuntime componentRuntime;
    public final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    public final AtomicBoolean deleted = new AtomicBoolean();
    public final String name;
    public final FirebaseOptions options;

    @KeepForSdk
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
        public static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<>();

        public static void access$100(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (INSTANCE.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (INSTANCE.compareAndSet((Object) null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
                    }
                }
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.automaticResourceManagementEnabled.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        for (BackgroundStateChangeListener onBackgroundStateChanged : firebaseApp.backgroundStateChangeListeners) {
                            onBackgroundStateChanged.onBackgroundStateChanged(z);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public static class UiExecutor implements Executor {
        public static final Handler HANDLER = new Handler(Looper.getMainLooper());

        public UiExecutor(C23551 r1) {
        }

        public void execute(@NonNull Runnable runnable) {
            HANDLER.post(runnable);
        }
    }

    @TargetApi(24)
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public static class UserUnlockReceiver extends BroadcastReceiver {
        public static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<>();
        public final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.LOCK) {
                for (FirebaseApp initializeAllApis : FirebaseApp.INSTANCES.values()) {
                    initializeAllApis.initializeAllApis();
                }
            }
            this.applicationContext.unregisterReceiver(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FirebaseApp(android.content.Context r13, java.lang.String r14, com.google.firebase.FirebaseOptions r15) {
        /*
            r12 = this;
            r12.<init>()
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r1 = 0
            r0.<init>(r1)
            r12.automaticResourceManagementEnabled = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r12.deleted = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r12.backgroundStateChangeListeners = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            android.content.Context r0 = (android.content.Context) r0
            r12.applicationContext = r0
            java.lang.String r14 = com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r12.name = r14
            java.lang.Object r14 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            com.google.firebase.FirebaseOptions r14 = (com.google.firebase.FirebaseOptions) r14
            r12.options = r14
            java.lang.Class<com.google.firebase.components.ComponentDiscoveryService> r14 = com.google.firebase.components.ComponentDiscoveryService.class
            com.google.firebase.components.ComponentDiscovery$MetadataRegistrarNameRetriever r0 = new com.google.firebase.components.ComponentDiscovery$MetadataRegistrarNameRetriever
            r2 = 0
            r0.<init>(r14, r2)
            java.lang.String r14 = "ComponentDiscovery"
            android.content.pm.PackageManager r3 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0073 }
            if (r3 != 0) goto L_0x004a
            java.lang.String r0 = "Context has no PackageManager."
            android.util.Log.w(r14, r0)     // Catch:{ NameNotFoundException -> 0x0073 }
            goto L_0x0078
        L_0x004a:
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0073 }
            java.lang.Class<? extends android.app.Service> r5 = r0.discoveryService     // Catch:{ NameNotFoundException -> 0x0073 }
            r4.<init>(r13, r5)     // Catch:{ NameNotFoundException -> 0x0073 }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ServiceInfo r3 = r3.getServiceInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x0073 }
            if (r3 != 0) goto L_0x0070
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0073 }
            r3.<init>()     // Catch:{ NameNotFoundException -> 0x0073 }
            java.lang.Class<? extends android.app.Service> r0 = r0.discoveryService     // Catch:{ NameNotFoundException -> 0x0073 }
            r3.append(r0)     // Catch:{ NameNotFoundException -> 0x0073 }
            java.lang.String r0 = " has no service info."
            r3.append(r0)     // Catch:{ NameNotFoundException -> 0x0073 }
            java.lang.String r0 = r3.toString()     // Catch:{ NameNotFoundException -> 0x0073 }
            android.util.Log.w(r14, r0)     // Catch:{ NameNotFoundException -> 0x0073 }
            goto L_0x0078
        L_0x0070:
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0073 }
            goto L_0x0079
        L_0x0073:
            java.lang.String r0 = "Application info not found."
            android.util.Log.w(r14, r0)
        L_0x0078:
            r0 = r2
        L_0x0079:
            java.lang.String r3 = "com.google.firebase.components.ComponentRegistrar"
            if (r0 != 0) goto L_0x0087
            java.lang.String r0 = "Could not retrieve metadata, returning empty list of registrars."
            android.util.Log.w(r14, r0)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00bd
        L_0x0087:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Set r5 = r0.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0094:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00bc
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.get(r6)
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x0094
            java.lang.String r7 = "com.google.firebase.components:"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x0094
            r7 = 31
            java.lang.String r6 = r6.substring(r7)
            r4.add(r6)
            goto L_0x0094
        L_0x00bc:
            r0 = r4
        L_0x00bd:
            java.lang.String r4 = "Could not instantiate %s"
            java.lang.String r5 = "Could not instantiate %s."
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ca:
            boolean r7 = r0.hasNext()
            r8 = 1
            r9 = 2
            if (r7 == 0) goto L_0x0149
            java.lang.Object r7 = r0.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Class r10 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            java.lang.Class<com.google.firebase.components.ComponentRegistrar> r11 = com.google.firebase.components.ComponentRegistrar.class
            boolean r11 = r11.isAssignableFrom(r10)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            if (r11 != 0) goto L_0x00f4
            java.lang.String r10 = "Class %s is not an instance of %s"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            r9[r1] = r7     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            r9[r8] = r3     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            java.lang.String r9 = java.lang.String.format(r10, r9)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            android.util.Log.w(r14, r9)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            goto L_0x00ca
        L_0x00f4:
            java.lang.Class[] r9 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            java.lang.reflect.Constructor r9 = r10.getDeclaredConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            java.lang.Object r9 = r9.newInstance(r10)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            com.google.firebase.components.ComponentRegistrar r9 = (com.google.firebase.components.ComponentRegistrar) r9     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            r6.add(r9)     // Catch:{ ClassNotFoundException -> 0x013a, IllegalAccessException -> 0x012d, InstantiationException -> 0x0120, NoSuchMethodException -> 0x0113, InvocationTargetException -> 0x0106 }
            goto L_0x00ca
        L_0x0106:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r4, r8)
            android.util.Log.w(r14, r7, r9)
            goto L_0x00ca
        L_0x0113:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r4, r8)
            android.util.Log.w(r14, r7, r9)
            goto L_0x00ca
        L_0x0120:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r5, r8)
            android.util.Log.w(r14, r7, r9)
            goto L_0x00ca
        L_0x012d:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r5, r8)
            android.util.Log.w(r14, r7, r9)
            goto L_0x00ca
        L_0x013a:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = "Class %s is not an found."
            java.lang.String r7 = java.lang.String.format(r7, r8)
            android.util.Log.w(r14, r7, r9)
            goto L_0x00ca
        L_0x0149:
            kotlin.KotlinVersion r14 = kotlin.KotlinVersion.CURRENT     // Catch:{ NoClassDefFoundError -> 0x0150 }
            java.lang.String r14 = r14.toString()     // Catch:{ NoClassDefFoundError -> 0x0150 }
            goto L_0x0151
        L_0x0150:
            r14 = r2
        L_0x0151:
            com.google.firebase.components.ComponentRuntime r0 = new com.google.firebase.components.ComponentRuntime
            java.util.concurrent.Executor r3 = UI_EXECUTOR
            r4 = 8
            com.google.firebase.components.Component[] r4 = new com.google.firebase.components.Component[r4]
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            java.lang.Class[] r7 = new java.lang.Class[r1]
            com.google.firebase.components.Component r5 = com.google.firebase.components.Component.m3054of(r13, r5, r7)
            r4[r1] = r5
            java.lang.Class<com.google.firebase.FirebaseApp> r5 = com.google.firebase.FirebaseApp.class
            java.lang.Class[] r7 = new java.lang.Class[r1]
            com.google.firebase.components.Component r5 = com.google.firebase.components.Component.m3054of(r12, r5, r7)
            r4[r8] = r5
            java.lang.Class<com.google.firebase.FirebaseOptions> r5 = com.google.firebase.FirebaseOptions.class
            java.lang.Class[] r7 = new java.lang.Class[r1]
            com.google.firebase.components.Component r15 = com.google.firebase.components.Component.m3054of(r15, r5, r7)
            r4[r9] = r15
            r15 = 3
            java.lang.String r5 = "fire-android"
            java.lang.String r7 = ""
            com.google.firebase.components.Component r5 = com.android.billingclient.api.zzam.create(r5, r7)
            r4[r15] = r5
            r15 = 4
            java.lang.String r5 = "fire-core"
            java.lang.String r7 = "19.3.0"
            com.google.firebase.components.Component r5 = com.android.billingclient.api.zzam.create(r5, r7)
            r4[r15] = r5
            r15 = 5
            if (r14 == 0) goto L_0x0196
            java.lang.String r2 = "kotlin"
            com.google.firebase.components.Component r2 = com.android.billingclient.api.zzam.create(r2, r14)
        L_0x0196:
            r4[r15] = r2
            r14 = 6
            java.lang.Class<com.google.firebase.platforminfo.UserAgentPublisher> r15 = com.google.firebase.platforminfo.UserAgentPublisher.class
            com.google.firebase.components.Component$Builder r15 = com.google.firebase.components.Component.builder(r15)
            java.lang.Class<com.google.firebase.platforminfo.LibraryVersion> r2 = com.google.firebase.platforminfo.LibraryVersion.class
            com.google.firebase.components.Dependency r5 = new com.google.firebase.components.Dependency
            r5.<init>(r2, r9, r1)
            r15.add(r5)
            com.google.firebase.platforminfo.DefaultUserAgentPublisher$$Lambda$1 r1 = com.google.firebase.platforminfo.DefaultUserAgentPublisher$$Lambda$1.instance
            r15.factory(r1)
            com.google.firebase.components.Component r15 = r15.build()
            r4[r14] = r15
            r14 = 7
            java.lang.Class<com.google.firebase.heartbeatinfo.HeartBeatInfo> r15 = com.google.firebase.heartbeatinfo.HeartBeatInfo.class
            com.google.firebase.components.Component$Builder r15 = com.google.firebase.components.Component.builder(r15)
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            com.google.firebase.components.Dependency r1 = com.google.firebase.components.Dependency.required(r1)
            r15.add(r1)
            com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$1 r1 = com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$1.instance
            r15.factory(r1)
            com.google.firebase.components.Component r15 = r15.build()
            r4[r14] = r15
            r0.<init>(r3, r6, r4)
            r12.componentRuntime = r0
            com.google.firebase.components.Lazy r14 = new com.google.firebase.components.Lazy
            com.google.firebase.FirebaseApp$$Lambda$1 r15 = new com.google.firebase.FirebaseApp$$Lambda$1
            r15.<init>(r12, r13)
            r14.<init>(r15)
            r12.dataCollectionConfigStorage = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.FirebaseApp.<init>(android.content.Context, java.lang.String, com.google.firebase.FirebaseOptions):void");
    }

    @NonNull
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.access$100(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            Preconditions.checkState(!INSTANCES.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, "[DEFAULT]", firebaseOptions);
            INSTANCES.put("[DEFAULT]", firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }

    public static /* synthetic */ DataCollectionConfigStorage lambda$new$0(FirebaseApp firebaseApp, Context context) {
        return new DataCollectionConfigStorage(context, firebaseApp.getPersistenceKey(), (Publisher) firebaseApp.componentRuntime.get(Publisher.class));
    }

    public final void checkNotDeleted() {
        Preconditions.checkState(!this.deleted.get(), "FirebaseApp was deleted");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        String str = this.name;
        FirebaseApp firebaseApp = (FirebaseApp) obj;
        firebaseApp.checkNotDeleted();
        return str.equals(firebaseApp.name);
    }

    @KeepForSdk
    public String getPersistenceKey() {
        StringBuilder sb = new StringBuilder();
        checkNotDeleted();
        sb.append(Base64Utils.encodeUrlSafeNoPadding(this.name.getBytes(Charset.defaultCharset())));
        sb.append("+");
        checkNotDeleted();
        sb.append(Base64Utils.encodeUrlSafeNoPadding(this.options.applicationId.getBytes(Charset.defaultCharset())));
        return sb.toString();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public final void initializeAllApis() {
        Queue<Event<?>> queue;
        Set<Map.Entry> emptySet;
        if (!UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            Context context = this.applicationContext;
            if (UserUnlockReceiver.INSTANCE.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (UserUnlockReceiver.INSTANCE.compareAndSet((Object) null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        ComponentRuntime componentRuntime2 = this.componentRuntime;
        boolean isDefaultApp = isDefaultApp();
        for (Map.Entry next : componentRuntime2.components.entrySet()) {
            Component component = (Component) next.getKey();
            Lazy lazy = (Lazy) next.getValue();
            boolean z = false;
            if (!(component.instantiation == 1)) {
                if (component.instantiation == 2) {
                    z = true;
                }
                if (z) {
                    if (!isDefaultApp) {
                    }
                }
            }
            lazy.get();
        }
        EventBus eventBus = componentRuntime2.eventBus;
        synchronized (eventBus) {
            if (eventBus.pendingEvents != null) {
                queue = eventBus.pendingEvents;
                eventBus.pendingEvents = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event event : queue) {
                if (event != null) {
                    synchronized (eventBus) {
                        if (eventBus.pendingEvents != null) {
                            eventBus.pendingEvents.add(event);
                        } else {
                            synchronized (eventBus) {
                                Map map = eventBus.handlerMap.get((Object) null);
                                emptySet = map == null ? Collections.emptySet() : map.entrySet();
                            }
                            for (Map.Entry entry : emptySet) {
                                ((Executor) entry.getValue()).execute(new EventBus$$Lambda$1(entry, event));
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public boolean isDefaultApp() {
        checkNotDeleted();
        return "[DEFAULT]".equals(this.name);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("options", this.options).toString();
    }
}
