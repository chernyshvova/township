package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzt extends zza<String> {
    public zzt(String str, int i) {
        super(str, i);
    }

    public final /* synthetic */ void zza(Bundle bundle, Object obj) {
        bundle.putString(getName(), (String) obj);
    }

    public final /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.getString(getName());
    }

    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return dataHolder.getString(getName(), i, i2);
    }
}
