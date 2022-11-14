package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C2349i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.c */
public final class C2333c implements ReviewManager {

    /* renamed from: a */
    public final C2337h f3269a;

    /* renamed from: b */
    public final Handler f3270b = new Handler(Looper.getMainLooper());

    public C2333c(C2337h hVar) {
        this.f3269a = hVar;
    }

    public final Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", ((C2331a) reviewInfo).f3267a);
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        C2349i iVar = new C2349i();
        intent.putExtra("result_receiver", new C2332b(this.f3270b, iVar));
        activity.startActivity(intent);
        return iVar.f3302a;
    }

    public final Task<ReviewInfo> requestReviewFlow() {
        C2337h hVar = this.f3269a;
        C2337h.f3277b.mo33278a(4, "requestInAppReview (%s)", new Object[]{hVar.f3279c});
        C2349i iVar = new C2349i();
        hVar.f3278a.mo33286a(new C2335e(hVar, iVar, iVar));
        return iVar.f3302a;
    }
}
