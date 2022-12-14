package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zziw implements zzka {
    public static final zzjg zzb = new zziz();
    public final zzjg zza;

    public zziw() {
        this(new zziy(zzhz.zza(), zza()));
    }

    public final <T> zzkb<T> zza(Class<T> cls) {
        Class<zzhy> cls2 = zzhy.class;
        zzkd.zza((Class<?>) cls);
        zzjh zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzjp.zza(zzkd.zzc(), zzho.zza(), zzb2.zzc());
            }
            return zzjp.zza(zzkd.zza(), zzho.zzb(), zzb2.zzc());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzjn.zza(cls, zzb2, zzjt.zzb(), zzit.zzb(), zzkd.zzc(), zzho.zza(), zzje.zzb());
            }
            return zzjn.zza(cls, zzb2, zzjt.zzb(), zzit.zzb(), zzkd.zzc(), (zzhn<?>) null, zzje.zzb());
        } else if (zza(zzb2)) {
            return zzjn.zza(cls, zzb2, zzjt.zza(), zzit.zza(), zzkd.zza(), zzho.zzb(), zzje.zza());
        } else {
            return zzjn.zza(cls, zzb2, zzjt.zza(), zzit.zza(), zzkd.zzb(), (zzhn<?>) null, zzje.zza());
        }
    }

    public zziw(zzjg zzjg) {
        this.zza = (zzjg) zzia.zza(zzjg, "messageInfoFactory");
    }

    public static boolean zza(zzjh zzjh) {
        return zzjh.zza() == zzju.zza;
    }

    public static zzjg zza() {
        try {
            return (zzjg) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
