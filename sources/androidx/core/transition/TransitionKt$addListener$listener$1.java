package androidx.core.transition;

import android.transition.Transition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onCancel;
    public final /* synthetic */ Function1 $onEnd;
    public final /* synthetic */ Function1 $onPause;
    public final /* synthetic */ Function1 $onResume;
    public final /* synthetic */ Function1 $onStart;

    public TransitionKt$addListener$listener$1(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15) {
        this.$onEnd = function1;
        this.$onResume = function12;
        this.$onPause = function13;
        this.$onCancel = function14;
        this.$onStart = function15;
    }

    public void onTransitionCancel(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onPause.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        this.$onStart.invoke(transition);
    }
}
