package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;

public final class UriCompat {
    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(scheme);
                sb.append(':');
                if (schemeSpecificPart != null) {
                    for (int i = 0; i < schemeSpecificPart.length(); i++) {
                        char charAt = schemeSpecificPart.charAt(i);
                        if (charAt == '-' || charAt == '@' || charAt == '.') {
                            sb.append(charAt);
                        } else {
                            sb.append('x');
                        }
                    }
                }
                return sb.toString();
            } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase(Utility.URL_SCHEME) || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("//");
                String str = "";
                outline24.append(uri.getHost() != null ? uri.getHost() : str);
                if (uri.getPort() != -1) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24(CertificateUtil.DELIMITER);
                    outline242.append(uri.getPort());
                    str = outline242.toString();
                }
                schemeSpecificPart = GeneratedOutlineSupport.outline18(outline24, str, "/...");
            }
        }
        StringBuilder sb2 = new StringBuilder(64);
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append(':');
        }
        if (schemeSpecificPart != null) {
            sb2.append(schemeSpecificPart);
        }
        return sb2.toString();
    }
}
