package com.playrix.gplay;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.playrix.engine.Logger;

public class Leaderboards {
    public final Activity activity;
    public LeaderboardsClient leaderboardsClient = null;

    public Leaderboards(Activity activity2) {
        this.activity = activity2;
    }

    public synchronized void clear() {
        this.leaderboardsClient = null;
    }

    public synchronized void setClient(LeaderboardsClient leaderboardsClient2) {
        this.leaderboardsClient = leaderboardsClient2;
    }

    public synchronized void setLeaderboardScore(String str, long j) {
        if (this.leaderboardsClient != null) {
            this.leaderboardsClient.submitScore(str, j);
        }
    }

    public synchronized void showLeaderboard(final String str, final int i) {
        Task<Intent> task;
        if (this.leaderboardsClient != null) {
            if (str.isEmpty()) {
                task = this.leaderboardsClient.getAllLeaderboardsIntent();
            } else {
                task = this.leaderboardsClient.getLeaderboardIntent(str);
            }
            task.addOnCompleteListener(new OnCompleteListener<Intent>() {
                public void onComplete(@NonNull Task<Intent> task) {
                    try {
                        Leaderboards.this.activity.startActivityForResult(task.getResult(ApiException.class), i);
                    } catch (ApiException e) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("GoogleGameCenter: showLeaderboard ");
                        outline24.append(str);
                        outline24.append(" failed:");
                        outline24.append(e.getStatusCode());
                        Logger.logError(outline24.toString());
                    } catch (Exception e2) {
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("GoogleGameCenter: showLeaderboard ");
                        outline242.append(str);
                        outline242.append(" failed:");
                        outline242.append(e2.toString());
                        Logger.logError(outline242.toString());
                    }
                }
            });
        }
    }
}
