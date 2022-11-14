package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzayj> CREATOR = new zzayk();
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public final String zza;
    @SafeParcelable.Field(mo17147id = 3)
    public final long zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public final String zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public final String zzd;
    @SafeParcelable.Field(mo17147id = 6)
    public final String zze;
    @SafeParcelable.Field(mo17147id = 7)
    public final Bundle zzf;
    @SafeParcelable.Field(mo17147id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(mo17147id = 9)
    public long zzh;
    @SafeParcelable.Field(mo17147id = 10)
    public String zzi;
    @SafeParcelable.Field(mo17147id = 11)
    public int zzj;

    @SafeParcelable.Constructor
    public zzayj(@SafeParcelable.Param(mo17150id = 2) @Nullable String str, @SafeParcelable.Param(mo17150id = 3) long j, @SafeParcelable.Param(mo17150id = 4) String str2, @SafeParcelable.Param(mo17150id = 5) String str3, @SafeParcelable.Param(mo17150id = 6) String str4, @SafeParcelable.Param(mo17150id = 7) Bundle bundle, @SafeParcelable.Param(mo17150id = 8) boolean z, @SafeParcelable.Param(mo17150id = 9) long j2, @SafeParcelable.Param(mo17150id = 10) String str5, @SafeParcelable.Param(mo17150id = 11) int i) {
        this.zza = str;
        this.zzb = j;
        this.zzc = str2 == null ? "" : str2;
        this.zzd = str3 == null ? "" : str3;
        this.zze = str4 == null ? "" : str4;
        this.zzf = bundle == null ? new Bundle() : bundle;
        this.zzg = z;
        this.zzh = j2;
        this.zzi = str5;
        this.zzj = i;
    }

    @Nullable
    public static zzayj zza(Uri uri) {
        long parseLong;
        Uri uri2 = uri;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzcgs.zzi(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri2.getQueryParameter("url");
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(uri2.getQueryParameter("read_only"));
            String queryParameter2 = uri2.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(queryParameter2);
            }
            long j = parseLong;
            Bundle bundle = new Bundle();
            for (String next : uri.getQueryParameterNames()) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri2.getQueryParameter(next));
                }
            }
            return new zzayj(queryParameter, j, host, str, str2, bundle, equals, 0, "", 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzcgs.zzj("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeString(parcel, 10, this.zzi, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
