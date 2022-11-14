package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.SystemDateMessageDM;
import com.helpshift.util.Styles;

public class SystemDateMessageDataBinder extends MessageViewDataBinder<ViewHolder, SystemDateMessageDM> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView body;

        public ViewHolder(View view) {
            super(view);
            this.body = (TextView) view.findViewById(C2466R.C2468id.system_message);
        }
    }

    public SystemDateMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, SystemDateMessageDM systemDateMessageDM) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        if (systemDateMessageDM.isFirstMessageInList) {
            layoutParams.topMargin = (int) Styles.dpToPx(this.context, 18.0f);
        } else {
            layoutParams.topMargin = (int) Styles.dpToPx(this.context, 2.0f);
        }
        viewHolder.itemView.setLayoutParams(layoutParams);
        viewHolder.body.setText(systemDateMessageDM.getBodyText());
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_system_layout, viewGroup, false));
    }
}
