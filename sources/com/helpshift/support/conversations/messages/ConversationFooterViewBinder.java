package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.widget.CSATView;

public class ConversationFooterViewBinder {
    public Context context;
    public ConversationFooterClickListener footerClickListener;

    /* renamed from: com.helpshift.support.conversations.messages.ConversationFooterViewBinder$1 */
    public static /* synthetic */ class C27651 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$ConversationFooterState */
        public static final /* synthetic */ int[] f3358xbfca5416;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0039 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.ConversationFooterState[] r0 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3358xbfca5416 = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r2 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.NONE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r3 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.CONVERSATION_ENDED_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r3 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.START_NEW_CONVERSATION     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r3 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.CSAT_RATING     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x002b }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r3 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.ARCHIVAL_MESSAGE     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r3 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.AUTHOR_MISMATCH     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r1 = 7
                int[] r2 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r3 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.REJECTED_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r0 = f3358xbfca5416     // Catch:{ NoSuchFieldError -> 0x0041 }
                com.helpshift.conversation.activeconversation.message.ConversationFooterState r2 = com.helpshift.conversation.activeconversation.message.ConversationFooterState.REDACTED_STATE     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.ConversationFooterViewBinder.C27651.<clinit>():void");
        }
    }

    public interface ConversationFooterClickListener {
        void onCSATSurveyCancelled();

        void onCSATSurveyStarted();

        void onCSATSurveySubmitted(int i, String str);

        void onStartNewConversationButtonClick();
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CSATView.CSATListener {
        public final View conversationFooter;
        public final CSATView csatView;
        public final TextView footerMessage;
        public final LinearLayout newConversationBox;
        public final Button newConversationButton;
        public final TextView newConversationReason;

        public ViewHolder(View view) {
            super(view);
            this.conversationFooter = view;
            this.footerMessage = (TextView) view.findViewById(C2466R.C2468id.footer_message);
            this.newConversationBox = (LinearLayout) view.findViewById(C2466R.C2468id.hs__new_conversation);
            this.newConversationButton = (Button) view.findViewById(C2466R.C2468id.hs__new_conversation_btn);
            this.csatView = (CSATView) view.findViewById(C2466R.C2468id.csat_view_layout);
            this.newConversationReason = (TextView) view.findViewById(C2466R.C2468id.hs__new_conversation_footer_reason);
        }

        public void onCSATSurveyCancelled() {
            ConversationFooterClickListener conversationFooterClickListener = ConversationFooterViewBinder.this.footerClickListener;
            if (conversationFooterClickListener != null) {
                conversationFooterClickListener.onCSATSurveyCancelled();
            }
        }

        public void onCSATSurveyStarted() {
            ConversationFooterClickListener conversationFooterClickListener = ConversationFooterViewBinder.this.footerClickListener;
            if (conversationFooterClickListener != null) {
                conversationFooterClickListener.onCSATSurveyStarted();
            }
        }

        public void onClick(View view) {
            ConversationFooterClickListener conversationFooterClickListener = ConversationFooterViewBinder.this.footerClickListener;
            if (conversationFooterClickListener != null) {
                conversationFooterClickListener.onStartNewConversationButtonClick();
            }
        }

        public void sendCSATSurvey(int i, String str) {
            ConversationFooterClickListener conversationFooterClickListener = ConversationFooterViewBinder.this.footerClickListener;
            if (conversationFooterClickListener != null) {
                conversationFooterClickListener.onCSATSurveySubmitted(i, str);
            }
        }
    }

    public ConversationFooterViewBinder(Context context2) {
        this.context = context2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        if (r1 == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        r9.conversationFooter.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r10 == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r9.footerMessage.setText(r0);
        r9.footerMessage.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r9.footerMessage.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r3 == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        r9.newConversationBox.setVisibility(0);
        r9.newConversationButton.setOnClickListener(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        r9.newConversationBox.setVisibility(8);
        r9.newConversationBox.setOnClickListener((android.view.View.OnClickListener) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        if (r4 == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        r9.csatView.setVisibility(0);
        r9.csatView.setCSATListener(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r9.csatView.hideCSATDialog();
        r9.csatView.setVisibility(8);
        r9.csatView.setCSATListener((com.helpshift.support.widget.CSATView.CSATListener) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a7, code lost:
        if (r5 == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a9, code lost:
        r9.newConversationReason.setVisibility(0);
        r9.newConversationReason.setText(com.helpshift.C2466R.string.hs__issue_archival_message);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b6, code lost:
        if (r6 == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        r9.newConversationReason.setVisibility(0);
        r9.newConversationReason.setText(com.helpshift.C2466R.string.hs__new_conversation_footer_generic_reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c5, code lost:
        r9.newConversationReason.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
        r9.conversationFooter.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        r6 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.ConversationFooterViewBinder.ViewHolder r9, com.helpshift.conversation.activeconversation.message.ConversationFooterState r10) {
        /*
            r8 = this;
            android.content.Context r0 = r8.context
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.helpshift.C2466R.string.hs__conversation_end_msg
            java.lang.String r0 = r0.getString(r1)
            int r10 = r10.ordinal()
            r1 = 1
            r2 = 0
            switch(r10) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0048;
                case 2: goto L_0x0045;
                case 3: goto L_0x0035;
                case 4: goto L_0x0030;
                case 5: goto L_0x002a;
                case 6: goto L_0x001d;
                case 7: goto L_0x001b;
                default: goto L_0x0015;
            }
        L_0x0015:
            r10 = 1
        L_0x0016:
            r3 = 0
        L_0x0017:
            r4 = 0
        L_0x0018:
            r5 = 0
        L_0x0019:
            r6 = 0
            goto L_0x0058
        L_0x001b:
            r10 = 0
            goto L_0x0046
        L_0x001d:
            android.content.Context r10 = r8.context
            android.content.res.Resources r10 = r10.getResources()
            int r0 = com.helpshift.C2466R.string.hs__conversation_rejected_status
            java.lang.String r0 = r10.getString(r0)
            goto L_0x0045
        L_0x002a:
            r10 = 0
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 1
            goto L_0x0058
        L_0x0030:
            r10 = 0
            r3 = 1
            r4 = 0
            r5 = 1
            goto L_0x0019
        L_0x0035:
            android.content.Context r10 = r8.context
            android.content.res.Resources r10 = r10.getResources()
            int r0 = com.helpshift.C2466R.string.hs__confirmation_footer_msg
            java.lang.String r0 = r10.getString(r0)
            r10 = 1
            r3 = 1
            r4 = 1
            goto L_0x0018
        L_0x0045:
            r10 = 1
        L_0x0046:
            r3 = 1
            goto L_0x0017
        L_0x0048:
            android.content.Context r10 = r8.context
            android.content.res.Resources r10 = r10.getResources()
            int r0 = com.helpshift.C2466R.string.hs__confirmation_footer_msg
            java.lang.String r0 = r10.getString(r0)
            goto L_0x0015
        L_0x0055:
            r10 = 0
            r1 = 0
            goto L_0x0016
        L_0x0058:
            r7 = 8
            if (r1 == 0) goto L_0x00cb
            android.view.View r1 = r9.conversationFooter
            r1.setVisibility(r2)
            if (r10 == 0) goto L_0x006e
            android.widget.TextView r10 = r9.footerMessage
            r10.setText(r0)
            android.widget.TextView r10 = r9.footerMessage
            r10.setVisibility(r2)
            goto L_0x0073
        L_0x006e:
            android.widget.TextView r10 = r9.footerMessage
            r10.setVisibility(r7)
        L_0x0073:
            r10 = 0
            if (r3 == 0) goto L_0x0081
            android.widget.LinearLayout r0 = r9.newConversationBox
            r0.setVisibility(r2)
            android.widget.Button r0 = r9.newConversationButton
            r0.setOnClickListener(r9)
            goto L_0x008b
        L_0x0081:
            android.widget.LinearLayout r0 = r9.newConversationBox
            r0.setVisibility(r7)
            android.widget.LinearLayout r0 = r9.newConversationBox
            r0.setOnClickListener(r10)
        L_0x008b:
            if (r4 == 0) goto L_0x0098
            com.helpshift.support.widget.CSATView r10 = r9.csatView
            r10.setVisibility(r2)
            com.helpshift.support.widget.CSATView r10 = r9.csatView
            r10.setCSATListener(r9)
            goto L_0x00a7
        L_0x0098:
            com.helpshift.support.widget.CSATView r0 = r9.csatView
            r0.hideCSATDialog()
            com.helpshift.support.widget.CSATView r0 = r9.csatView
            r0.setVisibility(r7)
            com.helpshift.support.widget.CSATView r0 = r9.csatView
            r0.setCSATListener(r10)
        L_0x00a7:
            if (r5 == 0) goto L_0x00b6
            android.widget.TextView r10 = r9.newConversationReason
            r10.setVisibility(r2)
            android.widget.TextView r9 = r9.newConversationReason
            int r10 = com.helpshift.C2466R.string.hs__issue_archival_message
            r9.setText(r10)
            goto L_0x00d0
        L_0x00b6:
            if (r6 == 0) goto L_0x00c5
            android.widget.TextView r10 = r9.newConversationReason
            r10.setVisibility(r2)
            android.widget.TextView r9 = r9.newConversationReason
            int r10 = com.helpshift.C2466R.string.hs__new_conversation_footer_generic_reason
            r9.setText(r10)
            goto L_0x00d0
        L_0x00c5:
            android.widget.TextView r9 = r9.newConversationReason
            r9.setVisibility(r7)
            goto L_0x00d0
        L_0x00cb:
            android.view.View r9 = r9.conversationFooter
            r9.setVisibility(r7)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.ConversationFooterViewBinder.bind(com.helpshift.support.conversations.messages.ConversationFooterViewBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.ConversationFooterState):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__messages_list_footer, viewGroup, false));
    }

    public void setConversationFooterClickListener(ConversationFooterClickListener conversationFooterClickListener) {
        this.footerClickListener = conversationFooterClickListener;
    }
}
