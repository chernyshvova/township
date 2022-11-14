package com.swrve.sdk;

import com.swrve.sdk.conversations.p035ui.ConversationActivity;

public class QaCampaignInfo {
    public final boolean displayed;

    /* renamed from: id */
    public final long f2775id;
    public final String reason;
    public final CAMPAIGN_TYPE type;
    public final long variantId;

    public enum CAMPAIGN_TYPE {
        IAM {
            public String toString() {
                return "iam";
            }
        },
        CONVERSATION {
            public String toString() {
                return ConversationActivity.EXTRA_CONVERSATION_KEY;
            }
        },
        EMBEDDED {
            public String toString() {
                return "embedded";
            }
        }
    }

    public QaCampaignInfo(long j, long j2, CAMPAIGN_TYPE campaign_type, boolean z, String str) {
        this.f2775id = j;
        this.variantId = j2;
        this.type = campaign_type;
        this.displayed = z;
        this.reason = str;
    }
}
