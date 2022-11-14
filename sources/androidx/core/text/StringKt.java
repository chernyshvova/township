package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: String.kt */
public final class StringKt {
    public static final String htmlEncode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$htmlEncode");
        String htmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.checkExpressionValueIsNotNull(htmlEncode, "TextUtils.htmlEncode(this)");
        return htmlEncode;
    }
}
