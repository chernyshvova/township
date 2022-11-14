package com.google.firebase.iid;

import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.Store;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$4 implements SuccessContinuation {
    public final FirebaseInstanceId arg$1;
    public final String arg$2;
    public final String arg$3;
    public final String arg$4;

    public FirebaseInstanceId$$Lambda$4(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.arg$1 = firebaseInstanceId;
        this.arg$2 = str;
        this.arg$3 = str2;
        this.arg$4 = str3;
    }

    public final Task then(Object obj) {
        FirebaseInstanceId firebaseInstanceId = this.arg$1;
        String str = this.arg$2;
        String str2 = this.arg$3;
        String str3 = this.arg$4;
        String str4 = (String) obj;
        Store store = FirebaseInstanceId.store;
        String subtype = firebaseInstanceId.getSubtype();
        String appVersionCode = firebaseInstanceId.metadata.getAppVersionCode();
        synchronized (store) {
            String encode = Store.Token.encode(str4, appVersionCode, System.currentTimeMillis());
            if (encode != null) {
                SharedPreferences.Editor edit = store.store.edit();
                edit.putString(store.createTokenKey(subtype, str, str2), encode);
                edit.commit();
            }
        }
        return Tasks.forResult(new InstanceIdResultImpl(str3, str4));
    }
}
