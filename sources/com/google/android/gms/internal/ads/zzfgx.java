package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgx {
    public static zzfik zza(Context context, int i, zzhl zzhl, String str, String str2, String str3, zzfgn zzfgn) {
        return new zzfgw(context, 1, zzhl, str, str2, AppEventsConstants.EVENT_PARAM_VALUE_YES, zzfgn).zza(50000);
    }
}
