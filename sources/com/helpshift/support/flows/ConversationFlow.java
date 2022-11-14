package com.helpshift.support.flows;

import androidx.annotation.NonNull;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.util.ConfigUtil;
import java.util.HashMap;
import java.util.Map;

public class ConversationFlow implements Flow {
    public final HashMap config;
    public final String label;
    public final int labelResId;
    public SupportController supportController;

    public ConversationFlow(int i) {
        this(i, (Map) new HashMap());
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelResId() {
        return this.labelResId;
    }

    public void performAction() {
        this.supportController.startConversationFlow(SupportInternal.cleanConfig(SupportInternal.removeShowConversationUnsupportedConfigs(this.config)), true);
    }

    public void setSupportController(SupportController supportController2) {
        this.supportController = supportController2;
    }

    public ConversationFlow(int i, Map map) {
        this.labelResId = i;
        this.config = new HashMap(map);
        this.label = null;
    }

    public ConversationFlow(int i, @NonNull ApiConfig apiConfig) {
        this(i, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public ConversationFlow(String str) {
        this(str, (Map) new HashMap());
    }

    public ConversationFlow(String str, Map map) {
        this.label = str;
        this.config = new HashMap(map);
        this.labelResId = 0;
    }

    public ConversationFlow(String str, @NonNull ApiConfig apiConfig) {
        this(str, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }
}
