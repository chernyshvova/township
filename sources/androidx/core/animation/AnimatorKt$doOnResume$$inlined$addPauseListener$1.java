package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt$doOnResume$$inlined$addPauseListener$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ Function1 $onResume;

    public AnimatorKt$doOnResume$$inlined$addPauseListener$1(Function1 function1) {
        this.$onResume = function1;
    }

    public void onAnimationPause(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationResume(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
