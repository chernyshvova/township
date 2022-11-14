package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Canvas.kt */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withClip");
        Intrinsics.checkParameterIsNotNull(rect, "clipRect");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withMatrix");
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static void withMatrix$default(Canvas canvas, Matrix matrix, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withMatrix");
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f2, float f3, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withRotation");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static void withRotation$default(Canvas canvas, float f, float f2, float f3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withRotation");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withSave(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withSave");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f2, float f3, float f4, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withScale");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withScale");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f2, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withSkew");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static void withSkew$default(Canvas canvas, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withSkew");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f2, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withTranslation");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static void withTranslation$default(Canvas canvas, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withTranslation");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withClip");
        Intrinsics.checkParameterIsNotNull(rectF, "clipRect");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, int i, int i2, int i3, int i4, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withClip");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f2, float f3, float f4, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withClip");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, Path path, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(canvas, "$this$withClip");
        Intrinsics.checkParameterIsNotNull(path, "clipPath");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            function1.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }
}
