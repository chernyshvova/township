package com.helpshift.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AssetsUtil {
    public static final String TAG = "AssetsUtil";

    @Nullable
    public static Uri getNotificationSoundUri(Context context, Integer num) {
        if (num == null) {
            return null;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("android.resource://");
        outline24.append(context.getPackageName());
        outline24.append("/");
        outline24.append(num);
        return Uri.parse(outline24.toString());
    }

    public static String readFileAsString(Context context, String str) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            IOUtils.closeQuitely(inputStream);
                            IOUtils.closeQuitely(bufferedReader);
                            return sb2;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        HSLogger.m3241e(TAG, "Error reading the file : " + e.getMessage());
                        IOUtils.closeQuitely(inputStream);
                        IOUtils.closeQuitely(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuitely(inputStream);
                        IOUtils.closeQuitely(bufferedReader);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
                HSLogger.m3241e(TAG, "Error reading the file : " + e.getMessage());
                IOUtils.closeQuitely(inputStream);
                IOUtils.closeQuitely(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                IOUtils.closeQuitely(inputStream);
                IOUtils.closeQuitely(bufferedReader);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            bufferedReader = null;
            HSLogger.m3241e(TAG, "Error reading the file : " + e.getMessage());
            IOUtils.closeQuitely(inputStream);
            IOUtils.closeQuitely(bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            inputStream = null;
            IOUtils.closeQuitely(inputStream);
            IOUtils.closeQuitely(bufferedReader);
            throw th;
        }
    }

    @Nullable
    public static boolean resourceExists(Context context, Integer num) {
        if (context == null || num == null) {
            return false;
        }
        try {
            return context.getResources().getResourceName(num.intValue()) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }
}
