package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcjq extends zzcig implements TextureView.SurfaceTextureListener, zzcip {
    public final zzciz zzc;
    public final zzcja zzd;
    public final boolean zze;
    public final zzciy zzf;
    public zzcif zzg;
    public Surface zzh;
    public zzciq zzi;
    public String zzj;
    public String[] zzk;
    public boolean zzl;
    public int zzm = 1;
    public zzcix zzn;
    public final boolean zzo;
    public boolean zzp;
    public boolean zzq;
    public int zzr;
    public int zzs;
    public int zzt;
    public int zzu;
    public float zzv;

    public zzcjq(Context context, zzcja zzcja, zzciz zzciz, boolean z, boolean z2, zzciy zzciy) {
        super(context);
        this.zze = z2;
        this.zzc = zzciz;
        this.zzd = zzcja;
        this.zzo = z;
        this.zzf = zzciy;
        setSurfaceTextureListener(this);
        this.zzd.zza(this);
    }

    private final boolean zzR() {
        zzciq zzciq = this.zzi;
        return zzciq != null && zzciq.zzY() && !this.zzl;
    }

    private final boolean zzS() {
        return zzR() && this.zzm != 1;
    }

    private final void zzT() {
        String str;
        if (this.zzi == null && (str = this.zzj) != null && this.zzh != null) {
            if (str.startsWith("cache:")) {
                zzckx zzs2 = this.zzc.zzs(this.zzj);
                if (zzs2 instanceof zzclf) {
                    zzciq zzj2 = ((zzclf) zzs2).zzj();
                    this.zzi = zzj2;
                    if (!zzj2.zzY()) {
                        zzcgs.zzi("Precached video player has been released.");
                        return;
                    }
                } else if (zzs2 instanceof zzcld) {
                    zzcld zzcld = (zzcld) zzs2;
                    String zzE = zzE();
                    ByteBuffer zzr2 = zzcld.zzr();
                    boolean zzq2 = zzcld.zzq();
                    String zzp2 = zzcld.zzp();
                    if (zzp2 == null) {
                        zzcgs.zzi("Stream cache URL is null.");
                        return;
                    }
                    zzciq zzD = zzD();
                    this.zzi = zzD;
                    zzD.zzO(new Uri[]{Uri.parse(zzp2)}, zzE, zzr2, zzq2);
                } else {
                    String valueOf = String.valueOf(this.zzj);
                    zzcgs.zzi(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzi = zzD();
                String zzE2 = zzE();
                Uri[] uriArr = new Uri[this.zzk.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzk;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzi.zzN(uriArr, zzE2);
            }
            this.zzi.zzP(this);
            zzU(this.zzh, false);
            if (this.zzi.zzY()) {
                int zzZ = this.zzi.zzZ();
                this.zzm = zzZ;
                if (zzZ == 3) {
                    zzW();
                }
            }
        }
    }

    private final void zzU(Surface surface, boolean z) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            try {
                zzciq.zzR(surface, z);
            } catch (IOException e) {
                zzcgs.zzj("", e);
            }
        } else {
            zzcgs.zzi("Trying to set surface before player is initialized.");
        }
    }

    private final void zzV(float f, boolean z) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            try {
                zzciq.zzS(f, z);
            } catch (IOException e) {
                zzcgs.zzj("", e);
            }
        } else {
            zzcgs.zzi("Trying to set volume before player is initialized.");
        }
    }

    private final void zzW() {
        if (!this.zzp) {
            this.zzp = true;
            zzr.zza.post(new zzcje(this));
            zzq();
            this.zzd.zzb();
            if (this.zzq) {
                zze();
            }
        }
    }

    public static String zzX(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(str.length(), 2, String.valueOf(canonicalName).length(), String.valueOf(message).length()));
        GeneratedOutlineSupport.outline34(sb, str, "/", canonicalName, CertificateUtil.DELIMITER);
        sb.append(message);
        return sb.toString();
    }

    private final void zzY() {
        zzZ(this.zzr, this.zzs);
    }

    private final void zzZ(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzv != f) {
            this.zzv = f;
            requestLayout();
        }
    }

    private final void zzaa() {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzak(true);
        }
    }

    private final void zzab() {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzak(false);
        }
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzv;
        if (f != 0.0f && this.zzn == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcix zzcix = this.zzn;
        if (zzcix != null) {
            zzcix.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzo) {
            zzcix zzcix = new zzcix(getContext());
            this.zzn = zzcix;
            zzcix.zzb(surfaceTexture, i, i2);
            this.zzn.start();
            SurfaceTexture zze2 = this.zzn.zze();
            if (zze2 != null) {
                surfaceTexture = zze2;
            } else {
                this.zzn.zzd();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzT();
        } else {
            zzU(surface, true);
            if (!this.zzf.zza) {
                zzaa();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzZ(i, i2);
        } else {
            zzY();
        }
        zzr.zza.post(new zzcjl(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzf();
        zzcix zzcix = this.zzn;
        if (zzcix != null) {
            zzcix.zzd();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzab();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzU((Surface) null, true);
        }
        zzr.zza.post(new zzcjn(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzcix zzcix = this.zzn;
        if (zzcix != null) {
            zzcix.zzc(i, i2);
        }
        zzr.zza.post(new zzcjm(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzg);
    }

    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zze.zza(sb.toString());
        zzr.zza.post(new zzcjo(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzW(i);
        }
    }

    public final void zzB(int i) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzX(i);
        }
    }

    public final void zzC() {
        zzr.zza.post(new zzcjg(this));
    }

    public final zzciq zzD() {
        zzciy zzciy = this.zzf;
        if (zzciy.zzm) {
            return new zzclw(this.zzc.getContext(), this.zzf, this.zzc);
        }
        if (zzciy.zzn) {
            return new zzcmh(this.zzc.getContext(), this.zzf, this.zzc);
        }
        return new zzckg(this.zzc.getContext(), this.zzf, this.zzc);
    }

    public final String zzE() {
        return zzs.zzc().zze(this.zzc.getContext(), this.zzc.zzt().zza);
    }

    public final /* synthetic */ void zzF() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzk();
        }
    }

    public final /* synthetic */ void zzG(String str) {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzg("ExoPlayerAdapter exception", str);
        }
    }

    public final /* synthetic */ void zzH(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    public final /* synthetic */ void zzI(int i) {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.onWindowVisibilityChanged(i);
        }
    }

    public final /* synthetic */ void zzJ() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzh();
        }
    }

    public final /* synthetic */ void zzK(int i, int i2) {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzj(i, i2);
        }
    }

    public final /* synthetic */ void zzL() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zza();
        }
    }

    public final /* synthetic */ void zzM() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzd();
        }
    }

    public final /* synthetic */ void zzN() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzc();
        }
    }

    public final /* synthetic */ void zzO(String str) {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzf("ExoPlayerAdapter error", str);
        }
    }

    public final /* synthetic */ void zzP() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zze();
        }
    }

    public final /* synthetic */ void zzQ() {
        zzcif zzcif = this.zzg;
        if (zzcif != null) {
            zzcif.zzb();
        }
    }

    public final String zza() {
        String str = true != this.zzo ? "" : " spherical";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final void zzb(zzcif zzcif) {
        this.zzg = zzcif;
    }

    public final void zzc(String str) {
        if (str != null) {
            this.zzj = str;
            this.zzk = new String[]{str};
            zzT();
        }
    }

    public final void zzd() {
        if (zzR()) {
            this.zzi.zzT();
            if (this.zzi != null) {
                zzU((Surface) null, true);
                zzciq zzciq = this.zzi;
                if (zzciq != null) {
                    zzciq.zzP((zzcip) null);
                    this.zzi.zzQ();
                    this.zzi = null;
                }
                this.zzm = 1;
                this.zzl = false;
                this.zzp = false;
                this.zzq = false;
            }
        }
        this.zzd.zzf();
        this.zzb.zze();
        this.zzd.zzc();
    }

    public final void zze() {
        if (zzS()) {
            if (this.zzf.zza) {
                zzaa();
            }
            this.zzi.zzac(true);
            this.zzd.zze();
            this.zzb.zzd();
            this.zza.zza();
            zzr.zza.post(new zzcjj(this));
            return;
        }
        this.zzq = true;
    }

    public final void zzf() {
        if (zzS()) {
            if (this.zzf.zza) {
                zzab();
            }
            this.zzi.zzac(false);
            this.zzd.zzf();
            this.zzb.zze();
            zzr.zza.post(new zzcjk(this));
        }
    }

    public final int zzg() {
        if (zzS()) {
            return (int) this.zzi.zzaf();
        }
        return 0;
    }

    public final int zzh() {
        if (zzS()) {
            return (int) this.zzi.zzaa();
        }
        return 0;
    }

    public final void zzi(int i) {
        if (zzS()) {
            this.zzi.zzU((long) i);
        }
    }

    public final void zzj(float f, float f2) {
        zzcix zzcix = this.zzn;
        if (zzcix != null) {
            zzcix.zzf(f, f2);
        }
    }

    public final int zzk() {
        return this.zzr;
    }

    public final int zzl() {
        return this.zzs;
    }

    public final long zzm() {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            return zzciq.zzag();
        }
        return -1;
    }

    public final long zzn() {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            return zzciq.zzah();
        }
        return -1;
    }

    public final long zzo() {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            return zzciq.zzai();
        }
        return -1;
    }

    public final int zzp() {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            return zzciq.zzaj();
        }
        return -1;
    }

    public final void zzq() {
        zzV(this.zzb.zzc(), false);
    }

    public final void zzr(boolean z, long j) {
        if (this.zzc != null) {
            zzche.zze.execute(new zzcjp(this, z, j));
        }
    }

    public final void zzs(int i) {
        if (this.zzm != i) {
            this.zzm = i;
            if (i == 3) {
                zzW();
            } else if (i == 4) {
                if (this.zzf.zza) {
                    zzab();
                }
                this.zzd.zzf();
                this.zzb.zze();
                zzr.zza.post(new zzcjh(this));
            }
        }
    }

    public final void zzt(int i, int i2) {
        this.zzr = i;
        this.zzs = i2;
        zzY();
    }

    public final void zzu(String str, Exception exc) {
        String str2;
        String zzX = zzX(str, exc);
        String valueOf = String.valueOf(zzX);
        if (valueOf.length() != 0) {
            str2 = "ExoPlayerAdapter error: ".concat(valueOf);
        } else {
            str2 = new String("ExoPlayerAdapter error: ");
        }
        zzcgs.zzi(str2);
        this.zzl = true;
        if (this.zzf.zza) {
            zzab();
        }
        zzr.zza.post(new zzcji(this, zzX));
    }

    public final void zzv(String str, Exception exc) {
        String str2;
        String zzX = zzX("onLoadException", exc);
        String valueOf = String.valueOf(zzX);
        if (valueOf.length() != 0) {
            str2 = "ExoPlayerAdapter exception: ".concat(valueOf);
        } else {
            str2 = new String("ExoPlayerAdapter exception: ");
        }
        zzcgs.zzi(str2);
        zzr.zza.post(new zzcjf(this, zzX));
    }

    public final void zzw(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                zzc(str);
            }
            this.zzj = str;
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzT();
        }
    }

    public final void zzx(int i) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzad(i);
        }
    }

    public final void zzy(int i) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzae(i);
        }
    }

    public final void zzz(int i) {
        zzciq zzciq = this.zzi;
        if (zzciq != null) {
            zzciq.zzV(i);
        }
    }
}
