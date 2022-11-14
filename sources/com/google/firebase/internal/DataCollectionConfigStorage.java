package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.firebase.events.Publisher;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class DataCollectionConfigStorage {
    public final Context applicationContext;
    public final AtomicBoolean dataCollectionDefaultEnabled;
    public final SharedPreferences sharedPreferences;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        ApplicationInfo applicationInfo;
        this.applicationContext = (Build.VERSION.SDK_INT < 24 || ContextCompat.isDeviceProtectedStorage(context)) ? context : ContextCompat.createDeviceProtectedStorageContext(context);
        this.sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        boolean z = true;
        if (this.sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            z = this.sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = this.applicationContext.getPackageManager();
                if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                    z = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        this.dataCollectionDefaultEnabled = new AtomicBoolean(z);
    }
}
