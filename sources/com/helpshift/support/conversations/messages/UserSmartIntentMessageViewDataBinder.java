package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;

public class UserSmartIntentMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, UserSmartIntentMessageDM> {

    /* renamed from: com.helpshift.support.conversations.messages.UserSmartIntentMessageViewDataBinder$1 */
    public static /* synthetic */ class C27781 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$UserMessageState */
        public static final /* synthetic */ int[] f3365x57a590b2;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.UserMessageState[] r0 = com.helpshift.conversation.activeconversation.message.UserMessageState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3365x57a590b2 = r0
                com.helpshift.conversation.activeconversation.message.UserMessageState r1 = com.helpshift.conversation.activeconversation.message.UserMessageState.UNSENT_NOT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f3365x57a590b2     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.UserMessageState r2 = com.helpshift.conversation.activeconversation.message.UserMessageState.UNSENT_RETRYABLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3365x57a590b2     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.UserMessageState r3 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENDING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3365x57a590b2     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.UserMessageState r2 = com.helpshift.conversation.activeconversation.message.UserMessageState.SENT     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.UserSmartIntentMessageViewDataBinder.C27781.<clinit>():void");
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, View.OnClickListener {
        public final TextView leafLabelText;
        public final FrameLayout messageBubble;
        public final View messageLayout;
        public final ImageView retryButton;
        public final TextView rootLabelText;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.rootLabelText = (TextView) view.findViewById(C2466R.C2468id.smart_intent_root_label);
            this.leafLabelText = (TextView) view.findViewById(C2466R.C2468id.smart_intent_leaf_label);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.user_date_text);
            this.messageBubble = (FrameLayout) view.findViewById(C2466R.C2468id.user_message_container);
            this.retryButton = (ImageView) view.findViewById(C2466R.C2468id.user_message_retry_button);
            this.messageLayout = view.findViewById(C2466R.C2468id.smart_intent_user_message_layout);
        }

        public void onClick(View view) {
            MessageViewDataBinder.MessageItemClickListener messageItemClickListener = UserSmartIntentMessageViewDataBinder.this.messageClickListener;
            if (messageItemClickListener != null) {
                messageItemClickListener.retryMessage(getAdapterPosition());
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (UserSmartIntentMessageViewDataBinder.this.messageClickListener != null) {
                UserSmartIntentMessageViewDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, this.rootLabelText.getText() + " " + this.leafLabelText.getText());
            }
        }

        public void setListeners() {
            this.messageLayout.setOnCreateContextMenuListener(this);
        }
    }

    public UserSmartIntentMessageViewDataBinder(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.UserSmartIntentMessageViewDataBinder.ViewHolder r10, com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM r11) {
        /*
            r9 = this;
            com.helpshift.conversation.activeconversation.message.UserMessageState r0 = r11.getState()
            java.util.List<java.lang.String> r1 = r11.intentLabels
            int r1 = r1.size()
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 < r2) goto L_0x0029
            android.widget.TextView r1 = r10.rootLabelText
            java.util.List<java.lang.String> r5 = r11.intentLabels
            java.lang.Object r5 = r5.get(r3)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.TextView r1 = r10.leafLabelText
            java.util.List<java.lang.String> r5 = r11.intentLabels
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x0029:
            r1 = 1056964608(0x3f000000, float:0.5)
            android.content.Context r5 = r9.context
            r6 = 16842808(0x1010038, float:2.3693715E-38)
            int r5 = com.helpshift.util.Styles.getColor(r5, r6)
            int r0 = r0.ordinal()
            java.lang.String r6 = ""
            if (r0 == 0) goto L_0x008d
            if (r0 == r4) goto L_0x006f
            if (r0 == r2) goto L_0x005e
            r2 = 3
            if (r0 == r2) goto L_0x0047
            r0 = r6
            r3 = 1
            r4 = 0
            goto L_0x00a7
        L_0x0047:
            java.lang.String r6 = r11.getSubText()
            android.content.Context r0 = r9.context
            int r1 = com.helpshift.C2466R.string.hs__user_sent_message_voice_over
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r7 = r11.getAccessbilityMessageTime()
            r2[r3] = r7
            java.lang.String r0 = r0.getString(r1, r2)
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0087
        L_0x005e:
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__sending_msg
            java.lang.String r6 = r0.getString(r2)
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__user_sending_message_voice_over
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0088
        L_0x006f:
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r6 = r0.getString(r2)
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r0 = r0.getString(r2)
            android.content.Context r2 = r9.context
            int r5 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r5 = com.helpshift.util.Styles.getColor(r2, r5)
        L_0x0087:
            r3 = 1
        L_0x0088:
            r4 = 0
        L_0x0089:
            r8 = r6
            r6 = r0
            r0 = r8
            goto L_0x00a7
        L_0x008d:
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__sending_fail_msg
            java.lang.String r6 = r0.getString(r2)
            android.content.Context r0 = r9.context
            int r2 = com.helpshift.C2466R.string.hs__user_failed_message_voice_over
            java.lang.String r0 = r0.getString(r2)
            android.content.Context r2 = r9.context
            int r3 = com.helpshift.C2466R.attr.hs__errorTextColor
            int r5 = com.helpshift.util.Styles.getColor(r2, r3)
            r3 = 1
            goto L_0x0089
        L_0x00a7:
            android.view.View r2 = r10.messageLayout
            r2.setContentDescription(r6)
            android.widget.TextView r2 = r10.subText
            r2.setTextColor(r5)
            android.widget.FrameLayout r2 = r10.messageBubble
            r2.setAlpha(r1)
            android.widget.TextView r1 = r10.rootLabelText
            r1.setEnabled(r3)
            android.widget.TextView r1 = r10.leafLabelText
            r1.setEnabled(r3)
            android.widget.ImageView r1 = r10.retryButton
            r9.setViewVisibility(r1, r4)
            com.helpshift.conversation.activeconversation.message.UIViewState r11 = r11.getUiViewState()
            android.widget.FrameLayout r1 = r10.messageBubble
            r9.setUserMessageContainerBackground(r1, r11)
            android.widget.TextView r1 = r10.subText
            r9.setUserMessageSubText(r1, r11, r0)
            if (r4 == 0) goto L_0x00db
            android.widget.ImageView r11 = r10.retryButton
            r11.setOnClickListener(r10)
            goto L_0x00e1
        L_0x00db:
            android.widget.ImageView r10 = r10.retryButton
            r11 = 0
            r10.setOnClickListener(r11)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.UserSmartIntentMessageViewDataBinder.bind(com.helpshift.support.conversations.messages.UserSmartIntentMessageViewDataBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_smart_intent_txt_user, viewGroup, false));
        setUserMessageLayoutMargin(viewHolder.messageBubble.getLayoutParams());
        viewHolder.setListeners();
        return viewHolder;
    }
}
