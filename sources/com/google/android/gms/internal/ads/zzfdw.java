package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdw {
    public final zzeha zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final Context zze;
    public final zzeyr zzf;
    public final Clock zzg;
    public final zzfb zzh;

    public zzfdw(zzeha zzeha, zzcgy zzcgy, String str, String str2, Context context, @Nullable zzeyr zzeyr, Clock clock, zzfb zzfb) {
        this.zza = zzeha;
        this.zzb = zzcgy.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzeyr;
        this.zzg = clock;
        this.zzh = zzfb;
    }

    public static final List<String> zzd(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String zze2 : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append("2.");
            sb.append(i2);
            arrayList.add(zze(zze2, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    public static String zze(String str, String str2, @Nullable String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    public static String zzf(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzcgr.zzj()) ? str : "fakeForAdDebugLog";
    }

    public final List<String> zza(zzeyq zzeyq, zzeye zzeye, List<String> list) {
        return zzb(zzeyq, zzeye, false, "", "", list);
    }

    public final List<String> zzb(zzeyq zzeyq, @Nullable zzeye zzeye, boolean z, String str, @Nullable String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        for (String zze2 : list) {
            String zze3 = zze(zze(zze(zze2, "@gw_adlocid@", zzeyq.zza.zza.zzf), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzb);
            if (zzeye != null) {
                zze3 = zzcfd.zza(zze(zze(zze(zze3, "@gw_qdata@", zzeye.zzy), "@gw_adnetid@", zzeye.zzx), "@gw_allocid@", zzeye.zzw), this.zze, zzeye.zzR);
            }
            String zze4 = zze(zze(zze(zze3, "@gw_adnetstatus@", this.zza.zzb()), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z2 = false;
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbW)).booleanValue() && !TextUtils.isEmpty(str)) {
                z2 = true;
            }
            boolean z3 = !TextUtils.isEmpty(str2);
            if (!z2) {
                if (z3) {
                    z3 = true;
                } else {
                    arrayList.add(zze4);
                }
            }
            if (this.zzh.zza(Uri.parse(zze4))) {
                Uri.Builder buildUpon = Uri.parse(zze4).buildUpon();
                if (z2) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zze4 = buildUpon.build().toString();
            }
            arrayList.add(zze4);
        }
        return arrayList;
    }

    public final List<String> zzc(zzeye zzeye, List<String> list, zzcca zzcca) {
        String str;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzg.currentTimeMillis();
        try {
            String zzb2 = zzcca.zzb();
            String num = Integer.toString(zzcca.zzc());
            zzeyr zzeyr = this.zzf;
            String str2 = "";
            if (zzeyr == null) {
                str = str2;
            } else {
                str = zzf(zzeyr.zza);
            }
            zzeyr zzeyr2 = this.zzf;
            if (zzeyr2 != null) {
                str2 = zzf(zzeyr2.zzb);
            }
            for (String zze2 : list) {
                arrayList.add(zzcfd.zza(zze(zze(zze(zze(zze(zze(zze2, "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(zzb2)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzb), this.zze, zzeye.zzR));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzcgs.zzg("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
