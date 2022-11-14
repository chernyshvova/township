package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqy extends zzql {
    public static final int zzd = Float.floatToIntBits(Float.NaN);

    public static void zzo(int i, ByteBuffer byteBuffer) {
        double d = (double) i;
        Double.isNaN(d);
        int floatToIntBits = Float.floatToIntBits((float) (d * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void zzc(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.zzb.zzd;
        if (i2 == 536870912) {
            byteBuffer2 = zzi((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & Base64.EQUALS_SIGN_ENC) << 8) | ((byteBuffer.get(position + 1) & Base64.EQUALS_SIGN_ENC) << 16) | ((byteBuffer.get(position + 2) & Base64.EQUALS_SIGN_ENC) << 24), byteBuffer2);
                position += 3;
            }
        } else if (i2 == 805306368) {
            byteBuffer2 = zzi(i);
            while (position < limit) {
                zzo((byteBuffer.get(position) & Base64.EQUALS_SIGN_ENC) | ((byteBuffer.get(position + 1) & Base64.EQUALS_SIGN_ENC) << 8) | ((byteBuffer.get(position + 2) & Base64.EQUALS_SIGN_ENC) << 16) | ((byteBuffer.get(position + 3) & Base64.EQUALS_SIGN_ENC) << 24), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzpl zzk(zzpl zzpl) throws zzpm {
        int i = zzpl.zzd;
        if (zzalh.zzO(i)) {
            return i != 4 ? new zzpl(zzpl.zzb, zzpl.zzc, 4) : zzpl.zza;
        }
        throw new zzpm(zzpl);
    }
}
