package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgep extends InputStream {
    public Iterator<ByteBuffer> zza;
    public ByteBuffer zzb;
    public int zzc = 0;
    public int zzd;
    public int zze;
    public boolean zzf;
    public byte[] zzg;
    public int zzh;
    public long zzi;

    public zzgep(Iterable<ByteBuffer> iterable) {
        this.zza = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.zzc++;
        }
        this.zzd = -1;
        if (!zza()) {
            this.zzb = zzgem.zzd;
            this.zzd = 0;
            this.zze = 0;
            this.zzi = 0;
        }
    }

    private final boolean zza() {
        this.zzd++;
        if (!this.zza.hasNext()) {
            return false;
        }
        ByteBuffer next = this.zza.next();
        this.zzb = next;
        this.zze = next.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzggy.zzs(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    private final void zzb(int i) {
        int i2 = this.zze + i;
        this.zze = i2;
        if (i2 == this.zzb.limit()) {
            zza();
        }
    }

    public final int read() throws IOException {
        byte zzr;
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            zzr = this.zzg[this.zze + this.zzh];
            zzb(1);
        } else {
            zzr = zzggy.zzr(((long) this.zze) + this.zzi);
            zzb(1);
        }
        return zzr & Base64.EQUALS_SIGN_ENC;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int limit = this.zzb.limit();
        int i3 = this.zze;
        int i4 = limit - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i3 + this.zzh, bArr, i, i2);
            zzb(i2);
        } else {
            int position = this.zzb.position();
            this.zzb.position(this.zze);
            this.zzb.get(bArr, i, i2);
            this.zzb.position(position);
            zzb(i2);
        }
        return i2;
    }
}
