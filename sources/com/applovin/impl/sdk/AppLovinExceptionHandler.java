package com.applovin.impl.sdk;

import android.os.Process;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static final AppLovinExceptionHandler f1276a = new AppLovinExceptionHandler();

    /* renamed from: b */
    public final Set<C1188m> f1277b = new HashSet(2);

    /* renamed from: c */
    public final AtomicBoolean f1278c = new AtomicBoolean();

    /* renamed from: d */
    public Thread.UncaughtExceptionHandler f1279d;

    public static AppLovinExceptionHandler shared() {
        return f1276a;
    }

    public void addSdk(C1188m mVar) {
        this.f1277b.add(mVar);
    }

    public void enable() {
        if (this.f1278c.compareAndSet(false, true)) {
            this.f1279d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        for (C1188m next : this.f1277b) {
            next.mo10922B().mo11372b("AppLovinExceptionHandler", "Detected unhandled exception");
            ((EventServiceImpl) next.mo11007w()).trackEventSynchronously("paused");
            ((EventServiceImpl) next.mo11007w()).trackEventSynchronously("crashed");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1279d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
