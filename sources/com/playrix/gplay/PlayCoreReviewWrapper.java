package com.playrix.gplay;

import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.review.C2333c;
import com.google.android.play.core.review.C2337h;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.testing.FakeReviewManager;
import com.google.android.play.core.tasks.C2342b;
import com.google.android.play.core.tasks.C2353m;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.TaskExecutors;
import com.playrix.engine.Engine;

public class PlayCoreReviewWrapper {
    public static ReviewInfo _reviewInfo;
    public static ReviewManager _reviewManager;

    public static boolean isLaunchReviewReady() {
        return _reviewInfo != null;
    }

    public static boolean launchReview() {
        if (_reviewInfo == null || Engine.getActivity() == null) {
            return false;
        }
        Task<Void> launchReviewFlow = _reviewManager.launchReviewFlow(Engine.getActivity(), _reviewInfo);
        C33142 r1 = new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        PlayCoreReviewWrapper.launchReviewRequestFinished();
                    }
                });
            }
        };
        C2353m mVar = (C2353m) launchReviewFlow;
        if (mVar != null) {
            mVar.f3305b.mo33329a(new C2342b(TaskExecutors.MAIN_THREAD, r1));
            mVar.mo33336c();
            _reviewInfo = null;
            return true;
        }
        throw null;
    }

    public static native void launchReviewRequestFinished();

    public static boolean prepareReview(boolean z) {
        if (z) {
            _reviewManager = new FakeReviewManager(Engine.getContext());
        } else {
            Context context = Engine.getContext();
            PlayCoreDialogWrapperActivity.m2970a(context);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            _reviewManager = new C2333c(new C2337h(context));
        }
        Task<ReviewInfo> requestReviewFlow = _reviewManager.requestReviewFlow();
        C33121 r0 = new OnCompleteListener<ReviewInfo>() {
            public void onComplete(final Task<ReviewInfo> task) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        if (task.isSuccessful()) {
                            ReviewInfo unused = PlayCoreReviewWrapper._reviewInfo = (ReviewInfo) task.getResult();
                        }
                        PlayCoreReviewWrapper.prepareReviewRequestFinished(task.isSuccessful());
                    }
                });
            }
        };
        C2353m mVar = (C2353m) requestReviewFlow;
        if (mVar != null) {
            mVar.f3305b.mo33329a(new C2342b(TaskExecutors.MAIN_THREAD, r0));
            mVar.mo33336c();
            return true;
        }
        throw null;
    }

    public static native void prepareReviewRequestFinished(boolean z);
}
