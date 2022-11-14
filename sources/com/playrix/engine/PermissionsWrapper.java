package com.playrix.engine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PermissionsWrapper {
    public static final int PERMISSIONS_REQUEST_CODE = 17;
    public Activity mActivity;
    public IDelegate mDelegate = null;
    public PermissionConf[] mPermissionsToCheck;
    public boolean mRequestInProcess = false;

    public interface IDelegate {
        void onRequestPermissionsResult(String[] strArr, String[] strArr2);
    }

    public static class PermissionConf {
        public String mName;
        public String mShutdownMessage;

        public PermissionConf(String str, String str2) {
            this.mName = str;
            this.mShutdownMessage = str2;
        }
    }

    public PermissionsWrapper(Activity activity, PermissionConf[] permissionConfArr, IDelegate iDelegate) {
        if (activity != null) {
            this.mActivity = activity;
            this.mDelegate = iDelegate;
            this.mPermissionsToCheck = null;
            if (permissionConfArr != null && Build.VERSION.SDK_INT >= 23) {
                this.mPermissionsToCheck = (PermissionConf[]) Arrays.copyOf(permissionConfArr, permissionConfArr.length);
                return;
            }
            return;
        }
        throw new NullPointerException("activity is null");
    }

    private boolean isPermissionGranted(String str) {
        return ContextCompat.checkSelfPermission(this.mActivity, str) == 0;
    }

    private void shutdownAlert(String str) {
        new AlertDialog.Builder(this.mActivity).setMessage(str).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionsWrapper.this.mActivity.finish();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                PermissionsWrapper.this.mActivity.finish();
            }
        }).show();
    }

    public void demandPermissions() {
        if (!this.mRequestInProcess) {
            this.mRequestInProcess = true;
            ArrayList arrayList = new ArrayList();
            for (PermissionConf permissionConf : this.mPermissionsToCheck) {
                if (!isPermissionGranted(permissionConf.mName)) {
                    arrayList.add(permissionConf.mName);
                }
            }
            ActivityCompat.requestPermissions(this.mActivity, (String[]) arrayList.toArray(new String[arrayList.size()]), 17);
        }
    }

    public boolean hasUngrantedPermissions() {
        PermissionConf[] permissionConfArr = this.mPermissionsToCheck;
        if (permissionConfArr == null) {
            return false;
        }
        for (PermissionConf permissionConf : permissionConfArr) {
            if (!isPermissionGranted(permissionConf.mName)) {
                return true;
            }
        }
        return false;
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 17) {
            return false;
        }
        if (this.mDelegate != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (PermissionConf permissionConf : this.mPermissionsToCheck) {
                if (isPermissionGranted(permissionConf.mName)) {
                    arrayList.add(permissionConf.mName);
                } else {
                    if (!permissionConf.mShutdownMessage.isEmpty()) {
                        arrayList3.add(permissionConf);
                    }
                    arrayList2.add(permissionConf.mName);
                }
            }
            if (arrayList3.size() > 0) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    shutdownAlert(((PermissionConf) it.next()).mShutdownMessage);
                }
            } else {
                this.mDelegate.onRequestPermissionsResult((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        this.mRequestInProcess = false;
        return true;
    }
}
