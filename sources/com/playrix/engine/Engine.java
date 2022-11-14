package com.playrix.engine;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.Trace;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.p003os.ConfigurationCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.security.ProviderInstaller;
import com.playrix.engine.GLSurfaceViewV17;
import com.vungle.warren.VisionController;
import com.vungle.warren.VungleApiClient;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class Engine {
    public static final float DEFAULT_ANDROID_REFRESH_RATE = 60.1f;
    public static final double PHABLET_DIAGONAL_MIN = 5.5d;
    public static final boolean USE_SDCARD_WORK_DIR = false;
    public static ActivityManager actMgr = null;
    public static ClipboardManager clipboardManager = null;
    public static ConnectivityManager connMgr = null;
    public static Display defaultDisplay = null;
    public static float displayRefreshRate = 60.0f;
    public static final Object displayRefreshRateSyncObject = new Object();
    public static volatile boolean externalCacheDir = false;
    public static final ThreadLocal<String> lastError = new ThreadLocal<>();
    public static WeakReference<EngineActivity> mActivity;
    public static Application mContext;
    public static GLSurfaceViewV17.Scale2D mResolutionScale = new GLSurfaceViewV17.Scale2D();
    public static float preferredDisplayRefreshRate = 60.1f;
    public static final Object preferredDisplayRefreshRateSyncObject = new Object();

    public static void ClearLastError() {
        lastError.set((Object) null);
    }

    public static void CloseApplication() {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        } else {
            System.exit(0);
        }
    }

    public static long GetAvailableSpace(String str) {
        ClearLastError();
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (Exception e) {
            SetLastError(e.toString());
            return -1;
        }
    }

    public static int GetCurrentThreadPriority() {
        try {
            return Process.getThreadPriority(Process.myTid());
        } catch (Exception unused) {
            return -1000;
        }
    }

    public static String GetLastError() {
        return lastError.get();
    }

    public static boolean SetCurrentThreadPriority(int i) {
        try {
            Process.setThreadPriority(i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void SetLastError(String str) {
        lastError.set(str);
    }

    public static void beginTraceSection(String str) {
        Trace.beginSection(str);
    }

    public static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        boolean z = true;
        for (char c : str.toCharArray()) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                str2 = str2 + c;
            } else {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24(str2);
                outline24.append(Character.toUpperCase(c));
                str2 = outline24.toString();
                z = false;
            }
        }
        return str2;
    }

    public static boolean checkConnectedNetworkDeprecated(int i) {
        NetworkInfo networkInfo = connMgr.getNetworkInfo(i);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean containsSharedPreferencesValue(String str) {
        SharedPreferences preferences = getPreferences();
        if (preferences != null) {
            return preferences.contains(str);
        }
        return false;
    }

    public static Intent createLaunchIntent() throws ClassNotFoundException {
        Intent intent = new Intent(mContext, Class.forName(getLaunchActivityName()));
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(DriveFile.MODE_READ_WRITE);
        return intent;
    }

    public static void enableTls12() {
        enableTls12InHttpsUrlConnection();
        installDynamicSslProvider(new Runnable() {
            public void run() {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        HttpManager.enableTls12(true);
                    }
                });
                Engine.enableTls12InHttpsUrlConnection();
            }
        });
    }

    public static void enableTls12InHttpsUrlConnection() {
        SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        if (HttpsTls12Helper.checkTls12(defaultSSLSocketFactory, "HttpsURLConnection") == 1) {
            HttpsURLConnection.setDefaultSSLSocketFactory(HttpsTls12Helper.enableTls12Support(defaultSSLSocketFactory, "HttpsURLConnection"));
        }
    }

    public static void endTraceSection() {
        Trace.endSection();
    }

    public static void executeInGlThread(final long j) {
        runOnGLThread(new Runnable() {
            public void run() {
                Engine.nativeExecuteInGlThread(j);
            }
        });
    }

    public static EngineActivity getActivity() {
        WeakReference<EngineActivity> weakReference = mActivity;
        if (weakReference != null) {
            return (EngineActivity) weakReference.get();
        }
        return null;
    }

    @TargetApi(21)
    public static int getAllConnectedNetworksDeprecated() {
        Network[] allNetworks = connMgr.getAllNetworks();
        if (allNetworks == null) {
            return 0;
        }
        int i = 0;
        for (Network networkInfo : allNetworks) {
            NetworkInfo networkInfo2 = connMgr.getNetworkInfo(networkInfo);
            if (networkInfo2 != null && networkInfo2.isConnected()) {
                networkInfo2.getType();
                int type = networkInfo2.getType();
                if (type == 0) {
                    i |= 2;
                } else if (type == 1 || type == 6) {
                    i |= 1;
                } else if (type == 7) {
                    i |= 8;
                } else if (type == 9) {
                    i |= 4;
                }
            }
        }
        return i;
    }

    public static String getAndroidId() {
        return Settings.Secure.getString(mContext.getContentResolver(), VungleApiClient.ANDROID_ID);
    }

    public static String getAppId() {
        return mContext.getPackageName();
    }

    public static String getAppName() {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = mContext.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    public static String getAppPath() {
        return mContext.getApplicationInfo().sourceDir;
    }

    public static String getAppVersion() {
        try {
            return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int getAppVersionCode() {
        try {
            return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static Application getApplication() {
        return mContext;
    }

    public static String getCachesPath() {
        if (!externalCacheDir) {
            return mContext.getCacheDir().getAbsolutePath();
        }
        File externalCacheDir2 = mContext.getExternalCacheDir();
        if (externalCacheDir2 != null) {
            return externalCacheDir2.getAbsolutePath();
        }
        return null;
    }

    public static String getClipboardContent() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        ClipDescription description;
        ClipboardManager clipboardManager2 = clipboardManager;
        if (clipboardManager2 == null || !clipboardManager2.hasPrimaryClip() || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() == 0 || (itemAt = primaryClip.getItemAt(0)) == null || (description = primaryClip.getDescription()) == null || !description.hasMimeType("text/plain")) {
            return null;
        }
        return itemAt.getText().toString();
    }

    public static int getConnectedNetworks() {
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT < 27) {
            return getConnectedNetworksDeprecated();
        }
        Network activeNetwork = connMgr.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connMgr.getNetworkCapabilities(activeNetwork)) == null) {
            return 0;
        }
        int i = 1;
        if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(5)) {
            i = 0;
        }
        if (networkCapabilities.hasTransport(0)) {
            i |= 2;
        }
        if (networkCapabilities.hasTransport(3)) {
            i |= 4;
        }
        int i2 = networkCapabilities.hasTransport(2) ? i | 8 : i;
        return networkCapabilities.hasTransport(4) ? i2 | 16 : i2;
    }

    public static int getConnectedNetworksDeprecated() {
        if (Build.VERSION.SDK_INT >= 21) {
            return getAllConnectedNetworksDeprecated();
        }
        int i = 1;
        if (!checkConnectedNetworkDeprecated(1) && !checkConnectedNetworkDeprecated(6)) {
            i = 0;
        }
        if (checkConnectedNetworkDeprecated(0)) {
            i |= 2;
        }
        if (checkConnectedNetworkDeprecated(9)) {
            i |= 4;
        }
        return checkConnectedNetworkDeprecated(7) ? i | 8 : i;
    }

    public static Context getContext() {
        return mContext;
    }

    public static String[] getDeviceAbiList() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    public static String getDeviceCountry() {
        return getDeviceLocale().getCountry();
    }

    public static String getDeviceLanguage() {
        return getDeviceLocale().getLanguage();
    }

    public static Locale getDeviceLocale() {
        return ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        return str.startsWith(str2) ? str.substring(str2.length()).trim() : str;
    }

    public static float getDeviceNativeScale() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        float f = displayMetrics.density;
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static int getDeviceRotation() {
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? -1 : 270;
        }
        return 180;
    }

    public static int getDeviceScreenDPI() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static String getDeviceScript() {
        if (Build.VERSION.SDK_INT >= 21) {
            return getDeviceLocale().getScript();
        }
        return null;
    }

    public static String getDeviceSerialNumber() {
        return Build.SERIAL;
    }

    public static double getDisplayDiagonal() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        return Math.sqrt((double) ((f2 * f2) + (f * f)));
    }

    public static int getDisplayPpi() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return (int) ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
    }

    public static float getDisplayRefreshRate() {
        float f;
        synchronized (displayRefreshRateSyncObject) {
            f = displayRefreshRate;
        }
        return f;
    }

    public static Point getDisplaySize() {
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point;
    }

    public static String getExternalStoragePath() {
        File externalFilesDir = mContext.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    public static String getFirstSupportedCountry() {
        return Locale.getDefault().getCountry();
    }

    public static String getFirstSupportedLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getFirstSupportedScript() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Locale.getDefault().getScript();
        }
        return null;
    }

    public static String getFlavor(String str) {
        try {
            Object obj = Class.forName(str + ".BuildConfig").getField("FLAVOR").get((Object) null);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String getInstaller() {
        try {
            PackageManager packageManager = mContext.getPackageManager();
            if (Build.VERSION.SDK_INT >= 30) {
                return packageManager.getInstallSourceInfo(mContext.getPackageName()).getInstallingPackageName();
            }
            return packageManager.getInstallerPackageName(mContext.getPackageName());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getInternalStoragePath() {
        return mContext.getFilesDir().getAbsolutePath();
    }

    public static String getInternetConnectionType() {
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT < 27) {
            return getInternetConnectionTypeDeprecated();
        }
        Network activeNetwork = connMgr.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connMgr.getNetworkCapabilities(activeNetwork)) == null) {
            return "No";
        }
        if (networkCapabilities.hasTransport(3)) {
            return "Ethernet";
        }
        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(5)) {
            return "WiFi";
        }
        if (networkCapabilities.hasTransport(2)) {
            return "Bluetooth";
        }
        if (networkCapabilities.hasTransport(6)) {
            return "LoWPAN";
        }
        if (networkCapabilities.hasTransport(4)) {
            return "VPN";
        }
        return networkCapabilities.hasTransport(0) ? "Mobile" : "No";
    }

    public static String getInternetConnectionTypeDeprecated() {
        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "No";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1 || type == 6) {
            return "WiFi";
        }
        if (type == 9) {
            return "Ethernet";
        }
        return type == 7 ? "Bluetooth" : "Mobile";
    }

    public static String getLaunchActivityName() {
        return GlobalConstants.getString("app_launch_activity", "");
    }

    public static int getLongPressTimeout() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public static Debug.MemoryInfo getMemoryInfo() {
        Debug.MemoryInfo[] processMemoryInfo = actMgr.getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            return null;
        }
        return processMemoryInfo[0];
    }

    public static String getOsVer() {
        return Build.VERSION.RELEASE;
    }

    public static SharedPreferences getPreferences() {
        Application application = mContext;
        if (application == null) {
            return null;
        }
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    public static long getProcSize() {
        return (long) actMgr.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
    }

    public static Point getRealScreenSize() {
        Display display;
        Point point = new Point();
        EngineActivity activity = getActivity();
        if (activity == null) {
            return point;
        }
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                display = activity.getDisplay();
            } else {
                display = activity.getWindowManager().getDefaultDisplay();
            }
            display.getRealSize(point);
        } catch (Exception unused) {
        }
        return point;
    }

    public static float getResolutionScale() {
        return mResolutionScale.getScale();
    }

    public static float getResolutionScaleH() {
        return mResolutionScale.getScaleH();
    }

    public static float getResolutionScaleW() {
        return mResolutionScale.getScaleW();
    }

    public static int getScaledTouchSlop() {
        return ViewConfiguration.get(mContext).getScaledTouchSlop();
    }

    public static String getSecureAndroidId() {
        return Settings.Secure.getString(mContext.getContentResolver(), VungleApiClient.ANDROID_ID);
    }

    public static int getSharedPreferencesInt(String str, int i) {
        SharedPreferences preferences = getPreferences();
        return preferences != null ? preferences.getInt(str, i) : i;
    }

    public static String getSharedPreferencesString(String str, String str2) {
        SharedPreferences preferences = getPreferences();
        if (preferences != null) {
            return preferences.getString(str, str2);
        }
        return null;
    }

    public static int getVersionSDK() {
        return Build.VERSION.SDK_INT;
    }

    public static String getWriteablePath() {
        return mContext.getApplicationInfo().dataDir;
    }

    public static boolean hasVibrator() {
        try {
            return ((Vibrator) mContext.getSystemService("vibrator")).hasVibrator();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void installDynamicSslProvider(final Runnable runnable) {
        try {
            ProviderInstaller.installIfNeededAsync(mContext, new ProviderInstaller.ProviderInstallListener() {
                public void onProviderInstallFailed(int i, Intent intent) {
                    Logger.logDebug("Security provider installation failed, code " + i);
                }

                public void onProviderInstalled() {
                    Logger.logDebug("Security provider installed");
                    runnable.run();
                }
            });
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error while installing security provider: ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
        }
    }

    public static boolean isDevicePhablet() {
        if (isDeviceTablet() || getDisplayDiagonal() <= 5.5d) {
            return false;
        }
        return true;
    }

    public static boolean isDeviceTablet() {
        return (mContext.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static Boolean isEmulator() {
        return nativeIsEmulator();
    }

    public static boolean isInteractive() {
        Application application = mContext;
        if (application == null) {
            Logger.logDebug("Attempt to check interactive state with null context");
            return true;
        }
        PowerManager powerManager = (PowerManager) application.getSystemService("power");
        if (powerManager == null) {
            Logger.logDebug("Attempt to check interactive state with null power manager");
            return true;
        } else if (Build.VERSION.SDK_INT < 20) {
            return powerManager.isScreenOn();
        } else {
            return powerManager.isInteractive();
        }
    }

    public static Boolean isJailbroken() {
        return nativeIsJailbroken();
    }

    public static boolean isPackageInstalled(String str) {
        try {
            return mContext.getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isProductionBuild() {
        return NativeThread.getInstance().isLibrariesLoaded() && nativeIsProductionBuild();
    }

    public static native void nativeCancelMouse();

    public static native void nativeDisableInput(boolean z);

    public static native void nativeDisplayCutout(int i, int i2, int i3, int i4);

    public static native void nativeExecuteInGlThread(long j);

    public static native int nativeGetOrientationSettings();

    public static native Boolean nativeIsEmulator();

    public static native Boolean nativeIsJailbroken();

    public static native boolean nativeIsProductionBuild();

    public static native void nativeMouseWheel(int i);

    public static native void nativeMultiFingerDoubleTap(int i);

    public static native void nativeOnCreate();

    public static native void nativeOnDestroy();

    public static native void nativeOnDisplayRefreshRateChanged(float f);

    public static native void nativeOnGoogleAdvertisingIdReady(String str);

    public static native void nativeOnLaunchConfig();

    public static native void nativeOnLowMemory();

    public static native void nativeOnMarketAdvertisingIdReady(String str, boolean z);

    public static native void nativeOnOrientationChanged();

    public static native void nativeOnPause();

    public static native void nativeOnPushTokenReceived(String str);

    public static native void nativeOnResume();

    public static native void nativeOnStart();

    public static native void nativeOnStop();

    public static native void nativeOnThermalStatusChanged(int i);

    public static native void nativeOnUrlActivate(String str);

    public static native void nativeRender();

    public static native void nativeResize(int i, int i2);

    public static native void nativeScale(int i, int i2, float f);

    public static native void nativeScaleBegin(int i, int i2, float f);

    public static native void nativeScaleEnd();

    public static native void nativeTouch(int i, int i2, int i3);

    public static void onCreate(EngineActivity engineActivity) {
        mActivity = new WeakReference<>(engineActivity);
    }

    public static void onDisplayChanged(Display display) {
        if (getActivity() != null) {
            updateDisplayPreferences(getActivity());
        }
        float refreshRate = display.getRefreshRate();
        synchronized (displayRefreshRateSyncObject) {
            if (refreshRate != displayRefreshRate) {
                displayRefreshRate = refreshRate;
                nativeOnDisplayRefreshRateChanged(refreshRate);
            }
        }
    }

    public static void onPlayrixActivityCreated(EngineActivity engineActivity) {
        updateDisplayPreferences(engineActivity);
        engineActivity.getGLView().setResolutionScale(mResolutionScale);
        KeyboardManager.onPlayrixActivityCreated();
    }

    public static void onPushTokenReceived(final String str) {
        if (str != null) {
            runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeOnPushTokenReceived(str);
                }
            });
        }
    }

    public static void performHapticFeedback(int i) {
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.getGLView().performHapticFeedback(i, 3);
        }
    }

    public static boolean putSharedPreferencesInt(String str, int i) {
        SharedPreferences preferences = getPreferences();
        if (preferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(str, i);
        edit.apply();
        return true;
    }

    public static boolean putSharedPreferencesString(String str, String str2) {
        SharedPreferences preferences = getPreferences();
        if (preferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(str, str2);
        edit.apply();
        return true;
    }

    public static void registerThermalStatusListener() {
        PowerManager powerManager;
        if (Build.VERSION.SDK_INT >= 29 && (powerManager = (PowerManager) mContext.getSystemService("power")) != null) {
            nativeOnThermalStatusChanged(powerManager.getCurrentThermalStatus());
            powerManager.addThermalStatusListener(new PowerManager.OnThermalStatusChangedListener() {
                public void onThermalStatusChanged(int i) {
                    Engine.nativeOnThermalStatusChanged(i);
                }
            });
        }
    }

    public static boolean removeSharedPreferencesValue(String str) {
        SharedPreferences preferences = getPreferences();
        if (preferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.remove(str);
        edit.apply();
        return true;
    }

    public static void requestAdvertisingId() {
        requestGoogleAdvertisingId();
        requestMarketAdvertisingId();
    }

    public static void requestGoogleAdvertisingId() {
        new Thread(new Runnable() {
            public void run() {
                String str = null;
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(Engine.mContext);
                    if (advertisingIdInfo.getId() != null) {
                        str = advertisingIdInfo.getId();
                    }
                } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | Exception | NullPointerException unused) {
                }
                Engine.nativeOnGoogleAdvertisingIdReady(str);
            }
        }).start();
    }

    public static void requestMarketAdvertisingId() {
        try {
            Method declaredMethod = Class.forName("com.playrix.engine.AdvertisingId").getDeclaredMethod("request", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.invoke((Object) null, new Object[0]);
                return;
            }
        } catch (Exception unused) {
        }
        nativeOnMarketAdvertisingIdReady((String) null, false);
    }

    public static boolean runOnGLThread(Runnable runnable) {
        return NativeThread.getInstance().queueEvent(runnable);
    }

    public static boolean runOnUiThread(Runnable runnable) {
        EngineActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        activity.runOnUiThread(runnable);
        return true;
    }

    public static void setApplicationContext(Application application) {
        if (mContext != application) {
            mContext = application;
            actMgr = (ActivityManager) application.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            connMgr = (ConnectivityManager) mContext.getSystemService("connectivity");
            clipboardManager = (ClipboardManager) mContext.getSystemService("clipboard");
            final DisplayManager displayManager = (DisplayManager) mContext.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            defaultDisplay = displayManager.getDisplay(0);
            synchronized (displayRefreshRateSyncObject) {
                displayRefreshRate = defaultDisplay.getRefreshRate();
            }
            displayManager.registerDisplayListener(new DisplayManager.DisplayListener() {
                public void onDisplayAdded(int i) {
                }

                public void onDisplayChanged(int i) {
                    if (Engine.defaultDisplay.getDisplayId() == i) {
                        final Display display = displayManager.getDisplay(i);
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                Engine.onDisplayChanged(display);
                            }
                        });
                    }
                }

                public void onDisplayRemoved(int i) {
                }
            }, (Handler) null);
            KeyboardManager.init(mContext);
            WebViewWindow.checkAvailability();
        }
    }

    public static boolean setClipboardContent(String str) {
        ClipboardManager clipboardManager2 = clipboardManager;
        if (clipboardManager2 == null) {
            return false;
        }
        clipboardManager2.setPrimaryClip(ClipData.newPlainText("", str));
        return true;
    }

    public static void setDeviceOrientation(Activity activity, int i) {
        setDeviceOrientation(activity, i, i);
    }

    public static void setKeepScreenOn() {
        final EngineActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    EngineActivity.this.getWindow().addFlags(128);
                }
            });
        }
    }

    public static void setResolutionScale(float f) {
        setResolutionScale(f, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r1 = getActivity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean tryStartPackage(java.lang.String r2) {
        /*
            android.app.Application r0 = mContext
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r2 = r0.getLaunchIntentForPackage(r2)
            r0 = 0
            if (r2 != 0) goto L_0x000e
            return r0
        L_0x000e:
            com.playrix.engine.EngineActivity r1 = getActivity()
            if (r1 != 0) goto L_0x0015
            return r0
        L_0x0015:
            com.playrix.engine.Engine$2 r0 = new com.playrix.engine.Engine$2
            r0.<init>(r1, r2)
            boolean r2 = runOnUiThread(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.Engine.tryStartPackage(java.lang.String):boolean");
    }

    public static void updateDisplayPreferences(final EngineActivity engineActivity) {
        float[] supportedRefreshRates;
        float f;
        float f2;
        Display defaultDisplay2 = ((WindowManager) engineActivity.getSystemService(VisionController.WINDOW)).getDefaultDisplay();
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        if (i >= 23) {
            Display.Mode[] supportedModes = defaultDisplay2.getSupportedModes();
            if (supportedModes != null) {
                Display.Mode mode = null;
                int length = supportedModes.length;
                while (i2 < length) {
                    Display.Mode mode2 = supportedModes[i2];
                    float refreshRate = mode2.getRefreshRate();
                    if (mode == null || refreshRate > mode.getRefreshRate()) {
                        mode = mode2;
                    }
                    i2++;
                }
                if (mode != null) {
                    final float refreshRate2 = mode.getRefreshRate();
                    final int modeId = mode.getModeId();
                    synchronized (preferredDisplayRefreshRateSyncObject) {
                        f2 = preferredDisplayRefreshRate;
                    }
                    if (f2 < refreshRate2) {
                        engineActivity.runOnUiThread(new Runnable() {
                            public void run() {
                                WindowManager.LayoutParams attributes = EngineActivity.this.getWindow().getAttributes();
                                attributes.preferredDisplayModeId = modeId;
                                EngineActivity.this.getWindow().setAttributes(attributes);
                                synchronized (Engine.preferredDisplayRefreshRateSyncObject) {
                                    float unused = Engine.preferredDisplayRefreshRate = refreshRate2;
                                }
                            }
                        });
                    }
                }
            }
        } else if (i >= 21 && (supportedRefreshRates = defaultDisplay2.getSupportedRefreshRates()) != null && supportedRefreshRates.length > 0) {
            final float f3 = 0.0f;
            int length2 = supportedRefreshRates.length;
            while (i2 < length2) {
                float f4 = supportedRefreshRates[i2];
                if (f4 > f3) {
                    f3 = f4;
                }
                i2++;
            }
            synchronized (preferredDisplayRefreshRateSyncObject) {
                f = preferredDisplayRefreshRate;
            }
            if (f < f3) {
                engineActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        WindowManager.LayoutParams attributes = EngineActivity.this.getWindow().getAttributes();
                        attributes.preferredRefreshRate = f3;
                        EngineActivity.this.getWindow().setAttributes(attributes);
                        synchronized (Engine.preferredDisplayRefreshRateSyncObject) {
                            float unused = Engine.preferredDisplayRefreshRate = f3;
                        }
                    }
                });
            }
        }
    }

    public static void useExternalCache() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && mContext.getExternalCacheDir() != null) {
            externalCacheDir = true;
        }
    }

    public static void setDeviceOrientation(Activity activity, int i, int i2) {
        setDeviceOrientation(activity, i, i, i2);
    }

    public static void setResolutionScale(float f, float f2) {
        mResolutionScale = new GLSurfaceViewV17.Scale2D(f, f2);
        EngineActivity activity = getActivity();
        if (activity != null) {
            activity.getGLView().setResolutionScale(mResolutionScale);
        }
    }

    public static void setDeviceOrientation(Activity activity, int i, int i2, int i3) {
        if (isDeviceTablet()) {
            activity.setRequestedOrientation(i3);
        } else if (isDevicePhablet()) {
            activity.setRequestedOrientation(i2);
        } else {
            activity.setRequestedOrientation(i);
        }
    }
}
