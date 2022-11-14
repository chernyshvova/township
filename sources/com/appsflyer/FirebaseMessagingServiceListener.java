package com.appsflyer;

import com.appsflyer.internal.C1433az;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        new C1433az(getApplicationContext()).AFKeystoreWrapper(str);
    }
}
