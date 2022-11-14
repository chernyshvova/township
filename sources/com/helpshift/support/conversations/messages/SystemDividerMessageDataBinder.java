package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.SystemDividerMessageDM;

public class SystemDividerMessageDataBinder extends MessageViewDataBinder<ViewHolder, SystemDividerMessageDM> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dividerHeader;
        public View dividerView;

        public ViewHolder(View view) {
            super(view);
            this.dividerView = view.findViewById(C2466R.C2468id.conversations_divider);
            this.dividerHeader = (TextView) view.findViewById(C2466R.C2468id.conversation_closed_view);
        }
    }

    public SystemDividerMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, SystemDividerMessageDM systemDividerMessageDM) {
        String str;
        if (systemDividerMessageDM.showDividerText) {
            viewHolder.dividerHeader.setVisibility(0);
            str = "";
        } else {
            viewHolder.dividerHeader.setVisibility(8);
            str = this.context.getString(C2466R.string.hs__conversations_divider_voice_over);
        }
        viewHolder.dividerView.setContentDescription(str);
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_system_divider_layout, viewGroup, false));
    }
}
