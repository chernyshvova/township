package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Context.kt */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getSystemService");
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, @AttrRes int i, @StyleRes int i2, Function1<? super TypedArray, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$this$withStyledAttributes");
        Intrinsics.checkParameterIsNotNull(iArr, "attrs");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "$this$withStyledAttributes");
        Intrinsics.checkParameterIsNotNull(iArr, "attrs");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, @StyleRes int i, int[] iArr, Function1<? super TypedArray, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "$this$withStyledAttributes");
        Intrinsics.checkParameterIsNotNull(iArr, "attrs");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
