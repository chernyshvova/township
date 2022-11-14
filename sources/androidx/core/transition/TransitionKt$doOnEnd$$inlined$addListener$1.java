package androidx.core.transition;

import android.transition.Transition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
public final class TransitionKt$doOnEnd$$inlined$addListener$1 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onEnd;

    public TransitionKt$doOnEnd$$inlined$addListener$1(Function1 function1) {
        this.$onEnd = function1;
    }

    public void onTransitionCancel(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
    }

    public void onTransitionEnd(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
    }

    public void onTransitionResume(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
    }

    public void onTransitionStart(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
    }
}
