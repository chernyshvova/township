package com.helpshift.conversation.dao;

public interface FAQSuggestionsDAO {
    Object getFAQ(String str, String str2);

    void insertOrUpdateFAQ(Object obj);

    void removeFAQ(String str, String str2);
}
