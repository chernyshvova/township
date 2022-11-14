package com.helpshift.activities;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.model.InfoModelFactory;
import com.helpshift.util.AssetsUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.LocaleContextUtil;
import com.helpshift.util.concurrent.ApiExecutorFactory;

public class MainActivity extends AppCompatActivity {
    public static final String SHOW_IN_FULLSCREEN = "showInFullScreen";
    public static final String TAG = "Helpshift_MainActvty";

    public void attachBaseContext(Context context) {
        if (HelpshiftContext.installCallSuccessful.get()) {
            context = LocaleContextUtil.getContextWithUpdatedLocale(context);
        }
        super.attachBaseContext(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!HelpshiftContext.installCallSuccessful.get()) {
            Log.d(TAG, "Helpshift install is not successful yet.");
            if (HelpshiftContext.verifyInstall()) {
                Log.d(TAG, "Waiting for install call to finish");
                ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
                if (!HelpshiftContext.installCallSuccessful.get()) {
                    Log.d(TAG, "Helpshift install unsuccessful after waiting.");
                    return;
                }
            } else {
                Log.d(TAG, "Helpshift install is not called yet.");
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 30 && getIntent().getBooleanExtra(SHOW_IN_FULLSCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        try {
            Integer num = InfoModelFactory.getInstance().appInfoModel.screenOrientation;
            if (!(num == null || num.intValue() == -1)) {
                setRequestedOrientation(num.intValue());
            }
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to set the requested orientation : ");
            outline24.append(e.getMessage());
            HSLogger.m3241e(TAG, outline24.toString());
        }
        Integer theme = InfoModelFactory.getInstance().sdkInfoModel.getTheme();
        if (AssetsUtil.resourceExists(this, theme)) {
            setTheme(theme.intValue());
        }
    }
}
