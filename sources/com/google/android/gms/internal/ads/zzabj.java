package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabj {
    public final ByteArrayOutputStream zza = new ByteArrayOutputStream(512);
    public final DataOutputStream zzb = new DataOutputStream(this.zza);

    public static void zzb(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public static void zzc(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeByte(((int) (j >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j) & 255);
    }

    public final byte[] zza(zzabi zzabi) {
        this.zza.reset();
        try {
            zzb(this.zzb, zzabi.zza);
            String str = zzabi.zzb;
            if (str == null) {
                str = "";
            }
            zzb(this.zzb, str);
            zzc(this.zzb, zzabi.zzc);
            zzc(this.zzb, zzabi.zzd);
            this.zzb.write(zzabi.zze);
            this.zzb.flush();
            return this.zza.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
