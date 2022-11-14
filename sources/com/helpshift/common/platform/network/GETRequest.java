package com.helpshift.common.platform.network;

import java.util.List;

public class GETRequest extends Request {
    public GETRequest(String str, List<KeyValuePair> list, int i) {
        super(Method.GET, str, list, i);
    }
}
