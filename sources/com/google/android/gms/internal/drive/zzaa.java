package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzaa extends Metadata {
    public final MetadataBundle zzdt;

    public zzaa(MetadataBundle metadataBundle) {
        this.zzdt = metadataBundle;
    }

    public final /* synthetic */ Object freeze() {
        return new zzaa(this.zzdt.zzbf());
    }

    public final boolean isDataValid() {
        return this.zzdt != null;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdt);
        return GeneratedOutlineSupport.outline12(valueOf.length() + 17, "Metadata [mImpl=", valueOf, "]");
    }

    public final <T> T zza(MetadataField<T> metadataField) {
        return this.zzdt.zza(metadataField);
    }
}
