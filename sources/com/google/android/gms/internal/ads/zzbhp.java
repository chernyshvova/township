package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhp {
    @VisibleForTesting
    public final zzbew zza;
    public final zzbve zzb;
    public final zzbdo zzc;
    public final AtomicBoolean zzd;
    public final VideoController zze;
    @Nullable
    public zzbcz zzf;
    public AdListener zzg;
    public AdSize[] zzh;
    @Nullable
    public AppEventListener zzi;
    @Nullable
    public zzbfr zzj;
    public VideoOptions zzk;
    public String zzl;
    @NotOnlyInitialized
    public final ViewGroup zzm;
    public int zzn;
    public boolean zzo;
    @Nullable
    public OnPaidEventListener zzp;

    public zzbhp(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzbdo.zza, (zzbfr) null, 0);
    }

    public static zzbdp zzB(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzbdp.zze();
            }
        }
        zzbdp zzbdp = new zzbdp(context, adSizeArr);
        zzbdp.zzj = zzC(i);
        return zzbdp;
    }

    public static boolean zzC(int i) {
        return i == 1;
    }

    public final void zza() {
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzc();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final AdListener zzb() {
        return this.zzg;
    }

    @Nullable
    public final AdSize zzc() {
        zzbdp zzn2;
        try {
            zzbfr zzbfr = this.zzj;
            if (!(zzbfr == null || (zzn2 = zzbfr.zzn()) == null)) {
                return zza.zza(zzn2.zze, zzn2.zzb, zzn2.zza);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] zzd() {
        return this.zzh;
    }

    public final String zze() {
        zzbfr zzbfr;
        if (this.zzl == null && (zzbfr = this.zzj) != null) {
            try {
                this.zzl = zzbfr.zzu();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    @Nullable
    public final AppEventListener zzf() {
        return this.zzi;
    }

    public final void zzg(zzbhn zzbhn) {
        zzbfr zzbfr;
        try {
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzbdp zzB = zzB(context, this.zzh, this.zzn);
                if ("search_v2".equals(zzB.zza)) {
                    zzbfr = (zzbfr) new zzbei(zzbev.zzb(), context, zzB, this.zzl).zzd(context, false);
                } else {
                    zzbfr = (zzbfr) new zzbeg(zzbev.zzb(), context, zzB, this.zzl, this.zzb).zzd(context, false);
                }
                this.zzj = zzbfr;
                zzbfr.zzh(new zzbdf(this.zza));
                zzbcz zzbcz = this.zzf;
                if (zzbcz != null) {
                    this.zzj.zzy(new zzbda(zzbcz));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzi(new zzawn(appEventListener));
                }
                VideoOptions videoOptions = this.zzk;
                if (videoOptions != null) {
                    this.zzj.zzF(new zzbiv(videoOptions));
                }
                this.zzj.zzO(new zzbio(this.zzp));
                this.zzj.zzz(this.zzo);
                zzbfr zzbfr2 = this.zzj;
                if (zzbfr2 != null) {
                    try {
                        IObjectWrapper zzb2 = zzbfr2.zzb();
                        if (zzb2 != null) {
                            this.zzm.addView((View) ObjectWrapper.unwrap(zzb2));
                        }
                    } catch (RemoteException e) {
                        zzcgs.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzbfr zzbfr3 = this.zzj;
            if (zzbfr3 == null) {
                throw null;
            } else if (zzbfr3.zze(this.zzc.zza(this.zzm.getContext(), zzbhn))) {
                this.zzb.zze(zzbhn.zzn());
            }
        } catch (RemoteException e2) {
            zzcgs.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzh() {
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzf();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzi() {
        if (!this.zzd.getAndSet(true)) {
            try {
                zzbfr zzbfr = this.zzj;
                if (zzbfr != null) {
                    zzbfr.zzm();
                }
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzj() {
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzg();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzk(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzl(@Nullable zzbcz zzbcz) {
        try {
            this.zzf = zzbcz;
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzy(zzbcz != null ? new zzbda(zzbcz) : null);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzm(AdSize... adSizeArr) {
        if (this.zzh == null) {
            zzn(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zzn(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzo(zzB(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzo(String str) {
        if (this.zzl == null) {
            this.zzl = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzp(@Nullable AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzi(appEventListener != null ? new zzawn(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq(boolean z) {
        this.zzo = z;
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzz(z);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final boolean zzr() {
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                return zzbfr.zzA();
            }
            return false;
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    @Nullable
    public final ResponseInfo zzs() {
        zzbhd zzbhd = null;
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbhd = zzbfr.zzt();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzbhd);
    }

    public final void zzt(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzO(new zzbio(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#008 Must be called on the main UI thread.", e);
        }
    }

    @Nullable
    public final OnPaidEventListener zzu() {
        return this.zzp;
    }

    public final VideoController zzv() {
        return this.zze;
    }

    @Nullable
    public final zzbhg zzw() {
        zzbfr zzbfr = this.zzj;
        if (zzbfr != null) {
            try {
                return zzbfr.zzE();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
        return null;
    }

    public final void zzx(VideoOptions videoOptions) {
        this.zzk = videoOptions;
        try {
            zzbfr zzbfr = this.zzj;
            if (zzbfr != null) {
                zzbfr.zzF(videoOptions == null ? null : new zzbiv(videoOptions));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions zzy() {
        return this.zzk;
    }

    public final boolean zzz(zzbfr zzbfr) {
        try {
            IObjectWrapper zzb2 = zzbfr.zzb();
            if (zzb2 == null || ((View) ObjectWrapper.unwrap(zzb2)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(zzb2));
            this.zzj = zzbfr;
            return true;
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public zzbhp(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzbdo.zza, (zzbfr) null, i);
    }

    public zzbhp(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzbdo.zza, (zzbfr) null, 0);
    }

    public zzbhp(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzbdo.zza, (zzbfr) null, i);
    }

    @VisibleForTesting
    public zzbhp(ViewGroup viewGroup, @Nullable AttributeSet attributeSet, boolean z, zzbdo zzbdo, @Nullable zzbfr zzbfr, int i) {
        zzbdp zzbdp;
        this.zzb = new zzbve();
        this.zze = new VideoController();
        this.zza = new zzbho(this);
        this.zzm = viewGroup;
        this.zzc = zzbdo;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzbdx zzbdx = new zzbdx(context, attributeSet);
                this.zzh = zzbdx.zza(z);
                this.zzl = zzbdx.zzb();
                if (viewGroup.isInEditMode()) {
                    zzcgl zza2 = zzbev.zza();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzbdp = zzbdp.zze();
                    } else {
                        zzbdp zzbdp2 = new zzbdp(context, adSize);
                        zzbdp2.zzj = zzC(i2);
                        zzbdp = zzbdp2;
                    }
                    zza2.zzc(viewGroup, zzbdp, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzbev.zza().zzb(viewGroup, new zzbdp(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
