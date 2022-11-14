package com.google.android.gms.drive;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.drive.ExecutionOptions;

@ShowFirstParty
public final class zzp extends ExecutionOptions.Builder {
    public boolean zzat = true;

    public final /* synthetic */ ExecutionOptions build() {
        zzo();
        return new zzn(this.zzaq, this.zzar, this.zzas, this.zzat);
    }

    public final /* synthetic */ ExecutionOptions.Builder setConflictStrategy(int i) {
        super.setConflictStrategy(i);
        return this;
    }

    public final /* synthetic */ ExecutionOptions.Builder setNotifyOnCompletion(boolean z) {
        super.setNotifyOnCompletion(z);
        return this;
    }

    public final /* synthetic */ ExecutionOptions.Builder setTrackingTag(String str) {
        super.setTrackingTag(str);
        return this;
    }
}
