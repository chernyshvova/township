package com.playrix.engine;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.facebook.LegacyTokenHelper;

public class GlobalConstants {
    public static String packName;
    public static Resources res;

    public static void Init() {
        if (res == null) {
            Context context = Engine.getContext();
            res = context.getResources();
            packName = context.getPackageName();
        }
    }

    public static boolean getBool(String str, boolean z) {
        Init();
        int identifier = res.getIdentifier(str, LegacyTokenHelper.TYPE_BOOLEAN, packName);
        return identifier != 0 ? res.getBoolean(identifier) : z;
    }

    public static float getFloat(String str, float f) {
        Init();
        int identifier = res.getIdentifier(str, "vals", packName);
        if (identifier == 0) {
            return f;
        }
        TypedValue typedValue = new TypedValue();
        res.getValue(identifier, typedValue, true);
        return typedValue.getFloat();
    }

    public static int getInt(String str, int i) {
        Init();
        int identifier = res.getIdentifier(str, "integer", packName);
        return identifier != 0 ? res.getInteger(identifier) : i;
    }

    public static String getString(String str, String str2) {
        Init();
        int identifier = res.getIdentifier(str, LegacyTokenHelper.TYPE_STRING, packName);
        return identifier != 0 ? res.getString(identifier) : str2;
    }

    public static boolean nameIsDefined(String str) {
        Init();
        if (res.getIdentifier(str, "integer", packName) == 0 && res.getIdentifier(str, LegacyTokenHelper.TYPE_STRING, packName) == 0 && res.getIdentifier(str, "vals", packName) == 0 && res.getIdentifier(str, LegacyTokenHelper.TYPE_BOOLEAN, packName) == 0) {
            return false;
        }
        return true;
    }
}
