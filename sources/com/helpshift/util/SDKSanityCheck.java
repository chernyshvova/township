package com.helpshift.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.internal.FetchedAppSettings;
import com.helpshift.constants.CommonSharedPrefrences;
import java.io.File;
import java.security.MessageDigest;
import java.util.Map;

public class SDKSanityCheck {
    public static final String TAG = "Helpshift_SntyChck";

    public static void checkInstallCredsSanity(Context context, String str, String str2, String str3, String str4, Map<String, String> map) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        try {
            String string = sharedPreferences.getString(CommonSharedPrefrences.LIBRARY_VERSION, "");
            String string2 = sharedPreferences.getString(CommonSharedPrefrences.INSTALL_CREDS_HASH, "");
            String generateInstallCredsHash = generateInstallCredsHash(str2, str3, str4);
            if (StringUtils.isEmpty(string)) {
                Log.d(TAG, "SDK version empty, SDK sanity check not needed.");
                storeInstallHash(sharedPreferences, generateInstallCredsHash);
            } else if (StringUtils.isEmpty(string2)) {
                if (!str3.endsWith(".com")) {
                    Log.d(TAG, "Old install hash does not exist and domain change to " + str3);
                    deleteDatabases(context, map);
                }
                storeInstallHash(sharedPreferences, generateInstallCredsHash);
            } else if (!generateInstallCredsHash.equals(string2)) {
                Log.d(TAG, "Install creds changed, delete all data.");
                deleteDatabases(context, map);
                storeInstallHash(sharedPreferences, generateInstallCredsHash);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while install creds sanity check:", e);
        }
    }

    public static void deleteDatabases(Context context, Map<String, String> map) {
        File file;
        Log.d(TAG, "Deleting databases for install creds switch");
        File databasePath = context.getDatabasePath("dummy");
        if (databasePath == null) {
            file = null;
        } else {
            file = databasePath.getParentFile();
        }
        for (String next : map.values()) {
            context.deleteDatabase(next);
            deleteFileByName(file, next);
        }
    }

    public static void deleteFileByName(File file, String str) {
        File[] listFiles;
        if (file != null && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName() != null && file2.getName().startsWith(str)) {
                    file2.delete();
                }
            }
        }
    }

    public static String generateInstallCredsHash(String str, String str2, String str3) throws Exception {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest((str + FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR + str2 + FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR + str3).getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
            }
            return sb.toString();
        } catch (Exception e) {
            Log.e("Helpshift", "Error in generating MD5 hash");
            throw e;
        }
    }

    public static void storeInstallHash(SharedPreferences sharedPreferences, String str) {
        Log.d(TAG, "Storing install creds hash");
        sharedPreferences.edit().putString(CommonSharedPrefrences.INSTALL_CREDS_HASH, str).commit();
    }
}
