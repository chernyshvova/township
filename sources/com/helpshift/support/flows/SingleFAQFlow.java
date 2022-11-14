package com.helpshift.support.flows;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.support.util.ConfigUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleFAQFlow implements Flow {
    public final HashMap config;
    public final String label;
    public final int labelResId;
    public final String questionPublishId;
    public SupportController supportController;

    public SingleFAQFlow(int i, String str) {
        this(i, str, (Map) new HashMap());
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelResId() {
        return this.labelResId;
    }

    public void performAction() {
        Bundle cleanConfig = SupportInternal.cleanConfig(SupportInternal.removeFAQFlowUnsupportedConfigs(this.config));
        cleanConfig.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID, this.questionPublishId);
        cleanConfig.putInt(SupportFragment.SUPPORT_MODE, 3);
        cleanConfig.putBoolean(SupportFragmentConstants.DECOMPOSED, true);
        this.supportController.startFaqFlow(cleanConfig, true, (List) this.config.get("customContactUsFlows"));
    }

    public void setSupportController(SupportController supportController2) {
        this.supportController = supportController2;
    }

    public SingleFAQFlow(int i, String str, Map map) {
        this.labelResId = i;
        this.questionPublishId = str;
        this.config = new HashMap(map);
        this.label = null;
    }

    public SingleFAQFlow(int i, @NonNull String str, @NonNull ApiConfig apiConfig) {
        this(i, str, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public SingleFAQFlow(String str, String str2) {
        this(str, str2, (Map) new HashMap());
    }

    public SingleFAQFlow(String str, String str2, Map map) {
        this.label = str;
        this.questionPublishId = str2;
        this.config = new HashMap(map);
        this.labelResId = 0;
    }

    public SingleFAQFlow(String str, @NonNull String str2, @NonNull ApiConfig apiConfig) {
        this(str, str2, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }
}
