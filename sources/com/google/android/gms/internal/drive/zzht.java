package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.internal.zzb;
import java.util.Collection;

public final class zzht extends zzb {
    public zzht(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_ORLA);
    }

    /* renamed from: zze */
    public final Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger("trashed", i, i2) == 2);
    }
}
