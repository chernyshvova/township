package com.google.android.gms.internal.drive;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class zznd {
    public static final Logger logger = Logger.getLogger(zznd.class.getName());
    public static final Class<?> zzni = zzix.zzbs();
    public static final boolean zzog = zzfg();
    public static final Unsafe zzuc = zzff();
    public static final boolean zzvy = zzk(Long.TYPE);
    public static final boolean zzvz = zzk(Integer.TYPE);
    public static final zzd zzwa;
    public static final boolean zzwb = zzfh();
    public static final long zzwc = ((long) zzi(byte[].class));
    public static final long zzwd;
    public static final long zzwe;
    public static final long zzwf;
    public static final long zzwg;
    public static final long zzwh;
    public static final long zzwi;
    public static final long zzwj;
    public static final long zzwk;
    public static final long zzwl;
    public static final long zzwm;
    public static final long zzwn;
    public static final long zzwo;
    public static final long zzwp;
    public static final int zzwq = ((int) (zzwc & 7));
    public static final boolean zzwr = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzws.putBoolean(obj, j, z);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzws.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzws.getBoolean(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return this.zzws.getFloat(obj, j);
        }

        public final double zzn(Object obj, long j) {
            return this.zzws.getDouble(obj, j);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzws.getByte(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzws.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzws.putDouble(obj, j, d);
        }
    }

    public static abstract class zzd {
        public Unsafe zzws;

        public zzd(Unsafe unsafe) {
            this.zzws = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zzws.putInt(obj, j, i);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public final int zzj(Object obj, long j) {
            return this.zzws.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzws.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final void zza(Object obj, long j, long j2) {
            this.zzws.putLong(obj, j, j2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d0, code lost:
        r1 = zzwa;
     */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.drive.zznd> r6 = com.google.android.gms.internal.drive.zznd.class
            java.lang.String r6 = r6.getName()
            java.util.logging.Logger r6 = java.util.logging.Logger.getLogger(r6)
            logger = r6
            sun.misc.Unsafe r6 = zzff()
            zzuc = r6
            java.lang.Class r6 = com.google.android.gms.internal.drive.zzix.zzbs()
            zzni = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzk(r6)
            zzvy = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            boolean r6 = zzk(r6)
            zzvz = r6
            sun.misc.Unsafe r6 = zzuc
            r7 = 0
            if (r6 != 0) goto L_0x003a
            goto L_0x005f
        L_0x003a:
            boolean r6 = com.google.android.gms.internal.drive.zzix.zzbr()
            if (r6 == 0) goto L_0x0058
            boolean r6 = zzvy
            if (r6 == 0) goto L_0x004c
            com.google.android.gms.internal.drive.zznd$zzb r7 = new com.google.android.gms.internal.drive.zznd$zzb
            sun.misc.Unsafe r6 = zzuc
            r7.<init>(r6)
            goto L_0x005f
        L_0x004c:
            boolean r6 = zzvz
            if (r6 == 0) goto L_0x005f
            com.google.android.gms.internal.drive.zznd$zza r7 = new com.google.android.gms.internal.drive.zznd$zza
            sun.misc.Unsafe r6 = zzuc
            r7.<init>(r6)
            goto L_0x005f
        L_0x0058:
            com.google.android.gms.internal.drive.zznd$zzc r7 = new com.google.android.gms.internal.drive.zznd$zzc
            sun.misc.Unsafe r6 = zzuc
            r7.<init>(r6)
        L_0x005f:
            zzwa = r7
            boolean r6 = zzfh()
            zzwb = r6
            boolean r6 = zzfg()
            zzog = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzi(r6)
            long r6 = (long) r6
            zzwc = r6
            int r6 = zzi(r5)
            long r6 = (long) r6
            zzwd = r6
            int r5 = zzj(r5)
            long r5 = (long) r5
            zzwe = r5
            int r5 = zzi(r4)
            long r5 = (long) r5
            zzwf = r5
            int r4 = zzj(r4)
            long r4 = (long) r4
            zzwg = r4
            int r4 = zzi(r3)
            long r4 = (long) r4
            zzwh = r4
            int r3 = zzj(r3)
            long r3 = (long) r3
            zzwi = r3
            int r3 = zzi(r2)
            long r3 = (long) r3
            zzwj = r3
            int r2 = zzj(r2)
            long r2 = (long) r2
            zzwk = r2
            int r2 = zzi(r1)
            long r2 = (long) r2
            zzwl = r2
            int r1 = zzj(r1)
            long r1 = (long) r1
            zzwm = r1
            int r1 = zzi(r0)
            long r1 = (long) r1
            zzwn = r1
            int r0 = zzj(r0)
            long r0 = (long) r0
            zzwo = r0
            java.lang.reflect.Field r0 = zzfi()
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.internal.drive.zznd$zzd r1 = zzwa
            if (r1 != 0) goto L_0x00d5
            goto L_0x00dc
        L_0x00d5:
            sun.misc.Unsafe r1 = r1.zzws
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00de
        L_0x00dc:
            r0 = -1
        L_0x00de:
            zzwp = r0
            long r0 = zzwc
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzwq = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f2
            r0 = 1
            goto L_0x00f3
        L_0x00f2:
            r0 = 0
        L_0x00f3:
            zzwr = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zznd.<clinit>():void");
    }

    public static void zza(Object obj, long j, int i) {
        zzwa.zza(obj, j, i);
    }

    public static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    public static boolean zzfd() {
        return zzog;
    }

    public static boolean zzfe() {
        return zzwb;
    }

    public static Unsafe zzff() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzne());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzfg() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzuc;
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
            if (zzix.zzbr()) {
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
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    public static boolean zzfh() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            if (zzfi() == null) {
                return false;
            }
            if (zzix.zzbr()) {
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
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    public static Field zzfi() {
        Field zzb2;
        if (zzix.zzbr() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    public static <T> T zzh(Class<T> cls) {
        try {
            return zzuc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int zzi(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int zzj(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayIndexScale(cls);
        }
        return -1;
    }

    public static long zzk(Object obj, long j) {
        return zzwa.zzk(obj, j);
    }

    public static boolean zzl(Object obj, long j) {
        return zzwa.zzl(obj, j);
    }

    public static float zzm(Object obj, long j) {
        return zzwa.zzm(obj, j);
    }

    public static double zzn(Object obj, long j) {
        return zzwa.zzn(obj, j);
    }

    public static Object zzo(Object obj, long j) {
        return zzwa.zzws.getObject(obj, j);
    }

    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    public static void zza(Object obj, long j, long j2) {
        zzwa.zza(obj, j, j2);
    }

    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    public static boolean zzk(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzix.zzbr()) {
            return false;
        }
        try {
            Class<?> cls3 = zzni;
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

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j, z);
            } else {
                zznd.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zznd.zzwr) {
                zznd.zza(obj, j, b);
            } else {
                zznd.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzr(obj, j);
            }
            return zznd.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzp(obj, j);
            }
            return zznd.zzq(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j, z);
            } else {
                zznd.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zznd.zzwr) {
                zznd.zza(obj, j, b);
            } else {
                zznd.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzr(obj, j);
            }
            return zznd.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            if (zznd.zzwr) {
                return zznd.zzp(obj, j);
            }
            return zznd.zzq(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static void zza(Object obj, long j, boolean z) {
        zzwa.zza(obj, j, z);
    }

    public static int zzj(Object obj, long j) {
        return zzwa.zzj(obj, j);
    }

    public static void zza(Object obj, long j, float f) {
        zzwa.zza(obj, j, f);
    }

    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    public static void zza(Object obj, long j, double d) {
        zzwa.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzwa.zzws.putObject(obj, j, obj2);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzwa.zzx(bArr, zzwc + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzwa.zze(bArr, zzwc + j, b);
    }

    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }
}
