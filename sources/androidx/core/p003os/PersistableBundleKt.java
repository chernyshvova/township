package androidx.core.p003os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.core.os.PersistableBundleKt */
/* compiled from: PersistableBundle.kt */
public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.first;
            B b = pair.second;
            if (b == null) {
                persistableBundle.putString(str, (String) null);
            } else if (b instanceof Boolean) {
                if (Build.VERSION.SDK_INT >= 22) {
                    persistableBundle.putBoolean(str, ((Boolean) b).booleanValue());
                } else {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + str + '\"');
                }
            } else if (b instanceof Double) {
                persistableBundle.putDouble(str, ((Number) b).doubleValue());
            } else if (b instanceof Integer) {
                persistableBundle.putInt(str, ((Number) b).intValue());
            } else if (b instanceof Long) {
                persistableBundle.putLong(str, ((Number) b).longValue());
            } else if (b instanceof String) {
                persistableBundle.putString(str, (String) b);
            } else if (b instanceof boolean[]) {
                if (Build.VERSION.SDK_INT >= 22) {
                    persistableBundle.putBooleanArray(str, (boolean[]) b);
                } else {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + str + '\"');
                }
            } else if (b instanceof double[]) {
                persistableBundle.putDoubleArray(str, (double[]) b);
            } else if (b instanceof int[]) {
                persistableBundle.putIntArray(str, (int[]) b);
            } else if (b instanceof long[]) {
                persistableBundle.putLongArray(str, (long[]) b);
            } else if (b instanceof Object[]) {
                Class<?> componentType = b.getClass().getComponentType();
                if (componentType != null) {
                    Intrinsics.checkExpressionValueIsNotNull(componentType, "value::class.java.componentType!!");
                    if (String.class.isAssignableFrom(componentType)) {
                        persistableBundle.putStringArray(str, (String[]) b);
                    } else {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                    }
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            } else {
                throw new IllegalArgumentException("Illegal value type " + b.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return persistableBundle;
    }
}
