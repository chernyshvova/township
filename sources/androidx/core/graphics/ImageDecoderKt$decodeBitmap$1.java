package androidx.core.graphics;

import android.graphics.ImageDecoder;
import com.facebook.GraphRequest;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageDecoder.kt */
public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder.OnHeaderDecodedListener {
    public final /* synthetic */ Function3 $action;

    public ImageDecoderKt$decodeBitmap$1(Function3 function3) {
        this.$action = function3;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Intrinsics.checkParameterIsNotNull(imageDecoder, "decoder");
        Intrinsics.checkParameterIsNotNull(imageInfo, GraphRequest.DEBUG_SEVERITY_INFO);
        Intrinsics.checkParameterIsNotNull(source, "source");
        this.$action.invoke(imageDecoder, imageInfo, source);
    }
}
