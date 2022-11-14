package com.helpshift.applifecycle;

import android.content.Context;

public interface HSAppLifeCycleListener {
    void onAppBackground(Context context);

    void onAppForeground(Context context);
}
