package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.iid.WithinAppServiceConnection;
import com.google.firebase.messaging.EnhancedIntentService;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class WithinAppServiceBinder extends Binder {
    public final IntentHandler intentHandler;

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public interface IntentHandler {
    }

    @KeepForSdk
    public WithinAppServiceBinder(IntentHandler intentHandler2) {
        this.intentHandler = intentHandler2;
    }

    public void send(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            IntentHandler intentHandler2 = this.intentHandler;
            EnhancedIntentService.this.processIntent(bindRequest.intent).addOnCompleteListener(FirebaseIidExecutors.DIRECT_EXECUTOR, new WithinAppServiceBinder$$Lambda$0(bindRequest));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
