package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2315ck;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.bw */
public final class C2215bw {

    /* renamed from: a */
    public static final C2292ag f3022a = new C2292ag("ExtractorLooper");

    /* renamed from: b */
    public final C2232cp f3023b;

    /* renamed from: c */
    public final C2212bt f3024c;

    /* renamed from: d */
    public final C2261dv f3025d;

    /* renamed from: e */
    public final C2245df f3026e;

    /* renamed from: f */
    public final C2249dj f3027f;

    /* renamed from: g */
    public final C2254do f3028g;

    /* renamed from: h */
    public final C2315ck<C2281w> f3029h;

    /* renamed from: i */
    public final C2235cs f3030i;

    /* renamed from: j */
    public final AtomicBoolean f3031j = new AtomicBoolean(false);

    public C2215bw(C2232cp cpVar, C2315ck<C2281w> ckVar, C2212bt btVar, C2261dv dvVar, C2245df dfVar, C2249dj djVar, C2254do doVar, C2235cs csVar) {
        this.f3023b = cpVar;
        this.f3029h = ckVar;
        this.f3024c = btVar;
        this.f3025d = dvVar;
        this.f3026e = dfVar;
        this.f3027f = djVar;
        this.f3028g = doVar;
        this.f3030i = csVar;
    }

    /* renamed from: a */
    public final void mo33211a(int i, Exception exc) {
        try {
            C2232cp cpVar = this.f3023b;
            cpVar.mo33217a(new C2225cg(cpVar, i));
            C2232cp cpVar2 = this.f3023b;
            cpVar2.mo33217a(new C2226ch(cpVar2, i));
        } catch (C2214bv unused) {
            f3022a.mo33278a(6, "Error during error handling: %s", new Object[]{exc.getMessage()});
        }
    }
}
