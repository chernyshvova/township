package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.ab */
public abstract class C2288ab extends C2320k implements C2289ac {
    /* renamed from: a */
    public static C2289ac m2975a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof C2289ac ? (C2289ac) queryLocalInterface : new C2287aa(iBinder);
    }
}
