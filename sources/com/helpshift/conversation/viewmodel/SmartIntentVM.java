package com.helpshift.conversation.viewmodel;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.smartintent.BaseSmartIntentViewState;
import com.helpshift.conversation.smartintent.LeafIntentUIModel;
import com.helpshift.conversation.smartintent.RootIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;
import com.helpshift.conversation.smartintent.SmartIntentCollapsedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentDM;
import com.helpshift.conversation.smartintent.SmartIntentDMCallback;
import com.helpshift.conversation.smartintent.SmartIntentExpandedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentLeafViewState;
import com.helpshift.conversation.smartintent.SmartIntentSavedState;
import com.helpshift.conversation.smartintent.SmartIntentSearchResultViewState;
import com.helpshift.conversation.smartintent.dto.SISearchResultDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.util.HSBackStackController;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.MutableBaseViewState;
import com.helpshift.widget.MutableReplyFieldViewState;
import com.helpshift.widget.ReplyFieldViewState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmartIntentVM implements SmartIntentDMCallback {
    public static final String TAG = "Helpshift_SmartVM";
    public Conversation activeConversation;
    public HSBackStackController<BaseSmartIntentViewState> backStackController = new HSBackStackController<>();
    public SITreeDTO cachedSmartIntentTree = null;
    public SmartIntentVMCallback callback;
    public MutableBaseViewState clearSearchViewState;
    public Domain domain;
    public Map<String, List<SearchIntentUIModel>> intentIdToSearchIntentUIModelMapping = null;
    public boolean isInitialized = false;
    public boolean isShowingFakeTAI = false;
    public SmartIntentSavedState lastSavedState;
    public SISearchResultDTO lastSearchResultData = null;
    public Platform platform;
    public MutableBaseViewState replyButtonViewState;
    public MutableReplyFieldViewState replyFieldViewState;
    public boolean skipSearchOnUserQueryChange = false;
    public SmartIntentDM smartIntentDM;
    public UserDM userDM;

    public SmartIntentVM(Platform platform2, Domain domain2, SmartIntentDM smartIntentDM2, UserDM userDM2, Conversation conversation, SmartIntentVMCallback smartIntentVMCallback) {
        this.platform = platform2;
        this.domain = domain2;
        this.activeConversation = conversation;
        this.userDM = userDM2;
        this.smartIntentDM = smartIntentDM2;
        this.callback = smartIntentVMCallback;
        this.replyButtonViewState = new MutableBaseViewState();
        this.replyFieldViewState = new MutableReplyFieldViewState();
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        this.clearSearchViewState = mutableBaseViewState;
        mutableBaseViewState.setVisible(false);
        this.smartIntentDM.registerSmartIntentDMCallback(this);
    }

    private SmartIntentCollapsedRootViewState buildSmartIntentCollapsedRootViewState(SITreeDTO sITreeDTO) {
        ArrayList arrayList = new ArrayList();
        for (SmartIntentDTO next : sITreeDTO.rootIntents) {
            arrayList.add(new RootIntentUIModel(next.localId.longValue(), next.label));
        }
        return new SmartIntentCollapsedRootViewState(sITreeDTO.promptTitle, sITreeDTO.textInputHint, sITreeDTO.enforceIntentSelection, arrayList);
    }

    private SmartIntentExpandedRootViewState buildSmartIntentExpandedRootViewState(SmartIntentCollapsedRootViewState smartIntentCollapsedRootViewState) {
        return new SmartIntentExpandedRootViewState(smartIntentCollapsedRootViewState.promptTitle, smartIntentCollapsedRootViewState.typingBoxHint, smartIntentCollapsedRootViewState.enforceIntentSelection, smartIntentCollapsedRootViewState.rootIntentUIModels);
    }

    private SmartIntentLeafViewState buildSmartIntentLeafViewState(SITreeDTO sITreeDTO, long j) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<SmartIntentDTO> it = sITreeDTO.rootIntents.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            SmartIntentDTO next = it.next();
            if (next.localId.longValue() == j) {
                str = next.label;
                for (SmartIntentDTO next2 : next.children) {
                    arrayList.add(new LeafIntentUIModel(next2.localId.longValue(), next2.label));
                }
            }
        }
        return new SmartIntentLeafViewState(str, sITreeDTO.textInputHint, sITreeDTO.enforceIntentSelection, j, arrayList);
    }

    private List<SearchIntentUIModel> convertToSearchIntentUIModelList(List<ValuePair<String, Double>> list) {
        Map<String, List<SearchIntentUIModel>> intentIdToSearchIntentUIModelIndex = getIntentIdToSearchIntentUIModelIndex();
        ArrayList arrayList = new ArrayList();
        if (intentIdToSearchIntentUIModelIndex == null) {
            return arrayList;
        }
        int i = 1;
        for (ValuePair next : list) {
            List<SearchIntentUIModel> list2 = intentIdToSearchIntentUIModelIndex.get(next.first);
            if (ListUtils.isNotEmpty(list2)) {
                for (SearchIntentUIModel deepClone : list2) {
                    SearchIntentUIModel deepClone2 = deepClone.deepClone();
                    deepClone2.rank = i;
                    deepClone2.confidence = (Double) next.second;
                    arrayList.add(deepClone2);
                    i++;
                }
            }
        }
        return arrayList;
    }

    private void createPreIssue(long j, Integer num, Double d) {
        List<SmartIntentDTO> rootToLeafIntents = getRootToLeafIntents(j);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SmartIntentDTO next : rootToLeafIntents) {
            arrayList.add(next.serverId);
            arrayList2.add(next.label);
        }
        this.callback.createPreIssueFromSmartIntentSelection(this.cachedSmartIntentTree.serverId, arrayList, arrayList2, this.replyFieldViewState.getReplyText());
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_IS_LEAF_INTENT, Boolean.TRUE);
        if (ListUtils.isNotEmpty(arrayList)) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_IDS, this.platform.getJsonifier().jsonifyListToJsonArray(arrayList));
        }
        if (d != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CONFIDENCE, d);
        }
        if (num != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, num);
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SELECTION, (Map<String, Object>) hashMap);
    }

    private Map<String, List<SearchIntentUIModel>> getIntentIdToSearchIntentUIModelIndex() {
        Map<String, List<SearchIntentUIModel>> map = this.intentIdToSearchIntentUIModelMapping;
        if (map != null) {
            return map;
        }
        if (this.cachedSmartIntentTree == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (SmartIntentDTO next : this.cachedSmartIntentTree.rootIntents) {
            ArrayList arrayList = new ArrayList();
            for (SmartIntentDTO next2 : next.children) {
                SearchIntentUIModel searchIntentUIModel = new SearchIntentUIModel(next2.localId.longValue(), next2.label, next.label);
                hashMap.put(next2.serverId, Collections.singletonList(searchIntentUIModel));
                arrayList.add(searchIntentUIModel);
            }
            hashMap.put(next.serverId, arrayList);
        }
        this.intentIdToSearchIntentUIModelMapping = hashMap;
        return hashMap;
    }

    private SmartIntentDTO getRootIntentDTO(long j) {
        SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
        if (sITreeDTO == null) {
            return null;
        }
        for (SmartIntentDTO next : sITreeDTO.rootIntents) {
            if (next.localId.longValue() == j) {
                return next;
            }
        }
        return null;
    }

    private List<SmartIntentDTO> getRootToLeafIntents(long j) {
        ArrayList arrayList = new ArrayList();
        SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
        if (sITreeDTO == null) {
            return arrayList;
        }
        Iterator<SmartIntentDTO> it = sITreeDTO.rootIntents.iterator();
        loop0:
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SmartIntentDTO next = it.next();
            Iterator<SmartIntentDTO> it2 = next.children.iterator();
            while (true) {
                if (it2.hasNext()) {
                    SmartIntentDTO next2 = it2.next();
                    if (next2.localId.longValue() == j) {
                        arrayList.add(next);
                        arrayList.add(next2);
                        break loop0;
                    }
                }
            }
        }
        return arrayList;
    }

    private Map<String, Object> getSearchAnalyticsData() {
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        SISearchResultDTO sISearchResultDTO = this.lastSearchResultData;
        if (sISearchResultDTO != null && sISearchResultDTO.isSearchPerformed) {
            Integer num = sISearchResultDTO.aiModelVersion;
            if (num != null) {
                hashMap.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, num);
            }
            Integer num2 = this.lastSearchResultData.searchIntentLevel;
            if (num2 != null) {
                hashMap.put(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, num2);
            }
            Integer num3 = this.lastSearchResultData.searchAlgorithmType;
            if (num3 != null) {
                if (num3.intValue() == 1) {
                    hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_ALGORITHM, "ml");
                } else if (this.lastSearchResultData.searchAlgorithmType.intValue() == 2) {
                    hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_ALGORITHM, "ss");
                }
            }
            if (this.lastSearchResultData.searchResults != null) {
                Map<String, List<SearchIntentUIModel>> intentIdToSearchIntentUIModelIndex = getIntentIdToSearchIntentUIModelIndex();
                int i = 0;
                if (intentIdToSearchIntentUIModelIndex != null) {
                    for (ValuePair<String, Double> valuePair : this.lastSearchResultData.searchResults) {
                        List list = intentIdToSearchIntentUIModelIndex.get(valuePair.first);
                        if (ListUtils.isNotEmpty(list)) {
                            i += list.size();
                        }
                    }
                }
                hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_RESULT_COUNT, Integer.valueOf(i));
            }
        }
        return hashMap;
    }

    private void handleRootIntentSelectedInternal(long j) {
        SmartIntentLeafViewState buildSmartIntentLeafViewState = buildSmartIntentLeafViewState(this.smartIntentDM.getSmartIntentTree(this.userDM), j);
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem instanceof SmartIntentCollapsedRootViewState) {
            this.backStackController.addItem(buildSmartIntentExpandedRootViewState((SmartIntentCollapsedRootViewState) topItem));
        }
        if (this.backStackController.addItem(buildSmartIntentLeafViewState)) {
            this.callback.updateSmartIntentView(buildSmartIntentLeafViewState);
        }
    }

    /* access modifiers changed from: private */
    public void handleTreeAvailable(@NonNull SITreeDTO sITreeDTO) {
        this.cachedSmartIntentTree = sITreeDTO;
        this.intentIdToSearchIntentUIModelMapping = null;
        showFakeTypingIndicator(false);
        showSmartIntentTreeInitialState(sITreeDTO);
        sendTreeShownEvent(sITreeDTO);
    }

    /* access modifiers changed from: private */
    public void handleTreeUnAvailable() {
        resetInternalStates();
        showFakeTypingIndicator(false);
        notifyShowReplyBox();
    }

    private void notifyShowReplyBox() {
        this.callback.showReplyFooterFromSmartIntent();
    }

    private void resetInternalStates() {
        this.lastSavedState = null;
        this.isShowingFakeTAI = false;
        this.isInitialized = false;
        this.backStackController.clear();
    }

    private void restoreSmartIntentUIFromSavedState(@NonNull SmartIntentSavedState smartIntentSavedState) {
        HSLogger.m3237d(TAG, "Restoring smart intent UI state on rotation");
        if (!smartIntentSavedState.isShowingTAI || !this.smartIntentDM.isTreeFetchRequestInProgress(this.userDM)) {
            SITreeDTO smartIntentTree = this.smartIntentDM.getSmartIntentTree(this.userDM);
            this.cachedSmartIntentTree = smartIntentTree;
            if (smartIntentTree == null) {
                handleTreeUnAvailable();
                return;
            }
            showSmartIntentTreeInitialState(smartIntentTree);
            SmartIntentSavedState smartIntentSavedState2 = this.lastSavedState;
            Long l = smartIntentSavedState2.selectedRootIntentLocalId;
            if (l != null) {
                handleRootIntentSelectedInternal(l.longValue());
            } else if (smartIntentSavedState2.isBottomSheetInExpandedState) {
                onSmartIntentBottomSheetExpanded();
            }
            if (StringUtils.isNotEmpty(this.lastSavedState.userTypedQuery)) {
                if (!this.lastSavedState.isSearchUIVisible) {
                    this.skipSearchOnUserQueryChange = true;
                }
                this.replyFieldViewState.setReplyText(this.lastSavedState.userTypedQuery);
            }
            this.isInitialized = true;
            return;
        }
        showFakeTypingIndicator(true);
        this.isInitialized = true;
    }

    private void sendTreeShownEvent(SITreeDTO sITreeDTO) {
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_TREE_ID, sITreeDTO.serverId);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_TREE_VERSION, Integer.valueOf(sITreeDTO.version));
        hashMap.put(AnalyticsEventKey.SMART_INTENT_ENFORCE_INTENT_SELECTION, Boolean.valueOf(sITreeDTO.enforceIntentSelection));
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_TREE_SHOWN, (Map<String, Object>) hashMap);
    }

    private void showFakeTypingIndicator(boolean z) {
        this.isShowingFakeTAI = z;
        if (z) {
            this.callback.showFakeTypingIndicatorFromSmartIntent();
        } else {
            this.callback.hideFakeTypingIndicatorFromSmartIntent();
        }
    }

    private void showSmartIntentTreeInitialState(SITreeDTO sITreeDTO) {
        SmartIntentCollapsedRootViewState buildSmartIntentCollapsedRootViewState = buildSmartIntentCollapsedRootViewState(sITreeDTO);
        this.backStackController.clear();
        if (this.backStackController.addItem(buildSmartIntentCollapsedRootViewState)) {
            this.callback.showSmartIntentUI(buildSmartIntentCollapsedRootViewState);
        }
        this.replyButtonViewState.setVisible(!sITreeDTO.enforceIntentSelection);
        this.replyButtonViewState.setEnabled(false);
    }

    private void updateConversationReplyFooter(boolean z) {
        if (z) {
            this.callback.showReplyFooterFromSmartIntent();
        } else {
            this.callback.hideReplyFooterFromSmartIntent();
        }
    }

    private void updateUIOnSearchResultChange(SISearchResultDTO sISearchResultDTO, String str) {
        SmartIntentSearchResultViewState smartIntentSearchResultViewState;
        BaseSmartIntentViewState topItem;
        SISearchResultDTO sISearchResultDTO2;
        Class cls = SmartIntentSearchResultViewState.class;
        if (!sISearchResultDTO.isSearchPerformed) {
            if (!StringUtils.isEmpty(str) && (sISearchResultDTO2 = this.lastSearchResultData) != null && sISearchResultDTO2.isSearchPerformed) {
                Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
                searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, Boolean.TRUE);
                this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
            }
            if (!(this.backStackController.popTopItem(cls) == null || (topItem = this.backStackController.getTopItem()) == null)) {
                this.callback.updateSmartIntentView(topItem);
            }
        } else {
            if (ListUtils.isEmpty(sISearchResultDTO.searchResults)) {
                SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
                smartIntentSearchResultViewState = new SmartIntentSearchResultViewState(sITreeDTO.emptySearchTitle, sITreeDTO.emptySearchDescription, sITreeDTO.enforceIntentSelection, Collections.emptyList());
            } else {
                List<SearchIntentUIModel> convertToSearchIntentUIModelList = convertToSearchIntentUIModelList(sISearchResultDTO.searchResults);
                SITreeDTO sITreeDTO2 = this.cachedSmartIntentTree;
                smartIntentSearchResultViewState = new SmartIntentSearchResultViewState(sITreeDTO2.searchTitle, "", sITreeDTO2.enforceIntentSelection, convertToSearchIntentUIModelList);
            }
            this.backStackController.popTopItem(cls);
            if (this.backStackController.addItem(smartIntentSearchResultViewState)) {
                this.callback.updateSmartIntentView(smartIntentSearchResultViewState);
            }
        }
        this.lastSearchResultData = sISearchResultDTO;
    }

    public SmartIntentSavedState buildInstanceSaveState() {
        if (this.isShowingFakeTAI) {
            return new SmartIntentSavedState(false, (Long) null, (String) null, false, true);
        }
        Long l = null;
        if (!this.isInitialized || this.backStackController.isEmpty()) {
            return null;
        }
        String replyText = this.replyFieldViewState.getReplyText();
        boolean z = !this.backStackController.isTopItemOfType(SmartIntentCollapsedRootViewState.class);
        BaseSmartIntentViewState lastItemOfType = this.backStackController.getLastItemOfType(SmartIntentLeafViewState.class);
        if (lastItemOfType instanceof SmartIntentLeafViewState) {
            l = Long.valueOf(((SmartIntentLeafViewState) lastItemOfType).parentIntentId);
        }
        return new SmartIntentSavedState(z, l, replyText, this.backStackController.isTopItemOfType(SmartIntentSearchResultViewState.class), false);
    }

    public BaseViewState getClearSearchButtonViewState() {
        return this.clearSearchViewState;
    }

    public BaseViewState getReplyButtonViewState() {
        return this.replyButtonViewState;
    }

    public ReplyFieldViewState getReplyFieldViewState() {
        return this.replyFieldViewState;
    }

    public boolean handleBackPressedForSmartIntent() {
        if (this.backStackController.isEmpty()) {
            return false;
        }
        HSLogger.m3237d(TAG, "On user pressed back button");
        if (this.backStackController.isTopItemOfType(SmartIntentCollapsedRootViewState.class)) {
            return false;
        }
        BaseSmartIntentViewState popTopItem = this.backStackController.popTopItem();
        if (popTopItem instanceof SmartIntentSearchResultViewState) {
            Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
            searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, Boolean.TRUE);
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
        } else if (popTopItem instanceof SmartIntentLeafViewState) {
            List list = null;
            SmartIntentDTO rootIntentDTO = getRootIntentDTO(((SmartIntentLeafViewState) popTopItem).parentIntentId);
            if (rootIntentDTO != null) {
                list = Collections.singletonList(rootIntentDTO.serverId);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("acid", this.activeConversation.acid);
            if (ListUtils.isNotEmpty(list)) {
                hashMap.put(AnalyticsEventKey.SMART_INTENT_IDS, this.platform.getJsonifier().jsonifyListToJsonArray(list));
            }
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_DESELECTION, (Map<String, Object>) hashMap);
        }
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem == null) {
            return false;
        }
        this.callback.updateSmartIntentView(topItem);
        return true;
    }

    public void handleLeafIntentSelected(LeafIntentUIModel leafIntentUIModel) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("On user selected a leaf intent : ");
        outline24.append(leafIntentUIModel.label);
        HSLogger.m3237d(TAG, outline24.toString());
        this.callback.hideSmartIntentView();
        resetInternalStates();
        createPreIssue(leafIntentUIModel.localId, (Integer) null, (Double) null);
    }

    public void handleRootIntentSelected(RootIntentUIModel rootIntentUIModel) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("On user selected a root intent : ");
        outline24.append(rootIntentUIModel.label);
        HSLogger.m3237d(TAG, outline24.toString());
        handleRootIntentSelectedInternal(rootIntentUIModel.localId);
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_IS_LEAF_INTENT, Boolean.FALSE);
        SmartIntentDTO rootIntentDTO = getRootIntentDTO(rootIntentUIModel.localId);
        if (rootIntentDTO != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_IDS, this.platform.getJsonifier().jsonifyListToJsonArray(Collections.singletonList(rootIntentDTO.serverId)));
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SELECTION, (Map<String, Object>) hashMap);
    }

    public void handleSearchIntentSelected(SearchIntentUIModel searchIntentUIModel) {
        this.callback.hideSmartIntentView();
        resetInternalStates();
        Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
        searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, Boolean.FALSE);
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
        createPreIssue(searchIntentUIModel.localId, Integer.valueOf(searchIntentUIModel.rank), searchIntentUIModel.confidence);
    }

    public boolean isSmartIntentUIVisible() {
        return this.isInitialized;
    }

    public void onDestroy() {
        this.smartIntentDM.unregisterSmartIntentDMCallback();
    }

    public void onNewConversationStarted(Conversation conversation) {
        this.activeConversation = conversation;
    }

    public void onRestoreInstanceState(SmartIntentSavedState smartIntentSavedState) {
        this.lastSavedState = smartIntentSavedState;
    }

    public void onSmartIntentBottomSheetCollapsed() {
        HSLogger.m3237d(TAG, "Smart intent bottom sheet state changed to collapsed mode");
        this.backStackController.popTopItem(SmartIntentExpandedRootViewState.class);
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem instanceof SmartIntentCollapsedRootViewState) {
            this.callback.updateSmartIntentView(topItem);
        }
    }

    public void onSmartIntentBottomSheetExpanded() {
        HSLogger.m3237d(TAG, "Smart intent bottom sheet state changed to Expanded mode");
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem instanceof SmartIntentCollapsedRootViewState) {
            SmartIntentExpandedRootViewState buildSmartIntentExpandedRootViewState = buildSmartIntentExpandedRootViewState((SmartIntentCollapsedRootViewState) topItem);
            if (this.backStackController.addItem(buildSmartIntentExpandedRootViewState)) {
                this.callback.updateSmartIntentView(buildSmartIntentExpandedRootViewState);
            }
        }
    }

    public void onSmartIntentSendButtonClick(String str) {
        if (StringUtils.userVisibleCharacterCount(str) < this.domain.getSDKConfigurationDM().getMinimumConversationDescriptionLength()) {
            this.callback.showSmartIntentReplyValidationFailedError();
            return;
        }
        this.callback.hideSmartIntentView();
        resetInternalStates();
        this.callback.createPreIssueFromSmartIntentSendButton(this.cachedSmartIntentTree.serverId, str);
        SISearchResultDTO sISearchResultDTO = this.lastSearchResultData;
        if (sISearchResultDTO != null && sISearchResultDTO.isSearchPerformed) {
            Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
            searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, Boolean.FALSE);
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
        }
    }

    public void onSmartIntentTextChanged(CharSequence charSequence) {
        String str;
        HSLogger.m3237d(TAG, "On user query change");
        if (charSequence == null) {
            str = "";
        } else {
            str = charSequence.toString();
        }
        this.replyFieldViewState.setReplyText(str);
        boolean z = true;
        this.replyButtonViewState.setEnabled(!StringUtils.isEmpty(str));
        MutableBaseViewState mutableBaseViewState = this.clearSearchViewState;
        if (!this.cachedSmartIntentTree.enforceIntentSelection || StringUtils.isEmpty(str)) {
            z = false;
        }
        mutableBaseViewState.setVisible(z);
        if (this.skipSearchOnUserQueryChange) {
            this.skipSearchOnUserQueryChange = false;
            return;
        }
        SISearchResultDTO match = this.smartIntentDM.match(this.cachedSmartIntentTree, str);
        if (match != null) {
            updateUIOnSearchResultChange(match, str);
        }
    }

    public void onTreeAvailable(@NonNull UserDM userDM2, @NonNull final SITreeDTO sITreeDTO) {
        if (this.userDM.getLocalId().equals(userDM2.getLocalId())) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    SmartIntentVM.this.handleTreeAvailable(sITreeDTO);
                }
            });
        }
    }

    public void onTreeUnAvailable(@NonNull UserDM userDM2) {
        if (this.userDM.getLocalId().equals(userDM2.getLocalId())) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    SmartIntentVM.this.handleTreeUnAvailable();
                }
            });
        }
    }

    public boolean shouldShowSmartIntentFakeTypingIndicator() {
        return this.isShowingFakeTAI;
    }

    public void showSmartIntentUI() {
        HSLogger.m3237d(TAG, "Showing smart intent UI");
        updateConversationReplyFooter(false);
        if (!this.isInitialized) {
            SmartIntentSavedState smartIntentSavedState = this.lastSavedState;
            if (smartIntentSavedState != null) {
                restoreSmartIntentUIFromSavedState(smartIntentSavedState);
                this.lastSavedState = null;
                return;
            }
            if (this.smartIntentDM.isSmartIntentTreeAvailable(this.userDM)) {
                SITreeDTO smartIntentTree = this.smartIntentDM.getSmartIntentTree(this.userDM);
                this.cachedSmartIntentTree = smartIntentTree;
                this.intentIdToSearchIntentUIModelMapping = null;
                if (smartIntentTree != null) {
                    showSmartIntentTreeInitialState(smartIntentTree);
                    sendTreeShownEvent(this.cachedSmartIntentTree);
                    this.isInitialized = true;
                    this.smartIntentDM.refreshSmartIntentSearchModel(this.userDM, this.cachedSmartIntentTree);
                    return;
                }
            }
            showFakeTypingIndicator(true);
            this.smartIntentDM.fetchSmartIntentTreeFromServer(this.userDM);
            this.isInitialized = true;
        }
    }
}
