package com.helpshift.support;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FaqTagFilter implements Serializable {
    public static final long serialVersionUID = 7526472295622776147L;
    public String operator = "undefined";
    public String[] tags;

    public static class Operator {
        public static final String AND = "and";
        public static final String NOT = "not";

        /* renamed from: OR */
        public static final String f3347OR = "or";
        public static final String UNDEFINED = "undefined";
        public static final HashSet<String> valueSet = getSupportedValueSet();

        public static HashSet<String> getSupportedValueSet() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(AND);
            hashSet.add(f3347OR);
            hashSet.add(NOT);
            return hashSet;
        }
    }

    public FaqTagFilter(String str, String[] strArr) {
        if (Operator.valueSet.contains(str)) {
            this.operator = str;
        }
        this.tags = strArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FaqTagFilter) {
            FaqTagFilter faqTagFilter = (FaqTagFilter) obj;
            return this.operator.equals(faqTagFilter.operator) && Arrays.equals(this.tags, faqTagFilter.tags);
        }
    }

    public String getOperator() {
        return this.operator;
    }

    public String[] getTags() {
        return this.tags;
    }

    public Map<String, Object> toMap() {
        String[] strArr;
        String str = this.operator;
        if (str == null || !Operator.valueSet.contains(str) || (strArr = this.tags) == null || strArr.length <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("operator", this.operator);
        hashMap.put("tags", this.tags);
        return hashMap;
    }
}
