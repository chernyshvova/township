package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public interface zak {
    @Nullable
    Bundle getConnectionHint();

    boolean isConnected();
}
