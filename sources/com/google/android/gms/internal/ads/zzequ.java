package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzequ implements zzeqo<Bundle> {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final ArrayList<String> zzh;
    public final String zzi;
    public final String zzj;
    public final String zzk;
    public final boolean zzl;
    public final String zzm;
    public final long zzn;

    public zzequ(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = z5;
        this.zzg = str2;
        this.zzh = arrayList;
        this.zzi = str3;
        this.zzj = str4;
        this.zzk = str5;
        this.zzl = z6;
        this.zzm = str6;
        this.zzn = j;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zza);
        bundle.putBoolean("coh", this.zzb);
        bundle.putString("gl", this.zzc);
        bundle.putBoolean("simulator", this.zzd);
        bundle.putBoolean("is_latchsky", this.zze);
        bundle.putBoolean("is_sidewinder", this.zzf);
        bundle.putString("hl", this.zzg);
        if (!this.zzh.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzh);
        }
        bundle.putString(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, this.zzi);
        bundle.putString("submodel", this.zzm);
        Bundle zza2 = zzezi.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        bundle.putBundle(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zza2);
        zza2.putString("build", this.zzk);
        zza2.putLong("remaining_data_partition_space", this.zzn);
        Bundle zza3 = zzezi.zza(zza2, "browser");
        zza2.putBundle("browser", zza3);
        zza3.putBoolean("is_browser_custom_tabs_capable", this.zzl);
        if (!TextUtils.isEmpty(this.zzj)) {
            Bundle zza4 = zzezi.zza(zza2, "play_store");
            zza2.putBundle("play_store", zza4);
            zza4.putString("package_version", this.zzj);
        }
    }
}
