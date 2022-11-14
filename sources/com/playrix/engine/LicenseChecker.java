package com.playrix.engine;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.facebook.internal.FetchedAppSettings;
import java.util.regex.Pattern;

public class LicenseChecker {
    public static final int LICENSED = 0;
    public static final int LICENSED_OLD_KEY = 2;
    public static final int RESULT_BAD_RESPONSE = 3;
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_SKIPPED = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final LicensingService service = new LicensingService();

    public static class LicensingService implements ServiceConnection {
        public Context context;
        public ILicensingService licensingService;
        public long requestId;
        public int requestNonce;

        public LicensingService() {
            this.context = null;
            this.licensingService = null;
            this.requestId = 0;
            this.requestNonce = 0;
        }

        private synchronized void bindService() {
            try {
                this.context = Engine.getContext();
                if (!this.context.bindService(new Intent("com.android.vending.licensing.ILicensingService").setPackage("com.android.vending"), this, 1)) {
                    onError(1, "Can't bind service");
                } else {
                    return;
                }
            } catch (Exception e) {
                onError(1, e.toString());
            }
        }

        public static boolean checkResponseData(String str, int i, int i2) {
            try {
                int indexOf = str.indexOf(58);
                if (indexOf >= 0) {
                    str = str.substring(0, indexOf);
                }
                String[] split = TextUtils.split(str, Pattern.quote(FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR));
                if (split.length < 6 || i != Integer.parseInt(split[0]) || i2 != Integer.parseInt(split[1])) {
                    return false;
                }
                Context context2 = Engine.getContext();
                String packageName = context2.getPackageName();
                int i3 = context2.getPackageManager().getPackageInfo(packageName, 0).versionCode;
                if (packageName.equals(split[2]) && i3 == Integer.parseInt(split[3])) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        private synchronized void onError(int i, String str) {
            onResult(i, 0, str, (String) null);
        }

        /* access modifiers changed from: private */
        public synchronized void onResult(int i, int i2, String str, String str2) {
            if (this.requestId != 0) {
                long j = this.requestId;
                this.requestId = 0;
                final long j2 = j;
                final int i3 = i;
                final int i4 = i2;
                final String str3 = str;
                final String str4 = str2;
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        LicenseChecker.nativeOnRequestResult(j2, i3, i4, str3, str4);
                    }
                });
            }
        }

        private synchronized void processRequest() {
            if (this.requestId != 0) {
                try {
                    this.licensingService.checkLicense((long) this.requestNonce, this.context.getPackageName(), new ILicenseResultListener.Stub() {
                        public void verifyLicense(int i, String str, String str2) {
                            LicensingService.this.onResult(((i == 0 || i == 2) && !LicensingService.checkResponseData(str, i, LicensingService.this.requestNonce)) ? 3 : 0, i, str, str2);
                        }
                    });
                } catch (Exception e) {
                    onError(1, e.toString());
                }
            } else {
                return;
            }
            return;
        }

        /* access modifiers changed from: private */
        public synchronized void unbindService() {
            if (this.licensingService != null) {
                try {
                    this.context.unbindService(this);
                } catch (Exception unused) {
                }
                this.licensingService = null;
                this.context = null;
            }
        }

        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ILicensingService asInterface = ILicensingService.Stub.asInterface(iBinder);
            this.licensingService = asInterface;
            if (this.context == null || asInterface == null) {
                onError(1, "Service is null");
            } else {
                processRequest();
            }
        }

        public synchronized void onServiceDisconnected(ComponentName componentName) {
            this.licensingService = null;
            this.context = null;
            onError(1, "Service disconnected");
        }

        public synchronized void request(long j, int i) {
            if (this.requestId != 0) {
                onError(2, "Skip request");
                unbindService();
            }
            this.requestId = j;
            this.requestNonce = i;
            if (this.context == null || this.licensingService == null) {
                bindService();
            } else {
                processRequest();
            }
        }
    }

    public static void cancel() {
        service.unbindService();
    }

    public static native void nativeOnRequestResult(long j, int i, int i2, String str, String str2);

    public static void request(long j, int i) {
        service.request(j, i);
    }
}
