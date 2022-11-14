package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ Function1 $onPause;
    public final /* synthetic */ Function1 $onResume;

    public AnimatorKt$addPauseListener$listener$1(Function1 function1, Function1 function12) {
        this.$onPause = function1;
        this.$onResume = function12;
    }

    public void onAnimationPause(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onPause.invoke(animator);
    }

    public void onAnimationResume(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
