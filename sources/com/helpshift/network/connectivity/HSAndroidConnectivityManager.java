package com.helpshift.network.connectivity;

import androidx.annotation.NonNull;

public interface HSAndroidConnectivityManager {
    @NonNull
    HSConnectivityStatus getConnectivityStatus();

    @NonNull
    HSConnectivityType getConnectivityType();

    void startListeningConnectivityChange(HSNetworkConnectivityCallback hSNetworkConnectivityCallback);

    void stopListeningConnectivityChange();
}
