package com.google.android.play.core.assetpacks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2315ck;
import com.google.android.play.core.splitinstall.C2339p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.j */
public final class C2267j {

    /* renamed from: a */
    public static final C2292ag f3196a = new C2292ag("AssetPackManager");

    /* renamed from: b */
    public final C2198bb f3197b;

    /* renamed from: c */
    public final C2315ck<C2281w> f3198c;

    /* renamed from: d */
    public final C2192aw f3199d;

    /* renamed from: i */
    public final C2315ck<Executor> f3200i;

    public C2267j(C2198bb bbVar, C2315ck<C2281w> ckVar, C2192aw awVar, C2339p pVar, C2232cp cpVar, C2218bz bzVar, C2207bn bnVar, C2315ck<Executor> ckVar2) {
        new Handler(Looper.getMainLooper());
        this.f3197b = bbVar;
        this.f3198c = ckVar;
        this.f3199d = awVar;
        this.f3200i = ckVar2;
    }

    /* renamed from: a */
    public final void mo33267a(boolean z) {
        boolean z2;
        C2192aw awVar = this.f3199d;
        synchronized (awVar) {
            z2 = awVar.e$com$google$android$play$core$listener$b != null;
        }
        C2192aw awVar2 = this.f3199d;
        synchronized (awVar2) {
            awVar2.f$com$google$android$play$core$listener$b = z;
            awVar2.mo33172c();
        }
        if (z && !z2) {
            this.f3200i.mo33293a().execute(new C2264e(this));
        }
    }
}
