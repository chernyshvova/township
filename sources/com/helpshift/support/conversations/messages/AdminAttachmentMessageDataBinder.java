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
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.util.Styles;

public class AdminAttachmentMessageDataBinder extends MessageViewDataBinder<ViewHolder, AdminAttachmentMessageDM> {

    /* renamed from: com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder$2 */
    public static /* synthetic */ class C27552 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$AdminAttachmentMessageDM$AdminGenericAttachmentState */
        public static final /* synthetic */ int[] f3354x7e204bdd;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM$AdminGenericAttachmentState[] r0 = com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM.AdminGenericAttachmentState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3354x7e204bdd = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM$AdminGenericAttachmentState r2 = com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM.AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3354x7e204bdd     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM$AdminGenericAttachmentState r3 = com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM.AdminGenericAttachmentState.DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f3354x7e204bdd     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM$AdminGenericAttachmentState r2 = com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM.AdminGenericAttachmentState.DOWNLOADED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder.C27552.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView attachmentIcon;
        public final View downloadButton;
        public final TextView fileName;
        public final TextView fileSize;
        public final View messageContainer;
        public final View messageLayout;
        public final ProgressBar progress;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.admin_attachment_message_layout);
            this.fileName = (TextView) view.findViewById(C2466R.C2468id.attachment_file_name);
            this.fileSize = (TextView) view.findViewById(C2466R.C2468id.attachment_file_size);
            this.messageContainer = view.findViewById(C2466R.C2468id.admin_message);
            this.downloadButton = view.findViewById(C2466R.C2468id.download_button);
            this.progress = (ProgressBar) view.findViewById(C2466R.C2468id.progress);
            this.attachmentIcon = (ImageView) view.findViewById(C2466R.C2468id.attachment_icon);
            Styles.setColorFilter(AdminAttachmentMessageDataBinder.this.context, ((ImageView) view.findViewById(C2466R.C2468id.hs_download_foreground_view)).getDrawable(), C2466R.attr.hs__chatBubbleMediaBackgroundColor);
            Styles.setColorFilter(AdminAttachmentMessageDataBinder.this.context, this.messageContainer.getBackground(), C2466R.attr.hs__chatBubbleMediaBackgroundColor);
            com.helpshift.support.util.Styles.setAccentColor(AdminAttachmentMessageDataBinder.this.context, this.progress.getIndeterminateDrawable());
            com.helpshift.support.util.Styles.setAccentColor(AdminAttachmentMessageDataBinder.this.context, this.attachmentIcon.getDrawable());
        }
    }

    public AdminAttachmentMessageDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder.ViewHolder r10, final com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.context
            r1 = 16842806(0x1010036, float:2.369371E-38)
            int r0 = com.helpshift.support.util.Styles.getColor(r0, r1)
            java.lang.String r1 = r11.getFormattedFileSize()
            com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM$AdminGenericAttachmentState r2 = r11.state
            int r2 = r2.ordinal()
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r5) goto L_0x0039
            if (r2 == r3) goto L_0x0021
            java.lang.String r2 = ""
            r3 = 0
        L_0x001f:
            r5 = 0
            goto L_0x0071
        L_0x0021:
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.attr.colorAccent
            int r0 = com.helpshift.support.util.Styles.getColor(r0, r2)
            android.content.Context r2 = r9.context
            int r3 = com.helpshift.C2466R.string.hs__attachment_downloaded__voice_over
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.String r7 = r11.fileName
            r6[r4] = r7
            java.lang.String r2 = r2.getString(r3, r6)
            r3 = 0
            goto L_0x0071
        L_0x0039:
            java.lang.String r1 = r11.getDownloadProgressAndFileSize()
            android.content.Context r2 = r9.context
            int r6 = com.helpshift.C2466R.string.hs__attachment_downloading_voice_over
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r8 = r11.fileName
            r7[r4] = r8
            java.lang.String r8 = r11.getDownloadedProgressSize()
            r7[r5] = r8
            java.lang.String r8 = r11.getFormattedFileSize()
            r7[r3] = r8
            java.lang.String r2 = r2.getString(r6, r7)
            r3 = 1
            goto L_0x001f
        L_0x005a:
            android.content.Context r2 = r9.context
            int r6 = com.helpshift.C2466R.string.hs__attachment_not_downloaded_voice_over
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r7 = r11.fileName
            r3[r4] = r7
            java.lang.String r7 = r11.getFormattedFileSize()
            r3[r5] = r7
            java.lang.String r2 = r2.getString(r6, r3)
            r3 = 0
            r4 = 1
            goto L_0x001f
        L_0x0071:
            android.view.View r6 = r10.downloadButton
            r9.setViewVisibility(r6, r4)
            android.widget.ImageView r4 = r10.attachmentIcon
            r9.setViewVisibility(r4, r5)
            android.widget.ProgressBar r4 = r10.progress
            r9.setViewVisibility(r4, r3)
            android.widget.TextView r3 = r10.fileName
            java.lang.String r4 = r11.fileName
            r3.setText(r4)
            android.widget.TextView r3 = r10.fileSize
            r3.setText(r1)
            android.widget.TextView r1 = r10.fileName
            r1.setTextColor(r0)
            android.view.View r0 = r10.messageContainer
            com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder$1 r1 = new com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder$1
            r1.<init>(r11)
            r0.setOnClickListener(r1)
            android.view.View r0 = r10.messageContainer
            r0.setContentDescription(r2)
            android.view.View r0 = r10.messageLayout
            java.lang.String r1 = r9.getAdminMessageContentDesciption(r11)
            r0.setContentDescription(r1)
            boolean r11 = r11.shouldShowAvatar()
            if (r11 == 0) goto L_0x00b8
            android.view.View r10 = r10.messageContainer
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            r9.setAdminMessageLayoutMarginForAvatar(r10)
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder.bind(com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_attachment_generic, viewGroup, false));
    }
}
