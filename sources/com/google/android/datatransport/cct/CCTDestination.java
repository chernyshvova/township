package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.zzam;
import com.facebook.GraphRequest;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class CCTDestination implements EncodedDestination {
    public static final CCTDestination LEGACY_INSTANCE = new CCTDestination(zzb, zzc);
    public static final String zza = zzam.zza("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
    public static final String zzb = zzam.zza("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
    public static final String zzc = zzam.zza("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
    public static final Set<Encoding> zzd = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding[]{new Encoding("proto"), new Encoding(GraphRequest.FORMAT_JSON)})));
    @NonNull
    public final String zze;
    @Nullable
    public final String zzf;

    public CCTDestination(@NonNull String str, @Nullable String str2) {
        this.zze = str;
        this.zzf = str2;
    }

    @NonNull
    public static CCTDestination fromByteArray(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new CCTDestination(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Nullable
    public byte[] getExtras() {
        if (this.zzf == null && this.zze == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.zze;
        objArr[2] = "\\";
        String str = this.zzf;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @NonNull
    public String getName() {
        return "cct";
    }

    public Set<Encoding> getSupportedEncodings() {
        return zzd;
    }
}
