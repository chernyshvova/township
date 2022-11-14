package com.facebook.login;

import android.os.Bundle;
import android.util.Base64;
import com.android.billingclient.api.zzam;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.Regex;

/* compiled from: PKCEUtil.kt */
public final class PKCEUtil {
    public static final PKCEUtil INSTANCE = new PKCEUtil();

    public static final GraphRequest createCodeExchangeRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "authorizationCode");
        Intrinsics.checkNotNullParameter(str2, "redirectUri");
        Intrinsics.checkNotNullParameter(str3, "codeVerifier");
        Bundle bundle = new Bundle();
        bundle.putString("code", str);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString("code_verifier", str3);
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "oauth/access_token", (GraphRequest.Callback) null);
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest;
    }

    public static final String generateCodeChallenge(String str, CodeChallengeMethod codeChallengeMethod) throws FacebookException {
        Intrinsics.checkNotNullParameter(str, "codeVerifier");
        Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
        if (!isValidCodeVerifier(str)) {
            throw new FacebookException("Invalid Code Verifier.");
        } else if (codeChallengeMethod == CodeChallengeMethod.PLAIN) {
            return str;
        } else {
            try {
                byte[] bytes = str.getBytes(Charsets.US_ASCII);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                MessageDigest instance = MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA256);
                instance.update(bytes, 0, bytes.length);
                String encodeToString = Base64.encodeToString(instance.digest(), 11);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "{\n      // try to generate challenge with S256\n      val bytes: ByteArray = codeVerifier.toByteArray(Charsets.US_ASCII)\n      val messageDigest = MessageDigest.getInstance(\"SHA-256\")\n      messageDigest.update(bytes, 0, bytes.size)\n      val digest = messageDigest.digest()\n\n      Base64.encodeToString(digest, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP)\n    }");
                return encodeToString;
            } catch (Exception e) {
                throw new FacebookException((Throwable) e);
            }
        }
    }

    public static final String generateCodeVerifier() {
        List list;
        IntRange intRange = new IntRange(43, 128);
        Random.Default defaultR = Random.Default;
        Intrinsics.checkNotNullParameter(intRange, "$this$random");
        Intrinsics.checkNotNullParameter(defaultR, "random");
        try {
            int nextInt = zzam.nextInt(defaultR, intRange);
            CharRange charRange = new CharRange('a', 'z');
            CharRange charRange2 = new CharRange('A', 'Z');
            Intrinsics.checkNotNullParameter(charRange, "$this$plus");
            Intrinsics.checkNotNullParameter(charRange2, "elements");
            if (charRange instanceof Collection) {
                list = CollectionsKt__CollectionsKt.plus((Collection) charRange, charRange2);
            } else {
                ArrayList arrayList = new ArrayList();
                zzam.addAll(arrayList, charRange);
                zzam.addAll(arrayList, charRange2);
                list = arrayList;
            }
            List plus = CollectionsKt__CollectionsKt.plus(CollectionsKt__CollectionsKt.plus(CollectionsKt__CollectionsKt.plus(CollectionsKt__CollectionsKt.plus(CollectionsKt__CollectionsKt.plus(list, new CharRange('0', '9')), '-'), '.'), '_'), '~');
            ArrayList arrayList2 = new ArrayList(nextInt);
            int i = 0;
            int i2 = 0;
            while (i2 < nextInt) {
                Random.Default defaultR2 = Random.Default;
                Intrinsics.checkNotNullParameter(plus, "$this$random");
                Intrinsics.checkNotNullParameter(defaultR2, "random");
                if (!plus.isEmpty()) {
                    int nextInt2 = defaultR2.nextInt(plus.size());
                    Intrinsics.checkNotNullParameter(plus, "$this$elementAt");
                    arrayList2.add(Character.valueOf(((Character) plus.get(nextInt2)).charValue()));
                    i2++;
                } else {
                    throw new NoSuchElementException("Collection is empty.");
                }
            }
            Intrinsics.checkNotNullParameter(arrayList2, "$this$joinToString");
            Intrinsics.checkNotNullParameter("", "separator");
            Intrinsics.checkNotNullParameter("", "prefix");
            Intrinsics.checkNotNullParameter("", "postfix");
            Intrinsics.checkNotNullParameter("...", "truncated");
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullParameter(arrayList2, "$this$joinTo");
            Intrinsics.checkNotNullParameter(sb, FileLruCache.BufferFile.FILE_NAME_PREFIX);
            Intrinsics.checkNotNullParameter("", "separator");
            Intrinsics.checkNotNullParameter("", "prefix");
            Intrinsics.checkNotNullParameter("", "postfix");
            Intrinsics.checkNotNullParameter("...", "truncated");
            sb.append("");
            for (Object next : arrayList2) {
                boolean z = true;
                i++;
                if (i > 1) {
                    sb.append("");
                }
                Intrinsics.checkNotNullParameter(sb, "$this$appendElement");
                if (next != null) {
                    z = next instanceof CharSequence;
                }
                if (z) {
                    sb.append((CharSequence) next);
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    sb.append(String.valueOf(next));
                }
            }
            sb.append("");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
            return sb2;
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final boolean isValidCodeVerifier(String str) {
        if ((str == null || str.length() == 0) || str.length() < 43 || str.length() > 128) {
            return false;
        }
        return new Regex("^[-._~A-Za-z0-9]+$").matches(str);
    }
}
