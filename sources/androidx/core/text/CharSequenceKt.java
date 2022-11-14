package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharSequence.kt */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$isDigitsOnly");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimmedLength");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
