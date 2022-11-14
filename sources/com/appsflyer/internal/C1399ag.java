package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.appsflyer.internal.ag */
public final class C1399ag {
    public static C1399ag valueOf = new C1399ag();

    public static C1399ag AFInAppEventType() {
        return valueOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[SYNTHETIC, Splitter:B:23:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.C1481i AFKeystoreWrapper(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0033, all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0033, all -> 0x0027 }
            long r2 = r4.length()     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            char[] r2 = new char[r3]     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r1.read(r2)     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            com.appsflyer.internal.i r3 = new com.appsflyer.internal.i     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r3.valueOf = r4     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r4 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r4)
        L_0x0023:
            return r3
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r0 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r0)
        L_0x0032:
            throw r4
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r4 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r4)
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1399ag.AFKeystoreWrapper(java.io.File):com.appsflyer.internal.i");
    }

    public static File valueOf(Context context) {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    public static List<C1481i> values(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file2.getName());
                    AFLogger.AFInAppEventParameterName(sb.toString());
                    arrayList.add(AFKeystoreWrapper(file2));
                }
            }
        } catch (Exception e) {
            AFLogger.values("Could not cache request", e);
        }
        return arrayList;
    }

    public static void values(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        sb.append(" from cache");
        AFLogger.AFInAppEventParameterName(sb.toString());
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
                AFLogger.values(sb2.toString(), e);
            }
        }
    }
}
