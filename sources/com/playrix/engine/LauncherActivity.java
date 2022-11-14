package com.playrix.engine;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.Dialog;

public class LauncherActivity extends Activity {
    public static final String TAG = "[PlayrixEngine] ";

    public static void finishApplication(Activity activity, DialogInterface dialogInterface) {
        if (isUsableActivity(activity)) {
            dialogInterface.dismiss();
        }
        activity.finish();
        System.exit(0);
    }

    public static boolean isUsableActivity(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public static void launchMainActivity(Activity activity, String str) {
        try {
            Intent intent = new Intent(activity, Class.forName(str));
            Intent intent2 = activity.getIntent();
            intent.setData(intent2.getData());
            String action = intent2.getAction();
            if (!TextUtils.isEmpty(action)) {
                intent.setAction(action);
            }
            Bundle extras = intent2.getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            if (!Engine.isProductionBuild()) {
                Logger.logDebug("[PlayrixEngine] Starting activity for action " + action + ", data " + intent.getData() + ", extras: " + extras + ", flags: " + Integer.toHexString(intent.getFlags()));
            }
            activity.startActivity(intent);
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("[PlayrixEngine] Launch error:"));
        }
        activity.finish();
    }

    public static void showLibrariesLoadFailedDialog(final Activity activity) {
        if (!isUsableActivity(activity)) {
            Log.e(TAG, "Unusable activity in showLibrariesLoadFailedDialog, skipping.");
            return;
        }
        Dialog.Builder builder = new Dialog.Builder(activity);
        builder.setCancelable(false);
        builder.setNegativeButton(activity.getString(C3204R.string.closeButton), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                LauncherActivity.finishApplication(activity, dialogInterface);
            }
        });
        final String string = GlobalConstants.getString("app_store_url", "");
        if (!TextUtils.isEmpty(string)) {
            builder.setPositiveButton(activity.getString(C3204R.string.installButton), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
                    } catch (Exception e) {
                        Log.w(LauncherActivity.TAG, e);
                    }
                    LauncherActivity.finishApplication(activity, dialogInterface);
                }
            });
        }
        builder.setMessage(activity.getString(C3204R.string.installError));
        builder.create().show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(C3204R.style.MainTheme);
        if (!NativeThread.getInstance().isLibrariesLoaded()) {
            showLibrariesLoadFailedDialog(this);
        } else {
            launchMainActivity(this, GlobalConstants.getString("app_main_activity", ""));
        }
    }
}
