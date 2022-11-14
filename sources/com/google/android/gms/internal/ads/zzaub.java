package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzaub extends IOException {
    public final zzatx zza;

    public zzaub(IOException iOException, zzatx zzatx, int i) {
        super(iOException);
        this.zza = zzatx;
    }

    public zzaub(String str, zzatx zzatx, int i) {
        super(str);
        this.zza = zzatx;
    }

    public zzaub(String str, IOException iOException, zzatx zzatx, int i) {
        super(str, iOException);
        this.zza = zzatx;
    }
}
