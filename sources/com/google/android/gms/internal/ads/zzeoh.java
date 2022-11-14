package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeoh implements zzeqp<zzeoi> {
    public final zzfqo zza;
    @Nullable
    public final ViewGroup zzb;
    public final Context zzc;
    public final Set<String> zzd;

    public zzeoh(zzfqo zzfqo, @Nullable ViewGroup viewGroup, Context context, Set<String> set) {
        this.zza = zzfqo;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final zzfqn<zzeoi> zza() {
        return this.zza.zzb(new zzeog(this));
    }

    public final /* synthetic */ zzeoi zzb() throws Exception {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeh)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzeoi(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        Boolean bool = null;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzei)).booleanValue() && this.zzd.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolean z = false;
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    bool = Boolean.TRUE;
                }
                return new zzeoi(bool);
            }
        }
        return new zzeoi((Boolean) null);
    }
}
