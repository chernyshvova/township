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
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;

public class AdminActionCardMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, AdminActionCardMessageDM> {

    /* renamed from: com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder$2 */
    public static /* synthetic */ class C27532 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$AdminActionCardMessageDM$ActionCardImageState */
        public static final /* synthetic */ int[] f3353x50e18588;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM$ActionCardImageState[] r0 = com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM.ActionCardImageState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3353x50e18588 = r0
                r1 = 1
                r2 = 2
                com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM$ActionCardImageState r3 = com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM.ActionCardImageState.IMAGE_DOWNLOADED     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f3353x50e18588     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM$ActionCardImageState r3 = com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM.ActionCardImageState.DOWNLOAD_NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3 = 0
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = f3353x50e18588     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM$ActionCardImageState r2 = com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM.ActionCardImageState.IMAGE_DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder.C27532.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView actionButton;
        public final ImageView actionCardImage;
        public final View actionCardView;
        public final TextView actionTitle;
        public final TextView dateText;
        public final View imageViewContainer;
        public final View messageContainer;
        public final ProgressBar progress;
        public final View separator;

        public ViewHolder(View view) {
            super(view);
            this.actionTitle = (TextView) view.findViewById(C2466R.C2468id.action_card_title);
            this.dateText = (TextView) view.findViewById(C2466R.C2468id.admin_date_text);
            this.actionButton = (TextView) view.findViewById(C2466R.C2468id.action_card_action);
            this.progress = (ProgressBar) view.findViewById(C2466R.C2468id.download_progressbar);
            this.actionCardImage = (ImageView) view.findViewById(C2466R.C2468id.action_card_imageview);
            this.imageViewContainer = view.findViewById(C2466R.C2468id.action_card_imageview_container);
            this.separator = view.findViewById(C2466R.C2468id.action_card_separator);
            this.messageContainer = view.findViewById(C2466R.C2468id.action_card_container);
            this.actionCardView = view.findViewById(C2466R.C2468id.action_card_cardview);
        }
    }

    public AdminActionCardMessageViewDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder.ViewHolder r9, final com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM r10) {
        /*
            r8 = this;
            boolean r0 = r10.isActionCardTitleVisible()
            android.widget.ImageView r1 = r9.actionCardImage
            int r2 = com.helpshift.C2466R.C2467drawable.hs__placeholder_image
            r1.setImageResource(r2)
            com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM$ActionCardImageState r1 = r10.state
            int r1 = r1.ordinal()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 == r3) goto L_0x0037
            r4 = 2
            if (r1 == r4) goto L_0x001c
        L_0x001a:
            r3 = 0
            goto L_0x0038
        L_0x001c:
            com.helpshift.support.imageloader.ImageLoader r1 = com.helpshift.support.imageloader.ImageLoader.getInstance()
            com.helpshift.conversation.activeconversation.model.ActionCard r4 = r10.actionCard
            java.lang.String r4 = r4.filePath
            android.widget.ImageView r5 = r9.actionCardImage
            android.content.Context r6 = r8.context
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.helpshift.C2466R.C2467drawable.hs__placeholder_image
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r1.load(r4, r5, r6)
        L_0x0035:
            r2 = 1
            goto L_0x001a
        L_0x0037:
            r2 = 1
        L_0x0038:
            android.view.View r1 = r9.imageViewContainer
            r8.setViewVisibility(r1, r2)
            android.widget.TextView r1 = r9.actionTitle
            r8.setViewVisibility(r1, r0)
            android.view.View r1 = r9.separator
            r8.setViewVisibility(r1, r0)
            android.widget.ProgressBar r1 = r9.progress
            r8.setViewVisibility(r1, r3)
            android.widget.TextView r1 = r9.actionButton
            com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder$1 r2 = new com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder$1
            r2.<init>(r10)
            r1.setOnClickListener(r2)
            if (r0 == 0) goto L_0x006a
            android.widget.TextView r0 = r9.actionTitle
            com.helpshift.conversation.activeconversation.model.ActionCard r1 = r10.actionCard
            java.lang.String r1 = r1.title
            r0.setText(r1)
            android.widget.TextView r0 = r9.actionTitle
            com.helpshift.conversation.activeconversation.model.ActionCard r1 = r10.actionCard
            java.lang.String r1 = r1.title
            r0.setContentDescription(r1)
        L_0x006a:
            com.helpshift.conversation.activeconversation.message.UIViewState r0 = r10.getUiViewState()
            android.widget.TextView r1 = r9.dateText
            java.lang.String r2 = r10.getSubText()
            r8.setAdminMessageSubText(r1, r0, r2)
            android.widget.TextView r0 = r9.actionButton
            com.helpshift.conversation.activeconversation.model.ActionCard r1 = r10.actionCard
            com.helpshift.conversation.activeconversation.model.Action r1 = r1.action
            java.lang.String r1 = r1.actionTitle
            r0.setText(r1)
            android.widget.TextView r0 = r9.actionButton
            com.helpshift.conversation.activeconversation.model.ActionCard r1 = r10.actionCard
            com.helpshift.conversation.activeconversation.model.Action r1 = r1.action
            java.lang.String r1 = r1.actionTitle
            r0.setContentDescription(r1)
            android.view.View r0 = r9.messageContainer
            java.lang.String r1 = r8.getAdminMessageContentDesciption(r10)
            r0.setContentDescription(r1)
            boolean r10 = r10.shouldShowAvatar()
            if (r10 == 0) goto L_0x00a5
            android.view.View r9 = r9.actionCardView
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            r8.setAdminMessageLayoutMarginForAvatar(r9)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder.bind(com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_admin_action_card, viewGroup, false));
    }
}
