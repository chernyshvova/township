package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzand implements zzana {
    public final zzanp[] zza;
    public final zzatq zzb;
    public final zzato zzc;
    public final Handler zzd;
    public final zzani zze;
    public final CopyOnWriteArraySet<zzamx> zzf;
    public final zzanu zzg;
    public final zzant zzh;
    public boolean zzi;
    public boolean zzj;
    public int zzk;
    public int zzl;
    public int zzm;
    public boolean zzn;
    public zzanv zzo;
    public Object zzp;
    public zzatc zzq;
    public zzato zzr;
    public zzano zzs;
    public zzanf zzt;
    public long zzu;

    @SuppressLint({"HandlerLeak"})
    public zzand(zzanp[] zzanpArr, zzatq zzatq, zzcjw zzcjw, byte[] bArr) {
        zzatq zzatq2 = zzatq;
        String str = zzava.zze;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        this.zza = zzanpArr;
        if (zzatq2 != null) {
            this.zzb = zzatq2;
            this.zzj = false;
            this.zzk = 1;
            this.zzf = new CopyOnWriteArraySet<>();
            this.zzc = new zzato(new zzatg[2], (byte[]) null);
            this.zzo = zzanv.zza;
            this.zzg = new zzanu();
            this.zzh = new zzant();
            this.zzq = zzatc.zza;
            this.zzr = this.zzc;
            this.zzs = zzano.zza;
            this.zzd = new zzanc(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
            zzanf zzanf = new zzanf(0, 0);
            this.zzt = zzanf;
            this.zze = new zzani(zzanpArr, zzatq, zzcjw, this.zzj, 0, this.zzd, zzanf, this, (byte[]) null);
            return;
        }
        throw null;
    }

    public final void zza(zzamx zzamx) {
        this.zzf.add(zzamx);
    }

    public final void zzb(zzamx zzamx) {
        this.zzf.remove(zzamx);
    }

    public final int zzc() {
        return this.zzk;
    }

    public final void zzd(zzasn zzasn) {
        if (!this.zzo.zzf() || this.zzp != null) {
            this.zzo = zzanv.zza;
            this.zzp = null;
            Iterator<zzamx> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzo, this.zzp);
            }
        }
        if (this.zzi) {
            this.zzi = false;
            this.zzq = zzatc.zza;
            this.zzr = this.zzc;
            this.zzb.zze((Object) null);
            Iterator<zzamx> it2 = this.zzf.iterator();
            while (it2.hasNext()) {
                it2.next().zzb(this.zzq, this.zzr);
            }
        }
        this.zzm++;
        this.zze.zzb(zzasn, true);
    }

    public final void zze(boolean z) {
        if (this.zzj != z) {
            this.zzj = z;
            this.zze.zzc(z);
            Iterator<zzamx> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzd(z, this.zzk);
            }
        }
    }

    public final boolean zzf() {
        return this.zzj;
    }

    public final void zzg(long j) {
        zzr();
        if (this.zzo.zzf() || this.zzo.zza() > 0) {
            this.zzl++;
            if (!this.zzo.zzf()) {
                this.zzo.zzg(0, this.zzg, false);
                long zzb2 = zzamv.zzb(j);
                long j2 = this.zzo.zzd(0, this.zzh, false).zzc;
                if (j2 != -9223372036854775807L) {
                    int i = (zzb2 > j2 ? 1 : (zzb2 == j2 ? 0 : -1));
                }
            }
            this.zzu = j;
            this.zze.zzd(this.zzo, 0, zzamv.zzb(j));
            Iterator<zzamx> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzf();
            }
            return;
        }
        throw new zzanm(this.zzo, 0, j);
    }

    public final void zzh() {
        this.zze.zze();
    }

    public final void zzi() {
        this.zze.zzh();
        this.zzd.removeCallbacksAndMessages((Object) null);
    }

    public final void zzj(zzamz... zzamzArr) {
        this.zze.zzf(zzamzArr);
    }

    public final void zzk(zzamz... zzamzArr) {
        this.zze.zzg(zzamzArr);
    }

    public final long zzl() {
        if (this.zzo.zzf()) {
            return -9223372036854775807L;
        }
        zzanv zzanv = this.zzo;
        zzr();
        return zzamv.zza(zzanv.zzg(0, this.zzg, false).zza);
    }

    public final long zzm() {
        if (this.zzo.zzf() || this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzamv.zza(this.zzt.zzc) + zzamv.zza(0);
    }

    public final long zzn() {
        if (this.zzo.zzf() || this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzamv.zza(this.zzt.zzd) + zzamv.zza(0);
    }

    public final void zzo() {
        this.zze.zza();
    }

    public final void zzp(int i) {
        this.zze.zzl(i);
    }

    public final void zzq(int i) {
        this.zze.zzm(i);
    }

    public final int zzr() {
        if (!this.zzo.zzf() && this.zzl <= 0) {
            this.zzo.zzd(this.zzt.zza, this.zzh, false);
        }
        return 0;
    }

    public final void zzs(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzm--;
                return;
            case 1:
                this.zzk = message.arg1;
                Iterator<zzamx> it = this.zzf.iterator();
                while (it.hasNext()) {
                    it.next().zzd(this.zzj, this.zzk);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzn = z;
                Iterator<zzamx> it2 = this.zzf.iterator();
                while (it2.hasNext()) {
                    it2.next().zzc(this.zzn);
                }
                return;
            case 3:
                if (this.zzm == 0) {
                    zzatr zzatr = (zzatr) message.obj;
                    this.zzi = true;
                    this.zzq = zzatr.zza;
                    this.zzr = zzatr.zzb;
                    this.zzb.zze(zzatr.zzc);
                    Iterator<zzamx> it3 = this.zzf.iterator();
                    while (it3.hasNext()) {
                        it3.next().zzb(this.zzq, this.zzr);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzl - 1;
                this.zzl = i;
                if (i == 0) {
                    this.zzt = (zzanf) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzamx> it4 = this.zzf.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzf();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzl == 0) {
                    this.zzt = (zzanf) message.obj;
                    Iterator<zzamx> it5 = this.zzf.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzf();
                    }
                    return;
                }
                return;
            case 6:
                zzanh zzanh = (zzanh) message.obj;
                this.zzl -= zzanh.zzd;
                if (this.zzm == 0) {
                    this.zzo = zzanh.zza;
                    this.zzp = zzanh.zzb;
                    this.zzt = zzanh.zzc;
                    Iterator<zzamx> it6 = this.zzf.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzo, this.zzp);
                    }
                    return;
                }
                return;
            case 7:
                zzano zzano = (zzano) message.obj;
                if (!this.zzs.equals(zzano)) {
                    this.zzs = zzano;
                    Iterator<zzamx> it7 = this.zzf.iterator();
                    while (it7.hasNext()) {
                        it7.next().zzg(zzano);
                    }
                    return;
                }
                return;
            case 8:
                zzamw zzamw = (zzamw) message.obj;
                Iterator<zzamx> it8 = this.zzf.iterator();
                while (it8.hasNext()) {
                    it8.next().zze(zzamw);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
