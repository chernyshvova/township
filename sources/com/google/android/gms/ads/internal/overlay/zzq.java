package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzcgl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzq extends FrameLayout implements View.OnClickListener {
    public final ImageButton zza;
    public final zzz zzb;

    public zzq(Context context, zzp zzp, @Nullable zzz zzz) {
        super(context);
        this.zzb = zzz;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        imageButton.setImageResource(17301527);
        this.zza.setBackgroundColor(0);
        this.zza.setOnClickListener(this);
        ImageButton imageButton2 = this.zza;
        zzbev.zza();
        int zzs = zzcgl.zzs(context, zzp.zza);
        zzbev.zza();
        int zzs2 = zzcgl.zzs(context, 0);
        zzbev.zza();
        int zzs3 = zzcgl.zzs(context, zzp.zzb);
        zzbev.zza();
        imageButton2.setPadding(zzs, zzs2, zzs3, zzcgl.zzs(context, zzp.zzc));
        this.zza.setContentDescription("Interstitial close button");
        ImageButton imageButton3 = this.zza;
        zzbev.zza();
        int zzs4 = zzcgl.zzs(context, zzp.zzd + zzp.zza + zzp.zzb);
        zzbev.zza();
        addView(imageButton3, new FrameLayout.LayoutParams(zzs4, zzcgl.zzs(context, zzp.zzd + zzp.zzc), 17));
    }

    public final void onClick(View view) {
        zzz zzz = this.zzb;
        if (zzz != null) {
            zzz.zzd();
        }
    }

    public final void zza(boolean z) {
        if (z) {
            this.zza.setVisibility(8);
        } else {
            this.zza.setVisibility(0);
        }
    }
}
