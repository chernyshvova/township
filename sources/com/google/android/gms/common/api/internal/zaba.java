package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaba {
    public static final ExecutorService zaa = zao.zaa().zaa(2, new NumberedThreadFactory("GAC_Executor"), zap.zab);

    public static ExecutorService zaa() {
        return zaa;
    }
}
