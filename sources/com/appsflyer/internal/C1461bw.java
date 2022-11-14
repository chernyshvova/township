package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.appsflyer.internal.bw */
public abstract class C1461bw extends Observable {
    public final Runnable AFInAppEventParameterName;
    public C1463d AFInAppEventType = C1463d.NOT_STARTED;
    public final Map<String, Object> AFKeystoreWrapper = new HashMap();
    public final String valueOf;
    public long values;

    /* renamed from: com.appsflyer.internal.bw$d */
    public enum C1463d {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public C1461bw(String str, Runnable runnable) {
        this.AFInAppEventParameterName = runnable;
        this.valueOf = str;
    }

    public abstract void AFInAppEventType(Context context);

    public final void AFKeystoreWrapper() {
        this.AFKeystoreWrapper.put("source", this.valueOf);
        this.AFKeystoreWrapper.putAll(new C1456bs());
        this.AFKeystoreWrapper.put("latency", Long.valueOf(System.currentTimeMillis() - this.values));
        this.AFInAppEventType = C1463d.FINISHED;
        setChanged();
        notifyObservers();
    }

    public final void values() {
        this.values = System.currentTimeMillis();
        this.AFInAppEventType = C1463d.STARTED;
        addObserver(new Observer() {
            public final void update(Observable observable, Object obj) {
                C1461bw.this.AFInAppEventParameterName.run();
            }
        });
    }
}
