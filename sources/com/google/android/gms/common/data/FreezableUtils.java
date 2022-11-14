package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class FreezableUtils {
    @RecentlyNonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@RecentlyNonNull ArrayList<E> arrayList) {
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((Freezable) arrayList.get(i)).freeze());
        }
        return arrayList2;
    }

    @RecentlyNonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@RecentlyNonNull Iterable<E> iterable) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (E freeze : iterable) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }

    @RecentlyNonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@RecentlyNonNull E[] eArr) {
        ArrayList<T> arrayList = new ArrayList<>(eArr.length);
        for (E freeze : eArr) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }
}
