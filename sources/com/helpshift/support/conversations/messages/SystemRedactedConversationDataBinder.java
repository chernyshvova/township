package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM;

public class SystemRedactedConversationDataBinder extends MessageViewDataBinder<ViewHolder, SystemRedactedConversationMessageDM> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView redactedTextView;

        public ViewHolder(View view) {
            super(view);
            this.redactedTextView = (TextView) view.findViewById(C2466R.C2468id.conversation_redacted_view);
        }
    }

    public SystemRedactedConversationDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, SystemRedactedConversationMessageDM systemRedactedConversationMessageDM) {
        String str;
        int i = systemRedactedConversationMessageDM.contiguousRedactedConversationsCount;
        if (i > 1) {
            str = this.context.getString(C2466R.string.hs__conversation_redacted_status_multiple, new Object[]{Integer.valueOf(i)});
        } else {
            str = this.context.getString(C2466R.string.hs__conversation_redacted_status);
        }
        viewHolder.redactedTextView.setText(str);
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_system_conversation_redacted_layout, viewGroup, false));
    }
}
