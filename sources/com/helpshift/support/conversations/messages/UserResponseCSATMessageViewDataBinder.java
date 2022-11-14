package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;

public class UserResponseCSATMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, UserResponseMessageForCSATInput> {

    /* renamed from: com.helpshift.support.conversations.messages.UserResponseCSATMessageViewDataBinder$1 */
    public static /* synthetic */ class C27761 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$UserMessageState */
        public static final /* synthetic */ int[] f3364x57a590b2;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.UserMessageState[] r0 = com.helpshift.conversation.activeconversation.message.UserMessageState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3364x57a590b2 = r0
                com.helpshift.conversation.activeconversation.message.UserMessageState r1 = com.helpshift.conversation.activeconversation.message.UserMessageState.UNSENT_NOT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f3364x57a590b2     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.UserMessageState r2 = com.helpshift.conversation.activeconversation.message.UserMessageState.UNSENT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3364x57a590b2     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.UserMessageState r3 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENDING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3364x57a590b2     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.UserMessageState r2 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENT     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.UserResponseCSATMessageViewDataBinder.C27761.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, View.OnClickListener {
        public final RelativeLayout messageBubble;
        public final View messageLayout;
        public final TextView messageText;
        public final RatingBar ratingBar;
        public final ImageView retryButton;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.ratingBar = (RatingBar) view.findViewById(C2466R.C2468id.csat_selected_rating);
            this.messageText = (TextView) view.findViewById(C2466R.C2468id.user_message_text);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.user_date_text);
            this.messageBubble = (RelativeLayout) view.findViewById(C2466R.C2468id.user_message_container);
            this.retryButton = (ImageView) view.findViewById(C2466R.C2468id.user_message_retry_button);
            this.messageLayout = view.findViewById(C2466R.C2468id.user_csat_rsp_message_layout);
        }

        public void onClick(View view) {
            MessageViewDataBinder.MessageItemClickListener messageItemClickListener = UserResponseCSATMessageViewDataBinder.this.messageClickListener;
            if (messageItemClickListener != null) {
                messageItemClickListener.retryMessage(getAdapterPosition());
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (UserResponseCSATMessageViewDataBinder.this.messageClickListener != null) {
                UserResponseCSATMessageViewDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, ((TextView) view).getText().toString());
            }
        }

        public void setListeners() {
            this.messageText.setOnCreateContextMenuListener(this);
        }
    }

    public UserResponseCSATMessageViewDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.UserResponseCSATMessageViewDataBinder.ViewHolder r10, com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput r11) {
        /*
            r9 = this;
            com.helpshift.conversation.activeconversation.message.UserMessageState r0 = r11.getState()
            android.widget.TextView r1 = r10.messageText
            java.lang.String r2 = r11.body
            java.lang.String r2 = r9.escapeHtml(r2)
            r1.setText(r2)
            android.content.Context r1 = r9.context
            r2 = 16842808(0x1010038, float:2.3693715E-38)
            int r1 = com.helpshift.util.Styles.getColor(r1, r2)
            int r0 = r0.ordinal()
            java.lang.String r2 = ""
            r3 = 1
            r4 = 0
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x007d
            if (r0 == r3) goto L_0x005e
            r6 = 2
            if (r0 == r6) goto L_0x004b
            r6 = 3
            if (r0 == r6) goto L_0x0031
            r0 = r2
            r5 = 1
            r6 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0098
        L_0x0031:
            java.lang.String r2 = r11.getSubText()
            android.content.Context r0 = r9.context
            int r5 = com.helpshift.C2466R.string.hs__user_sent_message_voice_over
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.String r7 = r11.getAccessbilityMessageTime()
            r6[r4] = r7
            java.lang.String r0 = r0.getString(r5, r6)
            r5 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0079
        L_0x004b:
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__sending_msg
            java.lang.String r2 = r0.getString(r2)
            android.content.Context r0 = r9.context
            int r3 = com.helpshift.C2466R.string.hs__user_sending_message_voice_over
            java.lang.String r0 = r0.getString(r3)
            r3 = 0
            r5 = 0
            goto L_0x0077
        L_0x005e:
            android.content.Context r0 = r9.context
            int r1 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r2 = r0.getString(r1)
            android.content.Context r0 = r9.context
            int r1 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r0 = r0.getString(r1)
            android.content.Context r1 = r9.context
            int r6 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r1 = com.helpshift.util.Styles.getColor(r1, r6)
        L_0x0076:
            r5 = 1
        L_0x0077:
            r6 = 1056964608(0x3f000000, float:0.5)
        L_0x0079:
            r8 = r2
            r2 = r0
            r0 = r8
            goto L_0x0098
        L_0x007d:
            android.content.Context r0 = r9.context
            int r1 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r2 = r0.getString(r1)
            android.content.Context r0 = r9.context
            int r1 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r0 = r0.getString(r1)
            android.content.Context r1 = r9.context
            int r6 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r1 = com.helpshift.util.Styles.getColor(r1, r6)
            r3 = 0
            r4 = 1
            goto L_0x0076
        L_0x0098:
            android.view.View r7 = r10.messageLayout
            r7.setContentDescription(r2)
            android.widget.TextView r2 = r10.subText
            r2.setTextColor(r1)
            android.widget.RelativeLayout r1 = r10.messageBubble
            r1.setAlpha(r6)
            r1 = 0
            if (r3 == 0) goto L_0x00af
            android.widget.TextView r2 = r10.messageText
            r9.linkify(r2, r1)
        L_0x00af:
            android.widget.TextView r2 = r10.messageText
            r2.setEnabled(r5)
            android.widget.ImageView r2 = r10.retryButton
            r9.setViewVisibility(r2, r4)
            com.helpshift.conversation.activeconversation.message.UIViewState r2 = r11.getUiViewState()
            android.widget.RelativeLayout r3 = r10.messageBubble
            r9.setUserMessageContainerBackground(r3, r2)
            android.widget.TextView r3 = r10.subText
            r9.setUserMessageSubText(r3, r2, r0)
            if (r4 == 0) goto L_0x00cf
            android.widget.ImageView r0 = r10.retryButton
            r0.setOnClickListener(r10)
            goto L_0x00d4
        L_0x00cf:
            android.widget.ImageView r0 = r10.retryButton
            r0.setOnClickListener(r1)
        L_0x00d4:
            android.content.Context r0 = r9.context
            android.widget.RatingBar r1 = r10.ratingBar
            android.graphics.drawable.Drawable r1 = r1.getProgressDrawable()
            int r2 = com.helpshift.C2466R.attr.hs__chatBubbleUserText
            com.helpshift.util.Styles.setColorFilter(r0, r1, r2)
            android.widget.RatingBar r10 = r10.ratingBar
            int r11 = r11.rating
            float r11 = (float) r11
            r10.setRating(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.UserResponseCSATMessageViewDataBinder.bind(com.helpshift.support.conversations.messages.UserResponseCSATMessageViewDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_csat_user_rsp, viewGroup, false));
        setUserMessageLayoutMargin(viewHolder.messageBubble.getLayoutParams());
        viewHolder.setListeners();
        return viewHolder;
    }
}
