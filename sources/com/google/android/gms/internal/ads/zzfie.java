package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfie implements zzfgq {
    public final Object zza;
    public final zzfif zzb;
    public final zzfiq zzc;
    public final zzfgn zzd;

    public zzfie(@NonNull Object obj, @NonNull zzfif zzfif, @NonNull zzfiq zzfiq, @NonNull zzfgn zzfgn) {
        this.zza = obj;
        this.zzb = zzfif;
        this.zzc = zzfiq;
        this.zzd = zzfgn;
    }

    @Nullable
    public static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzdu zza2 = zzdv.zza();
        zza2.zzc(zzdj.DG);
        zza2.zza(zzgcz.zzt(bArr));
        return Base64.encodeToString(((zzdv) zza2.zzah()).zzao(), 11);
    }

    @Nullable
    private final synchronized byte[] zzj(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzd.zzd(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zza, new Object[]{null, map2});
    }

    @Nullable
    public final synchronized String zza(Context context, String str) {
        Map<String, Object> zzb2;
        zzb2 = this.zzc.zzb();
        zzb2.put("f", "q");
        zzb2.put("ctx", context);
        zzb2.put(AttributionIdentifiers.ATTRIBUTION_ID_COLUMN_NAME, (Object) null);
        return zzi(zzj((Map<String, String>) null, zzb2));
    }

    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzc2;
        zzc2 = this.zzc.zzc();
        zzc2.put("f", MetadataRule.FIELD_V);
        zzc2.put("ctx", context);
        zzc2.put(AttributionIdentifiers.ATTRIBUTION_ID_COLUMN_NAME, (Object) null);
        zzc2.put(ViewHierarchyConstants.VIEW_KEY, view);
        zzc2.put("act", (Object) null);
        return zzi(zzj((Map<String, String>) null, zzc2));
    }

    @Nullable
    public final synchronized String zzc(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzd2;
        zzd2 = this.zzc.zzd();
        zzd2.put("f", "c");
        zzd2.put("ctx", context);
        zzd2.put("cs", str2);
        zzd2.put(AttributionIdentifiers.ATTRIBUTION_ID_COLUMN_NAME, (Object) null);
        zzd2.put(ViewHierarchyConstants.VIEW_KEY, view);
        zzd2.put("act", activity);
        return zzi(zzj((Map<String, String>) null, zzd2));
    }

    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfio {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put(AttributionIdentifiers.ATTRIBUTION_ID_COLUMN_NAME, (Object) null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zza, new Object[]{hashMap});
            this.zzd.zzc(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzfio(2005, (Throwable) e);
        }
    }

    public final zzfif zze() {
        return this.zzb;
    }

    public final synchronized boolean zzf() throws zzfio {
        try {
        } catch (Exception e) {
            throw new zzfio((int) AdError.INTERNAL_ERROR_CODE, (Throwable) e);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }

    public final synchronized void zzg() throws zzfio {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzc(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzfio((int) AdError.INTERNAL_ERROR_2003, (Throwable) e);
        }
    }

    public final synchronized int zzh() throws zzfio {
        try {
        } catch (Exception e) {
            throw new zzfio((int) AdError.INTERNAL_ERROR_2006, (Throwable) e);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }
}
