package androidx.core.transition;

import android.transition.Transition;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Transition.kt */
public final class TransitionKt$addListener$2 extends Lambda implements Function1<Transition, Unit> {
    public static final TransitionKt$addListener$2 INSTANCE = new TransitionKt$addListener$2();

    public TransitionKt$addListener$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Transition) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "it");
    }
}
