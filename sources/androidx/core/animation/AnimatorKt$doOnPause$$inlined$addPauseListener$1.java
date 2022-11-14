package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt$doOnPause$$inlined$addPauseListener$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ Function1 $onPause;

    public AnimatorKt$doOnPause$$inlined$addPauseListener$1(Function1 function1) {
        this.$onPause = function1;
    }

    public void onAnimationPause(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onPause.invoke(animator);
    }

    public void onAnimationResume(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }
}
