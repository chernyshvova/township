package com.google.firebase.installations;

/* compiled from: FirebaseInstallations */
public final /* synthetic */ class FirebaseInstallations$$Lambda$4 implements Runnable {
    public final FirebaseInstallations arg$1;
    public final boolean arg$2;

    public FirebaseInstallations$$Lambda$4(FirebaseInstallations firebaseInstallations, boolean z) {
        this.arg$1 = firebaseInstallations;
        this.arg$2 = z;
    }

    public void run() {
        FirebaseInstallations.lambda$doRegistrationOrRefresh$2(this.arg$1, this.arg$2);
    }
}
