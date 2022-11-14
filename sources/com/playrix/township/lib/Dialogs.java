package com.playrix.township.lib;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.playrix.engine.Dialog;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineActivity;
import com.playrix.engine.GlobalConstants;
import com.playrix.engine.ImmersiveMode;
import com.playrix.engine.Logger;

public class Dialogs {
    public static final String TAG = "Dialogs";

    public static void checkedDissmiss(Activity activity, DialogInterface dialogInterface) {
        if (Utils.isUsableActivity(activity)) {
            dialogInterface.dismiss();
        } else {
            Logger.logError("Dialogs Skipping dialog dismiss: unusable activity");
        }
    }

    public static void showCloseDialog(final Activity activity, String str, String str2) {
        if (!Utils.isUsableActivity(activity)) {
            Logger.logError("Dialogs Unusable activity in showCloseDialog, skipping.");
            return;
        }
        String text = Utils.getText("CloseButton");
        Dialog.Builder builder = new Dialog.Builder(activity);
        builder.setMessage(str2).setCancelable(false).setTitle(str).setPositiveButton(text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Dialogs.checkedDissmiss(activity, dialogInterface);
                activity.finish();
            }
        });
        showDialog(builder.create());
    }

    public static boolean showDialog(Dialog dialog) {
        if (Utils.isUsableActivity(dialog.getOwnerActivity())) {
            ImmersiveMode.showDialog(dialog, new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (Utils.isUsablePlayrixActivity()) {
                        Engine.getActivity().onDialogFocusChanged(false);
                    }
                }
            });
            return true;
        }
        Logger.logError("Dialogs Can't show dialog: unusable activity in context");
        return false;
    }

    public static void showLibrariesLoadFailedDialog(final Activity activity) {
        if (!Utils.isUsableActivity(activity)) {
            Logger.logError("Dialogs Unusable activity in showLibrariesLoadFailedDialog, skipping.");
            return;
        }
        C33514 r0 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 1) {
                    try {
                        Utils.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(GlobalConstants.getString("app_store_url", "market://details?id=com.playrix.township"))), activity);
                    } catch (Exception unused) {
                        return;
                    }
                }
                Dialogs.checkedDissmiss(activity, dialogInterface);
                activity.finish();
            }
        };
        Dialog.Builder.ButtonInfo[] buttonInfoArr = {new Dialog.Builder.ButtonInfo(Utils.getText("CloseButton"), r0), new Dialog.Builder.ButtonInfo(Utils.getText("InstallButton"), r0)};
        Dialog.Builder builder = new Dialog.Builder(activity);
        builder.setMessage(Utils.getText("SystemInstallError")).setCancelable(false).setButtons(buttonInfoArr);
        builder.setMessage("SystemInstallError").setCancelable(false).setButtons(buttonInfoArr);
        showDialog(builder.create());
    }

    public static void showSimpleDialog(final String str, final String str2, final Runnable runnable) {
        final EngineActivity activity = Engine.getActivity();
        if (!Utils.isUsableActivity(activity)) {
            Logger.logError("Dialogs Unusable activity in showSimpleDialog, skipping.");
        } else {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Dialog.Builder builder = new Dialog.Builder(activity);
                    builder.setMessage(str2).setCancelable(false).setPositiveButton(activity.getString(17039370), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Dialogs.checkedDissmiss(activity, dialogInterface);
                            Runnable runnable = runnable;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                    });
                    if (!TextUtils.isEmpty(str)) {
                        builder.setTitle(str);
                    }
                    Dialogs.showDialog(builder.create());
                }
            });
        }
    }

    public static void checkedDissmiss(Dialog dialog) {
        if (dialog == null || !Utils.isUsableActivity(dialog.getOwnerActivity())) {
            Logger.logError("Dialogs Skipping dialog dismiss: unusable activity");
        } else {
            dialog.dismiss();
        }
    }
}
