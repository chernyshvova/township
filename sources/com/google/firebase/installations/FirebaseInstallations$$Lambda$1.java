package com.google.firebase.installations;

/* compiled from: FirebaseInstallations */
public final /* synthetic */ class FirebaseInstallations$$Lambda$1 implements Runnable {
    public final FirebaseInstallations arg$1;

    public FirebaseInstallations$$Lambda$1(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public void run() {
        this.arg$1.doRegistrationOrRefresh(false);
    }
}
