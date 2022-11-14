package com.helpshift.conversation.viewmodel;

import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.UIConversation;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemDateMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemDividerMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemPublishIdMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageState;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.util.ErrorReportProvider;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageListVM {
    public final Domain domain;
    public MessageListVMCallback messageListVMCallback;
    public final Platform platform;
    public long timeZoneOffSet;
    public Map<Long, UIConversation> uiConversationLocalIdMap = new ConcurrentHashMap();
    public List<MessageDM> uiMessageDMs;

    public MessageListVM(Platform platform2, Domain domain2) {
        this.platform = platform2;
        this.domain = domain2;
        this.timeZoneOffSet = platform2.getDevice().getTimeZoneOffSet();
    }

    /* access modifiers changed from: private */
    public void appendUIMessages(List<MessageDM> list) {
        int intValue;
        int size = this.uiMessageDMs.size();
        int i = size - 1;
        List<MessageDM> insertSystemMessageDMs = insertSystemMessageDMs(list, getItemAtPosition(i), true);
        this.uiMessageDMs.addAll(insertSystemMessageDMs);
        List<MessageDM> list2 = this.uiMessageDMs;
        ValuePair<Integer, Integer> checkAndUpdateGroupByTime = checkAndUpdateGroupByTime(list2, i, list2.size() - 1);
        MessageListVMCallback messageListVMCallback2 = this.messageListVMCallback;
        if (messageListVMCallback2 != null) {
            messageListVMCallback2.appendMessages(size, insertSystemMessageDMs.size());
            if (checkAndUpdateGroupByTime != null && (intValue = ((Integer) checkAndUpdateGroupByTime.first).intValue()) < size) {
                this.messageListVMCallback.updateMessages(intValue, size - intValue);
            }
        }
    }

    private SystemDividerMessageDM buildSystemDividerMessages(MessageDM messageDM, MessageDM messageDM2) {
        if (messageDM == null || messageDM2 == null || !isDifferentConversationMessages(messageDM, messageDM2)) {
            return null;
        }
        UIConversation uIConversation = getUIConversation(messageDM.conversationLocalId.longValue());
        boolean z = true;
        if ((uIConversation != null && uIConversation.isRedacted) || getIssueStateForMessage(messageDM) != IssueState.REJECTED) {
            z = false;
        }
        SystemDividerMessageDM generateConversationDividerMessage = generateConversationDividerMessage(getDateFromMessageDM(messageDM2), z);
        generateConversationDividerMessage.conversationLocalId = messageDM2.conversationLocalId;
        return generateConversationDividerMessage;
    }

    /* access modifiers changed from: private */
    public List<SystemMessageDM> buildSystemMessages(MessageDM messageDM, MessageDM messageDM2, boolean z, boolean z2) {
        if (messageDM2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        SystemDividerMessageDM buildSystemDividerMessages = buildSystemDividerMessages(messageDM, messageDM2);
        if (buildSystemDividerMessages != null) {
            arrayList.add(buildSystemDividerMessages);
        }
        boolean isDifferentConversationMessages = isDifferentConversationMessages(messageDM, messageDM2);
        Date dateFromMessageDM = getDateFromMessageDM(messageDM2);
        UIConversation uIConversation = getUIConversation(messageDM2.conversationLocalId.longValue());
        boolean z3 = true;
        if (!(uIConversation != null && uIConversation.isRedacted)) {
            if (isDifferentConversationMessages || z) {
                if (uIConversation != null) {
                    if (!z2 || uIConversation.isInPreIssueMode || StringUtils.isEmpty(uIConversation.publishId)) {
                        z3 = false;
                    }
                    if (z3) {
                        SystemPublishIdMessageDM generateSystemPublishIdMessageDM = generateSystemPublishIdMessageDM(uIConversation.publishId, dateFromMessageDM, z, messageDM2.conversationLocalId);
                        generateSystemPublishIdMessageDM.conversationLocalId = messageDM2.conversationLocalId;
                        arrayList.add(generateSystemPublishIdMessageDM);
                        z = false;
                    }
                }
                SystemDateMessageDM generateSystemDateMessageDM = generateSystemDateMessageDM(dateFromMessageDM, z, messageDM2.conversationLocalId);
                generateSystemDateMessageDM.conversationLocalId = messageDM2.conversationLocalId;
                arrayList.add(generateSystemDateMessageDM);
            } else if (isMessagesDayDifferent(messageDM, messageDM2) && !isSystemDateMessage(messageDM2)) {
                SystemDateMessageDM generateSystemDateMessageDM2 = generateSystemDateMessageDM(dateFromMessageDM, z, messageDM2.conversationLocalId);
                generateSystemDateMessageDM2.conversationLocalId = messageDM2.conversationLocalId;
                arrayList.add(generateSystemDateMessageDM2);
            }
        }
        return arrayList;
    }

    private boolean canGroupMessagesByTime(MessageDM messageDM, MessageDM messageDM2) {
        if (messageDM == null || messageDM2 == null || StringUtils.isEmpty(messageDM2.body)) {
            return false;
        }
        if (((!isUserMessage(messageDM) || !isUserMessage(messageDM2)) && (!isAdminMessage(messageDM) || !isAdminMessage(messageDM2))) || isMinuteDifferent(messageDM.getEpochCreatedAtTime(), messageDM2.getEpochCreatedAtTime())) {
            return false;
        }
        if (!isUserMessage(messageDM)) {
            String displayedAuthorName = messageDM.getDisplayedAuthorName();
            String displayedAuthorName2 = messageDM2.getDisplayedAuthorName();
            String str = messageDM.author.authorId;
            String str2 = messageDM2.author.authorId;
            if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(str2)) {
                return str.equals(str2);
            }
            if (displayedAuthorName != null) {
                return displayedAuthorName.equals(displayedAuthorName2);
            }
            if (displayedAuthorName2 == null) {
                return true;
            }
            return false;
        } else if (!isUserMessageSent(messageDM) || !isUserMessageSent(messageDM2)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean containsAdminMessages(List<MessageDM> list) {
        for (MessageDM isAdminMessage : list) {
            if (isAdminMessage(isAdminMessage)) {
                return true;
            }
        }
        return false;
    }

    private synchronized List<MessageDM> filterUIMessages(Collection<? extends MessageDM> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection == null) {
            return arrayList;
        }
        for (MessageDM messageDM : collection) {
            if (messageDM.isUISupportedMessage()) {
                arrayList.add(messageDM);
            }
        }
        return arrayList;
    }

    private int findBinaryIndex(long j, int i, int i2) {
        int i3 = ((i2 - i) / 2) + i;
        if (i == i3) {
            long epochCreatedAtTime = this.uiMessageDMs.get(i).getEpochCreatedAtTime();
            long epochCreatedAtTime2 = this.uiMessageDMs.get(i2).getEpochCreatedAtTime();
            if (j < epochCreatedAtTime) {
                return i;
            }
            return j >= epochCreatedAtTime2 ? i2 + 1 : i2;
        } else if (this.uiMessageDMs.get(i3).getEpochCreatedAtTime() <= j) {
            return findBinaryIndex(j, i3, i2);
        } else {
            return findBinaryIndex(j, i, i3);
        }
    }

    private int findBinaryIndexIntoUIList(MessageDM messageDM) {
        int findBinaryIndex;
        int size = this.uiMessageDMs.size();
        if (size != 0 && (findBinaryIndex = findBinaryIndex(messageDM.getEpochCreatedAtTime(), 0, size - 1)) >= 0) {
            return findBinaryIndex > size ? size : findBinaryIndex;
        }
        return 0;
    }

    private SystemDividerMessageDM generateConversationDividerMessage(Date date, boolean z) {
        String format = HSDateFormatSpec.STORAGE_TIME_FORMAT.format(new Date(date.getTime()));
        SystemDividerMessageDM systemDividerMessageDM = new SystemDividerMessageDM(format, getEpochTimeForSystemMessage(format), z);
        systemDividerMessageDM.setDependencies(this.domain, this.platform);
        return systemDividerMessageDM;
    }

    private SystemDateMessageDM generateSystemDateMessageDM(Date date, boolean z, Long l) {
        String format = HSDateFormatSpec.STORAGE_TIME_FORMAT.format(new Date(date.getTime()));
        SystemDateMessageDM systemDateMessageDM = new SystemDateMessageDM(format, getEpochTimeForSystemMessage(format), z);
        systemDateMessageDM.setDependencies(this.domain, this.platform);
        systemDateMessageDM.conversationLocalId = l;
        return systemDateMessageDM;
    }

    private SystemPublishIdMessageDM generateSystemPublishIdMessageDM(String str, Date date, boolean z, Long l) {
        String format = HSDateFormatSpec.STORAGE_TIME_FORMAT.format(new Date(date.getTime()));
        SystemPublishIdMessageDM systemPublishIdMessageDM = new SystemPublishIdMessageDM(str, format, getEpochTimeForSystemMessage(format), z);
        systemPublishIdMessageDM.setDependencies(this.domain, this.platform);
        systemPublishIdMessageDM.conversationLocalId = l;
        return systemPublishIdMessageDM;
    }

    private Date getDateFromMessageDM(MessageDM messageDM) {
        return new Date(messageDM.getEpochCreatedAtTime());
    }

    private long getEpochTimeForSystemMessage(String str) {
        return HSDateFormatSpec.convertToEpochTime(str) - 1;
    }

    private IssueState getIssueStateForMessage(MessageDM messageDM) {
        if (messageDM == null) {
            return IssueState.UNKNOWN;
        }
        UIConversation uIConversation = getUIConversation(messageDM.conversationLocalId.longValue());
        if (uIConversation == null) {
            return IssueState.UNKNOWN;
        }
        return uIConversation.issueState;
    }

    /* access modifiers changed from: private */
    public MessageDM getItemAtPosition(int i) {
        if (i < 0 || i >= this.uiMessageDMs.size()) {
            return null;
        }
        return this.uiMessageDMs.get(i);
    }

    private Comparator<MessageDM> getSortMessagesComparator() {
        return new Comparator<MessageDM>() {
            public int compare(MessageDM messageDM, MessageDM messageDM2) {
                UIConversation uIConversation = MessageListVM.this.getUIConversation(messageDM.conversationLocalId.longValue());
                UIConversation uIConversation2 = MessageListVM.this.getUIConversation(messageDM2.conversationLocalId.longValue());
                if (!(uIConversation == null || uIConversation2 == null)) {
                    Integer valueOf = Integer.valueOf(uIConversation.index);
                    Integer valueOf2 = Integer.valueOf(uIConversation2.index);
                    if (valueOf.intValue() < valueOf2.intValue()) {
                        return -1;
                    }
                    if (valueOf.intValue() > valueOf2.intValue()) {
                        return 1;
                    }
                    long epochCreatedAtTime = messageDM.getEpochCreatedAtTime();
                    long epochCreatedAtTime2 = messageDM2.getEpochCreatedAtTime();
                    if (epochCreatedAtTime > epochCreatedAtTime2) {
                        return 1;
                    }
                    if (epochCreatedAtTime < epochCreatedAtTime2) {
                        return -1;
                    }
                }
                return 0;
            }
        };
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> groupConversationRedactedMessages(java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0042 }
            r0.<init>()     // Catch:{ all -> 0x0042 }
            boolean r1 = com.helpshift.util.ListUtils.isEmpty(r8)     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r7)
            return r0
        L_0x000e:
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0042 }
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = 0
        L_0x0016:
            boolean r5 = r8.hasNext()     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0039
            java.lang.Object r5 = r8.next()     // Catch:{ all -> 0x0042 }
            com.helpshift.conversation.activeconversation.message.MessageDM r5 = (com.helpshift.conversation.activeconversation.message.MessageDM) r5     // Catch:{ all -> 0x0042 }
            boolean r6 = r5 instanceof com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x002c
            int r4 = r4 + 1
            com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM r5 = (com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM) r5     // Catch:{ all -> 0x0042 }
            r3 = r5
            goto L_0x0016
        L_0x002c:
            if (r3 == 0) goto L_0x0035
            r3.contiguousRedactedConversationsCount = r4     // Catch:{ all -> 0x0042 }
            r0.add(r3)     // Catch:{ all -> 0x0042 }
            r3 = r1
            r4 = 0
        L_0x0035:
            r0.add(r5)     // Catch:{ all -> 0x0042 }
            goto L_0x0016
        L_0x0039:
            if (r3 == 0) goto L_0x0040
            r3.contiguousRedactedConversationsCount = r4     // Catch:{ all -> 0x0042 }
            r0.add(r3)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r7)
            return r0
        L_0x0042:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0046
        L_0x0045:
            throw r8
        L_0x0046:
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.MessageListVM.groupConversationRedactedMessages(java.util.List):java.util.List");
    }

    private synchronized List<MessageDM> insertSystemMessageDMs(List<MessageDM> list, MessageDM messageDM, boolean z) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        boolean z2 = this.domain.getSDKConfigurationDM().getBoolean(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN);
        boolean z3 = !z && messageDM == null;
        for (MessageDM next : list) {
            arrayList.addAll(buildSystemMessages(messageDM, next, z3, z2));
            arrayList.add(next);
            messageDM = next;
            z3 = false;
        }
        return arrayList;
    }

    private void insertSystemMessageDMsForLatestEmptyConversation(List<UIConversation> list) {
        if (!ListUtils.isEmpty(this.uiMessageDMs)) {
            List<MessageDM> list2 = this.uiMessageDMs;
            boolean z = true;
            MessageDM messageDM = list2.get(list2.size() - 1);
            Long l = messageDM.conversationLocalId;
            UIConversation uIConversation = list.get(list.size() - 1);
            if (!Long.valueOf(uIConversation.localID).equals(l)) {
                UIConversation uIConversation2 = getUIConversation(messageDM.conversationLocalId.longValue());
                if ((uIConversation2 != null && uIConversation2.isRedacted) || getIssueStateForMessage(messageDM) != IssueState.REJECTED) {
                    z = false;
                }
                Date date = new Date(uIConversation.epochCreateTime);
                SystemDividerMessageDM generateConversationDividerMessage = generateConversationDividerMessage(date, z);
                SystemDateMessageDM generateSystemDateMessageDM = generateSystemDateMessageDM(date, false, Long.valueOf(uIConversation.localID));
                this.uiMessageDMs.add(generateConversationDividerMessage);
                this.uiMessageDMs.add(generateSystemDateMessageDM);
            }
        }
    }

    /* access modifiers changed from: private */
    public void insertUIMessages(List<MessageDM> list) {
        for (MessageDM insertUIMessage : list) {
            insertUIMessage(insertUIMessage);
        }
        notifyMessageListVMRefreshAll();
    }

    private boolean isAdminMessage(MessageDM messageDM) {
        return messageDM.isAdminMessage;
    }

    private boolean isDayDifferent(long j, long j2) {
        long j3 = this.timeZoneOffSet;
        return (j + j3) / ErrorReportProvider.BATCH_TIME != (j2 + j3) / ErrorReportProvider.BATCH_TIME;
    }

    private boolean isDifferentConversationMessages(MessageDM messageDM, MessageDM messageDM2) {
        if (messageDM == null || messageDM2 == null) {
            return false;
        }
        return !messageDM.conversationLocalId.equals(messageDM2.conversationLocalId);
    }

    private boolean isMessagesDayDifferent(MessageDM messageDM, MessageDM messageDM2) {
        if (messageDM == null || messageDM2 == null) {
            return false;
        }
        return isDayDifferent(messageDM.getEpochCreatedAtTime(), messageDM2.getEpochCreatedAtTime());
    }

    private boolean isMinuteDifferent(long j, long j2) {
        long j3 = this.timeZoneOffSet;
        return (j + j3) / ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT != (j2 + j3) / ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT;
    }

    private boolean isSystemDateMessage(MessageDM messageDM) {
        return messageDM instanceof SystemDateMessageDM;
    }

    /* access modifiers changed from: private */
    public boolean isSystemMessage(MessageDM messageDM) {
        return messageDM instanceof SystemMessageDM;
    }

    private boolean isUserMessage(MessageDM messageDM) {
        return !isAdminMessage(messageDM) && !isSystemMessage(messageDM);
    }

    private boolean isUserMessageSent(MessageDM messageDM) {
        if (messageDM == null) {
            return false;
        }
        MessageType messageType = messageDM.messageType;
        if (messageType == MessageType.USER_TEXT || messageType == MessageType.USER_RESP_FOR_TEXT_INPUT || messageType == MessageType.USER_RESP_FOR_OPTION_INPUT) {
            if (((UserMessageDM) messageDM).getState() == UserMessageState.SENT) {
                return true;
            }
            return false;
        } else if (messageType == MessageType.SCREENSHOT && ((ScreenshotMessageDM) messageDM).state == UserMessageState.SENT) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void notifyNewUIMessagesAdded(List<MessageDM> list) {
        boolean containsAdminMessages = containsAdminMessages(list);
        MessageListVMCallback messageListVMCallback2 = this.messageListVMCallback;
        if (messageListVMCallback2 == null) {
            return;
        }
        if (containsAdminMessages) {
            messageListVMCallback2.newAdminMessagesAdded();
        } else {
            messageListVMCallback2.newUserMessagesAdded();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateMessageGroupViewState(com.helpshift.conversation.activeconversation.message.MessageDM r4, boolean r5, boolean r6) {
        /*
            r3 = this;
            com.helpshift.conversation.activeconversation.message.UIViewState r0 = r4.getUiViewState()
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L_0x001a
            if (r6 == 0) goto L_0x0010
            com.helpshift.conversation.activeconversation.message.UIViewState r4 = new com.helpshift.conversation.activeconversation.message.UIViewState
            r4.<init>(r1, r2)
            goto L_0x002c
        L_0x0010:
            com.helpshift.conversation.activeconversation.message.UIViewState r5 = new com.helpshift.conversation.activeconversation.message.UIViewState
            boolean r4 = r3.isUserMessage(r4)
            r5.<init>(r1, r4)
            goto L_0x0025
        L_0x001a:
            if (r6 == 0) goto L_0x0027
            com.helpshift.conversation.activeconversation.message.UIViewState r5 = new com.helpshift.conversation.activeconversation.message.UIViewState
            boolean r4 = r3.isAdminMessage(r4)
            r5.<init>(r2, r4)
        L_0x0025:
            r4 = r5
            goto L_0x002c
        L_0x0027:
            com.helpshift.conversation.activeconversation.message.UIViewState r4 = new com.helpshift.conversation.activeconversation.message.UIViewState
            r4.<init>(r2, r1)
        L_0x002c:
            boolean r5 = r0.equals(r4)
            if (r5 == 0) goto L_0x0033
            return r2
        L_0x0033:
            r0.updateViewState(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.MessageListVM.updateMessageGroupViewState(com.helpshift.conversation.activeconversation.message.MessageDM, boolean, boolean):boolean");
    }

    public void addMessages(Collection<? extends MessageDM> collection) {
        final List<MessageDM> processAddedMessages = processAddedMessages(collection);
        if (processAddedMessages.size() > 0) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    MessageListVM messageListVM = MessageListVM.this;
                    MessageDM access$000 = messageListVM.getItemAtPosition(messageListVM.uiMessageDMs.size() - 1);
                    if (access$000 == null || access$000.getEpochCreatedAtTime() <= ((MessageDM) processAddedMessages.get(0)).getEpochCreatedAtTime()) {
                        MessageListVM.this.appendUIMessages(processAddedMessages);
                    } else {
                        MessageListVM.this.insertUIMessages(processAddedMessages);
                    }
                    MessageListVM.this.notifyNewUIMessagesAdded(processAddedMessages);
                    MessageListVM.this.notifyUIMessageListUpdated();
                }
            });
        }
    }

    public void checkAndPrependSystemMessagesBeforeFirstMessage() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (MessageListVM.this.uiMessageDMs.size() != 0) {
                    MessageDM messageDM = MessageListVM.this.uiMessageDMs.get(0);
                    if (!MessageListVM.this.isSystemMessage(messageDM)) {
                        List access$500 = MessageListVM.this.buildSystemMessages((MessageDM) null, messageDM, true, MessageListVM.this.domain.getSDKConfigurationDM().getBoolean(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN));
                        if (!ListUtils.isEmpty(access$500)) {
                            MessageListVM.this.uiMessageDMs.addAll(0, access$500);
                            MessageListVMCallback messageListVMCallback = MessageListVM.this.messageListVMCallback;
                            if (messageListVMCallback != null) {
                                messageListVMCallback.appendMessages(0, access$500.size());
                            }
                        }
                    }
                }
            }
        });
    }

    public boolean checkAndUpdateGroupByDate(int i) {
        boolean z;
        MessageDM itemAtPosition = getItemAtPosition(i);
        MessageDM itemAtPosition2 = getItemAtPosition(i + 1);
        boolean z2 = false;
        if (!isSystemDateMessage(itemAtPosition) || (itemAtPosition2 != null && !isSystemDateMessage(itemAtPosition2))) {
            z = false;
        } else {
            this.uiMessageDMs.remove(i);
            i--;
            z = true;
        }
        MessageDM itemAtPosition3 = getItemAtPosition(i);
        MessageDM itemAtPosition4 = getItemAtPosition(i - 1);
        if (itemAtPosition4 == null || itemAtPosition3 == null || isSystemDateMessage(itemAtPosition3)) {
            return z;
        }
        if (!isMessagesDayDifferent(itemAtPosition4, itemAtPosition3)) {
            return z;
        }
        Date date = new Date(itemAtPosition3.getEpochCreatedAtTime());
        if (itemAtPosition3.getEpochCreatedAtTime() == -1) {
            z2 = true;
        }
        this.uiMessageDMs.add(i, generateSystemDateMessageDM(date, z2, itemAtPosition3.conversationLocalId));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.util.ValuePair<java.lang.Integer, java.lang.Integer> checkAndUpdateGroupByTime(java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> r11, int r12, int r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r11.size()     // Catch:{ all -> 0x0085 }
            r1 = 0
            int r12 = java.lang.Math.max(r12, r1)     // Catch:{ all -> 0x0085 }
            r2 = 1
            int r0 = r0 - r2
            int r13 = java.lang.Math.min(r13, r0)     // Catch:{ all -> 0x0085 }
            r3 = 0
            if (r13 >= r12) goto L_0x0015
            monitor-exit(r10)
            return r3
        L_0x0015:
            r4 = -1
            if (r12 <= 0) goto L_0x0040
            int r5 = r12 + -1
            java.lang.Object r6 = r11.get(r5)     // Catch:{ all -> 0x0085 }
            com.helpshift.conversation.activeconversation.message.MessageDM r6 = (com.helpshift.conversation.activeconversation.message.MessageDM) r6     // Catch:{ all -> 0x0085 }
            boolean r7 = r10.isGroupFirstMessageAtIndex(r5)     // Catch:{ all -> 0x0085 }
            java.lang.Object r8 = r11.get(r12)     // Catch:{ all -> 0x0085 }
            com.helpshift.conversation.activeconversation.message.MessageDM r8 = (com.helpshift.conversation.activeconversation.message.MessageDM) r8     // Catch:{ all -> 0x0085 }
            boolean r8 = r10.canGroupMessagesByTime(r6, r8)     // Catch:{ all -> 0x0085 }
            if (r8 != 0) goto L_0x0032
            r9 = 1
            goto L_0x0033
        L_0x0032:
            r9 = 0
        L_0x0033:
            boolean r6 = r10.updateMessageGroupViewState(r6, r7, r9)     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x003b
            r6 = r5
            goto L_0x003d
        L_0x003b:
            r5 = -1
            r6 = -1
        L_0x003d:
            r7 = r8 ^ 1
            goto L_0x0043
        L_0x0040:
            r5 = -1
            r6 = -1
            r7 = 1
        L_0x0043:
            if (r12 > r13) goto L_0x0074
            java.lang.Object r8 = r11.get(r12)     // Catch:{ all -> 0x0085 }
            com.helpshift.conversation.activeconversation.message.MessageDM r8 = (com.helpshift.conversation.activeconversation.message.MessageDM) r8     // Catch:{ all -> 0x0085 }
            if (r12 != r0) goto L_0x0052
            boolean r8 = r10.updateMessageGroupViewState(r8, r7, r2)     // Catch:{ all -> 0x0085 }
            goto L_0x006b
        L_0x0052:
            int r9 = r12 + 1
            java.lang.Object r9 = r11.get(r9)     // Catch:{ all -> 0x0085 }
            com.helpshift.conversation.activeconversation.message.MessageDM r9 = (com.helpshift.conversation.activeconversation.message.MessageDM) r9     // Catch:{ all -> 0x0085 }
            boolean r9 = r10.canGroupMessagesByTime(r8, r9)     // Catch:{ all -> 0x0085 }
            if (r9 == 0) goto L_0x0066
            boolean r8 = r10.updateMessageGroupViewState(r8, r7, r1)     // Catch:{ all -> 0x0085 }
            r7 = 0
            goto L_0x006b
        L_0x0066:
            boolean r8 = r10.updateMessageGroupViewState(r8, r7, r2)     // Catch:{ all -> 0x0085 }
            r7 = 1
        L_0x006b:
            if (r8 == 0) goto L_0x0071
            if (r5 != r4) goto L_0x0070
            r5 = r12
        L_0x0070:
            r6 = r12
        L_0x0071:
            int r12 = r12 + 1
            goto L_0x0043
        L_0x0074:
            if (r5 == r4) goto L_0x0083
            com.helpshift.util.ValuePair r3 = new com.helpshift.util.ValuePair     // Catch:{ all -> 0x0085 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0085 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0085 }
            r3.<init>(r11, r12)     // Catch:{ all -> 0x0085 }
        L_0x0083:
            monitor-exit(r10)
            return r3
        L_0x0085:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0089
        L_0x0088:
            throw r11
        L_0x0089:
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.MessageListVM.checkAndUpdateGroupByTime(java.util.List, int, int):com.helpshift.util.ValuePair");
    }

    public List<MessageDM> copyOfUIMessageDMs() {
        if (this.uiMessageDMs != null) {
            return new ArrayList(this.uiMessageDMs);
        }
        return new ArrayList();
    }

    public MessageDM getLastUIMessage() {
        int size = this.uiMessageDMs.size();
        if (size > 0) {
            return this.uiMessageDMs.get(size - 1);
        }
        return null;
    }

    public synchronized UIConversation getUIConversation(long j) {
        return this.uiConversationLocalIdMap.get(Long.valueOf(j));
    }

    public List<MessageDM> getUiMessageDMs() {
        return this.uiMessageDMs;
    }

    public void initializeMessageList(List<UIConversation> list, List<MessageDM> list2, boolean z, MessageListVMCallback messageListVMCallback2) {
        updateUIConversationOrder(list);
        this.uiMessageDMs = insertSystemMessageDMs(groupConversationRedactedMessages(processAddedMessages(list2)), (MessageDM) null, z);
        insertSystemMessageDMsForLatestEmptyConversation(list);
        List<MessageDM> list3 = this.uiMessageDMs;
        checkAndUpdateGroupByTime(list3, 0, list3.size() - 1);
        this.messageListVMCallback = messageListVMCallback2;
    }

    public void insertOrUpdateMessage(final MessageDM messageDM) {
        if (messageDM != null && messageDM.isUISupportedMessage()) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    if (MessageListVM.this.uiMessageDMs.contains(messageDM)) {
                        MessageListVM.this.updateUIMessage(messageDM);
                    } else {
                        MessageListVM.this.insertUIMessage(messageDM);
                        MessageListVM.this.notifyNewUIMessagesAdded(new ArrayList(Collections.singletonList(messageDM)));
                        MessageListVM.this.notifyMessageListVMRefreshAll();
                    }
                    MessageListVM.this.notifyUIMessageListUpdated();
                }
            });
        }
    }

    public void insertUIMessage(MessageDM messageDM) {
        int findBinaryIndexIntoUIList = findBinaryIndexIntoUIList(messageDM);
        this.uiMessageDMs.add(findBinaryIndexIntoUIList, messageDM);
        checkAndUpdateGroupByDate(findBinaryIndexIntoUIList);
        checkAndUpdateGroupByTime(this.uiMessageDMs, findBinaryIndexIntoUIList - 1, findBinaryIndexIntoUIList + 1);
    }

    public boolean isGroupFirstMessageAtIndex(int i) {
        if (i < 0) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        return !canGroupMessagesByTime(this.uiMessageDMs.get(i - 1), this.uiMessageDMs.get(i));
    }

    public boolean isMessageAtCorrectPosition(int i) {
        MessageDM itemAtPosition = getItemAtPosition(i);
        if (itemAtPosition == null) {
            return true;
        }
        MessageDM itemAtPosition2 = getItemAtPosition(i - 1);
        if (itemAtPosition2 != null && itemAtPosition.getEpochCreatedAtTime() < itemAtPosition2.getEpochCreatedAtTime()) {
            return false;
        }
        MessageDM itemAtPosition3 = getItemAtPosition(i + 1);
        if (itemAtPosition3 == null || itemAtPosition.getEpochCreatedAtTime() <= itemAtPosition3.getEpochCreatedAtTime()) {
            return true;
        }
        return false;
    }

    public void notifyMessageListUpdate(ValuePair<Integer, Integer> valuePair) {
        if (valuePair != null) {
            int intValue = ((Integer) valuePair.first).intValue();
            int intValue2 = (((Integer) valuePair.second).intValue() - intValue) + 1;
            if (this.messageListVMCallback != null && intValue > 0 && intValue2 > 0 && ((Integer) valuePair.second).intValue() < this.uiMessageDMs.size()) {
                this.messageListVMCallback.updateMessages(intValue, intValue2);
            }
        }
    }

    public void notifyMessageListVMRefreshAll() {
        MessageListVMCallback messageListVMCallback2 = this.messageListVMCallback;
        if (messageListVMCallback2 != null) {
            messageListVMCallback2.refreshAll();
        }
    }

    public void notifyUIMessageListUpdated() {
        MessageListVMCallback messageListVMCallback2 = this.messageListVMCallback;
        if (messageListVMCallback2 != null) {
            messageListVMCallback2.onUIMessageListUpdated();
        }
    }

    public void prependMessages(List<MessageDM> list, boolean z) {
        if (!ListUtils.isEmpty(list)) {
            List<MessageDM> filterUIMessages = filterUIMessages(list);
            Collections.sort(filterUIMessages, getSortMessagesComparator());
            List<MessageDM> insertSystemMessageDMs = insertSystemMessageDMs(groupConversationRedactedMessages(filterUIMessages), (MessageDM) null, z);
            checkAndUpdateGroupByTime(insertSystemMessageDMs, 0, insertSystemMessageDMs.size() - 1);
            prependMessagesInternal(insertSystemMessageDMs);
        } else if (!z) {
            checkAndPrependSystemMessagesBeforeFirstMessage();
        }
    }

    public void prependMessagesInternal(final List<MessageDM> list) {
        if (!ListUtils.isEmpty(list)) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    List list = list;
                    list.addAll(MessageListVM.this.buildSystemMessages((MessageDM) list.get(list.size() - 1), !ListUtils.isEmpty(MessageListVM.this.uiMessageDMs) ? MessageListVM.this.uiMessageDMs.get(0) : null, false, MessageListVM.this.domain.getSDKConfigurationDM().getBoolean(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN)));
                    int size = list.size();
                    MessageListVM.this.uiMessageDMs.addAll(0, list);
                    MessageListVMCallback messageListVMCallback = MessageListVM.this.messageListVMCallback;
                    if (messageListVMCallback != null) {
                        messageListVMCallback.appendMessages(0, size);
                    }
                    int i = size - 1;
                    boolean checkAndUpdateGroupByDate = MessageListVM.this.checkAndUpdateGroupByDate(i);
                    MessageListVM messageListVM = MessageListVM.this;
                    ValuePair<Integer, Integer> checkAndUpdateGroupByTime = messageListVM.checkAndUpdateGroupByTime(messageListVM.uiMessageDMs, i, size + 1);
                    if (checkAndUpdateGroupByDate) {
                        MessageListVM.this.notifyMessageListVMRefreshAll();
                    } else if (checkAndUpdateGroupByTime != null) {
                        MessageListVM.this.notifyMessageListUpdate(checkAndUpdateGroupByTime);
                    }
                }
            });
        }
    }

    public List<MessageDM> processAddedMessages(Collection<? extends MessageDM> collection) {
        List<MessageDM> filterUIMessages = filterUIMessages(collection);
        Collections.sort(filterUIMessages, getSortMessagesComparator());
        return filterUIMessages;
    }

    public void remove(List<MessageDM> list) {
        final List<MessageDM> filterUIMessages = filterUIMessages(list);
        if (!ListUtils.isEmpty(filterUIMessages)) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    boolean z = false;
                    for (MessageDM indexOf : filterUIMessages) {
                        int indexOf2 = MessageListVM.this.uiMessageDMs.indexOf(indexOf);
                        if (indexOf2 != -1) {
                            MessageListVM.this.uiMessageDMs.remove(indexOf2);
                            int i = indexOf2 - 1;
                            MessageListVM.this.checkAndUpdateGroupByDate(i);
                            MessageListVM messageListVM = MessageListVM.this;
                            messageListVM.checkAndUpdateGroupByTime(messageListVM.uiMessageDMs, i, indexOf2 + 1);
                            z = true;
                        }
                    }
                    if (z) {
                        MessageListVM.this.notifyMessageListVMRefreshAll();
                        MessageListVM.this.notifyUIMessageListUpdated();
                    }
                }
            });
        }
    }

    public void unregisterMessageListVMCallback() {
        this.messageListVMCallback = null;
    }

    public synchronized void updateUIConversationOrder(List<UIConversation> list) {
        if (!ListUtils.isEmpty(list)) {
            this.uiConversationLocalIdMap.clear();
            for (UIConversation next : list) {
                this.uiConversationLocalIdMap.put(Long.valueOf(next.localID), next);
            }
        }
    }

    public void updateUIMessage(MessageDM messageDM) {
        int i;
        int indexOf = this.uiMessageDMs.indexOf(messageDM);
        if (indexOf != -1) {
            if (isMessageAtCorrectPosition(indexOf)) {
                boolean checkAndUpdateGroupByDate = checkAndUpdateGroupByDate(indexOf);
                ValuePair<Integer, Integer> checkAndUpdateGroupByTime = checkAndUpdateGroupByTime(this.uiMessageDMs, indexOf - 1, indexOf + 1);
                if (checkAndUpdateGroupByDate) {
                    notifyMessageListVMRefreshAll();
                    return;
                }
                if (checkAndUpdateGroupByTime != null) {
                    int min = Math.min(indexOf, ((Integer) checkAndUpdateGroupByTime.first).intValue());
                    int max = Math.max(indexOf, ((Integer) checkAndUpdateGroupByTime.second).intValue());
                    indexOf = min;
                    i = max;
                } else {
                    i = indexOf;
                }
                if (this.messageListVMCallback != null && indexOf <= i && i < this.uiMessageDMs.size()) {
                    this.messageListVMCallback.updateMessages(indexOf, (i - indexOf) + 1);
                    return;
                }
                return;
            }
            this.uiMessageDMs.remove(indexOf);
            int i2 = indexOf - 1;
            checkAndUpdateGroupByDate(i2);
            checkAndUpdateGroupByTime(this.uiMessageDMs, i2, indexOf + 1);
            insertUIMessage(messageDM);
            notifyMessageListVMRefreshAll();
        }
    }
}
