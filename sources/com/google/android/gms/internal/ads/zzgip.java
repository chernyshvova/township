package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgip extends zzgin implements zzbp {
    public int zza;

    public zzgip(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzbo.zzc(byteBuffer.get());
        zzbo.zzb(byteBuffer);
        byteBuffer.get();
        return 4;
    }
}
