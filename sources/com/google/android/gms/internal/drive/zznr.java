package com.google.android.gms.internal.drive;

import androidx.cardview.widget.RoundRectDrawableWithShadow;

public enum zznr {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(RoundRectDrawableWithShadow.COS_45)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzjc.zznq),
    ENUM((String) null),
    MESSAGE((String) null);
    
    public final Object zztd;

    /* access modifiers changed from: public */
    zznr(Object obj) {
        this.zztd = obj;
    }
}
