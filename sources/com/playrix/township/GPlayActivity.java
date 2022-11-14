package com.playrix.township;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.security.ProviderInstaller;
import com.playrix.engine.Engine;
import com.playrix.engine.Logger;
import com.playrix.gplay.GoogleGameCenter;
import com.playrix.township.lib.GameActivity;
import com.playrix.township.lib.Settings;
import com.playrix.township.lib.Utils;

public class GPlayActivity extends GameActivity {
    public GoogleGameCenter mGameCenter;

    public void onCreate(Bundle bundle) {
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences != null && preferences.getBoolean("_GameCenter_", true) && !Settings.isCityDeleted()) {
            GoogleGameCenter googleGameCenter = new GoogleGameCenter(this);
            this.mGameCenter = googleGameCenter;
            if (googleGameCenter != null) {
                registerActivityLifecycleCallbacks(googleGameCenter);
            }
        }
        super.onCreate(bundle);
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Play services version: ");
        outline24.append(Utils.getAppVersionInfo("com.google.android.gms"));
        Logger.logInfo(outline24.toString());
        ProviderInstaller.installIfNeededAsync(this, new ProviderInstaller.ProviderInstallListener() {
            public void onProviderInstallFailed(int i, Intent intent) {
                StringBuilder outline25 = GeneratedOutlineSupport.outline25("Security provider installation failed, code ", i, " - ");
                outline25.append(GoogleApiAvailability.getInstance().getErrorString(i));
                Logger.logWarning(outline25.toString());
            }

            public void onProviderInstalled() {
                Logger.logDebug("Security provider installed");
            }
        });
    }
}
