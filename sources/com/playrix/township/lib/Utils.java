package com.playrix.township.lib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.Html;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.helpshift.util.AttachmentFileSize;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineActivity;
import com.playrix.engine.GlobalConstants;
import com.playrix.engine.Logger;
import com.playrix.gplay.billing.Base64;
import com.swrve.sdk.rest.RESTClient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class Utils {
    public static final boolean DEBUG_BUILD = false;
    public static final int DEFAULT_MIN_FREE_SPACE = 52428800;
    public static final int PATH_ID_CACHES = 1;
    public static final int PATH_ID_DOWNLOADS = 2;
    public static final int PATH_ID_LOGS = 3;
    public static final int PATH_ID_REPORTS = 4;
    public static final int PATH_ID_SAVES = 0;
    public static final boolean QA_BUILD = false;
    public static final boolean SUPPORT_BUILD = false;
    public static final String TAG = "Utils";
    public static Handler handler;
    public static long lastShownToastTime;
    public static volatile long mActivityCreatedTimestamp;

    public static void SetText(final String str, final String str2) {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                Context context = Engine.getContext();
                if (context != null) {
                    try {
                        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                        if (clipboardManager != null) {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
                        } else {
                            Logger.logError("UtilsCan't get clipboard manager");
                        }
                    } catch (Throwable th) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("UtilsError in SetText: ");
                        outline24.append(th.toString());
                        Logger.logError(outline24.toString());
                    }
                } else {
                    Logger.logError("UtilsNull context in SetText");
                }
            }
        });
    }

    public static boolean canOpenUrl(String str) {
        if (TextUtils.isEmpty(str) || Engine.getContext() == null) {
            return false;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Logger.logError("canOpenUrl was called from not UI thread.");
        }
        if (Engine.getContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0).size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkCurrentDate() {
        /*
            java.lang.String r0 = nativeBuildDate()
            int r1 = r0.length()
            r2 = 11
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            if (r1 == r2) goto L_0x0017
            java.lang.String r0 = "Utils Unknown date format for build date. Ignored."
            com.playrix.engine.Logger.logDebug(r0)
            return r3
        L_0x0017:
            r1 = 0
            r5 = 3
            java.lang.String r6 = r0.substring(r1, r5)
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r6 = r6.toLowerCase(r7)
            int r7 = r6.hashCode()
            r8 = 10
            r9 = 9
            r10 = 8
            r11 = 6
            r12 = 4
            r13 = 2
            r14 = 7
            r15 = 5
            switch(r7) {
                case 96803: goto L_0x00ab;
                case 96947: goto L_0x00a1;
                case 99330: goto L_0x0096;
                case 101251: goto L_0x008c;
                case 104983: goto L_0x0082;
                case 105601: goto L_0x0078;
                case 105603: goto L_0x006e;
                case 107870: goto L_0x0064;
                case 107877: goto L_0x005a;
                case 109269: goto L_0x004f;
                case 109856: goto L_0x0043;
                case 113758: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x00b5
        L_0x0037:
            java.lang.String r7 = "sep"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 8
            goto L_0x00b6
        L_0x0043:
            java.lang.String r7 = "oct"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 9
            goto L_0x00b6
        L_0x004f:
            java.lang.String r7 = "nov"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 10
            goto L_0x00b6
        L_0x005a:
            java.lang.String r7 = "may"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 4
            goto L_0x00b6
        L_0x0064:
            java.lang.String r7 = "mar"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 2
            goto L_0x00b6
        L_0x006e:
            java.lang.String r7 = "jun"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 5
            goto L_0x00b6
        L_0x0078:
            java.lang.String r7 = "jul"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 6
            goto L_0x00b6
        L_0x0082:
            java.lang.String r7 = "jan"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 0
            goto L_0x00b6
        L_0x008c:
            java.lang.String r7 = "feb"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 1
            goto L_0x00b6
        L_0x0096:
            java.lang.String r7 = "dec"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 11
            goto L_0x00b6
        L_0x00a1:
            java.lang.String r7 = "aug"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 7
            goto L_0x00b6
        L_0x00ab:
            java.lang.String r7 = "apr"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00b5
            r6 = 3
            goto L_0x00b6
        L_0x00b5:
            r6 = -1
        L_0x00b6:
            switch(r6) {
                case 0: goto L_0x00ec;
                case 1: goto L_0x00f0;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00dd;
                case 5: goto L_0x00d8;
                case 6: goto L_0x00d3;
                case 7: goto L_0x00ce;
                case 8: goto L_0x00c9;
                case 9: goto L_0x00c4;
                case 10: goto L_0x00bf;
                case 11: goto L_0x00ba;
                default: goto L_0x00b9;
            }
        L_0x00b9:
            goto L_0x00f0
        L_0x00ba:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            goto L_0x00f0
        L_0x00bf:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            goto L_0x00f0
        L_0x00c4:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            goto L_0x00f0
        L_0x00c9:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            goto L_0x00f0
        L_0x00ce:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            goto L_0x00f0
        L_0x00d3:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            goto L_0x00f0
        L_0x00d8:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            goto L_0x00f0
        L_0x00dd:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            goto L_0x00f0
        L_0x00e2:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            goto L_0x00f0
        L_0x00e7:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            goto L_0x00f0
        L_0x00ec:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
        L_0x00f0:
            java.lang.String r0 = r0.substring(r14)     // Catch:{ NumberFormatException -> 0x0101 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0101 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0101 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0101 }
            goto L_0x0107
        L_0x0101:
            r0 = 2019(0x7e3, float:2.829E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0107:
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            java.util.Calendar r12 = java.util.Calendar.getInstance()
            int r6 = r0.intValue()
            int r7 = r4.intValue()
            r8 = 1
            r9 = 0
            r10 = 0
            r11 = 0
            r5 = r2
            r5.set(r6, r7, r8, r9, r10, r11)
            r12.add(r15, r3)
            boolean r0 = r12.before(r2)
            if (r0 == 0) goto L_0x0151
            java.lang.String r0 = "Utils Build date is later than tomorrow: "
            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
            java.util.Date r2 = r2.getTime()
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r2 = "/"
            r0.append(r2)
            java.util.Date r2 = r12.getTime()
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.playrix.engine.Logger.logDebug(r0)
            return r1
        L_0x0151:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.township.lib.Utils.checkCurrentDate():boolean");
    }

    public static boolean checkExternalStorage(Context context) {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            Logger.logDebug("Utils External storage state: " + externalStorageState);
            if (!"mounted".equals(externalStorageState) || context.getExternalFilesDir((String) null) == null) {
                return false;
            }
            return true;
        } catch (NullPointerException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Utils Can't checkExternalStorage ");
            outline24.append(e.getMessage());
            Logger.logError(outline24.toString());
            return false;
        }
    }

    public static boolean checkFreeSpace() {
        String externalStoragePath = Engine.getExternalStoragePath();
        if (externalStoragePath == null) {
            return false;
        }
        File file = new File(externalStoragePath);
        if (!file.exists()) {
            return false;
        }
        if (file.getUsableSpace() >= ((long) Engine.getSharedPreferencesInt("MinFreeSpace", DEFAULT_MIN_FREE_SPACE))) {
            return true;
        }
        return false;
    }

    public static boolean checkInetPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.INTERNET") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    public static void disableInput(final boolean z) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Engine.nativeDisableInput(z);
            }
        });
    }

    public static void exitGame(final int i) {
        final EngineActivity activity = Engine.getActivity();
        if (!isUsableActivity(activity)) {
            Logger.logError("Bad context for exitGame. Ignoring.");
        } else {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("exitGame: ");
                    outline24.append(i);
                    Logger.logInfo(outline24.toString());
                    int i = i;
                    if ((i & 1) == 1) {
                        if (Utils.isUsableActivity(activity)) {
                            activity.finish();
                        }
                    } else if ((i & 4) == 4) {
                        C33571 r0 = new AsyncTask<Void, Void, Void>() {
                            public Void doInBackground(Void... voidArr) {
                                while (Utils.nativeIsSaving()) {
                                    try {
                                        Thread.sleep(500);
                                    } catch (Exception unused) {
                                        return null;
                                    }
                                }
                                Process.killProcess(Process.myPid());
                                return null;
                            }
                        };
                        Logger.sysInfo("start waiting killGameTask");
                        r0.execute(new Void[0]);
                    } else {
                        Logger.logError("Unknown exitGame behave");
                    }
                }
            });
        }
    }

    public static String formatMemoryStr(File file) {
        return humanReadableSize(file.getUsableSpace()) + " / " + humanReadableSize(file.getFreeSpace()) + " / " + humanReadableSize(file.getTotalSpace());
    }

    public static String getAppVersionInfo(String str) {
        try {
            Context context = Engine.getContext();
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            if (packageManager == null) {
                return "";
            }
            return packageManager.getPackageInfo(str, 0).versionName + "/" + packageManager.getPackageInfo(str, 0).versionCode;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getCountryTagByIp() {
        return nativeCountryTagByIp();
    }

    public static long getInstallTime() {
        try {
            Context context = Engine.getContext();
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Utils");
            outline24.append(e.getMessage());
            Logger.logError(outline24.toString());
            return 0;
        }
    }

    public static String getLanguage(String str) {
        String nativeGameLanguage = nativeGameLanguage();
        return TextUtils.isEmpty(nativeGameLanguage) ? str : nativeGameLanguage;
    }

    public static String getMD5(byte[] bArr) {
        String str;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & Base64.EQUALS_SIGN_ENC;
                if (b2 <= 15) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMetaString(String str) {
        try {
            return Engine.getContext().getPackageManager().getApplicationInfo(Engine.getContext().getPackageName(), 128).metaData.getString(str);
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Utils Exception in getMetaString: ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
            return "";
        }
    }

    public static String getProcMemInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || i >= 3) {
                    bufferedReader.close();
                } else {
                    sb.append(readLine);
                    sb.append(10);
                    i++;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("Can't get meminfo: "));
        }
        return sb.toString();
    }

    public static String getPublicIp() {
        return nativePublicIp();
    }

    public static boolean getSharedPreferencesBool(String str, boolean z) {
        SharedPreferences preferences = Engine.getPreferences();
        return preferences != null ? preferences.getBoolean(str, z) : z;
    }

    public static String getSysMemInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getProcMemInfo());
        Context context = Engine.getContext();
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("Minfo: ");
                    sb.append(memoryInfo.availMem);
                    sb.append('/');
                    sb.append(memoryInfo.totalMem);
                    sb.append('/');
                    sb.append(memoryInfo.threshold);
                    sb.append(10);
                }
                sb.append("MLimit: ");
                sb.append((Runtime.getRuntime().maxMemory() / 1024) / 1024);
                if (activityManager != null) {
                    sb.append('/');
                    sb.append(activityManager.getMemoryClass());
                }
                sb.append(10);
            } catch (Exception e) {
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("Can't get meminfo2: "));
            }
        }
        File dataDirectory = Environment.getDataDirectory();
        sb.append("DataDir: ");
        if (dataDirectory == null || !dataDirectory.exists()) {
            sb.append("unknown");
        } else {
            sb.append(formatMemoryStr(dataDirectory));
        }
        sb.append("\n");
        sb.append("ExtDir: ");
        String externalStoragePath = Engine.getExternalStoragePath();
        if (!TextUtils.isEmpty(externalStoragePath)) {
            File file = new File(externalStoragePath);
            if (file.exists()) {
                sb.append(formatMemoryStr(file));
            } else {
                sb.append("unknown");
            }
        } else {
            sb.append("unknown");
        }
        sb.append("\tremovable: ");
        sb.append(Environment.isExternalStorageRemovable());
        sb.append("\temulated: ");
        sb.append(Environment.isExternalStorageEmulated());
        sb.append("\n");
        return sb.toString();
    }

    public static String getText(String str) {
        String str2;
        try {
            str2 = getLanguage(Engine.getFirstSupportedLanguage());
        } catch (Throwable unused) {
            str2 = Engine.getFirstSupportedLanguage();
        }
        String outline17 = GeneratedOutlineSupport.outline17(str2, "_", str);
        return GlobalConstants.getString(outline17, GlobalConstants.getString("en_" + str, ""));
    }

    public static String humanReadableSize(long j) {
        if (j < ((long) 1024)) {
            return j + AttachmentFileSize.FILE_SIZE_UNIT_B;
        }
        double d = (double) j;
        double d2 = (double) 1024;
        int log = (int) (Math.log(d) / Math.log(d2));
        double pow = Math.pow(d2, (double) log);
        Double.isNaN(d);
        return String.format("%.1f%s", new Object[]{Double.valueOf(d / pow), Character.valueOf("KMGTPE".charAt(log - 1))});
    }

    public static boolean isIntentAvailable(Intent intent) {
        try {
            Context context = Engine.getContext();
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            if (packageManager == null || packageManager.resolveActivity(intent, 65536) == null) {
                return false;
            }
            return true;
        } catch (NullPointerException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("UtilsisIntentAvailable, NPE ");
            outline24.append(e.getMessage());
            Logger.logError(outline24.toString());
            return false;
        }
    }

    public static boolean isUsableActivity(Activity activity) {
        return activity != null && !activity.isFinishing() && !activity.isDestroyed();
    }

    public static boolean isUsablePlayrixActivity() {
        return isUsableActivity(Engine.getActivity());
    }

    public static native String nativeBuildDate();

    public static native String nativeCountryTagByIp();

    public static native String nativeGameLanguage();

    public static native boolean nativeIsSaving();

    public static native String nativePublicIp();

    public static void onCreate() {
        mActivityCreatedTimestamp = System.currentTimeMillis();
    }

    public static void openAppOrUrl(final String str, final String str2) {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                if (Utils.canOpenUrl(str)) {
                    Utils.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), Engine.getActivity());
                } else if (Utils.canOpenUrl(str2)) {
                    Utils.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)), Engine.getActivity());
                } else {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("openAppOrUrl: can't open: ");
                    outline24.append(str);
                    outline24.append(" or ");
                    outline24.append(str2);
                    Logger.logError(outline24.toString());
                }
            }
        });
    }

    public static boolean putSharedPreferencesBool(String str, boolean z) {
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
        return true;
    }

    public static String readAssetsTextFile(String str, boolean z) {
        try {
            InputStream open = Engine.getContext().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                for (int read = open.read(); read != -1; read = open.read()) {
                    byteArrayOutputStream.write(read);
                }
                open.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            return z ? byteArrayOutputStream2.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br/>") : byteArrayOutputStream2;
        } catch (IOException unused) {
            Logger.logError("Utils" + str + " not found!");
            return "";
        }
    }

    public static void reportIssue(String str, String str2, String str3, String str4) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(GeneratedOutlineSupport.outline16(str, "-----<br>"));
        outline24.append(getSysMemInfo().replace("\n", "<br>"));
        sendEmail(str2, GeneratedOutlineSupport.outline16(GeneratedOutlineSupport.outline16(outline24.toString(), "<br/>"), "-----<br>"), "support@playrix.com", (Uri) null, str4);
    }

    @TargetApi(24)
    public static void sendEmail(String str, String str2, String str3, Uri uri, String str4) {
        final Uri uri2 = uri;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                Intent intent = new Intent("android.intent.action.SEND");
                if (uri2 != null) {
                    intent.setType("application/zip");
                } else {
                    intent.setType("message/rfc822");
                }
                intent.addFlags(335544320);
                intent.putExtra("android.intent.extra.SUBJECT", str5);
                if (Build.VERSION.SDK_INT < 24) {
                    intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(str6));
                } else {
                    intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(str6, 0));
                }
                String str = str7;
                if (str != null && !str.isEmpty()) {
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str7});
                }
                Uri uri = uri2;
                if (uri != null) {
                    intent.putExtra("android.intent.extra.STREAM", uri);
                }
                if (!Utils.startActivity(intent, Engine.getActivity())) {
                    Toast.makeText(Engine.getActivity(), str8, 0).show();
                }
            }
        });
    }

    public static void showDebugToast(final String str) {
        if (getSharedPreferencesBool("_DebugToast_", true)) {
            long currentTimeMillis = System.currentTimeMillis() - lastShownToastTime;
            long j = currentTimeMillis > 2000 ? 0 : 2000 - currentTimeMillis;
            lastShownToastTime = System.currentTimeMillis() + j;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (Utils.isUsableActivity(Engine.getActivity())) {
                        Toast.makeText(Engine.getContext(), str, 0).show();
                        return;
                    }
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to show toast: ");
                    outline24.append(str);
                    Logger.logWarning(outline24.toString());
                }
            }, j);
        }
    }

    public static boolean startActivity(Intent intent, Activity activity) {
        String str;
        String str2;
        if (activity == null || intent == null) {
            str = "null activity/intent";
        } else {
            try {
                activity.startActivity(intent);
                return true;
            } catch (NullPointerException unused) {
                str2 = "NPE";
                StringBuilder outline26 = GeneratedOutlineSupport.outline26(str2, RESTClient.SEMICOLON_SEPARATOR);
                outline26.append(intent.getComponent());
                outline26.append("/");
                outline26.append(intent.getDataString());
                str = outline26.toString();
                Logger.logWarning("UtilsCan't start activity: " + str);
                return false;
            } catch (ActivityNotFoundException unused2) {
                str2 = "ANF";
                StringBuilder outline262 = GeneratedOutlineSupport.outline26(str2, RESTClient.SEMICOLON_SEPARATOR);
                outline262.append(intent.getComponent());
                outline262.append("/");
                outline262.append(intent.getDataString());
                str = outline262.toString();
                Logger.logWarning("UtilsCan't start activity: " + str);
                return false;
            } catch (SecurityException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("UtilsError while starting activity for goHome: ");
                outline24.append(e.getMessage());
                Logger.logError(outline24.toString());
                str2 = "";
                StringBuilder outline2622 = GeneratedOutlineSupport.outline26(str2, RESTClient.SEMICOLON_SEPARATOR);
                outline2622.append(intent.getComponent());
                outline2622.append("/");
                outline2622.append(intent.getDataString());
                str = outline2622.toString();
                Logger.logWarning("UtilsCan't start activity: " + str);
                return false;
            } catch (Exception e2) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("ex: ");
                outline242.append(e2.getMessage());
                str2 = outline242.toString();
                StringBuilder outline26222 = GeneratedOutlineSupport.outline26(str2, RESTClient.SEMICOLON_SEPARATOR);
                outline26222.append(intent.getComponent());
                outline26222.append("/");
                outline26222.append(intent.getDataString());
                str = outline26222.toString();
                Logger.logWarning("UtilsCan't start activity: " + str);
                return false;
            }
        }
        Logger.logWarning("UtilsCan't start activity: " + str);
        return false;
    }

    public static String getMD5(String str) {
        return getMD5(str.getBytes());
    }
}
