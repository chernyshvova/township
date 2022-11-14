package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public final /* synthetic */ class FirebaseApp$$Lambda$1 implements Provider {
    public final FirebaseApp arg$1;
    public final Context arg$2;

    public FirebaseApp$$Lambda$1(FirebaseApp firebaseApp, Context context) {
        this.arg$1 = firebaseApp;
        this.arg$2 = context;
    }

    public Object get() {
        return FirebaseApp.lambda$new$0(this.arg$1, this.arg$2);
    }
}
