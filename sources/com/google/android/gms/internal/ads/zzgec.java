package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdy;
import com.google.android.gms.internal.ads.zzgec;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgec<MessageType extends zzgec<MessageType, BuilderType>, BuilderType extends zzgdy<MessageType, BuilderType>> extends zzgcj<MessageType, BuilderType> {
    public static final Map<Object, zzgec<?, ?>> zzb = new ConcurrentHashMap();
    public zzggp zzc = zzggp.zza();
    public int zzd = -1;

    public static <T extends zzgec<T, ?>> T zza(T t) throws zzgeo {
        if (t == null || t.zzat()) {
            return t;
        }
        zzgeo zzgeo = new zzgeo(new zzggn(t).getMessage());
        zzgeo.zza(t);
        throw zzgeo;
    }

    public static Object zzaA(Method method, Object obj, Object... objArr) {
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

    public static zzgeh zzaB() {
        return zzged.zzd();
    }

    public static zzgeh zzaC(zzgeh zzgeh) {
        int size = zzgeh.size();
        return zzgeh.zzf(size == 0 ? 10 : size + size);
    }

    public static zzgek zzaD() {
        return zzgez.zzd();
    }

    public static <E> zzgel<E> zzaE() {
        return zzgft.zzd();
    }

    public static <E> zzgel<E> zzaF(zzgel<E> zzgel) {
        int size = zzgel.size();
        return zzgel.zze(size == 0 ? 10 : size + size);
    }

    public static <T extends zzgec<T, ?>> T zzaG(T t, byte[] bArr, int i, int i2, zzgdo zzgdo) throws zzgeo {
        T t2 = (zzgec) t.zzb(4, (Object) null, (Object) null);
        try {
            zzgga<?> zzb2 = zzgfs.zza().zzb(t2.getClass());
            zzb2.zzi(t2, bArr, 0, i2, new zzgcm(zzgdo));
            zzb2.zzj(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (zzgeo e) {
            e = e;
            if (e.zzc()) {
                e = new zzgeo((IOException) e);
            }
            e.zza(t2);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzgeo) {
                throw ((zzgeo) e2.getCause());
            }
            zzgeo zzgeo = new zzgeo(e2);
            zzgeo.zza(t2);
            throw zzgeo;
        } catch (IndexOutOfBoundsException unused) {
            zzgeo zzd2 = zzgeo.zzd();
            zzd2.zza(t2);
            throw zzd2;
        }
    }

    public static <T extends zzgec<T, ?>> T zzaH(T t, zzgcz zzgcz) throws zzgeo {
        T t2;
        zzgdo zza = zzgdo.zza();
        try {
            zzgde zzp = zzgcz.zzp();
            t2 = (zzgec) t.zzb(4, (Object) null, (Object) null);
            zzgga<?> zzb2 = zzgfs.zza().zzb(t2.getClass());
            zzb2.zzf(t2, zzgdf.zza(zzp), zza);
            zzb2.zzj(t2);
            zzp.zzb(0);
            zza(t2);
            zza(t2);
            return t2;
        } catch (zzgeo e) {
            e = e;
            if (e.zzc()) {
                e = new zzgeo((IOException) e);
            }
            e.zza(t2);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzgeo) {
                throw ((zzgeo) e2.getCause());
            }
            zzgeo zzgeo = new zzgeo(e2);
            zzgeo.zza(t2);
            throw zzgeo;
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzgeo) {
                throw ((zzgeo) e3.getCause());
            }
            throw e3;
        } catch (zzgeo e4) {
            e4.zza(t2);
            throw e4;
        } catch (zzgeo e5) {
            throw e5;
        }
    }

    public static <T extends zzgec<T, ?>> T zzaI(T t, zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        T t2;
        try {
            zzgde zzp = zzgcz.zzp();
            t2 = (zzgec) t.zzb(4, (Object) null, (Object) null);
            zzgga<?> zzb2 = zzgfs.zza().zzb(t2.getClass());
            zzb2.zzf(t2, zzgdf.zza(zzp), zzgdo);
            zzb2.zzj(t2);
            zzp.zzb(0);
            zza(t2);
            return t2;
        } catch (zzgeo e) {
            e = e;
            if (e.zzc()) {
                e = new zzgeo((IOException) e);
            }
            e.zza(t2);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzgeo) {
                throw ((zzgeo) e2.getCause());
            }
            zzgeo zzgeo = new zzgeo(e2);
            zzgeo.zza(t2);
            throw zzgeo;
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzgeo) {
                throw ((zzgeo) e3.getCause());
            }
            throw e3;
        } catch (zzgeo e4) {
            e4.zza(t2);
            throw e4;
        } catch (zzgeo e5) {
            throw e5;
        }
    }

    public static <T extends zzgec<T, ?>> T zzaJ(T t, byte[] bArr) throws zzgeo {
        T zzaG = zzaG(t, bArr, 0, bArr.length, zzgdo.zza());
        zza(zzaG);
        return zzaG;
    }

    public static <T extends zzgec<T, ?>> T zzaK(T t, byte[] bArr, zzgdo zzgdo) throws zzgeo {
        T zzaG = zzaG(t, bArr, 0, bArr.length, zzgdo);
        zza(zzaG);
        return zzaG;
    }

    public static <T extends zzgec> T zzax(Class<T> cls) {
        T t = (zzgec) zzb.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzgec) zzb.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzgec) ((zzgec) zzggy.zzc(cls)).zzb(6, (Object) null, (Object) null);
            if (t != null) {
                zzb.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends zzgec> void zzay(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    public static Object zzaz(zzgfk zzgfk, String str, Object[] objArr) {
        return new zzgfu(zzgfk, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgfs.zza().zzb(getClass()).zzb(this, (zzgec) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzc2 = zzgfs.zza().zzb(getClass()).zzc(this);
        this.zza = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zzgfm.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zzgfj zzaL() {
        zzgdy zzgdy = (zzgdy) zzb(5, (Object) null, (Object) null);
        zzgdy.zzai(this);
        return zzgdy;
    }

    public final /* bridge */ /* synthetic */ zzgfj zzaM() {
        return (zzgdy) zzb(5, (Object) null, (Object) null);
    }

    public final int zzap() {
        return this.zzd;
    }

    public final void zzaq(int i) {
        this.zzd = i;
    }

    public final <MessageType extends zzgec<MessageType, BuilderType>, BuilderType extends zzgdy<MessageType, BuilderType>> BuilderType zzas() {
        return (zzgdy) zzb(5, (Object) null, (Object) null);
    }

    public final boolean zzat() {
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgfs.zza().zzb(getClass()).zzk(this);
        zzb(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }

    public final BuilderType zzau() {
        BuilderType buildertype = (zzgdy) zzb(5, (Object) null, (Object) null);
        buildertype.zzai(this);
        return buildertype;
    }

    public final void zzav(zzgdj zzgdj) throws IOException {
        zzgfs.zza().zzb(getClass()).zzn(this, zzgdk.zza(zzgdj));
    }

    public final int zzaw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zze = zzgfs.zza().zzb(getClass()).zze(this);
        this.zzd = zze;
        return zze;
    }

    public abstract Object zzb(int i, Object obj, Object obj2);

    public final /* bridge */ /* synthetic */ zzgfk zzbe() {
        return (zzgec) zzb(6, (Object) null, (Object) null);
    }
}
