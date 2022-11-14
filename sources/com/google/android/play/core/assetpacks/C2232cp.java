package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2315ck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.play.core.assetpacks.cp */
public final class C2232cp {

    /* renamed from: a */
    public static final C2292ag f3078a = new C2292ag("ExtractorSessionStoreView");

    /* renamed from: b */
    public final C2198bb f3079b;

    /* renamed from: c */
    public final C2315ck<C2281w> f3080c;

    /* renamed from: d */
    public final C2218bz f3081d;

    /* renamed from: f */
    public final Map<Integer, C2229cm> f3082f = new HashMap();

    /* renamed from: g */
    public final ReentrantLock f3083g = new ReentrantLock();

    public C2232cp(C2198bb bbVar, C2315ck<C2281w> ckVar, C2218bz bzVar, C2315ck<Executor> ckVar2) {
        this.f3079b = bbVar;
        this.f3080c = ckVar;
        this.f3081d = bzVar;
    }

    /* renamed from: e */
    public static String m2899e(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new C2214bv("Session without pack received.");
    }

    /* renamed from: a */
    public final <T> T mo33217a(C2231co<T> coVar) {
        try {
            this.f3083g.lock();
            return coVar.mo33216a();
        } finally {
            this.f3083g.unlock();
        }
    }

    /* renamed from: e */
    public final C2229cm mo33218e(int i) {
        Map<Integer, C2229cm> map = this.f3082f;
        Integer valueOf = Integer.valueOf(i);
        C2229cm cmVar = map.get(valueOf);
        if (cmVar != null) {
            return cmVar;
        }
        throw new C2214bv(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i);
    }
}
