package com.helpshift.common.platform;

import com.helpshift.faq.dao.FaqEventDAO;
import java.util.HashMap;
import java.util.Map;

public class AndroidFaqEventDAO implements FaqEventDAO {
    public static final String KEY_FAQ_MARK_EVENTS = "key_faq_mark_event";
    public KVStore kvStore;

    public AndroidFaqEventDAO(KVStore kVStore) {
        this.kvStore = kVStore;
    }

    private synchronized HashMap<String, Boolean> getFaqMarkEventFromDB() {
        HashMap<String, Boolean> hashMap;
        Object serializable = this.kvStore.getSerializable(KEY_FAQ_MARK_EVENTS);
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        } else {
            hashMap = new HashMap<>();
        }
        return hashMap;
    }

    public Map<String, Boolean> getUnSentFaqMarkHelpfulEvents() {
        return getFaqMarkEventFromDB();
    }

    public void insertFaqMarkHelpfulEvent(String str, boolean z) {
        HashMap<String, Boolean> faqMarkEventFromDB = getFaqMarkEventFromDB();
        faqMarkEventFromDB.put(str, Boolean.valueOf(z));
        this.kvStore.setSerializable(KEY_FAQ_MARK_EVENTS, faqMarkEventFromDB);
    }

    public void removeFaqMarkHelpfulEvent(String str) {
        HashMap<String, Boolean> faqMarkEventFromDB = getFaqMarkEventFromDB();
        if (faqMarkEventFromDB.containsKey(str)) {
            faqMarkEventFromDB.remove(str);
            this.kvStore.setSerializable(KEY_FAQ_MARK_EVENTS, faqMarkEventFromDB);
        }
    }
}
