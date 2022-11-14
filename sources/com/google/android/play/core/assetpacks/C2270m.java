package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.m */
public final /* synthetic */ class C2270m implements ThreadFactory {

    /* renamed from: a */
    public static final ThreadFactory f3210a = new C2270m();

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
