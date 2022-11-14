package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

public final class zzlf implements zzmg {
    public static final zzlp zzts = new zzlg();
    public final zzlp zztr;

    public zzlf() {
        this(new zzlh(zzkj.zzcv(), zzdv()));
    }

    public static boolean zza(zzlo zzlo) {
        return zzlo.zzec() == zzkk.zze.zzsf;
    }

    public static zzlp zzdv() {
        try {
            return (zzlp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzts;
        }
    }

    public final <T> zzmf<T> zze(Class<T> cls) {
        Class<zzkk> cls2 = zzkk.class;
        zzmh.zzg((Class<?>) cls);
        zzlo zzc = this.zztr.zzc(cls);
        if (zzc.zzed()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzlw.zza(zzmh.zzeo(), zzka.zzcl(), zzc.zzee());
            }
            return zzlw.zza(zzmh.zzem(), zzka.zzcm(), zzc.zzee());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzlu.zza(cls, zzc, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), zzka.zzcl(), zzln.zzea());
            }
            return zzlu.zza(cls, zzc, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), (zzjy<?>) null, zzln.zzea());
        } else if (zza(zzc)) {
            return zzlu.zza(cls, zzc, zzma.zzeg(), zzla.zzdt(), zzmh.zzem(), zzka.zzcm(), zzln.zzdz());
        } else {
            return zzlu.zza(cls, zzc, zzma.zzeg(), zzla.zzdt(), zzmh.zzen(), (zzjy<?>) null, zzln.zzdz());
        }
    }

    public zzlf(zzlp zzlp) {
        this.zztr = (zzlp) zzkm.zza(zzlp, "messageInfoFactory");
    }
}
