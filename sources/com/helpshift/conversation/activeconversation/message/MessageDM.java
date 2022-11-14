package com.helpshift.conversation.activeconversation.message;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.IdempotentPolicy;
import com.helpshift.common.domain.idempotent.SuccessOrNonRetriableStatusCodeIdempotentPolicy;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.GuardAgainstConversationArchivalNetwork;
import com.helpshift.common.domain.network.GuardAgainstConversationReOpenExpiryNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.domain.network.UserPreConditionsFailedNetwork;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.util.FileUtil;
import com.helpshift.util.HSCloneable;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import com.swrve.sdk.rest.RESTClient;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;

public abstract class MessageDM extends Observable implements HSCloneable {
    public static final int DELIVERY_STATE_READ = 1;
    public static final int DELIVERY_STATE_SENT = 2;
    public static final int DELIVERY_STATE_UNREAD = 0;
    public static final String TAG = "Helpshift_MessageDM";
    public Author author;
    public AvatarImageDownloadState avatarImageState;
    public String body;
    public Long conversationLocalId;
    public String createdAt;
    public String createdRequestId;
    public int deliveryState;
    public Domain domain;
    public long epochCreatedAtTime;
    public final boolean isAdminMessage;
    public boolean isFeedbackMessage;
    public boolean isMessageSeenSynced;
    public boolean isRedacted;
    public Long localId;
    public final MessageType messageType;
    public Platform platform;
    public String readAt;
    public String seenAtMessageCursor;
    public String serverId;
    public final UIViewState uiViewState;

    /* renamed from: com.helpshift.conversation.activeconversation.message.MessageDM$1 */
    public static /* synthetic */ class C25461 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$Author$AuthorRole */
        public static final /* synthetic */ int[] f3336x96bc889d;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole[] r0 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3336x96bc889d = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r2 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.AGENT     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3336x96bc889d     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r3 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.BOT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3336x96bc889d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r3 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.SYSTEM     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3336x96bc889d     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r2 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.LOCAL_USER     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.activeconversation.message.MessageDM.C25461.<clinit>():void");
        }
    }

    public enum AvatarImageDownloadState {
        AVATAR_IMAGE_DOWNLOAD_FAILED,
        AVATAR_IMAGE_NOT_PRESENT,
        AVATAR_IMAGE_DOWNLOADING,
        AVATAR_IMAGE_DOWNLOADED
    }

    public MessageDM(String str, String str2, long j, Author author2, boolean z, MessageType messageType2) {
        this.body = str;
        this.createdAt = str2;
        this.epochCreatedAtTime = j;
        this.author = author2;
        this.isAdminMessage = z;
        this.messageType = messageType2;
        this.uiViewState = new UIViewState();
        updateAvatarImageState();
    }

    private void updateAvatarImageState() {
        if (StringUtils.isEmpty(this.author.localAvatarImagePath)) {
            this.avatarImageState = AvatarImageDownloadState.AVATAR_IMAGE_NOT_PRESENT;
        } else if (FileUtil.doesFilePathExistAndCanRead(this.author.localAvatarImagePath)) {
            this.avatarImageState = AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADED;
        } else {
            this.avatarImageState = AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOAD_FAILED;
        }
    }

    public abstract MessageDM deepClone();

    public String getAccessbilityMessageTime() {
        Locale currentLocale = this.domain.getLocaleProviderDM().getCurrentLocale();
        Date date = new Date(getEpochCreatedAtTime());
        return GeneratedOutlineSupport.outline17(HSDateFormatSpec.getDateFormatter(this.platform.getDevice().is24HourFormat() ? HSDateFormatSpec.DISPLAY_TIME_PATTERN_24HR : HSDateFormatSpec.DISPLAY_TIME_PATTERN_12HR, currentLocale).format(date), " ", HSDateFormatSpec.getDateFormatter(HSDateFormatSpec.DISPLAY_DATE_PATTERN, currentLocale).format(date));
    }

    public String getAuthorAvatarFallbackImage() {
        int ordinal = this.author.role.ordinal();
        if (ordinal == 0) {
            return this.domain.getSDKConfigurationDM().getAgentFallbackImageLocalPath();
        }
        if (ordinal == 1) {
            return this.domain.getSDKConfigurationDM().getBotFallbackImageLocalPath();
        }
        if (ordinal != 2) {
            return ordinal != 3 ? this.domain.getSDKConfigurationDM().getConversationHeaderImageLocalPath() : "";
        }
        return this.domain.getSDKConfigurationDM().getConversationHeaderImageLocalPath();
    }

    public AvatarImageDownloadState getAvatarImageState() {
        return this.avatarImageState;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDisplayedAuthorName() {
        if (!this.isAdminMessage || !this.domain.getSDKConfigurationDM().isPersonalisedConversationEnabled()) {
            return null;
        }
        String systemMessageNickname = getSystemMessageNickname();
        if (!StringUtils.isEmpty(this.author.authorName)) {
            systemMessageNickname = this.author.authorName.trim();
        } else if (StringUtils.isEmpty(systemMessageNickname)) {
            return null;
        }
        return systemMessageNickname;
    }

    public long getEpochCreatedAtTime() {
        return this.epochCreatedAtTime;
    }

    public IdempotentPolicy getIdempotentPolicy() {
        return new SuccessOrNonRetriableStatusCodeIdempotentPolicy();
    }

    public String getIssueSendMessageRoute(ConversationServerInfo conversationServerInfo) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(ConversationController.CREATE_ISSUE_ROUTE);
        outline24.append(conversationServerInfo.getIssueId());
        outline24.append("/messages/");
        return outline24.toString();
    }

    public String getPreIssueSendMessageRoute(ConversationServerInfo conversationServerInfo) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(ConversationController.CREATE_PRE_ISSUE_ROUTE);
        outline24.append(conversationServerInfo.getPreIssueId());
        outline24.append("/messages/");
        return outline24.toString();
    }

    public Network getSendMessageNetwork(String str) {
        return new GuardOKNetwork(new GuardAgainstConversationArchivalNetwork(new GuardAgainstConversationReOpenExpiryNetwork(new AuthenticationFailureNetwork(new UserPreConditionsFailedNetwork(new TSCorrectedNetwork(new IdempotentNetwork(new POSTNetwork(str, this.domain, this.platform), this.platform, getIdempotentPolicy(), str, String.valueOf(this.localId)), this.platform))), this.platform)));
    }

    public String getSubText() {
        Date date;
        Locale currentLocale = this.domain.getLocaleProviderDM().getCurrentLocale();
        try {
            date = HSDateFormatSpec.getDateFormatter(HSDateFormatSpec.STORAGE_TIME_PATTERN, currentLocale, "GMT").parse(getCreatedAt());
        } catch (ParseException e) {
            Date date2 = new Date();
            HSLogger.m3238d(TAG, "getSubText : ParseException", (Throwable) e);
            date = date2;
        }
        String format = HSDateFormatSpec.getDateFormatter(this.platform.getDevice().is24HourFormat() ? HSDateFormatSpec.DISPLAY_TIME_PATTERN_24HR : HSDateFormatSpec.DISPLAY_TIME_PATTERN_12HR, currentLocale).format(date);
        String displayedAuthorName = getDisplayedAuthorName();
        return !StringUtils.isEmpty(displayedAuthorName) ? GeneratedOutlineSupport.outline17(displayedAuthorName, RESTClient.COMMA_SEPARATOR, format) : format;
    }

    public String getSystemMessageNickname() {
        return this.domain.getSDKConfigurationDM().getSystemMessageNickname();
    }

    public UIViewState getUiViewState() {
        return this.uiViewState;
    }

    public abstract boolean isUISupportedMessage();

    public void merge(MessageDM messageDM) {
        this.body = messageDM.body;
        this.createdAt = messageDM.getCreatedAt();
        this.epochCreatedAtTime = messageDM.getEpochCreatedAtTime();
        if (this.isAdminMessage) {
            String str = this.author.localAvatarImagePath;
            Author author2 = messageDM.author;
            this.author = author2;
            author2.localAvatarImagePath = str;
        } else {
            this.author = messageDM.author;
        }
        if (StringUtils.isEmpty(this.serverId)) {
            this.serverId = messageDM.serverId;
        }
        if (!StringUtils.isEmpty(messageDM.createdRequestId)) {
            this.createdRequestId = messageDM.createdRequestId;
        }
        this.isRedacted = messageDM.isRedacted;
        this.isFeedbackMessage = messageDM.isFeedbackMessage;
    }

    public void mergeAndNotify(MessageDM messageDM) {
        merge(messageDM);
        notifyUpdated();
    }

    public void notifyUpdated() {
        setChanged();
        notifyObservers();
    }

    public void setAvatarImageState(AvatarImageDownloadState avatarImageDownloadState) {
        this.avatarImageState = avatarImageDownloadState;
        notifyUpdated();
    }

    public void setCreatedAt(String str) {
        if (!StringUtils.isEmpty(str)) {
            this.createdAt = str;
        }
    }

    public void setDependencies(Domain domain2, Platform platform2) {
        this.domain = domain2;
        this.platform = platform2;
    }

    public void setEpochCreatedAtTime(long j) {
        this.epochCreatedAtTime = j;
    }

    public boolean shouldShowAvatar() {
        return this.domain.getSDKConfigurationDM().isAvatarEnabledInChatFeed();
    }

    public boolean shouldShowPersonalisedAgentAvatar() {
        return this.domain.getSDKConfigurationDM().isPersonalisedAgentEnabled();
    }

    public boolean shouldShowPersonalisedBotAvatar() {
        return this.domain.getSDKConfigurationDM().isPersonalisedBotEnabled();
    }

    public MessageDM(MessageDM messageDM) {
        this.isAdminMessage = messageDM.isAdminMessage;
        this.messageType = messageDM.messageType;
        this.uiViewState = messageDM.uiViewState.deepClone();
        this.serverId = messageDM.serverId;
        this.body = messageDM.body;
        this.author = messageDM.author;
        this.conversationLocalId = messageDM.conversationLocalId;
        this.localId = messageDM.localId;
        this.readAt = messageDM.readAt;
        this.seenAtMessageCursor = messageDM.seenAtMessageCursor;
        this.deliveryState = messageDM.deliveryState;
        this.isMessageSeenSynced = messageDM.isMessageSeenSynced;
        this.createdRequestId = messageDM.createdRequestId;
        this.isRedacted = messageDM.isRedacted;
        this.domain = messageDM.domain;
        this.platform = messageDM.platform;
        this.createdAt = messageDM.createdAt;
        this.epochCreatedAtTime = messageDM.epochCreatedAtTime;
        this.avatarImageState = messageDM.avatarImageState;
        this.author = messageDM.author.deepClone();
        this.isFeedbackMessage = messageDM.isFeedbackMessage;
    }
}
