package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: Menu.kt */
public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$contains");
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            function1.invoke(item);
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            function2.invoke(valueOf, item);
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$get");
        MenuItem item = menu.getItem(i);
        Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
        return item;
    }

    public static final Sequence<MenuItem> getChildren(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$children");
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$size");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$isEmpty");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$isNotEmpty");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$iterator");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
