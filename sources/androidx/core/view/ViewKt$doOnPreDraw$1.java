package androidx.core.view;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* compiled from: View.kt */
public final class ViewKt$doOnPreDraw$1 implements Runnable {
    public final /* synthetic */ Function1 $action;
    public final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(View view, Function1 function1) {
        this.$this_doOnPreDraw = view;
        this.$action = function1;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
