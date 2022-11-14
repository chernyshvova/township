package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmm;
import com.google.android.gms.internal.ads.zzcgs;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class NativeAdView extends FrameLayout {
    @NotOnlyInitialized
    public final FrameLayout zza;
    @NotOnlyInitialized
    @Nullable
    public final zzbmm zzb = zzf();

    public NativeAdView(@RecentlyNonNull Context context) {
        super(context);
        this.zza = zze(context);
    }

    private final void zzd(String str, @Nullable View view) {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                zzbmm.zzb(str, ObjectWrapper.wrap(view));
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call setAssetView on delegate", e);
            }
        }
    }

    private final FrameLayout zze(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    @RequiresNonNull({"overlayFrame"})
    @Nullable
    private final zzbmm zzf() {
        if (isInEditMode()) {
            return null;
        }
        return zzbev.zzb().zzd(this.zza.getContext(), this, this.zza);
    }

    public final void addView(@RecentlyNonNull View view, int i, @RecentlyNonNull ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zza);
    }

    public final void bringChildToFront(@RecentlyNonNull View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zza;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                zzbmm.zze();
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to destroy native ad view", e);
            }
        }
    }

    public final boolean dispatchTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        zzbmm zzbmm;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbU)).booleanValue() && (zzbmm = this.zzb) != null) {
            try {
                zzbmm.zzbN(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @RecentlyNullable
    public AdChoicesView getAdChoicesView() {
        View zza2 = zza("3011");
        if (zza2 instanceof AdChoicesView) {
            return (AdChoicesView) zza2;
        }
        return null;
    }

    @RecentlyNullable
    public final View getAdvertiserView() {
        return zza("3005");
    }

    @RecentlyNullable
    public final View getBodyView() {
        return zza("3004");
    }

    @RecentlyNullable
    public final View getCallToActionView() {
        return zza("3002");
    }

    @RecentlyNullable
    public final View getHeadlineView() {
        return zza("3001");
    }

    @RecentlyNullable
    public final View getIconView() {
        return zza("3003");
    }

    @RecentlyNullable
    public final View getImageView() {
        return zza("3008");
    }

    @RecentlyNullable
    public final MediaView getMediaView() {
        View zza2 = zza("3010");
        if (zza2 instanceof MediaView) {
            return (MediaView) zza2;
        }
        if (zza2 == null) {
            return null;
        }
        zzcgs.zzd("View is not an instance of MediaView");
        return null;
    }

    @RecentlyNullable
    public final View getPriceView() {
        return zza("3007");
    }

    @RecentlyNullable
    public final View getStarRatingView() {
        return zza("3009");
    }

    @RecentlyNullable
    public final View getStoreView() {
        return zza("3006");
    }

    public final void onVisibilityChanged(@RecentlyNonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                zzbmm.zzf(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zza);
    }

    public final void removeView(@RecentlyNonNull View view) {
        if (this.zza != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(@Nullable AdChoicesView adChoicesView) {
        zzd("3011", adChoicesView);
    }

    public final void setAdvertiserView(@Nullable View view) {
        zzd("3005", view);
    }

    public final void setBodyView(@Nullable View view) {
        zzd("3004", view);
    }

    public final void setCallToActionView(@Nullable View view) {
        zzd("3002", view);
    }

    public final void setClickConfirmingView(@Nullable View view) {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                zzbmm.zzg(ObjectWrapper.wrap(view));
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call setClickConfirmingView on delegate", e);
            }
        }
    }

    public final void setHeadlineView(@Nullable View view) {
        zzd("3001", view);
    }

    public final void setIconView(@Nullable View view) {
        zzd("3003", view);
    }

    public final void setImageView(@Nullable View view) {
        zzd("3008", view);
    }

    public final void setMediaView(@Nullable MediaView mediaView) {
        zzd("3010", mediaView);
        if (mediaView != null) {
            mediaView.zza(new zzb(this));
            mediaView.zzb(new zzc(this));
        }
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@RecentlyNonNull NativeAd nativeAd) {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                zzbmm.zzd(nativeAd.zza());
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void setPriceView(@Nullable View view) {
        zzd("3007", view);
    }

    public final void setStarRatingView(@Nullable View view) {
        zzd("3009", view);
    }

    public final void setStoreView(@Nullable View view) {
        zzd("3006", view);
    }

    @RecentlyNullable
    public final View zza(@RecentlyNonNull String str) {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                IObjectWrapper zzc = zzbmm.zzc(str);
                if (zzc != null) {
                    return (View) ObjectWrapper.unwrap(zzc);
                }
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call getAssetView on delegate", e);
            }
        }
        return null;
    }

    public final /* synthetic */ void zzb(ImageView.ScaleType scaleType) {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null && scaleType != null) {
            try {
                zzbmm.zzbM(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    public final /* synthetic */ void zzc(MediaContent mediaContent) {
        zzbmm zzbmm = this.zzb;
        if (zzbmm != null) {
            try {
                if (mediaContent instanceof zzbhz) {
                    zzbmm.zzbO(((zzbhz) mediaContent).zza());
                } else if (mediaContent == null) {
                    zzbmm.zzbO((zzbmf) null);
                } else {
                    zzcgs.zzd("Use MediaContent provided by NativeAd.getMediaContent");
                }
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call setMediaContent on delegate", e);
            }
        }
    }

    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = zze(context);
    }

    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zza = zze(context);
    }

    @TargetApi(21)
    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zza = zze(context);
    }
}
