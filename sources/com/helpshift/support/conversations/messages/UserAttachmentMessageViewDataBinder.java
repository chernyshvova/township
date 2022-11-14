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
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.util.Styles;

public class UserAttachmentMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, UserAttachmentMessageDM> {

    /* renamed from: com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder$2 */
    public static /* synthetic */ class C27742 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$UserAttachmentMessageDM$UserGenericAttachmentState */
        public static final /* synthetic */ int[] f3362x28bf9c21;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState[] r0 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3362x28bf9c21 = r0
                r1 = 1
                r2 = 4
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r3 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.SENDING     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 5
                int[] r4 = f3362x28bf9c21     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r5 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.SENT     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r4 = 3
                int[] r5 = f3362x28bf9c21     // Catch:{ NoSuchFieldError -> 0x001e }
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r6 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.UNSENT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x001e }
                r5[r0] = r4     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r0 = f3362x28bf9c21     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r5 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.UNSENT_NOT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x0024 }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r0 = f3362x28bf9c21     // Catch:{ NoSuchFieldError -> 0x002b }
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r2 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.DOWNLOAD_NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 0
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f3362x28bf9c21     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r2 = com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM.UserGenericAttachmentState.DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder.C27742.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView attachmentIcon;
        public final View downloadButton;
        public final TextView fileName;
        public final TextView fileSize;
        public final View messageContainer;
        public final View messageLayout;
        public final ProgressBar progress;
        public final ImageView retryButton;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.user_attachment_message_layout);
            this.messageContainer = view.findViewById(C2466R.C2468id.user_attachment_container);
            this.fileName = (TextView) view.findViewById(C2466R.C2468id.attachment_file_name);
            this.fileSize = (TextView) view.findViewById(C2466R.C2468id.attachment_file_size);
            this.downloadButton = view.findViewById(C2466R.C2468id.download_button);
            this.progress = (ProgressBar) view.findViewById(C2466R.C2468id.progress);
            this.attachmentIcon = (ImageView) view.findViewById(C2466R.C2468id.attachment_icon);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.date);
            this.retryButton = (ImageView) view.findViewById(C2466R.C2468id.user_message_retry_button);
            Styles.setColorFilter(UserAttachmentMessageViewDataBinder.this.context, ((ImageView) view.findViewById(C2466R.C2468id.hs_download_foreground_view)).getDrawable(), C2466R.attr.hs__chatBubbleMediaBackgroundColor);
            com.helpshift.support.util.Styles.setAccentColor(UserAttachmentMessageViewDataBinder.this.context, this.progress.getIndeterminateDrawable());
            com.helpshift.support.util.Styles.setAccentColor(UserAttachmentMessageViewDataBinder.this.context, this.attachmentIcon.getDrawable());
        }

        public void onClick(View view) {
            MessageViewDataBinder.MessageItemClickListener messageItemClickListener = UserAttachmentMessageViewDataBinder.this.messageClickListener;
            if (messageItemClickListener != null) {
                messageItemClickListener.retryMessage(getAdapterPosition());
            }
        }
    }

    public UserAttachmentMessageViewDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder.ViewHolder r21, com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            android.content.Context r3 = r0.context
            r4 = 16842806(0x1010036, float:2.369371E-38)
            int r3 = com.helpshift.support.util.Styles.getColor(r3, r4)
            android.content.Context r4 = r0.context
            r5 = 16842808(0x1010038, float:2.3693715E-38)
            int r4 = com.helpshift.support.util.Styles.getColor(r4, r5)
            java.lang.String r5 = r22.getFormattedFileSize()
            java.lang.String r6 = r22.getSubText()
            com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM$UserGenericAttachmentState r7 = r2.state
            int r7 = r7.ordinal()
            java.lang.String r10 = ""
            r11 = 2
            r12 = 0
            r13 = 1
            if (r7 == 0) goto L_0x0161
            r15 = 3
            if (r7 == r13) goto L_0x012a
            if (r7 == r11) goto L_0x00e8
            if (r7 == r15) goto L_0x009e
            r11 = 4
            if (r7 == r11) goto L_0x0078
            r11 = 5
            if (r7 == r11) goto L_0x0046
            r7 = r10
            r16 = r7
            r8 = 1056964608(0x3f000000, float:0.5)
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
        L_0x0043:
            r15 = 0
            goto L_0x018d
        L_0x0046:
            android.content.Context r3 = r0.context
            int r7 = com.helpshift.C2466R.attr.colorAccent
            int r3 = com.helpshift.support.util.Styles.getColor(r3, r7)
            android.content.Context r7 = r0.context
            int r11 = com.helpshift.C2466R.string.hs__user_sent_message_voice_over
            java.lang.Object[] r14 = new java.lang.Object[r13]
            java.lang.String r15 = r22.getAccessbilityMessageTime()
            r14[r12] = r15
            java.lang.String r7 = r7.getString(r11, r14)
            android.content.Context r11 = r0.context
            int r14 = com.helpshift.C2466R.string.hs__attachment_downloaded__voice_over
            java.lang.Object[] r15 = new java.lang.Object[r13]
            java.lang.String r8 = r2.fileName
            r15[r12] = r8
            java.lang.String r8 = r11.getString(r14, r15)
            r16 = r10
            r9 = 0
            r11 = 0
        L_0x0070:
            r14 = 0
            r15 = 1
        L_0x0072:
            r10 = r7
            r7 = r8
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x018d
        L_0x0078:
            java.lang.String r5 = r22.getFormattedFileSize()
            android.content.Context r6 = r0.context
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.helpshift.C2466R.string.hs__sending_msg
            java.lang.String r6 = r6.getString(r7)
            android.content.Context r7 = r0.context
            int r8 = com.helpshift.C2466R.string.hs__user_sending_message_voice_over
            java.lang.String r7 = r7.getString(r8)
            r16 = r10
            r8 = 1056964608(0x3f000000, float:0.5)
            r9 = 0
            r11 = 1
            r13 = 0
            r14 = 0
            r15 = 0
            r10 = r7
            r7 = r16
            goto L_0x018d
        L_0x009e:
            boolean r4 = r2.isRejected
            if (r4 == 0) goto L_0x00ab
            android.content.Context r4 = r0.context
            int r6 = com.helpshift.C2466R.string.hs__file_type_unsupported
            java.lang.String r4 = r4.getString(r6)
            goto L_0x00b7
        L_0x00ab:
            android.content.Context r4 = r0.context
            android.content.res.Resources r4 = r4.getResources()
            int r6 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r4 = r4.getString(r6)
        L_0x00b7:
            r6 = r4
            android.content.Context r4 = r0.context
            int r7 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r4 = com.helpshift.support.util.Styles.getColor(r4, r7)
            android.content.Context r7 = r0.context
            int r8 = com.helpshift.C2466R.string.hs__user_attachment_rejected_voice_over
            java.lang.String r7 = r7.getString(r8)
            android.content.Context r8 = r0.context
            int r15 = com.helpshift.C2466R.string.hs__attachment_name_voice_over
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r14 = r2.fileName
            r11[r12] = r14
            java.lang.String r14 = r22.getFormattedFileSize()
            r11[r13] = r14
            java.lang.String r8 = r8.getString(r15, r11)
            r16 = r10
            r9 = 0
            r11 = 0
            r14 = 0
            r15 = 0
            r10 = r7
            r7 = r8
            r8 = 1056964608(0x3f000000, float:0.5)
            goto L_0x018d
        L_0x00e8:
            android.content.Context r4 = r0.context
            android.content.res.Resources r4 = r4.getResources()
            int r6 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r6 = r4.getString(r6)
            android.content.Context r4 = r0.context
            int r7 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r4 = com.helpshift.support.util.Styles.getColor(r4, r7)
            android.content.Context r7 = r0.context
            int r8 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r10 = r7.getString(r8)
            android.content.Context r7 = r0.context
            int r8 = com.helpshift.C2466R.string.hs__retry_button_voice_over
            java.lang.String r7 = r7.getString(r8)
            android.content.Context r8 = r0.context
            int r14 = com.helpshift.C2466R.string.hs__attachment_name_voice_over
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r15 = r2.fileName
            r11[r12] = r15
            java.lang.String r15 = r22.getFormattedFileSize()
            r11[r13] = r15
            java.lang.String r8 = r8.getString(r14, r11)
            r9 = r1
            r16 = r7
            r7 = r8
            r8 = 1056964608(0x3f000000, float:0.5)
            r11 = 0
            r14 = 1
            goto L_0x0043
        L_0x012a:
            java.lang.String r5 = r22.getProgressAndFileSize()
            android.content.Context r7 = r0.context
            int r8 = com.helpshift.C2466R.string.hs__user_sent_message_voice_over
            java.lang.Object[] r14 = new java.lang.Object[r13]
            java.lang.String r17 = r22.getAccessbilityMessageTime()
            r14[r12] = r17
            java.lang.String r7 = r7.getString(r8, r14)
            android.content.Context r8 = r0.context
            int r14 = com.helpshift.C2466R.string.hs__attachment_downloading_voice_over
            java.lang.Object[] r15 = new java.lang.Object[r15]
            java.lang.String r9 = r2.fileName
            r15[r12] = r9
            java.lang.String r9 = r22.getProgressAndFileSize()
            r15[r13] = r9
            java.lang.String r9 = r22.getFormattedFileSize()
            r15[r11] = r9
            java.lang.String r8 = r8.getString(r14, r15)
            r16 = r10
            r9 = 0
            r11 = 1
            r13 = 0
            r14 = 0
            r15 = 0
            goto L_0x0072
        L_0x0161:
            android.content.Context r7 = r0.context
            int r8 = com.helpshift.C2466R.string.hs__user_sent_message_voice_over
            java.lang.Object[] r9 = new java.lang.Object[r13]
            java.lang.String r14 = r22.getAccessbilityMessageTime()
            r9[r12] = r14
            java.lang.String r7 = r7.getString(r8, r9)
            android.content.Context r8 = r0.context
            int r9 = com.helpshift.C2466R.string.hs__attachment_not_downloaded_voice_over
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r14 = r2.fileName
            r11[r12] = r14
            java.lang.String r14 = r22.getFormattedFileSize()
            r11[r13] = r14
            java.lang.String r8 = r8.getString(r9, r11)
            r16 = r10
            r9 = 0
            r11 = 0
            r12 = 1
            r13 = 0
            goto L_0x0070
        L_0x018d:
            com.helpshift.conversation.activeconversation.message.UIViewState r18 = r22.getUiViewState()
            r19 = r7
            android.view.View r7 = r1.downloadButton
            r0.setViewVisibility(r7, r12)
            android.widget.ImageView r7 = r1.attachmentIcon
            r0.setViewVisibility(r7, r13)
            android.widget.ProgressBar r7 = r1.progress
            r0.setViewVisibility(r7, r11)
            android.widget.ImageView r7 = r1.retryButton
            r0.setViewVisibility(r7, r14)
            android.widget.TextView r7 = r1.subText
            boolean r11 = r18.isFooterVisible()
            r0.setViewVisibility(r7, r11)
            android.view.View r7 = r1.messageLayout
            r7.setAlpha(r8)
            android.widget.TextView r7 = r1.fileName
            java.lang.String r8 = r2.fileName
            r7.setText(r8)
            android.widget.TextView r7 = r1.fileSize
            r7.setText(r5)
            android.widget.TextView r5 = r1.fileName
            r5.setTextColor(r3)
            boolean r3 = r18.isFooterVisible()
            if (r3 == 0) goto L_0x01d6
            android.widget.TextView r3 = r1.subText
            r3.setText(r6)
            android.widget.TextView r3 = r1.subText
            r3.setTextColor(r4)
        L_0x01d6:
            if (r14 == 0) goto L_0x01df
            android.widget.ImageView r3 = r1.retryButton
            r3.setOnClickListener(r9)
            r4 = 0
            goto L_0x01e5
        L_0x01df:
            android.widget.ImageView r3 = r1.retryButton
            r4 = 0
            r3.setOnClickListener(r4)
        L_0x01e5:
            if (r15 == 0) goto L_0x01f2
            android.view.View r3 = r1.messageLayout
            com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder$1 r4 = new com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder$1
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            goto L_0x01f7
        L_0x01f2:
            android.view.View r2 = r1.messageLayout
            r2.setOnClickListener(r4)
        L_0x01f7:
            android.view.View r2 = r1.messageContainer
            r2.setContentDescription(r10)
            android.view.View r2 = r1.messageLayout
            r8 = r19
            r2.setContentDescription(r8)
            android.widget.ImageView r1 = r1.retryButton
            r10 = r16
            r1.setContentDescription(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder.bind(com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_user_attachment_generic, viewGroup, false));
    }
}
