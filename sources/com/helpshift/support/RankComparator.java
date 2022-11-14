package com.helpshift.support;

import java.util.Comparator;
import java.util.HashMap;

/* compiled from: HSSearch */
public class RankComparator implements Comparator<String> {
    public HashMap<String, Double> base;

    public RankComparator(HashMap<String, Double> hashMap) {
        this.base = hashMap;
    }

    public int compare(String str, String str2) {
        return this.base.get(str).doubleValue() >= this.base.get(str2).doubleValue() ? -1 : 1;
    }
}
