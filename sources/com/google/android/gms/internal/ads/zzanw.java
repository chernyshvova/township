package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzanw {
    public static final /* synthetic */ int zza = 0;
    public static final int[] zzb = {1, 2, 3, 6};
    public static final int[] zzc = {48000, 44100, 32000};
    public static final int[] zzd = {2, 1, 2, 3, 3, 4, 4, 5};

    public static zzank zza(zzaut zzaut, String str, String str2, zzaph zzaph) {
        int i = zzc[(zzaut.zzl() & 192) >> 6];
        int zzl = zzaut.zzl();
        int i2 = zzd[(zzl & 56) >> 3];
        if ((zzl & 4) != 0) {
            i2++;
        }
        return zzank.zzb(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzaph, 0, str2);
    }

    public static zzank zzb(zzaut zzaut, String str, String str2, zzaph zzaph) {
        zzaut zzaut2 = zzaut;
        zzaut.zzj(2);
        int i = zzc[(zzaut.zzl() & 192) >> 6];
        int zzl = zzaut.zzl();
        int i2 = zzd[(zzl & 14) >> 1];
        if ((zzl & 1) != 0) {
            i2++;
        }
        return zzank.zzb(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzaph, 0, str2);
    }

    public static int zzc(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzb[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
