package com.google.firebase.messaging;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.LegacyTokenHelper;
import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class NotificationParams {
    @NonNull
    public final Bundle data;

    public NotificationParams(@NonNull Bundle bundle) {
        this.data = new Bundle(bundle);
    }

    public static boolean isNotification(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("gcm.n.e")) || AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String userFriendlyKey(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            String userFriendlyKey = userFriendlyKey(str);
            StringBuilder outline23 = GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(string, GeneratedOutlineSupport.outline3(userFriendlyKey, 38)), "Couldn't parse value of ", userFriendlyKey, "(", string);
            outline23.append(") into an int");
            Log.w("NotificationParams", outline23.toString());
            return null;
        }
    }

    @Nullable
    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            String userFriendlyKey = userFriendlyKey(str);
            StringBuilder outline23 = GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(string, GeneratedOutlineSupport.outline3(userFriendlyKey, 50)), "Malformed JSON for key ", userFriendlyKey, ": ", string);
            outline23.append(", falling back to default");
            Log.w("NotificationParams", outline23.toString());
            return null;
        }
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String[] strArr;
        String string = getString(str2);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = getString(str2.concat("_loc_key"));
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        int identifier = resources.getIdentifier(string2, LegacyTokenHelper.TYPE_STRING, str);
        if (identifier == 0) {
            String userFriendlyKey = userFriendlyKey(str2.concat("_loc_key"));
            StringBuilder sb = new StringBuilder(str2.length() + GeneratedOutlineSupport.outline3(userFriendlyKey, 49));
            sb.append(userFriendlyKey);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        JSONArray jSONArray = getJSONArray(str2.concat("_loc_args"));
        if (jSONArray == null) {
            strArr = null;
        } else {
            int length = jSONArray.length();
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.optString(i);
            }
        }
        if (strArr == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, strArr);
        } catch (MissingFormatArgumentException e) {
            String userFriendlyKey2 = userFriendlyKey(str2);
            String arrays = Arrays.toString(strArr);
            StringBuilder outline23 = GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(arrays, GeneratedOutlineSupport.outline3(userFriendlyKey2, 58)), "Missing format argument for ", userFriendlyKey2, ": ", arrays);
            outline23.append(" Default value will be used.");
            Log.w("NotificationParams", outline23.toString(), e);
            return null;
        }
    }

    public String getString(String str) {
        String str2;
        Bundle bundle = this.data;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            if (!str.startsWith("gcm.n.")) {
                str2 = str;
            } else {
                str2 = str.replace("gcm.n.", "gcm.notification.");
            }
            if (this.data.containsKey(str2)) {
                str = str2;
            }
        }
        return bundle.getString(str);
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
