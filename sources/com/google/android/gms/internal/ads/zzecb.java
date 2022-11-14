package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzecb {
    public final zzebx zza;
    public final zzfqo zzb;

    public zzecb(zzebx zzebx, zzfqo zzfqo) {
        this.zza = zzebx;
        this.zzb = zzfqo;
    }

    public final void zza(zzfcb<SQLiteDatabase, Void> zzfcb) {
        zzfqe.zzp(this.zzb.zzb(zzebz.zza(this.zza)), new zzeca(this, zzfcb), this.zzb);
    }
}
