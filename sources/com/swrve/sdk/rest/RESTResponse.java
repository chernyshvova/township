package com.swrve.sdk.rest;

import java.util.List;
import java.util.Map;

public class RESTResponse {
    public String responseBody;
    public int responseCode;
    public Map<String, List<String>> responseHeaders;

    public RESTResponse(int i, String str, Map<String, List<String>> map) {
        this.responseCode = i;
        this.responseBody = str;
        this.responseHeaders = map;
    }

    public String getHeaderValue(String str) {
        List list;
        Map<String, List<String>> map = this.responseHeaders;
        if (map == null || (list = map.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return (String) list.get(0);
    }
}
