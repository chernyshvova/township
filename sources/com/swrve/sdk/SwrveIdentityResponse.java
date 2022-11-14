package com.swrve.sdk;

public interface SwrveIdentityResponse {
    void onError(int i, String str);

    void onSuccess(String str, String str2);
}
