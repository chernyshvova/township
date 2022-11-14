package com.swrve.sdk.rest;

public interface IRESTResponseListener {
    void onException(Exception exc);

    void onResponse(RESTResponse rESTResponse);
}
