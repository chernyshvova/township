package com.applovin.impl.mediation.debugger.p017ui.p019b.p020a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.sdk.C1173j;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a.b */
public class C0917b extends C0929c {

    /* renamed from: a */
    public final C1173j.C1174a f962a;

    /* renamed from: o */
    public final Context f963o;

    /* renamed from: p */
    public final boolean f964p;

    public C0917b(C1173j.C1174a aVar, boolean z, Context context) {
        super(C0929c.C0932b.RIGHT_DETAIL);
        this.f962a = aVar;
        this.f963o = context;
        this.f1027d = new SpannedString(aVar.mo10903a());
        this.f964p = z;
    }

    /* renamed from: b */
    public boolean mo10124b() {
        return true;
    }

    /* renamed from: c_ */
    public SpannedString mo10146c_() {
        return new SpannedString(this.f962a.mo10904b(this.f963o));
    }

    /* renamed from: d_ */
    public boolean mo10147d_() {
        Boolean a = this.f962a.mo10902a(this.f963o);
        if (a != null) {
            return a.equals(Boolean.valueOf(this.f964p));
        }
        return false;
    }
}
