package com.helpshift.support;

import android.content.Context;
import android.database.SQLException;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.configuration.response.PeriodicReview;
import com.helpshift.faq.FaqCore;
import com.helpshift.faq.FaqsResponse;
import com.helpshift.logger.model.LogModel;
import com.helpshift.model.InfoModelFactory;
import com.helpshift.model.SdkInfoModel;
import com.helpshift.providers.CrossModuleDataProvider;
import com.helpshift.providers.ICampaignsModuleAPIs;
import com.helpshift.support.HSSearch;
import com.helpshift.support.constants.GetSectionsCallBackStatus;
import com.helpshift.support.model.FaqSearchIndex;
import com.helpshift.support.model.FuzzySearchToken;
import com.helpshift.support.storage.FaqDAO;
import com.helpshift.support.storage.FaqsDataSource;
import com.helpshift.support.storage.SectionDAO;
import com.helpshift.support.storage.SectionsDataSource;
import com.helpshift.util.ErrorReportProvider;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public final class HSApiData {
    public static final String TAG = "Helpshift_ApiData";
    public static final Object faqIndexLock = new Object();
    public static final Object flatFaqListSyncLock = new Object();
    public static ArrayList<HSFaqSyncStatusEvents> observers;
    public Iterator failedApiKeys = null;
    public FaqDAO faqDAO;
    public ArrayList<Faq> flatFaqList = null;
    public SectionDAO sectionDAO;
    public HSStorage storage;

    public HSApiData(Context context) {
        this.storage = new HSStorage(context);
        this.sectionDAO = SectionsDataSource.getInstance();
        this.faqDAO = FaqsDataSource.getInstance();
    }

    public static void addFaqSyncStatusObserver(HSFaqSyncStatusEvents hSFaqSyncStatusEvents) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(hSFaqSyncStatusEvents);
    }

    private void getAndStoreSections(final Handler handler, final Handler handler2, final FaqTagFilter faqTagFilter) {
        HelpshiftContext.getCoreApi().getFaqDM().fetchFaqs(new FetchDataFromThread<FaqsResponse, ExceptionType>() {
            public void onDataFetched(FaqsResponse faqsResponse) {
                Handler handler = handler;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    int i = faqsResponse.statusCode;
                    if (1 == i) {
                        obtainMessage.what = GetSectionsCallBackStatus.API_SUCCESS_NEW_DATA;
                    } else if (2 == i) {
                        obtainMessage.what = GetSectionsCallBackStatus.API_SUCCESS_NO_NEW_DATA;
                    }
                    Object obj = faqsResponse.response;
                    if (obj != null) {
                        HSApiData.this.storeSections((JSONArray) obj);
                        obtainMessage.obj = HSApiData.this.sectionDAO.getAllSections(faqTagFilter);
                        HSApiData.this.startSearchIndexing();
                    }
                    handler.sendMessage(obtainMessage);
                    HSApiData.signalFaqsUpdated();
                }
            }

            public void onFailure(ExceptionType exceptionType) {
                int i;
                Handler handler = handler2;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.obj = exceptionType;
                    if (exceptionType == NetworkException.CONTENT_UNCHANGED) {
                        i = GetSectionsCallBackStatus.API_FAILURE_CONTENT_UNCHANGED;
                    } else {
                        i = GetSectionsCallBackStatus.API_FAILURE;
                    }
                    obtainMessage.what = i;
                    handler2.sendMessage(obtainMessage);
                }
            }
        });
    }

    private void getQuestionAsync(String str, String str2, boolean z, Handler handler, Handler handler2) {
        final Handler handler3 = handler;
        final boolean z2 = z;
        final Handler handler4 = handler2;
        final String str3 = str;
        HelpshiftContext.getCoreApi().getFaqDM().fetchQuestion(new FetchDataFromThread<FaqCore, Integer>() {
            public void onDataFetched(FaqCore faqCore) {
                Message obtainMessage = handler3.obtainMessage();
                Faq faq = new Faq(faqCore, HSApiData.this.getPublishIdFromSectionId(faqCore.section_id));
                obtainMessage.obj = faq;
                handler3.sendMessage(obtainMessage);
                if (z2) {
                    HelpshiftContext.getPlatform().getFAQSuggestionsDAO().insertOrUpdateFAQ(faq);
                } else {
                    HSApiData.this.faqDAO.addFaq(faq);
                }
            }

            public void onFailure(Integer num) {
                Message obtainMessage = handler4.obtainMessage();
                if (NetworkErrorCodes.FORBIDDEN_ACCESS.equals(num) || NetworkErrorCodes.CONTENT_NOT_FOUND.equals(num)) {
                    if (!z2) {
                        HSApiData.this.faqDAO.removeFaq(str3);
                    }
                    SdkInfoModel sdkInfoModel = InfoModelFactory.getInstance().sdkInfoModel;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("/faqs/");
                    outline24.append(str3);
                    outline24.append("/");
                    sdkInfoModel.clearEtag(outline24.toString());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("status", num);
                obtainMessage.obj = hashMap;
                handler4.sendMessage(obtainMessage);
            }
        }, str, str2, z);
    }

    public static void removeFaqSyncStatusObserver(HSFaqSyncStatusEvents hSFaqSyncStatusEvents) {
        ArrayList<HSFaqSyncStatusEvents> arrayList = observers;
        if (arrayList != null) {
            arrayList.remove(hSFaqSyncStatusEvents);
        }
    }

    public static void signalFaqsUpdated() {
        if (observers != null) {
            for (int i = 0; i < observers.size(); i++) {
                HSFaqSyncStatusEvents hSFaqSyncStatusEvents = observers.get(i);
                if (hSFaqSyncStatusEvents != null) {
                    hSFaqSyncStatusEvents.faqsUpdated();
                }
            }
        }
    }

    public static void signalSearchIndexesUpdated() {
        if (observers != null) {
            for (int i = 0; i < observers.size(); i++) {
                HSFaqSyncStatusEvents hSFaqSyncStatusEvents = observers.get(i);
                if (hSFaqSyncStatusEvents != null) {
                    hSFaqSyncStatusEvents.searchIndexesUpdated();
                }
            }
        }
    }

    private void updateFlatList() {
        ArrayList<Section> sections = getSections();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sections.size(); i++) {
            arrayList.addAll(getFaqsDataForSection(sections.get(i).getPublishId()));
        }
        synchronized (flatFaqListSyncLock) {
            this.flatFaqList = new ArrayList<>(arrayList);
        }
    }

    public void clearETagsForFaqs() {
        for (String questionRoute : this.faqDAO.getAllFaqPublishIds()) {
            String questionRoute2 = getQuestionRoute(questionRoute);
            HelpshiftContext.getPlatform().getNetworkRequestDAO().storeETag(questionRoute2, "");
            InfoModelFactory.getInstance().sdkInfoModel.clearEtag(questionRoute2);
        }
        HelpshiftContext.getPlatform().getNetworkRequestDAO().storeETag("/faqs/", (String) null);
    }

    public List<Faq> getAllFaqs(FaqTagFilter faqTagFilter) {
        ArrayList<Faq> arrayList = this.flatFaqList;
        if (arrayList == null) {
            updateFlatList();
        } else {
            Iterator<Faq> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().clearSearchTerms();
            }
        }
        if (faqTagFilter != null) {
            return new ArrayList(this.faqDAO.getFilteredFaqs(new ArrayList(this.flatFaqList), faqTagFilter));
        }
        return this.flatFaqList;
    }

    public ArrayList<Faq> getFaqsDataForSection(String str) {
        ArrayList<Faq> arrayList = new ArrayList<>();
        try {
            return (ArrayList) this.faqDAO.getFaqsDataForSection(str);
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting faqs for section", e);
            return arrayList;
        }
    }

    public ArrayList<Faq> getFaqsForSection(String str, FaqTagFilter faqTagFilter) {
        ArrayList<Faq> arrayList = new ArrayList<>();
        try {
            return (ArrayList) this.faqDAO.getFaqsForSection(str, faqTagFilter);
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting faqs for section", e);
            return arrayList;
        }
    }

    public ArrayList<Section> getPopulatedSections(ArrayList<Section> arrayList, FaqTagFilter faqTagFilter) {
        ArrayList<Section> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (!isSectionEmpty(arrayList.get(i), faqTagFilter)) {
                arrayList2.add(arrayList.get(i));
            }
        }
        return arrayList2;
    }

    public String getPublishIdFromSectionId(String str) {
        ArrayList<Section> sections = getSections();
        String str2 = "";
        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            if (section.getSectionId().equals(str)) {
                str2 = section.getPublishId();
            }
        }
        return str2;
    }

    public void getQuestion(Handler handler, Handler handler2, boolean z, boolean z2, String str, String str2) {
        Faq faq;
        if (TextUtils.isEmpty(str)) {
            handler2.sendMessage(handler2.obtainMessage());
            return;
        }
        if (z2) {
            faq = (Faq) HelpshiftContext.getPlatform().getFAQSuggestionsDAO().getFAQ(str, str2);
            if (faq == null) {
                faq = this.faqDAO.getFaq(str, str2);
            }
        } else {
            faq = this.faqDAO.getFaq(str);
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = faq;
        handler.sendMessage(obtainMessage);
        if (faq == null || z) {
            getQuestionAsync(str, str2, z2, handler, handler2);
        }
    }

    public String getQuestionRoute(String str) {
        return GeneratedOutlineSupport.outline17("/faqs/", str, "/");
    }

    public void getSection(final String str, final Handler handler, Handler handler2, FaqTagFilter faqTagFilter) {
        try {
            if (TextUtils.isEmpty(str)) {
                handler2.sendMessage(handler2.obtainMessage());
                return;
            }
            Section section = this.sectionDAO.getSection(str);
            if (section != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = section;
                handler.sendMessage(obtainMessage);
            }
            getAndStoreSections(new Handler() {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    Section section = HSApiData.this.sectionDAO.getSection(str);
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.obj = section;
                    handler.sendMessage(obtainMessage);
                }
            }, handler2, faqTagFilter);
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting section data ", e);
        }
    }

    public void getSectionSync(String str, Handler handler, Handler handler2) {
        if (TextUtils.isEmpty(str)) {
            handler2.sendMessage(handler2.obtainMessage());
            return;
        }
        try {
            Section section = this.sectionDAO.getSection(str);
            if (section != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = section;
                handler.sendMessage(obtainMessage);
                return;
            }
            handler2.sendMessage(handler2.obtainMessage());
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting section data ", e);
        }
    }

    public void getSections(Handler handler, Handler handler2, FaqTagFilter faqTagFilter) {
        ArrayList arrayList;
        try {
            arrayList = (ArrayList) this.sectionDAO.getAllSections(faqTagFilter);
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting sections data ", e);
            arrayList = null;
        }
        if (arrayList != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = GetSectionsCallBackStatus.DATABASE_SUCCESS;
            obtainMessage.obj = arrayList;
            handler.sendMessage(obtainMessage);
        } else {
            Message obtainMessage2 = handler2.obtainMessage();
            obtainMessage2.what = GetSectionsCallBackStatus.DATABASE_FAILURE;
            handler2.sendMessage(obtainMessage2);
        }
        getAndStoreSections(handler, handler2, faqTagFilter);
    }

    public boolean isSectionEmpty(Section section, FaqTagFilter faqTagFilter) {
        return getFaqsForSection(section.getPublishId(), faqTagFilter).isEmpty();
    }

    public void loadIndex() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    HSApiData.this.storage.loadIndex();
                } catch (IOException | ClassCastException | ClassNotFoundException e) {
                    HSLogger.m3242e(HSApiData.TAG, "Exception while loading index: trying to re-create the index", e);
                    HSApiData.this.updateIndex();
                    try {
                        HSApiData.this.storage.loadIndex();
                    } catch (Exception e2) {
                        HSLogger.m3242e(HSApiData.TAG, "Exception caught again, while loading index: ", e2);
                    }
                }
            }
        }, "HS-load-index");
        thread.setDaemon(true);
        thread.start();
    }

    public ArrayList<Faq> localFaqSearch(String str, HSSearch.HS_SEARCH_OPTIONS hs_search_options) {
        return localFaqSearch(str, hs_search_options, (FaqTagFilter) null);
    }

    public void markFaqInDB(String str, boolean z) {
        this.faqDAO.setIsHelpful(str, Boolean.valueOf(z));
    }

    public void resetReviewCounter() {
        int reviewCounter = this.storage.getReviewCounter();
        String str = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getPeriodicReview().type;
        if (str.equals(AnalyticsEventKey.SEARCH_QUERY)) {
            reviewCounter = (int) (new Date().getTime() / 1000);
        } else if (str.equals(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL)) {
            reviewCounter = 0;
        }
        this.storage.setReviewCounter(reviewCounter);
        this.storage.setLaunchReviewCounter(0);
    }

    public void sendErrorReports(List<LogModel> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    ICampaignsModuleAPIs campaignModuleAPIs = CrossModuleDataProvider.getCampaignModuleAPIs();
                    HelpshiftContext.getCoreApi().getErrorReportsDM().sendErrorReport(new FetchDataFromThread<Response, Void>() {
                        public void onDataFetched(Response response) {
                            HSLogger.deleteAll();
                        }

                        public void onFailure(Void voidR) {
                            HSApiData.this.storage.setLastErrorReportedTime((HSDateFormatSpec.getCurrentAdjustedTimeInMillis(HelpshiftContext.getPlatform()) - ErrorReportProvider.BATCH_TIME) - 1);
                        }
                    }, list, HelpshiftContext.getCoreApi().getUserManagerDM().getActiveUser(), NetworkConstants.apiVersion, "7.11.0", Build.MODEL, campaignModuleAPIs != null ? campaignModuleAPIs.getDeviceIdentifier() : "", Build.VERSION.RELEASE);
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean shouldShowReviewPopup() {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        if (sDKConfigurationDM.getBoolean(SDKConfigurationDM.APP_REVIEWED) || TextUtils.isEmpty(sDKConfigurationDM.getString(SDKConfigurationDM.REVIEW_URL))) {
            return false;
        }
        PeriodicReview periodicReview = sDKConfigurationDM.getPeriodicReview();
        if (periodicReview.isEnabled && periodicReview.interval > 0) {
            int reviewCounter = this.storage.getReviewCounter();
            String str = periodicReview.type;
            int i = periodicReview.interval;
            if (AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL.equals(str) && reviewCounter >= i) {
                return true;
            }
            if (!AnalyticsEventKey.SEARCH_QUERY.equals(str) || reviewCounter == 0 || (new Date().getTime() / 1000) - ((long) reviewCounter) < ((long) i)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void startSearchIndexing() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                HSApiData.this.updateIndex();
            }
        }, "HS-search-index");
        thread.setDaemon(true);
        thread.start();
    }

    public void storeFile(String str) {
        try {
            JSONArray storedFiles = this.storage.getStoredFiles();
            storedFiles.put(str);
            this.storage.setStoredFiles(storedFiles);
        } catch (JSONException e) {
            HSLogger.m3238d(TAG, "storeFile", (Throwable) e);
        }
    }

    public void storeSections(JSONArray jSONArray) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Updating ");
        outline24.append(jSONArray == null ? 0 : jSONArray.length());
        outline24.append(" FAQ sections in DB");
        HSLogger.m3237d(TAG, outline24.toString());
        this.sectionDAO.clearSectionsData();
        this.sectionDAO.storeSections(jSONArray);
    }

    public void updateIndex() {
        synchronized (faqIndexLock) {
            HSLogger.m3237d(TAG, "Updating search indexes.");
            this.storage.deleteIndex();
            updateFlatList();
            FaqSearchIndex indexDocuments = HSSearch.indexDocuments(new ArrayList(this.flatFaqList));
            if (indexDocuments != null) {
                this.storage.storeIndex(indexDocuments);
            }
            signalSearchIndexesUpdated();
            HSLogger.m3237d(TAG, "Search index update finished.");
        }
    }

    public void updateReviewCounter() {
        int i;
        int reviewCounter = this.storage.getReviewCounter();
        int launchReviewCounter = this.storage.getLaunchReviewCounter();
        if (reviewCounter == 0) {
            i = (int) (new Date().getTime() / 1000);
        } else {
            i = reviewCounter;
            reviewCounter = launchReviewCounter;
        }
        this.storage.setLaunchReviewCounter(reviewCounter + 1);
        if (AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL.equals(HelpshiftContext.getCoreApi().getSDKConfigurationDM().getPeriodicReview().type)) {
            i = this.storage.getLaunchReviewCounter();
        }
        this.storage.setReviewCounter(i);
    }

    public ArrayList<Faq> localFaqSearch(String str, HSSearch.HS_SEARCH_OPTIONS hs_search_options, FaqTagFilter faqTagFilter) {
        ArrayList<Faq> arrayList = this.flatFaqList;
        if (arrayList == null) {
            updateFlatList();
        } else {
            Iterator<Faq> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().clearSearchTerms();
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String lowerCase = str.toLowerCase();
        if (this.storage.isCacheSearchIndexNull() || !this.storage.getDBFlag().booleanValue()) {
            for (int i = 0; i < this.flatFaqList.size(); i++) {
                Faq faq = this.flatFaqList.get(i);
                if (!faq.title.toLowerCase().contains(lowerCase)) {
                    linkedHashSet.add(faq);
                }
            }
        } else {
            FaqSearchIndex readIndex = this.storage.readIndex();
            Map<String, List<FuzzySearchToken>> map = null;
            if (readIndex != null) {
                map = readIndex.fuzzyIndex;
            }
            ArrayList<HashMap> queryDocs = HSSearch.queryDocs(str, hs_search_options);
            ArrayList<HashMap> fuzzyMatches = HSSearch.getFuzzyMatches(str, map);
            Iterator<HashMap> it2 = queryDocs.iterator();
            while (it2.hasNext()) {
                HashMap next = it2.next();
                int intValue = Integer.decode((String) next.get("f")).intValue();
                if (intValue < this.flatFaqList.size()) {
                    Faq faq2 = this.flatFaqList.get(intValue);
                    faq2.addSearchTerms((ArrayList) next.get("t"));
                    linkedHashSet.add(faq2);
                }
            }
            Iterator<HashMap> it3 = fuzzyMatches.iterator();
            while (it3.hasNext()) {
                HashMap next2 = it3.next();
                int intValue2 = Integer.decode((String) next2.get("f")).intValue();
                if (intValue2 < this.flatFaqList.size()) {
                    Faq faq3 = this.flatFaqList.get(intValue2);
                    faq3.addSearchTerms((ArrayList) next2.get("t"));
                    linkedHashSet.add(faq3);
                }
            }
        }
        if (faqTagFilter != null) {
            return new ArrayList<>(this.faqDAO.getFilteredFaqs(new ArrayList(linkedHashSet), faqTagFilter));
        }
        return new ArrayList<>(linkedHashSet);
    }

    public ArrayList<Section> getPopulatedSections(FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList = (ArrayList) this.sectionDAO.getAllSections(faqTagFilter);
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting sections data ", e);
        }
        return getPopulatedSections(arrayList, faqTagFilter);
    }

    public Section getSection(String str) {
        return this.sectionDAO.getSection(str);
    }

    public ArrayList<Section> getSections() {
        ArrayList<Section> arrayList = new ArrayList<>();
        try {
            return (ArrayList) this.sectionDAO.getAllSections();
        } catch (SQLException e) {
            HSLogger.m3242e(TAG, "Database exception in getting sections data ", e);
            return arrayList;
        }
    }
}
