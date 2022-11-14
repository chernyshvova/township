package com.vungle.warren.omsdk;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.Omid;

public class OMTestUtils {
    @VisibleForTesting
    public static boolean isOmidActive() {
        return Omid.INSTANCE.f3500a;
    }
}
