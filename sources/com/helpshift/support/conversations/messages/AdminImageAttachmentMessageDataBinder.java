package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.support.views.HSRoundedImageView;
import com.helpshift.util.Styles;

public class AdminImageAttachmentMessageDataBinder extends MessageViewDataBinder<ViewHolder, AdminImageAttachmentMessageDM> {

    /* renamed from: com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder$2 */
    public static /* synthetic */ class C27592 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$AdminImageAttachmentMessageDM$AdminImageAttachmentState */
        public static final /* synthetic */ int[] f3355x3e717422;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState[] r0 = com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM.AdminImageAttachmentState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3355x3e717422 = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState r2 = com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM.AdminImageAttachmentState.DOWNLOAD_NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3355x3e717422     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState r3 = com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM.AdminImageAttachmentState.THUMBNAIL_DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3355x3e717422     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState r3 = com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM.AdminImageAttachmentState.THUMBNAIL_DOWNLOADED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = f3355x3e717422     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState r3 = com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM.AdminImageAttachmentState.IMAGE_DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = f3355x3e717422     // Catch:{ NoSuchFieldError -> 0x002b }
                com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState r2 = com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM.AdminImageAttachmentState.IMAGE_DOWNLOADED     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder.C27592.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final View downloadButtonView;
        public final View downloadProgressbarContainer;
        public final TextView fileSize;
        public final View messageContainer;
        public final View messageLayout;
        public final ProgressBar progressBarView;
        public final HSRoundedImageView roundedImageView;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.admin_image_message_layout);
            this.roundedImageView = (HSRoundedImageView) view.findViewById(C2466R.C2468id.admin_attachment_imageview);
            this.downloadButtonView = view.findViewById(C2466R.C2468id.download_button);
            this.downloadProgressbarContainer = view.findViewById(C2466R.C2468id.download_progressbar_container);
            this.progressBarView = (ProgressBar) view.findViewById(C2466R.C2468id.download_attachment_progressbar);
            this.fileSize = (TextView) view.findViewById(C2466R.C2468id.attachment_file_size);
            this.messageContainer = view.findViewById(C2466R.C2468id.admin_image_attachment_message_container);
            Styles.setColorFilter(AdminImageAttachmentMessageDataBinder.this.context, ((ImageView) view.findViewById(C2466R.C2468id.hs_download_foreground_view)).getDrawable(), C2466R.attr.hs__chatBubbleMediaBackgroundColor);
            com.helpshift.support.util.Styles.setAccentColor(AdminImageAttachmentMessageDataBinder.this.context, this.progressBarView.getIndeterminateDrawable());
        }
    }

    public AdminImageAttachmentMessageDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder.ViewHolder r12, final com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM r13) {
        /*
            r11 = this;
            java.lang.String r0 = r13.getFormattedFileSize()
            com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM$AdminImageAttachmentState r1 = r13.state
            int r1 = r1.ordinal()
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x007f
            if (r1 == r4) goto L_0x006e
            r5 = 2
            if (r1 == r5) goto L_0x0059
            r6 = 3
            if (r1 == r6) goto L_0x0035
            r5 = 4
            if (r1 == r5) goto L_0x0025
            java.lang.String r1 = ""
            r5 = r1
            r1 = r2
            r3 = 1
            r6 = 1
            r7 = 0
        L_0x0021:
            r8 = 1
        L_0x0022:
            r9 = 1
            goto L_0x0095
        L_0x0025:
            java.lang.String r1 = r13.checkAndGetFilePath()
            android.content.Context r5 = r11.context
            int r6 = com.helpshift.C2466R.string.hs__image_downloaded_voice_over
            java.lang.String r5 = r5.getString(r6)
            r6 = 0
            r7 = 0
            r8 = 0
            goto L_0x0022
        L_0x0035:
            java.lang.String r1 = r13.checkAndGetThumbnailFilePath()
            java.lang.String r0 = r13.getDownloadProgressAndFileSize()
            android.content.Context r6 = r11.context
            int r7 = com.helpshift.C2466R.string.hs__image_downloading_voice_over
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r8 = r13.getDownloadedProgressSize()
            r5[r3] = r8
            java.lang.String r8 = r13.getFormattedFileSize()
            r5[r4] = r8
            java.lang.String r5 = r6.getString(r7, r5)
            r3 = 1
            r6 = 1
            r7 = 0
            r8 = 1
            r9 = 0
            goto L_0x0095
        L_0x0059:
            java.lang.String r1 = r13.checkAndGetThumbnailFilePath()
            android.content.Context r5 = r11.context
            int r6 = com.helpshift.C2466R.string.hs__image_not_downloaded_voice_over
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.String r8 = r13.getFormattedFileSize()
            r7[r3] = r8
            java.lang.String r5 = r5.getString(r6, r7)
            goto L_0x0091
        L_0x006e:
            android.content.Context r1 = r11.context
            int r5 = com.helpshift.C2466R.string.hs__image_not_downloaded_voice_over
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = r13.getFormattedFileSize()
            r6[r3] = r7
            java.lang.String r1 = r1.getString(r5, r6)
            goto L_0x008f
        L_0x007f:
            android.content.Context r1 = r11.context
            int r5 = com.helpshift.C2466R.string.hs__image_not_downloaded_voice_over
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = r13.getFormattedFileSize()
            r6[r3] = r7
            java.lang.String r1 = r1.getString(r5, r6)
        L_0x008f:
            r5 = r1
            r1 = r2
        L_0x0091:
            r3 = 1
            r6 = 0
            r7 = 1
            goto L_0x0021
        L_0x0095:
            android.view.View r10 = r12.downloadProgressbarContainer
            r11.setViewVisibility(r10, r3)
            android.widget.ProgressBar r3 = r12.progressBarView
            r11.setViewVisibility(r3, r6)
            android.view.View r3 = r12.downloadButtonView
            r11.setViewVisibility(r3, r7)
            if (r8 == 0) goto L_0x00ae
            com.helpshift.support.views.HSRoundedImageView r3 = r12.roundedImageView
            r6 = 1048576000(0x3e800000, float:0.25)
            r3.setAlpha(r6)
            goto L_0x00b5
        L_0x00ae:
            com.helpshift.support.views.HSRoundedImageView r3 = r12.roundedImageView
            r6 = 1065353216(0x3f800000, float:1.0)
            r3.setAlpha(r6)
        L_0x00b5:
            android.widget.TextView r3 = r12.fileSize
            r11.setViewVisibility(r3, r4)
            com.helpshift.support.imageloader.ImageLoader r3 = com.helpshift.support.imageloader.ImageLoader.getInstance()
            com.helpshift.support.views.HSRoundedImageView r4 = r12.roundedImageView
            android.content.Context r6 = r11.context
            android.content.res.Resources r6 = r6.getResources()
            int r8 = com.helpshift.C2466R.C2467drawable.hs__placeholder_image
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r8)
            r3.load(r1, r4, r6)
            android.widget.TextView r1 = r12.fileSize
            r1.setText(r0)
            com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder$1 r0 = new com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder$1
            r0.<init>(r13)
            if (r7 == 0) goto L_0x00e1
            android.view.View r1 = r12.downloadButtonView
            r1.setOnClickListener(r0)
            goto L_0x00e6
        L_0x00e1:
            android.view.View r1 = r12.downloadButtonView
            r1.setOnClickListener(r2)
        L_0x00e6:
            if (r9 == 0) goto L_0x00ee
            com.helpshift.support.views.HSRoundedImageView r1 = r12.roundedImageView
            r1.setOnClickListener(r0)
            goto L_0x00f3
        L_0x00ee:
            com.helpshift.support.views.HSRoundedImageView r0 = r12.roundedImageView
            r0.setOnClickListener(r2)
        L_0x00f3:
            com.helpshift.support.views.HSRoundedImageView r0 = r12.roundedImageView
            r0.setContentDescription(r5)
            android.view.View r0 = r12.messageLayout
            java.lang.String r1 = r11.getAdminMessageContentDesciption(r13)
            r0.setContentDescription(r1)
            boolean r13 = r13.shouldShowAvatar()
            if (r13 == 0) goto L_0x0110
            android.view.View r12 = r12.messageContainer
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            r11.setAdminMessageLayoutMarginForAvatar(r12)
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder.bind(com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_attachment_image, viewGroup, false));
    }
}
