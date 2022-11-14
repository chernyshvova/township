package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgs;
import com.unity3d.services.banners.UnityBannerSize;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    @RecentlyNonNull
    public static final AdSize BANNER = new AdSize(UnityBannerSize.BannerSize.STANDARD_WIDTH, 50, "320x50_mb");
    @RecentlyNonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    @RecentlyNonNull
    public static final AdSize FULL_BANNER = new AdSize(UnityBannerSize.BannerSize.IAB_STANDARD_WIDTH, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    @RecentlyNonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    @RecentlyNonNull
    public static final AdSize LARGE_BANNER = new AdSize(UnityBannerSize.BannerSize.STANDARD_WIDTH, 100, "320x100_as");
    @RecentlyNonNull
    public static final AdSize LEADERBOARD = new AdSize(UnityBannerSize.BannerSize.LEADERBOARD_WIDTH, 90, "728x90_as");
    @RecentlyNonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    @RecentlyNonNull
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    @RecentlyNonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    @RecentlyNonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(DrawerLayout.PEEK_DELAY, 600, "160x600_as");
    @RecentlyNonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");
    public final int zzb;
    public final int zzc;
    public final String zzd;
    public boolean zze;
    public boolean zzf;
    public int zzg;
    public boolean zzh;
    public int zzi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L_0x0006
            java.lang.String r0 = "FULL"
            goto L_0x000a
        L_0x0006:
            java.lang.String r0 = java.lang.String.valueOf(r6)
        L_0x000a:
            r1 = -2
            if (r7 != r1) goto L_0x0010
            java.lang.String r1 = "AUTO"
            goto L_0x0014
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r7)
        L_0x0014:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = r2 + 4
            int r2 = r2 + r3
            r4.<init>(r2)
            java.lang.String r2 = "x"
            java.lang.String r3 = "_as"
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline20(r4, r0, r2, r1, r3)
            r5.<init>(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    @RecentlyNonNull
    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i) {
        AdSize zzh2 = zzcgl.zzh(context, i, 50, 0);
        zzh2.zze = true;
        return zzh2;
    }

    @RecentlyNonNull
    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i) {
        int zzj = zzcgl.zzj(context, 0);
        if (zzj == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzg = zzj;
        adSize.zzf = true;
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getCurrentOrientationInterscrollerAdSize(@RecentlyNonNull Context context, int i) {
        return zzj(i, zzcgl.zzj(context, 0));
    }

    @RecentlyNonNull
    public static AdSize getInlineAdaptiveBannerAdSize(int i, int i2) {
        AdSize adSize = new AdSize(i, 0);
        adSize.zzg = i2;
        adSize.zzf = true;
        if (i2 < 32) {
            StringBuilder sb = new StringBuilder(129);
            sb.append("The maximum height set for the inline adaptive ad size was ");
            sb.append(i2);
            sb.append(" dp, which is below the minimum recommended value of 32 dp.");
            zzcgs.zzi(sb.toString());
        }
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i) {
        AdSize zzh2 = zzcgl.zzh(context, i, 50, 2);
        zzh2.zze = true;
        return zzh2;
    }

    @RecentlyNonNull
    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i) {
        int zzj = zzcgl.zzj(context, 2);
        AdSize adSize = new AdSize(i, 0);
        if (zzj == -1) {
            return INVALID;
        }
        adSize.zzg = zzj;
        adSize.zzf = true;
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getLandscapeInterscrollerAdSize(@RecentlyNonNull Context context, int i) {
        return zzj(i, zzcgl.zzj(context, 2));
    }

    @RecentlyNonNull
    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i) {
        AdSize zzh2 = zzcgl.zzh(context, i, 50, 1);
        zzh2.zze = true;
        return zzh2;
    }

    @RecentlyNonNull
    public static AdSize getPortraitInlineAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i) {
        int zzj = zzcgl.zzj(context, 1);
        AdSize adSize = new AdSize(i, 0);
        if (zzj == -1) {
            return INVALID;
        }
        adSize.zzg = zzj;
        adSize.zzf = true;
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getPortraitInterscrollerAdSize(@RecentlyNonNull Context context, int i) {
        return zzj(i, zzcgl.zzj(context, 1));
    }

    public static AdSize zzj(int i, int i2) {
        if (i2 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzi = i2;
        adSize.zzh = true;
        return adSize;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(@RecentlyNonNull Context context) {
        int i = this.zzc;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzbdp.zza(context.getResources().getDisplayMetrics());
        }
        zzbev.zza();
        return zzcgl.zzs(context, this.zzc);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(@RecentlyNonNull Context context) {
        int i = this.zzb;
        if (i == -3) {
            return -1;
        }
        if (i != -1) {
            zzbev.zza();
            return zzcgl.zzs(context, this.zzb);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzbdp> creator = zzbdp.CREATOR;
        return displayMetrics.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    @RecentlyNonNull
    public String toString() {
        return this.zzd;
    }

    public final boolean zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final void zzc(boolean z) {
        this.zzf = true;
    }

    public final void zzd(int i) {
        this.zzg = i;
    }

    public final int zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final void zzg(boolean z) {
        this.zzh = true;
    }

    public final int zzh() {
        return this.zzi;
    }

    public final void zzi(int i) {
        this.zzi = i;
    }

    public AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(37, "Invalid width for AdSize: ", i));
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.zzb = i;
            this.zzc = i2;
            this.zzd = str;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(38, "Invalid height for AdSize: ", i2));
        }
    }
}
