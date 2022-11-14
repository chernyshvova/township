package com.helpshift.util;

import java.util.ArrayList;
import java.util.List;

public class Filters {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (predicate.matches(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
