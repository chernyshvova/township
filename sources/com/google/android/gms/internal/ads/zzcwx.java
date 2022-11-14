package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.view.ViewCompat;
import com.facebook.AuthenticationToken;
import com.google.android.gms.ads.internal.zzs;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcwx extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    public final Context zza;
    public View zzb;

    public zzcwx(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcwx zza(Context context, View view, zzeye zzeye) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcwx zzcwx = new zzcwx(context);
        if (!(zzeye.zzu.isEmpty() || (resources = zzcwx.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzeyf zzeyf = zzeye.zzu.get(0);
            float f = displayMetrics.density;
            zzcwx.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzeyf.zza) * f), (int) (((float) zzeyf.zzb) * f)));
        }
        zzcwx.zzb = view;
        zzcwx.addView(view);
        zzs.zzz();
        zzchr.zzb(zzcwx, zzcwx);
        zzs.zzz();
        zzchr.zza(zzcwx, zzcwx);
        JSONObject jSONObject = zzeye.zzad;
        RelativeLayout relativeLayout = new RelativeLayout(zzcwx.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject(AuthenticationToken.HEADER_KEY);
        if (optJSONObject != null) {
            zzcwx.zzb(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcwx.zzb(optJSONObject2, relativeLayout, 12);
        }
        zzcwx.addView(relativeLayout);
        return zzcwx;
    }

    private final void zzb(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzc = zzc(jSONObject.optDouble("padding", RoundRectDrawableWithShadow.COS_45));
        textView.setPadding(0, zzc, 0, zzc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzc(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzc(double d) {
        zzbev.zza();
        return zzcgl.zzs(this.zza, (int) d);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
