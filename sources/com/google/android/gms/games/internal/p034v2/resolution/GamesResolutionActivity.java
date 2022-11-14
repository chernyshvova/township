package com.google.android.gms.games.internal.p034v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzat;

/* renamed from: com.google.android.gms.games.internal.v2.resolution.GamesResolutionActivity */
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class GamesResolutionActivity extends Activity {
    @Nullable
    public ResultReceiver zza;

    private final void zza(int i, @Nullable Intent intent) {
        Bundle bundle;
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver != null) {
            if (intent == null) {
                bundle = new Bundle();
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("resultData", intent);
                bundle = bundle2;
            }
            resultReceiver.send(i, bundle);
        }
    }

    public final void onActivityResult(int i, int i2, @RecentlyNonNull Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            StringBuilder sb = new StringBuilder(36);
            sb.append("Unexpected request code: ");
            sb.append(i);
            zzat.zzc("ResultActivity", sb.toString());
            zza(0, intent);
            finish();
            return;
        }
        zza(i2, intent);
        finish();
    }

    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zza = (ResultReceiver) Preconditions.checkNotNull((ResultReceiver) bundle.getParcelable("resultReceiver"));
            return;
        }
        this.zza = (ResultReceiver) Preconditions.checkNotNull((ResultReceiver) getIntent().getParcelableExtra("resultReceiver"));
        try {
            startIntentSenderForResult(((PendingIntent) Preconditions.checkNotNull((PendingIntent) getIntent().getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT))).getIntentSender(), 0, (Intent) null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            zzat.zzd("ResultActivity", "Failed to launch", e);
            zza(0, (Intent) null);
            finish();
        }
    }

    public final void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("resultReceiver", this.zza);
    }
}
