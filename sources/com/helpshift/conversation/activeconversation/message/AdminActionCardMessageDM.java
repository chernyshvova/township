package com.helpshift.conversation.activeconversation.message;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.conversation.activeconversation.model.Action;
import com.helpshift.conversation.activeconversation.model.ActionCard;
import com.helpshift.conversation.activeconversation.model.ActionType;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import com.helpshift.util.FileUtil;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class AdminActionCardMessageDM extends AdminMessageDM {
    public static final int MAX_RETRY_ATTEMPT = 3;
    public ActionCard actionCard;
    public final String originalMessageServerId;
    public int retryAttempts;
    public ActionCardImageState state;

    public enum ActionCardImageState {
        DOWNLOAD_NOT_STARTED,
        IMAGE_DOWNLOADING,
        IMAGE_DOWNLOADED,
        IMAGE_NOT_PRESENT
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdminActionCardMessageDM(String str, String str2, String str3, long j, Author author, String str4, ActionCard actionCard2) {
        super(str, str2, str3, j, author, MessageType.ADMIN_ACTION_CARD);
        this.actionCard = actionCard2;
        this.originalMessageServerId = str4;
        this.retryAttempts = 0;
        updateState();
    }

    private void downloadImageInternal(final Platform platform) {
        setState(ActionCardImageState.IMAGE_DOWNLOADING);
        ActionCard actionCard2 = this.actionCard;
        platform.getDownloader().startDownload(new AdminFileInfo(actionCard2.imageUrl, (String) null, (String) null, actionCard2.isSecure), SupportDownloader.StorageDirType.INTERNAL_ONLY, new AuthDataProvider(this.domain, platform, this.actionCard.imageUrl), new SupportDownloadStateChangeListener() {
            public void onFailure(String str, int i) {
                AdminActionCardMessageDM.this.setState(ActionCardImageState.DOWNLOAD_NOT_STARTED);
                if (!NetworkErrorCodes.NOT_RETRIABLE_STATUS_CODES.contains(Integer.valueOf(i))) {
                    AdminActionCardMessageDM.this.downloadImage(platform);
                }
            }

            public void onProgressChange(String str, int i) {
            }

            public void onSuccess(String str, String str2, String str3) {
                AdminActionCardMessageDM.this.setState(ActionCardImageState.IMAGE_DOWNLOADED);
                AdminActionCardMessageDM.this.actionCard.filePath = str2;
                platform.getConversationDAO().insertOrUpdateMessage(AdminActionCardMessageDM.this);
            }
        });
    }

    private void updateState() {
        if (StringUtils.isEmpty(this.actionCard.imageUrl)) {
            this.state = ActionCardImageState.IMAGE_NOT_PRESENT;
        } else if (FileUtil.doesFilePathExistAndCanRead(this.actionCard.filePath)) {
            this.state = ActionCardImageState.IMAGE_DOWNLOADED;
        } else {
            this.state = ActionCardImageState.DOWNLOAD_NOT_STARTED;
        }
    }

    public void downloadImage(Platform platform) {
        int i = this.retryAttempts;
        if (i != 3 && this.state == ActionCardImageState.DOWNLOAD_NOT_STARTED) {
            this.retryAttempts = i + 1;
            downloadImageInternal(platform);
        }
    }

    public String getUriAsStringForAction() {
        Action action = this.actionCard.action;
        ActionType actionType = action.actionType;
        if (actionType != ActionType.CALL) {
            return actionType == ActionType.LINK ? action.actionData.get("url") : "";
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("tel:");
        outline24.append(action.actionData.get("phone_number"));
        return outline24.toString();
    }

    public void handleClick(ConversationServerInfo conversationServerInfo) {
        String str;
        Action action = this.actionCard.action;
        ActionType actionType = action.actionType;
        if (actionType == ActionType.CALL) {
            str = action.actionData.get("phone_number");
        } else {
            str = actionType == ActionType.LINK ? action.actionData.get("url") : "";
        }
        this.domain.getDelegate().userClickOnAction(action.actionType, str);
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsEventKey.ISSUE_ID, conversationServerInfo.getIssueId());
        hashMap.put(AnalyticsEventKey.MESSAGE_ID, this.originalMessageServerId);
        hashMap.put("a", action.actionSHA);
        hashMap.put("type", action.actionType.getValue());
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.ACTION_CARD_CLICKED, (Map<String, Object>) hashMap);
    }

    public boolean isActionCardTitleVisible() {
        return StringUtils.isNotEmpty(this.actionCard.title);
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof AdminActionCardMessageDM) {
            this.actionCard = ((AdminActionCardMessageDM) messageDM).actionCard;
        }
    }

    public void setState(ActionCardImageState actionCardImageState) {
        this.state = actionCardImageState;
        notifyUpdated();
    }

    public AdminActionCardMessageDM deepClone() {
        return new AdminActionCardMessageDM(this);
    }

    public AdminActionCardMessageDM(AdminActionCardMessageDM adminActionCardMessageDM) {
        super(adminActionCardMessageDM);
        this.actionCard = adminActionCardMessageDM.actionCard.deepClone();
        this.state = adminActionCardMessageDM.state;
        this.retryAttempts = adminActionCardMessageDM.retryAttempts;
        this.originalMessageServerId = adminActionCardMessageDM.originalMessageServerId;
    }
}
