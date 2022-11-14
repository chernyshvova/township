package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Icon.kt */
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$toAdaptiveIcon");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        Intrinsics.checkExpressionValueIsNotNull(createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$toIcon");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        Intrinsics.checkExpressionValueIsNotNull(createWithBitmap, "Icon.createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toIcon");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        Intrinsics.checkExpressionValueIsNotNull(createWithContentUri, "Icon.createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toIcon");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(createWithData, "Icon.createWithData(this, 0, size)");
        return createWithData;
    }
}
