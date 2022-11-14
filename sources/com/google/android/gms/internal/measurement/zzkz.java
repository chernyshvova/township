package com.google.android.gms.internal.measurement;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkz {
    public static final boolean zza = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    public static final Unsafe zzb = zzc();
    public static final Class<?> zzc = zzgm.zzb();
    public static final boolean zzd = zzd(Long.TYPE);
    public static final boolean zze = zzd(Integer.TYPE);
    public static final zzc zzf;
    public static final boolean zzg = zze();
    public static final boolean zzh = zzd();
    public static final long zzi = ((long) zzb(byte[].class));
    public static final long zzj;
    public static final long zzk;
    public static final long zzl;
    public static final long zzm;
    public static final long zzn;
    public static final long zzo;
    public static final long zzp;
    public static final long zzq;
    public static final long zzr;
    public static final long zzs;
    public static final long zzt;
    public static final long zzu;
    public static final long zzv;
    public static final int zzw = ((int) (zzi & 7));

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class zzc {
        public Unsafe zza;

        public zzc(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class zzd extends zzc {
        public zzd(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, byte b) {
            this.zza.putByte(obj, j, b);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        public final void zza(Object obj, long j, float f) {
            this.zza.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, double d) {
            this.zza.putDouble(obj, j, d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00c4, code lost:
        r1 = zzf;
     */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            sun.misc.Unsafe r6 = zzc()
            zzb = r6
            java.lang.Class r6 = com.google.android.gms.internal.measurement.zzgm.zzb()
            zzc = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzd(r6)
            zzd = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            boolean r6 = zzd(r6)
            zze = r6
            sun.misc.Unsafe r6 = zzb
            r7 = 0
            if (r6 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r6 = com.google.android.gms.internal.measurement.zzgm.zza()
            if (r6 == 0) goto L_0x004c
            boolean r6 = zzd
            if (r6 == 0) goto L_0x0040
            com.google.android.gms.internal.measurement.zzkz$zza r7 = new com.google.android.gms.internal.measurement.zzkz$zza
            sun.misc.Unsafe r6 = zzb
            r7.<init>(r6)
            goto L_0x0053
        L_0x0040:
            boolean r6 = zze
            if (r6 == 0) goto L_0x0053
            com.google.android.gms.internal.measurement.zzkz$zzb r7 = new com.google.android.gms.internal.measurement.zzkz$zzb
            sun.misc.Unsafe r6 = zzb
            r7.<init>(r6)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.measurement.zzkz$zzd r7 = new com.google.android.gms.internal.measurement.zzkz$zzd
            sun.misc.Unsafe r6 = zzb
            r7.<init>(r6)
        L_0x0053:
            zzf = r7
            boolean r6 = zze()
            zzg = r6
            boolean r6 = zzd()
            zzh = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzb(r6)
            long r6 = (long) r6
            zzi = r6
            int r6 = zzb(r5)
            long r6 = (long) r6
            zzj = r6
            int r5 = zzc(r5)
            long r5 = (long) r5
            zzk = r5
            int r5 = zzb(r4)
            long r5 = (long) r5
            zzl = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            zzm = r4
            int r4 = zzb(r3)
            long r4 = (long) r4
            zzn = r4
            int r3 = zzc(r3)
            long r3 = (long) r3
            zzo = r3
            int r3 = zzb(r2)
            long r3 = (long) r3
            zzp = r3
            int r2 = zzc(r2)
            long r2 = (long) r2
            zzq = r2
            int r2 = zzb(r1)
            long r2 = (long) r2
            zzr = r2
            int r1 = zzc(r1)
            long r1 = (long) r1
            zzs = r1
            int r1 = zzb(r0)
            long r1 = (long) r1
            zzt = r1
            int r0 = zzc(r0)
            long r0 = (long) r0
            zzu = r0
            java.lang.reflect.Field r0 = zzf()
            if (r0 == 0) goto L_0x00d0
            com.google.android.gms.internal.measurement.zzkz$zzc r1 = zzf
            if (r1 != 0) goto L_0x00c9
            goto L_0x00d0
        L_0x00c9:
            sun.misc.Unsafe r1 = r1.zza
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00d2
        L_0x00d0:
            r0 = -1
        L_0x00d2:
            zzv = r0
            long r0 = zzi
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzw = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00e6
            r0 = 1
            goto L_0x00e7
        L_0x00e6:
            r0 = 0
        L_0x00e7:
            zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkz.<clinit>():void");
    }

    public static boolean zza() {
        return zzh;
    }

    public static boolean zzb() {
        return zzg;
    }

    public static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    public static float zzd(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    public static double zze(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    public static Object zzf(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }

    public static <T> T zza(Class<T> cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static boolean zzd() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls2.getMethod("getInt", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putInt", new Class[]{cls, Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putLong", new Class[]{cls, Long.TYPE, Long.TYPE});
            cls2.getMethod("getObject", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putObject", new Class[]{cls, Long.TYPE, cls});
            if (zzgm.zza()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putByte", new Class[]{cls, Long.TYPE, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putBoolean", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putFloat", new Class[]{cls, Long.TYPE, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putDouble", new Class[]{cls, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzkz.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    public static boolean zze() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            if (zzf() == null) {
                return false;
            }
            if (zzgm.zza()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{Long.TYPE});
            cls2.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{Long.TYPE});
            cls2.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{Long.TYPE});
            cls2.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls2.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls2.getMethod("copyMemory", new Class[]{cls, Long.TYPE, cls, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzkz.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class zza extends zzc {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzk(obj, j);
            }
            return zzkz.zzl(obj, j);
        }

        public final boolean zzb(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzm(obj, j);
            }
            return zzkz.zzn(obj, j);
        }

        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        public final void zza(Object obj, long j, byte b) {
            if (zzkz.zza) {
                zzkz.zzc(obj, j, b);
            } else {
                zzkz.zzd(obj, j, b);
            }
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzkz.zza) {
                zzkz.zzd(obj, j, z);
            } else {
                zzkz.zze(obj, j, z);
            }
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class zzb extends zzc {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzk(obj, j);
            }
            return zzkz.zzl(obj, j);
        }

        public final boolean zzb(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzm(obj, j);
            }
            return zzkz.zzn(obj, j);
        }

        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        public final void zza(Object obj, long j, byte b) {
            if (zzkz.zza) {
                zzkz.zzc(obj, j, b);
            } else {
                zzkz.zzd(obj, j, b);
            }
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzkz.zza) {
                zzkz.zzd(obj, j, z);
            } else {
                zzkz.zze(obj, j, z);
            }
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static boolean zzc(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static Field zzf() {
        Field zza2;
        if (zzgm.zza() && (zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return zza2;
        }
        Field zza3 = zza((Class<?>) Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    public static int zza(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    public static long zzb(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    public static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzky());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zza(Object obj, long j, int i) {
        zzf.zza(obj, j, i);
    }

    public static void zza(Object obj, long j, long j2) {
        zzf.zza(obj, j, j2);
    }

    public static void zzc(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ -1)));
    }

    public static void zza(Object obj, long j, boolean z) {
        zzf.zza(obj, j, z);
    }

    public static void zza(Object obj, long j, float f) {
        zzf.zza(obj, j, f);
    }

    public static void zza(Object obj, long j, double d) {
        zzf.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzf.zza(bArr, zzi + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzf.zza((Object) bArr, zzi + j, b);
    }

    public static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : 0);
    }

    public static boolean zzd(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzgm.zza()) {
            return false;
        }
        try {
            Class<?> cls3 = zzc;
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

    public static void zzd(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ -1)));
    }

    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : 0);
    }
}
