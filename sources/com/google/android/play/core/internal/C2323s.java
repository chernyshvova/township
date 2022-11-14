package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.s */
public abstract class C2323s extends C2320k implements C2324t {
    /* renamed from: a */
    public static C2324t m3020a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof C2324t ? (C2324t) queryLocalInterface : new C2322r(iBinder);
    }
}
