package com.helpshift.faq.dao;

import java.util.Map;

public interface FaqEventDAO {
    Map<String, Boolean> getUnSentFaqMarkHelpfulEvents();

    void insertFaqMarkHelpfulEvent(String str, boolean z);

    void removeFaqMarkHelpfulEvent(String str);
}
