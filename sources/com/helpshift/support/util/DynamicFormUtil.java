package com.helpshift.support.util;

import android.content.Context;
import com.facebook.LegacyTokenHelper;
import com.helpshift.support.flows.ConversationFlow;
import com.helpshift.support.flows.DynamicFormFlow;
import com.helpshift.support.flows.FAQSectionFlow;
import com.helpshift.support.flows.FAQsFlow;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.flows.SingleFAQFlow;
import com.vungle.warren.network.VungleApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicFormUtil {
    public static Flow toFlow(Context context, HashMap hashMap) {
        Flow flow;
        String str = (String) hashMap.get("type");
        HashMap hashMap2 = new HashMap();
        if (hashMap.containsKey(VungleApiImpl.CONFIG)) {
            hashMap2 = (HashMap) hashMap.get(VungleApiImpl.CONFIG);
        }
        String str2 = (String) hashMap.get("titleResourceName");
        int i = 0;
        if (str2 != null) {
            i = context.getResources().getIdentifier(str2, LegacyTokenHelper.TYPE_STRING, context.getPackageName());
        }
        String str3 = i == 0 ? (String) hashMap.get("title") : "";
        if (str.equals("faqsFlow")) {
            if (i != 0) {
                return new FAQsFlow(i, (Map) hashMap2);
            }
            return new FAQsFlow(str3, (Map) hashMap2);
        } else if (!str.equals("conversationFlow")) {
            if (str.equals("faqSectionFlow")) {
                String str4 = (String) hashMap.get("data");
                if (i != 0) {
                    flow = new FAQSectionFlow(i, str4, (Map) hashMap2);
                } else {
                    flow = new FAQSectionFlow(str3, str4, (Map) hashMap2);
                }
            } else if (str.equals("singleFaqFlow")) {
                String str5 = (String) hashMap.get("data");
                if (i != 0) {
                    flow = new SingleFAQFlow(i, str5, (Map) hashMap2);
                } else {
                    flow = new SingleFAQFlow(str3, str5, (Map) hashMap2);
                }
            } else if (!str.equals("dynamicFormFlow")) {
                return null;
            } else {
                List<Flow> flowList = toFlowList(context, (ArrayList) hashMap.get("data"));
                if (i != 0) {
                    flow = new DynamicFormFlow(i, flowList);
                } else {
                    flow = new DynamicFormFlow(str3, flowList);
                }
            }
            return flow;
        } else if (i != 0) {
            return new ConversationFlow(i, (Map) hashMap2);
        } else {
            return new ConversationFlow(str3, (Map) hashMap2);
        }
    }

    public static List<Flow> toFlowList(Context context, List<HashMap<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        for (HashMap<String, Object> flow : list) {
            arrayList.add(toFlow(context, flow));
        }
        return arrayList;
    }
}
