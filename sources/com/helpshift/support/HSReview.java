package com.helpshift.support;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.helpshift.C2466R;
import com.helpshift.model.InfoModelFactory;
import com.helpshift.support.flows.CustomContactUsFlowListHolder;
import com.helpshift.support.flows.Flow;
import com.helpshift.util.AssetsUtil;
import com.helpshift.util.LocaleContextUtil;
import java.util.List;

public final class HSReview extends FragmentActivity {
    public List<Flow> flowList;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleContextUtil.getContextWithUpdatedLocaleLegacy(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Integer theme = InfoModelFactory.getInstance().sdkInfoModel.getTheme();
        setTheme(AssetsUtil.resourceExists(this, theme) ? theme.intValue() : C2466R.style.Helpshift_Theme_Base);
        setContentView(new View(this));
        this.flowList = CustomContactUsFlowListHolder.getFlowList();
        CustomContactUsFlowListHolder.setFlowList((List<Flow>) null);
        new HSReviewFragment().show(getSupportFragmentManager(), "hs__review_dialog");
    }

    public void onDestroy() {
        super.onDestroy();
        CustomContactUsFlowListHolder.setFlowList(this.flowList);
        LocaleContextUtil.restoreApplicationLocale();
    }
}
