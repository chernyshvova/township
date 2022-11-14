package com.helpshift.common.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import com.facebook.internal.security.CertificateUtil;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.platform.Device;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.meta.dto.DeviceDiskSpaceDTO;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.PermissionUtil;
import com.helpshift.util.StringUtils;
import com.vungle.warren.VungleApiClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public class AndroidDevice implements Device {
    public static final String KEY_DEVICE_ID = "key_support_device_id";
    public static final String KEY_PUSH_TOKEN = "key_push_token";
    public BackupDAO backupDAO;
    public String cacheDeviceId;
    public String cachedPushToken;
    public final Context context;
    public KVStore kvStore;

    /* renamed from: com.helpshift.common.platform.AndroidDevice$1 */
    public static /* synthetic */ class C25031 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$platform$Device$PermissionType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.common.platform.Device$PermissionType[] r0 = com.helpshift.common.platform.Device.PermissionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$platform$Device$PermissionType = r0
                r1 = 1
                com.helpshift.common.platform.Device$PermissionType r2 = com.helpshift.common.platform.Device.PermissionType.READ_STORAGE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$common$platform$Device$PermissionType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.platform.Device$PermissionType r2 = com.helpshift.common.platform.Device.PermissionType.WRITE_STORAGE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidDevice.C25031.<clinit>():void");
        }
    }

    public AndroidDevice(Context context2, KVStore kVStore, BackupDAO backupDAO2) {
        this.context = context2;
        this.kvStore = kVStore;
        this.backupDAO = backupDAO2;
    }

    private Device.PermissionState checkStoragePermissions(String str) {
        int oSVersionNumber = getOSVersionNumber();
        if (oSVersionNumber < 19) {
            return Device.PermissionState.AVAILABLE;
        }
        if (ApplicationUtil.isPermissionGranted(this.context, str)) {
            return Device.PermissionState.AVAILABLE;
        }
        if (oSVersionNumber < 23) {
            return Device.PermissionState.UNAVAILABLE;
        }
        if (PermissionUtil.hasPermissionInManifest(this.context, str)) {
            return Device.PermissionState.REQUESTABLE;
        }
        return Device.PermissionState.UNAVAILABLE;
    }

    public void changeLocale(Locale locale) {
        Resources resources = this.context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public Device.PermissionState checkPermission(Device.PermissionType permissionType) {
        int ordinal = permissionType.ordinal();
        if (ordinal == 0) {
            return checkStoragePermissions("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (ordinal != 1) {
            return null;
        }
        return checkStoragePermissions("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public String getAndroidId() {
        try {
            return Settings.Secure.getString(this.context.getContentResolver(), VungleApiClient.ANDROID_ID);
        } catch (Exception e) {
            HSLogger.m3242e("AndroidDevice", "Exception while getting android_id", e);
            return null;
        }
    }

    public String getApiVersion() {
        return NetworkConstants.apiVersion;
    }

    public String getAppIdentifier() {
        return this.context.getPackageName();
    }

    public String getAppName() {
        return ApplicationUtil.getApplicationName(this.context);
    }

    public String getAppVersion() {
        return ApplicationUtil.getApplicationVersion(this.context);
    }

    public String getBatteryLevel() {
        Intent registerReceiver = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return "";
        }
        int intExtra = (int) ((((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))) * 100.0f);
        return intExtra + "%";
    }

    public String getBatteryStatus() {
        Intent registerReceiver = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return "Not charging";
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return "Charging";
        }
        return "Not charging";
    }

    public String getCarrierName() {
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public String getDeviceId() {
        String str = this.cacheDeviceId;
        if (str != null) {
            return str;
        }
        String string = this.kvStore.getString("key_support_device_id");
        this.cacheDeviceId = string;
        if (StringUtils.isEmpty(string)) {
            String str2 = (String) this.backupDAO.getValue("key_support_device_id");
            this.cacheDeviceId = str2;
            if (!StringUtils.isEmpty(str2)) {
                this.kvStore.setString("key_support_device_id", this.cacheDeviceId);
            }
        } else {
            this.backupDAO.storeValue("key_support_device_id", this.cacheDeviceId);
        }
        if (StringUtils.isEmpty(this.cacheDeviceId)) {
            String uuid = UUID.randomUUID().toString();
            this.cacheDeviceId = uuid;
            this.kvStore.setString("key_support_device_id", uuid);
            this.backupDAO.storeValue("key_support_device_id", this.cacheDeviceId);
        }
        return this.cacheDeviceId;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public DeviceDiskSpaceDTO getDiskSpace() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        double availableBlocksLong = (double) statFs.getAvailableBlocksLong();
        double blockSizeLong = (double) statFs.getBlockSizeLong();
        Double.isNaN(availableBlocksLong);
        Double.isNaN(blockSizeLong);
        double round = (double) Math.round(((availableBlocksLong * blockSizeLong) / 1.073741824E9d) * 100.0d);
        Double.isNaN(round);
        double blockCountLong = (double) statFs.getBlockCountLong();
        double blockSizeLong2 = (double) statFs.getBlockSizeLong();
        Double.isNaN(blockCountLong);
        Double.isNaN(blockSizeLong2);
        double round2 = (double) Math.round(((blockCountLong * blockSizeLong2) / 1.073741824E9d) * 100.0d);
        Double.isNaN(round2);
        return new DeviceDiskSpaceDTO((round2 / 100.0d) + " GB", (round / 100.0d) + " GB", (String) null, (String) null);
    }

    public String getLanguage() {
        return Locale.getDefault().toString();
    }

    public Locale getLocale() {
        Configuration configuration = this.context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            return configuration.getLocales().get(0);
        }
        return configuration.locale;
    }

    public String getNetworkType() {
        NetworkInfo activeNetworkInfo;
        String str = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                str = activeNetworkInfo.getTypeName();
            }
        } catch (SecurityException unused) {
        }
        return str == null ? "Unknown" : str;
    }

    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public int getOSVersionNumber() {
        return Build.VERSION.SDK_INT;
    }

    public String getPlatformName() {
        return "Android";
    }

    public String getPushToken() {
        if (this.cachedPushToken == null) {
            this.cachedPushToken = this.kvStore.getString(KEY_PUSH_TOKEN);
        }
        return this.cachedPushToken;
    }

    public String getRom() {
        return System.getProperty("os.version") + CertificateUtil.DELIMITER + Build.FINGERPRINT;
    }

    public String getSDKVersion() {
        return "7.11.0";
    }

    public String getSimCountryIso() {
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getSimCountryIso();
    }

    public String getTimeStamp() {
        return new SimpleDateFormat(HSDateFormatSpec.STORAGE_TIME_PATTERN, Locale.ENGLISH).format(new Date());
    }

    public String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    public long getTimeZoneOffSet() {
        TimeZone timeZone = new GregorianCalendar().getTimeZone();
        return (long) (timeZone.getDSTSavings() + timeZone.getRawOffset());
    }

    public boolean is24HourFormat() {
        return DateFormat.is24HourFormat(this.context);
    }

    public void setPushToken(String str) {
        this.kvStore.setString(KEY_PUSH_TOKEN, str);
        this.cachedPushToken = str;
    }

    public void updateDeviceIdInBackupDAO() {
        String string = this.kvStore.getString("key_support_device_id");
        if (!StringUtils.isEmpty(string)) {
            this.backupDAO.storeValue("key_support_device_id", string);
        }
    }
}
