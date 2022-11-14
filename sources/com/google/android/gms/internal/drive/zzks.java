package com.google.android.gms.internal.drive;

import androidx.cardview.widget.RoundRectDrawableWithShadow;

public enum zzks {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(RoundRectDrawableWithShadow.COS_45)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzjc.class, zzjc.class, zzjc.zznq),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    public final Class<?> zztb;
    public final Class<?> zztc;
    public final Object zztd;

    /* access modifiers changed from: public */
    zzks(Class<?> cls, Class<?> cls2, Object obj) {
        this.zztb = cls;
        this.zztc = cls2;
        this.zztd = obj;
    }

    public final Class<?> zzdo() {
        return this.zztc;
    }
}
