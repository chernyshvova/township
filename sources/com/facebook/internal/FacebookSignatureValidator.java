package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.android.billingclient.api.zzam;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.vungle.warren.log.LogEntry;
import java.util.HashSet;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: FacebookSignatureValidator.kt */
public final class FacebookSignatureValidator {
    public static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    public static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    public static final String FBL_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    public static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    public static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    public static final String IGR_HASH = "c56fb7d591ba6704df047fd98f535372fea00211";
    public static final FacebookSignatureValidator INSTANCE = new FacebookSignatureValidator();
    public static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    public static final HashSet<String> validAppSignatureHashes = zzam.hashSetOf(FBR_HASH, FBR2_HASH, FBI_HASH, FBL_HASH, MSR_HASH, FBF_HASH, IGR_HASH);

    public static final boolean validateSignature(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(str, InAppPurchaseBillingClientWrapper.PACKAGE_NAME);
        String str2 = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        Intrinsics.checkNotNullExpressionValue(str2, "brand");
        if (CharsKt__CharKt.startsWith$default(str2, "generic", false, 2) && (i & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures == null) {
                return false;
            }
            Signature[] signatureArr = packageInfo.signatures;
            Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
            if (signatureArr.length == 0) {
                return false;
            }
            Signature[] signatureArr2 = packageInfo.signatures;
            Intrinsics.checkNotNullExpressionValue(signatureArr2, "packageInfo.signatures");
            for (Signature byteArray : signatureArr2) {
                HashSet<String> hashSet = validAppSignatureHashes;
                Utility utility = Utility.INSTANCE;
                byte[] byteArray2 = byteArray.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray2, "it.toByteArray()");
                if (!CollectionsKt__CollectionsKt.contains(hashSet, Utility.sha1hash(byteArray2))) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
