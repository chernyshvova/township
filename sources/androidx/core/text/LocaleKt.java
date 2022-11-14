package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Locale.kt */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale locale) {
        Intrinsics.checkParameterIsNotNull(locale, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
