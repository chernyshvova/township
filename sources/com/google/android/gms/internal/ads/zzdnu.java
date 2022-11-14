package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public interface zzdnu extends View.OnClickListener, View.OnTouchListener {
    FrameLayout zzbL();

    View zzbP();

    zzawa zzh();

    void zzi(String str, View view, boolean z);

    Map<String, WeakReference<View>> zzj();

    Map<String, WeakReference<View>> zzk();

    Map<String, WeakReference<View>> zzl();

    View zzm(String str);

    String zzn();

    IObjectWrapper zzo();

    JSONObject zzp();

    JSONObject zzq();
}
