package com.google.android.gms.drive;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@Deprecated
public final class zzn extends ExecutionOptions {
    public boolean zzat;

    public zzn(@Nullable String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.zzat = z2;
    }

    public static zzn zza(@Nullable ExecutionOptions executionOptions) {
        zzp zzp = new zzp();
        if (executionOptions != null) {
            zzp.setConflictStrategy(executionOptions.zzn());
            zzp.setNotifyOnCompletion(executionOptions.zzm());
            String zzl = executionOptions.zzl();
            if (zzl != null) {
                zzp.setTrackingTag(zzl);
            }
        }
        return (zzn) zzp.build();
    }

    public final boolean zzp() {
        return this.zzat;
    }
}
