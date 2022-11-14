package com.helpshift.faq;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.ContentUnchangedNetwork;
import com.helpshift.common.domain.network.ETagNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GETNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.faq.dao.FaqEventDAO;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FaqsDM implements AutoRetriableDM {
    public final Domain domain;
    public final FaqEventDAO faqEventDAO;
    public final Platform platform;

    public FaqsDM(Domain domain2, Platform platform2) {
        this.domain = domain2;
        this.platform = platform2;
        this.faqEventDAO = platform2.getFaqEventDAO();
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.FAQ, this);
    }

    public void fetchFaqs(final FetchDataFromThread<FaqsResponse, ExceptionType> fetchDataFromThread) {
        if (fetchDataFromThread != null) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        Network faqsNetwork = FaqsDM.this.getFaqsNetwork("/faqs/");
                        HashMap hashMap = new HashMap();
                        hashMap.put("edfl", String.valueOf(FaqsDM.this.domain.getSDKConfigurationDM().getBoolean(SDKConfigurationDM.DEFAULT_FALLBACK_LANGUAGE_ENABLE)));
                        RequestData requestData = new RequestData((Map<String, String>) hashMap);
                        HashMap hashMap2 = new HashMap();
                        String sDKLanguage = FaqsDM.this.domain.getLocaleProviderDM().getSDKLanguage();
                        String defaultLanguage = FaqsDM.this.domain.getLocaleProviderDM().getDefaultLanguage();
                        if (StringUtils.isEmpty(sDKLanguage)) {
                            sDKLanguage = defaultLanguage;
                        }
                        int i = 1;
                        hashMap2.put(GraphRequest.ACCEPT_LANGUAGE_HEADER, String.format(Locale.ENGLISH, "%s;q=1.0", new Object[]{sDKLanguage}));
                        requestData.setCustomHeaders(hashMap2);
                        Object obj = null;
                        FaqsDM.this.setFaqsCustomHeaders(requestData, (String) null);
                        String str = faqsNetwork.makeRequest(requestData).responseString;
                        if (str != null) {
                            obj = FaqsDM.this.platform.getJsonifier().jsonifyToArray(str);
                        } else {
                            i = 2;
                        }
                        fetchDataFromThread.onDataFetched(new FaqsResponse(obj, i));
                    } catch (RootAPIException e) {
                        fetchDataFromThread.onFailure(e.exceptionType);
                    }
                }
            });
        }
    }

    public void fetchQuestion(FetchDataFromThread<FaqCore, Integer> fetchDataFromThread, String str, String str2, boolean z) {
        final String str3 = str2;
        final boolean z2 = z;
        final String str4 = str;
        final FetchDataFromThread<FaqCore, Integer> fetchDataFromThread2 = fetchDataFromThread;
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                boolean z;
                try {
                    HashMap hashMap = new HashMap();
                    String str = str3;
                    if (z2) {
                        z = true;
                    } else {
                        z = FaqsDM.this.domain.getSDKConfigurationDM().getBoolean(SDKConfigurationDM.DEFAULT_FALLBACK_LANGUAGE_ENABLE);
                    }
                    hashMap.put("edfl", String.valueOf(z));
                    RequestData requestData = new RequestData((Map<String, String>) hashMap);
                    FaqsDM.this.setFaqsCustomHeaders(requestData, str);
                    fetchDataFromThread2.onDataFetched(FaqsDM.this.platform.getResponseParser().parseSingleFAQ(FaqsDM.this.getFaqsNetwork("/faqs/" + str4 + "/").makeRequest(requestData).responseString));
                } catch (RootAPIException e) {
                    if (e.exceptionType != NetworkException.CONTENT_UNCHANGED) {
                        int serverStatusCode = e.getServerStatusCode();
                        if (serverStatusCode == NetworkErrorCodes.FORBIDDEN_ACCESS.intValue() || serverStatusCode == NetworkErrorCodes.CONTENT_NOT_FOUND.intValue()) {
                            if (z2) {
                                FaqsDM.this.platform.getFAQSuggestionsDAO().removeFAQ(str4, str3);
                            }
                            FaqsDM.this.platform.getNetworkRequestDAO().storeETag(GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("/faqs/"), str4, "/"), "");
                        }
                        fetchDataFromThread2.onFailure(Integer.valueOf(serverStatusCode));
                    }
                }
            }
        });
    }

    public Network getFaqsNetwork(String str) {
        return new ETagNetwork(new GuardOKNetwork(new ContentUnchangedNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new GETNetwork(str, this.domain, this.platform)), this.platform))), this.platform, str);
    }

    public void markHelpful(final String str, final boolean z) {
        AnalyticsEventType analyticsEventType;
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    FaqsDM.this.send(str, z);
                } catch (RootAPIException e) {
                    if (e.exceptionType != NetworkException.NON_RETRIABLE) {
                        FaqsDM.this.faqEventDAO.insertFaqMarkHelpfulEvent(str, z);
                        FaqsDM.this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.FAQ, e.getServerStatusCode());
                        throw e;
                    }
                }
            }
        });
        if (z) {
            analyticsEventType = AnalyticsEventType.MARKED_HELPFUL;
        } else {
            analyticsEventType = AnalyticsEventType.MARKED_UNHELPFUL;
        }
        this.domain.getAnalyticsEventDM().pushEvent(analyticsEventType, str);
    }

    public void send(String str, boolean z) {
        String str2;
        if (z) {
            str2 = GeneratedOutlineSupport.outline17("/faqs/", str, "/helpful/");
        } else {
            str2 = GeneratedOutlineSupport.outline17("/faqs/", str, "/unhelpful/");
        }
        new GuardOKNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new POSTNetwork(str2, this.domain, this.platform)), this.platform)).makeRequest(new RequestData((Map<String, String>) new HashMap()));
    }

    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        Map<String, Boolean> unSentFaqMarkHelpfulEvents;
        if (eventType == AutoRetryFailedEventDM.EventType.FAQ && (unSentFaqMarkHelpfulEvents = this.faqEventDAO.getUnSentFaqMarkHelpfulEvents()) != null) {
            for (String next : unSentFaqMarkHelpfulEvents.keySet()) {
                try {
                    send(next, unSentFaqMarkHelpfulEvents.get(next).booleanValue());
                    this.faqEventDAO.removeFaqMarkHelpfulEvent(next);
                } catch (RootAPIException e) {
                    if (e.exceptionType == NetworkException.NON_RETRIABLE) {
                        this.faqEventDAO.removeFaqMarkHelpfulEvent(next);
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    public void setFaqsCustomHeaders(RequestData requestData, String str) {
        HashMap hashMap = new HashMap();
        if (StringUtils.isEmpty(str)) {
            str = this.domain.getLocaleProviderDM().getSDKLanguage();
            String defaultLanguage = this.domain.getLocaleProviderDM().getDefaultLanguage();
            if (StringUtils.isEmpty(str)) {
                str = defaultLanguage;
            }
        }
        hashMap.put(GraphRequest.ACCEPT_LANGUAGE_HEADER, String.format(Locale.ENGLISH, "%s;q=1.0", new Object[]{str}));
        requestData.setCustomHeaders(hashMap);
    }
}
