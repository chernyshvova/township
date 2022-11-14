package com.iab.omid.library.applovin.p044a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* renamed from: com.iab.omid.library.applovin.a.d */
public final class C2837d extends ContentObserver {

    /* renamed from: a */
    public final Context f3371a;

    /* renamed from: b */
    public final AudioManager f3372b;

    /* renamed from: c */
    public final C2834a f3373c;

    /* renamed from: d */
    public final C2836c f3374d;

    /* renamed from: e */
    public float f3375e;

    public C2837d(Handler handler, Context context, C2834a aVar, C2836c cVar) {
        super(handler);
        this.f3371a = context;
        this.f3372b = (AudioManager) context.getSystemService("audio");
        this.f3373c = aVar;
        this.f3374d = cVar;
    }

    /* renamed from: a */
    private boolean m3254a(float f) {
        return f != this.f3375e;
    }

    /* renamed from: c */
    private float m3255c() {
        return this.f3373c.mo36630a(this.f3372b.getStreamVolume(3), this.f3372b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m3256d() {
        this.f3374d.mo36632a(this.f3375e);
    }

    /* renamed from: a */
    public void mo36633a() {
        this.f3375e = m3255c();
        m3256d();
        this.f3371a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public void mo36634b() {
        this.f3371a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = m3255c();
        if (m3254a(c)) {
            this.f3375e = c;
            m3256d();
        }
    }
}
