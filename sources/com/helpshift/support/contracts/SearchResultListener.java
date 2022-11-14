package com.helpshift.support.contracts;

import java.util.ArrayList;

public interface SearchResultListener {
    void onQuestionSelected(String str, ArrayList<String> arrayList);

    void sendAnyway();
}
