package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzgir implements Iterator<zzbp>, Closeable, zzbq {
    public static final zzbp zza = new zzgiq("eof ");
    public static final zzgiy zzb = zzgiy.zzb(zzgir.class);
    public zzbm zzc;
    public zzgis zzd;
    public zzbp zze = null;
    public long zzf = 0;
    public long zzg = 0;
    public final List<zzbp> zzh = new ArrayList();

    public void close() throws IOException {
    }

    public final boolean hasNext() {
        zzbp zzbp = this.zze;
        if (zzbp == zza) {
            return false;
        }
        if (zzbp != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzh.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzh.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public final List<zzbp> zzd() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzgix(this.zzh, this);
    }

    public final void zze(zzgis zzgis, long j, zzbm zzbm) throws IOException {
        this.zzd = zzgis;
        this.zzf = zzgis.zzc();
        zzgis.zzd(zzgis.zzc() + j);
        this.zzg = zzgis.zzc();
        this.zzc = zzbm;
    }

    /* renamed from: zzf */
    public final zzbp next() {
        zzbp zzb2;
        zzbp zzbp = this.zze;
        if (zzbp == null || zzbp == zza) {
            zzgis zzgis = this.zzd;
            if (zzgis == null || this.zzf >= this.zzg) {
                this.zze = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzgis) {
                    this.zzd.zzd(this.zzf);
                    zzb2 = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzc();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zze = null;
            return zzbp;
        }
    }
}
