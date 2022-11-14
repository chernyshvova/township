package com.microsoft.appcenter.utils.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

public class SharedPreferencesManager {
    @SuppressLint({"StaticFieldLeak"})
    public static Context sContext;
    public static SharedPreferences sSharedPreferences;

    public static boolean getBoolean(@NonNull String str, boolean z) {
        return sSharedPreferences.getBoolean(str, z);
    }

    public static void putBoolean(@NonNull String str, boolean z) {
        SharedPreferences.Editor edit = sSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void remove(@NonNull String str) {
        SharedPreferences.Editor edit = sSharedPreferences.edit();
        edit.remove(str);
        edit.apply();
    }
}
