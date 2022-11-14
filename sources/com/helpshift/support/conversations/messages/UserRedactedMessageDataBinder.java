package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.util.HSLinkify;

public class UserRedactedMessageDataBinder extends MessageViewDataBinder<ViewHolder, MessageDM> {

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        public final FrameLayout messageBubble;
        public final View messageLayout;
        public final TextView messageText;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.messageText = (TextView) view.findViewById(C2466R.C2468id.user_message_text);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.user_date_text);
            this.messageBubble = (FrameLayout) view.findViewById(C2466R.C2468id.user_message_container);
            this.messageLayout = view.findViewById(C2466R.C2468id.user_text_message_layout);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (UserRedactedMessageDataBinder.this.messageClickListener != null) {
                UserRedactedMessageDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, ((TextView) view).getText().toString());
            }
        }

        public void setListeners() {
            this.messageText.setOnCreateContextMenuListener(this);
        }
    }

    public UserRedactedMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, MessageDM messageDM) {
        viewHolder.messageText.setText(getRedactedBodyText(escapeHtml(messageDM.body)));
        applyRedactionStyle(viewHolder.messageText);
        viewHolder.messageLayout.setContentDescription(this.context.getString(C2466R.string.hs__user_sent_message_voice_over, new Object[]{messageDM.getAccessbilityMessageTime()}));
        linkify(viewHolder.messageText, (HSLinkify.LinkClickListener) null);
        UIViewState uiViewState = messageDM.getUiViewState();
        setUserMessageContainerBackground(viewHolder.messageBubble, uiViewState);
        setUserMessageSubText(viewHolder.subText, uiViewState, messageDM.getSubText());
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_txt_user, viewGroup, false));
        setUserMessageLayoutMargin(viewHolder.messageBubble.getLayoutParams());
        viewHolder.setListeners();
        return viewHolder;
    }
}
