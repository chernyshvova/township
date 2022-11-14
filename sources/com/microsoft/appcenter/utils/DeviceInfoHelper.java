package com.microsoft.appcenter.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import com.facebook.internal.ServerProtocol;
import com.microsoft.appcenter.ingestion.models.Device;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceInfoHelper {

    public static class DeviceInfoException extends Exception {
        public DeviceInfoException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static synchronized Device getDeviceInfo(Context context) throws DeviceInfoException {
        Device device;
        synchronized (DeviceInfoHelper.class) {
            device = new Device();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                device.appVersion = packageInfo.versionName;
                device.appBuild = String.valueOf(packageInfo.versionCode);
                device.appNamespace = context.getPackageName();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (!TextUtils.isEmpty(networkCountryIso)) {
                    device.carrierCountry = networkCountryIso;
                }
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    device.carrierName = networkOperatorName;
                }
            } catch (Exception e) {
                AppCenterLog.error("AppCenter", "Cannot retrieve package info", e);
                throw new DeviceInfoException("Cannot retrieve package info", e);
            } catch (Exception e2) {
                AppCenterLog.error("AppCenter", "Cannot retrieve carrier info", e2);
            }
            device.locale = Locale.getDefault().toString();
            device.model = Build.MODEL;
            device.oemName = Build.MANUFACTURER;
            device.osApiLevel = Integer.valueOf(Build.VERSION.SDK_INT);
            device.osName = "Android";
            device.osVersion = Build.VERSION.RELEASE;
            device.osBuild = Build.ID;
            try {
                device.screenSize = getScreenSize(context);
            } catch (Exception e3) {
                AppCenterLog.error("AppCenter", "Cannot retrieve screen size", e3);
            }
            device.sdkName = "appcenter.android";
            device.sdkVersion = "4.3.1";
            device.timeZoneOffset = Integer.valueOf((TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60) / 1000);
        }
        return device;
    }

    @SuppressLint({"SwitchIntDef"})
    public static String getScreenSize(Context context) {
        int i;
        int i2;
        Point point = new Point();
        Display display = ((DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).getDisplay(0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        int rotation = display.getRotation();
        if (rotation == 1 || rotation == 3) {
            int i3 = point.x;
            int i4 = point.y;
            i2 = i3;
            i = i4;
        } else {
            i = point.x;
            i2 = point.y;
        }
        return i + "x" + i2;
    }
}
