package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgin implements zzbp {
    public static final zzgiy zza = zzgiy.zzb(zzgin.class);
    public final String zzb;
    public boolean zzc;
    public boolean zzd;
    public long zze;
    public long zzf = -1;
    public zzgis zzg;
    public zzbq zzh;
    public ByteBuffer zzi;
    public ByteBuffer zzj = null;

    public zzgin(String str) {
        this.zzb = str;
        this.zzd = true;
        this.zzc = true;
    }

    private final synchronized void zzd() {
        String str;
        if (!this.zzd) {
            try {
                zzgiy zzgiy = zza;
                String str2 = this.zzb;
                if (str2.length() != 0) {
                    str = "mem mapping ".concat(str2);
                } else {
                    str = new String("mem mapping ");
                }
                zzgiy.zza(str);
                this.zzi = this.zzg.zze(this.zze, this.zzf);
                this.zzd = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void zza(zzbq zzbq) {
        this.zzh = zzbq;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(zzgis zzgis, ByteBuffer byteBuffer, long j, zzbm zzbm) throws IOException {
        this.zze = zzgis.zzc();
        byteBuffer.remaining();
        this.zzf = j;
        this.zzg = zzgis;
        zzgis.zzd(zzgis.zzc() + j);
        this.zzd = false;
        this.zzc = false;
        zzg();
    }

    public abstract void zzf(ByteBuffer byteBuffer);

    public final synchronized void zzg() {
        String str;
        zzd();
        zzgiy zzgiy = zza;
        String str2 = this.zzb;
        if (str2.length() != 0) {
            str = "parsing details of ".concat(str2);
        } else {
            str = new String("parsing details of ");
        }
        zzgiy.zza(str);
        ByteBuffer byteBuffer = this.zzi;
        if (byteBuffer != null) {
            this.zzc = true;
            byteBuffer.rewind();
            zzf(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzj = byteBuffer.slice();
            }
            this.zzi = null;
        }
    }
}
