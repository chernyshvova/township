package com.playrix.engine;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class Marketing {
    public static final String EXTRA_PARAM_APP_PACKAGE = "app_package";
    public static final String EXTRA_PARAM_APP_UID = "app_uid";
    public static final int RC_EMAIL = 1000;
    public static final int RC_SHARE_CHOOSER = 1002;
    public static final int RC_SHARE_PICK = 1001;
    public static final String SETTINGS_APP_NOTIFICATION_SETTINGS = "android.settings.APP_NOTIFICATION_SETTINGS";

    public static class ShareDialogReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
            if (componentName != null) {
                Marketing.shareDataResultToGLThread(0, componentName.flattenToShortString(), "");
            } else {
                Marketing.shareDataResultToGLThread(1, "", "Fail to get share target");
            }
        }
    }

    public static class ShareResult {
        public static final int CANCELED = 2;
        public static final int FAILED = 1;
        public static final int SUCCEEDED = 0;
    }

    public static boolean canOpenUrl(String str) {
        return Engine.getContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0;
    }

    public static void emailResultToGLThread(final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Marketing.sendEmailResult(i);
            }
        });
    }

    public static Spanned getHtmlEmailBody(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return Html.fromHtml(str);
        }
        return getHtmlEmailBodyNew(str);
    }

    @TargetApi(24)
    public static Spanned getHtmlEmailBodyNew(String str) {
        return Html.fromHtml(str, 0);
    }

    public static boolean onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i == 1000) {
            emailResultToGLThread(0);
            return true;
        }
        if (i == 1001) {
            if (!(intent == null || intent.getComponent() == null)) {
                String flattenToShortString = intent.getComponent().flattenToShortString();
                if (!TextUtils.isEmpty(flattenToShortString)) {
                    try {
                        activity.startActivity(intent);
                        shareDataResultToGLThread(0, flattenToShortString, "");
                    } catch (ActivityNotFoundException e) {
                        shareDataResultToGLThread(1, flattenToShortString, e.toString());
                    }
                    return true;
                }
            }
            shareDataResultToGLThread(2, "", "");
        }
        if (i == 1002) {
            shareDataResultToGLThread(2, "", "");
        }
        return false;
    }

    public static void openNotificationSettings() {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                EngineActivity activity = Engine.getActivity();
                if (activity != null && !activity.isDestroyed()) {
                    Intent intent = new Intent();
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 26) {
                        intent.setAction(Marketing.SETTINGS_APP_NOTIFICATION_SETTINGS);
                        intent.putExtra("android.provider.extra.APP_PACKAGE", Engine.getContext().getPackageName());
                    } else if (i >= 21) {
                        intent.setAction(Marketing.SETTINGS_APP_NOTIFICATION_SETTINGS);
                        intent.putExtra(Marketing.EXTRA_PARAM_APP_PACKAGE, Engine.getContext().getPackageName());
                        intent.putExtra(Marketing.EXTRA_PARAM_APP_UID, Engine.getActivity().getApplicationInfo().uid);
                    } else {
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse("package:" + Engine.getContext().getPackageName()));
                    }
                    activity.startActivity(intent);
                }
            }
        });
    }

    public static void openUrl(final String str) {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    EngineActivity activity = Engine.getActivity();
                    if (activity != null) {
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } catch (ActivityNotFoundException unused) {
                } catch (SecurityException e) {
                    Log.e("Marketing", "SecurityException with startActivity", e);
                }
            }
        });
    }

    public static void sendEmail(String str, String str2, boolean z, String[] strArr, String[] strArr2) {
        final String str3 = str;
        final boolean z2 = z;
        final String str4 = str2;
        final String[] strArr3 = strArr;
        final String[] strArr4 = strArr2;
        if (!Engine.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                    intent.addFlags(1);
                    intent.setType("message/rfc822");
                    intent.putExtra("android.intent.extra.SUBJECT", str3);
                    intent.putExtra("android.intent.extra.TEXT", z2 ? Marketing.getHtmlEmailBody(str4) : str4);
                    if (strArr3 != null && strArr3.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String parse : strArr3) {
                            Uri parse2 = Uri.parse(parse);
                            Engine.getContext().grantUriPermission("com.android.email", parse2, 1);
                            arrayList.add(parse2);
                        }
                        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                    }
                    intent.putExtra("android.intent.extra.EMAIL", strArr4);
                    EngineActivity activity = Engine.getActivity();
                    if (activity != null) {
                        activity.startActivityForResult(intent, 1000);
                        return;
                    }
                } catch (ActivityNotFoundException unused) {
                }
                Marketing.emailResultToGLThread(3);
            }
        })) {
            emailResultToGLThread(3);
        }
    }

    public static native void sendEmailResult(int i);

    public static void shareData(final String str, final String str2, final String str3, final String str4) {
        if (!Engine.runOnUiThread(new Runnable() {
            /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Object[], java.io.Serializable] */
            public void run() {
                String str;
                try {
                    EngineActivity activity = Engine.getActivity();
                    if (activity == null) {
                        Marketing.shareDataResultToGLThread(1, "", "Fail to getActivity");
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    if (!TextUtils.isEmpty(str)) {
                        str = "" + str;
                        intent.putExtra("android.intent.extra.TEXT", str);
                    } else {
                        str = "";
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (!TextUtils.isEmpty(str)) {
                            str = str + " ";
                        }
                        str = str + str2;
                    }
                    intent.putExtra("android.intent.extra.TEXT", str);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra("android.intent.extra.TITLE", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        intent.putExtra("android.intent.extra.SUBJECT", str4);
                    }
                    if (Build.VERSION.SDK_INT < 22) {
                        ArrayList arrayList = new ArrayList();
                        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
                        if (queryIntentActivities.isEmpty()) {
                            Marketing.shareDataResultToGLThread(1, "", "No suitable activities to share");
                            return;
                        }
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            Intent intent2 = new Intent("android.intent.action.SEND");
                            intent2.setType("text/plain");
                            intent2.setPackage(resolveInfo.activityInfo.packageName);
                            arrayList.add(intent2);
                        }
                        Intent intent3 = new Intent();
                        intent3.setAction("android.intent.action.PICK_ACTIVITY");
                        intent3.putExtra("android.intent.extra.TITLE", str3);
                        intent3.putExtra("android.intent.extra.INTENT", intent);
                        intent3.putExtra("android.intent.extra.INITIAL_INTENTS", arrayList.toArray());
                        activity.startActivityForResult(intent3, 1001);
                        return;
                    }
                    activity.startActivityForResult(Intent.createChooser(intent, str3, PendingIntent.getBroadcast(activity, 0, new Intent(activity, ShareDialogReceiver.class), 134217728).getIntentSender()), 1002);
                } catch (Exception e) {
                    Marketing.shareDataResultToGLThread(1, "", e.toString());
                }
            }
        })) {
            shareDataResultToGLThread(1, "", "Fail to runOnUiThread");
        }
    }

    public static native void shareDataResult(int i, String str, String str2);

    public static void shareDataResultToGLThread(final int i, final String str, final String str2) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Marketing.shareDataResult(i, str, str2);
            }
        });
    }
}
