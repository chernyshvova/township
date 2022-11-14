package com.helpshift.logger;

import com.facebook.appevents.aam.MetadataRule;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.CustomAuthDataPOSTNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.logger.model.LogModel;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import com.helpshift.support.res.values.HSConsts;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.HSFormat;
import com.helpshift.util.StringUtils;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ErrorReportsDM {
    public Domain domain;
    public Platform platform;

    public ErrorReportsDM(Platform platform2, Domain domain2) {
        this.platform = platform2;
        this.domain = domain2;
    }

    public Map<String, String> getAuthDataForErrorReports() {
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add("platform-id=sdk");
            String uuid = UUID.randomUUID().toString();
            arrayList.add("token=" + uuid);
            hashMap.put("token", uuid);
            hashMap.put(HSConsts.SDK_META, this.platform.getJsonifier().jsonify(NetworkDataRequestUtil.getSdkMeta()));
            arrayList.add("sm=" + this.platform.getJsonifier().jsonify(NetworkDataRequestUtil.getSdkMeta()));
            hashMap.put("signature", this.domain.getCryptoDM().getSignature(StringUtils.join("&", arrayList), "sdk"));
            return hashMap;
        } catch (GeneralSecurityException e) {
            throw RootAPIException.wrap(e, (ExceptionType) null, "SecurityException while creating signature");
        }
    }

    public void sendErrorReport(FetchDataFromThread<Response, Void> fetchDataFromThread, List<LogModel> list, UserDM userDM, String str, String str2, String str3, String str4, String str5) {
        final List<LogModel> list2 = list;
        final String str6 = str3;
        final UserDM userDM2 = userDM;
        final String str7 = str4;
        final String str8 = str5;
        final String str9 = str;
        final String str10 = str2;
        final FetchDataFromThread<Response, Void> fetchDataFromThread2 = fetchDataFromThread;
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    Object jsonifyLogModelList = ErrorReportsDM.this.platform.getJsonifier().jsonifyLogModelList(list2);
                    Device device = ErrorReportsDM.this.platform.getDevice();
                    String appName = device.getAppName();
                    String appVersion = device.getAppVersion();
                    ArrayList arrayList = new ArrayList(5);
                    arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject("domain", ErrorReportsDM.this.platform.getDomain()));
                    arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject("dm", str6));
                    arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject(ProfileTable.Columns.COLUMN_DID, userDM2.getDeviceId()));
                    if (!StringUtils.isEmpty(str7)) {
                        arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject("cdid", str7));
                    }
                    arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject("os", str8));
                    if (!StringUtils.isEmpty(appName)) {
                        arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject("an", appName));
                    }
                    if (!StringUtils.isEmpty(appVersion)) {
                        arrayList.add(ErrorReportsDM.this.platform.getJsonifier().jsonifyToObject("av", appVersion));
                    }
                    Object jsonifyListToJsonArray = ErrorReportsDM.this.platform.getJsonifier().jsonifyListToJsonArray(arrayList);
                    HashMap hashMap = new HashMap();
                    hashMap.put("id", UUID.randomUUID().toString());
                    hashMap.put(MetadataRule.FIELD_V, str9);
                    hashMap.put("ctime", HSFormat.errorLogReportingTimeFormat.format(HSDateFormatSpec.getCurrentAdjustedTime(ErrorReportsDM.this.platform)));
                    hashMap.put(AnalyticsEventKey.FAQ_SOURCE, "sdk.android." + str10);
                    hashMap.put("logs", jsonifyLogModelList.toString());
                    hashMap.put("md", jsonifyListToJsonArray.toString());
                    fetchDataFromThread2.onDataFetched(new GuardOKNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new CustomAuthDataPOSTNetwork("/events/crash-log", ErrorReportsDM.this.domain, ErrorReportsDM.this.platform, ErrorReportsDM.this.getAuthDataForErrorReports())), ErrorReportsDM.this.platform)).makeRequest(new RequestData((Map<String, String>) hashMap)));
                } catch (RootAPIException unused) {
                    fetchDataFromThread2.onFailure(null);
                }
            }
        });
    }
}
