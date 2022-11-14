package com.helpshift.support.contracts;

import android.os.Bundle;
import java.util.ArrayList;

public interface FaqFragmentListener {
    void onContactUsClicked(String str);

    void onQuestionSelected(String str, ArrayList<String> arrayList);

    void onSectionSelected(Bundle bundle);
}
