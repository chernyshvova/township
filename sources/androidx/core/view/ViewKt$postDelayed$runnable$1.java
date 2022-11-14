package androidx.core.view;

import kotlin.jvm.functions.Function0;

/* compiled from: View.kt */
public final class ViewKt$postDelayed$runnable$1 implements Runnable {
    public final /* synthetic */ Function0 $action;

    public ViewKt$postDelayed$runnable$1(Function0 function0) {
        this.$action = function0;
    }

    public final void run() {
        this.$action.invoke();
    }
}
