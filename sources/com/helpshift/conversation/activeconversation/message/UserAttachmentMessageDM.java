package com.helpshift.conversation.activeconversation.message;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.GuardAgainstConversationArchivalNetwork;
import com.helpshift.common.domain.network.GuardAgainstConversationReOpenExpiryNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.domain.network.UploadNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.conversation.viewmodel.ConversationVMCallback;
import com.helpshift.delegate.DelegateConstants;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import com.helpshift.util.Callback;
import com.helpshift.util.FileUtil;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class UserAttachmentMessageDM extends AttachmentMessageDM {
    public int progressPercentage = 0;
    public UserGenericAttachmentState state;

    public enum UserGenericAttachmentState {
        DOWNLOAD_NOT_STARTED,
        DOWNLOADING,
        UNSENT_RETRYABLE,
        UNSENT_NOT_RETRYABLE,
        SENDING,
        SENT
    }

    public UserAttachmentMessageDM(String str, String str2, long j, Author author, int i, String str3, String str4, String str5, boolean z) {
        super(str, str2, j, author, i, str3, str4, str5, false, z, MessageType.USER_ATTACHMENT);
    }

    private String getProgressSize() {
        int i = this.progressPercentage;
        if (i > 0) {
            int i2 = this.size;
            double d = (double) (i * i2);
            Double.isNaN(d);
            double d2 = d / 100.0d;
            if (d2 < ((double) i2)) {
                return getFormattedFileSize(d2);
            }
        }
        return null;
    }

    public String getFilePath() {
        if (!FileUtil.doesFilePathExistAndCanRead(this.filePath)) {
            this.filePath = null;
        }
        return this.filePath;
    }

    public String getProgressAndFileSize() {
        String progressSize = getProgressSize();
        if (StringUtils.isEmpty(progressSize)) {
            return getFormattedFileSize();
        }
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(progressSize, "/");
        outline26.append(getFormattedFileSize());
        return outline26.toString();
    }

    public void handleClick(ConversationVMCallback conversationVMCallback) {
        if (this.state == UserGenericAttachmentState.SENT && conversationVMCallback != null) {
            conversationVMCallback.launchAttachment(getFilePath(), this.contentType);
        } else if (this.state == UserGenericAttachmentState.DOWNLOAD_NOT_STARTED) {
            this.progressPercentage = 0;
            setState(UserGenericAttachmentState.DOWNLOADING);
            this.platform.getDownloader().startDownload(new AdminFileInfo(this.attachmentUrl, this.fileName, this.contentType, this.isSecureAttachment), SupportDownloader.StorageDirType.INTERNAL_ONLY, new AuthDataProvider(this.domain, this.platform, this.attachmentUrl), new SupportDownloadStateChangeListener() {
                public void onFailure(String str, int i) {
                    UserAttachmentMessageDM.this.setState(UserGenericAttachmentState.DOWNLOAD_NOT_STARTED);
                }

                public void onProgressChange(String str, int i) {
                    UserAttachmentMessageDM userAttachmentMessageDM = UserAttachmentMessageDM.this;
                    userAttachmentMessageDM.progressPercentage = i;
                    userAttachmentMessageDM.notifyUpdated();
                }

                public void onSuccess(String str, String str2, String str3) {
                    UserAttachmentMessageDM userAttachmentMessageDM = UserAttachmentMessageDM.this;
                    userAttachmentMessageDM.filePath = str2;
                    userAttachmentMessageDM.platform.getConversationDAO().insertOrUpdateMessage(UserAttachmentMessageDM.this);
                    UserAttachmentMessageDM.this.setState(UserGenericAttachmentState.SENT);
                }
            });
        }
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public void setState(UserGenericAttachmentState userGenericAttachmentState) {
        this.state = userGenericAttachmentState;
        notifyUpdated();
    }

    public void updateState(boolean z) {
        if (this.serverId == null) {
            if (this.state != UserGenericAttachmentState.SENDING) {
                if (!z || this.isRejected) {
                    setState(UserGenericAttachmentState.UNSENT_NOT_RETRYABLE);
                } else {
                    setState(UserGenericAttachmentState.UNSENT_RETRYABLE);
                }
            }
        } else if (getFilePath() != null) {
            setState(UserGenericAttachmentState.SENT);
        } else {
            setState(UserGenericAttachmentState.DOWNLOAD_NOT_STARTED);
        }
    }

    public void uploadAttachment(final UserDM userDM, final ConversationServerInfo conversationServerInfo, final Callback<Void, RootAPIException> callback) {
        if (StringUtils.isEmpty(conversationServerInfo.getIssueId())) {
            throw new UnsupportedOperationException("UserAttachmentMessageDM send called with conversation in pre issue mode.");
        } else if (getFilePath() != null) {
            setState(UserGenericAttachmentState.SENDING);
            this.domain.getAttachmentUploadThreader().thread(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UserAttachmentMessageDM.this.uploadAttachmentInternal(userDM, conversationServerInfo, callback);
                }
            }).mo33949f();
        }
    }

    public void uploadAttachmentInternal(UserDM userDM, ConversationServerInfo conversationServerInfo, Callback<Void, RootAPIException> callback) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put("body", "Attachment sent");
        userRequestData.put("type", "at");
        userRequestData.put("filePath", getFilePath());
        userRequestData.put("originalFileName", this.fileName);
        try {
            String issueSendMessageRoute = getIssueSendMessageRoute(conversationServerInfo);
            GuardAgainstConversationArchivalNetwork guardAgainstConversationArchivalNetwork = new GuardAgainstConversationArchivalNetwork(new GuardAgainstConversationReOpenExpiryNetwork(new AuthenticationFailureNetwork(new IdempotentNetwork(new UploadNetwork(issueSendMessageRoute, this.domain, this.platform), this.platform, getIdempotentPolicy(), issueSendMessageRoute, String.valueOf(this.localId))), this.platform));
            UserAttachmentMessageDM parseUserAttachmentMessageDM = this.platform.getResponseParser().parseUserAttachmentMessageDM(new GuardOKNetwork(guardAgainstConversationArchivalNetwork).makeRequest(new RequestData((Map<String, String>) userRequestData)).responseString);
            this.serverId = parseUserAttachmentMessageDM.serverId;
            this.author = parseUserAttachmentMessageDM.author;
            merge(parseUserAttachmentMessageDM);
            setState(UserGenericAttachmentState.SENT);
            this.platform.getConversationDAO().insertOrUpdateMessage(this);
            notifyUpdated();
            HashMap hashMap = new HashMap();
            hashMap.put("id", conversationServerInfo.getIssueId());
            if (StringUtils.isNotEmpty(conversationServerInfo.getAnalyticConversationId())) {
                hashMap.put("acid", conversationServerInfo.getAnalyticConversationId());
            }
            hashMap.put("type", "url");
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.MESSAGE_ADDED, (Map<String, Object>) hashMap);
            this.domain.getDelegate().userRepliedToConversation(DelegateConstants.USER_SENT_A_ATTACHMENT);
            if (callback != null) {
                callback.onSuccess(null);
            }
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.UNHANDLED_STATUS_CODE && e.getServerStatusCode() == NetworkErrorCodes.UNSUPPORTED_MEDIA_TYPE.intValue()) {
                this.isRejected = true;
                setState(UserGenericAttachmentState.UNSENT_NOT_RETRYABLE);
                this.platform.getConversationDAO().insertOrUpdateMessage(this);
                notifyUpdated();
                return;
            }
            ExceptionType exceptionType = e.exceptionType;
            if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
            }
            if (e.exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                setState(UserGenericAttachmentState.UNSENT_NOT_RETRYABLE);
            } else if (StringUtils.isEmpty(this.serverId)) {
                setState(UserGenericAttachmentState.UNSENT_RETRYABLE);
            }
            if (callback != null) {
                callback.onFailure(e);
            }
            throw RootAPIException.wrap(e);
        }
    }

    public MessageDM deepClone() {
        return new UserAttachmentMessageDM(this);
    }

    public UserAttachmentMessageDM(UserAttachmentMessageDM userAttachmentMessageDM) {
        super(userAttachmentMessageDM);
        this.state = userAttachmentMessageDM.state;
        this.progressPercentage = userAttachmentMessageDM.progressPercentage;
    }
}
