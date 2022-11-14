package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Picture.kt */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(picture, "$this$record");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Canvas beginRecording = picture.beginRecording(i, i2);
        try {
            Intrinsics.checkExpressionValueIsNotNull(beginRecording, "c");
            function1.invoke(beginRecording);
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
