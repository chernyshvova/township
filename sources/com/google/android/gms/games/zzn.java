package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class zzn extends DataBufferRef {
    public zzn(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int zzp(String str, int i) {
        return (!hasColumn(str) || hasNull(str)) ? i : getInteger(str);
    }

    public final String zzq(String str, String str2) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getString(str);
    }
}
