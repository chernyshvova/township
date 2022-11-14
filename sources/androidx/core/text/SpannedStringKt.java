package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannedString.kt */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(spanned, "$this$getSpans");
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        int i4 = i3 & 1;
        if ((i3 & 2) != 0) {
            spanned.length();
        }
        Intrinsics.checkParameterIsNotNull(spanned, "$this$getSpans");
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$toSpanned");
        SpannedString valueOf = SpannedString.valueOf(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
