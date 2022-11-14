package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.appsflyer.internal.z */
public final class C1500z {
    public static final BitSet AFLogger$LogLevel = new BitSet(6);
    @VisibleForTesting
    public static volatile C1500z AFVersionDeclaration;
    public static final Handler AppsFlyer2dXConversionCallback = new Handler(Looper.getMainLooper());
    public final Handler AFInAppEventParameterName;
    public final Runnable AFInAppEventType = new Runnable() {
        public final void run() {
            synchronized (C1500z.this.valueOf) {
                C1500z zVar = C1500z.this;
                zVar.init.execute(new Runnable() {
                    public final void run() {
                        try {
                            if (!C1500z.this.onAppOpenAttributionNative.isEmpty()) {
                                for (C1495x xVar : C1500z.this.onAppOpenAttributionNative.values()) {
                                    C1500z.this.onAttributionFailureNative.unregisterListener(xVar);
                                    xVar.AFInAppEventType((Map<C1495x, Map<String, Object>>) C1500z.this.onInstallConversionDataLoadedNative, true);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        int unused2 = C1500z.this.onInstallConversionFailureNative = 0;
                        boolean unused3 = C1500z.this.onDeepLinkingNative = false;
                    }
                });
            }
        }
    };
    public boolean AFKeystoreWrapper;
    public final Runnable getLevel = new Runnable() {
        public final void run() {
            synchronized (C1500z.this.valueOf) {
                if (C1500z.this.AFKeystoreWrapper) {
                    C1500z.this.AFInAppEventParameterName.removeCallbacks(C1500z.this.values);
                    C1500z.this.AFInAppEventParameterName.removeCallbacks(C1500z.this.AFInAppEventType);
                    C1500z zVar = C1500z.this;
                    zVar.init.execute(new Runnable() {
                        public final void run() {
                            try {
                                if (!C1500z.this.onAppOpenAttributionNative.isEmpty()) {
                                    for (C1495x xVar : C1500z.this.onAppOpenAttributionNative.values()) {
                                        C1500z.this.onAttributionFailureNative.unregisterListener(xVar);
                                        xVar.AFInAppEventType((Map<C1495x, Map<String, Object>>) C1500z.this.onInstallConversionDataLoadedNative, true);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            int unused2 = C1500z.this.onInstallConversionFailureNative = 0;
                            boolean unused3 = C1500z.this.onDeepLinkingNative = false;
                        }
                    });
                    C1500z.this.AFKeystoreWrapper = false;
                }
            }
        }
    };
    public final Executor init = Executors.newSingleThreadExecutor();
    public final Runnable onAppOpenAttribution = new Runnable() {
        public final void run() {
            synchronized (C1500z.this.valueOf) {
                if (C1500z.this.onInstallConversionFailureNative == 0) {
                    int unused = C1500z.this.onInstallConversionFailureNative = 1;
                }
                C1500z.this.AFInAppEventParameterName.postDelayed(C1500z.this.AFInAppEventType, ((long) C1500z.this.onInstallConversionFailureNative) * 500);
            }
        }
    };
    public final Map<C1495x, C1495x> onAppOpenAttributionNative = new HashMap(AFLogger$LogLevel.size());
    public final SensorManager onAttributionFailureNative;
    public long onConversionDataFail = 0;
    public boolean onDeepLinkingNative;
    public final Map<C1495x, Map<String, Object>> onInstallConversionDataLoadedNative = new ConcurrentHashMap(AFLogger$LogLevel.size());
    public int onInstallConversionFailureNative = 1;
    public final Object valueOf = new Object();
    public final Runnable values = new Runnable() {
        public final void run() {
            synchronized (C1500z.this.valueOf) {
                C1500z zVar = C1500z.this;
                zVar.init.execute(new Runnable() {
                    public final void run() {
                        try {
                            for (Sensor next : C1500z.this.onAttributionFailureNative.getSensorList(-1)) {
                                if (C1500z.AFKeystoreWrapper(next.getType())) {
                                    C1495x xVar = new C1495x(next, C1500z.this.init);
                                    if (!C1500z.this.onAppOpenAttributionNative.containsKey(xVar)) {
                                        C1500z.this.onAppOpenAttributionNative.put(xVar, xVar);
                                    }
                                    C1500z.this.onAttributionFailureNative.registerListener((SensorEventListener) C1500z.this.onAppOpenAttributionNative.get(xVar), next, 0);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        boolean unused2 = C1500z.this.onDeepLinkingNative = true;
                    }
                });
                C1500z.this.AFInAppEventParameterName.postDelayed(C1500z.this.onAppOpenAttribution, 100);
                C1500z.this.AFKeystoreWrapper = true;
            }
        }
    };

    static {
        AFLogger$LogLevel.set(1);
        AFLogger$LogLevel.set(2);
        AFLogger$LogLevel.set(4);
    }

    public C1500z(@NonNull SensorManager sensorManager, Handler handler) {
        this.onAttributionFailureNative = sensorManager;
        this.AFInAppEventParameterName = handler;
    }

    public static boolean AFKeystoreWrapper(int i) {
        return i >= 0 && AFLogger$LogLevel.get(i);
    }

    public static C1500z valueOf(Context context) {
        if (AFVersionDeclaration != null) {
            return AFVersionDeclaration;
        }
        return AFInAppEventParameterName((SensorManager) context.getApplicationContext().getSystemService("sensor"), AppsFlyer2dXConversionCallback);
    }

    @NonNull
    public final List<Map<String, Object>> AFKeystoreWrapper() {
        synchronized (this.valueOf) {
            if (!this.onAppOpenAttributionNative.isEmpty() && this.onDeepLinkingNative) {
                for (C1495x AFInAppEventType2 : this.onAppOpenAttributionNative.values()) {
                    AFInAppEventType2.AFInAppEventType(this.onInstallConversionDataLoadedNative, false);
                }
            }
            if (this.onInstallConversionDataLoadedNative.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.onInstallConversionDataLoadedNative.values());
            return copyOnWriteArrayList2;
        }
    }

    public static C1500z AFInAppEventParameterName(SensorManager sensorManager, Handler handler) {
        if (AFVersionDeclaration == null) {
            synchronized (C1500z.class) {
                if (AFVersionDeclaration == null) {
                    AFVersionDeclaration = new C1500z(sensorManager, handler);
                }
            }
        }
        return AFVersionDeclaration;
    }

    public final void valueOf() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.onConversionDataFail;
        if (j != 0) {
            this.onInstallConversionFailureNative++;
            if (j - currentTimeMillis < 500) {
                this.AFInAppEventParameterName.removeCallbacks(this.AFInAppEventType);
                this.AFInAppEventParameterName.post(this.values);
            }
        } else {
            this.AFInAppEventParameterName.post(this.getLevel);
            this.AFInAppEventParameterName.post(this.values);
        }
        this.onConversionDataFail = currentTimeMillis;
    }

    public final List<Map<String, Object>> AFInAppEventParameterName() {
        for (C1495x AFInAppEventType2 : this.onAppOpenAttributionNative.values()) {
            AFInAppEventType2.AFInAppEventType(this.onInstallConversionDataLoadedNative, true);
        }
        Map<C1495x, Map<String, Object>> map = this.onInstallConversionDataLoadedNative;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.onInstallConversionDataLoadedNative.values());
    }
}
