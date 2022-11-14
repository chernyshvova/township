package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: id */
    public final String f3310id;
    public final String token;

    public InstanceIdResultImpl(String str, String str2) {
        this.f3310id = str;
        this.token = str2;
    }

    public final String getId() {
        return this.f3310id;
    }

    public final String getToken() {
        return this.token;
    }
}
