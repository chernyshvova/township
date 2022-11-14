package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public class ProxyBillingActivity extends Activity {
    @Nullable
    public ResultReceiver zza;

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            int zza2 = zzb.zza(intent, "ProxyBillingActivity");
            if (!(i2 == -1 && zza2 == 0)) {
                zzb.zzb("ProxyBillingActivity", GeneratedOutlineSupport.outline11(85, "Activity finished with resultCode ", i2, " and billing's responseCode: ", zza2));
            }
            this.zza.send(zza2, intent == null ? null : intent.getExtras());
        } else {
            StringBuilder sb = new StringBuilder(69);
            sb.append("Got onActivityResult with wrong requestCode: ");
            sb.append(i);
            sb.append("; skipping...");
            zzb.zzb("ProxyBillingActivity", sb.toString());
        }
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            zzb.zza("ProxyBillingActivity", "Launching Play Store billing flow");
            this.zza = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            } else {
                pendingIntent = getIntent().hasExtra("SUBS_MANAGEMENT_INTENT") ? (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT") : null;
            }
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 53);
                sb.append("Got exception while trying to start a purchase flow: ");
                sb.append(valueOf);
                zzb.zzb("ProxyBillingActivity", sb.toString());
                this.zza.send(6, (Bundle) null);
                finish();
            }
        } else {
            zzb.zza("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.zza = (ResultReceiver) bundle.getParcelable("result_receiver");
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putParcelable("result_receiver", this.zza);
    }
}
