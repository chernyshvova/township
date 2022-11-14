package com.playrix.engine;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.playrix.engine.LifeCycleActivity;
import com.playrix.googlesignin.BuildConfig;

public class GoogleSignInWrapper implements LifeCycleActivity.ILifecycleCallbacks {
    public static final int REQUEST_CODE_SIGN_IN = 9201;
    public static final int SIGN_IN_RESULT_CANCELED = 1;
    public static final int SIGN_IN_RESULT_FAILED = 3;
    public static final int SIGN_IN_RESULT_SUCCESS = 0;
    public static final int SIGN_IN_RESULT_UNAVAILABLE = 2;
    public GoogleSignInAccount signInAccount = null;
    public GoogleSignInClient signInClient = null;

    public static void createActivityLifecycleCallbacks(GoogleSignInWrapper googleSignInWrapper) {
        Engine.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof EngineActivity) {
                    Engine.getActivity().registerActivityLifecycleCallbacks(GoogleSignInWrapper.this);
                }
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }
        });
    }

    public static int getAuthenticationErrorResult(int i) {
        verboseLog("getAuthenticationErrorResult: " + i);
        return (i == 13 || i == 12501) ? 1 : 3;
    }

    public static String getSdkVersion() {
        return BuildConfig.GOOGLE_AUTH_VERSION;
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            onSignInSucceeded(task.getResult(ApiException.class));
        } catch (ApiException e) {
            onSignInError(getAuthenticationErrorResult(e.getStatusCode()), e.toString());
        } catch (Exception e2) {
            onSignInError(3, e2.toString());
        }
    }

    public static boolean isAvailable() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Engine.getContext()) == 0;
    }

    public static native void nativeOnSignInResult(int i, String str, String str2, String str3, String str4);

    public static native void nativeOnVerboseLog(String str);

    public static void onSignInError(int i, String str) {
        onSignInResult(i, str, (String) null, (String) null, (String) null);
    }

    public static void onSignInResult(int i, String str, String str2, String str3, String str4) {
        final int i2 = i;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                GoogleSignInWrapper.nativeOnSignInResult(i2, str5, str6, str7, str8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onSignInSucceeded(GoogleSignInAccount googleSignInAccount) {
        try {
            synchronized (this) {
                this.signInAccount = googleSignInAccount;
            }
            onSignInResult(0, (String) null, googleSignInAccount.getId(), googleSignInAccount.getIdToken(), googleSignInAccount.getEmail());
        } catch (Exception e) {
            onSignInError(3, e.toString());
        }
    }

    public static void verboseLog(final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                GoogleSignInWrapper.nativeOnVerboseLog(str);
            }
        });
    }

    public boolean initialize(final String str) {
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
                if (!TextUtils.isEmpty(str)) {
                    builder.requestIdToken(str);
                }
                builder.requestEmail();
                GoogleSignInClient unused = GoogleSignInWrapper.this.signInClient = GoogleSignIn.getClient(Engine.getContext(), builder.build());
                GoogleSignInWrapper.createActivityLifecycleCallbacks(GoogleSignInWrapper.this);
            }
        });
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != 9201) {
            return false;
        }
        handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
        return true;
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onLowMemory() {
    }

    public void onNewIntent(Intent intent) {
    }

    public synchronized void signIn() {
        if (this.signInClient == null) {
            onSignInError(3, "Not initialized");
            return;
        }
        EngineActivity activity = Engine.getActivity();
        if (activity == null) {
            onSignInError(3, "No activity");
        } else {
            activity.startActivityForResult(this.signInClient.getSignInIntent(), REQUEST_CODE_SIGN_IN);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void signInCheck() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = isAvailable()     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x000f
            r0 = 2
            java.lang.String r1 = ""
            onSignInError(r0, r1)     // Catch:{ all -> 0x006c }
            monitor-exit(r3)
            return
        L_0x000f:
            com.google.android.gms.auth.api.signin.GoogleSignInClient r0 = r3.signInClient     // Catch:{ all -> 0x006c }
            r1 = 3
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = "Not initialized"
            onSignInError(r1, r0)     // Catch:{ all -> 0x006c }
            monitor-exit(r3)
            return
        L_0x001b:
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = r3.signInAccount     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0041
            android.content.Context r0 = com.playrix.engine.Engine.getContext()     // Catch:{ all -> 0x006c }
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount(r0)     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r2 = r3.signInAccount     // Catch:{ all -> 0x006c }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = r3.signInAccount     // Catch:{ all -> 0x006c }
            r3.onSignInSucceeded(r0)     // Catch:{ all -> 0x006c }
            goto L_0x003f
        L_0x0037:
            r0 = 0
            r3.signInAccount = r0     // Catch:{ all -> 0x006c }
            java.lang.String r0 = "Changed account"
            onSignInError(r1, r0)     // Catch:{ all -> 0x006c }
        L_0x003f:
            monitor-exit(r3)
            return
        L_0x0041:
            com.google.android.gms.auth.api.signin.GoogleSignInClient r0 = r3.signInClient     // Catch:{ all -> 0x006c }
            com.google.android.gms.tasks.Task r0 = r0.silentSignIn()     // Catch:{ all -> 0x006c }
            boolean r1 = r0.isSuccessful()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "silentSignIn: Already connected"
            verboseLog(r1)     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r0.getResult()     // Catch:{ all -> 0x006c }
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r0     // Catch:{ all -> 0x006c }
            r3.onSignInSucceeded(r0)     // Catch:{ all -> 0x006c }
            monitor-exit(r3)
            return
        L_0x005d:
            java.lang.String r1 = "silentSignIn: Waiting silent sign in"
            verboseLog(r1)     // Catch:{ all -> 0x006c }
            com.playrix.engine.GoogleSignInWrapper$3 r1 = new com.playrix.engine.GoogleSignInWrapper$3     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            r0.addOnCompleteListener(r1)     // Catch:{ all -> 0x006c }
            monitor-exit(r3)
            return
        L_0x006c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.GoogleSignInWrapper.signInCheck():void");
    }

    public synchronized void signOut() {
        if (this.signInClient == null) {
            verboseLog("signOut: null signInClient");
        } else {
            this.signInClient.signOut();
        }
    }
}
