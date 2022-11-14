package com.microsoft.appcenter.crashes;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.FileManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WrapperSdkExceptionManager {
    @VisibleForTesting
    public static final Map<String, String> sWrapperExceptionDataContainer = new HashMap();

    public static void deleteWrapperExceptionData(UUID uuid) {
        if (uuid == null) {
            AppCenterLog.error("AppCenterCrashes", "Failed to delete wrapper exception data: null errorId");
            return;
        }
        File file = getFile(uuid);
        if (file.exists()) {
            String str = null;
            String str2 = sWrapperExceptionDataContainer.get(uuid.toString());
            if (str2 == null) {
                File file2 = getFile(uuid);
                if (file2.exists() && (str = FileManager.read(file2)) != null) {
                    sWrapperExceptionDataContainer.put(uuid.toString(), str);
                }
                str2 = str;
            }
            if (str2 == null) {
                AppCenterLog.error("AppCenterCrashes", "Failed to load wrapper exception data.");
            }
            file.delete();
        }
    }

    public static File getFile(@NonNull UUID uuid) {
        File errorStorageDirectory = ErrorLogHelper.getErrorStorageDirectory();
        return new File(errorStorageDirectory, uuid.toString() + ".dat");
    }
}
