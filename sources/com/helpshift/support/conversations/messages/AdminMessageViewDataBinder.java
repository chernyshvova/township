package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.util.HSLinkify;
import com.helpshift.util.StringUtils;
import com.helpshift.views.CircleImageView;

public class AdminMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, MessageDM> {

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        public final CircleImageView avatarImageView;
        public final TextView dateText;
        public final View messageContainer;
        public final View messageLayout;
        public final TextView messageText;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.admin_text_message_layout);
            this.messageText = (TextView) view.findViewById(C2466R.C2468id.admin_message_text);
            this.dateText = (TextView) view.findViewById(C2466R.C2468id.admin_date_text);
            this.messageContainer = view.findViewById(C2466R.C2468id.admin_message_container);
            this.avatarImageView = (CircleImageView) view.findViewById(C2466R.C2468id.avatar_image_view);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (AdminMessageViewDataBinder.this.messageClickListener != null) {
                AdminMessageViewDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, ((TextView) view).getText().toString());
            }
        }

        public void setListeners() {
            this.messageText.setOnCreateContextMenuListener(this);
        }
    }

    public AdminMessageViewDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, final MessageDM messageDM) {
        if (StringUtils.isEmpty(messageDM.body)) {
            viewHolder.messageLayout.setVisibility(8);
            return;
        }
        viewHolder.messageLayout.setVisibility(0);
        viewHolder.messageText.setText(escapeHtml(messageDM.body));
        UIViewState uiViewState = messageDM.getUiViewState();
        setAdminMessageContainerBackground(viewHolder.messageContainer, uiViewState);
        setAdminMessageSubText(viewHolder.dateText, uiViewState, messageDM.getSubText());
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(messageDM));
        linkify(viewHolder.messageText, new HSLinkify.LinkClickListener() {
            public void onLinkClickFailed() {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminMessageViewDataBinder.this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.onAdminMessageLinkClickFailed();
                }
            }

            public void onLinkClicked(String str) {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener = AdminMessageViewDataBinder.this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.onAdminMessageLinkClicked(str, messageDM);
                }
            }
        });
        setAuthorAvatar(messageDM, viewHolder.avatarImageView);
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_txt_admin, viewGroup, false));
        viewHolder.setListeners();
        return viewHolder;
    }
}
