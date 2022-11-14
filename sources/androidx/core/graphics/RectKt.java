package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.helpshift.analytics.AnalyticsEventKey;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Rect.kt */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect rect, Rect rect2) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$and");
        Intrinsics.checkParameterIsNotNull(rect2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$component1");
        return rect.left;
    }

    public static final int component2(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$component2");
        return rect.top;
    }

    public static final int component3(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$component3");
        return rect.right;
    }

    public static final int component4(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$component4");
        return rect.bottom;
    }

    public static final boolean contains(Rect rect, Point point) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$contains");
        Intrinsics.checkParameterIsNotNull(point, AnalyticsEventKey.PROTOCOL);
        return rect.contains(point.x, point.y);
    }

    public static final Region minus(Rect rect, Rect rect2) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$minus");
        Intrinsics.checkParameterIsNotNull(rect2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    /* renamed from: or */
    public static final Rect m7or(Rect rect, Rect rect2) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$or");
        Intrinsics.checkParameterIsNotNull(rect2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final Rect plus(Rect rect, Rect rect2) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$plus");
        Intrinsics.checkParameterIsNotNull(rect2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final Rect times(Rect rect, int i) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$times");
        Rect rect2 = new Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    public static final Rect toRect(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$toRect");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$toRectF");
        return new RectF(rect);
    }

    public static final Region toRegion(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$toRegion");
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$transform");
        Intrinsics.checkParameterIsNotNull(matrix, PaintCompat.EM_STRING);
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(Rect rect, Rect rect2) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$xor");
        Intrinsics.checkParameterIsNotNull(rect2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$component1");
        return rectF.left;
    }

    public static final float component2(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$component2");
        return rectF.top;
    }

    public static final float component3(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$component3");
        return rectF.right;
    }

    public static final float component4(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$component4");
        return rectF.bottom;
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$contains");
        Intrinsics.checkParameterIsNotNull(pointF, AnalyticsEventKey.PROTOCOL);
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final Region toRegion(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$toRegion");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF rectF2) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$and");
        Intrinsics.checkParameterIsNotNull(rectF2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final Rect minus(Rect rect, int i) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$minus");
        Rect rect2 = new Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    /* renamed from: or */
    public static final RectF m8or(RectF rectF, RectF rectF2) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$or");
        Intrinsics.checkParameterIsNotNull(rectF2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$plus");
        Intrinsics.checkParameterIsNotNull(rectF2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$xor");
        Intrinsics.checkParameterIsNotNull(rectF2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final RectF minus(RectF rectF, float f) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$minus");
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final Rect plus(Rect rect, int i) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$plus");
        Rect rect2 = new Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    public static final RectF times(RectF rectF, float f) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$times");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final Rect minus(Rect rect, Point point) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$minus");
        Intrinsics.checkParameterIsNotNull(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    public static final RectF plus(RectF rectF, float f) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$plus");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$minus");
        Intrinsics.checkParameterIsNotNull(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }

    public static final Rect plus(Rect rect, Point point) {
        Intrinsics.checkParameterIsNotNull(rect, "$this$plus");
        Intrinsics.checkParameterIsNotNull(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$minus");
        Intrinsics.checkParameterIsNotNull(rectF2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i) {
        Intrinsics.checkParameterIsNotNull(rectF, "$this$times");
        float f = (float) i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }
}
