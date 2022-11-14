package com.helpshift.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CloneUtil {
    public static <T extends HSCloneable> HSObservableList<T> deepClone(HSObservableList<T> hSObservableList) {
        if (hSObservableList == null) {
            return null;
        }
        HSObservableList<T> hSObservableList2 = new HSObservableList<>();
        Iterator<E> it = hSObservableList.iterator();
        while (it.hasNext()) {
            hSObservableList2.add((HSCloneable) ((HSCloneable) it.next()).deepClone());
        }
        return hSObservableList2;
    }

    public static <T extends HSCloneable> ArrayList<T> deepClone(List<T> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        ArrayList<T> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((HSCloneable) ((HSCloneable) it.next()).deepClone());
        }
        return arrayList2;
    }

    public static <K, V extends HSCloneable> HashMap<K, V> deepClone(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        HashMap<K, V> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), (HSCloneable) ((HSCloneable) next.getValue()).deepClone());
        }
        return hashMap;
    }
}
