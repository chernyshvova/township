package com.facebook.internal.instrument.crashshield;

/* compiled from: CrashShieldHandler.kt */
public final class CrashShieldHandler$scheduleCrashInDebug$1 implements Runnable {

    /* renamed from: $e */
    public final /* synthetic */ Throwable f2756$e;

    public CrashShieldHandler$scheduleCrashInDebug$1(Throwable th) {
        this.f2756$e = th;
    }

    public void run() {
        throw new RuntimeException(this.f2756$e);
    }
}
