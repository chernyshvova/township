package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzlg extends IOException {
    @Deprecated
    public zzlg() {
        super((String) null, (Throwable) null);
    }

    public static zzlg zza(@Nullable String str, @Nullable Throwable th) {
        return new zzlg(str, (Throwable) null, true, 1);
    }

    @Deprecated
    public zzlg(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public zzlg(@Nullable String str, @Nullable Throwable th, boolean z, int i) {
        super(str, (Throwable) null);
    }
}
