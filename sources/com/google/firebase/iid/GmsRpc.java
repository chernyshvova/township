package com.google.firebase.iid;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.Utility;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class GmsRpc {
    public final FirebaseApp app;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final Provider<HeartBeatInfo> heartbeatInfo;
    public final Metadata metadata;
    public final Rpc rpc;
    public final Provider<UserAgentPublisher> userAgentPublisher;

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        firebaseApp.checkNotDeleted();
        Rpc rpc2 = new Rpc(firebaseApp.applicationContext);
        this.app = firebaseApp;
        this.metadata = metadata2;
        this.rpc = rpc2;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }

    public final Task<String> extractResponseWhenComplete(Task<Bundle> task) {
        return task.continueWith(FirebaseIidExecutors.DIRECT_EXECUTOR, new GmsRpc$$Lambda$0(this));
    }

    public final Task<Bundle> startRpc(String str, String str2, String str3, Bundle bundle) {
        int i;
        String str4;
        String str5;
        HeartBeatInfo.HeartBeat heartBeatCode;
        PackageInfo packageInfo;
        bundle.putString("scope", str3);
        bundle.putString(NotificationCompat.MessagingStyle.Message.KEY_SENDER, str2);
        bundle.putString("subtype", str2);
        bundle.putString(AppsFlyerProperties.APP_ID, str);
        FirebaseApp firebaseApp = this.app;
        firebaseApp.checkNotDeleted();
        bundle.putString("gmp_app_id", firebaseApp.options.applicationId);
        Metadata metadata2 = this.metadata;
        synchronized (metadata2) {
            if (metadata2.gmsVersionCode == 0 && (packageInfo = metadata2.getPackageInfo("com.google.android.gms")) != null) {
                metadata2.gmsVersionCode = packageInfo.versionCode;
            }
            i = metadata2.gmsVersionCode;
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.metadata.getAppVersionCode());
        Metadata metadata3 = this.metadata;
        synchronized (metadata3) {
            if (metadata3.appVersionName == null) {
                metadata3.populateAppVersionInfo();
            }
            str4 = metadata3.appVersionName;
        }
        bundle.putString("app_ver_name", str4);
        FirebaseApp firebaseApp2 = this.app;
        firebaseApp2.checkNotDeleted();
        try {
            str5 = Base64.encodeToString(MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA1).digest(firebaseApp2.name.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            str5 = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", str5);
        try {
            String str6 = ((AutoValue_InstallationTokenResult) ((InstallationTokenResult) Tasks.await(this.firebaseInstallations.getToken(false)))).token;
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("Goog-Firebase-Installations-Auth", str6);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-".concat("21.0.0"));
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo.get();
        UserAgentPublisher userAgentPublisher2 = this.userAgentPublisher.get();
        if (!(heartBeatInfo == null || userAgentPublisher2 == null || (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid")) == HeartBeatInfo.HeartBeat.NONE)) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.code));
            bundle.putString("Firebase-Client", userAgentPublisher2.getUserAgent());
        }
        return this.rpc.send(bundle);
    }
}
