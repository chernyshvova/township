package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import androidx.annotation.Nullable;
import com.google.android.gms.drive.DriveFile;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcog extends MutableContextWrapper {
    @Nullable
    public Activity zza;
    public Context zzb;
    public Context zzc;

    public zzcog(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.zzc.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.zzb = context.getApplicationContext();
        this.zza = context instanceof Activity ? (Activity) context : null;
        this.zzc = context;
        super.setBaseContext(this.zzb);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zza;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        this.zzb.startActivity(intent);
    }

    @Nullable
    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzc;
    }
}
