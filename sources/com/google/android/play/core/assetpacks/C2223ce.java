package com.google.android.play.core.assetpacks;

import com.android.billingclient.api.zzam;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ce */
public final /* synthetic */ class C2223ce implements C2231co {

    /* renamed from: a */
    public final C2232cp f3053a;

    /* renamed from: b */
    public final String f3054b;

    /* renamed from: c */
    public final int f3055c;

    /* renamed from: d */
    public final long f3056d;

    public C2223ce(C2232cp cpVar, String str, int i, long j) {
        this.f3053a = cpVar;
        this.f3054b = str;
        this.f3055c = i;
        this.f3056d = j;
    }

    /* renamed from: a */
    public final Object mo33216a() {
        C2232cp cpVar = this.f3053a;
        String str = this.f3054b;
        int i = this.f3055c;
        long j = this.f3056d;
        if (cpVar != null) {
            C2229cm cmVar = (C2229cm) ((Map) cpVar.mo33217a(new C2224cf(cpVar, Arrays.asList(new String[]{str})))).get(str);
            if (cmVar == null || zzam.m32b(cmVar.f3071c.f3066c)) {
                C2232cp.f3078a.mo33278a(6, String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
            }
            C2198bb bbVar = cpVar.f3079b;
            if (bbVar.mo33187h(str, i, j).exists()) {
                C2198bb.m2858c(bbVar.mo33187h(str, i, j));
            }
            cmVar.f3071c.f3066c = 4;
            return null;
        }
        throw null;
    }
}
