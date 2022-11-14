package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Path.kt */
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path path, Path path2) {
        Intrinsics.checkParameterIsNotNull(path, "$this$and");
        Intrinsics.checkParameterIsNotNull(path2, AnalyticsEventKey.PROTOCOL);
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f) {
        Intrinsics.checkParameterIsNotNull(path, "$this$flatten");
        Collection<PathSegment> flatten = PathUtils.flatten(path, f);
        Intrinsics.checkExpressionValueIsNotNull(flatten, "PathUtils.flatten(this, error)");
        return flatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(19)
    public static final Path minus(Path path, Path path2) {
        Intrinsics.checkParameterIsNotNull(path, "$this$minus");
        Intrinsics.checkParameterIsNotNull(path2, AnalyticsEventKey.PROTOCOL);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    /* renamed from: or */
    public static final Path m6or(Path path, Path path2) {
        Intrinsics.checkParameterIsNotNull(path, "$this$or");
        Intrinsics.checkParameterIsNotNull(path2, AnalyticsEventKey.PROTOCOL);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path path2) {
        Intrinsics.checkParameterIsNotNull(path, "$this$plus");
        Intrinsics.checkParameterIsNotNull(path2, AnalyticsEventKey.PROTOCOL);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path path2) {
        Intrinsics.checkParameterIsNotNull(path, "$this$xor");
        Intrinsics.checkParameterIsNotNull(path2, AnalyticsEventKey.PROTOCOL);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
