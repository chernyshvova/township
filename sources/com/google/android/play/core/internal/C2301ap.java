package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ap */
public final class C2301ap implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ C2302aq f3238a;

    public /* synthetic */ C2301ap(C2302aq aqVar) {
        this.f3238a = aqVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3238a.f3241c.mo33278a(4, "ServiceConnectionImpl.onServiceConnected(%s)", new Object[]{componentName});
        this.f3238a.mo33287b(new C2299an(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3238a.f3241c.mo33278a(4, "ServiceConnectionImpl.onServiceDisconnected(%s)", new Object[]{componentName});
        this.f3238a.mo33287b(new C2300ao(this));
    }
}
