package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.swrve.sdk.SwrveImp;
import com.vungle.warren.VisionController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdmz {
    public final zzg zza;
    public final zzeyw zzb;
    public final zzdmf zzc;
    public final zzdma zzd;
    @Nullable
    public final zzdnk zze;
    @Nullable
    public final zzdns zzf;
    public final Executor zzg;
    public final Executor zzh;
    public final zzblw zzi;
    public final zzdlx zzj;

    public zzdmz(zzg zzg2, zzeyw zzeyw, zzdmf zzdmf, zzdma zzdma, @Nullable zzdnk zzdnk, @Nullable zzdns zzdns, Executor executor, Executor executor2, zzdlx zzdlx) {
        this.zza = zzg2;
        this.zzb = zzeyw;
        this.zzi = zzeyw.zzi;
        this.zzc = zzdmf;
        this.zzd = zzdma;
        this.zze = zzdnk;
        this.zzf = zzdns;
        this.zzg = executor;
        this.zzh = executor2;
        this.zzj = zzdlx;
    }

    public static void zzg(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzh(@NonNull ViewGroup viewGroup, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View zzH = z ? this.zzd.zzH() : this.zzd.zzI();
        if (zzH == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzH.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzH.getParent()).removeView(zzH);
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcj)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzH, layoutParams);
        return true;
    }

    public final void zza(zzdnu zzdnu) {
        this.zzg.execute(new zzdmw(this, zzdnu));
    }

    public final void zzb(@Nullable zzdnu zzdnu) {
        if (zzdnu != null && this.zze != null && zzdnu.zzbL() != null && this.zzc.zzb()) {
            try {
                zzdnu.zzbL().addView(this.zze.zza());
            } catch (zzcnc e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzc(@Nullable zzdnu zzdnu) {
        if (zzdnu != null) {
            Context context = zzdnu.zzbP().getContext();
            if (zzby.zzi(context, this.zzc.zza)) {
                if (!(context instanceof Activity)) {
                    zzcgs.zzd("Activity context is needed for policy validator.");
                } else if (this.zzf != null && zzdnu.zzbL() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
                        windowManager.addView(this.zzf.zza(zzdnu.zzbL(), windowManager), zzby.zzj());
                    } catch (zzcnc e) {
                        zze.zzb("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    public final boolean zzd(@NonNull ViewGroup viewGroup) {
        return zzh(viewGroup, true);
    }

    public final /* synthetic */ void zze(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzd.zzH() == null) {
            return;
        }
        if (this.zzd.zzv() == 2 || this.zzd.zzv() == 1) {
            this.zza.zzw(this.zzb.zzf, String.valueOf(this.zzd.zzv()), z);
        } else if (this.zzd.zzv() == 6) {
            this.zza.zzw(this.zzb.zzf, SwrveImp.CAMPAIGN_RESPONSE_VERSION, z);
            this.zza.zzw(this.zzb.zzf, AppEventsConstants.EVENT_PARAM_VALUE_YES, z);
        }
    }

    public final /* synthetic */ void zzf(zzdnu zzdnu) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzbmf zza2;
        Drawable drawable;
        Context context = null;
        if (this.zzc.zze() || this.zzc.zzc()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                View zzm = zzdnu.zzm(strArr[i]);
                if (zzm != null && (zzm instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzm;
                    break;
                }
                i++;
            }
        }
        viewGroup = null;
        Context context2 = zzdnu.zzbP().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzd.zzy() != null) {
            view = this.zzd.zzy();
            zzblw zzblw = this.zzi;
            if (zzblw != null && viewGroup == null) {
                zzg(layoutParams, zzblw.zze);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.zzd.zzx() instanceof zzblp)) {
            view = null;
        } else {
            zzblp zzblp = (zzblp) this.zzd.zzx();
            if (viewGroup == null) {
                zzg(layoutParams, zzblp.zzi());
            }
            zzblq zzblq = new zzblq(context2, zzblp, layoutParams);
            zzblq.setContentDescription((CharSequence) zzbex.zzc().zzb(zzbjn.zzch));
            view = zzblq;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzdnu.zzbP().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzbL = zzdnu.zzbL();
                if (zzbL != null) {
                    zzbL.addView(zza3);
                }
            }
            zzdnu.zzi(zzdnu.zzn(), view, true);
        }
        zzfml<String> zzfml = zzdmv.zza;
        int size = zzfml.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzm2 = zzdnu.zzm(zzfml.get(i2));
            i2++;
            if (zzm2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzm2;
                break;
            }
        }
        this.zzh.execute(new zzdmx(this, viewGroup2));
        if (viewGroup2 != null) {
            if (!zzh(viewGroup2, true)) {
                if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgz)).booleanValue() || !zzh(viewGroup2, false)) {
                    viewGroup2.removeAllViews();
                    View zzbP = zzdnu.zzbP();
                    if (zzbP != null) {
                        context = zzbP.getContext();
                    }
                    if (context != null && (zza2 = this.zzj.zza()) != null) {
                        try {
                            IObjectWrapper zzg2 = zza2.zzg();
                            if (zzg2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzg2)) != null) {
                                ImageView imageView = new ImageView(context);
                                imageView.setImageDrawable(drawable);
                                IObjectWrapper zzo = zzdnu.zzo();
                                if (zzo != null) {
                                    if (((Boolean) zzbex.zzc().zzb(zzbjn.zzev)).booleanValue()) {
                                        imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzo));
                                        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                        viewGroup2.addView(imageView);
                                    }
                                }
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                viewGroup2.addView(imageView);
                            }
                        } catch (RemoteException unused) {
                            zzcgs.zzi("Could not get main image drawable");
                        }
                    }
                } else if (this.zzd.zzS() != null) {
                    this.zzd.zzS().zzap(new zzdmy(zzdnu, viewGroup2));
                }
            } else if (this.zzd.zzR() != null) {
                this.zzd.zzR().zzap(new zzdmy(zzdnu, viewGroup2));
            }
        }
    }
}
