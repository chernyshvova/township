package com.helpshift.common.platform;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.helpshift.faq.domainmodel.FAQSearchDM;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.HSApiData;
import com.helpshift.support.HSSearch;
import com.helpshift.support.constants.GetSectionsCallBackStatus;
import com.helpshift.support.util.HSTransliterator;
import java.util.ArrayList;

public class AndroidFAQSearchDM implements FAQSearchDM {
    public HSApiData data;

    public AndroidFAQSearchDM(HSApiData hSApiData) {
        this.data = hSApiData;
    }

    public ArrayList getSearchResults(String str) {
        return this.data.localFaqSearch(str, HSSearch.HS_SEARCH_OPTIONS.KEYWORD_SEARCH);
    }

    public void startFAQSearchIndexing() {
        HandlerThread handlerThread = new HandlerThread("HS-faqdm-index");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() {
            public void run() {
                AndroidFAQSearchDM.this.data.getSections(new Handler() {
                    public void handleMessage(Message message) {
                        if (message.what != GetSectionsCallBackStatus.API_SUCCESS_NO_NEW_DATA) {
                            AndroidFAQSearchDM.this.data.loadIndex();
                            HSTransliterator.init();
                        }
                    }
                }, new Handler(), (FaqTagFilter) null);
            }
        });
    }
}
