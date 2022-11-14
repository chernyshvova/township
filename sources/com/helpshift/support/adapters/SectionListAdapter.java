package com.helpshift.support.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.Section;
import java.util.List;

public class SectionListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public View.OnClickListener onClickListener;
    public List<Section> sections;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public SectionListAdapter(List<Section> list, View.OnClickListener onClickListener2) {
        this.sections = list;
        this.onClickListener = onClickListener2;
    }

    public int getItemCount() {
        return this.sections.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Section section = this.sections.get(i);
        viewHolder.textView.setText(section.getTitle());
        viewHolder.textView.setTag(section.getPublishId());
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs_simple_recycler_view_item, viewGroup, false);
        textView.setOnClickListener(this.onClickListener);
        return new ViewHolder(textView);
    }
}
