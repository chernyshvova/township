package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfc implements zzggb {
    public static final zzgfi zzb = new zzgfa();
    public final zzgfi zza;

    public zzgfc() {
        zzgfi zzgfi;
        zzgfi[] zzgfiArr = new zzgfi[2];
        zzgfiArr[0] = zzgdx.zza();
        try {
            zzgfi = (zzgfi) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzgfi = zzb;
        }
        zzgfiArr[1] = zzgfi;
        zzgfb zzgfb = new zzgfb(zzgfiArr);
        zzgem.zzb(zzgfb, "messageInfoFactory");
        this.zza = zzgfb;
    }

    public static boolean zzb(zzgfh zzgfh) {
        return zzgfh.zzc() == 1;
    }

    public final <T> zzgga<T> zza(Class<T> cls) {
        Class<zzgec> cls2 = zzgec.class;
        zzggc.zza(cls);
        zzgfh zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzgfo.zzg(zzggc.zzC(), zzgdr.zza(), zzc.zzb());
            }
            return zzgfo.zzg(zzggc.zzA(), zzgdr.zzb(), zzc.zzb());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzgfn.zzl(cls, zzc, zzgfq.zzb(), zzgey.zze(), zzggc.zzC(), zzgdr.zza(), zzgfg.zzb());
            }
            return zzgfn.zzl(cls, zzc, zzgfq.zzb(), zzgey.zze(), zzggc.zzC(), (zzgdp<?>) null, zzgfg.zzb());
        } else if (zzb(zzc)) {
            return zzgfn.zzl(cls, zzc, zzgfq.zza(), zzgey.zzd(), zzggc.zzA(), zzgdr.zzb(), zzgfg.zza());
        } else {
            return zzgfn.zzl(cls, zzc, zzgfq.zza(), zzgey.zzd(), zzggc.zzB(), (zzgdp<?>) null, zzgfg.zza());
        }
    }
}
