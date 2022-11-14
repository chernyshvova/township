package com.google.android.gms.drive.metadata.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFolder;
import java.util.Locale;

public final class zzk {
    public String zzji;

    public zzk(String str) {
        this.zzji = str.toLowerCase(Locale.US);
    }

    @Nullable
    public static zzk zzg(@Nullable String str) {
        Preconditions.checkArgument(str == null || !str.isEmpty());
        if (str == null) {
            return null;
        }
        return new zzk(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != zzk.class) {
            return false;
        }
        return this.zzji.equals(((zzk) obj).zzji);
    }

    public final int hashCode() {
        return this.zzji.hashCode();
    }

    public final boolean isFolder() {
        return this.zzji.equals(DriveFolder.MIME_TYPE);
    }

    public final String toString() {
        return this.zzji;
    }

    public final boolean zzbh() {
        return this.zzji.startsWith("application/vnd.google-apps");
    }
}
