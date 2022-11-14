package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.C0030Px;
import androidx.annotation.RequiresApi;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: ViewGroup.kt */
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$contains");
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            function1.invoke(childAt);
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Integer valueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            function2.invoke(valueOf, childAt);
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$get");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder outline25 = GeneratedOutlineSupport.outline25("Index: ", i, ", Size: ");
        outline25.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(outline25.toString());
    }

    public static final Sequence<View> getChildren(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$children");
        return new ViewGroupKt$children$1(viewGroup);
    }

    public static final int getSize(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$size");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$isEmpty");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$isNotEmpty");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$iterator");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @C0030Px int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$this$setMargins");
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @C0030Px int i, @C0030Px int i2, @C0030Px int i3, @C0030Px int i4) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$this$updateMargins");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$this$updateMargins");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @C0030Px int i, @C0030Px int i2, @C0030Px int i3, @C0030Px int i4) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$this$updateMarginsRelative");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$this$updateMarginsRelative");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
