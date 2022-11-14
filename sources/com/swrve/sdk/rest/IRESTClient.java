package com.swrve.sdk.rest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface IRESTClient {
    void get(String str, IRESTResponseListener iRESTResponseListener);

    void get(String str, Map<String, String> map, IRESTResponseListener iRESTResponseListener) throws UnsupportedEncodingException;

    void post(String str, String str2, IRESTResponseListener iRESTResponseListener);

    void post(String str, String str2, IRESTResponseListener iRESTResponseListener, String str3);
}
