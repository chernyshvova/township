package com.helpshift.network.connectivity;

public interface HSNetworkConnectivityCallback {
    void onNetworkAvailable();

    void onNetworkUnavailable();
}
