package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzblq extends RelativeLayout {
    public static final float[] zza = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    public AnimationDrawable zzb;

    public zzblq(Context context, zzblp zzblp, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzblp);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zza, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zzblp.zze());
        setLayoutParams(layoutParams);
        zzs.zze();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzblp.zzb())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzblp.zzb());
            textView.setTextColor(zzblp.zzf());
            textView.setTextSize((float) zzblp.zzg());
            zzbev.zza();
            int zzs = zzcgl.zzs(context, 4);
            zzbev.zza();
            textView.setPadding(zzs, 0, zzcgl.zzs(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzbls> zzd = zzblp.zzd();
        if (zzd != null && zzd.size() > 1) {
            this.zzb = new AnimationDrawable();
            for (zzbls zzb2 : zzd) {
                try {
                    this.zzb.addFrame((Drawable) ObjectWrapper.unwrap(zzb2.zzb()), zzblp.zzh());
                } catch (Exception e) {
                    zzcgs.zzg("Error while getting drawable.", e);
                }
            }
            zzs.zze();
            imageView.setBackground(this.zzb);
        } else if (zzd.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zzd.get(0).zzb()));
            } catch (Exception e2) {
                zzcgs.zzg("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzb;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
