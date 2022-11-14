package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmj extends zzid implements zzir {
    @Nullable
    public zzro zzA;
    @Nullable
    public zzro zzB;
    public int zzC;
    public zzpi zzD;
    public float zzE;
    public boolean zzF;
    public List zzG;
    public boolean zzH;
    public boolean zzI;
    public zzru zzJ;
    public zzamp zzK;
    public final zzma[] zzb;
    public final zzajj zzc = new zzajj(zzajh.zza);
    public final Context zzd;
    public final zzjn zze;
    public final zzmh zzf;
    public final zzmi zzg;
    public final CopyOnWriteArraySet<zzamb> zzh;
    public final CopyOnWriteArraySet<zzpk> zzi;
    public final CopyOnWriteArraySet<zzafz> zzj;
    public final CopyOnWriteArraySet<zzabf> zzk;
    public final CopyOnWriteArraySet<zzrv> zzl;
    public final zzou zzm;
    public final zzhy zzn;
    public final zzic zzo;
    public final zzmo zzp;
    public final zzmw zzq;
    public final zzmx zzr;
    @Nullable
    public zzkc zzs;
    @Nullable
    public zzkc zzt;
    @Nullable
    public AudioTrack zzu;
    @Nullable
    public Object zzv;
    @Nullable
    public Surface zzw;
    public int zzx;
    public int zzy;
    public int zzz;

    public zzmj(zzmg zzmg) {
        zzmj zzmj;
        try {
            this.zzd = zzmg.zza.getApplicationContext();
            this.zzm = zzmg.zzh;
            this.zzD = zzmg.zzj;
            this.zzx = 1;
            this.zzF = false;
            this.zzf = new zzmh(this, (zzmf) null);
            this.zzg = new zzmi((zzmf) null);
            this.zzh = new CopyOnWriteArraySet<>();
            this.zzi = new CopyOnWriteArraySet<>();
            this.zzj = new CopyOnWriteArraySet<>();
            this.zzk = new CopyOnWriteArraySet<>();
            this.zzl = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(zzmg.zzi);
            zzmd zzh2 = zzmg.zzb;
            zzmh zzmh = this.zzf;
            this.zzb = zzh2.zza(handler, zzmh, zzmh, zzmh, zzmh);
            this.zzE = 1.0f;
            if (zzalh.zza < 21) {
                AudioTrack audioTrack = this.zzu;
                if (!(audioTrack == null || audioTrack.getAudioSessionId() == 0)) {
                    this.zzu.release();
                    this.zzu = null;
                }
                if (this.zzu == null) {
                    this.zzu = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.zzC = this.zzu.getAudioSessionId();
            } else {
                this.zzC = zzig.zzc(this.zzd);
            }
            this.zzG = Collections.emptyList();
            this.zzH = true;
            zzlo zzlo = new zzlo();
            zzlo.zzc(16, 17, 18, 19, 20, 21, 22, 23);
            zzlp zze2 = zzlo.zze();
            zzma[] zzmaArr = this.zzb;
            zzahc zzi2 = zzmg.zzd;
            zzaeg zzj2 = zzmg.zze;
            zzkf zzk2 = zzmg.zzf;
            zzahl zzl2 = zzmg.zzg;
            zzou zzou = this.zzm;
            zzou zzou2 = zzou;
            zzjn zzjn = r1;
            Handler handler2 = handler;
            try {
                zzjn zzjn2 = new zzjn(zzmaArr, zzi2, zzj2, zzk2, zzl2, zzou2, true, zzmg.zzk, zzmg.zzm, 500, false, zzmg.zzc, zzmg.zzi, this, zze2, (byte[]) null);
                zzmj = this;
            } catch (Throwable th) {
                th = th;
                zzmj = this;
                zzmj.zzc.zza();
                throw th;
            }
            try {
                zzmj.zze = zzjn;
                zzjn.zzf(zzmj.zzf);
                zzmj.zze.zzh(zzmj.zzf);
                Handler handler3 = handler2;
                zzmj.zzn = new zzhy(zzmg.zza, handler3, zzmj.zzf);
                zzmj.zzo = new zzic(zzmg.zza, handler3, zzmj.zzf);
                zzalh.zzc((Object) null, (Object) null);
                zzmo zzmo = new zzmo(zzmg.zza, handler3, zzmj.zzf);
                zzmj.zzp = zzmo;
                int i = zzmj.zzD.zzb;
                zzmo.zza(3);
                zzmj.zzq = new zzmw(zzmg.zza);
                zzmj.zzr = new zzmx(zzmg.zza);
                zzmj.zzJ = zzag(zzmj.zzp);
                zzmj.zzK = zzamp.zza;
                zzmj.zzaf(1, 102, Integer.valueOf(zzmj.zzC));
                zzmj.zzaf(2, 102, Integer.valueOf(zzmj.zzC));
                zzmj.zzaf(1, 3, zzmj.zzD);
                zzmj.zzaf(2, 4, Integer.valueOf(zzmj.zzx));
                zzmj.zzaf(1, 101, Boolean.valueOf(zzmj.zzF));
                zzmj.zzaf(2, 6, zzmj.zzg);
                zzmj.zzaf(6, 7, zzmj.zzg);
                zzmj.zzc.zza();
            } catch (Throwable th2) {
                th = th2;
                zzmj.zzc.zza();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zzmj = this;
            zzmj.zzc.zza();
            throw th;
        }
    }

    public static /* synthetic */ void zzN(zzmj zzmj) {
        zzmj.zzm.zzI(zzmj.zzF);
        Iterator<zzpk> it = zzmj.zzi.iterator();
        while (it.hasNext()) {
            it.next().zzI(zzmj.zzF);
        }
    }

    public static /* synthetic */ void zzQ(zzmj zzmj, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzmj.zzaa(surface);
        zzmj.zzw = surface;
    }

    public static /* synthetic */ void zzZ(zzmj zzmj) {
        int zzi2 = zzmj.zzi();
        if (zzi2 == 2 || zzi2 == 3) {
            zzmj.zzae();
            zzmj.zze.zzd();
            zzmj.zzn();
            zzmj.zzn();
        }
    }

    /* access modifiers changed from: private */
    public final void zzaa(@Nullable Object obj) {
        ArrayList arrayList = new ArrayList();
        zzma[] zzmaArr = this.zzb;
        int length = zzmaArr.length;
        for (int i = 0; i < 2; i++) {
            zzma zzma = zzmaArr[i];
            if (zzma.zza() == 2) {
                zzlx zzc2 = this.zze.zzc(zzma);
                zzc2.zzb(1);
                zzc2.zzd(obj);
                zzc2.zzg();
                arrayList.add(zzc2);
            }
        }
        Object obj2 = this.zzv;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzlx) it.next()).zzk(2000);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.zze.zzq(false, zzio.zzb(new zzjz(3)));
            }
            Object obj3 = this.zzv;
            Surface surface = this.zzw;
            if (obj3 == surface) {
                surface.release();
                this.zzw = null;
            }
        }
        this.zzv = obj;
    }

    /* access modifiers changed from: private */
    public final void zzab(int i, int i2) {
        if (i != this.zzy || i2 != this.zzz) {
            this.zzy = i;
            this.zzz = i2;
            this.zzm.zzU(i, i2);
            Iterator<zzamb> it = this.zzh.iterator();
            while (it.hasNext()) {
                it.next().zzU(i, i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzac() {
        zzaf(1, 2, Float.valueOf(this.zzo.zza() * this.zzE));
    }

    /* access modifiers changed from: private */
    public final void zzad(boolean z, int i, int i2) {
        int i3 = 1;
        boolean z2 = z && i != -1;
        if (!z2 || i == 1) {
            i3 = 0;
        }
        this.zze.zzm(z2, i3, i2);
    }

    private final void zzae() {
        IllegalStateException illegalStateException;
        this.zzc.zzd();
        if (Thread.currentThread() != this.zze.zze().getThread()) {
            String zzv2 = zzalh.zzv("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zze.zze().getThread().getName());
            if (!this.zzH) {
                if (this.zzI) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzaka.zza("SimpleExoPlayer", zzv2, illegalStateException);
                this.zzI = true;
                return;
            }
            throw new IllegalStateException(zzv2);
        }
    }

    private final void zzaf(int i, int i2, @Nullable Object obj) {
        zzma[] zzmaArr = this.zzb;
        int length = zzmaArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzma zzma = zzmaArr[i3];
            if (zzma.zza() == i) {
                zzlx zzc2 = this.zze.zzc(zzma);
                zzc2.zzb(i2);
                zzc2.zzd(obj);
                zzc2.zzg();
            }
        }
    }

    public static zzru zzag(zzmo zzmo) {
        return new zzru(0, zzmo.zzb(), zzmo.zzc());
    }

    public static int zzah(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public final int zzA() {
        zzae();
        this.zze.zzA();
        return -1;
    }

    public final long zzB() {
        zzae();
        return this.zze.zzB();
    }

    public final zzmv zzC() {
        zzae();
        return this.zze.zzC();
    }

    public final int zza() {
        zzae();
        this.zze.zza();
        return 2;
    }

    @Deprecated
    public final void zzb(zzadx zzadx) {
        throw null;
    }

    public final zzlx zzc(zzlw zzlw) {
        throw null;
    }

    public final void zzd(@Nullable Surface surface) {
        zzae();
        zzaa(surface);
        int i = surface == null ? 0 : -1;
        zzab(i, i);
    }

    public final void zze(float f) {
        zzae();
        float zzz2 = zzalh.zzz(f, 0.0f, 1.0f);
        if (this.zzE != zzz2) {
            this.zzE = zzz2;
            zzac();
            this.zzm.zzT(zzz2);
            Iterator<zzpk> it = this.zzi.iterator();
            while (it.hasNext()) {
                it.next().zzT(zzz2);
            }
        }
    }

    public final void zzf(zzlq zzlq) {
        throw null;
    }

    public final void zzg(zzlq zzlq) {
        throw null;
    }

    public final void zzh(zzow zzow) {
        this.zzm.zzN(zzow);
    }

    public final int zzi() {
        zzae();
        return this.zze.zzi();
    }

    public final void zzj(zzow zzow) {
        this.zzm.zzO(zzow);
    }

    public final void zzk() {
        zzae();
        boolean zzn2 = zzn();
        int zzb2 = this.zzo.zzb(zzn2, 2);
        zzad(zzn2, zzb2, zzah(zzn2, zzb2));
        this.zze.zzj();
    }

    public final void zzl(boolean z) {
        zzae();
        int zzb2 = this.zzo.zzb(z, zzi());
        zzad(z, zzb2, zzah(z, zzb2));
    }

    public final void zzm(zzadx zzadx) {
        zzae();
        this.zze.zzk(Collections.singletonList(zzadx), true);
    }

    public final boolean zzn() {
        zzae();
        return this.zze.zzn();
    }

    public final void zzo(int i, long j) {
        zzae();
        this.zzm.zzS();
        this.zze.zzo(i, j);
    }

    public final void zzp(boolean z) {
        zzae();
        this.zzo.zzb(zzn(), 1);
        this.zze.zzq(false, (zzio) null);
        this.zzG = Collections.emptyList();
    }

    @Deprecated
    public final void zzq(boolean z) {
        this.zzH = false;
    }

    public final void zzr() {
        AudioTrack audioTrack;
        zzae();
        if (zzalh.zza < 21 && (audioTrack = this.zzu) != null) {
            audioTrack.release();
            this.zzu = null;
        }
        this.zzp.zzd();
        this.zzo.zzc();
        this.zze.zzr();
        this.zzm.zzQ();
        Surface surface = this.zzw;
        if (surface != null) {
            surface.release();
            this.zzw = null;
        }
        this.zzG = Collections.emptyList();
    }

    public final int zzs() {
        zzae();
        return this.zze.zzs();
    }

    public final int zzt() {
        zzae();
        return this.zze.zzt();
    }

    public final long zzu() {
        zzae();
        return this.zze.zzu();
    }

    public final long zzv() {
        zzae();
        return this.zze.zzv();
    }

    public final long zzw() {
        zzae();
        return this.zze.zzw();
    }

    public final long zzx() {
        zzae();
        return this.zze.zzx();
    }

    public final boolean zzy() {
        zzae();
        return this.zze.zzy();
    }

    public final int zzz() {
        zzae();
        return this.zze.zzz();
    }
}
