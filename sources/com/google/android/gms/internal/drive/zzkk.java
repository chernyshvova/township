package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import com.google.android.gms.internal.drive.zzkk.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzkk<MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzit<MessageType, BuilderType> {
    public static Map<Object, zzkk<?, ?>> zzrs = new ConcurrentHashMap();
    public zzmy zzrq = zzmy.zzfa();
    public int zzrr = -1;

    public static class zzb<T extends zzkk<T, ?>> extends zziv<T> {
        public final T zzrt;

        public zzb(T t) {
            this.zzrt = t;
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzkk<MessageType, BuilderType> implements zzls {
        public zzkb<Object> zzrw = zzkb.zzcn();

        public final zzkb<Object> zzdg() {
            if (this.zzrw.isImmutable()) {
                this.zzrw = (zzkb) this.zzrw.clone();
            }
            return this.zzrw;
        }
    }

    public static class zzd<ContainingType extends zzlq, Type> extends zzjv<ContainingType, Type> {
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzrx = 1;
        public static final int zzry = 2;
        public static final int zzrz = 3;
        public static final int zzsa = 4;
        public static final int zzsb = 5;
        public static final int zzsc = 6;
        public static final int zzsd = 7;
        public static final /* synthetic */ int[] zzse = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzsf = 1;
        public static final int zzsg = 2;
        public static final /* synthetic */ int[] zzsh = {1, 2};
        public static final int zzsi = 1;
        public static final int zzsj = 2;
        public static final /* synthetic */ int[] zzsk = {1, 2};

        public static int[] zzdh() {
            return (int[]) zzse.clone();
        }
    }

    public static <T extends zzkk<?, ?>> void zza(Class<T> cls, T t) {
        zzrs.put(cls, t);
    }

    public static <T extends zzkk<?, ?>> T zzd(Class<T> cls) {
        T t = (zzkk) zzrs.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzkk) zzrs.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzkk) ((zzkk) zznd.zzh(cls)).zza(zze.zzsc, (Object) null, (Object) null);
            if (t != null) {
                zzrs.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzkk) zza(zze.zzsc, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzmd.zzej().zzq(this).equals(this, (zzkk) obj);
    }

    public int hashCode() {
        int i = this.zzne;
        if (i != 0) {
            return i;
        }
        int hashCode = zzmd.zzej().zzq(this).hashCode(this);
        this.zzne = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzlt.zza(this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zzb(zzjr zzjr) throws IOException {
        zzmd.zzej().zzf(getClass()).zza(this, zzjt.zza(zzjr));
    }

    public final int zzbm() {
        return this.zzrr;
    }

    public final void zzbp() {
        zzmd.zzej().zzq(this).zzd(this);
    }

    public final <MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzcw() {
        return (zza) zza(zze.zzsb, (Object) null, (Object) null);
    }

    public final int zzcx() {
        if (this.zzrr == -1) {
            this.zzrr = zzmd.zzej().zzq(this).zzn(this);
        }
        return this.zzrr;
    }

    public final /* synthetic */ zzlr zzcy() {
        zza zza2 = (zza) zza(zze.zzsb, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzlr zzcz() {
        return (zza) zza(zze.zzsb, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzlq zzda() {
        return (zzkk) zza(zze.zzsc, (Object) null, (Object) null);
    }

    public final void zzo(int i) {
        this.zzrr = i;
    }

    public static abstract class zza<MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zziu<MessageType, BuilderType> {
        public final MessageType zzrt;
        public MessageType zzru;
        public boolean zzrv = false;

        public zza(MessageType messagetype) {
            this.zzrt = messagetype;
            this.zzru = (zzkk) messagetype.zza(zze.zzsa, (Object) null, (Object) null);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzrt.zza(zze.zzsb, (Object) null, (Object) null);
            zza.zza((zzkk) zzde());
            return zza;
        }

        public final boolean isInitialized() {
            return zzkk.zza(this.zzru, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzdb();
            zza(this.zzru, messagetype);
            return this;
        }

        public final /* synthetic */ zziu zzbn() {
            return (zza) clone();
        }

        public final /* synthetic */ zzlq zzda() {
            return this.zzrt;
        }

        public final void zzdb() {
            if (this.zzrv) {
                MessageType messagetype = (zzkk) this.zzru.zza(zze.zzsa, (Object) null, (Object) null);
                zza(messagetype, this.zzru);
                this.zzru = messagetype;
                this.zzrv = false;
            }
        }

        /* renamed from: zzdc */
        public MessageType zzde() {
            if (this.zzrv) {
                return this.zzru;
            }
            this.zzru.zzbp();
            this.zzrv = true;
            return this.zzru;
        }

        /* renamed from: zzdd */
        public final MessageType zzdf() {
            MessageType messagetype = (zzkk) zzde();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzmw(messagetype);
        }

        public static void zza(MessageType messagetype, MessageType messagetype2) {
            zzmd.zzej().zzq(messagetype).zzc(messagetype, messagetype2);
        }
    }

    public static Object zza(zzlq zzlq, String str, Object[] objArr) {
        return new zzme(zzlq, str, objArr);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static final <T extends zzkk<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzrx, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzp = zzmd.zzej().zzq(t).zzp(t);
        if (z) {
            t.zza(zze.zzry, (Object) zzp ? t : null, (Object) null);
        }
        return zzp;
    }

    public static <T extends zzkk<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzjx zzjx) throws zzkq {
        T t2 = (zzkk) t.zza(zze.zzsa, (Object) null, (Object) null);
        try {
            zzmd.zzej().zzq(t2).zza(t2, bArr, 0, i2, new zziz(zzjx));
            t2.zzbp();
            if (t2.zzne == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzkq) {
                throw ((zzkq) e.getCause());
            }
            throw new zzkq(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkq.zzdi().zzg(t2);
        }
    }

    public static <T extends zzkk<T, ?>> T zza(T t, byte[] bArr, zzjx zzjx) throws zzkq {
        T zza2 = zza(t, bArr, 0, bArr.length, zzjx);
        if (zza2 == null || zza2.isInitialized()) {
            return zza2;
        }
        throw new zzkq(new zzmw(zza2).getMessage()).zzg(zza2);
    }
}
