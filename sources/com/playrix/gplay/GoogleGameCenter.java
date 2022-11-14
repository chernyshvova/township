package com.playrix.gplay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.Player;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineActivity;
import com.playrix.engine.GameCenter;
import com.playrix.engine.GlobalConstants;
import com.playrix.engine.ImmersiveMode;
import com.playrix.engine.LifeCycleActivity;
import com.playrix.engine.Logger;
import com.playrix.engine.NativeThread;

public class GoogleGameCenter implements GameCenter.IGameCenter, LifeCycleActivity.ILifecycleCallbacks {
    public static final int REQUEST_CODE_SHOW_ACHIEVEMENTS = 9003;
    public static final int REQUEST_CODE_SHOW_DIALOG = 9004;
    public static final int REQUEST_CODE_SHOW_LEADERBOARD = 9002;
    public static final String TAG = "GoogleGameCenter: ";
    public final Achievements achievements;
    public final Activity activity;
    public int authenticationResult;
    public boolean debugLogEnabled;
    public final boolean gameFeaturesEnabled;
    public final Leaderboards leaderboards;
    public Player player;
    public String serverAuthCode;

    public GoogleGameCenter(Activity activity2) {
        this(activity2, true);
    }

    private synchronized void checkIsStillConnected() {
    }

    private void clearState() {
        synchronized (this) {
            this.player = null;
            this.serverAuthCode = null;
        }
        Achievements achievements2 = this.achievements;
        if (achievements2 != null) {
            achievements2.clear();
        }
        Leaderboards leaderboards2 = this.leaderboards;
        if (leaderboards2 != null) {
            leaderboards2.clear();
        }
    }

    public static void createActivityLifecycleCallbacks(final boolean z, final boolean z2) {
        Engine.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof EngineActivity) {
                    GoogleGameCenter googleGameCenter = new GoogleGameCenter(activity, z);
                    googleGameCenter.enableDebugLog(z2);
                    Engine.getActivity().registerActivityLifecycleCallbacks(googleGameCenter);
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

    private void debugLog(String str) {
        synchronized (this) {
            if (this.debugLogEnabled) {
                Logger.logDebug(TAG + str);
            }
        }
    }

    public static boolean initialize(final boolean z, final boolean z2) {
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                GoogleGameCenter.createActivityLifecycleCallbacks(z, z2);
            }
        });
    }

    public static void logWarning(String str) {
        Logger.logWarning(TAG + str);
    }

    /* access modifiers changed from: private */
    public void onSignInFailed() {
        clearState();
        onSignInFinished();
    }

    /* access modifiers changed from: private */
    public synchronized void onSignInFinished() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                GameCenter.nativeSignInCompleted();
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void processAuthenticationErrorResult(int r5, final java.lang.String r6, final java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 7
            r1 = 2
            if (r5 == r0) goto L_0x0043
            r0 = 18
            if (r5 == r0) goto L_0x0043
            r0 = 13
            if (r5 == r0) goto L_0x002a
            r0 = 14
            if (r5 == r0) goto L_0x0043
            r0 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            r2.append(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r3 = " failed:"
            r2.append(r3)     // Catch:{ all -> 0x006c }
            r2.append(r5)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x006c }
            logWarning(r5)     // Catch:{ all -> 0x006c }
            goto L_0x005b
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r0.<init>()     // Catch:{ all -> 0x006c }
            r0.append(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = " canceled:"
            r0.append(r2)     // Catch:{ all -> 0x006c }
            r0.append(r5)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x006c }
            logWarning(r5)     // Catch:{ all -> 0x006c }
            r0 = 2
            goto L_0x005b
        L_0x0043:
            r0 = 4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            r2.append(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r3 = " recoverable error:"
            r2.append(r3)     // Catch:{ all -> 0x006c }
            r2.append(r5)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x006c }
            logWarning(r5)     // Catch:{ all -> 0x006c }
        L_0x005b:
            r4.setAuthenticationResult(r0)     // Catch:{ all -> 0x006c }
            if (r0 == r1) goto L_0x006a
            android.app.Activity r5 = r4.activity     // Catch:{ all -> 0x006c }
            com.playrix.gplay.GoogleGameCenter$11 r0 = new com.playrix.gplay.GoogleGameCenter$11     // Catch:{ all -> 0x006c }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x006c }
            r5.runOnUiThread(r0)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r4)
            return
        L_0x006c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.gplay.GoogleGameCenter.processAuthenticationErrorResult(int, java.lang.String, java.lang.String):void");
    }

    private void refreshPlayer() {
        PlayGames.getPlayersClient(this.activity).getCurrentPlayer().addOnCompleteListener(new OnCompleteListener<Player>() {
            public void onComplete(@NonNull Task<Player> task) {
                try {
                    synchronized (GoogleGameCenter.this) {
                        Player unused = GoogleGameCenter.this.player = task.getResult(ApiException.class);
                    }
                } catch (ApiException e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("refreshPlayer failed:");
                    outline24.append(e.getStatusCode());
                    GoogleGameCenter.logWarning(outline24.toString());
                } catch (Exception e2) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("refreshPlayer failed:");
                    outline242.append(e2.toString());
                    GoogleGameCenter.logWarning(outline242.toString());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void requestPlayer() {
        PlayGames.getPlayersClient(this.activity).getCurrentPlayer().addOnCompleteListener(new OnCompleteListener<Player>() {
            public void onComplete(@NonNull Task<Player> task) {
                try {
                    GoogleGameCenter.this.requestPlayerFinished(task.getResult(ApiException.class));
                } catch (ApiException e) {
                    GoogleGameCenter.this.processAuthenticationErrorResult(e.getStatusCode(), e.getMessage(), "Get player ");
                    GoogleGameCenter.this.onSignInFailed();
                } catch (Exception e2) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Get player failed:");
                    outline24.append(e2.toString());
                    GoogleGameCenter.logWarning(outline24.toString());
                    GoogleGameCenter.this.setAuthenticationResult(1);
                    GoogleGameCenter.this.onSignInFailed();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void requestPlayerFinished(Player player2) {
        synchronized (this) {
            this.player = player2;
        }
        Leaderboards leaderboards2 = this.leaderboards;
        if (leaderboards2 != null) {
            leaderboards2.setClient(PlayGames.getLeaderboardsClient(this.activity));
        }
        Achievements achievements2 = this.achievements;
        if (achievements2 != null) {
            achievements2.setClient(PlayGames.getAchievementsClient(this.activity));
        }
        requestServerAuthCode();
    }

    /* access modifiers changed from: private */
    public void requestServerAuthCode() {
        GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(this.activity);
        String string = GlobalConstants.getString("identify_server_oauth_client_id", (String) null);
        if (string == null || string.isEmpty()) {
            setAuthenticationResult(1);
            onSignInFailed();
            logWarning("can't get requestServerSideAccess - empty client id");
            return;
        }
        gamesSignInClient.requestServerSideAccess(string, false).addOnCompleteListener(new OnCompleteListener<String>() {
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    synchronized (GoogleGameCenter.this) {
                        String unused = GoogleGameCenter.this.serverAuthCode = task.getResult();
                        GoogleGameCenter.this.setAuthenticationResult(0);
                    }
                    GoogleGameCenter.this.onSignInFinished();
                    return;
                }
                GoogleGameCenter.this.setAuthenticationResult(1);
                GoogleGameCenter.this.onSignInFailed();
                GoogleGameCenter.logWarning("requestServerSideAccess failed");
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void setAuthenticationResult(int i) {
        this.authenticationResult = i;
    }

    private void signIn() {
        PlayGames.getGamesSignInClient(this.activity).signIn().addOnCompleteListener(new OnCompleteListener<AuthenticationResult>() {
            public void onComplete(@NonNull Task<AuthenticationResult> task) {
                if (task.isSuccessful() && task.getResult().isAuthenticated()) {
                    GoogleGameCenter.this.requestPlayer();
                    return;
                }
                GoogleGameCenter.this.setAuthenticationResult(1);
                GoogleGameCenter.this.onSignInFailed();
                GoogleGameCenter.logWarning("isAuthenticated failed");
            }
        });
    }

    private synchronized void signOut() {
    }

    public void enableDebugLog(boolean z) {
        synchronized (this) {
            this.debugLogEnabled = z;
        }
        if (z) {
            debugLog("Debug log enabled.");
        }
    }

    public synchronized int getErrorCode() {
        return this.authenticationResult;
    }

    public void getPlayGamesAuthCodeWithCallback(final long j) {
        GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(this.activity);
        String string = GlobalConstants.getString("identify_server_oauth_client_id", (String) null);
        if (string == null || string.isEmpty()) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    GameCenter.nativeGetPlayGamesAuthCodeFinished(j, "");
                }
            });
        } else {
            gamesSignInClient.requestServerSideAccess(string, false).addOnCompleteListener(new OnCompleteListener<String>() {
                public void onComplete(@NonNull Task<String> task) {
                    final String str;
                    if (task.isSuccessful()) {
                        str = task.getResult();
                    } else {
                        GoogleGameCenter.logWarning("requestServerSideAccess failed");
                        str = "";
                    }
                    Engine.runOnGLThread(new Runnable() {
                        public void run() {
                            GameCenter.nativeGetPlayGamesAuthCodeFinished(j, str);
                        }
                    });
                }
            });
        }
    }

    public synchronized String getPlayerId() {
        return this.player != null ? this.player.getPlayerId() : "";
    }

    public synchronized String getPlayerName() {
        return this.player != null ? this.player.getDisplayName() : "";
    }

    public synchronized String getPlayerToken() {
        return this.serverAuthCode != null ? this.serverAuthCode : "";
    }

    public synchronized boolean isAuthenticated() {
        return (this.player == null || this.serverAuthCode == null) ? false : true;
    }

    public boolean isSupported() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Engine.getContext()) == 0;
    }

    public void onActivityCreated(Activity activity2, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity2) {
    }

    public void onActivityPaused(Activity activity2) {
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case REQUEST_CODE_SHOW_LEADERBOARD /*9002*/:
            case REQUEST_CODE_SHOW_ACHIEVEMENTS /*9003*/:
            case REQUEST_CODE_SHOW_DIALOG /*9004*/:
                return true;
            default:
                return false;
        }
    }

    public void onActivityResumed(Activity activity2) {
        refreshPlayer();
    }

    public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity2) {
    }

    public void onActivityStopped(Activity activity2) {
    }

    public void onLowMemory() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void setAchievementProgress(String str, float f) {
        Achievements achievements2 = this.achievements;
        if (achievements2 != null) {
            achievements2.setAchievementProgress(str, f);
        }
    }

    public void setLeaderboardScore(String str, long j) {
        Leaderboards leaderboards2 = this.leaderboards;
        if (leaderboards2 != null) {
            leaderboards2.setLeaderboardScore(str, j);
        }
    }

    public void showAchievements() {
        Achievements achievements2 = this.achievements;
        if (achievements2 != null) {
            achievements2.showAchievements(REQUEST_CODE_SHOW_ACHIEVEMENTS);
        } else {
            logWarning("Game features are disabled");
        }
    }

    public void showAuth() {
        final int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Engine.getContext());
        if (isGooglePlayServicesAvailable != 0) {
            this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog(GoogleGameCenter.this.activity, isGooglePlayServicesAvailable, (int) GoogleGameCenter.REQUEST_CODE_SHOW_DIALOG);
                    if ((errorDialog instanceof AlertDialog) && ((i = isGooglePlayServicesAvailable) == 2 || i == 3 || i == 18)) {
                        ((AlertDialog) errorDialog).setButton(-2, GoogleGameCenter.this.activity.getText(17039360), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                    ImmersiveMode.showDialog(errorDialog);
                }
            });
            return;
        }
        setAuthenticationResult(-1);
        signIn();
    }

    public void showLeaderboard(String str) {
        Leaderboards leaderboards2 = this.leaderboards;
        if (leaderboards2 != null) {
            leaderboards2.showLeaderboard(str, REQUEST_CODE_SHOW_LEADERBOARD);
        } else {
            logWarning("Game features are disabled");
        }
    }

    public synchronized void signOutGC() {
    }

    public synchronized void silentSignIn() {
        if (isSupported()) {
            setAuthenticationResult(-1);
            signIn();
        }
    }

    public void submitData() {
    }

    public GoogleGameCenter(Activity activity2, boolean z) {
        this.player = null;
        this.serverAuthCode = null;
        this.authenticationResult = -1;
        this.debugLogEnabled = false;
        this.activity = activity2;
        this.gameFeaturesEnabled = z;
        if (z) {
            this.leaderboards = new Leaderboards(activity2);
            this.achievements = new Achievements(activity2);
        } else {
            this.leaderboards = null;
            this.achievements = null;
        }
        if (isSupported()) {
            PlayGames.getGamesSignInClient(activity2).isAuthenticated().addOnCompleteListener(new OnCompleteListener<AuthenticationResult>() {
                public void onComplete(@NonNull Task<AuthenticationResult> task) {
                    if (task.isSuccessful() && task.getResult().isAuthenticated()) {
                        GoogleGameCenter.this.requestServerAuthCode();
                        return;
                    }
                    GoogleGameCenter.this.setAuthenticationResult(1);
                    GoogleGameCenter.this.onSignInFailed();
                    GoogleGameCenter.logWarning("isAuthenticated failed");
                }
            });
        }
        GameCenter.init(this);
    }
}
