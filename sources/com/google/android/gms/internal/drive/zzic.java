package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.zzb;

public final class zzic extends zzb implements SearchableMetadataField<Boolean> {
    public zzic(String str, int i) {
        super(str, GmsVersion.VERSION_HALLOUMI);
    }

    /* renamed from: zze */
    public final Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
    }
}
