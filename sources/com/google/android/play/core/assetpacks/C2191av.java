package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.av */
public final /* synthetic */ class C2191av implements Runnable {

    /* renamed from: a */
    public final C2192aw f2920a;

    /* renamed from: b */
    public final Bundle f2921b;

    public C2191av(C2192aw awVar, Bundle bundle) {
        this.f2920a = awVar;
        this.f2921b = bundle;
    }

    public final void run() {
        C2234cr crVar;
        C2192aw awVar = this.f2920a;
        Bundle bundle = this.f2921b;
        C2232cp cpVar = awVar.f2924c;
        if (((Boolean) cpVar.mo33217a(new C2221cc(cpVar, bundle))).booleanValue()) {
            C2215bw bwVar = awVar.f2925d;
            if (bwVar != null) {
                C2215bw.f3022a.mo33278a(3, "Run extractor loop", new Object[0]);
                if (bwVar.f3031j.compareAndSet(false, true)) {
                    while (true) {
                        try {
                            crVar = bwVar.f3030i.mo33219a();
                        } catch (C2214bv e) {
                            C2215bw.f3022a.mo33278a(6, "Error while getting next extraction task: %s", new Object[]{e.getMessage()});
                            if (e.f3021a >= 0) {
                                bwVar.f3029h.mo33293a().mo33161a(e.f3021a);
                                bwVar.mo33211a(e.f3021a, e);
                            }
                            crVar = null;
                        }
                        if (crVar != null) {
                            try {
                                if (crVar instanceof C2211bs) {
                                    bwVar.f3024c.mo33209a((C2211bs) crVar);
                                } else if (crVar instanceof C2260du) {
                                    bwVar.f3025d.mo33258a((C2260du) crVar);
                                } else if (crVar instanceof C2244de) {
                                    bwVar.f3026e.mo33234a((C2244de) crVar);
                                } else if (crVar instanceof C2247dh) {
                                    bwVar.f3027f.mo33236a((C2247dh) crVar);
                                } else if (crVar instanceof C2253dn) {
                                    bwVar.f3028g.mo33238a((C2253dn) crVar);
                                } else {
                                    C2215bw.f3022a.mo33278a(6, "Unknown task type: %s", new Object[]{crVar.getClass().getName()});
                                }
                            } catch (Exception e2) {
                                C2215bw.f3022a.mo33278a(6, "Error during extraction task: %s", new Object[]{e2.getMessage()});
                                bwVar.f3029h.mo33293a().mo33161a(crVar.f3088j);
                                bwVar.mo33211a(crVar.f3088j, e2);
                            }
                        } else {
                            bwVar.f3031j.set(false);
                            return;
                        }
                    }
                } else {
                    C2215bw.f3022a.mo33278a(5, "runLoop already looping; return", new Object[0]);
                }
            } else {
                throw null;
            }
        }
    }
}
