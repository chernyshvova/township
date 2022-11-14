package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzou implements zzamb, zzpk, zzafz, zzabf, zzrv, zzlq, zzpz, zzamn, zzaef, zzahk, zzse {
    public final zzajh zza;
    public final zzms zzb = new zzms();
    public final zzmu zzc = new zzmu();
    public final zzot zzd = new zzot(this.zzb);
    public final SparseArray<zzov> zze = new SparseArray<>();
    public zzajz<zzow> zzf;
    public zzlu zzg;
    public boolean zzh;

    public zzou(zzajh zzajh) {
        this.zza = zzajh;
        this.zzf = new zzajz<>(zzalh.zzk(), zzajh, zzmy.zza);
    }

    private final zzov zzae(@Nullable zzadv zzadv) {
        zzmv zzmv;
        if (this.zzg != null) {
            if (zzadv == null) {
                zzmv = null;
            } else {
                zzmv = this.zzd.zze(zzadv);
            }
            if (zzadv != null && zzmv != null) {
                return zzY(zzmv, zzmv.zzf(zzadv.zza, this.zzb).zzc, zzadv);
            }
            int zzt = this.zzg.zzt();
            zzmv zzC = this.zzg.zzC();
            if (zzt >= zzC.zzr()) {
                zzC = zzmv.zza;
            }
            return zzY(zzC, zzt, (zzadv) null);
        }
        throw null;
    }

    private final zzov zzaf() {
        return zzae(this.zzd.zzb());
    }

    private final zzov zzag() {
        return zzae(this.zzd.zzc());
    }

    private final zzov zzah(int i, @Nullable zzadv zzadv) {
        zzlu zzlu = this.zzg;
        if (zzlu == null) {
            throw null;
        } else if (zzadv == null) {
            zzmv zzC = zzlu.zzC();
            if (i >= zzC.zzr()) {
                zzC = zzmv.zza;
            }
            return zzY(zzC, i, (zzadv) null);
        } else if (this.zzd.zze(zzadv) != null) {
            return zzae(zzadv);
        } else {
            return zzY(zzmv.zza, i, zzadv);
        }
    }

    public final void zzA(Exception exc) {
        zzov zzag = zzag();
        zzW(zzag, 1038, new zznp(zzag, exc));
    }

    public final void zzB(zzro zzro) {
        zzov zzag = zzag();
        zzW(zzag, 1008, new zzoo(zzag, zzro));
    }

    public final void zzC(String str, long j, long j2) {
        zzov zzag = zzag();
        zzW(zzag, 1009, new zzop(zzag, str, j2, j));
    }

    public final void zzD(zzkc zzkc, @Nullable zzrs zzrs) {
        zzov zzag = zzag();
        zzW(zzag, 1010, new zzoq(zzag, zzkc, zzrs));
    }

    public final void zzE(long j) {
        zzov zzag = zzag();
        zzW(zzag, 1011, new zzor(zzag, j));
    }

    public final void zzF(int i, long j, long j2) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_NO_DROP, new zzos(zzag, i, j, j2));
    }

    public final void zzG(String str) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_ALL_SCROLL, new zzmz(zzag, str));
    }

    public final void zzH(zzro zzro) {
        zzov zzaf = zzaf();
        zzW(zzaf, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new zzna(zzaf, zzro));
    }

    public final void zzI(boolean z) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new zznb(zzag, z));
    }

    public final void zzJ(Exception exc) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_ZOOM_IN, new zznc(zzag, exc));
    }

    public final void zzK(Exception exc) {
        zzov zzag = zzag();
        zzW(zzag, 1037, new zznd(zzag, exc));
    }

    public final void zzL(zzkc zzkc) {
    }

    public final void zzM(zzkc zzkc) {
    }

    @CallSuper
    public final void zzN(zzow zzow) {
        this.zzf.zzb(zzow);
    }

    @CallSuper
    public final void zzO(zzow zzow) {
        this.zzf.zzc(zzow);
    }

    @CallSuper
    public final void zzP(zzlu zzlu, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzajg.zzd(z);
        this.zzg = zzlu;
        this.zzf = this.zzf.zza(looper, new zznh(this, zzlu));
    }

    @CallSuper
    public final void zzQ() {
        zzov zzX = zzX();
        this.zze.put(1036, zzX);
        this.zzf.zzg(1036, new zzns(zzX));
    }

    public final void zzR(List<zzadv> list, @Nullable zzadv zzadv) {
        zzot zzot = this.zzd;
        zzlu zzlu = this.zzg;
        if (zzlu != null) {
            zzot.zzh(list, zzadv, zzlu);
            return;
        }
        throw null;
    }

    public final void zzS() {
        if (!this.zzh) {
            zzov zzX = zzX();
            this.zzh = true;
            zzW(zzX, -1, new zzoc(zzX));
        }
    }

    public final void zzT(float f) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_ZOOM_OUT, new zzne(zzag, f));
    }

    public final void zzU(int i, int i2) {
        zzov zzag = zzag();
        zzW(zzag, 1029, new zznq(zzag, i, i2));
    }

    public final void zzV(int i, long j, long j2) {
        zzov zzae = zzae(this.zzd.zzd());
        zzW(zzae, 1006, new zzon(zzae, i, j, j2));
    }

    public final void zzW(zzov zzov, int i, zzajw<zzow> zzajw) {
        this.zze.put(i, zzov);
        zzajz<zzow> zzajz = this.zzf;
        zzajz.zzd(i, zzajw);
        zzajz.zze();
    }

    public final zzov zzX() {
        return zzae(this.zzd.zza());
    }

    @RequiresNonNull({"player"})
    public final zzov zzY(zzmv zzmv, int i, @Nullable zzadv zzadv) {
        zzmv zzmv2 = zzmv;
        int i2 = i;
        boolean z = true;
        zzadv zzadv2 = true == zzmv.zzt() ? null : zzadv;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!zzmv2.equals(this.zzg.zzC()) || i2 != this.zzg.zzt()) {
            z = false;
        }
        long j = 0;
        if (zzadv2 == null || !zzadv2.zzb()) {
            if (z) {
                j = this.zzg.zzB();
            } else if (!zzmv.zzt()) {
                long j2 = zzmv2.zze(i2, this.zzc, 0).zzl;
                j = zzig.zza(0);
            }
        } else if (z && this.zzg.zzz() == zzadv2.zzb) {
            this.zzg.zzA();
            j = this.zzg.zzv();
        }
        return new zzov(elapsedRealtime, zzmv, i, zzadv2, j, this.zzg.zzC(), this.zzg.zzt(), this.zzd.zza(), this.zzg.zzv(), this.zzg.zzx());
    }

    public final /* synthetic */ void zzZ(zzlu zzlu, zzow zzow, zzajr zzajr) {
        SparseArray<zzov> sparseArray = this.zze;
        SparseArray sparseArray2 = new SparseArray(zzajr.zza());
        int i = 0;
        while (i < zzajr.zza()) {
            int zzb2 = zzajr.zzb(i);
            zzov zzov = sparseArray.get(zzb2);
            if (zzov != null) {
                sparseArray2.append(zzb2, zzov);
                i++;
            } else {
                throw null;
            }
        }
    }

    public final void zza(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr) {
        zzov zzah = zzah(i, zzadv);
        zzW(zzah, 1000, new zznr(zzah, zzadm, zzadr));
    }

    public final void zzaa(zzru zzru) {
    }

    public final void zzab(int i, boolean z) {
    }

    public final void zzac(int i, int i2, int i3, float f) {
    }

    public final void zzad() {
    }

    public final void zzb(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr) {
        zzov zzah = zzah(i, zzadv);
        zzW(zzah, 1001, new zznt(zzah, zzadm, zzadr));
    }

    public final void zzbf(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr) {
        zzov zzah = zzah(i, zzadv);
        zzW(zzah, 1002, new zznu(zzah, zzadm, zzadr));
    }

    public final void zzbg(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        zzov zzah = zzah(i, zzadv);
        zzW(zzah, 1003, new zznv(zzah, zzadm, zzadr, iOException, z));
    }

    public final void zzbh(int i, @Nullable zzadv zzadv, zzadr zzadr) {
        zzov zzah = zzah(i, zzadv);
        zzW(zzah, PointerIconCompat.TYPE_WAIT, new zznw(zzah, zzadr));
    }

    public final void zzbt(String str, long j, long j2) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_GRABBING, new zzng(zzag, str, j2, j));
    }

    public final void zzbu(zzkc zzkc, @Nullable zzrs zzrs) {
        zzov zzag = zzag();
        zzW(zzag, 1022, new zzni(zzag, zzkc, zzrs));
    }

    public final void zzbv(zzmv zzmv, int i) {
        zzot zzot = this.zzd;
        zzlu zzlu = this.zzg;
        if (zzlu != null) {
            zzot.zzg(zzlu);
            zzov zzX = zzX();
            zzW(zzX, 0, new zznx(zzX, i));
            return;
        }
        throw null;
    }

    public final void zzbw(@Nullable zzkq zzkq, int i) {
        zzov zzX = zzX();
        zzW(zzX, 1, new zzny(zzX, zzkq, i));
    }

    public final void zzc(zzro zzro) {
        zzov zzag = zzag();
        zzW(zzag, PointerIconCompat.TYPE_GRAB, new zznf(zzag, zzro));
    }

    public final void zzh(zzaft zzaft, zzagx zzagx) {
        zzov zzX = zzX();
        zzW(zzX, 2, new zznz(zzX, zzaft, zzagx));
    }

    public final void zzi(List<zzabe> list) {
        zzov zzX = zzX();
        zzW(zzX, 3, new zzoa(zzX, list));
    }

    public final void zzj(zzku zzku) {
        zzov zzX = zzX();
        zzW(zzX, 15, new zzol(zzX, zzku));
    }

    public final void zzk(boolean z) {
        zzov zzX = zzX();
        zzW(zzX, 4, new zzob(zzX, z));
    }

    public final void zzl(boolean z, int i) {
        zzov zzX = zzX();
        zzW(zzX, -1, new zzod(zzX, z, i));
    }

    public final void zzm(int i) {
        zzov zzX = zzX();
        zzW(zzX, 5, new zzoe(zzX, i));
    }

    public final void zzn(boolean z, int i) {
        zzov zzX = zzX();
        zzW(zzX, 6, new zzof(zzX, z, i));
    }

    public final void zzo(int i) {
        zzov zzX = zzX();
        zzW(zzX, 7, new zzog(zzX, i));
    }

    public final void zzp(boolean z) {
        zzov zzX = zzX();
        zzW(zzX, 8, new zzoh(zzX, z));
    }

    public final void zzq(zzio zzio) {
        zzov zzov;
        zzadu zzadu = zzio.zzf;
        if (zzadu != null) {
            zzov = zzae(new zzadv(zzadu));
        } else {
            zzov = zzX();
        }
        zzW(zzov, 11, new zzoi(zzov, zzio));
    }

    public final void zzr(zzlt zzlt, zzlt zzlt2, int i) {
        if (i == 1) {
            this.zzh = false;
            i = 1;
        }
        zzot zzot = this.zzd;
        zzlu zzlu = this.zzg;
        if (zzlu != null) {
            zzot.zzf(zzlu);
            zzov zzX = zzX();
            zzW(zzX, 12, new zzoj(zzX, i, zzlt, zzlt2));
            return;
        }
        throw null;
    }

    public final void zzs(zzll zzll) {
        zzov zzX = zzX();
        zzW(zzX, 13, new zzok(zzX, zzll));
    }

    public final void zzt() {
        zzov zzX = zzX();
        zzW(zzX, -1, new zzom(zzX));
    }

    public final void zzu(int i, long j) {
        zzov zzaf = zzaf();
        zzW(zzaf, AudioAttributesCompat.FLAG_ALL, new zznj(zzaf, i, j));
    }

    public final void zzv(zzamp zzamp) {
        zzov zzag = zzag();
        zzW(zzag, 1028, new zznm(zzag, zzamp));
    }

    public final void zzw(Object obj, long j) {
        zzov zzag = zzag();
        zzW(zzag, 1027, new zznn(zzag, obj, j));
    }

    public final void zzx(String str) {
        zzov zzag = zzag();
        zzW(zzag, 1024, new zznk(zzag, str));
    }

    public final void zzy(zzro zzro) {
        zzov zzaf = zzaf();
        zzW(zzaf, InputDeviceCompat.SOURCE_GAMEPAD, new zznl(zzaf, zzro));
    }

    public final void zzz(long j, int i) {
        zzov zzaf = zzaf();
        zzW(zzaf, 1026, new zzno(zzaf, j, i));
    }
}
