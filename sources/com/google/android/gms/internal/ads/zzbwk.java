package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.helpshift.common.domain.network.NetworkConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwk implements NativeMediationAdRequest {
    public final Date zza;
    public final int zzb;
    public final Set<String> zzc;
    public final boolean zzd;
    public final Location zze;
    public final int zzf;
    public final zzblw zzg;
    public final List<String> zzh = new ArrayList();
    public final boolean zzi;
    public final Map<String, Boolean> zzj = new HashMap();
    public final String zzk;

    public zzbwk(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzblw zzblw, List<String> list, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = zzblw;
        this.zzi = z2;
        this.zzk = str;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(CertificateUtil.DELIMITER, 3);
                    if (split.length == 3) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(split[2])) {
                            this.zzj.put(split[1], Boolean.TRUE);
                        } else if ("false".equals(split[2])) {
                            this.zzj.put(split[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(next);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzbhv.zza().zzd();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    public final NativeAdOptions getNativeAdOptions() {
        zzblw zzblw = this.zzg;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzblw == null) {
            return builder.build();
        }
        int i = zzblw.zza;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzblw.zzg);
                    builder.setMediaAspectRatio(zzblw.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzblw.zzb);
                builder.setImageOrientation(zzblw.zzc);
                builder.setRequestMultipleImages(zzblw.zzd);
                return builder.build();
            }
            zzbiv zzbiv = zzblw.zzf;
            if (zzbiv != null) {
                builder.setVideoOptions(new VideoOptions(zzbiv));
            }
        }
        builder.setAdChoicesPlacement(zzblw.zze);
        builder.setReturnUrlsForImageAssets(zzblw.zzb);
        builder.setImageOrientation(zzblw.zzc);
        builder.setRequestMultipleImages(zzblw.zzd);
        return builder.build();
    }

    @NonNull
    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzblw.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        return zzbhv.zza().zzf();
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final boolean zza() {
        return this.zzh.contains(NetworkConstants.apiVersion);
    }

    public final Map<String, Boolean> zzb() {
        return this.zzj;
    }
}
