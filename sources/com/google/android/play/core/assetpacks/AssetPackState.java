package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.android.billingclient.api.zzam;

public abstract class AssetPackState {
    /* renamed from: a */
    public static AssetPackState m2820a(Bundle bundle, String str, C2218bz bzVar, C2195az azVar) {
        double doubleValue;
        int a = azVar.mo33173a(bundle.getInt(zzam.m20a("status", str)), str);
        int i = bundle.getInt(zzam.m20a("error_code", str));
        long j = bundle.getLong(zzam.m20a("bytes_downloaded", str));
        long j2 = bundle.getLong(zzam.m20a("total_bytes_to_download", str));
        synchronized (bzVar) {
            Double d = bzVar.f3047a.get(str);
            doubleValue = d == null ? RoundRectDrawableWithShadow.COS_45 : d.doubleValue();
        }
        long j3 = bundle.getLong(zzam.m20a("pack_version", str));
        long j4 = bundle.getLong(zzam.m20a("pack_base_version", str));
        return m2821a(str, a, i, j, j2, doubleValue, (a != 4 || j4 == 0 || j4 == j3) ? 1 : 2);
    }

    /* renamed from: a */
    public static AssetPackState m2821a(@NonNull String str, int i, int i2, long j, long j2, double d, int i3) {
        return new C2203bh(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3);
    }
}
