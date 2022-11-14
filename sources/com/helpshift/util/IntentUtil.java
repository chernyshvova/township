package com.helpshift.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import java.io.File;

public class IntentUtil {
    public static Intent createFileProviderIntent(@NonNull Context context, @NonNull File file, @NonNull String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        String packageName = context.getApplicationContext().getPackageName();
        Uri uriForFile = FileProvider.getUriForFile(context, packageName + ".helpshift.fileprovider", file);
        intent.setFlags(1);
        intent.setDataAndType(uriForFile, str);
        return intent;
    }
}
