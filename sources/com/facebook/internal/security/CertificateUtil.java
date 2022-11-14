package com.facebook.internal.security;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateUtil.kt */
public final class CertificateUtil {
    public static final String DELIMITER = ":";
    public static final CertificateUtil INSTANCE = new CertificateUtil();

    public static final String getCertificateHash(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuilder sb = new StringBuilder();
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            Intrinsics.checkNotNullExpressionValue(signatureArr, "signatures");
            int length = signatureArr.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Signature signature = signatureArr[i];
                i++;
                instance.update(signature.toByteArray());
                sb.append(Base64.encodeToString(instance.digest(), 0));
                sb.append(DELIMITER);
            }
            if (sb.length() > 0) {
                z = true;
            }
            if (z) {
                sb.setLength(sb.length() - 1);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getDELIMITER$facebook_core_release$annotations() {
    }
}
