package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

public final class zzi {
    public static MetadataField<?> zza(MetadataBundle metadataBundle) {
        Set<MetadataField<?>> zzbg = metadataBundle.zzbg();
        if (zzbg.size() == 1) {
            return zzbg.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
