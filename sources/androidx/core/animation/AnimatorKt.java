package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13, Function1<? super Animator, Unit> function14) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(function1, "onEnd");
        Intrinsics.checkParameterIsNotNull(function12, "onStart");
        Intrinsics.checkParameterIsNotNull(function13, "onCancel");
        Intrinsics.checkParameterIsNotNull(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = AnimatorKt$addListener$4.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(animator, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(function1, "onEnd");
        Intrinsics.checkParameterIsNotNull(function12, "onStart");
        Intrinsics.checkParameterIsNotNull(function13, "onCancel");
        Intrinsics.checkParameterIsNotNull(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$addPauseListener");
        Intrinsics.checkParameterIsNotNull(function1, "onResume");
        Intrinsics.checkParameterIsNotNull(function12, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(animator, "$this$addPauseListener");
        Intrinsics.checkParameterIsNotNull(function1, "onResume");
        Intrinsics.checkParameterIsNotNull(function12, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnCancel");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$1 animatorKt$doOnCancel$$inlined$addListener$1 = new AnimatorKt$doOnCancel$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$1);
        return animatorKt$doOnCancel$$inlined$addListener$1;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnEnd");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$1 animatorKt$doOnEnd$$inlined$addListener$1 = new AnimatorKt$doOnEnd$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$1);
        return animatorKt$doOnEnd$$inlined$addListener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnPause");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        AnimatorKt$doOnPause$$inlined$addPauseListener$1 animatorKt$doOnPause$$inlined$addPauseListener$1 = new AnimatorKt$doOnPause$$inlined$addPauseListener$1(function1);
        animator.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$1;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnRepeat");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$1 animatorKt$doOnRepeat$$inlined$addListener$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$1);
        return animatorKt$doOnRepeat$$inlined$addListener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnResume");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        AnimatorKt$doOnResume$$inlined$addPauseListener$1 animatorKt$doOnResume$$inlined$addPauseListener$1 = new AnimatorKt$doOnResume$$inlined$addPauseListener$1(function1);
        animator.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$1;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnStart");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        AnimatorKt$doOnStart$$inlined$addListener$1 animatorKt$doOnStart$$inlined$addListener$1 = new AnimatorKt$doOnStart$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$1);
        return animatorKt$doOnStart$$inlined$addListener$1;
    }
}
