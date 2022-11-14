package com.helpshift.support;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.helpshift.Core;
import com.helpshift.HelpshiftUser;
import com.helpshift.delegate.RootDelegate;
import com.helpshift.executors.ActionExecutor;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.util.ConfigUtil;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.concurrent.ApiExecutorFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Support implements Core.ApiProvider {
    public static final String CONVERSATION_FLOW = "conversationFlow";
    public static final String CustomIssueFieldKey = "hs-custom-issue-field";
    public static final String CustomMetadataKey = "hs-custom-metadata";
    public static final String DYNAMIC_FORM_FLOW = "dynamicFormFlow";
    public static final String FAQS_FLOW = "faqsFlow";
    public static final String FAQ_SECTION_FLOW = "faqSectionFlow";
    public static final String SINGLE_FAQ_FLOW = "singleFaqFlow";
    public static final String TAG = "HelpShiftDebug";
    public static final String TagsKey = "hs-tags";
    public static final String UserAcceptedTheSolution = "User accepted the solution";
    public static final String UserRejectedTheSolution = "User rejected the solution";
    public static final String UserReviewedTheApp = "User reviewed the app";
    public static final String UserSentScreenShot = "User sent a screenshot";
    public static final String libraryVersion = "7.11.0";

    public interface Delegate extends RootDelegate {
        void displayAttachmentFile(Uri uri);
    }

    public static class EnableContactUs extends SupportInternal.EnableContactUs {
    }

    public static class LazyHolder {
        public static final Support INSTANCE = new Support();
    }

    public static class RateAlert extends SupportInternal.RateAlert {
    }

    public static void clearBreadCrumbs() {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.clearBreadCrumbs();
                }
            });
        }
    }

    public static SupportFragment getConversationFragment(@NonNull Activity activity) {
        return getConversationFragment(activity, (Map<String, Object>) new HashMap());
    }

    public static SupportFragment getDynamicFormFragment(@NonNull Activity activity, @NonNull List<Flow> list) {
        return getDynamicFormFragment(activity, "", list, (Map<String, Object>) new HashMap());
    }

    public static SupportFragment getFAQSectionFragment(@NonNull Activity activity, @NonNull String str) {
        return getFAQSectionFragment(activity, str, (Map<String, Object>) new HashMap());
    }

    public static SupportFragment getFAQsFragment(@NonNull Activity activity) {
        return getFAQsFragment(activity, (Map<String, Object>) new HashMap());
    }

    public static Support getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static Integer getNotificationCount() {
        if (!HelpshiftContext.verifyInstall()) {
            return -1;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.getNotificationCount();
    }

    public static SupportFragment getSingleFAQFragment(@NonNull Activity activity, @NonNull String str) {
        return getSingleFAQFragment(activity, str, (Map<String, Object>) new HashMap());
    }

    public static boolean isConversationActive() {
        if (!HelpshiftContext.verifyInstall()) {
            return false;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.isConversationActive();
    }

    public static void leaveBreadCrumb(final String str) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.leaveBreadCrumb(str);
                }
            });
        }
    }

    public static void setDelegate(final Delegate delegate) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.setDelegate(delegate);
                }
            });
        }
    }

    @Deprecated
    public static void setMetadataCallback(final Callable callable) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.setMetadataCallback(callable);
                }
            });
        }
    }

    public static void setSDKLanguage(final String str) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.setSDKLanguage(str);
                }
            });
        }
    }

    @Deprecated
    public static void setUserIdentifier(final String str) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.setUserIdentifier(str);
                }
            });
        }
    }

    public static void showAlertToRateApp(final String str, final AlertToRateAppListener alertToRateAppListener) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runOnUiThread(new Runnable() {
                public void run() {
                    SupportInternal.showAlertToRateApp(str, alertToRateAppListener);
                }
            });
        }
    }

    public static void showConversation(Activity activity) {
        showConversation(activity, (Map<String, Object>) new HashMap());
    }

    public static void showDynamicForm(@NonNull Activity activity, @NonNull List<Flow> list) {
        showDynamicForm(activity, "", list);
    }

    public static void showFAQSection(Activity activity, String str) {
        showFAQSection(activity, str, (Map<String, Object>) new HashMap());
    }

    public static void showFAQs(Activity activity) {
        showFAQs(activity, (Map<String, Object>) new HashMap());
    }

    public static void showSingleFAQ(Activity activity, String str) {
        showSingleFAQ(activity, str, (Map<String, Object>) new HashMap());
    }

    public boolean _clearAnonymousUser() {
        return SupportInternal.clearAnonymousUser();
    }

    public ActionExecutor _getActionExecutor() {
        return null;
    }

    public void _handlePush(Context context, Intent intent) {
        SupportInternal.handlePush(context, intent);
    }

    public void _install(@NonNull Application application, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        SupportInternal.install(application, str, str2, str3);
    }

    public boolean _login(HelpshiftUser helpshiftUser) {
        return SupportInternal.login(helpshiftUser);
    }

    public boolean _logout() {
        return SupportInternal.logout();
    }

    public void _preInstall(Application application, String str, String str2, String str3, Map<String, Object> map) {
        SupportInternal.preInstall(application, str, str2, str3, map);
    }

    public void _registerDeviceToken(@NonNull Context context, @NonNull String str) {
        SupportInternal.registerDeviceToken(context, str);
    }

    public void _setNameAndEmail(String str, String str2) {
        SupportInternal.setNameAndEmail(str, str2);
    }

    public void _setSDKLanguage(String str) {
        setSDKLanguage(str);
    }

    public void _setTheme(final int i) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.setTheme(i);
                }
            });
        }
    }

    public Support() {
    }

    @Deprecated
    public static SupportFragment getConversationFragment(@NonNull Activity activity, @NonNull Map<String, Object> map) {
        if (!HelpshiftContext.verifyInstall()) {
            return null;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.getConversationFragment(activity, map);
    }

    public static SupportFragment getDynamicFormFragment(@NonNull Activity activity, @NonNull String str, @NonNull List<Flow> list) {
        return getDynamicFormFragment(activity, str, list, (Map<String, Object>) new HashMap());
    }

    @Deprecated
    public static SupportFragment getFAQSectionFragment(@NonNull Activity activity, @NonNull String str, @NonNull Map<String, Object> map) {
        if (!HelpshiftContext.verifyInstall()) {
            return null;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.getFAQSectionFragment(activity, str, map);
    }

    @Deprecated
    public static SupportFragment getFAQsFragment(@NonNull Activity activity, @NonNull Map<String, Object> map) {
        if (!HelpshiftContext.verifyInstall()) {
            return null;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.getFAQsFragment(activity, map);
    }

    @Deprecated
    public static SupportFragment getSingleFAQFragment(@NonNull Activity activity, @NonNull String str, @NonNull Map<String, Object> map) {
        if (!HelpshiftContext.verifyInstall()) {
            return null;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.getSingleFAQFragment(activity, str, map);
    }

    @Deprecated
    public static void showConversation(final Activity activity, final Map<String, Object> map) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runOnUiThread(new Runnable() {
                public void run() {
                    SupportInternal.showConversation(activity, map);
                }
            });
        }
    }

    public static void showDynamicForm(@NonNull final Activity activity, @NonNull final String str, @NonNull final List<Flow> list) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runOnUiThread(new Runnable() {
                public void run() {
                    SupportInternal.showDynamicForm(activity, str, list);
                }
            });
        }
    }

    @Deprecated
    public static void showFAQSection(final Activity activity, final String str, final Map<String, Object> map) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runOnUiThread(new Runnable() {
                public void run() {
                    SupportInternal.showFAQSection(activity, str, map);
                }
            });
        }
    }

    @Deprecated
    public static void showFAQs(final Activity activity, final Map<String, Object> map) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runOnUiThread(new Runnable() {
                public void run() {
                    SupportInternal.showFAQs(activity, map);
                }
            });
        }
    }

    @Deprecated
    public static void showSingleFAQ(final Activity activity, final String str, final Map<String, Object> map) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runOnUiThread(new Runnable() {
                public void run() {
                    SupportInternal.showSingleFAQ(activity, str, map);
                }
            });
        }
    }

    public void _install(@NonNull Application application, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Map<String, Object> map) {
        SupportInternal.install(application, str, str2, str3, map);
    }

    @Deprecated
    public static SupportFragment getDynamicFormFragment(@NonNull Activity activity, @NonNull List<Flow> list, @NonNull Map<String, Object> map) {
        return getDynamicFormFragment(activity, "", list, map);
    }

    public static SupportFragment getDynamicFormFragment(@NonNull Activity activity, @NonNull List<Flow> list, @NonNull ApiConfig apiConfig) {
        return getDynamicFormFragment(activity, "", list, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static void setMetadataCallback(final MetadataCallable metadataCallable) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.setMetadataCallback(metadataCallable);
                }
            });
        }
    }

    public static SupportFragment getDynamicFormFragment(@NonNull Activity activity, @NonNull String str, @NonNull List<Flow> list, @NonNull ApiConfig apiConfig) {
        return getDynamicFormFragment(activity, str, list, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static void showConversation(@NonNull Activity activity, @NonNull ApiConfig apiConfig) {
        showConversation(activity, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static void showFAQSection(@NonNull Activity activity, @NonNull String str, @NonNull ApiConfig apiConfig) {
        if (HelpshiftContext.verifyInstall()) {
            showFAQSection(activity, str, ConfigUtil.validateAndConvertToMap(apiConfig));
        }
    }

    public static void showFAQs(@NonNull Activity activity, @NonNull ApiConfig apiConfig) {
        showFAQs(activity, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static void showSingleFAQ(@NonNull Activity activity, @NonNull String str, @NonNull ApiConfig apiConfig) {
        showSingleFAQ(activity, str, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static SupportFragment getConversationFragment(@NonNull Activity activity, @NonNull ApiConfig apiConfig) {
        return getConversationFragment(activity, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static SupportFragment getDynamicFormFragment(@NonNull Activity activity, @NonNull String str, @NonNull List<Flow> list, @NonNull Map<String, Object> map) {
        if (!HelpshiftContext.verifyInstall()) {
            return null;
        }
        ApiExecutorFactory.getHandlerExecutor().awaitForSyncExecution();
        return SupportInternal.getDynamicFormFragment(activity, str, list, map);
    }

    public static SupportFragment getFAQSectionFragment(@NonNull Activity activity, @NonNull String str, @NonNull ApiConfig apiConfig) {
        return getFAQSectionFragment(activity, str, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static SupportFragment getFAQsFragment(@NonNull Activity activity, @NonNull ApiConfig apiConfig) {
        return getFAQsFragment(activity, ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public static void getNotificationCount(final Handler handler, final Handler handler2) {
        if (HelpshiftContext.verifyInstall()) {
            ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
                public void run() {
                    SupportInternal.getNotificationCount(handler, handler2);
                }
            });
        }
    }

    public static SupportFragment getSingleFAQFragment(@NonNull Activity activity, @NonNull String str, @NonNull ApiConfig apiConfig) {
        return getSingleFAQFragment(activity, str, ConfigUtil.validateAndConvertToMap(apiConfig));
    }
}
