package com.facebook.appevents.cloudbridge;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEventsConversionsAPITransformer.kt */
public enum CustomEventField {
    EVENT_TIME(Constants.LOG_TIME_APP_EVENT_KEY),
    EVENT_NAME(Constants.EVENT_NAME_EVENT_KEY),
    VALUE_TO_SUM(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM),
    CONTENT_IDS(AppEventsConstants.EVENT_PARAM_CONTENT_ID),
    CONTENTS(AppEventsConstants.EVENT_PARAM_CONTENT),
    CONTENT_TYPE(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE),
    DESCRIPTION(AppEventsConstants.EVENT_PARAM_DESCRIPTION),
    LEVEL(AppEventsConstants.EVENT_PARAM_LEVEL),
    MAX_RATING_VALUE(AppEventsConstants.EVENT_PARAM_MAX_RATING_VALUE),
    NUM_ITEMS(AppEventsConstants.EVENT_PARAM_NUM_ITEMS),
    PAYMENT_INFO_AVAILABLE(AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE),
    REGISTRATION_METHOD(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD),
    SEARCH_STRING(AppEventsConstants.EVENT_PARAM_SEARCH_STRING),
    SUCCESS(AppEventsConstants.EVENT_PARAM_SUCCESS),
    ORDER_ID(AppEventsConstants.EVENT_PARAM_ORDER_ID),
    AD_TYPE("ad_type"),
    CURRENCY(AppEventsConstants.EVENT_PARAM_CURRENCY);
    
    public static final Companion Companion = null;
    public final String rawValue;

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomEventField invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "rawValue");
            for (CustomEventField customEventField : CustomEventField.values()) {
                if (Intrinsics.areEqual(customEventField.getRawValue(), str)) {
                    return customEventField;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    CustomEventField(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
