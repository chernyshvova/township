package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdl {
    public Bundle zza = new Bundle();
    public List<String> zzb = new ArrayList();
    public boolean zzc = false;
    public int zzd = -1;
    public final Bundle zze = new Bundle();
    public final Bundle zzf = new Bundle();
    public final List<String> zzg = new ArrayList();
    public int zzh = -1;
    public String zzi = null;
    public final List<String> zzj = new ArrayList();
    public int zzk = 60000;

    public final zzbdk zza() {
        return new zzbdk(8, -1, this.zza, -1, this.zzb, this.zzc, this.zzd, false, (String) null, (zzbir) null, (Location) null, (String) null, this.zze, this.zzf, this.zzg, (String) null, (String) null, false, (zzbdb) null, this.zzh, this.zzi, this.zzj, this.zzk, (String) null);
    }

    public final zzbdl zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzbdl zzc(List<String> list) {
        this.zzb = list;
        return this;
    }

    public final zzbdl zzd(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzbdl zze(int i) {
        this.zzd = i;
        return this;
    }

    public final zzbdl zzf(int i) {
        this.zzh = i;
        return this;
    }

    public final zzbdl zzg(String str) {
        this.zzi = str;
        return this;
    }

    public final zzbdl zzh(int i) {
        this.zzk = i;
        return this;
    }
}
