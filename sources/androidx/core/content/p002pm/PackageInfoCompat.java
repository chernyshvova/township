package androidx.core.content.p002pm;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;

/* renamed from: androidx.core.content.pm.PackageInfoCompat */
public final class PackageInfoCompat {
    public static long getLongVersionCode(@NonNull PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }
}
