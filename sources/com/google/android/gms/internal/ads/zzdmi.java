package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public interface zzdmi {
    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void zzb(View view, Map<String, WeakReference<View>> map);

    void zzc(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zzd(String str);

    void zze(Bundle bundle);

    void zzf(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zzg();

    boolean zzh();

    void zzj(@Nullable View view, MotionEvent motionEvent, View view2);

    void zzk(Bundle bundle);

    JSONObject zzl(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    JSONObject zzm(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zzn();

    void zzo(View view);

    void zzp(zzboc zzboc);

    void zzq();

    void zzr(@Nullable zzbgq zzbgq);

    void zzs(zzbgm zzbgm);

    void zzt();

    void zzu(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zzv();

    boolean zzw(Bundle bundle);

    void zzx();
}
