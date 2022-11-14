package com.helpshift.support.conversations.messages;

import android.content.Context;
import com.helpshift.C2466R;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import com.helpshift.views.CircleImageView;

public class AvatarImageLoader {

    /* renamed from: com.helpshift.support.conversations.messages.AvatarImageLoader$1 */
    public static /* synthetic */ class C27641 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$Author$AuthorRole */
        public static final /* synthetic */ int[] f3356x96bc889d;

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$MessageDM$AvatarImageDownloadState */
        public static final /* synthetic */ int[] f3357x59416f38;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|7|8|9|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0030 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0036 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole[] r0 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3356x96bc889d = r0
                r1 = 1
                r2 = 2
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r3 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.SYSTEM     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f3356x96bc889d     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r3 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.BOT     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r0 = 0
                r3 = 3
                int[] r4 = f3356x96bc889d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.Author$AuthorRole r5 = com.helpshift.conversation.activeconversation.message.Author.AuthorRole.AGENT     // Catch:{ NoSuchFieldError -> 0x001d }
                r4[r0] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.helpshift.conversation.activeconversation.message.MessageDM$AvatarImageDownloadState[] r4 = com.helpshift.conversation.activeconversation.message.MessageDM.AvatarImageDownloadState.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f3357x59416f38 = r4
                com.helpshift.conversation.activeconversation.message.MessageDM$AvatarImageDownloadState r5 = com.helpshift.conversation.activeconversation.message.MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOAD_FAILED     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3357x59416f38     // Catch:{ NoSuchFieldError -> 0x0030 }
                com.helpshift.conversation.activeconversation.message.MessageDM$AvatarImageDownloadState r4 = com.helpshift.conversation.activeconversation.message.MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_NOT_PRESENT     // Catch:{ NoSuchFieldError -> 0x0030 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
            L_0x0030:
                int[] r0 = f3357x59416f38     // Catch:{ NoSuchFieldError -> 0x0036 }
                com.helpshift.conversation.activeconversation.message.MessageDM$AvatarImageDownloadState r1 = com.helpshift.conversation.activeconversation.message.MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0036 }
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0036 }
            L_0x0036:
                int[] r0 = f3357x59416f38     // Catch:{ NoSuchFieldError -> 0x003d }
                com.helpshift.conversation.activeconversation.message.MessageDM$AvatarImageDownloadState r1 = com.helpshift.conversation.activeconversation.message.MessageDM.AvatarImageDownloadState.AVATAR_IMAGE_DOWNLOADED     // Catch:{ NoSuchFieldError -> 0x003d }
                r1 = 4
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AvatarImageLoader.C27641.<clinit>():void");
        }
    }

    public static ValuePair<String, String> getAuthorAvatarActualImage(MessageDM messageDM) {
        String str;
        String authorAvatarFallbackImage = messageDM.getAuthorAvatarFallbackImage();
        Author.AuthorRole authorRole = messageDM.author.role;
        if (authorRole == Author.AuthorRole.AGENT && messageDM.shouldShowPersonalisedAgentAvatar()) {
            str = messageDM.author.localAvatarImagePath;
        } else if (authorRole != Author.AuthorRole.BOT || !messageDM.shouldShowPersonalisedBotAvatar()) {
            Author.AuthorRole authorRole2 = Author.AuthorRole.SYSTEM;
            str = authorAvatarFallbackImage;
        } else {
            str = messageDM.author.localAvatarImagePath;
        }
        return new ValuePair<>(str, authorAvatarFallbackImage);
    }

    public static String getFallbackImageURL(Author.AuthorRole authorRole) {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        int ordinal = authorRole.ordinal();
        if (ordinal == 0) {
            return sDKConfigurationDM.getAgentFallbackImageUrl();
        }
        if (ordinal != 1) {
            return sDKConfigurationDM.getConversationHeaderImageUrl();
        }
        return sDKConfigurationDM.getBotFallbackImageUrl();
    }

    public static int getLocalFallbackImage(Author.AuthorRole authorRole) {
        int ordinal = authorRole.ordinal();
        if (ordinal == 0) {
            return C2466R.C2467drawable.hs__default_agent_avatar;
        }
        if (ordinal == 1) {
            return C2466R.C2467drawable.hs__default_bot_avatar;
        }
        if (ordinal != 2) {
            return C2466R.C2467drawable.hs__default_support_avatar;
        }
        return C2466R.C2467drawable.hs__default_support_avatar;
    }

    public static void loadAvatarImageAccordingToState(Context context, MessageDM messageDM, CircleImageView circleImageView) {
        SDKConfigurationDM sDKConfigurationDM = HelpshiftContext.getCoreApi().getSDKConfigurationDM();
        MessageDM.AvatarImageDownloadState avatarImageState = messageDM.getAvatarImageState();
        int localFallbackImage = getLocalFallbackImage(messageDM.author.role);
        ValuePair<String, String> authorAvatarActualImage = getAuthorAvatarActualImage(messageDM);
        String str = (String) authorAvatarActualImage.first;
        String str2 = (String) authorAvatarActualImage.second;
        int width = circleImageView.getWidth();
        if (width == 0) {
            width = context.getResources().getDimensionPixelSize(C2466R.dimen.hs__author_avatar_size);
        }
        int ordinal = avatarImageState.ordinal();
        if (ordinal == 0 || ordinal == 1 || ordinal == 2) {
            if (StringUtils.isNotEmpty(str2)) {
                circleImageView.setTag(getFallbackImageURL(messageDM.author.role));
                ImageLoader.getInstance().loadImageWithoutSampling(str2, circleImageView, context.getResources().getDrawable(localFallbackImage), width);
                return;
            }
            circleImageView.setTag(Integer.valueOf(localFallbackImage));
            circleImageView.setImageResource(localFallbackImage);
        } else if (ordinal == 3) {
            circleImageView.setTag(sDKConfigurationDM.getAvatarImageUrl(messageDM.author.authorId));
            ImageLoader.getInstance().loadImageWithoutSampling(str, circleImageView, context.getResources().getDrawable(localFallbackImage), width);
        }
    }

    public static void loadConversationHeaderAvatarImage(Context context, CircleImageView circleImageView, String str) {
        if (StringUtils.isNotEmpty(str)) {
            ImageLoader.getInstance().loadImageWithoutSampling(str, circleImageView, context.getResources().getDrawable(C2466R.C2467drawable.hs__default_support_avatar), circleImageView.getWidth() == 0 ? context.getResources().getDimensionPixelSize(C2466R.dimen.hs__author_avatar_size) : circleImageView.getWidth());
        } else {
            circleImageView.setImageResource(C2466R.C2467drawable.hs__default_support_avatar);
        }
    }
}
