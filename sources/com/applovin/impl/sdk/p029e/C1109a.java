package com.applovin.impl.sdk.p029e;

import android.content.Context;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;

/* renamed from: com.applovin.impl.sdk.e.a */
public abstract class C1109a implements Runnable {

    /* renamed from: a */
    public final String f1960a;

    /* renamed from: b */
    public final C1188m f1961b;

    /* renamed from: c */
    public final C1314v f1962c;

    /* renamed from: d */
    public final Context f1963d;

    /* renamed from: e */
    public final boolean f1964e;

    public C1109a(String str, C1188m mVar) {
        this(str, mVar, false);
    }

    public C1109a(String str, C1188m mVar, boolean z) {
        this.f1960a = str;
        this.f1961b = mVar;
        this.f1962c = mVar.mo10922B();
        this.f1963d = mVar.mo10932L();
        this.f1964e = z;
    }

    /* renamed from: a */
    public void mo10768a(String str) {
        this.f1962c.mo11372b(this.f1960a, str);
    }

    /* renamed from: a */
    public void mo10769a(String str, Throwable th) {
        this.f1962c.mo11373b(this.f1960a, str, th);
    }

    /* renamed from: b */
    public void mo10770b(String str) {
        this.f1962c.mo11374c(this.f1960a, str);
    }

    /* renamed from: c */
    public void mo10771c(String str) {
        this.f1962c.mo11375d(this.f1960a, str);
    }

    /* renamed from: d */
    public C1188m mo10772d() {
        return this.f1961b;
    }

    /* renamed from: d */
    public void mo10773d(String str) {
        this.f1962c.mo11376e(this.f1960a, str);
    }

    /* renamed from: e */
    public String mo10774e() {
        return this.f1960a;
    }

    /* renamed from: f */
    public Context mo10775f() {
        return this.f1963d;
    }

    /* renamed from: g */
    public boolean mo10776g() {
        return this.f1964e;
    }
}
