package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.FetchedAppSettings;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class Store {
    public final Context context;
    public final SharedPreferences store;
    @GuardedBy("this")
    public final Map<String, Long> subtypeCreationTimes = new ArrayMap();

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class Token {
        public static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        public final String appVersion;
        public final long timestamp;
        public final String token;

        public Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        public static String encode(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                GeneratedOutlineSupport.outline30(valueOf.length() + 24, "Failed to encode token: ", valueOf, "FirebaseInstanceId");
                return null;
            }
        }

        public static String getTokenOrNull(@Nullable Token token2) {
            if (token2 == null) {
                return null;
            }
            return token2.token;
        }

        public static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(str, (String) null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                GeneratedOutlineSupport.outline30(valueOf.length() + 23, "Failed to parse token: ", valueOf, "FirebaseInstanceId");
                return null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (android.util.Log.isLoggable("FirebaseInstanceId", 3) != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        r4 = java.lang.String.valueOf(r4.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r4.length() != 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        r4 = "Error creating file in no backup dir: ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        r4 = new java.lang.String("Error creating file in no backup dir: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007f, code lost:
        android.util.Log.d("FirebaseInstanceId", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Store(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r3.subtypeCreationTimes = r0
            r3.context = r4
            java.lang.String r0 = "com.google.android.gms.appid"
            r1 = 0
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r0, r1)
            r3.store = r4
            java.lang.String r4 = "com.google.android.gms.appid-no-backup"
            android.content.Context r0 = r3.context
            java.io.File r0 = androidx.core.content.ContextCompat.getNoBackupFilesDir(r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r4)
            boolean r4 = r1.exists()
            if (r4 == 0) goto L_0x0029
            goto L_0x0082
        L_0x0029:
            boolean r4 = r1.createNewFile()     // Catch:{ IOException -> 0x0059 }
            if (r4 == 0) goto L_0x0082
            monitor-enter(r3)     // Catch:{ IOException -> 0x0059 }
            android.content.SharedPreferences r4 = r3.store     // Catch:{ all -> 0x0056 }
            java.util.Map r4 = r4.getAll()     // Catch:{ all -> 0x0056 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)     // Catch:{ IOException -> 0x0059 }
            if (r4 != 0) goto L_0x0082
            java.lang.String r4 = "FirebaseInstanceId"
            java.lang.String r0 = "App restored, clearing state"
            android.util.Log.i(r4, r0)     // Catch:{ IOException -> 0x0059 }
            r3.deleteAll()     // Catch:{ IOException -> 0x0059 }
            com.google.firebase.iid.FirebaseInstanceId r4 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ IOException -> 0x0059 }
            monitor-enter(r4)     // Catch:{ IOException -> 0x0059 }
            com.google.firebase.iid.Store r0 = com.google.firebase.iid.FirebaseInstanceId.store     // Catch:{ all -> 0x0053 }
            r0.deleteAll()     // Catch:{ all -> 0x0053 }
            monitor-exit(r4)     // Catch:{ IOException -> 0x0059 }
            goto L_0x0082
        L_0x0053:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ IOException -> 0x0059 }
            throw r0     // Catch:{ IOException -> 0x0059 }
        L_0x0056:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ IOException -> 0x0059 }
            throw r4     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r4 = move-exception
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 == 0) goto L_0x0082
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "Error creating file in no backup dir: "
            java.lang.String r4 = r4.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r2 = r4.length()
            if (r2 == 0) goto L_0x007a
            java.lang.String r4 = r1.concat(r4)
            goto L_0x007f
        L_0x007a:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1)
        L_0x007f:
            android.util.Log.d(r0, r4)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.Store.<init>(android.content.Context):void");
    }

    public static String createSubtypeInfoKey(String str, String str2) {
        return GeneratedOutlineSupport.outline12(str2.length() + GeneratedOutlineSupport.outline3(str, 3), str, "|S|", str2);
    }

    public final String createTokenKey(String str, String str2, String str3) {
        StringBuilder outline23 = GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(str3, GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(str, 4))), str, "|T|", str2, FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
        outline23.append(str3);
        return outline23.toString();
    }

    public synchronized void deleteAll() {
        this.subtypeCreationTimes.clear();
        this.store.edit().clear().commit();
    }

    public final long writeCreationTimeToSharedPreferences(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.store.contains(createSubtypeInfoKey(str, "cre"))) {
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(createSubtypeInfoKey(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
            return currentTimeMillis;
        }
        String string = this.store.getString(createSubtypeInfoKey(str, "cre"), (String) null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }
}
