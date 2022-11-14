package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    public final /* synthetic */ Function1 $onCancel;
    public final /* synthetic */ Function1 $onEnd;
    public final /* synthetic */ Function1 $onRepeat;
    public final /* synthetic */ Function1 $onStart;

    public AnimatorKt$addListener$listener$1(Function1 function1, Function1 function12, Function1 function13, Function1 function14) {
        this.$onRepeat = function1;
        this.$onEnd = function12;
        this.$onCancel = function13;
        this.$onStart = function14;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
