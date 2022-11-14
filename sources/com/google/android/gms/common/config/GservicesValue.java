package com.google.android.gms.common.config;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class GservicesValue<T> {
    public static final Object zzc = new Object();
    @RecentlyNonNull
    public final String zza;
    @RecentlyNonNull
    public final T zzb;
    @Nullable
    public T zzd = null;

    public GservicesValue(@RecentlyNonNull String str, @RecentlyNonNull T t) {
        this.zza = str;
        this.zzb = t;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@RecentlyNonNull String str, @RecentlyNonNull Float f) {
        return new zzd(str, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3 = zza(r4.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0033, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0036, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x001d */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r4 = this;
            T r0 = r4.zzd
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            java.lang.Object r1 = zzc
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            java.lang.Object r2 = zzc
            monitor-enter(r2)
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r4.zza     // Catch:{ SecurityException -> 0x001d }
            java.lang.Object r1 = r4.zza(r1)     // Catch:{ SecurityException -> 0x001d }
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x001b:
            r1 = move-exception
            goto L_0x0033
        L_0x001d:
            long r1 = android.os.Binder.clearCallingIdentity()     // Catch:{ all -> 0x001b }
            java.lang.String r3 = r4.zza     // Catch:{ all -> 0x002e }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x002e }
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x001b }
            android.os.StrictMode.setThreadPolicy(r0)
            return r3
        L_0x002e:
            r3 = move-exception
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x001b }
            throw r3     // Catch:{ all -> 0x001b }
        L_0x0033:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r1
        L_0x0037:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            throw r0
        L_0x003a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.get():java.lang.Object");
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @KeepForSdk
    @VisibleForTesting
    public void override(@RecentlyNonNull T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = t;
        synchronized (zzc) {
            synchronized (zzc) {
            }
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public void resetOverride() {
        this.zzd = null;
    }

    @RecentlyNonNull
    public abstract T zza(@RecentlyNonNull String str);

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@RecentlyNonNull String str, @RecentlyNonNull Integer num) {
        return new zzc(str, num);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@RecentlyNonNull String str, @RecentlyNonNull Long l) {
        return new zzb(str, l);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<String> value(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        return new zze(str, str2);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@RecentlyNonNull String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }
}
