package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzcy implements zzcx {
    @GuardedBy("GservicesLoader.class")
    public static zzcy zza;
    @Nullable
    public final Context zzb;
    @Nullable
    public final ContentObserver zzc;

    public zzcy(Context context) {
        this.zzb = context;
        this.zzc = new zzda(this, (Handler) null);
        context.getContentResolver().registerContentObserver(zzcp.zza, true, this.zzc);
    }

    public static zzcy zza(Context context) {
        zzcy zzcy;
        synchronized (zzcy.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcy(context) : new zzcy();
            }
            zzcy = zza;
        }
        return zzcy;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcw.zza(new zzdb(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    public final /* synthetic */ String zzb(String str) {
        return zzcp.zza(this.zzb.getContentResolver(), str, (String) null);
    }

    public zzcy() {
        this.zzb = null;
        this.zzc = null;
    }

    public static synchronized void zza() {
        synchronized (zzcy.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }
}
