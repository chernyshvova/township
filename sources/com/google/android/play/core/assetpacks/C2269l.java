package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.l */
public final /* synthetic */ class C2269l implements ThreadFactory {

    /* renamed from: a */
    public static final ThreadFactory f3209a = new C2269l();

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
