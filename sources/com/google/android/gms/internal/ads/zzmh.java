package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmh implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzamn, zzpz, zzafz, zzabf, zzib, zzhx, zzml, zzlq, zzip {
    public final /* synthetic */ zzmj zza;

    public /* synthetic */ zzmh(zzmj zzmj, zzmf zzmf) {
        this.zza = zzmj;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzmj.zzQ(this.zza, surfaceTexture);
        this.zza.zzab(i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzaa((Object) null);
        this.zza.zzab(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzab(i, i2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzab(i2, i3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzab(0, 0);
    }

    public final void zzA(Exception exc) {
        this.zza.zzm.zzA(exc);
    }

    public final void zzB(zzro zzro) {
        zzro unused = this.zza.zzB = zzro;
        this.zza.zzm.zzB(zzro);
    }

    public final void zzC(String str, long j, long j2) {
        this.zza.zzm.zzC(str, j, j2);
    }

    public final void zzD(zzkc zzkc, @Nullable zzrs zzrs) {
        zzkc unused = this.zza.zzt = zzkc;
        this.zza.zzm.zzD(zzkc, zzrs);
    }

    public final void zzE(long j) {
        this.zza.zzm.zzE(j);
    }

    public final void zzF(int i, long j, long j2) {
        this.zza.zzm.zzF(i, j, j2);
    }

    public final void zzG(String str) {
        this.zza.zzm.zzG(str);
    }

    public final void zzH(zzro zzro) {
        this.zza.zzm.zzH(zzro);
        zzkc unused = this.zza.zzt = null;
        zzro unused2 = this.zza.zzB = null;
    }

    public final void zzI(boolean z) {
        if (this.zza.zzF != z) {
            boolean unused = this.zza.zzF = z;
            zzmj.zzN(this.zza);
        }
    }

    public final void zzJ(Exception exc) {
        this.zza.zzm.zzJ(exc);
    }

    public final void zzK(Exception exc) {
        this.zza.zzm.zzK(exc);
    }

    public final void zzL(zzkc zzkc) {
    }

    public final void zzM(zzkc zzkc) {
    }

    public final void zza(boolean z) {
    }

    public final void zzb(boolean z) {
        zzmj.zzZ(this.zza);
    }

    public final void zzbt(String str, long j, long j2) {
        this.zza.zzm.zzbt(str, j, j2);
    }

    public final void zzbu(zzkc zzkc, @Nullable zzrs zzrs) {
        zzkc unused = this.zza.zzs = zzkc;
        this.zza.zzm.zzbu(zzkc, zzrs);
    }

    public final void zzbv(zzmv zzmv, int i) {
    }

    public final void zzbw(zzkq zzkq, int i) {
    }

    public final void zzc(zzro zzro) {
        zzro unused = this.zza.zzA = zzro;
        this.zza.zzm.zzc(zzro);
    }

    public final void zzh(zzaft zzaft, zzagx zzagx) {
    }

    public final void zzi(List list) {
    }

    public final void zzj(zzku zzku) {
    }

    public final void zzk(boolean z) {
    }

    public final void zzl(boolean z, int i) {
    }

    public final void zzm(int i) {
        zzmj.zzZ(this.zza);
    }

    public final void zzn(boolean z, int i) {
        zzmj.zzZ(this.zza);
    }

    public final void zzo(int i) {
    }

    public final void zzp(boolean z) {
    }

    public final void zzq(zzio zzio) {
    }

    public final void zzr(zzlt zzlt, zzlt zzlt2, int i) {
    }

    public final void zzs(zzll zzll) {
    }

    public final void zzt() {
    }

    public final void zzu(int i, long j) {
        this.zza.zzm.zzu(i, j);
    }

    public final void zzv(zzamp zzamp) {
        zzamp unused = this.zza.zzK = zzamp;
        this.zza.zzm.zzv(zzamp);
        Iterator it = this.zza.zzh.iterator();
        while (it.hasNext()) {
            zzamb zzamb = (zzamb) it.next();
            zzamb.zzv(zzamp);
            zzamb.zzac(zzamp.zzb, zzamp.zzc, zzamp.zzd, zzamp.zze);
        }
    }

    public final void zzw(Object obj, long j) {
        this.zza.zzm.zzw(obj, j);
        if (this.zza.zzv == obj) {
            Iterator it = this.zza.zzh.iterator();
            while (it.hasNext()) {
                ((zzamb) it.next()).zzad();
            }
        }
    }

    public final void zzx(String str) {
        this.zza.zzm.zzx(str);
    }

    public final void zzy(zzro zzro) {
        this.zza.zzm.zzy(zzro);
        zzkc unused = this.zza.zzs = null;
        zzro unused2 = this.zza.zzA = null;
    }

    public final void zzz(long j, int i) {
        this.zza.zzm.zzz(j, i);
    }
}
