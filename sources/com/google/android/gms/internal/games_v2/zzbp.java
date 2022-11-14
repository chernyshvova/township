package com.google.android.gms.internal.games_v2;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzbp {
    @Nullable
    public final String zza;
    public final Status zzb;

    public zzbp(Status status, @Nullable String str) {
        this.zzb = status;
        this.zza = str;
    }

    public static zzbp zzb(Status status) {
        Preconditions.checkArgument(!status.isSuccess());
        return new zzbp(status, (String) null);
    }

    public static zzbp zzc(String str) {
        return new zzbp(Status.RESULT_SUCCESS, str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbp)) {
            return false;
        }
        zzbp zzbp = (zzbp) obj;
        return Objects.equal(this.zzb, zzbp.zzb) && Objects.equal(this.zza, zzbp.zza);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("status", this.zzb).add("gameRunToken", this.zza).toString();
    }

    @Nullable
    public final PendingIntent zza() {
        return this.zzb.getResolution();
    }

    @Nullable
    public final String zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzb.isSuccess();
    }
}
