package com.helpshift.conversation.activeconversation.message;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.HSUrlMetadata;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.util.DownloadUtil;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.util.FileUtil;
import com.helpshift.util.StringUtils;

public class AvatarImageDownloader {
    public static void downloadAgentFallbackImage(Platform platform, Domain domain) {
        SDKConfigurationDM sDKConfigurationDM = domain.getSDKConfigurationDM();
        downloadAndSaveFallbackImage(platform, domain, sDKConfigurationDM, sDKConfigurationDM.getAgentFallbackImageUrl(), SDKConfigurationDM.AGENT_FALLBACK_IMAGE_URL);
    }

    public static void downloadAndSaveFallbackImage(Platform platform, Domain domain, final SDKConfigurationDM sDKConfigurationDM, String str, String str2) {
        DownloadUtil.downloadFile(platform, domain, str, str2, new DownloadUtil.OnFileDownloadFinishListener() {
            public void onFileDownloadFailure(String str, int i, String str2) {
                sDKConfigurationDM.storeDownloadedImage("", str2);
            }

            public void onFileDownloadSuccess(String str, String str2, String str3, String str4) {
                sDKConfigurationDM.storeDownloadedImage(str2, str4);
            }
        });
    }

    public static void downloadAvatarImage(Platform platform, Domain domain, MessageDM messageDM) {
        String avatarImageUrl = domain.getSDKConfigurationDM().getAvatarImageUrl(messageDM.author.authorId);
        if (StringUtils.isNotEmpty(avatarImageUrl)) {
            HSUrlMetadata urlMetadata = getUrlMetadata(platform, avatarImageUrl);
            long j = urlMetadata != null ? urlMetadata.lastFetchTimestamp : 0;
            boolean z = urlMetadata != null && urlMetadata.isLastFetchSuccessful;
            if (System.currentTimeMillis() - j > domain.getSDKConfigurationDM().getAvatarCacheExpiry()) {
                downloadAvatarImageInternal(platform, domain, avatarImageUrl, urlMetadata, true, messageDM);
            } else if (z) {
                downloadAvatarImageInternal(platform, domain, avatarImageUrl, urlMetadata, false, messageDM);
            } else {
                messageDM.setAvatarImageState(MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOAD_FAILED);
            }
        } else {
            updateMessageDm(platform, messageDM.getAuthorAvatarFallbackImage(), messageDM);
            messageDM.setAvatarImageState(MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADED);
        }
    }

    public static void downloadAvatarImageInternal(final Platform platform, Domain domain, final String str, HSUrlMetadata hSUrlMetadata, final boolean z, final MessageDM messageDM) {
        messageDM.setAvatarImageState(MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADING);
        DownloadUtil.downloadFile(platform, domain, z, str, str, hSUrlMetadata != null ? hSUrlMetadata.etag : "", new DownloadUtil.OnFileDownloadFinishListener() {
            public void onFileDownloadFailure(String str, int i, String str2) {
                if (i == NetworkErrorCodes.CONTENT_UNCHANGED.intValue()) {
                    if (z) {
                        AvatarImageDownloader.updateLastFetchTimestampAndStatus(platform, str);
                    }
                    messageDM.setAvatarImageState(MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADED);
                    return;
                }
                if (z) {
                    AvatarImageDownloader.insertOrUpdateUrlMetadata(platform, str, "", false);
                    FileUtil.deleteFile(messageDM.author.localAvatarImagePath);
                }
                AvatarImageDownloader.updateMessageDm(platform, "", messageDM);
                messageDM.setAvatarImageState(MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOAD_FAILED);
            }

            public void onFileDownloadSuccess(String str, String str2, String str3, String str4) {
                if (z) {
                    AvatarImageDownloader.insertOrUpdateUrlMetadata(platform, str, str3, true);
                    FileUtil.deleteFile(messageDM.author.localAvatarImagePath);
                }
                AvatarImageDownloader.updateMessageDm(platform, str2, messageDM);
                messageDM.setAvatarImageState(MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADED);
            }
        });
    }

    public static void downloadBotFallbackImage(Platform platform, Domain domain) {
        SDKConfigurationDM sDKConfigurationDM = domain.getSDKConfigurationDM();
        downloadAndSaveFallbackImage(platform, domain, sDKConfigurationDM, sDKConfigurationDM.getBotFallbackImageUrl(), SDKConfigurationDM.BOT_FALLBACK_IMAGE_URL);
    }

    public static void downloadConversationHeaderImage(Platform platform, Domain domain) {
        SDKConfigurationDM sDKConfigurationDM = domain.getSDKConfigurationDM();
        downloadAndSaveFallbackImage(platform, domain, sDKConfigurationDM, sDKConfigurationDM.getConversationHeaderImageUrl(), SDKConfigurationDM.HEADER_IMAGE_URL);
    }

    public static HSUrlMetadata getUrlMetadata(Platform platform, String str) {
        return platform.getHSNetworkMetadataDAO().getMetadataOfUrl(str);
    }

    public static void insertOrUpdateUrlMetadata(Platform platform, String str, String str2, boolean z) {
        platform.getHSNetworkMetadataDAO().insertOrUpdateMetadataForUrl(str, new HSUrlMetadata(str, str2, System.currentTimeMillis(), z));
    }

    public static void retryFallbackImagesDownload(Platform platform, Domain domain) {
        SDKConfigurationDM sDKConfigurationDM = domain.getSDKConfigurationDM();
        if (sDKConfigurationDM.isAvatarEnabledInChatFeed()) {
            if (StringUtils.isEmpty(sDKConfigurationDM.getAgentFallbackImageLocalPath())) {
                downloadAgentFallbackImage(platform, domain);
            }
            if (StringUtils.isEmpty(sDKConfigurationDM.getBotFallbackImageLocalPath())) {
                downloadBotFallbackImage(platform, domain);
            }
            if (StringUtils.isEmpty(sDKConfigurationDM.getConversationHeaderImageLocalPath())) {
                downloadConversationHeaderImage(platform, domain);
            }
        }
    }

    public static void updateLastFetchTimestampAndStatus(Platform platform, String str) {
        platform.getHSNetworkMetadataDAO().updateLastFetchTimestampAndFetchStateOfUrl(str, System.currentTimeMillis(), true);
    }

    public static void updateMessageDm(Platform platform, String str, MessageDM messageDM) {
        messageDM.author.localAvatarImagePath = str;
        platform.getConversationDAO().insertOrUpdateMessage(messageDM);
    }
}
