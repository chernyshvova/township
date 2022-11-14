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
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.support.util.Styles;
import com.helpshift.support.views.HSRoundedImageView;

public class ScreenshotMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, ScreenshotMessageDM> {

    /* renamed from: com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder$2 */
    public static /* synthetic */ class C27722 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$UserMessageState */
        public static final /* synthetic */ int[] f3361x57a590b2;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.UserMessageState[] r0 = com.helpshift.conversation.activeconversation.message.UserMessageState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3361x57a590b2 = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.UserMessageState r2 = com.helpshift.conversation.activeconversation.message.UserMessageState.UNSENT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3361x57a590b2     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.UserMessageState r3 = com.helpshift.conversation.activeconversation.message.UserMessageState.UNSENT_NOT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3361x57a590b2     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.UserMessageState r3 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENDING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3361x57a590b2     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.UserMessageState r2 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENT     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder.C27722.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View messageLayout;
        public final ProgressBar progress;
        public final ImageView retryButton;
        public final HSRoundedImageView roundedImageView;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.user_image_message_layout);
            this.progress = (ProgressBar) view.findViewById(C2466R.C2468id.upload_attachment_progressbar);
            this.roundedImageView = (HSRoundedImageView) view.findViewById(C2466R.C2468id.user_attachment_imageview);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.date);
            this.retryButton = (ImageView) view.findViewById(C2466R.C2468id.user_message_retry_button);
            Styles.setAccentColor(ScreenshotMessageViewDataBinder.this.context, this.progress.getIndeterminateDrawable());
        }

        public void onClick(View view) {
            MessageViewDataBinder.MessageItemClickListener messageItemClickListener = ScreenshotMessageViewDataBinder.this.messageClickListener;
            if (messageItemClickListener != null) {
                messageItemClickListener.retryMessage(getAdapterPosition());
            }
        }
    }

    public ScreenshotMessageViewDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder.ViewHolder r20, com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = r21.getFilePath()
            android.content.Context r4 = r0.context
            r5 = 16842808(0x1010038, float:2.3693715E-38)
            int r4 = com.helpshift.support.util.Styles.getColor(r4, r5)
            boolean r5 = com.helpshift.util.TextUtils.isEmpty(r3)
            r6 = 1
            r5 = r5 ^ r6
            r7 = 1056964608(0x3f000000, float:0.5)
            com.helpshift.conversation.activeconversation.message.UserMessageState r8 = r2.state
            int r8 = r8.ordinal()
            java.lang.String r9 = ""
            r11 = 0
            if (r8 == 0) goto L_0x00ae
            if (r8 == r6) goto L_0x0080
            r12 = 2
            if (r8 == r12) goto L_0x0067
            r12 = 3
            if (r8 == r12) goto L_0x0039
            r12 = r9
            r13 = r12
            r6 = 0
            r7 = 0
            r8 = 1056964608(0x3f000000, float:0.5)
            r9 = 0
            r14 = 0
            r15 = 0
            goto L_0x00d2
        L_0x0039:
            r7 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r8 = r21.getSubText()
            boolean r9 = com.helpshift.util.TextUtils.isEmpty(r3)
            r12 = r9 ^ 1
            android.content.Context r13 = r0.context
            int r14 = com.helpshift.C2466R.string.hs__user_sent_message_voice_over
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r15 = r21.getAccessbilityMessageTime()
            r6[r11] = r15
            java.lang.String r6 = r13.getString(r14, r6)
            android.content.Context r13 = r0.context
            int r14 = com.helpshift.C2466R.string.hs__image_downloaded_voice_over
            java.lang.String r13 = r13.getString(r14)
            r14 = r12
            r7 = 0
            r15 = 0
            r12 = r6
            r6 = r9
            r9 = r8
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00d2
        L_0x0067:
            android.content.Context r8 = r0.context
            android.content.res.Resources r8 = r8.getResources()
            int r12 = com.helpshift.C2466R.string.hs__sending_msg
            java.lang.String r8 = r8.getString(r12)
            android.content.Context r12 = r0.context
            int r13 = com.helpshift.C2466R.string.hs__user_sending_message_voice_over
            java.lang.String r12 = r12.getString(r13)
            r13 = r9
        L_0x007c:
            r7 = 0
            r14 = 0
            r15 = 0
            goto L_0x00cf
        L_0x0080:
            boolean r4 = r2.isRejected
            if (r4 == 0) goto L_0x008d
            android.content.Context r4 = r0.context
            int r6 = com.helpshift.C2466R.string.hs__file_type_unsupported
            java.lang.String r4 = r4.getString(r6)
            goto L_0x0099
        L_0x008d:
            android.content.Context r4 = r0.context
            android.content.res.Resources r4 = r4.getResources()
            int r6 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r4 = r4.getString(r6)
        L_0x0099:
            r8 = r4
            android.content.Context r4 = r0.context
            int r6 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r4 = com.helpshift.support.util.Styles.getColor(r4, r6)
            android.content.Context r6 = r0.context
            int r12 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r6 = r6.getString(r12)
            r12 = r6
            r13 = r9
            r6 = 0
            goto L_0x007c
        L_0x00ae:
            android.content.Context r4 = r0.context
            android.content.res.Resources r4 = r4.getResources()
            int r8 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r8 = r4.getString(r8)
            android.content.Context r4 = r0.context
            int r12 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r4 = com.helpshift.support.util.Styles.getColor(r4, r12)
            android.content.Context r12 = r0.context
            int r13 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r12 = r12.getString(r13)
            r15 = r1
            r13 = r9
            r6 = 0
            r7 = 1
            r14 = 0
        L_0x00cf:
            r9 = r8
            r8 = 1056964608(0x3f000000, float:0.5)
        L_0x00d2:
            com.helpshift.conversation.activeconversation.message.UIViewState r16 = r21.getUiViewState()
            com.helpshift.support.imageloader.ImageLoader r10 = com.helpshift.support.imageloader.ImageLoader.getInstance()
            com.helpshift.support.views.HSRoundedImageView r11 = r1.roundedImageView
            r17 = r13
            android.content.Context r13 = r0.context
            android.content.res.Resources r13 = r13.getResources()
            r18 = r12
            int r12 = com.helpshift.C2466R.C2467drawable.hs__placeholder_image
            android.graphics.drawable.Drawable r12 = r13.getDrawable(r12)
            r10.load(r3, r11, r12)
            com.helpshift.support.views.HSRoundedImageView r3 = r1.roundedImageView
            r3.setAlpha(r8)
            com.helpshift.support.views.HSRoundedImageView r3 = r1.roundedImageView
            r0.setViewVisibility(r3, r5)
            android.widget.TextView r3 = r1.subText
            r5 = 0
            r3.setVisibility(r5)
            boolean r3 = r16.isFooterVisible()
            if (r3 == 0) goto L_0x010f
            android.widget.TextView r3 = r1.subText
            r3.setText(r9)
            android.widget.TextView r3 = r1.subText
            r3.setTextColor(r4)
        L_0x010f:
            android.widget.TextView r3 = r1.subText
            boolean r4 = r16.isFooterVisible()
            r0.setViewVisibility(r3, r4)
            android.widget.ProgressBar r3 = r20.progress
            r0.setViewVisibility(r3, r6)
            android.widget.ImageView r3 = r1.retryButton
            r0.setViewVisibility(r3, r7)
            if (r7 == 0) goto L_0x012d
            android.widget.ImageView r3 = r1.retryButton
            r3.setOnClickListener(r15)
            r4 = 0
            goto L_0x0133
        L_0x012d:
            android.widget.ImageView r3 = r1.retryButton
            r4 = 0
            r3.setOnClickListener(r4)
        L_0x0133:
            if (r14 == 0) goto L_0x0140
            com.helpshift.support.views.HSRoundedImageView r3 = r1.roundedImageView
            com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder$1 r4 = new com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder$1
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            goto L_0x0145
        L_0x0140:
            com.helpshift.support.views.HSRoundedImageView r2 = r1.roundedImageView
            r2.setOnClickListener(r4)
        L_0x0145:
            android.view.View r2 = r1.messageLayout
            r6 = r18
            r2.setContentDescription(r6)
            com.helpshift.support.views.HSRoundedImageView r1 = r1.roundedImageView
            r9 = r17
            r1.setContentDescription(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder.bind(com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_screenshot_status, viewGroup, false));
    }
}
