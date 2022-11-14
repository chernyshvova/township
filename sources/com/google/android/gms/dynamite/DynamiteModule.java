package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class DynamiteModule {
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzg();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzh();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzi();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zze();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzd();
    @RecentlyNonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzf();
    @RecentlyNonNull
    public static final VersionPolicy zza = new zzj();
    @GuardedBy("DynamiteModule.class")
    @Nullable
    public static Boolean zzb = null;
    @GuardedBy("DynamiteModule.class")
    @Nullable
    public static String zzc = null;
    @GuardedBy("DynamiteModule.class")
    public static int zzd = -1;
    public static final ThreadLocal<zzk> zze = new ThreadLocal<>();
    public static final ThreadLocal<Long> zzf = new zzb();
    public static final zzm zzg = new zzc();
    @GuardedBy("DynamiteModule.class")
    @Nullable
    public static zzo zzi;
    @GuardedBy("DynamiteModule.class")
    @Nullable
    public static zzp zzj;
    public final Context zzh;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, zzb zzb) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, zzb zzb) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface VersionPolicy {
        zzn zza(Context context, String str, zzm zzm) throws LoadingException;
    }

    public DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzh = context;
    }

    @KeepForSdk
    public static int getLocalVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02b1, code lost:
        if (r1 != null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b0, code lost:
        if (r1 != null) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x030f  */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(@androidx.annotation.RecentlyNonNull android.content.Context r18, @androidx.annotation.RecentlyNonNull com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r19, @androidx.annotation.RecentlyNonNull java.lang.String r20) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r0 = zze
            java.lang.Object r0 = r0.get()
            r5 = r0
            com.google.android.gms.dynamite.zzk r5 = (com.google.android.gms.dynamite.zzk) r5
            com.google.android.gms.dynamite.zzk r6 = new com.google.android.gms.dynamite.zzk
            r7 = 0
            r6.<init>(r7)
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r0 = zze
            r0.set(r6)
            java.lang.ThreadLocal<java.lang.Long> r0 = zzf
            java.lang.Object r0 = r0.get()
            java.lang.Long r0 = (java.lang.Long) r0
            long r8 = r0.longValue()
            r10 = 0
            java.lang.ThreadLocal<java.lang.Long> r0 = zzf     // Catch:{ all -> 0x02f6 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02f6 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x02f6 }
            r0.set(r12)     // Catch:{ all -> 0x02f6 }
            com.google.android.gms.dynamite.zzm r0 = zzg     // Catch:{ all -> 0x02f6 }
            com.google.android.gms.dynamite.zzn r12 = r2.zza(r1, r3, r0)     // Catch:{ all -> 0x02f6 }
            java.lang.String r0 = "DynamiteModule"
            int r13 = r12.zza     // Catch:{ all -> 0x02f6 }
            int r14 = r12.zzb     // Catch:{ all -> 0x02f6 }
            java.lang.String r15 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x02f6 }
            int r15 = r15.length()     // Catch:{ all -> 0x02f6 }
            int r15 = r15 + 68
            java.lang.String r16 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x02f6 }
            int r16 = r16.length()     // Catch:{ all -> 0x02f6 }
            int r15 = r15 + r16
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f6 }
            r7.<init>(r15)     // Catch:{ all -> 0x02f6 }
            java.lang.String r15 = "Considering local module "
            r7.append(r15)     // Catch:{ all -> 0x02f6 }
            r7.append(r3)     // Catch:{ all -> 0x02f6 }
            java.lang.String r15 = ":"
            r7.append(r15)     // Catch:{ all -> 0x02f6 }
            r7.append(r13)     // Catch:{ all -> 0x02f6 }
            java.lang.String r13 = " and remote module "
            r7.append(r13)     // Catch:{ all -> 0x02f6 }
            r7.append(r3)     // Catch:{ all -> 0x02f6 }
            java.lang.String r13 = ":"
            r7.append(r13)     // Catch:{ all -> 0x02f6 }
            r7.append(r14)     // Catch:{ all -> 0x02f6 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02f6 }
            android.util.Log.i(r0, r7)     // Catch:{ all -> 0x02f6 }
            int r0 = r12.zzc     // Catch:{ all -> 0x02f6 }
            if (r0 == 0) goto L_0x02c7
            r7 = -1
            if (r0 != r7) goto L_0x008e
            int r13 = r12.zza     // Catch:{ all -> 0x02f6 }
            if (r13 == 0) goto L_0x02c7
        L_0x008e:
            r13 = 1
            if (r0 != r13) goto L_0x0095
            int r14 = r12.zzb     // Catch:{ all -> 0x02f6 }
            if (r14 == 0) goto L_0x02c7
        L_0x0095:
            if (r0 != r7) goto L_0x00bb
            com.google.android.gms.dynamite.DynamiteModule r0 = zzd(r1, r3)     // Catch:{ all -> 0x02f6 }
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x00a5
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf
            r1.remove()
            goto L_0x00ae
        L_0x00a5:
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x00ae:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x00b5
        L_0x00b2:
            r1.close()
        L_0x00b5:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r1 = zze
            r1.set(r5)
            return r0
        L_0x00bb:
            if (r0 != r13) goto L_0x02be
            int r0 = r12.zzb     // Catch:{ LoadingException -> 0x0262 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.Boolean r15 = zzb     // Catch:{ all -> 0x0243 }
            monitor-exit(r4)     // Catch:{ all -> 0x0243 }
            if (r15 == 0) goto L_0x023a
            boolean r15 = r15.booleanValue()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r13 = 2
            if (r15 == 0) goto L_0x017d
            java.lang.String r15 = "DynamiteModule"
            java.lang.String r17 = java.lang.String.valueOf(r20)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            int r17 = r17.length()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            int r7 = r17 + 51
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r14.<init>(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r7 = "Selected remote version of "
            r14.append(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r14.append(r3)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r7 = ", version >= "
            r14.append(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r14.append(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r7 = r14.toString()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            android.util.Log.i(r15, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamite.zzp r7 = zzj     // Catch:{ all -> 0x017a }
            monitor-exit(r4)     // Catch:{ all -> 0x017a }
            if (r7 == 0) goto L_0x0171
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r14 = zze     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.Object r14 = r14.get()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamite.zzk r14 = (com.google.android.gms.dynamite.zzk) r14     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r14 == 0) goto L_0x0168
            android.database.Cursor r15 = r14.zza     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r15 == 0) goto L_0x0168
            android.content.Context r15 = r18.getApplicationContext()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            android.database.Cursor r14 = r14.zza     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r16 = 0
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            int r10 = zzd     // Catch:{ all -> 0x0165 }
            if (r10 < r13) goto L_0x011a
            r13 = 1
            goto L_0x011b
        L_0x011a:
            r13 = 0
        L_0x011b:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0165 }
            monitor-exit(r4)     // Catch:{ all -> 0x0165 }
            boolean r4 = r10.booleanValue()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r4 == 0) goto L_0x013a
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r10 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            android.util.Log.v(r4, r10)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r14)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r7.zzf(r4, r3, r0, r10)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            goto L_0x014d
        L_0x013a:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r10 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r4, r10)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r14)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r7.zze(r4, r3, r0, r10)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x014d:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r0 == 0) goto L_0x015c
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            goto L_0x0206
        L_0x015c:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "Failed to get module context"
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0165:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0165 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0168:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "No result cursor"
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0171:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "DynamiteLoaderV2 was not cached."
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x017a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x017a }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x017d:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r7 = java.lang.String.valueOf(r20)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            int r7 = r7.length()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            int r7 = r7 + 51
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r10.<init>(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r7 = "Selected remote version of "
            r10.append(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r10.append(r3)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r7 = ", version >= "
            r10.append(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r10.append(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r7 = r10.toString()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            android.util.Log.i(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamite.zzo r4 = zzf(r18)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r4 == 0) goto L_0x0231
            int r7 = r4.zzi()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r10 = 3
            if (r7 < r10) goto L_0x01d4
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r7 = zze     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.Object r7 = r7.get()     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamite.zzk r7 = (com.google.android.gms.dynamite.zzk) r7     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r7 == 0) goto L_0x01cb
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            android.database.Cursor r7 = r7.zza     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzk(r10, r3, r0, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            goto L_0x01f5
        L_0x01cb:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "No cached result cursor holder"
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x01d4:
            if (r7 != r13) goto L_0x01e6
            java.lang.String r7 = "DynamiteModule"
            java.lang.String r10 = "IDynamite loader version = 2"
            android.util.Log.w(r7, r10)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzg(r7, r3, r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            goto L_0x01f5
        L_0x01e6:
            java.lang.String r7 = "DynamiteModule"
            java.lang.String r10 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r7, r10)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zze(r7, r3, r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x01f5:
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            if (r4 == 0) goto L_0x0228
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0206:
            r1 = 0
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0212
            java.lang.ThreadLocal<java.lang.Long> r0 = zzf
            r0.remove()
            goto L_0x021b
        L_0x0212:
            java.lang.ThreadLocal<java.lang.Long> r0 = zzf
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            r0.set(r1)
        L_0x021b:
            android.database.Cursor r0 = r6.zza
            if (r0 == 0) goto L_0x0222
            r0.close()
        L_0x0222:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r0 = zze
            r0.set(r5)
            return r4
        L_0x0228:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "Failed to load remote module."
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0231:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "Failed to create IDynamiteLoader."
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x023a:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            java.lang.String r4 = "Failed to determine which loading route to use."
            r7 = 0
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0243:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0243 }
            throw r0     // Catch:{ RemoteException -> 0x024a, LoadingException -> 0x0248, all -> 0x0246 }
        L_0x0246:
            r0 = move-exception
            goto L_0x024c
        L_0x0248:
            r0 = move-exception
            goto L_0x0258
        L_0x024a:
            r0 = move-exception
            goto L_0x0259
        L_0x024c:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = "Failed to load remote module."
            r10 = 0
            r4.<init>(r7, r0, r10)     // Catch:{ all -> 0x02f2 }
            throw r4     // Catch:{ all -> 0x02f2 }
        L_0x0258:
            throw r0     // Catch:{ all -> 0x02f2 }
        L_0x0259:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = "Failed to load remote module."
            r10 = 0
            r4.<init>(r7, r0, r10)     // Catch:{ all -> 0x02f2 }
            throw r4     // Catch:{ all -> 0x02f2 }
        L_0x0262:
            r0 = move-exception
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r7 = "Failed to load remote module: "
            java.lang.String r10 = r0.getMessage()     // Catch:{  }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{  }
            int r11 = r10.length()     // Catch:{  }
            if (r11 == 0) goto L_0x027a
            java.lang.String r7 = r7.concat(r10)     // Catch:{  }
            goto L_0x0280
        L_0x027a:
            java.lang.String r10 = new java.lang.String     // Catch:{  }
            r10.<init>(r7)     // Catch:{  }
            r7 = r10
        L_0x0280:
            android.util.Log.w(r4, r7)     // Catch:{  }
            int r4 = r12.zza     // Catch:{  }
            if (r4 == 0) goto L_0x02b5
            com.google.android.gms.dynamite.zzl r7 = new com.google.android.gms.dynamite.zzl     // Catch:{  }
            r10 = 0
            r7.<init>(r4, r10)     // Catch:{  }
            com.google.android.gms.dynamite.zzn r2 = r2.zza(r1, r3, r7)     // Catch:{  }
            int r2 = r2.zzc     // Catch:{  }
            r4 = -1
            if (r2 != r4) goto L_0x02b5
            com.google.android.gms.dynamite.DynamiteModule r0 = zzd(r1, r3)     // Catch:{  }
            r1 = 0
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x02a6
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf
            r1.remove()
            goto L_0x02af
        L_0x02a6:
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x02af:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x00b5
            goto L_0x00b2
        L_0x02b5:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r3 = 0
            r1.<init>(r2, r0, r3)     // Catch:{  }
            throw r1     // Catch:{  }
        L_0x02be:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            java.lang.String r1 = "VersionPolicy returned invalid code:0"
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x02c7:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            int r1 = r12.zza     // Catch:{  }
            int r2 = r12.zzb     // Catch:{  }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
            r4 = 91
            r3.<init>(r4)     // Catch:{  }
            java.lang.String r4 = "No acceptable module found. Local version is "
            r3.append(r4)     // Catch:{  }
            r3.append(r1)     // Catch:{  }
            java.lang.String r1 = " and remote version is "
            r3.append(r1)     // Catch:{  }
            r3.append(r2)     // Catch:{  }
            java.lang.String r1 = "."
            r3.append(r1)     // Catch:{  }
            java.lang.String r1 = r3.toString()     // Catch:{  }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x02f2:
            r0 = move-exception
            r1 = 0
            goto L_0x02f8
        L_0x02f6:
            r0 = move-exception
            r1 = r10
        L_0x02f8:
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0302
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf
            r1.remove()
            goto L_0x030b
        L_0x0302:
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x030b:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x0312
            r1.close()
        L_0x0312:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzk> r1 = zze
            r1.set(r5)
            goto L_0x0319
        L_0x0318:
            throw r0
        L_0x0319:
            goto L_0x0318
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0056=Splitter:B:23:0x0056, B:39:0x0097=Splitter:B:39:0x0097, B:18:0x0039=Splitter:B:18:0x0039} */
    public static int zza(@androidx.annotation.RecentlyNonNull android.content.Context r9, @androidx.annotation.RecentlyNonNull java.lang.String r10, boolean r11) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01b1 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01ae }
            r2 = 0
            if (r1 != 0) goto L_0x00d1
            android.content.Context r1 = r9.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r3 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r3 = r3.getName()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Class r1 = r1.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.String r3 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Class r3 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            monitor-enter(r3)     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Object r4 = r1.get(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x003c
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a5 }
            if (r4 != r1) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x0036:
            zze(r4)     // Catch:{ LoadingException -> 0x0039 }
        L_0x0039:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x003c:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r9.getApplicationContext()     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x00a5 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x0056
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a5 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a5 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x0056:
            int r4 = zzb(r9, r10, r11)     // Catch:{ LoadingException -> 0x009a }
            java.lang.String r5 = zzc     // Catch:{ LoadingException -> 0x009a }
            if (r5 == 0) goto L_0x0097
            java.lang.String r5 = zzc     // Catch:{ LoadingException -> 0x009a }
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x009a }
            if (r5 == 0) goto L_0x0067
            goto L_0x0097
        L_0x0067:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009a }
            r6 = 29
            if (r5 < r6) goto L_0x007c
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009a }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x009a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x009a }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009a }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x009a }
            goto L_0x008a
        L_0x007c:
            com.google.android.gms.dynamite.zza r5 = new com.google.android.gms.dynamite.zza     // Catch:{ LoadingException -> 0x009a }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x009a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x009a }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009a }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x009a }
        L_0x008a:
            zze(r5)     // Catch:{ LoadingException -> 0x009a }
            r1.set(r2, r5)     // Catch:{ LoadingException -> 0x009a }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x009a }
            zzb = r5     // Catch:{ LoadingException -> 0x009a }
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r0)     // Catch:{ all -> 0x01ae }
            return r4
        L_0x0097:
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r0)     // Catch:{ all -> 0x01ae }
            return r4
        L_0x009a:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a5 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a5 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            goto L_0x00cf
        L_0x00a5:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
        L_0x00a8:
            r1 = move-exception
            goto L_0x00ad
        L_0x00aa:
            r1 = move-exception
            goto L_0x00ad
        L_0x00ac:
            r1 = move-exception
        L_0x00ad:
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x01ae }
            int r4 = r1.length()     // Catch:{ all -> 0x01ae }
            int r4 = r4 + 30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ae }
            r5.<init>(r4)     // Catch:{ all -> 0x01ae }
            java.lang.String r4 = "Failed to load module via V2: "
            r5.append(r4)     // Catch:{ all -> 0x01ae }
            r5.append(r1)     // Catch:{ all -> 0x01ae }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01ae }
            android.util.Log.w(r3, r1)     // Catch:{ all -> 0x01ae }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01ae }
        L_0x00cf:
            zzb = r1     // Catch:{ all -> 0x01ae }
        L_0x00d1:
            monitor-exit(r0)     // Catch:{ all -> 0x01ae }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01b1 }
            r1 = 0
            if (r0 == 0) goto L_0x00ff
            int r9 = zzb(r9, r10, r11)     // Catch:{ LoadingException -> 0x00de }
            return r9
        L_0x00de:
            r10 = move-exception
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01b1 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x01b1 }
            int r2 = r10.length()     // Catch:{ all -> 0x01b1 }
            if (r2 == 0) goto L_0x00f6
            java.lang.String r10 = r0.concat(r10)     // Catch:{ all -> 0x01b1 }
            goto L_0x00fb
        L_0x00f6:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x01b1 }
            r10.<init>(r0)     // Catch:{ all -> 0x01b1 }
        L_0x00fb:
            android.util.Log.w(r11, r10)     // Catch:{ all -> 0x01b1 }
            return r1
        L_0x00ff:
            com.google.android.gms.dynamite.zzo r3 = zzf(r9)     // Catch:{ all -> 0x01b1 }
            if (r3 != 0) goto L_0x0107
            goto L_0x01a7
        L_0x0107:
            int r0 = r3.zzi()     // Catch:{ RemoteException -> 0x0181 }
            r4 = 3
            if (r0 < r4) goto L_0x015b
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0181 }
            java.lang.ThreadLocal<java.lang.Long> r0 = zzf     // Catch:{ RemoteException -> 0x0181 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0181 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0181 }
            long r7 = r0.longValue()     // Catch:{ RemoteException -> 0x0181 }
            r5 = r10
            r6 = r11
            com.google.android.gms.dynamic.IObjectWrapper r10 = r3.zzj(r4, r5, r6, r7)     // Catch:{ RemoteException -> 0x0181 }
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)     // Catch:{ RemoteException -> 0x0181 }
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch:{ RemoteException -> 0x0181 }
            if (r10 == 0) goto L_0x0148
            boolean r11 = r10.moveToFirst()     // Catch:{ RemoteException -> 0x0158, all -> 0x0155 }
            if (r11 != 0) goto L_0x0133
            goto L_0x0148
        L_0x0133:
            int r11 = r10.getInt(r1)     // Catch:{ RemoteException -> 0x0158, all -> 0x0155 }
            if (r11 <= 0) goto L_0x0140
            boolean r0 = zzc(r10)     // Catch:{ RemoteException -> 0x0158, all -> 0x0155 }
            if (r0 == 0) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r2 = r10
        L_0x0141:
            if (r2 == 0) goto L_0x0146
            r2.close()     // Catch:{ all -> 0x01b1 }
        L_0x0146:
            r1 = r11
            goto L_0x01a7
        L_0x0148:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r0)     // Catch:{ RemoteException -> 0x0158, all -> 0x0155 }
            if (r10 == 0) goto L_0x01a7
            r10.close()     // Catch:{ all -> 0x01b1 }
            goto L_0x01a7
        L_0x0155:
            r11 = move-exception
            r2 = r10
            goto L_0x01a8
        L_0x0158:
            r11 = move-exception
            r2 = r10
            goto L_0x0183
        L_0x015b:
            r4 = 2
            if (r0 != r4) goto L_0x016e
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0181 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0181 }
            int r1 = r3.zzh(r0, r10, r11)     // Catch:{ RemoteException -> 0x0181 }
            goto L_0x01a7
        L_0x016e:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0181 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0181 }
            int r1 = r3.zzf(r0, r10, r11)     // Catch:{ RemoteException -> 0x0181 }
            goto L_0x01a7
        L_0x017e:
            r10 = move-exception
            r11 = r10
            goto L_0x01a8
        L_0x0181:
            r10 = move-exception
            r11 = r10
        L_0x0183:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x017e }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x017e }
            int r3 = r11.length()     // Catch:{ all -> 0x017e }
            if (r3 == 0) goto L_0x019a
            java.lang.String r11 = r0.concat(r11)     // Catch:{ all -> 0x017e }
            goto L_0x019f
        L_0x019a:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x017e }
            r11.<init>(r0)     // Catch:{ all -> 0x017e }
        L_0x019f:
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x017e }
            if (r2 == 0) goto L_0x01a7
            r2.close()     // Catch:{ all -> 0x01b1 }
        L_0x01a7:
            return r1
        L_0x01a8:
            if (r2 == 0) goto L_0x01ad
            r2.close()     // Catch:{ all -> 0x01b1 }
        L_0x01ad:
            throw r11     // Catch:{ all -> 0x01b1 }
        L_0x01ae:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01ae }
            throw r10     // Catch:{ all -> 0x01b1 }
        L_0x01b1:
            r10 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r9, r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        if (zzc(r9) != false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(android.content.Context r9, java.lang.String r10, boolean r11) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal<java.lang.Long> r1 = zzf     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r9 = "api_force_staging"
            java.lang.String r4 = "api"
            r5 = 1
            if (r5 == r11) goto L_0x0019
            r9 = r4
        L_0x0019:
            android.net.Uri$Builder r11 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r11.<init>()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r11 = r11.scheme(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r11 = r11.authority(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri$Builder r9 = r11.path(r9)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri$Builder r9 = r9.appendPath(r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r10 = "requestStartTime"
            java.lang.String r11 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r10, r11)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.net.Uri r4 = r9.build()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            if (r9 == 0) goto L_0x0081
            boolean r10 = r9.moveToFirst()     // Catch:{ Exception -> 0x0090 }
            if (r10 == 0) goto L_0x0081
            r10 = 0
            int r10 = r9.getInt(r10)     // Catch:{ Exception -> 0x0090 }
            if (r10 <= 0) goto L_0x007a
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r11 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r11)     // Catch:{ Exception -> 0x0090 }
            r1 = 2
            java.lang.String r1 = r9.getString(r1)     // Catch:{ all -> 0x0077 }
            zzc = r1     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x0077 }
            if (r1 < 0) goto L_0x006f
            int r1 = r9.getInt(r1)     // Catch:{ all -> 0x0077 }
            zzd = r1     // Catch:{ all -> 0x0077 }
        L_0x006f:
            monitor-exit(r11)     // Catch:{ all -> 0x0077 }
            boolean r11 = zzc(r9)     // Catch:{ Exception -> 0x0090 }
            if (r11 == 0) goto L_0x007a
            goto L_0x007b
        L_0x0077:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0077 }
            throw r10     // Catch:{ Exception -> 0x0090 }
        L_0x007a:
            r0 = r9
        L_0x007b:
            if (r0 == 0) goto L_0x0080
            r0.close()
        L_0x0080:
            return r10
        L_0x0081:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r11 = "Failed to retrieve remote module version."
            android.util.Log.w(r10, r11)     // Catch:{ Exception -> 0x0090 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0090 }
            java.lang.String r11 = "Failed to connect to dynamite module ContentResolver."
            r10.<init>(r11, r0)     // Catch:{ Exception -> 0x0090 }
            throw r10     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            r10 = move-exception
            goto L_0x0098
        L_0x0092:
            r9 = move-exception
            r10 = r9
            goto L_0x00a7
        L_0x0095:
            r9 = move-exception
            r10 = r9
            r9 = r0
        L_0x0098:
            boolean r11 = r10 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00a5 }
            if (r11 == 0) goto L_0x009d
            throw r10     // Catch:{ all -> 0x00a5 }
        L_0x009d:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = "V2 version check failed"
            r11.<init>(r1, r10, r0)     // Catch:{ all -> 0x00a5 }
            throw r11     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r10 = move-exception
            r0 = r9
        L_0x00a7:
            if (r0 == 0) goto L_0x00ac
            r0.close()
        L_0x00ac:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    public static boolean zzc(Cursor cursor) {
        zzk zzk = zze.get();
        if (zzk == null || zzk.zza != null) {
            return false;
        }
        zzk.zza = cursor;
        return true;
    }

    public static DynamiteModule zzd(Context context, String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Selected local version of ".concat(valueOf);
        } else {
            str2 = new String("Selected local version of ");
        }
        Log.i("DynamiteModule", str2);
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    public static void zze(ClassLoader classLoader) throws LoadingException {
        zzp zzp;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzp = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzp) {
                    zzp = (zzp) queryLocalInterface;
                } else {
                    zzp = new zzp(iBinder);
                }
            }
            zzj = zzp;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzb) null);
        }
    }

    @Nullable
    public static zzo zzf(Context context) {
        zzo zzo;
        synchronized (DynamiteModule.class) {
            if (zzi != null) {
                zzo zzo2 = zzi;
                return zzo2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzo = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzo) {
                        zzo = (zzo) queryLocalInterface;
                    } else {
                        zzo = new zzo(iBinder);
                    }
                }
                if (zzo != null) {
                    zzi = zzo;
                    return zzo;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Context getModuleContext() {
        return this.zzh;
    }

    @RecentlyNonNull
    @KeepForSdk
    public IBinder instantiate(@RecentlyNonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzh.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zzb) null);
        }
    }
}
