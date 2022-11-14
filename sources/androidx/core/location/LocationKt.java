package androidx.core.location;

import android.location.Location;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Location.kt */
public final class LocationKt {
    public static final double component1(Location location) {
        Intrinsics.checkParameterIsNotNull(location, "$this$component1");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        Intrinsics.checkParameterIsNotNull(location, "$this$component2");
        return location.getLongitude();
    }
}
