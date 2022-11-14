package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.android.billingclient.api.zzam;
import com.google.android.play.core.review.C2331a;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.C2353m;
import com.google.android.play.core.tasks.Task;

public class FakeReviewManager implements ReviewManager {

    /* renamed from: a */
    public final Context f3280a;

    /* renamed from: b */
    public ReviewInfo f3281b;

    public FakeReviewManager(Context context) {
        this.f3280a = context;
    }

    public Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo == this.f3281b) {
            return zzam.m17a(null);
        }
        C2338a aVar = new C2338a();
        C2353m mVar = new C2353m();
        mVar.mo33334a((Exception) aVar);
        return mVar;
    }

    public Task<ReviewInfo> requestReviewFlow() {
        C2331a aVar = new C2331a(PendingIntent.getBroadcast(this.f3280a, 0, new Intent(), 0));
        this.f3281b = aVar;
        return zzam.m17a(aVar);
    }
}
