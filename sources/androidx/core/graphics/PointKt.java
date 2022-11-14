package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import com.helpshift.analytics.AnalyticsEventKey;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Point.kt */
public final class PointKt {
    public static final int component1(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$component1");
        return point.x;
    }

    public static final int component2(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$component2");
        return point.y;
    }

    public static final Point minus(Point point, Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "$this$minus");
        Intrinsics.checkParameterIsNotNull(point2, AnalyticsEventKey.PROTOCOL);
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final Point plus(Point point, Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "$this$plus");
        Intrinsics.checkParameterIsNotNull(point2, AnalyticsEventKey.PROTOCOL);
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final Point toPoint(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$toPoint");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    public static final PointF toPointF(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$toPointF");
        return new PointF(point);
    }

    public static final Point unaryMinus(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$unaryMinus");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$component1");
        return pointF.x;
    }

    public static final float component2(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$component2");
        return pointF.y;
    }

    public static final PointF unaryMinus(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$unaryMinus");
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$minus");
        Intrinsics.checkParameterIsNotNull(pointF2, AnalyticsEventKey.PROTOCOL);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pointF2, AnalyticsEventKey.PROTOCOL);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final Point minus(Point point, int i) {
        Intrinsics.checkParameterIsNotNull(point, "$this$minus");
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    public static final Point plus(Point point, int i) {
        Intrinsics.checkParameterIsNotNull(point, "$this$plus");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    public static final PointF minus(PointF pointF, float f) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$minus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, float f) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$plus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
