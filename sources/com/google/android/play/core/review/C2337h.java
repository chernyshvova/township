package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.C2289ac;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2302aq;

/* renamed from: com.google.android.play.core.review.h */
public final class C2337h {

    /* renamed from: b */
    public static final C2292ag f3277b = new C2292ag("ReviewService");

    /* renamed from: a */
    public final C2302aq<C2289ac> f3278a;

    /* renamed from: c */
    public final String f3279c;

    public C2337h(Context context) {
        this.f3279c = context.getPackageName();
        Context context2 = context;
        this.f3278a = new C2302aq(context2, f3277b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C2334d.f3271a);
    }
}
