package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbk extends ThreadLocal<ByteBuffer> {
    public zzbk(zzbl zzbl) {
    }

    public final /* bridge */ /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
