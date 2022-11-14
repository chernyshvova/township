package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzaim extends IOException {
    public final zzahx zza;

    public zzaim(IOException iOException, zzahx zzahx, int i) {
        super(iOException);
        this.zza = zzahx;
    }

    public zzaim(String str, zzahx zzahx, int i) {
        super(str);
        this.zza = zzahx;
    }

    public zzaim(String str, IOException iOException, zzahx zzahx, int i) {
        super(str, iOException);
        this.zza = zzahx;
    }
}
