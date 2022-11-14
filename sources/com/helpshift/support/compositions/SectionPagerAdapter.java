package com.helpshift.support.compositions;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.Section;
import com.helpshift.support.fragments.QuestionListFragment;
import com.helpshift.util.HSLogger;
import java.util.List;

public class SectionPagerAdapter extends FragmentStatePagerAdapter {
    public static final String TAG = "Helpshift_SectionPager";
    public FaqTagFilter faqTagFilter;
    public List<Section> sections;

    public SectionPagerAdapter(FragmentManager fragmentManager, List<Section> list, FaqTagFilter faqTagFilter2) {
        super(fragmentManager);
        this.sections = list;
        this.faqTagFilter = faqTagFilter2;
    }

    public int getCount() {
        return this.sections.size();
    }

    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("sectionPublishId", this.sections.get(i).getPublishId());
        bundle.putSerializable("withTagsMatching", this.faqTagFilter);
        return QuestionListFragment.newInstance(bundle);
    }

    public CharSequence getPageTitle(int i) {
        return this.sections.get(i).getTitle();
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        try {
            super.restoreState(parcelable, classLoader);
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Exception in restoreState: ", e);
        }
    }
}
