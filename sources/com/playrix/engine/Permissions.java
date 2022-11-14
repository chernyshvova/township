package com.playrix.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;

public class Permissions {
    public static final int REQUEST_PERMISSIONS = 0;
    public static final String logTag = "Permissions";
    public static volatile boolean processingRequest = false;

    public static boolean hasPermission(String str) {
        try {
            return ContextCompat.checkSelfPermission(Engine.getContext(), str) == 0;
        } catch (Exception e) {
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("Error hasPermission '", str, "' : ");
            outline27.append(e.toString());
            Log.e(logTag, outline27.toString());
            return false;
        }
    }

    public static boolean isAvailable() {
        try {
            return Build.VERSION.SDK_INT >= 23;
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error isAvailable : ");
            outline24.append(e.toString());
            Log.e(logTag, outline24.toString());
            return false;
        }
    }

    public static native void nativeOnRequestPermissionsResult(String[] strArr);

    public static boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = 0;
        if (i != 0) {
            return false;
        }
        final ArrayList arrayList = new ArrayList();
        while (i2 < strArr.length && i2 < iArr.length) {
            if (iArr[i2] == 0 && strArr[i2] != null) {
                arrayList.add(strArr[i2]);
            }
            i2++;
        }
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                ArrayList arrayList = arrayList;
                Permissions.nativeOnRequestPermissionsResult((String[]) arrayList.toArray(new String[arrayList.size()]));
                boolean unused = Permissions.processingRequest = false;
            }
        });
        return true;
    }

    public static boolean requestPermissions(String[] strArr) {
        try {
            if (processingRequest) {
                Log.e(logTag, "Error requestPermissions, already processing");
                return false;
            }
            EngineActivity activity = Engine.getActivity();
            if (activity == null) {
                Log.e(logTag, "No activity to requestPermissions");
                return false;
            }
            processingRequest = true;
            ActivityCompat.requestPermissions(activity, strArr, 0);
            return true;
        } catch (Exception e) {
            processingRequest = false;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error requestPermissions :");
            outline24.append(e.toString());
            Log.e(logTag, outline24.toString());
            return false;
        }
    }

    public static boolean shouldShowRationale(String str) {
        try {
            EngineActivity activity = Engine.getActivity();
            if (activity == null) {
                return false;
            }
            return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
        } catch (Exception e) {
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("Error shouldShowRationale '", str, "' : ");
            outline27.append(e.toString());
            Log.e(logTag, outline27.toString());
            return false;
        }
    }
}
