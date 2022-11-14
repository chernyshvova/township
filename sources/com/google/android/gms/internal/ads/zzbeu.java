package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbeu<T> {
    @Nullable
    public static final zzbgb zza;

    static {
        zzbgb zzbfz;
        zzbgb zzbgb = null;
        try {
            Object newInstance = zzbet.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzcgs.zzi("ClientApi class is not an instance of IBinder.");
            } else {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    if (queryLocalInterface instanceof zzbgb) {
                        zzbfz = (zzbgb) queryLocalInterface;
                    } else {
                        zzbfz = new zzbfz(iBinder);
                    }
                    zzbgb = zzbfz;
                }
            }
        } catch (Exception unused) {
            zzcgs.zzi("Failed to instantiate ClientApi class.");
        }
        zza = zzbgb;
    }

    @Nullable
    private final T zze() {
        zzbgb zzbgb = zza;
        if (zzbgb == null) {
            zzcgs.zzi("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zzc(zzbgb);
        } catch (RemoteException e) {
            zzcgs.zzj("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private final T zzf() {
        try {
            return zzb();
        } catch (RemoteException e) {
            zzcgs.zzj("Cannot invoke remote loader.", e);
            return null;
        }
    }

    @NonNull
    public abstract T zza();

    @Nullable
    public abstract T zzb() throws RemoteException;

    @Nullable
    public abstract T zzc(zzbgb zzbgb) throws RemoteException;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzd(android.content.Context r9, boolean r10) {
        /*
            r8 = this;
            r0 = 1
            if (r10 != 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzbev.zza()
            r1 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r1 = com.google.android.gms.internal.ads.zzcgl.zzn(r9, r1)
            if (r1 != 0) goto L_0x0015
            java.lang.String r10 = "Google Play Services is not available."
            com.google.android.gms.internal.ads.zzcgs.zzd(r10)
            r10 = 1
        L_0x0015:
            java.lang.String r1 = "com.google.android.gms.ads.dynamite"
            int r2 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r9, r1)
            int r1 = com.google.android.gms.dynamite.DynamiteModule.getRemoteVersion(r9, r1)
            r3 = 0
            if (r2 <= r1) goto L_0x0024
            r1 = 0
            goto L_0x0025
        L_0x0024:
            r1 = 1
        L_0x0025:
            r1 = r1 ^ r0
            r10 = r10 | r1
            com.google.android.gms.internal.ads.zzbjn.zza(r9)
            com.google.android.gms.internal.ads.zzbkp<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzbkw.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x003a
        L_0x0038:
            r10 = 0
            goto L_0x004d
        L_0x003a:
            com.google.android.gms.internal.ads.zzbkp<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzbkw.zzb
            java.lang.Object r1 = r1.zze()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x004b
            r10 = 1
            r3 = 1
            goto L_0x004d
        L_0x004b:
            r3 = r10
            goto L_0x0038
        L_0x004d:
            if (r3 == 0) goto L_0x005c
            java.lang.Object r9 = r8.zze()
            if (r9 != 0) goto L_0x00a2
            if (r10 != 0) goto L_0x00a2
            java.lang.Object r9 = r8.zzf()
            goto L_0x00a2
        L_0x005c:
            java.lang.Object r10 = r8.zzf()
            if (r10 != 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzbkp<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzblh.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            int r1 = r1.intValue()
            java.util.Random r2 = com.google.android.gms.internal.ads.zzbev.zze()
            int r1 = r2.nextInt(r1)
            if (r1 != 0) goto L_0x009a
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            java.lang.String r1 = "action"
            java.lang.String r2 = "dynamite_load"
            r6.putString(r1, r2)
            java.lang.String r1 = "is_missing"
            r6.putInt(r1, r0)
            com.google.android.gms.internal.ads.zzcgl r2 = com.google.android.gms.internal.ads.zzbev.zza()
            com.google.android.gms.internal.ads.zzcgy r0 = com.google.android.gms.internal.ads.zzbev.zzd()
            java.lang.String r4 = r0.zza
            r7 = 1
            java.lang.String r5 = "gmob-apps"
            r3 = r9
            r2.zze(r3, r4, r5, r6, r7)
        L_0x009a:
            if (r10 != 0) goto L_0x00a1
            java.lang.Object r9 = r8.zze()
            goto L_0x00a2
        L_0x00a1:
            r9 = r10
        L_0x00a2:
            if (r9 != 0) goto L_0x00a8
            java.lang.Object r9 = r8.zza()
        L_0x00a8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbeu.zzd(android.content.Context, boolean):java.lang.Object");
    }
}
