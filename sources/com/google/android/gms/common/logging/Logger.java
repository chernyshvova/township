package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class Logger {
    public final String zza;
    public final String zzb;
    public final GmsLogger zzc;
    public final int zzd;

    @KeepForSdk
    public Logger(@RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.zzb = str2;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo17259d(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr), th);
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo17261e(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        Log.e(this.zza, format(str, objArr), th);
    }

    @RecentlyNonNull
    @KeepForSdk
    public String format(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getTag() {
        return this.zza;
    }

    @KeepForSdk
    /* renamed from: i */
    public void mo17265i(@RecentlyNonNull String str, @Nullable Object... objArr) {
        Log.i(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo17267v(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void mo17269w(@RecentlyNonNull String str, @Nullable Object... objArr) {
        Log.w(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo17262e(@RecentlyNonNull String str, @Nullable Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(@RecentlyNonNull Throwable th) {
        Log.wtf(this.zza, th);
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo17260d(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo17268v(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }
}
