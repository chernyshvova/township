package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Region.kt */
public final class RegionKt {
    public static final Region and(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$and");
        Intrinsics.checkParameterIsNotNull(rect, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(Region region, Point point) {
        Intrinsics.checkParameterIsNotNull(region, "$this$contains");
        Intrinsics.checkParameterIsNotNull(point, AnalyticsEventKey.PROTOCOL);
        return region.contains(point.x, point.y);
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(region, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (regionIterator.next(rect)) {
                function1.invoke(rect);
            } else {
                return;
            }
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        Intrinsics.checkParameterIsNotNull(region, "$this$iterator");
        return new RegionKt$iterator$1(region);
    }

    public static final Region minus(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$minus");
        Intrinsics.checkParameterIsNotNull(rect, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region not(Region region) {
        Intrinsics.checkParameterIsNotNull(region, "$this$not");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    /* renamed from: or */
    public static final Region m9or(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$or");
        Intrinsics.checkParameterIsNotNull(rect, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region plus(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$plus");
        Intrinsics.checkParameterIsNotNull(rect, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        Intrinsics.checkParameterIsNotNull(region, "$this$unaryMinus");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region xor(Region region, Rect rect) {
        Intrinsics.checkParameterIsNotNull(region, "$this$xor");
        Intrinsics.checkParameterIsNotNull(rect, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final Region and(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$and");
        Intrinsics.checkParameterIsNotNull(region2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final Region minus(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$minus");
        Intrinsics.checkParameterIsNotNull(region2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    /* renamed from: or */
    public static final Region m10or(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$or");
        Intrinsics.checkParameterIsNotNull(region2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region plus(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$plus");
        Intrinsics.checkParameterIsNotNull(region2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region xor(Region region, Region region2) {
        Intrinsics.checkParameterIsNotNull(region, "$this$xor");
        Intrinsics.checkParameterIsNotNull(region2, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
