package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.input.CSATRatingsInput;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.support.widget.AdminCSATBotView;
import com.helpshift.util.Styles;
import com.helpshift.views.HSButton;
import com.helpshift.views.HSTextView;
import java.util.Iterator;
import java.util.List;

public class AdminCSATMessageViewBinder extends MessageViewDataBinder<ViewHolder, AdminCSATMessageWithOptions> {
    public final Context context;
    public String lastMessageId = "";

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout bottomDividerLayout;
        public final HSTextView csatBotDislikeText;
        public final HSTextView csatBotLikedText;
        public final HSTextView csatBotSelectedRatingText;
        public final HSTextView csatMessageText;
        public final AdminCSATBotView csatView;
        public final HSButton newConversationButton;
        public final HSButton sendFeedbackButton;

        public ViewHolder(View view) {
            super(view);
            this.csatView = (AdminCSATBotView) view.findViewById(C2466R.C2468id.admin_csat_view_layout);
            this.newConversationButton = (HSButton) view.findViewById(C2466R.C2468id.hs__csat_new_conversation_btn);
            this.sendFeedbackButton = (HSButton) view.findViewById(C2466R.C2468id.csat_sendfeedback_btn);
            this.csatMessageText = (HSTextView) view.findViewById(C2466R.C2468id.csat_bot_message);
            this.csatBotDislikeText = (HSTextView) view.findViewById(C2466R.C2468id.csat_bot_dislike_msg);
            this.csatBotLikedText = (HSTextView) view.findViewById(C2466R.C2468id.csat_bot_like_msg);
            this.csatBotSelectedRatingText = (HSTextView) view.findViewById(C2466R.C2468id.csat_selected_rating_msg);
            this.bottomDividerLayout = (LinearLayout) view.findViewById(C2466R.C2468id.csat_bottom_separator);
            setBorderToNewConversationButton(this.sendFeedbackButton);
        }

        private void setBorderToNewConversationButton(Button button) {
            GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(AdminCSATMessageViewBinder.this.context, C2466R.C2467drawable.hs__button_with_border);
            if (gradientDrawable != null) {
                gradientDrawable.setStroke((int) Styles.dpToPx(AdminCSATMessageViewBinder.this.context, 1.0f), Styles.getColor(AdminCSATMessageViewBinder.this.context, C2466R.attr.colorAccent));
                gradientDrawable.setColor(Styles.getColor(AdminCSATMessageViewBinder.this.context, C2466R.attr.hs__footerPromptBackground));
                int dpToPx = (int) Styles.dpToPx(AdminCSATMessageViewBinder.this.context, 4.0f);
                int dpToPx2 = (int) Styles.dpToPx(AdminCSATMessageViewBinder.this.context, 6.0f);
                button.setBackground(new InsetDrawable(gradientDrawable, dpToPx, dpToPx2, dpToPx, dpToPx2));
            }
        }
    }

    public AdminCSATMessageViewBinder(Context context2) {
        super(context2);
        this.context = context2;
    }

    public void bind(final ViewHolder viewHolder, final AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        if (!this.lastMessageId.equals(adminCSATMessageWithOptions.serverId)) {
            this.lastMessageId = adminCSATMessageWithOptions.serverId;
            viewHolder.csatView.reset();
            viewHolder.csatBotLikedText.setVisibility(0);
            viewHolder.csatBotDislikeText.setVisibility(0);
            viewHolder.csatBotSelectedRatingText.setVisibility(8);
            viewHolder.csatMessageText.setText(adminCSATMessageWithOptions.body);
            final CSATRatingsInput cSATRatingsInput = adminCSATMessageWithOptions.csatRatingsInput;
            List<CSATRatingsInput.Rating> list = cSATRatingsInput.ratings;
            int size = list.size();
            if (size > 0) {
                String str = list.get(0).title;
                String str2 = list.get(size - 1).title;
                viewHolder.csatBotDislikeText.setText(str);
                viewHolder.csatBotLikedText.setText(str2);
            }
            viewHolder.sendFeedbackButton.setText(cSATRatingsInput.sendFeedbackLabel);
            viewHolder.newConversationButton.setText(cSATRatingsInput.startNewConversationLabel);
            viewHolder.csatView.setAdminCSATBotListener(new AdminCSATBotView.AdminCSATBotViewListener() {
                public void onCSATSurveyRequested() {
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminCSATMessageViewBinder.this.messageClickListener;
                    if (messageItemClickListener != null) {
                        messageItemClickListener.onCSATSurveyRequestedFromBot(adminCSATMessageWithOptions.serverId);
                    }
                }

                public void onRatingChanged(int i) {
                    viewHolder.sendFeedbackButton.setVisibility(0);
                    viewHolder.csatBotLikedText.setVisibility(8);
                    viewHolder.csatBotDislikeText.setVisibility(8);
                    Iterator<CSATRatingsInput.Rating> it = cSATRatingsInput.ratings.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CSATRatingsInput.Rating next = it.next();
                        if (i == next.value) {
                            viewHolder.csatBotSelectedRatingText.setText(next.title);
                            break;
                        }
                    }
                    viewHolder.csatBotSelectedRatingText.setVisibility(0);
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminCSATMessageViewBinder.this.messageClickListener;
                    if (messageItemClickListener != null) {
                        messageItemClickListener.onCSATSurveyStartedFromBot(adminCSATMessageWithOptions.serverId);
                    }
                }

                public void sendCSATSurvey(int i) {
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminCSATMessageViewBinder.this.messageClickListener;
                    if (messageItemClickListener != null) {
                        messageItemClickListener.onSendFeedbackClick(i, adminCSATMessageWithOptions);
                    }
                }
            });
            viewHolder.newConversationButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminCSATMessageViewBinder.this.messageClickListener;
                    if (messageItemClickListener != null) {
                        messageItemClickListener.onStartNewConversationButtonClickFromCSATBot(adminCSATMessageWithOptions);
                    }
                }
            });
            if (!adminCSATMessageWithOptions.csatRatingsInput.showNewConversationButton) {
                viewHolder.bottomDividerLayout.setVisibility(8);
                viewHolder.newConversationButton.setVisibility(8);
            }
        }
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__admin_csat_message, viewGroup, false));
    }
}
