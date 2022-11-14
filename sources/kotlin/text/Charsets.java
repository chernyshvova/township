package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charsets.kt */
public final class Charsets {
    public static final Charset US_ASCII;
    public static final Charset UTF_8;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(\"UTF-8\")");
        UTF_8 = forName;
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        Charset forName2 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(forName2, "Charset.forName(\"US-ASCII\")");
        US_ASCII = forName2;
        Intrinsics.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
