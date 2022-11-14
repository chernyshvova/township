package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzayg> CREATOR = new zzayh();
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", mo17147id = 2)
    @Nullable
    public ParcelFileDescriptor zza;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "hasAdditionalMetadataFromReadV2", mo17147id = 3)
    public final boolean zzb;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isDownloaded", mo17147id = 4)
    public final boolean zzc;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getCachedBytes", mo17147id = 5)
    public final long zzd;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isGcacheHit", mo17147id = 6)
    public final boolean zze;

    public zzayg() {
        this((ParcelFileDescriptor) null, false, false, 0, false);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzc(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, zzd());
        SafeParcelWriter.writeBoolean(parcel, 4, zze());
        SafeParcelWriter.writeLong(parcel, 5, zzf());
        SafeParcelWriter.writeBoolean(parcel, 6, zzg());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final synchronized boolean zza() {
        return this.zza != null;
    }

    @Nullable
    public final synchronized InputStream zzb() {
        ParcelFileDescriptor parcelFileDescriptor = this.zza;
        if (parcelFileDescriptor == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        this.zza = null;
        return autoCloseInputStream;
    }

    public final synchronized ParcelFileDescriptor zzc() {
        return this.zza;
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized boolean zze() {
        return this.zzc;
    }

    public final synchronized long zzf() {
        return this.zzd;
    }

    public final synchronized boolean zzg() {
        return this.zze;
    }

    @SafeParcelable.Constructor
    public zzayg(@SafeParcelable.Param(mo17150id = 2) @Nullable ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo17150id = 3) boolean z, @SafeParcelable.Param(mo17150id = 4) boolean z2, @SafeParcelable.Param(mo17150id = 5) long j, @SafeParcelable.Param(mo17150id = 6) boolean z3) {
        this.zza = parcelFileDescriptor;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = z3;
    }
}
