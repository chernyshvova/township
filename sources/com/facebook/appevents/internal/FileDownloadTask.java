package com.facebook.appevents.internal;

import android.os.AsyncTask;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileDownloadTask.kt */
public final class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
    public final File destFile;
    public final Callback onSuccess;
    public final String uriStr;

    /* compiled from: FileDownloadTask.kt */
    public interface Callback {
        void onComplete(File file);
    }

    public FileDownloadTask(String str, File file, Callback callback) {
        Intrinsics.checkNotNullParameter(str, "uriStr");
        Intrinsics.checkNotNullParameter(file, "destFile");
        Intrinsics.checkNotNullParameter(callback, "onSuccess");
        this.uriStr = str;
        this.destFile = file;
        this.onSuccess = callback;
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground((String[]) objArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                onPostExecute(((Boolean) obj).booleanValue());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        return java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0045 */
    @androidx.annotation.VisibleForTesting(otherwise = 4)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean doInBackground(java.lang.String... r5) {
        /*
            r4 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)     // Catch:{ all -> 0x0048 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0045 }
            java.lang.String r0 = r4.uriStr     // Catch:{ Exception -> 0x0045 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0045 }
            java.net.URLConnection r0 = r5.openConnection()     // Catch:{ Exception -> 0x0045 }
            int r0 = r0.getContentLength()     // Catch:{ Exception -> 0x0045 }
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0045 }
            java.io.InputStream r5 = r5.openStream()     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0045 }
            byte[] r5 = new byte[r0]     // Catch:{ Exception -> 0x0045 }
            r2.readFully(r5)     // Catch:{ Exception -> 0x0045 }
            r2.close()     // Catch:{ Exception -> 0x0045 }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0045 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0045 }
            java.io.File r3 = r4.destFile     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0045 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0045 }
            r0.write(r5)     // Catch:{ Exception -> 0x0045 }
            r0.flush()     // Catch:{ Exception -> 0x0045 }
            r0.close()     // Catch:{ Exception -> 0x0045 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0045 }
            return r5
        L_0x0045:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0048 }
            return r5
        L_0x0048:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.FileDownloadTask.doInBackground(java.lang.String[]):java.lang.Boolean");
    }

    public void onPostExecute(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this) && z) {
            try {
                this.onSuccess.onComplete(this.destFile);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
