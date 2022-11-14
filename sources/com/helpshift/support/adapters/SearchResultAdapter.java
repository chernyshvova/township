package com.helpshift.support.adapters;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.ContactUsFilter;
import com.helpshift.support.Faq;
import com.helpshift.support.util.HSTransliterator;
import com.helpshift.util.Styles;
import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_QUESTION = 3;
    public View.OnClickListener onContactUsClickedListener;
    public View.OnClickListener onQuestionClickedListener;
    public List<Faq> questions;

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public Button button;
        public LinearLayout rootView;

        public FooterViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            this.rootView = linearLayout;
            this.button = (Button) linearLayout.findViewById(C2466R.C2468id.send_anyway_button);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(TextView textView) {
            super(textView);
        }
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public QuestionViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public SearchResultAdapter(List<Faq> list, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.questions = list;
        this.onQuestionClickedListener = onClickListener;
        this.onContactUsClickedListener = onClickListener2;
    }

    private void configureFooterViewHolder(FooterViewHolder footerViewHolder) {
        if (ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.SEARCH_FOOTER)) {
            footerViewHolder.rootView.setVisibility(0);
            footerViewHolder.button.setOnClickListener(this.onContactUsClickedListener);
            return;
        }
        footerViewHolder.rootView.setVisibility(8);
    }

    private void configureQuestionViewHolder(QuestionViewHolder questionViewHolder, int i) {
        QuestionViewHolder questionViewHolder2 = questionViewHolder;
        Faq faq = this.questions.get(i - 1);
        ArrayList<String> arrayList = faq.searchTerms;
        String str = faq.title;
        if (arrayList == null || arrayList.size() <= 0) {
            questionViewHolder2.textView.setText(str);
        } else {
            int color = Styles.getColor(questionViewHolder2.textView.getContext(), C2466R.attr.hs__searchHighlightColor);
            SpannableString spannableString = new SpannableString(str);
            if (str.equals(HSTransliterator.unidecode(str))) {
                String lowerCase = str.toLowerCase();
                for (String next : arrayList) {
                    if (next.length() >= 3) {
                        for (int indexOf = TextUtils.indexOf(lowerCase, next, 0); indexOf >= 0; indexOf = TextUtils.indexOf(lowerCase, next, next.length() + indexOf)) {
                            spannableString.setSpan(new BackgroundColorSpan(color), indexOf, next.length() + indexOf, 33);
                        }
                    }
                }
            } else {
                int length = str.length();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    String unidecode = HSTransliterator.unidecode(charAt + "");
                    for (int i3 = 0; i3 < unidecode.length(); i3++) {
                        sb.append(unidecode.charAt(i3));
                        arrayList2.add(Integer.valueOf(i2));
                    }
                }
                String lowerCase2 = sb.toString().toLowerCase();
                for (String lowerCase3 : arrayList) {
                    String lowerCase4 = lowerCase3.toLowerCase();
                    if (lowerCase4.length() >= 3) {
                        for (int indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase4, 0); indexOf2 >= 0; indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase4, lowerCase4.length() + indexOf2)) {
                            spannableString.setSpan(new BackgroundColorSpan(color), ((Integer) arrayList2.get(indexOf2)).intValue(), ((Integer) arrayList2.get((lowerCase4.length() + indexOf2) - 1)).intValue() + 1, 33);
                        }
                    }
                }
            }
            questionViewHolder2.textView.setText(spannableString);
        }
        questionViewHolder2.textView.setOnClickListener(this.onQuestionClickedListener);
        questionViewHolder2.textView.setTag(faq.publish_id);
    }

    private boolean isPositionFooter(int i) {
        return i == getItemCount() - 1;
    }

    public Faq getFaq(String str) {
        List<Faq> list = this.questions;
        if (list == null) {
            return null;
        }
        for (Faq next : list) {
            if (next.publish_id.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public int getItemCount() {
        return this.questions.size() + 2;
    }

    public long getItemId(int i) {
        if (i == 0) {
            return 1;
        }
        if (isPositionFooter(i)) {
            return 2;
        }
        return Long.valueOf(this.questions.get(i - 1).publish_id).longValue();
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        return isPositionFooter(i) ? 2 : 3;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof FooterViewHolder) {
            configureFooterViewHolder((FooterViewHolder) viewHolder);
        } else if (viewHolder instanceof QuestionViewHolder) {
            configureQuestionViewHolder((QuestionViewHolder) viewHolder, i);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new HeaderViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__search_result_header, viewGroup, false));
        }
        if (i != 2) {
            return new QuestionViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs_simple_recycler_view_item, viewGroup, false));
        }
        return new FooterViewHolder((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__search_result_footer, viewGroup, false));
    }
}
