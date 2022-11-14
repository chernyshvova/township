package com.appsflyer.internal;

import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.k */
public class C1482k implements Runnable {
    public final C1443bh valueOf;

    public C1482k() {
    }

    public static Map<String, Object> AFInAppEventParameterName(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = values((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventParameterName((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static Object AFInAppEventType(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                for (Object AFInAppEventType : (Collection) obj) {
                    jSONArray.put(AFInAppEventType(AFInAppEventType));
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < length; i++) {
                    jSONArray2.put(AFInAppEventType(Array.get(obj, i)));
                }
                return jSONArray2;
            } else if (obj instanceof Map) {
                return values((Map<String, ?>) (Map) obj);
            } else {
                return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
            }
        } catch (Exception unused) {
            return JSONObject.NULL;
        }
    }

    public static JSONObject values(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), AFInAppEventType(next.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void run() {
        HttpURLConnection values = values();
        if (values != null) {
            values.disconnect();
        }
    }

    public C1482k(C1443bh bhVar) {
        this.valueOf = bhVar;
    }

    public static List<Object> values(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = values((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventParameterName((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection values() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = ""
            com.appsflyer.internal.bh r0 = r1.valueOf
            java.lang.String r3 = r0.onInstallConversionFailureNative
            java.lang.String r0 = r0.AFLogger$LogLevel()
            com.appsflyer.internal.bh r4 = r1.valueOf
            boolean r4 = r4.AppsFlyer2dXConversionCallback()
            com.appsflyer.internal.bh r5 = r1.valueOf
            boolean r5 = r5.init()
            com.appsflyer.internal.bh r6 = r1.valueOf
            boolean r6 = r6.getLevel()
            com.appsflyer.internal.bh r7 = r1.valueOf
            boolean r7 = r7.AFKeystoreWrapper()
            byte[] r8 = r0.getBytes()
            r9 = 0
            if (r4 == 0) goto L_0x002c
            return r9
        L_0x002c:
            r4 = 1
            r10 = 0
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x0169 }
            r11.<init>(r3)     // Catch:{ all -> 0x0169 }
            if (r6 == 0) goto L_0x007c
            com.appsflyer.internal.am r12 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()     // Catch:{ all -> 0x0169 }
            java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = "server_request"
            java.lang.String[] r15 = new java.lang.String[r4]     // Catch:{ all -> 0x0169 }
            r15[r10] = r0     // Catch:{ all -> 0x0169 }
            r12.valueOf(r14, r13, r15)     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x0169 }
            int r12 = r12.length     // Catch:{ all -> 0x0169 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x0169 }
            r13.append(r11)     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x0169 }
            r13.append(r12)     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x0169 }
            if (r12 <= r4) goto L_0x0069
            java.lang.String r12 = "s"
            goto L_0x006a
        L_0x0069:
            r12 = r2
        L_0x006a:
            r13.append(r12)     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = "; body = "
            r13.append(r12)     // Catch:{ all -> 0x0169 }
            r13.append(r0)     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0169 }
            com.appsflyer.internal.C1415an.AFKeystoreWrapper(r0)     // Catch:{ all -> 0x0169 }
        L_0x007c:
            java.lang.String r0 = "AppsFlyer"
            int r0 = r0.hashCode()     // Catch:{ all -> 0x0169 }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x0169 }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x0169 }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x0169 }
            r0 = 30000(0x7530, float:4.2039E-41)
            r12.setReadTimeout(r0)     // Catch:{ all -> 0x0166 }
            r12.setConnectTimeout(r0)     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "POST"
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0166 }
            r12.setDoInput(r4)     // Catch:{ all -> 0x0166 }
            r12.setDoOutput(r4)     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "Content-Type"
            if (r7 == 0) goto L_0x00a6
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00a8
        L_0x00a6:
            java.lang.String r13 = "application/json"
        L_0x00a8:
            r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x0166 }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x0166 }
            if (r7 == 0) goto L_0x012b
            com.appsflyer.internal.bh r7 = r1.valueOf     // Catch:{ all -> 0x0166 }
            java.lang.String r7 = r7.AFLogger$LogLevel     // Catch:{ all -> 0x0166 }
            java.lang.Object[] r13 = new java.lang.Object[r4]     // Catch:{ all -> 0x0122 }
            r13[r10] = r7     // Catch:{ all -> 0x0122 }
            int r7 = android.text.TextUtils.indexOf(r2, r2)     // Catch:{ all -> 0x0122 }
            int r7 = 24 - r7
            float r14 = android.util.TypedValue.complexToFloat(r10)     // Catch:{ all -> 0x0122 }
            r15 = 0
            r16 = 57163(0xdf4b, float:8.0102E-41)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            int r14 = r14 + r16
            char r14 = (char) r14     // Catch:{ all -> 0x0122 }
            int r15 = android.view.View.getDefaultSize(r10, r10)     // Catch:{ all -> 0x0122 }
            int r15 = r15 + 24
            java.lang.Object r7 = com.appsflyer.internal.C1435b.values(r7, r14, r15)     // Catch:{ all -> 0x0122 }
            java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ all -> 0x0122 }
            java.lang.String r14 = "AFKeystoreWrapper"
            java.lang.Class[] r15 = new java.lang.Class[r4]     // Catch:{ all -> 0x0122 }
            java.lang.Class<java.lang.String> r17 = java.lang.String.class
            r15[r10] = r17     // Catch:{ all -> 0x0122 }
            java.lang.reflect.Method r7 = r7.getMethod(r14, r15)     // Catch:{ all -> 0x0122 }
            java.lang.Object r7 = r7.invoke(r9, r13)     // Catch:{ all -> 0x0122 }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0119 }
            r9[r10] = r8     // Catch:{ all -> 0x0119 }
            int r8 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x0119 }
            int r8 = r8 + 24
            int r13 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x0119 }
            int r13 = r16 - r13
            char r13 = (char) r13     // Catch:{ all -> 0x0119 }
            int r14 = android.graphics.ImageFormat.getBitsPerPixel(r10)     // Catch:{ all -> 0x0119 }
            int r14 = 23 - r14
            java.lang.Object r8 = com.appsflyer.internal.C1435b.values(r8, r13, r14)     // Catch:{ all -> 0x0119 }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x0119 }
            java.lang.String r13 = "values"
            java.lang.Class[] r14 = new java.lang.Class[r4]     // Catch:{ all -> 0x0119 }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r10] = r15     // Catch:{ all -> 0x0119 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x0119 }
            java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x0119 }
            r8 = r7
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0119 }
            goto L_0x012b
        L_0x0119:
            r0 = move-exception
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x0166 }
            if (r5 == 0) goto L_0x0121
            throw r5     // Catch:{ all -> 0x0166 }
        L_0x0121:
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x0122:
            r0 = move-exception
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x0166 }
            if (r5 == 0) goto L_0x012a
            throw r5     // Catch:{ all -> 0x0166 }
        L_0x012a:
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x012b:
            r0.write(r8)     // Catch:{ all -> 0x0166 }
            r0.close()     // Catch:{ all -> 0x0166 }
            r12.connect()     // Catch:{ all -> 0x0166 }
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x0166 }
            if (r5 == 0) goto L_0x0141
            com.appsflyer.internal.C1387af.AFInAppEventParameterName()     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = com.appsflyer.internal.C1387af.AFInAppEventType((java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x0166 }
        L_0x0141:
            if (r6 == 0) goto L_0x015b
            com.appsflyer.internal.am r5 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0166 }
            java.lang.String r7 = "server_response"
            r8 = 2
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x0166 }
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0166 }
            r8[r10] = r9     // Catch:{ all -> 0x0166 }
            r8[r4] = r2     // Catch:{ all -> 0x0166 }
            r5.valueOf(r7, r6, r8)     // Catch:{ all -> 0x0166 }
        L_0x015b:
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x0178
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)     // Catch:{ all -> 0x0166 }
            r4 = 0
            goto L_0x0178
        L_0x0166:
            r0 = move-exception
            r9 = r12
            goto L_0x016a
        L_0x0169:
            r0 = move-exception
        L_0x016a:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "Error while calling "
            java.lang.String r3 = r5.concat(r3)
            com.appsflyer.AFLogger.values(r3, r0)
            r12 = r9
        L_0x0178:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r4 == 0) goto L_0x0184
            java.lang.String r3 = "error"
            goto L_0x0186
        L_0x0184:
            java.lang.String r3 = "call succeeded"
        L_0x0186:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1482k.values():java.net.HttpURLConnection");
    }
}
