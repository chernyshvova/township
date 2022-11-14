package com.helpshift.support;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    public String[] issueTags;
    public Map<String, Object> metadata;

    public Metadata(Map<String, Object> map) {
        this(map, (String[]) null);
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.metadata;
        if (map != null) {
            hashMap.putAll(map);
        }
        String[] strArr = this.issueTags;
        if (strArr != null) {
            hashMap.put(Support.TagsKey, strArr);
        }
        return hashMap;
    }

    public Metadata(Map<String, Object> map, String[] strArr) {
        if (map != null) {
            this.metadata = map;
        }
        if (strArr != null && strArr.length > 0) {
            this.issueTags = strArr;
        }
    }
}
