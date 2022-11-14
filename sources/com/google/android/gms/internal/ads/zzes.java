package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzes implements zzfim {
    public final /* synthetic */ zzfgj zza;

    public zzes(zzeu zzeu, zzfgj zzfgj) {
        this.zza = zzfgj;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
