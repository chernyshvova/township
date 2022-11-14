package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GooglePlayServicesIncorrectManifestValueException(int r5) {
        /*
            r4 = this;
            int r0 = com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE
            r1 = 320(0x140, float:4.48E-43)
            java.lang.String r2 = "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected "
            java.lang.String r3 = " but found "
            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline22(r1, r2, r0, r3, r5)
            java.lang.String r1 = ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.<init>(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException.<init>(int):void");
    }
}
