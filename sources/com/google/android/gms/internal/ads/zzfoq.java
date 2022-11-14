package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoq implements FilenameFilter {
    public final Pattern zza;

    public zzfoq(Pattern pattern) {
        if (pattern != null) {
            this.zza = pattern;
            return;
        }
        throw null;
    }

    public final boolean accept(@CheckForNull File file, String str) {
        return this.zza.matcher(str).matches();
    }
}
