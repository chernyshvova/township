package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzblv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MediaView extends FrameLayout {
    public MediaContent zza;
    public boolean zzb;
    public zzblt zzc;
    public ImageView.ScaleType zzd;
    public boolean zze;
    public zzblv zzf;

    public MediaView(@RecentlyNonNull Context context) {
        super(context);
    }

    public void setImageScaleType(@RecentlyNonNull ImageView.ScaleType scaleType) {
        this.zze = true;
        this.zzd = scaleType;
        zzblv zzblv = this.zzf;
        if (zzblv != null) {
            zzblv.zza(scaleType);
        }
    }

    public void setMediaContent(@RecentlyNonNull MediaContent mediaContent) {
        this.zzb = true;
        this.zza = mediaContent;
        zzblt zzblt = this.zzc;
        if (zzblt != null) {
            zzblt.zza(mediaContent);
        }
    }

    public final synchronized void zza(zzblt zzblt) {
        this.zzc = zzblt;
        if (this.zzb) {
            zzblt.zza(this.zza);
        }
    }

    public final synchronized void zzb(zzblv zzblv) {
        this.zzf = zzblv;
        if (this.zze) {
            zzblv.zza(this.zzd);
        }
    }

    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
