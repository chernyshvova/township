package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class zzdr implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final zzdo zza;

    public zzdr(zzdo zzdo) {
        this.zza = zzdo;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
