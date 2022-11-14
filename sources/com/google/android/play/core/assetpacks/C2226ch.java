package com.google.android.play.core.assetpacks;

import com.android.billingclient.api.zzam;

/* renamed from: com.google.android.play.core.assetpacks.ch */
public final /* synthetic */ class C2226ch implements C2231co {

    /* renamed from: a */
    public final C2232cp f3061a;

    /* renamed from: b */
    public final int f3062b;

    public C2226ch(C2232cp cpVar, int i) {
        this.f3061a = cpVar;
        this.f3062b = i;
    }

    /* renamed from: a */
    public final Object mo33216a() {
        C2232cp cpVar = this.f3061a;
        int i = this.f3062b;
        C2229cm e = cpVar.mo33218e(i);
        if (zzam.m32b(e.f3071c.f3066c)) {
            C2198bb bbVar = cpVar.f3079b;
            C2228cl clVar = e.f3071c;
            String str = clVar.f3064a;
            int i2 = e.f3070b;
            long j = clVar.f3065b;
            if (bbVar.mo33187h(str, i2, j).exists()) {
                C2198bb.m2858c(bbVar.mo33187h(str, i2, j));
            }
            C2228cl clVar2 = e.f3071c;
            int i3 = clVar2.f3066c;
            if (i3 != 5 && i3 != 6) {
                return null;
            }
            C2198bb bbVar2 = cpVar.f3079b;
            String str2 = clVar2.f3064a;
            if (!bbVar2.mo33185g(str2).exists()) {
                return null;
            }
            C2198bb.m2858c(bbVar2.mo33185g(str2));
            return null;
        }
        throw new C2214bv(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i)}), i);
    }
}
