package com.applovin.sdk;

import android.os.Bundle;

public interface AppLovinVariableService {

    public interface OnVariablesUpdateListener {
        void onVariablesUpdate(Bundle bundle);
    }

    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    String getString(String str);

    String getString(String str, String str2);

    @Deprecated
    void loadVariables();

    @Deprecated
    void setOnVariablesUpdateListener(OnVariablesUpdateListener onVariablesUpdateListener);
}
