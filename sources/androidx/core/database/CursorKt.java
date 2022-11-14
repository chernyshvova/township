package androidx.core.database;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cursor.kt */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getBlobOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getDoubleOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getFloatOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getIntOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    public static final Long getLongOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getLongOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    public static final Short getShortOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getShortOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i));
    }

    public static final String getStringOrNull(Cursor cursor, int i) {
        Intrinsics.checkParameterIsNotNull(cursor, "$this$getStringOrNull");
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }
}
