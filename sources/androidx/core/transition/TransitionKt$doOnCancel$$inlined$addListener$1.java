package androidx.core.transition;

import android.transition.Transition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
public final class TransitionKt$doOnCancel$$inlined$addListener$1 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onCancel;

    public TransitionKt$doOnCancel$$inlined$addListener$1(Function1 function1) {
        this.$onCancel = function1;
    }

    public void onTransitionCancel(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
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
