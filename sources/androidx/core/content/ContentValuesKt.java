package androidx.core.content;

import android.content.ContentValues;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentValues.kt */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.first;
            B b = pair.second;
            if (b == null) {
                contentValues.putNull(str);
            } else if (b instanceof String) {
                contentValues.put(str, (String) b);
            } else if (b instanceof Integer) {
                contentValues.put(str, (Integer) b);
            } else if (b instanceof Long) {
                contentValues.put(str, (Long) b);
            } else if (b instanceof Boolean) {
                contentValues.put(str, (Boolean) b);
            } else if (b instanceof Float) {
                contentValues.put(str, (Float) b);
            } else if (b instanceof Double) {
                contentValues.put(str, (Double) b);
            } else if (b instanceof byte[]) {
                contentValues.put(str, (byte[]) b);
            } else if (b instanceof Byte) {
                contentValues.put(str, (Byte) b);
            } else if (b instanceof Short) {
                contentValues.put(str, (Short) b);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return contentValues;
    }
}
