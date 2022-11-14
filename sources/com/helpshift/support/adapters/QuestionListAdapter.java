package com.helpshift.support.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.Faq;
import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public View.OnClickListener onClickListener;
    public List<Faq> questions;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public QuestionListAdapter(List<Faq> list, View.OnClickListener onClickListener2) {
        this.questions = list;
        this.onClickListener = onClickListener2;
    }

    public int getItemCount() {
        return this.questions.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Faq faq = this.questions.get(i);
        viewHolder.textView.setText(faq.title);
        viewHolder.textView.setTag(faq.publish_id);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs_simple_recycler_view_item, viewGroup, false);
        textView.setOnClickListener(this.onClickListener);
        return new ViewHolder(textView);
    }
}
