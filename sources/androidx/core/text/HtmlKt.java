package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Html.kt */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        Intrinsics.checkParameterIsNotNull(str, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        Intrinsics.checkExpressionValueIsNotNull(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        Intrinsics.checkParameterIsNotNull(str, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        Intrinsics.checkExpressionValueIsNotNull(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static final String toHtml(Spanned spanned, int i) {
        Intrinsics.checkParameterIsNotNull(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i);
        Intrinsics.checkExpressionValueIsNotNull(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i);
        Intrinsics.checkExpressionValueIsNotNull(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
