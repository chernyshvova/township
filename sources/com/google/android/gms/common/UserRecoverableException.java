package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class UserRecoverableException extends Exception {
    public final Intent zza;

    public UserRecoverableException(@RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
        super(str);
        this.zza = intent;
    }

    @RecentlyNonNull
    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
