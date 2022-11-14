package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BitmapDrawable.kt */
public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$toDrawable");
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
