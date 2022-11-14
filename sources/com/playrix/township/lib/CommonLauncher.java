package com.playrix.township.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.playrix.engine.Engine;
import com.playrix.engine.Logger;
import com.playrix.township.C3342R;
import java.io.File;

public abstract class CommonLauncher extends Activity {
    public final String TAG = "[PlayrixLauncher] ";

    public void StartGame() {
        launchMainActivity(getActivityClass());
        Logger.logDebug("[PlayrixLauncher] finishing launcher activity");
        finish();
    }

    public boolean checkDate() {
        if (Utils.checkCurrentDate()) {
            return true;
        }
        WarningNotification.show(WarningNotification.TAG_DATE_WARN);
        return false;
    }

    public boolean checkDumpFiles() {
        return true;
    }

    public boolean checkFreeSpace() {
        if (Utils.checkFreeSpace()) {
            return true;
        }
        WarningNotification.show(WarningNotification.TAG_FREESPACE_WARN);
        return false;
    }

    public boolean checkInetPermission() {
        if (Utils.checkInetPermission(this)) {
            return true;
        }
        Dialogs.showCloseDialog(this, getString(C3342R.string.app_name), Utils.getText("NoInternet"));
        return false;
    }

    public boolean checkStorage() {
        if (Utils.checkExternalStorage(this)) {
            return true;
        }
        Dialogs.showCloseDialog(this, getString(C3342R.string.app_name), Utils.getText("CheckStorage"));
        return false;
    }

    public boolean checkWriteToAppFolder() {
        File file = new File(Engine.getWriteablePath() + "/saves");
        if (!file.exists()) {
            file = new File(Engine.getWriteablePath());
        }
        if (file.exists() && (!file.isDirectory() || !file.canRead() || !file.canWrite())) {
            return false;
        }
        String[] strArr = {"GlobalVars.xml", "mGameInfo.xml"};
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            try {
                File file2 = new File(Engine.getWriteablePath() + "/saves", str);
                if (file2.exists() && file2.isFile() && (!file2.canRead() || !file2.canWrite())) {
                    return false;
                }
            } catch (SecurityException unused) {
                return false;
            } catch (Exception unused2) {
            }
        }
        return true;
    }

    public abstract Class<?> getActivityClass();

    public void launchMainActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        Intent intent2 = getIntent();
        intent.setData(intent2.getData());
        String action = intent2.getAction();
        if (!TextUtils.isEmpty(action)) {
            intent.setAction(action);
        }
        Bundle extras = intent2.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
    }

    public void loadResourcesAndStart() {
        StartGame();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Engine.getActivity() != null) {
            Logger.logDebug("[PlayrixLauncher] Already started, just resume");
            StartGame();
        } else if (checkStorage() && checkInetPermission()) {
            if (!checkWriteToAppFolder()) {
                Logger.logError("[PlayrixLauncher] file permissions error");
                Dialogs.showCloseDialog(this, getString(C3342R.string.app_name), Utils.getText("FilesUnavailable"));
                return;
            }
            checkDate();
            checkFreeSpace();
            if (!checkDumpFiles()) {
                Logger.logWarning("[PlayrixLauncher] skip the checking dump files");
            }
            loadResourcesAndStart();
        }
    }
}
