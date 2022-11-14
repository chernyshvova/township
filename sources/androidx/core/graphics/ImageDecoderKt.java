package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageDecoder.kt */
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(source, "$this$decodeBitmap");
        Intrinsics.checkParameterIsNotNull(function3, "action");
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoderKt$decodeBitmap$1(function3));
        Intrinsics.checkExpressionValueIsNotNull(decodeBitmap, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return decodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(source, "$this$decodeDrawable");
        Intrinsics.checkParameterIsNotNull(function3, "action");
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoderKt$decodeDrawable$1(function3));
        Intrinsics.checkExpressionValueIsNotNull(decodeDrawable, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return decodeDrawable;
    }
}
