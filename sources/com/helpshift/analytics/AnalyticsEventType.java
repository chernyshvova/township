package com.helpshift.analytics;

import androidx.core.graphics.PaintCompat;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

public enum AnalyticsEventType {
    APP_START("a"),
    LIBRARY_OPENED("o"),
    LIBRARY_OPENED_DECOMP(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG),
    SUPPORT_LAUNCH(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL),
    PERFORMED_SEARCH(AnalyticsEventKey.SEARCH_QUERY),
    BROWSED_FAQ_LIST("b"),
    READ_FAQ("f"),
    MARKED_HELPFUL("h"),
    MARKED_UNHELPFUL(AnalyticsEventKey.URL),
    REPORTED_ISSUE("i"),
    CONVERSATION_POSTED(AnalyticsEventKey.PROTOCOL),
    REVIEWED_APP(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK),
    OPEN_ISSUE("c"),
    OPEN_INBOX("x"),
    LIBRARY_QUIT("q"),
    MESSAGE_ADDED(PaintCompat.EM_STRING),
    RESOLUTION_ACCEPTED("y"),
    RESOLUTION_REJECTED("n"),
    START_CSAT_RATING("sr"),
    CANCEL_CSAT_RATING("cr"),
    LINK_VIA_FAQ("fl"),
    TICKET_AVOIDED("ta"),
    TICKET_AVOIDANCE_FAILED("taf"),
    DYNAMIC_FORM_OPEN("dfo"),
    ADMIN_MESSAGE_DEEPLINK_CLICKED("ml"),
    DYNAMIC_FORM_CLOSE("dfc"),
    SMART_INTENT_TREE_SHOWN("its"),
    SMART_INTENT_SELECTION("sis"),
    SMART_INTENT_DESELECTION("sid"),
    SMART_INTENT_SEARCH_INTENT("sisr"),
    ACTION_CARD_CLICKED("acl"),
    TIMER_EXPIRED("te"),
    CSAT_SUBMITTED("cbc"),
    CSAT_REQUESTED("cbr");
    
    public final String key;

    /* access modifiers changed from: public */
    AnalyticsEventType(String str) {
        this.key = str;
    }
}
