package com.helpshift.util;

import android.content.Context;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.logmodels.LogExtrasModelProvider;
import com.helpshift.providers.CrossModuleDataProvider;
import com.helpshift.providers.ISupportDataProvider;
import java.util.ArrayList;
import java.util.List;

public class ErrorReportProvider {
    public static final long BATCH_TIME = 86400000;
    public static final String KEY_ACTIVE_CONVERSATION_ID = "actconvid";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_FUNNEL = "funnel";
    public static final String KEY_NETWORK_TYPE = "nt";
    public static final String KEY_THREAD_INFO = "thread";
    public static String TAG = "HS_ErrorReport";

    public static List<ILogExtrasModel> getErrorReportExtras(Context context, Thread thread) {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(LogExtrasModelProvider.fromString("appId", context.getPackageName()));
            arrayList.add(LogExtrasModelProvider.fromString("nt", HelpshiftConnectionUtil.getNetworkType(context)));
            ISupportDataProvider supportDataProvider = CrossModuleDataProvider.getSupportDataProvider();
            String str2 = "";
            if (supportDataProvider == null) {
                str = str2;
            } else {
                str = supportDataProvider.getActionEvents();
            }
            if (str != null) {
                arrayList.add(LogExtrasModelProvider.fromString(KEY_FUNNEL, str));
            }
            if (supportDataProvider != null) {
                str2 = supportDataProvider.getActiveConversationId();
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(LogExtrasModelProvider.fromString(KEY_ACTIVE_CONVERSATION_ID, str2));
            }
            String str3 = "Unknown";
            if (thread != null) {
                str3 = thread.toString();
            }
            arrayList.add(LogExtrasModelProvider.fromString(KEY_THREAD_INFO, str3));
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error creating error report", e);
        }
        return arrayList;
    }
}
