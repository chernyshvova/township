package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.LegacyTokenHelper;
import com.google.android.gms.common.C1632R;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class StringResourceValueReader {
    public final Resources zza;
    public final String zzb;

    public StringResourceValueReader(@RecentlyNonNull Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(C1632R.string.common_google_play_services_unknown_issue);
    }

    @KeepForSdk
    @RecentlyNullable
    public String getString(@RecentlyNonNull String str) {
        int identifier = this.zza.getIdentifier(str, LegacyTokenHelper.TYPE_STRING, this.zzb);
        if (identifier == 0) {
            return null;
        }
        return this.zza.getString(identifier);
    }
}
