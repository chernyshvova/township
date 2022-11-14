package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkp {
    public final Uri zza;
    @Nullable
    public final String zzb = null;
    @Nullable
    public final zzkm zzc = null;
    @Nullable
    public final zzki zzd = null;
    public final List zze;
    @Nullable
    public final String zzf;
    public final List zzg;
    @Nullable
    public final Object zzh;

    public /* synthetic */ zzkp(Uri uri, String str, zzkm zzkm, zzki zzki, List list, String str2, List list2, Object obj, zzkh zzkh) {
        this.zza = uri;
        this.zze = list;
        this.zzf = null;
        this.zzg = list2;
        this.zzh = null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzkp zzkp = (zzkp) obj;
        return this.zza.equals(zzkp.zza) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && this.zze.equals(zzkp.zze) && zzalh.zzc((Object) null, (Object) null) && this.zzg.equals(zzkp.zzg) && zzalh.zzc((Object) null, (Object) null);
    }

    public final int hashCode() {
        int hashCode = this.zze.hashCode();
        return (this.zzg.hashCode() + ((hashCode + (this.zza.hashCode() * 923521)) * 961)) * 31;
    }
}
