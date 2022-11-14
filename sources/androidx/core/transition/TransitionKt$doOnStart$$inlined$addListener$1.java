package androidx.core.transition;

import android.transition.Transition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
public final class TransitionKt$doOnStart$$inlined$addListener$1 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onStart;

    public TransitionKt$doOnStart$$inlined$addListener$1(Function1 function1) {
        this.$onStart = function1;
    }

    public void onTransitionCancel(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
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
        this.$onStart.invoke(transition);
    }
}
