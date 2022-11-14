package androidx.core.view;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ Function1 $action;
    public final /* synthetic */ View $this_doOnAttach;

    public ViewKt$doOnAttach$1(View view, Function1 function1) {
        this.$this_doOnAttach = view;
        this.$action = function1;
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
    }
}
