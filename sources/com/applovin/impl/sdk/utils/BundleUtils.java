package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.C1314v;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleUtils {
    public static boolean containsAtLeastOneKey(Set<String> set, Bundle bundle) {
        if (set != null && !set.isEmpty()) {
            for (String containsKey : set) {
                if (bundle.containsKey(containsKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getBoolean(String str, Bundle bundle) {
        return getBoolean(str, false, bundle);
    }

    public static boolean getBoolean(String str, boolean z, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue() != 0;
            }
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str2.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                    return true;
                }
                if (str2.equalsIgnoreCase("false") || str2.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    return false;
                }
                return z;
            }
        }
        return z;
    }

    public static int getInt(String str, int i, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            if (obj instanceof String) {
                try {
                    return Integer.parseInt((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return i;
    }

    public static int getInt(String str, Bundle bundle) {
        return getInt(str, 0, bundle);
    }

    public static long getLong(String str, long j, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof String) {
                try {
                    return Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return j;
    }

    public static long getLong(String str, Bundle bundle) {
        return getLong(str, 0, bundle);
    }

    public static String getString(String str, Bundle bundle) {
        return getString(str, (String) null, bundle);
    }

    public static String getString(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null || !bundle.containsKey(str)) {
            return str2;
        }
        Object obj = bundle.get(str);
        return obj instanceof String ? (String) obj : String.valueOf(obj);
    }

    public static void put(String str, @Nullable Object obj, Bundle bundle) {
        String str2;
        if (obj == null) {
            str2 = "Skipped insertion into Bundle because value is null.";
        } else if (obj instanceof String) {
            putString(str, (String) obj, bundle);
            return;
        } else if (obj instanceof Boolean) {
            putBoolean(str, (Boolean) obj, bundle);
            return;
        } else if (obj instanceof Integer) {
            putInt(str, (Integer) obj, bundle);
            return;
        } else if (obj instanceof Long) {
            putLong(str, (Long) obj, bundle);
            return;
        } else if (obj instanceof Double) {
            putDouble(str, (Double) obj, bundle);
            return;
        } else if (obj instanceof Byte) {
            putByte(str, (Byte) obj, bundle);
            return;
        } else if (obj instanceof Character) {
            putChar(str, (Character) obj, bundle);
            return;
        } else if (obj instanceof Float) {
            putFloat(str, (Float) obj, bundle);
            return;
        } else if (obj instanceof Short) {
            putShort(str, (Short) obj, bundle);
            return;
        } else if (obj instanceof CharSequence) {
            putCharSequence(str, (CharSequence) obj, bundle);
            return;
        } else if (obj instanceof String[]) {
            putStringArray(str, (String[]) obj, bundle);
            return;
        } else if (obj instanceof boolean[]) {
            putBooleanArray(str, (boolean[]) obj, bundle);
            return;
        } else if (obj instanceof int[]) {
            putIntArray(str, (int[]) obj, bundle);
            return;
        } else if (obj instanceof long[]) {
            putLongArray(str, (long[]) obj, bundle);
            return;
        } else if (obj instanceof double[]) {
            putDoubleArray(str, (double[]) obj, bundle);
            return;
        } else if (obj instanceof byte[]) {
            putByteArray(str, (byte[]) obj, bundle);
            return;
        } else if (obj instanceof char[]) {
            putCharArray(str, (char[]) obj, bundle);
            return;
        } else if (obj instanceof float[]) {
            putFloatArray(str, (float[]) obj, bundle);
            return;
        } else if (obj instanceof short[]) {
            putShortArray(str, (short[]) obj, bundle);
            return;
        } else if (obj instanceof CharSequence[]) {
            putCharSequenceArray(str, (CharSequence[]) obj, bundle);
            return;
        } else {
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.size() > 0) {
                    if (arrayList.get(0) instanceof String) {
                        putStringArrayList(str, arrayList, bundle);
                        return;
                    } else if (arrayList.get(0) instanceof Integer) {
                        putIntegerArrayList(str, arrayList, bundle);
                        return;
                    } else if (arrayList.get(0) instanceof CharSequence) {
                        putCharSequenceArrayList(str, arrayList, bundle);
                        return;
                    } else {
                        return;
                    }
                }
            }
            str2 = "Skipped insertion of " + obj + " into Bundle";
        }
        C1314v.m2663i(AppLovinSdk.TAG, str2);
    }

    public static void putBoolean(String str, @Nullable Boolean bool, Bundle bundle) {
        if (bool != null) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    public static void putBooleanArray(String str, @Nullable boolean[] zArr, Bundle bundle) {
        if (zArr != null) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static void putByte(String str, @Nullable Byte b, Bundle bundle) {
        if (b != null) {
            bundle.putByte(str, b.byteValue());
        }
    }

    public static void putByteArray(String str, @Nullable byte[] bArr, Bundle bundle) {
        if (bArr != null) {
            bundle.putByteArray(str, bArr);
        }
    }

    public static void putChar(String str, @Nullable Character ch, Bundle bundle) {
        if (ch != null) {
            bundle.putChar(str, ch.charValue());
        }
    }

    public static void putCharArray(String str, @Nullable char[] cArr, Bundle bundle) {
        if (cArr != null) {
            bundle.putCharArray(str, cArr);
        }
    }

    public static void putCharSequence(String str, @Nullable CharSequence charSequence, Bundle bundle) {
        if (charSequence != null) {
            bundle.putCharSequence(str, charSequence);
        }
    }

    public static void putCharSequenceArray(String str, @Nullable CharSequence[] charSequenceArr, Bundle bundle) {
        if (charSequenceArr != null) {
            bundle.putCharSequenceArray(str, charSequenceArr);
        }
    }

    public static void putCharSequenceArrayList(String str, @Nullable ArrayList<CharSequence> arrayList, Bundle bundle) {
        if (arrayList != null) {
            bundle.putCharSequenceArrayList(str, arrayList);
        }
    }

    public static void putDouble(String str, @Nullable Double d, Bundle bundle) {
        if (d != null) {
            bundle.putDouble(str, d.doubleValue());
        }
    }

    public static void putDoubleArray(String str, @Nullable double[] dArr, Bundle bundle) {
        if (dArr != null) {
            bundle.putDoubleArray(str, dArr);
        }
    }

    public static void putFloat(String str, @Nullable Float f, Bundle bundle) {
        if (f != null) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    public static void putFloatArray(String str, @Nullable float[] fArr, Bundle bundle) {
        if (fArr != null) {
            bundle.putFloatArray(str, fArr);
        }
    }

    public static void putInt(String str, @Nullable Integer num, Bundle bundle) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    public static void putIntArray(String str, @Nullable int[] iArr, Bundle bundle) {
        if (iArr != null) {
            bundle.putIntArray(str, iArr);
        }
    }

    public static void putIntegerArrayList(String str, @Nullable ArrayList<Integer> arrayList, Bundle bundle) {
        if (arrayList != null) {
            bundle.putIntegerArrayList(str, arrayList);
        }
    }

    public static void putLong(String str, @Nullable Long l, Bundle bundle) {
        if (l != null) {
            bundle.putLong(str, l.longValue());
        }
    }

    public static void putLongArray(String str, @Nullable long[] jArr, Bundle bundle) {
        if (jArr != null) {
            bundle.putLongArray(str, jArr);
        }
    }

    public static void putShort(String str, @Nullable Short sh, Bundle bundle) {
        if (sh != null) {
            bundle.putShort(str, sh.shortValue());
        }
    }

    public static void putShortArray(String str, @Nullable short[] sArr, Bundle bundle) {
        if (sArr != null) {
            bundle.putShortArray(str, sArr);
        }
    }

    public static void putString(String str, @Nullable String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    public static void putStringArray(String str, @Nullable String[] strArr, Bundle bundle) {
        if (strArr != null) {
            bundle.putStringArray(str, strArr);
        }
    }

    public static void putStringArrayList(String str, @Nullable ArrayList<String> arrayList, Bundle bundle) {
        if (arrayList != null) {
            bundle.putStringArrayList(str, arrayList);
        }
    }

    public static void putStringIfValid(String str, @Nullable String str2, Bundle bundle) {
        if (AppLovinSdkUtils.isValidString(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static JSONObject toJSONObject(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    if (obj instanceof Bundle) {
                        obj = toJSONObject((Bundle) obj);
                    } else if ((obj instanceof Collection) || (obj instanceof Parcelable[])) {
                        Collection asList = obj instanceof Collection ? (Collection) obj : Arrays.asList((Parcelable[]) obj);
                        JSONArray jSONArray = new JSONArray();
                        for (Object next : asList) {
                            if (next instanceof Bundle) {
                                next = toJSONObject((Bundle) next);
                            }
                            jSONArray.put(next);
                        }
                        jSONObject.put(str, jSONArray);
                    }
                    jSONObject.put(str, obj);
                }
            }
        } catch (JSONException e) {
            C1314v.m2659c(AppLovinSdk.TAG, "Failed to convert Bundle to JSONObject", e);
        }
        return jSONObject;
    }

    public static Map<String, Object> toMap(Bundle bundle) {
        if (bundle == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    obj = toMap((Bundle) obj);
                } else {
                    boolean z = obj instanceof Collection;
                    if (z || (obj instanceof Parcelable[])) {
                        Collection asList = z ? (Collection) obj : Arrays.asList((Parcelable[]) obj);
                        ArrayList arrayList = new ArrayList();
                        for (Object next : asList) {
                            if (next instanceof Bundle) {
                                next = toMap((Bundle) next);
                            }
                            arrayList.add(next);
                        }
                        hashMap.put(str, arrayList);
                    }
                }
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    public static Map<String, String> toStringMap(Bundle bundle) {
        if (bundle == null) {
            return new HashMap(0);
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            hashMap.put(str, String.valueOf(bundle.get(str)));
        }
        return hashMap;
    }
}
