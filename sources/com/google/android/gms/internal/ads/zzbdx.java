package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C1619R;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdx {
    public final AdSize[] zza;
    public final String zzb;

    public zzbdx(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1619R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(C1619R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C1619R.styleable.AdsAttrs_adSizes);
        boolean z = !TextUtils.isEmpty(string);
        boolean z2 = !TextUtils.isEmpty(string2);
        if (z && !z2) {
            this.zza = zzc(string);
        } else if (!z && z2) {
            this.zza = zzc(string2);
        } else if (z) {
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            obtainAttributes.recycle();
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.zzb = obtainAttributes.getString(C1619R.styleable.AdsAttrs_adUnitId);
        obtainAttributes.recycle();
        if (TextUtils.isEmpty(this.zzb)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    public static AdSize[] zzc(String str) {
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        String[] split = str.split("\\s*,\\s*");
        int length = split.length;
        AdSize[] adSizeArr = new AdSize[length];
        for (int i3 = 0; i3 < split.length; i3++) {
            String trim = split[i3].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    if ("FULL_WIDTH".equals(split2[0])) {
                        i = -1;
                    } else {
                        i = Integer.parseInt(split2[0]);
                    }
                    if ("AUTO_HEIGHT".equals(split2[1])) {
                        i2 = -2;
                    } else {
                        i2 = Integer.parseInt(split2[1]);
                    }
                    adSizeArr[i3] = new AdSize(i, i2);
                } catch (NumberFormatException unused) {
                    if (trim.length() != 0) {
                        str4 = "Could not parse XML attribute \"adSize\": ".concat(trim);
                    } else {
                        str4 = new String("Could not parse XML attribute \"adSize\": ");
                    }
                    throw new IllegalArgumentException(str4);
                }
            } else if ("BANNER".equals(trim)) {
                adSizeArr[i3] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i3] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i3] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i3] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i3] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i3] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i3] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(trim)) {
                adSizeArr[i3] = AdSize.FLUID;
            } else if ("ICON".equals(trim)) {
                adSizeArr[i3] = AdSize.zza;
            } else {
                if (trim.length() != 0) {
                    str3 = "Could not parse XML attribute \"adSize\": ".concat(trim);
                } else {
                    str3 = new String("Could not parse XML attribute \"adSize\": ");
                }
                throw new IllegalArgumentException(str3);
            }
        }
        if (length != 0) {
            return adSizeArr;
        }
        if (str.length() != 0) {
            str2 = "Could not parse XML attribute \"adSize\": ".concat(str);
        } else {
            str2 = new String("Could not parse XML attribute \"adSize\": ");
        }
        throw new IllegalArgumentException(str2);
    }

    public final AdSize[] zza(boolean z) {
        if (z || this.zza.length == 1) {
            return this.zza;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }

    public final String zzb() {
        return this.zzb;
    }
}
