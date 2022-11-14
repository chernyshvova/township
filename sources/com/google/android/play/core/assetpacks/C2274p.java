package com.google.android.play.core.assetpacks;

import com.android.billingclient.api.zzam;
import com.google.android.play.core.internal.C2318co;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.p */
public final class C2274p implements C2318co<Executor> {
    /* renamed from: a */
    public final Object mo33167a() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C2269l.f3209a);
        zzam.m31b(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }
}
