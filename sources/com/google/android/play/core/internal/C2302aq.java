package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.internal.aq */
public final class C2302aq<T extends IInterface> {

    /* renamed from: a */
    public static final Map<String, Handler> f3239a = new HashMap();

    /* renamed from: b */
    public final Context f3240b;

    /* renamed from: c */
    public final C2292ag f3241c;

    /* renamed from: d */
    public final String f3242d;

    /* renamed from: e */
    public final List<C2293ah> f3243e = new ArrayList();

    /* renamed from: f */
    public boolean f3244f;

    /* renamed from: g */
    public final Intent f3245g;

    /* renamed from: h */
    public final C2298am<T> f3246h;

    /* renamed from: i */
    public final WeakReference<C2297al> f3247i;

    /* renamed from: j */
    public final IBinder.DeathRecipient f3248j = new C2294ai(this);

    /* renamed from: k */
    public ServiceConnection f3249k;

    /* renamed from: l */
    public T f3250l;

    public C2302aq(Context context, C2292ag agVar, String str, Intent intent, C2298am<T> amVar) {
        this.f3240b = context;
        this.f3241c = agVar;
        this.f3242d = str;
        this.f3245g = intent;
        this.f3246h = amVar;
        this.f3247i = new WeakReference<>((Object) null);
    }

    /* renamed from: a */
    public final void mo33285a() {
        mo33287b(new C2296ak(this));
    }

    /* renamed from: a */
    public final void mo33286a(C2293ah ahVar) {
        mo33287b(new C2295aj(this, ahVar.f3230a, ahVar));
    }

    /* renamed from: b */
    public final void mo33287b(C2293ah ahVar) {
        Handler handler;
        synchronized (f3239a) {
            if (!f3239a.containsKey(this.f3242d)) {
                HandlerThread handlerThread = new HandlerThread(this.f3242d, 10);
                handlerThread.start();
                f3239a.put(this.f3242d, new Handler(handlerThread.getLooper()));
            }
            handler = f3239a.get(this.f3242d);
        }
        handler.post(ahVar);
    }
}
