package com.helpshift.android.commons.downloader.util;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.aam.MetadataRule;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AttachmentNetworkUtil {
    public static URL buildSecureURL(String str, NetworkAuthDataFetcher networkAuthDataFetcher) throws URISyntaxException, GeneralSecurityException, MalformedURLException {
        URI uri = new URI(str);
        String path = uri.getPath();
        Map<String, String> queryMap = getQueryMap(uri.getQuery());
        queryMap.put(MetadataRule.FIELD_V, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        queryMap.put("uri", path);
        Map<String, String> authData = networkAuthDataFetcher.getAuthData(queryMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : authData.entrySet()) {
            arrayList.add(((String) next.getKey()) + "=" + ((String) next.getValue()));
        }
        return new URL(new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), join("&", arrayList), (String) null).toASCIIString());
    }

    public static Map<String, String> getQueryMap(String str) {
        String[] split = str.split("&");
        HashMap hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            if (split3.length == 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        return hashMap;
    }

    public static String join(CharSequence charSequence, Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object next : iterable) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
