package com.helpshift.faq.domainmodel;

import java.util.ArrayList;

public interface FAQSearchDM {
    ArrayList getSearchResults(String str);

    void startFAQSearchIndexing();
}
