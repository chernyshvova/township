package com.playrix.engine;

import com.playrix.engine.PushNotifications;

public class PushNotificationsDelegate implements PushNotifications.IPushNotificationsDelegate {
    public static final String ALERT_ONCE_KEY = "alertOnce";
    public static final String CATEGORY_KEY = "category";
    public static final String CHANNEL_KEY = "channel";
    public static final String DRY_RUN_VALUE = "dryRun";
    public static final String GROUP_KEY = "group";
    public static final String IMAGE_KEY = "image";
    public static final String MESSAGE_KEY = "text";
    public static final String PAYLOAD_KEY = "payload";
    public static final String PLAYRIX_PUSH_TYPE = "playrix";
    public static final String PUSH_KEY = "playrixPN";
    public static final String SOUND_KEY = "sound";
    public static final String SUMMARY_ARG = "summaryArg";
    public static final String SUMMARY_ARG_COUNT = "summaryArgCnt";
    public static final String TAG = "[PlayrixPushNotifDelegate] ";
    public static final String TAG_KEY = "tag";
    public static final String TITLE_KEY = "title";

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8 A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5 A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2 A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d8 A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3 A[Catch:{ JSONException -> 0x00fc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.playrix.engine.PushNotifications.PushNotificationData processPushNotification(android.os.Bundle r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "image"
            java.lang.String r2 = "summaryArg"
            java.lang.String r3 = "group"
            java.lang.String r4 = "tag"
            java.lang.String r5 = "title"
            java.lang.String r6 = "sound"
            java.lang.String r7 = "alertOnce"
            java.lang.String r8 = "summaryArgCnt"
            java.lang.String r9 = "category"
            java.lang.String r10 = "channel"
            java.lang.String r11 = ""
            java.lang.String r12 = "playrixPN"
            boolean r13 = r0.containsKey(r12)
            r14 = 0
            if (r13 != 0) goto L_0x0022
            return r14
        L_0x0022:
            java.lang.String r13 = "[PlayrixPushNotifDelegate] Processing Engine notification"
            com.playrix.engine.Logger.logInfo(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r12 = r0.getString(r12)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r15 = "dryRun"
            boolean r12 = r12.equals(r15)     // Catch:{ JSONException -> 0x00fc }
            if (r12 == 0) goto L_0x003e
            com.playrix.engine.PushNotifications$PushNotificationData r0 = new com.playrix.engine.PushNotifications$PushNotificationData     // Catch:{ JSONException -> 0x00fc }
            r0.<init>(r14)     // Catch:{ JSONException -> 0x00fc }
            return r0
        L_0x003e:
            java.lang.String r12 = "source"
            java.lang.String r14 = "playrix"
            r13.put(r12, r14)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r12 = "message"
            java.lang.String r14 = "text"
            java.lang.String r14 = r0.getString(r14, r11)     // Catch:{ JSONException -> 0x00fc }
            r13.put(r12, r14)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r12 = r0.getString(r6, r11)     // Catch:{ JSONException -> 0x00fc }
            boolean r14 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x00fc }
            if (r14 != 0) goto L_0x005d
            r13.put(r6, r12)     // Catch:{ JSONException -> 0x00fc }
        L_0x005d:
            java.lang.String r6 = com.playrix.engine.Notifications.defaultChannelId()     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r6 = r0.getString(r10, r6)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r12 = com.playrix.engine.Notifications.defaultCategoryId()     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r12 = r0.getString(r9, r12)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r14 = "payload"
            java.lang.String r11 = r0.getString(r14, r11)     // Catch:{ JSONException -> 0x00fc }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00fc }
            r14.<init>()     // Catch:{ JSONException -> 0x00fc }
            boolean r15 = android.text.TextUtils.isEmpty(r11)     // Catch:{ JSONException -> 0x00fc }
            if (r15 != 0) goto L_0x0093
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008e }
            r15.<init>(r11)     // Catch:{ JSONException -> 0x008e }
            java.lang.String r6 = r15.optString(r10, r6)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r12 = r15.optString(r9, r12)     // Catch:{ JSONException -> 0x008d }
            r14 = r15
            goto L_0x0093
        L_0x008d:
            r14 = r15
        L_0x008e:
            java.lang.String r11 = "[PlayrixPushNotifDelegate] Can't parse payload as Json, ignoring"
            com.playrix.engine.Logger.logWarning(r11)     // Catch:{ JSONException -> 0x00fc }
        L_0x0093:
            r13.put(r10, r6)     // Catch:{ JSONException -> 0x00fc }
            r13.put(r9, r12)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r6 = "userInfo"
            r13.put(r6, r14)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r6 = r0.getString(r5)     // Catch:{ JSONException -> 0x00fc }
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x00fc }
            if (r9 != 0) goto L_0x00ab
            r13.put(r5, r6)     // Catch:{ JSONException -> 0x00fc }
        L_0x00ab:
            java.lang.String r5 = r0.getString(r4)     // Catch:{ JSONException -> 0x00fc }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x00fc }
            if (r6 != 0) goto L_0x00b8
            r13.put(r4, r5)     // Catch:{ JSONException -> 0x00fc }
        L_0x00b8:
            java.lang.String r4 = r0.getString(r3)     // Catch:{ JSONException -> 0x00fc }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x00fc }
            if (r5 != 0) goto L_0x00c5
            r13.put(r3, r4)     // Catch:{ JSONException -> 0x00fc }
        L_0x00c5:
            java.lang.String r3 = r0.getString(r2)     // Catch:{ JSONException -> 0x00fc }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x00fc }
            if (r4 != 0) goto L_0x00d2
            r13.put(r2, r3)     // Catch:{ JSONException -> 0x00fc }
        L_0x00d2:
            boolean r2 = r0.containsKey(r8)     // Catch:{ JSONException -> 0x00fc }
            if (r2 == 0) goto L_0x00e0
            r2 = 1
            int r2 = r0.getInt(r8, r2)     // Catch:{ JSONException -> 0x00fc }
            r13.put(r8, r2)     // Catch:{ JSONException -> 0x00fc }
        L_0x00e0:
            java.lang.String r2 = r0.getString(r1)     // Catch:{ JSONException -> 0x00fc }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00fc }
            if (r3 != 0) goto L_0x00ed
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x00fc }
        L_0x00ed:
            boolean r1 = r0.containsKey(r7)     // Catch:{ JSONException -> 0x00fc }
            if (r1 == 0) goto L_0x0111
            r1 = 0
            boolean r0 = r0.getBoolean(r7, r1)     // Catch:{ JSONException -> 0x00fc }
            r13.put(r7, r0)     // Catch:{ JSONException -> 0x00fc }
            goto L_0x0111
        L_0x00fc:
            r0 = move-exception
            java.lang.String r1 = "[PlayrixPushNotifDelegate] Error in extractPushData: "
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.playrix.engine.Logger.logError(r0)
        L_0x0111:
            com.playrix.engine.PushNotifications$PushNotificationData r0 = new com.playrix.engine.PushNotifications$PushNotificationData
            r0.<init>(r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.PushNotificationsDelegate.processPushNotification(android.os.Bundle):com.playrix.engine.PushNotifications$PushNotificationData");
    }
}
