package com.google.android.gms.internal.drive;

public final class zzlh implements zzlp {
    public zzlp[] zztt;

    public zzlh(zzlp... zzlpArr) {
        this.zztt = zzlpArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzlp zzb : this.zztt) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzlo zzc(Class<?> cls) {
        for (zzlp zzlp : this.zztt) {
            if (zzlp.zzb(cls)) {
                return zzlp.zzc(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
