package com.google.android.play.core.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.review.C2331a;
import com.google.android.play.core.review.C2336g;

/* renamed from: com.google.android.play.core.internal.ad */
public abstract class C2290ad extends C2320k implements C2291ae {
    public C2290ad() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    /* renamed from: a */
    public final boolean mo33277a(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        C2336g gVar = (C2336g) this;
        gVar.f3276c.f3278a.mo33285a();
        gVar.f3274a.mo33278a(4, "onGetLaunchReviewFlowInfo", new Object[0]);
        gVar.f3275b.mo33331b(new C2331a((PendingIntent) ((Bundle) C2321l.m3011a(parcel, Bundle.CREATOR)).get("confirmation_intent")));
        return true;
    }
}
