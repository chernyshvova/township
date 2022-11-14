package androidx.core.animation;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Animator.kt */
public final class AnimatorKt$addListener$4 extends Lambda implements Function1<Animator, Unit> {
    public static final AnimatorKt$addListener$4 INSTANCE = new AnimatorKt$addListener$4();

    public AnimatorKt$addListener$4() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "it");
    }
}
