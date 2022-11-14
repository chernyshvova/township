package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InstrumentManager.kt */
public final class InstrumentManager {
    public static final InstrumentManager INSTANCE = new InstrumentManager();

    public static final void start() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, $$Lambda$W14zN8pSqs882CZOyfFpXGD91k.INSTANCE);
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, $$Lambda$O45CUUZLqADBRGg36POLE65ON_4.INSTANCE);
            FeatureManager featureManager3 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.AnrReport, $$Lambda$afbQg6_R8R87G093r1zWqUFMaOY.INSTANCE);
        }
    }

    /* renamed from: start$lambda-0  reason: not valid java name */
    public static final void m3636start$lambda0(boolean z) {
        if (z) {
            CrashHandler.Companion.enable();
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
                ExceptionAnalyzer.enable();
                CrashShieldHandler crashShieldHandler = CrashShieldHandler.INSTANCE;
                CrashShieldHandler.enable();
            }
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                ThreadCheckHandler threadCheckHandler = ThreadCheckHandler.INSTANCE;
                ThreadCheckHandler.enable();
            }
        }
    }

    /* renamed from: start$lambda-1  reason: not valid java name */
    public static final void m3637start$lambda1(boolean z) {
        if (z) {
            ErrorReportHandler errorReportHandler = ErrorReportHandler.INSTANCE;
            ErrorReportHandler.enable();
        }
    }

    /* renamed from: start$lambda-2  reason: not valid java name */
    public static final void m3638start$lambda2(boolean z) {
        if (z) {
            ANRHandler aNRHandler = ANRHandler.INSTANCE;
            ANRHandler.enable();
        }
    }
}
