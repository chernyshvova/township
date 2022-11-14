package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt$doOnCancel$$inlined$addListener$1 implements Animator.AnimatorListener {
    public final /* synthetic */ Function1 $onCancel;

    public AnimatorKt$doOnCancel$$inlined$addListener$1(Function1 function1) {
        this.$onCancel = function1;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }
}
