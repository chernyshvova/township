package com.helpshift.support.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.flows.Flow;
import java.util.List;

public class FlowListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<Flow> flows;
    public View.OnClickListener onClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public FlowListAdapter(List<Flow> list, View.OnClickListener onClickListener2) {
        this.flows = list;
        this.onClickListener = onClickListener2;
    }

    public int getItemCount() {
        return this.flows.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        Flow flow = this.flows.get(i);
        if (flow.getLabelResId() != 0) {
            str = viewHolder.textView.getResources().getString(flow.getLabelResId());
        } else {
            str = flow.getLabel();
        }
        viewHolder.textView.setText(str);
        viewHolder.textView.setTag(Integer.valueOf(i));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__simple_list_item_1, viewGroup, false);
        textView.setOnClickListener(this.onClickListener);
        return new ViewHolder(textView);
    }
}
