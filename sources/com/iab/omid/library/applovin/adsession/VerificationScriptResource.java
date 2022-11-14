package com.iab.omid.library.applovin.adsession;

import com.iab.omid.library.applovin.p047d.C2860e;
import java.net.URL;

public final class VerificationScriptResource {
    public final URL resourceUrl;
    public final String vendorKey;
    public final String verificationParameters;

    public VerificationScriptResource(String str, URL url, String str2) {
        this.vendorKey = str;
        this.resourceUrl = url;
        this.verificationParameters = str2;
    }

    public static VerificationScriptResource createVerificationScriptResourceWithParameters(String str, URL url, String str2) {
        C2860e.m3381a(str, "VendorKey is null or empty");
        C2860e.m3379a((Object) url, "ResourceURL is null");
        C2860e.m3381a(str2, "VerificationParameters is null or empty");
        return new VerificationScriptResource(str, url, str2);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL url) {
        C2860e.m3379a((Object) url, "ResourceURL is null");
        return new VerificationScriptResource((String) null, url, (String) null);
    }

    public URL getResourceUrl() {
        return this.resourceUrl;
    }

    public String getVendorKey() {
        return this.vendorKey;
    }

    public String getVerificationParameters() {
        return this.verificationParameters;
    }
}
