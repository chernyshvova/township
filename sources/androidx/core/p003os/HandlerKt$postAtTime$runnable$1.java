package androidx.core.p003os;

import kotlin.jvm.functions.Function0;

/* renamed from: androidx.core.os.HandlerKt$postAtTime$runnable$1 */
/* compiled from: Handler.kt */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    public final /* synthetic */ Function0 $action;

    public HandlerKt$postAtTime$runnable$1(Function0 function0) {
        this.$action = function0;
    }

    public final void run() {
        this.$action.invoke();
    }
}
