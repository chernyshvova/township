package com.vungle.warren.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.persistence.FilePreferences;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class LogSender {
    public static final String HEADER_LOG_BATCH_ID = "batch_id";
    public static final String HEADER_LOG_DEVICE_ID = "device_guid";
    public static final String HEADER_LOG_PAYLOAD = "payload";
    public static final String PREFS_BATCH_ID_KEY = "batch_id";
    public static final String PREFS_DEVICE_ID_KEY = "device_id";
    public static final String TAG = "LogSender";
    public int batchId = getBatchId();
    public final String deviceId = getDeviceId();
    public final FilePreferences prefs;
    public final VungleApiClient vungleApiClient;

    public LogSender(@NonNull VungleApiClient vungleApiClient2, @NonNull FilePreferences filePreferences) {
        this.vungleApiClient = vungleApiClient2;
        this.prefs = filePreferences;
    }

    private int getBatchId() {
        return this.prefs.getInt("batch_id", 0);
    }

    @NonNull
    private String getDeviceId() {
        String string = this.prefs.getString("device_id", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        this.prefs.put("device_id", uuid);
        this.prefs.apply();
        return uuid;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        android.util.Log.e(TAG, "Invalidate log document file.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        com.vungle.warren.utility.FileUtility.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002b */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.JsonArray getPayload(@androidx.annotation.NonNull java.io.File r5) {
        /*
            r4 = this;
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
        L_0x0010:
            java.lang.String r5 = r2.readLine()     // Catch:{ Exception -> 0x002b }
            if (r5 == 0) goto L_0x0024
            com.google.gson.JsonElement r5 = com.android.billingclient.api.zzam.parseString(r5)     // Catch:{ Exception -> 0x002b }
            com.google.gson.JsonObject r5 = r5.getAsJsonObject()     // Catch:{ Exception -> 0x002b }
            java.util.List<com.google.gson.JsonElement> r3 = r0.elements     // Catch:{ Exception -> 0x002b }
            r3.add(r5)     // Catch:{ Exception -> 0x002b }
            goto L_0x0010
        L_0x0024:
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
            return r0
        L_0x0028:
            r5 = move-exception
            goto L_0x0038
        L_0x002a:
            r2 = r1
        L_0x002b:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = "Invalidate log document file."
            android.util.Log.e(r5, r0)     // Catch:{ all -> 0x0036 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
            return r1
        L_0x0036:
            r5 = move-exception
            r1 = r2
        L_0x0038:
            com.vungle.warren.utility.FileUtility.closeQuietly(r1)
            goto L_0x003d
        L_0x003c:
            throw r5
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogSender.getPayload(java.io.File):com.google.gson.JsonArray");
    }

    private void saveBatchId() {
        this.prefs.put("batch_id", this.batchId);
        this.prefs.apply();
    }

    public void sendLogs(@NonNull File[] fileArr) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("batch_id", (Number) Integer.valueOf(this.batchId));
            jsonObject.addProperty(HEADER_LOG_DEVICE_ID, this.deviceId);
            try {
                JsonArray payload = getPayload(file);
                if (payload == null) {
                    FileUtility.delete(file);
                    i++;
                } else {
                    jsonObject.members.put("payload", payload);
                    if (this.vungleApiClient.sendLog(jsonObject).execute().isSuccessful()) {
                        FileUtility.delete(file);
                    }
                    if (this.batchId >= Integer.MAX_VALUE) {
                        this.batchId = -1;
                    }
                    this.batchId++;
                    i++;
                }
            } catch (IOException unused) {
                Log.e(TAG, "Failed to generate request payload.");
            }
        }
        saveBatchId();
    }
}
