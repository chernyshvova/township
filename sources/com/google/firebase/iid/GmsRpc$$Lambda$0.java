package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class GmsRpc$$Lambda$0 implements Continuation {
    public final GmsRpc arg$1;

    public GmsRpc$$Lambda$0(GmsRpc gmsRpc) {
        this.arg$1 = gmsRpc;
    }

    public final Object then(Task task) {
        if (this.arg$1 != null) {
            Bundle bundle = (Bundle) task.getResult(IOException.class);
            if (bundle != null) {
                String string = bundle.getString("registration_id");
                if (string != null || (string = bundle.getString("unregistered")) != null) {
                    return string;
                }
                String string2 = bundle.getString("error");
                if ("RST".equals(string2)) {
                    throw new IOException("INSTANCE_ID_RESET");
                } else if (string2 != null) {
                    throw new IOException(string2);
                } else {
                    String valueOf = String.valueOf(bundle);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 21);
                    sb.append("Unexpected response: ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            } else {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw null;
        }
    }
}
