package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.LocalTestingException;

/* renamed from: com.google.android.play.core.assetpacks.cw */
public final /* synthetic */ class C2237cw implements Runnable {

    /* renamed from: a */
    public final C2240cz f3097a;

    /* renamed from: b */
    public final int f3098b;

    /* renamed from: c */
    public final String f3099c;

    public C2237cw(C2240cz czVar, int i, String str) {
        this.f3097a = czVar;
        this.f3098b = i;
        this.f3099c = str;
    }

    public final void run() {
        C2240cz czVar = this.f3097a;
        int i = this.f3098b;
        String str = this.f3099c;
        if (czVar != null) {
            try {
                czVar.mo33224a(i, str, 4);
            } catch (LocalTestingException e) {
                C2240cz.f3103a.mo33278a(5, "notifyModuleCompleted failed", new Object[]{e});
            }
        } else {
            throw null;
        }
    }
}
