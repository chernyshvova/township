package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class PriorityMapping {
    public static EnumMap<Priority, Integer> PRIORITY_INT_MAP;
    public static SparseArray<Priority> PRIORITY_MAP = new SparseArray<>();

    static {
        EnumMap<Priority, Integer> enumMap = new EnumMap<>(Priority.class);
        PRIORITY_INT_MAP = enumMap;
        enumMap.put(Priority.DEFAULT, 0);
        PRIORITY_INT_MAP.put(Priority.VERY_LOW, 1);
        PRIORITY_INT_MAP.put(Priority.HIGHEST, 2);
        for (Priority next : PRIORITY_INT_MAP.keySet()) {
            PRIORITY_MAP.append(PRIORITY_INT_MAP.get(next).intValue(), next);
        }
    }

    public static int toInt(@NonNull Priority priority) {
        Integer num = PRIORITY_INT_MAP.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority valueOf(int i) {
        Priority priority = PRIORITY_MAP.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline14("Unknown Priority for value ", i));
    }
}
