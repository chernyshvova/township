package com.helpshift.util;

import java.util.ArrayList;
import java.util.List;

public final class ListUtils {
    public static <T> List<T> flatten(List<List<T>> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (List next : list) {
            if (!isEmpty(next)) {
                arrayList.addAll(next);
            }
        }
        return arrayList;
    }

    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static String serializeWithDelimiter(List<String> list, String str) {
        if (isEmpty(list)) {
            return "";
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < size; i++) {
            sb.append(str);
            sb.append(" ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static <T> List<List<T>> unflatten(List<T> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(next);
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
