package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.util.HSLinkify;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import com.helpshift.views.CircleImageView;

public class AdminSuggestionsMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, FAQListMessageDM> {

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final CircleImageView avatarImageView;
        public final TextView dateText;
        public final View messageContainer;
        public final View messageLayout;
        public final TextView messageText;
        public final TableLayout suggestionsList;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.admin_suggestion_message_layout);
            this.suggestionsList = (TableLayout) view.findViewById(C2466R.C2468id.suggestionsListStub);
            this.messageText = (TextView) view.findViewById(C2466R.C2468id.admin_message_text);
            this.messageContainer = view.findViewById(C2466R.C2468id.admin_message_container);
            this.dateText = (TextView) view.findViewById(C2466R.C2468id.admin_date_text);
            this.avatarImageView = (CircleImageView) view.findViewById(C2466R.C2468id.avatar_image_view);
        }
    }

    public AdminSuggestionsMessageViewDataBinder(Context context) {
        super(context);
    }

    private void bindAdminMessage(ViewHolder viewHolder, final MessageDM messageDM) {
        if (StringUtils.isEmpty(messageDM.body)) {
            viewHolder.messageContainer.setVisibility(8);
            return;
        }
        viewHolder.messageContainer.setVisibility(0);
        viewHolder.messageText.setText(escapeHtml(messageDM.body));
        setDrawable(viewHolder.messageContainer, messageDM.getUiViewState().isRoundedBackground() ? C2466R.C2467drawable.hs__chat_bubble_rounded : C2466R.C2467drawable.hs__chat_bubble_admin, C2466R.attr.hs__chatBubbleAdminBackgroundColor);
        viewHolder.messageContainer.setContentDescription(getAdminMessageContentDesciption(messageDM));
        linkify(viewHolder.messageText, new HSLinkify.LinkClickListener() {
            public void onLinkClickFailed() {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminSuggestionsMessageViewDataBinder.this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.onAdminMessageLinkClickFailed();
                }
            }

            public void onLinkClicked(String str) {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminSuggestionsMessageViewDataBinder.this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.onAdminMessageLinkClicked(str, messageDM);
                }
            }
        });
        setAuthorAvatar(messageDM, viewHolder.avatarImageView);
    }

    public void bind(ViewHolder viewHolder, final FAQListMessageDM fAQListMessageDM) {
        bindAdminMessage(viewHolder, fAQListMessageDM);
        viewHolder.suggestionsList.removeAllViews();
        TableRow tableRow = null;
        for (final FAQListMessageDM.FAQ next : fAQListMessageDM.faqs) {
            View inflate = LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_admin_suggesstion_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2466R.C2468id.admin_suggestion_message);
            textView.setText(next.title);
            Styles.setColorFilter(this.context, textView.getCompoundDrawablesRelative()[2], C2466R.attr.hs__adminFaqSuggestionArrowColor);
            TableRow tableRow2 = new TableRow(this.context);
            tableRow2.addView(inflate);
            View inflate2 = LayoutInflater.from(this.context).inflate(C2466R.layout.hs__section_divider, (ViewGroup) null);
            inflate2.findViewById(C2466R.C2468id.divider).setBackgroundColor(Styles.getColor(this.context, C2466R.attr.hs__contentSeparatorColor));
            TableRow tableRow3 = new TableRow(this.context);
            tableRow3.addView(inflate2);
            viewHolder.suggestionsList.addView(tableRow2);
            viewHolder.suggestionsList.addView(tableRow3);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminSuggestionsMessageViewDataBinder.this.messageClickListener;
                    FAQListMessageDM fAQListMessageDM = fAQListMessageDM;
                    FAQListMessageDM.FAQ faq = next;
                    messageItemClickListener.onAdminSuggestedQuestionSelected(fAQListMessageDM, faq.publishId, faq.language);
                }
            });
            tableRow = tableRow3;
        }
        viewHolder.suggestionsList.removeView(tableRow);
        UIViewState uiViewState = fAQListMessageDM.getUiViewState();
        setViewVisibility(viewHolder.dateText, uiViewState.isFooterVisible());
        if (uiViewState.isFooterVisible()) {
            viewHolder.dateText.setText(fAQListMessageDM.getSubText());
        }
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(fAQListMessageDM));
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_admin_suggesstions_container, viewGroup, false));
    }
}
