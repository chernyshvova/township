package com.google.android.gms.common.util;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class CollectionUtils {
    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@RecentlyNonNull K k, @RecentlyNonNull V v, @RecentlyNonNull K k2, @RecentlyNonNull V v2, @RecentlyNonNull K k3, @RecentlyNonNull V v3) {
        Map zzb = zzb(3, false);
        zzb.put(k, v);
        zzb.put(k2, v2);
        zzb.put(k3, v3);
        return Collections.unmodifiableMap(zzb);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@RecentlyNonNull K[] kArr, @RecentlyNonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11(66, "Key and values array lengths not equal: ", length, " != ", length2));
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map zzb = zzb(length, false);
            for (int i = 0; i < kArr.length; i++) {
                zzb.put(kArr[i], vArr[i]);
            }
            return Collections.unmodifiableMap(zzb);
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i) {
        if (i == 0) {
            return new ArraySet();
        }
        return zza(i, true);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@RecentlyNonNull T t, @RecentlyNonNull T t2, @RecentlyNonNull T t3) {
        Set zza = zza(3, false);
        zza.add(t);
        zza.add(t2);
        zza.add(t3);
        return Collections.unmodifiableSet(zza);
    }

    public static <T> Set<T> zza(int i, boolean z) {
        float f = true != z ? 1.0f : 0.75f;
        if (i <= (true != z ? 256 : 128)) {
            return new ArraySet(i);
        }
        return new HashSet(i, f);
    }

    public static <K, V> Map<K, V> zzb(int i, boolean z) {
        if (i <= 256) {
            return new ArrayMap(i);
        }
        return new HashMap(i, 1.0f);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@RecentlyNonNull T t) {
        return Collections.singletonList(t);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@RecentlyNonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return listOf();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return listOf(tArr[0]);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@RecentlyNonNull K k, @RecentlyNonNull V v, @RecentlyNonNull K k2, @RecentlyNonNull V v2, @RecentlyNonNull K k3, @RecentlyNonNull V v3, @RecentlyNonNull K k4, @RecentlyNonNull V v4, @RecentlyNonNull K k5, @RecentlyNonNull V v5, @RecentlyNonNull K k6, @RecentlyNonNull V v6) {
        Map zzb = zzb(6, false);
        zzb.put(k, v);
        zzb.put(k2, v2);
        zzb.put(k3, v3);
        zzb.put(k4, v4);
        zzb.put(k5, v5);
        zzb.put(k6, v6);
        return Collections.unmodifiableMap(zzb);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@RecentlyNonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set zza = zza(2, false);
            zza.add(t);
            zza.add(t2);
            return Collections.unmodifiableSet(zza);
        } else if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set zza2 = zza(length, false);
                Collections.addAll(zza2, tArr);
                return Collections.unmodifiableSet(zza2);
            }
            T t3 = tArr[0];
            T t4 = tArr[1];
            T t5 = tArr[2];
            T t6 = tArr[3];
            Set zza3 = zza(4, false);
            zza3.add(t3);
            zza3.add(t4);
            zza3.add(t5);
            zza3.add(t6);
            return Collections.unmodifiableSet(zza3);
        }
    }
}
