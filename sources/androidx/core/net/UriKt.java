package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Uri.kt */
public final class UriKt {
    public static final File toFile(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toFile");
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    public static final Uri toUri(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUri");
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return parse;
    }

    public static final Uri toUri(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$toUri");
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
