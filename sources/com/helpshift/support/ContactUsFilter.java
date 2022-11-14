package com.helpshift.support;

import android.content.Context;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.SupportInternal;
import com.helpshift.util.HelpshiftContext;
import java.util.HashMap;

public final class ContactUsFilter {
    public static HSApiData data;
    public static Integer enableContactUs;

    /* renamed from: com.helpshift.support.ContactUsFilter$1 */
    public static /* synthetic */ class C26611 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$support$ContactUsFilter$LOCATION;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.helpshift.support.ContactUsFilter$LOCATION[] r0 = com.helpshift.support.ContactUsFilter.LOCATION.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$support$ContactUsFilter$LOCATION = r0
                com.helpshift.support.ContactUsFilter$LOCATION r1 = com.helpshift.support.ContactUsFilter.LOCATION.SEARCH_FOOTER     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$helpshift$support$ContactUsFilter$LOCATION     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.support.ContactUsFilter$LOCATION r1 = com.helpshift.support.ContactUsFilter.LOCATION.QUESTION_ACTION_BAR     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 3
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.ContactUsFilter.C26611.<clinit>():void");
        }
    }

    public enum LOCATION {
        ACTION_BAR,
        SEARCH_FOOTER,
        QUESTION_FOOTER,
        QUESTION_ACTION_BAR,
        SEARCH_RESULT_ACTIVITY_HEADER
    }

    public static void init(Context context) {
        if (data == null) {
            data = new HSApiData(context);
            enableContactUs = Integer.valueOf(HelpshiftContext.getCoreApi().getSDKConfigurationDM().getEnableContactUs().getValue());
        }
    }

    public static void setConfig(HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Object obj = hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US);
        if (obj instanceof Integer) {
            enableContactUs = (Integer) hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US);
        } else if (!(obj instanceof Boolean)) {
        } else {
            if (((Boolean) obj).booleanValue()) {
                enableContactUs = SupportInternal.EnableContactUs.ALWAYS;
            } else {
                enableContactUs = SupportInternal.EnableContactUs.NEVER;
            }
        }
    }

    public static boolean showContactUs(LOCATION location) {
        if (location == LOCATION.SEARCH_RESULT_ACTIVITY_HEADER || SupportInternal.EnableContactUs.NEVER.equals(enableContactUs)) {
            return false;
        }
        if (!SupportInternal.EnableContactUs.ALWAYS.equals(enableContactUs) && location != LOCATION.QUESTION_FOOTER) {
            if (location == LOCATION.ACTION_BAR) {
                if (HelpshiftContext.getCoreApi().getActiveConversation() != null) {
                    return true;
                }
                return false;
            } else if (!SupportInternal.EnableContactUs.AFTER_VIEWING_FAQS.equals(enableContactUs) && SupportInternal.EnableContactUs.AFTER_MARKING_ANSWER_UNHELPFUL.equals(enableContactUs)) {
                int ordinal = location.ordinal();
                if (ordinal == 1) {
                    return false;
                }
                if (ordinal == 3 && HelpshiftContext.getCoreApi().getActiveConversation() == null) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }
}
