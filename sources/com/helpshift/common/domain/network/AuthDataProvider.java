package com.helpshift.common.domain.network;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.crypto.CryptoDM;
import com.helpshift.support.res.values.HSConsts;
import com.helpshift.util.StringUtils;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class AuthDataProvider {
    public final String apiKey;
    public final String appId;
    public final CryptoDM cryptoDM;
    public final Jsonifier jsonifier;
    public final NetworkRequestDAO networkRequestDAO;
    public final String route;

    public AuthDataProvider(Domain domain, Platform platform, String str) {
        this.apiKey = platform.getAPIKey();
        this.appId = platform.getAppId();
        this.route = str;
        this.cryptoDM = domain.getCryptoDM();
        this.networkRequestDAO = platform.getNetworkRequestDAO();
        this.jsonifier = platform.getJsonifier();
    }

    public Map<String, String> getAuthData(Method method, Map<String, String> map) throws GeneralSecurityException {
        if (map == null || StringUtils.isEmpty(map.get("uri"))) {
            throw new IllegalArgumentException("No value for uri in auth data.");
        }
        map.put("platform-id", this.appId);
        map.put("method", method.name());
        map.put("timestamp", NetworkDataRequestUtil.getAdjustedTimestamp(this.networkRequestDAO));
        map.put(HSConsts.SDK_META, this.jsonifier.jsonify(NetworkDataRequestUtil.getSdkMeta()));
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.equals("filePath") && !str.equals("meta") && !str.equals("originalFileName")) {
                StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "=");
                outline26.append(map.get(str));
                arrayList2.add(outline26.toString());
            }
        }
        map.put("signature", this.cryptoDM.getSignature(StringUtils.join("&", arrayList2), this.apiKey));
        map.remove("method");
        map.remove("uri");
        return map;
    }
}
