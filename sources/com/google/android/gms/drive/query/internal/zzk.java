package com.google.android.gms.drive.query.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public final class zzk implements zzj<Boolean> {
    public Boolean zzmm = Boolean.FALSE;

    public static boolean zza(@Nullable Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzk())).booleanValue();
    }

    public final /* synthetic */ Object zzbj() {
        return this.zzmm;
    }

    public final /* synthetic */ Object zzbk() {
        return this.zzmm;
    }

    public final /* synthetic */ Object zzc(MetadataField metadataField, Object obj) {
        return this.zzmm;
    }

    public final /* synthetic */ Object zze(MetadataField metadataField) {
        return this.zzmm;
    }

    public final /* synthetic */ Object zzi(String str) {
        if (!str.isEmpty()) {
            this.zzmm = Boolean.TRUE;
        }
        return this.zzmm;
    }

    public final /* synthetic */ Object zza(zzx zzx, List list) {
        return this.zzmm;
    }

    public final /* synthetic */ Object zza(Object obj) {
        return this.zzmm;
    }

    public final /* synthetic */ Object zza(zzb zzb, Object obj) {
        return this.zzmm;
    }

    public final /* synthetic */ Object zza(zzx zzx, MetadataField metadataField, Object obj) {
        return this.zzmm;
    }
}
