package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzasj implements zzasn, zzasm {
    public final Uri zza;
    public final zzatu zzb;
    public final zzapn zzc;
    public final int zzd;
    public final Handler zze;
    public final zzasi zzf;
    public final zzant zzg = new zzant();
    public final int zzh;
    public zzasm zzi;
    public zzanv zzj;
    public boolean zzk;

    public zzasj(Uri uri, zzatu zzatu, zzapn zzapn, int i, Handler handler, zzasi zzasi, String str, int i2) {
        this.zza = uri;
        this.zzb = zzatu;
        this.zzc = zzapn;
        this.zzd = i;
        this.zze = handler;
        this.zzf = zzasi;
        this.zzh = i2;
    }

    public final void zza(zzana zzana, boolean z, zzasm zzasm) {
        this.zzi = zzasm;
        zzata zzata = new zzata(-9223372036854775807L, false);
        this.zzj = zzata;
        zzasm.zzi(zzata, (Object) null);
    }

    public final void zzb() throws IOException {
    }

    public final void zzc(zzasl zzasl) {
        ((zzash) zzasl).zzd();
    }

    public final void zzd() {
        this.zzi = null;
    }

    public final zzasl zze(int i, zzaty zzaty) {
        zzaul.zza(i == 0);
        return new zzash(this.zza, this.zzb.zza(), this.zzc.zza(), this.zzd, this.zze, this.zzf, this, zzaty, (String) null, this.zzh, (byte[]) null);
    }

    public final void zzi(zzanv zzanv, Object obj) {
        zzant zzant = this.zzg;
        boolean z = false;
        zzanv.zzd(0, zzant, false);
        if (zzant.zzc != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzk || z) {
            this.zzj = zzanv;
            this.zzk = z;
            this.zzi.zzi(zzanv, (Object) null);
        }
    }
}
