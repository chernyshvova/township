package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbs extends zzgip {
    public Date zza;
    public Date zzh;
    public long zzi;
    public long zzj;
    public double zzk = 1.0d;
    public float zzl = 1.0f;
    public zzgiz zzm = zzgiz.zzj;
    public long zzn;

    public zzbs() {
        super("mvhd");
    }

    public final String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MovieHeaderBox[creationTime=");
        outline24.append(this.zza);
        outline24.append(";modificationTime=");
        outline24.append(this.zzh);
        outline24.append(";timescale=");
        outline24.append(this.zzi);
        outline24.append(";duration=");
        outline24.append(this.zzj);
        outline24.append(";rate=");
        outline24.append(this.zzk);
        outline24.append(";volume=");
        outline24.append(this.zzl);
        outline24.append(";matrix=");
        outline24.append(this.zzm);
        outline24.append(";nextTrackId=");
        outline24.append(this.zzn);
        outline24.append("]");
        return outline24.toString();
    }

    public final long zzd() {
        return this.zzi;
    }

    public final long zze() {
        return this.zzj;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzgiu.zza(zzbo.zzd(byteBuffer));
            this.zzh = zzgiu.zza(zzbo.zzd(byteBuffer));
            this.zzi = zzbo.zza(byteBuffer);
            this.zzj = zzbo.zzd(byteBuffer);
        } else {
            this.zza = zzgiu.zza(zzbo.zza(byteBuffer));
            this.zzh = zzgiu.zza(zzbo.zza(byteBuffer));
            this.zzi = zzbo.zza(byteBuffer);
            this.zzj = zzbo.zza(byteBuffer);
        }
        this.zzk = zzbo.zze(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & Base64.EQUALS_SIGN_ENC) | ((short) ((bArr[0] << 8) & 65280))))) / 256.0f;
        zzbo.zzb(byteBuffer);
        zzbo.zza(byteBuffer);
        zzbo.zza(byteBuffer);
        this.zzm = zzgiz.zza(byteBuffer);
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzbo.zza(byteBuffer);
    }
}
