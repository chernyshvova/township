package androidx.core.p003os;

import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;

/* renamed from: androidx.core.os.EnvironmentCompat */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    public static final String TAG = "EnvironmentCompat";

    @NonNull
    public static String getStorageState(@NonNull File file) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Environment.getExternalStorageState(file);
        }
        return Environment.getStorageState(file);
    }
}
