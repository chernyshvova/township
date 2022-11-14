package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.integrity.IntegrityManager;
import com.playrix.gplay.billing.Base64;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggy {
    public static final long zza = ((long) zzC(byte[].class));
    public static final boolean zzb;
    public static final Unsafe zzc = zzt();
    public static final Class<?> zzd = zzgcl.zza();
    public static final boolean zze = zzu(Long.TYPE);
    public static final boolean zzf;
    public static final zzggx zzg;
    public static final boolean zzh;
    public static final boolean zzi;
    public static final long zzj;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0154  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            sun.misc.Unsafe r7 = zzt()
            zzc = r7
            java.lang.Class r7 = com.google.android.gms.internal.ads.zzgcl.zza()
            zzd = r7
            java.lang.Class r7 = java.lang.Long.TYPE
            boolean r7 = zzu(r7)
            zze = r7
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzu(r7)
            zzf = r7
            sun.misc.Unsafe r8 = zzc
            r9 = 0
            if (r8 != 0) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            boolean r10 = zze
            if (r10 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzggw r9 = new com.google.android.gms.internal.ads.zzggw
            r9.<init>(r8)
            goto L_0x0041
        L_0x003a:
            if (r7 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzggv r9 = new com.google.android.gms.internal.ads.zzggv
            r9.<init>(r8)
        L_0x0041:
            zzg = r9
            java.lang.String r7 = "getLong"
            java.lang.String r8 = "objectFieldOffset"
            r10 = 2
            r11 = 1
            r12 = 0
            if (r9 != 0) goto L_0x004e
        L_0x004c:
            r9 = 0
            goto L_0x0079
        L_0x004e:
            sun.misc.Unsafe r9 = r9.zza
            if (r9 != 0) goto L_0x0053
            goto L_0x004c
        L_0x0053:
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0074 }
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x0074 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r13[r12] = r14     // Catch:{ all -> 0x0074 }
            r9.getMethod(r8, r13)     // Catch:{ all -> 0x0074 }
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x0074 }
            r13[r12] = r6     // Catch:{ all -> 0x0074 }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x0074 }
            r13[r11] = r14     // Catch:{ all -> 0x0074 }
            r9.getMethod(r7, r13)     // Catch:{ all -> 0x0074 }
            java.lang.reflect.Field r9 = zzE()     // Catch:{ all -> 0x0074 }
            if (r9 != 0) goto L_0x0072
            goto L_0x004c
        L_0x0072:
            r9 = 1
            goto L_0x0079
        L_0x0074:
            r9 = move-exception
            zzv(r9)
            goto L_0x004c
        L_0x0079:
            zzh = r9
            com.google.android.gms.internal.ads.zzggx r9 = zzg
            if (r9 != 0) goto L_0x0082
        L_0x007f:
            r6 = 0
            goto L_0x0109
        L_0x0082:
            sun.misc.Unsafe r9 = r9.zza
            if (r9 != 0) goto L_0x0087
            goto L_0x007f
        L_0x0087:
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r13[r12] = r14     // Catch:{ all -> 0x0103 }
            r9.getMethod(r8, r13)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
            r8[r12] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "arrayBaseOffset"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
            r8[r12] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "arrayIndexScale"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r8 = new java.lang.Class[r10]     // Catch:{ all -> 0x0103 }
            r8[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r8[r11] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "getInt"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x0103 }
            r8 = 3
            java.lang.Class[] r13 = new java.lang.Class[r8]     // Catch:{ all -> 0x0103 }
            r13[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r13[r11] = r14     // Catch:{ all -> 0x0103 }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0103 }
            r13[r10] = r14     // Catch:{ all -> 0x0103 }
            java.lang.String r14 = "putInt"
            r9.getMethod(r14, r13)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x0103 }
            r13[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r13[r11] = r14     // Catch:{ all -> 0x0103 }
            r9.getMethod(r7, r13)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x0103 }
            r7[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r11] = r13     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r10] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "putLong"
            r9.getMethod(r13, r7)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x0103 }
            r7[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r11] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "getObject"
            r9.getMethod(r13, r7)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x0103 }
            r7[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r11] = r8     // Catch:{ all -> 0x0103 }
            r7[r10] = r6     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = "putObject"
            r9.getMethod(r6, r7)     // Catch:{ all -> 0x0103 }
            r6 = 1
            goto L_0x0109
        L_0x0103:
            r6 = move-exception
            zzv(r6)
            goto L_0x007f
        L_0x0109:
            zzi = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzC(r6)
            long r6 = (long) r6
            zza = r6
            zzC(r5)
            zzD(r5)
            zzC(r4)
            zzD(r4)
            zzC(r3)
            zzD(r3)
            zzC(r2)
            zzD(r2)
            zzC(r1)
            zzD(r1)
            zzC(r0)
            zzD(r0)
            java.lang.reflect.Field r0 = zzE()
            r1 = -1
            if (r0 == 0) goto L_0x0149
            com.google.android.gms.internal.ads.zzggx r3 = zzg
            if (r3 != 0) goto L_0x0145
            goto L_0x0149
        L_0x0145:
            long r1 = r3.zzj(r0)
        L_0x0149:
            zzj = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r11 = 0
        L_0x0155:
            zzb = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzggy.<clinit>():void");
    }

    public static int zzC(Class<?> cls) {
        if (zzi) {
            return zzg.zzk(cls);
        }
        return -1;
    }

    public static int zzD(Class<?> cls) {
        if (zzi) {
            return zzg.zzl(cls);
        }
        return -1;
    }

    public static Field zzE() {
        int i = zzgcl.zza;
        Field zzF = zzF(Buffer.class, "effectiveDirectAddress");
        if (zzF != null) {
            return zzF;
        }
        Field zzF2 = zzF(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzF2 == null || zzF2.getType() != Long.TYPE) {
            return null;
        }
        return zzF2;
    }

    public static Field zzF(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzG(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzm = zzg.zzm(obj, j2);
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzg.zzn(obj, j2, ((b & Base64.EQUALS_SIGN_ENC) << i) | (zzm & ((255 << i) ^ -1)));
    }

    public static void zzH(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzm = zzg.zzm(obj, j2);
        int i = (((int) j) & 3) << 3;
        zzg.zzn(obj, j2, ((b & Base64.EQUALS_SIGN_ENC) << i) | (zzm & ((255 << i) ^ -1)));
    }

    public static boolean zza() {
        return zzi;
    }

    public static boolean zzb() {
        return zzh;
    }

    public static <T> T zzc(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int zzd(Object obj, long j) {
        return zzg.zzm(obj, j);
    }

    public static void zze(Object obj, long j, int i) {
        zzg.zzn(obj, j, i);
    }

    public static long zzf(Object obj, long j) {
        return zzg.zzo(obj, j);
    }

    public static void zzg(Object obj, long j, long j2) {
        zzg.zzp(obj, j, j2);
    }

    public static boolean zzh(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    public static void zzi(Object obj, long j, boolean z) {
        zzg.zzc(obj, j, z);
    }

    public static float zzj(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    public static void zzk(Object obj, long j, float f) {
        zzg.zze(obj, j, f);
    }

    public static double zzl(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    public static void zzm(Object obj, long j, double d) {
        zzg.zzg(obj, j, d);
    }

    public static Object zzn(Object obj, long j) {
        return zzg.zzq(obj, j);
    }

    public static void zzo(Object obj, long j, Object obj2) {
        zzg.zzr(obj, j, obj2);
    }

    public static void zzp(byte[] bArr, long j, byte b) {
        zzg.zza(bArr, zza + j, b);
    }

    public static void zzq(long j, byte[] bArr, long j2, long j3) {
        zzg.zzi(j, bArr, j2, j3);
    }

    public static byte zzr(long j) {
        return zzg.zzh(j);
    }

    public static long zzs(ByteBuffer byteBuffer) {
        return zzg.zzo(byteBuffer, zzj);
    }

    public static Unsafe zzt() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzggu());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzu(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzgcl.zza;
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ void zzv(Throwable th) {
        Logger logger = Logger.getLogger(zzggy.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 71), "platform method missing - proto runtime falling back to safer methods: ", valueOf));
    }

    public static /* synthetic */ boolean zzy(Object obj, long j) {
        return ((byte) ((zzg.zzm(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean zzz(Object obj, long j) {
        return ((byte) ((zzg.zzm(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }
}
