package com.playrix.township.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.Engine;
import com.playrix.engine.Logger;
import com.playrix.engine.Notifications;
import com.playrix.township.C3342R;
import org.json.JSONException;
import org.json.JSONObject;

public class WarningNotification {
    public static final String TAG = "[WarningNotification] ";
    public static final String TAG_DATE_WARN = "dateWarn";
    public static final String TAG_FREESPACE_WARN = "freeSpace";
    public static final String WARN_SOURCE = "warning";
    public static Handler handler;
    public static long nextToastTime;

    public static void show(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            Logger.logDebug("[WarningNotification] skipped warning for empty tag");
            return;
        }
        Context context = Engine.getContext();
        if (context == null) {
            Logger.logError("[WarningNotification] skipped warning: null context");
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -444658182) {
            if (hashCode == 1792831316 && str.equals(TAG_DATE_WARN)) {
                c = 0;
            }
        } else if (str.equals(TAG_FREESPACE_WARN)) {
            c = 1;
        }
        if (c == 0) {
            str2 = Utils.getText("InvalidDate");
        } else if (c != 1) {
            Logger.logError("[WarningNotification] skipped warning for unknown tag " + str);
            return;
        } else {
            str2 = Utils.getText("CheckStorageStart");
        }
        if (TextUtils.isEmpty(str2)) {
            Logger.logDebug("[WarningNotification] skipped warning for empty message");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences != null && preferences.getBoolean("_useWarningNotification_", true)) {
            Resources resources = context.getResources();
            try {
                jSONObject.put("sound", "default");
                jSONObject.put("source", "warning");
                jSONObject.put("message", str2);
                jSONObject.put("channel", resources.getString(C3342R.string.notif_channel_default));
                jSONObject.put("tag", str);
                jSONObject.put("alertOnce", false);
            } catch (JSONException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[WarningNotification] Error while creating json: ");
                outline24.append(e.toString());
                Logger.logError(outline24.toString());
            }
            if (jSONObject.length() != 0) {
                Notifications.processNotification(jSONObject, Notifications.NotificationType.LOCAL);
            }
        }
        if (preferences != null && preferences.getBoolean("_useWarningToast_", true)) {
            int i = preferences.getInt("_warningToastDelta_", 3) * 1000;
            final Toast makeText = Toast.makeText(context, str2, 1);
            makeText.setGravity(48, 0, 0);
            long currentTimeMillis = System.currentTimeMillis();
            long j = nextToastTime;
            if (currentTimeMillis >= j) {
                makeText.show();
                nextToastTime = currentTimeMillis + ((long) i);
                return;
            }
            long j2 = j - currentTimeMillis;
            nextToastTime = currentTimeMillis + j2 + ((long) i);
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.postDelayed(new Runnable() {
                public void run() {
                    makeText.show();
                }
            }, j2);
        }
    }
}
