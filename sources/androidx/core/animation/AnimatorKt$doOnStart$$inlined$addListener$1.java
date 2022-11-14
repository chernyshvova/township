package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt$doOnStart$$inlined$addListener$1 implements Animator.AnimatorListener {
    public final /* synthetic */ Function1 $onStart;

    public AnimatorKt$doOnStart$$inlined$addListener$1(Function1 function1) {
        this.$onStart = function1;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
