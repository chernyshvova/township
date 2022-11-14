package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakd {
    public static void zza(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(GeneratedOutlineSupport.outline9(15, "csd-", i), ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void zzb(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }
}
