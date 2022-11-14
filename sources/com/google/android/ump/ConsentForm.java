package com.google.android.ump;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public interface ConsentForm {

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public interface OnConsentFormDismissedListener {
        void onConsentFormDismissed(@Nullable FormError formError);
    }
}
