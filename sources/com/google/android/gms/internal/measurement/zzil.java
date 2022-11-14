package com.google.android.gms.internal.measurement;

import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum zzil {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(RoundRectDrawableWithShadow.COS_45)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzgp.class, zzgp.class, zzgp.zza),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    public final Class<?> zzk;
    public final Class<?> zzl;
    public final Object zzm;

    /* access modifiers changed from: public */
    zzil(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
