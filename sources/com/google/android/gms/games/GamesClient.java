package com.google.android.gms.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface GamesClient {
    @RecentlyNonNull
    Task<Bundle> getActivationHint();

    @RecentlyNonNull
    Task<String> getAppId();

    @RecentlyNonNull
    @RequiresPermission("android.permission.GET_ACCOUNTS")
    Task<String> getCurrentAccountName();

    @RecentlyNonNull
    Task<Intent> getSettingsIntent();

    @RecentlyNonNull
    Task<Void> setGravityForPopups(int i);

    @RecentlyNonNull
    Task<Void> setViewForPopups(@RecentlyNonNull View view);
}
