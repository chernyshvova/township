package com.swrve.sdk;

import java.util.Map;

public interface ISwrveEventListener {
    void onEvent(String str, Map<String, String> map);
}
