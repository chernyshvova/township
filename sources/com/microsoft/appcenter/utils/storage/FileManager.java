package com.microsoft.appcenter.utils.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    @SuppressLint({"StaticFieldLeak"})
    public static Context sContext;

    public static boolean deleteDirectory(@NonNull File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File deleteDirectory : listFiles) {
                deleteDirectory(deleteDirectory);
            }
        }
        return file.delete();
    }

    public static void mkdir(@NonNull String str) {
        new File(str).mkdirs();
    }

    public static String read(@NonNull File file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String property = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        sb.append(property);
                        sb.append(readLine2);
                    }
                }
                bufferedReader.close();
                return sb.toString();
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Could not read file ");
            outline24.append(file.getAbsolutePath());
            AppCenterLog.error("AppCenter", outline24.toString(), e);
            return null;
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }

    public static void write(@NonNull File file, @NonNull String str) throws IOException {
        if (!TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter.write(str);
            } finally {
                bufferedWriter.close();
            }
        }
    }
}
