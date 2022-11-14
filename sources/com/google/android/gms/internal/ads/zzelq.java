package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.gms.ads.internal.zzs;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzelq implements zzeqo<Bundle> {
    public final Context zza;
    public final zzbdp zzb;
    public final List<Parcelable> zzc;

    public zzelq(Context context, zzbdp zzbdp, List<Parcelable> list) {
        this.zza = context;
        this.zzb = zzbdp;
        this.zzc = list;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Bundle bundle = (Bundle) obj;
        if (zzbld.zza.zze().booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzs.zzc();
            String str = null;
            try {
                ActivityManager activityManager = (ActivityManager) this.zza.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (activityManager != null) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (!(runningTasks == null || runningTasks.isEmpty() || (runningTaskInfo = runningTasks.get(0)) == null || runningTaskInfo.topActivity == null)) {
                        str = runningTaskInfo.topActivity.getClassName();
                    }
                }
            } catch (Exception unused) {
            }
            bundle2.putString(ActivityChooserModel.ATTRIBUTE_ACTIVITY, str);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzb.zze);
            bundle3.putInt("height", this.zzb.zzb);
            bundle2.putBundle("size", bundle3);
            if (this.zzc.size() > 0) {
                List<Parcelable> list = this.zzc;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
