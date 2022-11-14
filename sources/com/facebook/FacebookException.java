package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FacebookException.kt */
public class FacebookException extends RuntimeException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;

    /* compiled from: FacebookException.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FacebookException() {
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m3527_init_$lambda0(String str, boolean z) {
        if (z) {
            try {
                ErrorReportHandler errorReportHandler = ErrorReportHandler.INSTANCE;
                ErrorReportHandler.save(str);
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        String message = getMessage();
        return message == null ? "" : message;
    }

    public FacebookException(String str) {
        super(str);
        Random random = new Random();
        if (str != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isInitialized() && random.nextInt(100) > 50) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback(str) {
                    public final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onCompleted(boolean z) {
                        FacebookException.m3527_init_$lambda0(this.f$0, z);
                    }
                });
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacebookException(java.lang.String r3, java.lang.Object... r4) {
        /*
            r2 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            if (r3 != 0) goto L_0x0009
            r3 = 0
            goto L_0x0015
        L_0x0009:
            int r0 = r4.length
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r0)
            int r0 = r4.length
            java.lang.String r1 = "java.lang.String.format(this, *args)"
            java.lang.String r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline21(r4, r0, r3, r1)
        L_0x0015:
            r2.<init>((java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookException.<init>(java.lang.String, java.lang.Object[]):void");
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }
}
