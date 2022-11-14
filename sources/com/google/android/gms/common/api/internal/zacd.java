package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zacd {
    public static final ExecutorService zaa = zao.zaa().zaa((ThreadFactory) new NumberedThreadFactory("GAC_Transform"), zap.zaa);

    public static ExecutorService zaa() {
        return zaa;
    }
}
