package com.helpshift.conversation.smartintent;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.ETagNetwork;
import com.helpshift.common.domain.network.GETNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.smartintent.dao.SmartIntentDAO;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SISearchResultDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.p042db.smartintents.tables.SmartIntentTreeTable;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmartIntentDM {
    public static String SI_MODEL_ROUTE_ETAG_SUFFIX = "smart_intent_model_route";
    public static String SI_TREE_ROUTE_ETAG_SUFFIX = "smart_intent_tree_route";
    public static final String TAG = "Helpshift_SmartIntDM";
    public SmartIntentDMCallback callback;
    public Domain domain;
    public Set<Long> inProgressModelFetchRequests = Collections.synchronizedSet(new HashSet());
    public Set<Long> inProgressTreeFetchRequests = Collections.synchronizedSet(new HashSet());
    public Platform platform;
    public SmartIntentSearchManager searchManager;
    public SmartIntentDAO smartIntentDAO;

    public SmartIntentDM(Platform platform2, Domain domain2) {
        this.domain = domain2;
        this.platform = platform2;
        SmartIntentDAO smartIntentDAO2 = platform2.getSmartIntentDAO();
        this.smartIntentDAO = smartIntentDAO2;
        this.searchManager = new SmartIntentSearchManager(smartIntentDAO2);
    }

    /* access modifiers changed from: private */
    public void clearETagFromStorage(String str) {
        this.platform.getNetworkRequestDAO().removeETag(str);
    }

    /* access modifiers changed from: private */
    public boolean deleteModel(UserDM userDM, SITreeDTO sITreeDTO) {
        if (userDM == null || sITreeDTO == null) {
            return false;
        }
        clearETagFromStorage(getKeyToStoreETag(userDM, SI_MODEL_ROUTE_ETAG_SUFFIX));
        return this.smartIntentDAO.deleteModel(sITreeDTO.localId.longValue());
    }

    /* access modifiers changed from: private */
    public boolean deleteTreeAndModel(UserDM userDM) {
        if (userDM == null) {
            return false;
        }
        clearETagFromStorage(getKeyToStoreETag(userDM, SI_TREE_ROUTE_ETAG_SUFFIX));
        clearETagFromStorage(getKeyToStoreETag(userDM, SI_MODEL_ROUTE_ETAG_SUFFIX));
        return this.smartIntentDAO.deleteTreeAndModel(userDM);
    }

    /* access modifiers changed from: private */
    public RequestData getIntentModelRequestData(UserDM userDM, SITreeDTO sITreeDTO) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put(SmartIntentTreeTable.Columns.TREE_VERSION, String.valueOf(sITreeDTO.version));
        return new RequestData((Map<String, String>) userRequestData);
    }

    /* access modifiers changed from: private */
    public RequestData getIntentTreeRequestData(UserDM userDM) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put("platform_id", this.platform.getAppId());
        return new RequestData((Map<String, String>) userRequestData);
    }

    /* access modifiers changed from: private */
    public String getKeyToStoreETag(UserDM userDM, String str) {
        return userDM.getLocalId() + "_" + str;
    }

    /* access modifiers changed from: private */
    public void handleModelRefreshFailure(UserDM userDM, SITreeDTO sITreeDTO) {
        checkAndDeleteCachedModel(userDM, sITreeDTO);
    }

    /* access modifiers changed from: private */
    public void handleModelRefreshSuccess() {
    }

    /* access modifiers changed from: private */
    public void handleTreeRefreshFailure(UserDM userDM) {
        SITreeDTO tree = !checkAndDeleteCachedTree(userDM) ? this.smartIntentDAO.getTree(userDM) : null;
        if (tree != null) {
            notifyTreeAvailableCallback(userDM, tree);
        } else {
            notifyTreeUnAvailableCallback(userDM);
        }
    }

    /* access modifiers changed from: private */
    public void handleTreeRefreshSuccess(UserDM userDM) {
        SITreeDTO tree = this.smartIntentDAO.getTree(userDM);
        if (tree != null) {
            notifyTreeAvailableCallback(userDM, tree);
            return;
        }
        deleteTreeAndModel(userDM);
        notifyTreeUnAvailableCallback(userDM);
    }

    private void notifyTreeAvailableCallback(UserDM userDM, SITreeDTO sITreeDTO) {
        HSLogger.m3237d(TAG, "Smart intent tree available");
        SmartIntentDMCallback smartIntentDMCallback = this.callback;
        if (smartIntentDMCallback != null) {
            smartIntentDMCallback.onTreeAvailable(userDM, sITreeDTO);
        }
        refreshSmartIntentSearchModel(userDM, sITreeDTO);
    }

    /* access modifiers changed from: private */
    public void notifyTreeUnAvailableCallback(UserDM userDM) {
        HSLogger.m3237d(TAG, "Smart intent tree unavailable");
        SmartIntentDMCallback smartIntentDMCallback = this.callback;
        if (smartIntentDMCallback != null) {
            smartIntentDMCallback.onTreeUnAvailable(userDM);
        }
    }

    /* access modifiers changed from: private */
    public void updateLastSuccessfulModelFetchTime(long j) {
        this.smartIntentDAO.updateModelLastRefreshedAtTime(j, HSDateFormatSpec.getCurrentAdjustedTimeInMillis(this.platform));
    }

    /* access modifiers changed from: private */
    public void updateLastSuccessfulTreeFetchTime(UserDM userDM) {
        this.smartIntentDAO.updateTreeLastRefreshedAtTime(userDM, HSDateFormatSpec.getCurrentAdjustedTimeInMillis(this.platform));
    }

    public boolean checkAndDeleteCachedModel(UserDM userDM, SITreeDTO sITreeDTO) {
        SISearchModelDTO modelWithoutWordProbabilities = this.smartIntentDAO.getModelWithoutWordProbabilities(sITreeDTO.localId.longValue());
        if (modelWithoutWordProbabilities == null) {
            return false;
        }
        if (HSDateFormatSpec.getCurrentAdjustedTimeInMillis(this.platform) - modelWithoutWordProbabilities.lastRefreshedAt >= this.domain.getSDKConfigurationDM().getSmartIntentClientCacheExpiryInterval()) {
            return deleteModel(userDM, sITreeDTO);
        }
        return false;
    }

    public boolean checkAndDeleteCachedTree(UserDM userDM) {
        SITreeDTO tree = this.smartIntentDAO.getTree(userDM);
        if (tree == null) {
            return false;
        }
        if (HSDateFormatSpec.getCurrentAdjustedTimeInMillis(this.platform) - tree.lastRefreshedAt >= this.domain.getSDKConfigurationDM().getSmartIntentClientCacheExpiryInterval()) {
            return deleteTreeAndModel(userDM);
        }
        return false;
    }

    public void clearUserData(UserDM userDM) {
        deleteTreeAndModel(userDM);
    }

    public void fetchSmartIntentModelFromServer(final UserDM userDM, final SITreeDTO sITreeDTO) {
        if (!isModelFetchRequestInProgress(userDM)) {
            this.inProgressModelFetchRequests.add(userDM.getLocalId());
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    String outline18 = GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("/intent-trees/"), sITreeDTO.serverId, "/models/");
                    String access$100 = SmartIntentDM.this.getKeyToStoreETag(userDM, SmartIntentDM.SI_MODEL_ROUTE_ETAG_SUFFIX);
                    try {
                        SISearchModelDTO parseSmartIntentSearchModel = SmartIntentDM.this.platform.getResponseParser().parseSmartIntentSearchModel(new GuardOKNetwork(new ETagNetwork(new TSCorrectedNetwork(new GETNetwork(outline18, SmartIntentDM.this.domain, SmartIntentDM.this.platform), SmartIntentDM.this.platform), SmartIntentDM.this.platform, access$100)).makeRequest(new RequestData(SmartIntentDM.this.getIntentModelRequestData(userDM, sITreeDTO))).responseString);
                        parseSmartIntentSearchModel.lastRefreshedAt = HSDateFormatSpec.getCurrentAdjustedTimeInMillis(SmartIntentDM.this.platform);
                        SmartIntentDM.this.smartIntentDAO.deleteModel(sITreeDTO.localId.longValue());
                        if (SmartIntentDM.this.smartIntentDAO.insertModel(sITreeDTO.localId.longValue(), parseSmartIntentSearchModel)) {
                            SmartIntentDM.this.handleModelRefreshSuccess();
                        } else {
                            SmartIntentDM.this.clearETagFromStorage(access$100);
                            SmartIntentDM.this.handleModelRefreshFailure(userDM, sITreeDTO);
                        }
                    } catch (RootAPIException e) {
                        if (0 != 0) {
                            SmartIntentDM.this.clearETagFromStorage(access$100);
                        }
                        if (e.exceptionType instanceof NetworkException) {
                            NetworkException networkException = (NetworkException) e.exceptionType;
                            if (networkException.serverStatusCode == NetworkErrorCodes.CONTENT_UNCHANGED.intValue()) {
                                SmartIntentDM.this.updateLastSuccessfulModelFetchTime(sITreeDTO.localId.longValue());
                                SmartIntentDM.this.handleModelRefreshSuccess();
                            } else {
                                if (networkException.serverStatusCode != NetworkErrorCodes.CONTENT_NOT_FOUND.intValue()) {
                                    if (networkException.serverStatusCode != NetworkErrorCodes.CONFLICT.intValue()) {
                                        HSLogger.m3242e(SmartIntentDM.TAG, "Error while fetching smart intent model : ", e);
                                        SmartIntentDM.this.handleModelRefreshFailure(userDM, sITreeDTO);
                                    }
                                }
                                HSLogger.m3242e(SmartIntentDM.TAG, "Error smart intent model not exist or cached tree is not latest: ", e);
                                boolean unused = SmartIntentDM.this.deleteModel(userDM, sITreeDTO);
                            }
                        } else {
                            HSLogger.m3242e(SmartIntentDM.TAG, "Error while fetching smart intent model : ", e);
                            SmartIntentDM.this.handleModelRefreshFailure(userDM, sITreeDTO);
                        }
                    } catch (Exception e2) {
                        if (0 != 0) {
                            SmartIntentDM.this.clearETagFromStorage(access$100);
                        }
                        HSLogger.m3242e(SmartIntentDM.TAG, "Generic error while fetching smart intent model : ", e2);
                        SmartIntentDM.this.handleModelRefreshFailure(userDM, sITreeDTO);
                    } catch (Throwable th) {
                        SmartIntentDM.this.inProgressModelFetchRequests.remove(userDM.getLocalId());
                        throw th;
                    }
                    SmartIntentDM.this.inProgressModelFetchRequests.remove(userDM.getLocalId());
                }
            });
        }
    }

    public void fetchSmartIntentTreeFromServer(final UserDM userDM) {
        if (!isTreeFetchRequestInProgress(userDM)) {
            this.inProgressTreeFetchRequests.add(userDM.getLocalId());
            this.domain.runParallel(new C2500F() {
                /* JADX WARNING: Removed duplicated region for block: B:15:0x00a5 A[SYNTHETIC, Splitter:B:15:0x00a5] */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x00cb A[SYNTHETIC, Splitter:B:22:0x00cb] */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x00d8 A[SYNTHETIC, Splitter:B:27:0x00d8] */
                /* JADX WARNING: Removed duplicated region for block: B:35:0x011e A[Catch:{ all -> 0x009d }] */
                /* renamed from: f */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void mo33949f() {
                    /*
                        r7 = this;
                        java.lang.String r0 = "Helpshift_SmartIntDM"
                        com.helpshift.conversation.smartintent.SmartIntentDM r1 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        com.helpshift.account.domainmodel.UserDM r2 = r3
                        java.lang.String r3 = com.helpshift.conversation.smartintent.SmartIntentDM.SI_TREE_ROUTE_ETAG_SUFFIX
                        java.lang.String r1 = r1.getKeyToStoreETag(r2, r3)
                        com.helpshift.common.domain.network.GETNetwork r2 = new com.helpshift.common.domain.network.GETNetwork
                        com.helpshift.conversation.smartintent.SmartIntentDM r3 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        com.helpshift.common.domain.Domain r3 = r3.domain
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        com.helpshift.common.platform.Platform r4 = r4.platform
                        java.lang.String r5 = "/intent-trees/"
                        r2.<init>(r5, r3, r4)
                        com.helpshift.common.domain.network.TSCorrectedNetwork r3 = new com.helpshift.common.domain.network.TSCorrectedNetwork
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        com.helpshift.common.platform.Platform r4 = r4.platform
                        r3.<init>(r2, r4)
                        com.helpshift.common.domain.network.ETagNetwork r2 = new com.helpshift.common.domain.network.ETagNetwork
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        com.helpshift.common.platform.Platform r4 = r4.platform
                        r2.<init>(r3, r4, r1)
                        com.helpshift.common.domain.network.GuardOKNetwork r3 = new com.helpshift.common.domain.network.GuardOKNetwork
                        r3.<init>(r2)
                        r2 = 0
                        com.helpshift.common.platform.network.RequestData r4 = new com.helpshift.common.platform.network.RequestData     // Catch:{ RootAPIException -> 0x00c6, Exception -> 0x00a0 }
                        com.helpshift.conversation.smartintent.SmartIntentDM r5 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x00c6, Exception -> 0x00a0 }
                        com.helpshift.account.domainmodel.UserDM r6 = r3     // Catch:{ RootAPIException -> 0x00c6, Exception -> 0x00a0 }
                        com.helpshift.common.platform.network.RequestData r5 = r5.getIntentTreeRequestData(r6)     // Catch:{ RootAPIException -> 0x00c6, Exception -> 0x00a0 }
                        r4.<init>((com.helpshift.common.platform.network.RequestData) r5)     // Catch:{ RootAPIException -> 0x00c6, Exception -> 0x00a0 }
                        com.helpshift.common.platform.network.Response r2 = r3.makeRequest(r4)     // Catch:{ RootAPIException -> 0x00c6, Exception -> 0x00a0 }
                        r3 = 1
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.common.platform.Platform r4 = r4.platform     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.common.platform.network.ResponseParser r4 = r4.getResponseParser()     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        java.lang.String r2 = r2.responseString     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.dto.SITreeDTO r2 = r4.parseSmartIntentTree(r2)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.common.platform.Platform r4 = r4.platform     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        long r4 = com.helpshift.common.util.HSDateFormatSpec.getCurrentAdjustedTimeInMillis(r4)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        r2.lastRefreshedAt = r4     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.dao.SmartIntentDAO r4 = r4.smartIntentDAO     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.account.domainmodel.UserDM r5 = r3     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        r4.deleteTreeAndModel(r5)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.SmartIntentDM r4 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.dao.SmartIntentDAO r4 = r4.smartIntentDAO     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.account.domainmodel.UserDM r5 = r3     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        boolean r2 = r4.insertTree(r5, r2)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        if (r2 == 0) goto L_0x008c
                        com.helpshift.conversation.smartintent.SmartIntentDM r2 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.account.domainmodel.UserDM r4 = r3     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        r2.handleTreeRefreshSuccess(r4)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        goto L_0x00b6
                    L_0x008c:
                        com.helpshift.conversation.smartintent.SmartIntentDM r2 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        r2.clearETagFromStorage(r1)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.conversation.smartintent.SmartIntentDM r2 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        com.helpshift.account.domainmodel.UserDM r4 = r3     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        r2.handleTreeRefreshFailure(r4)     // Catch:{ RootAPIException -> 0x009b, Exception -> 0x0099 }
                        goto L_0x00b6
                    L_0x0099:
                        r2 = move-exception
                        goto L_0x00a3
                    L_0x009b:
                        r2 = move-exception
                        goto L_0x00c9
                    L_0x009d:
                        r0 = move-exception
                        goto L_0x012a
                    L_0x00a0:
                        r3 = move-exception
                        r2 = r3
                        r3 = 0
                    L_0x00a3:
                        if (r3 == 0) goto L_0x00aa
                        com.helpshift.conversation.smartintent.SmartIntentDM r3 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        r3.clearETagFromStorage(r1)     // Catch:{ all -> 0x009d }
                    L_0x00aa:
                        java.lang.String r1 = "Generic error while fetching smart intent tree : "
                        com.helpshift.util.HSLogger.m3242e(r0, r1, r2)     // Catch:{ all -> 0x009d }
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        r0.handleTreeRefreshFailure(r1)     // Catch:{ all -> 0x009d }
                    L_0x00b6:
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        java.util.Set r0 = r0.inProgressTreeFetchRequests
                        com.helpshift.account.domainmodel.UserDM r1 = r3
                        java.lang.Long r1 = r1.getLocalId()
                        r0.remove(r1)
                        goto L_0x0129
                    L_0x00c6:
                        r3 = move-exception
                        r2 = r3
                        r3 = 0
                    L_0x00c9:
                        if (r3 == 0) goto L_0x00d0
                        com.helpshift.conversation.smartintent.SmartIntentDM r3 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        r3.clearETagFromStorage(r1)     // Catch:{ all -> 0x009d }
                    L_0x00d0:
                        com.helpshift.common.exception.ExceptionType r1 = r2.exceptionType     // Catch:{ all -> 0x009d }
                        boolean r1 = r1 instanceof com.helpshift.common.exception.NetworkException     // Catch:{ all -> 0x009d }
                        java.lang.String r3 = "Error while fetching smart intent tree : "
                        if (r1 == 0) goto L_0x011e
                        com.helpshift.common.exception.ExceptionType r1 = r2.exceptionType     // Catch:{ all -> 0x009d }
                        com.helpshift.common.exception.NetworkException r1 = (com.helpshift.common.exception.NetworkException) r1     // Catch:{ all -> 0x009d }
                        int r4 = r1.serverStatusCode     // Catch:{ all -> 0x009d }
                        java.lang.Integer r5 = com.helpshift.common.domain.network.NetworkErrorCodes.CONTENT_UNCHANGED     // Catch:{ all -> 0x009d }
                        int r5 = r5.intValue()     // Catch:{ all -> 0x009d }
                        if (r4 != r5) goto L_0x00f5
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        r0.updateLastSuccessfulTreeFetchTime(r1)     // Catch:{ all -> 0x009d }
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        r0.handleTreeRefreshSuccess(r1)     // Catch:{ all -> 0x009d }
                        goto L_0x00b6
                    L_0x00f5:
                        int r1 = r1.serverStatusCode     // Catch:{ all -> 0x009d }
                        java.lang.Integer r4 = com.helpshift.common.domain.network.NetworkErrorCodes.CONTENT_NOT_FOUND     // Catch:{ all -> 0x009d }
                        int r4 = r4.intValue()     // Catch:{ all -> 0x009d }
                        if (r1 != r4) goto L_0x0113
                        java.lang.String r1 = "Smart intent tree data not exist on server : "
                        com.helpshift.util.HSLogger.m3242e(r0, r1, r2)     // Catch:{ all -> 0x009d }
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        boolean unused = r0.deleteTreeAndModel(r1)     // Catch:{ all -> 0x009d }
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        r0.notifyTreeUnAvailableCallback(r1)     // Catch:{ all -> 0x009d }
                        goto L_0x00b6
                    L_0x0113:
                        com.helpshift.util.HSLogger.m3242e(r0, r3, r2)     // Catch:{ all -> 0x009d }
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        r0.handleTreeRefreshFailure(r1)     // Catch:{ all -> 0x009d }
                        goto L_0x00b6
                    L_0x011e:
                        com.helpshift.util.HSLogger.m3242e(r0, r3, r2)     // Catch:{ all -> 0x009d }
                        com.helpshift.conversation.smartintent.SmartIntentDM r0 = com.helpshift.conversation.smartintent.SmartIntentDM.this     // Catch:{ all -> 0x009d }
                        com.helpshift.account.domainmodel.UserDM r1 = r3     // Catch:{ all -> 0x009d }
                        r0.handleTreeRefreshFailure(r1)     // Catch:{ all -> 0x009d }
                        goto L_0x00b6
                    L_0x0129:
                        return
                    L_0x012a:
                        com.helpshift.conversation.smartintent.SmartIntentDM r1 = com.helpshift.conversation.smartintent.SmartIntentDM.this
                        java.util.Set r1 = r1.inProgressTreeFetchRequests
                        com.helpshift.account.domainmodel.UserDM r2 = r3
                        java.lang.Long r2 = r2.getLocalId()
                        r1.remove(r2)
                        goto L_0x013b
                    L_0x013a:
                        throw r0
                    L_0x013b:
                        goto L_0x013a
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.smartintent.SmartIntentDM.C25621.mo33949f():void");
                }
            });
        }
    }

    public SITreeDTO getSmartIntentTree(UserDM userDM) {
        return this.smartIntentDAO.getTree(userDM);
    }

    public boolean isModelFetchRequestInProgress(UserDM userDM) {
        return this.inProgressModelFetchRequests.contains(userDM.getLocalId());
    }

    public boolean isSmartIntentModelAvailable(long j) {
        SISearchModelDTO modelWithoutWordProbabilities = this.smartIntentDAO.getModelWithoutWordProbabilities(j);
        if (modelWithoutWordProbabilities == null) {
            return false;
        }
        long j2 = modelWithoutWordProbabilities.lastRefreshedAt;
        if (HSDateFormatSpec.getCurrentAdjustedTimeInMillis(this.platform) - j2 < this.domain.getSDKConfigurationDM().getSmartIntentModelRefreshInterval()) {
            return true;
        }
        return false;
    }

    public boolean isSmartIntentTreeAvailable(UserDM userDM) {
        SITreeDTO tree = this.smartIntentDAO.getTree(userDM);
        if (tree == null) {
            return false;
        }
        long j = tree.lastRefreshedAt;
        if (HSDateFormatSpec.getCurrentAdjustedTimeInMillis(this.platform) - j < this.domain.getSDKConfigurationDM().getSmartIntentTreeRefreshInterval()) {
            return true;
        }
        return false;
    }

    public boolean isTreeFetchRequestInProgress(UserDM userDM) {
        return this.inProgressTreeFetchRequests.contains(userDM.getLocalId());
    }

    public SISearchResultDTO match(SITreeDTO sITreeDTO, String str) {
        return this.searchManager.match(sITreeDTO, str);
    }

    public void refreshSmartIntentSearchModel(UserDM userDM, SITreeDTO sITreeDTO) {
        if (!isSmartIntentModelAvailable(sITreeDTO.localId.longValue())) {
            fetchSmartIntentModelFromServer(userDM, sITreeDTO);
        }
    }

    public void registerSmartIntentDMCallback(SmartIntentDMCallback smartIntentDMCallback) {
        this.callback = smartIntentDMCallback;
    }

    public boolean shouldShowSmartIntent(Conversation conversation) {
        SDKConfigurationDM sDKConfigurationDM = this.domain.getSDKConfigurationDM();
        if (!sDKConfigurationDM.isSmartIntentsEnabled() || StringUtils.isNotEmpty(sDKConfigurationDM.getString(SDKConfigurationDM.CONVERSATION_PRE_FILL_TEXT))) {
            return false;
        }
        if (sDKConfigurationDM.shouldAutoFillPreissueFirstMessage() && StringUtils.isNotEmpty(sDKConfigurationDM.getString(SDKConfigurationDM.INITIAL_USER_MESSAGE_TO_AUTOSEND_IN_PREISSUE))) {
            return false;
        }
        ConversationManager conversationManager = this.domain.getConversationInboxManagerDM().getActiveConversationInboxDM().getConversationManager();
        if (conversationManager.isSynced(conversation) || conversationManager.containsAtleastOneUserMessage(conversation)) {
            return false;
        }
        return true;
    }

    public void unregisterSmartIntentDMCallback() {
        this.callback = null;
    }
}
