package com.helpshift.support;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.helpshift.C2466R;
import com.helpshift.activities.MainActivity;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.activities.ParentActivity;
import com.helpshift.support.conversations.NewConversationFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.support.storage.IMAppSessionStorage;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.util.ActivityUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.views.FontApplier;
import com.helpshift.views.HSToast;
import java.util.HashMap;
import java.util.Map;

public final class HSReviewFragment extends DialogFragment {
    public static AlertToRateAppListener alertToRateAppListener;
    public final String TAG = "Helpshift_ReviewFrag";
    public boolean disableReview = true;
    public String rurl = "";

    private Dialog initAlertDialog(FragmentActivity fragmentActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivity);
        builder.setMessage(C2466R.string.hs__review_message);
        AlertDialog create = builder.create();
        create.setTitle(C2466R.string.hs__review_title);
        create.setCanceledOnTouchOutside(false);
        create.setButton(-1, (CharSequence) getResources().getString(C2466R.string.hs__rate_button), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(HSReviewFragment.this.rurl)) {
                    HSReviewFragment.this.rurl = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getString(SDKConfigurationDM.REVIEW_URL);
                }
                HSReviewFragment hSReviewFragment = HSReviewFragment.this;
                hSReviewFragment.rurl = hSReviewFragment.rurl.trim();
                if (!TextUtils.isEmpty(HSReviewFragment.this.rurl)) {
                    HSReviewFragment hSReviewFragment2 = HSReviewFragment.this;
                    hSReviewFragment2.gotoApp(hSReviewFragment2.rurl);
                }
                HSReviewFragment.this.sendReviewActionEvent("reviewed");
                HSReviewFragment.this.sendAlertToRateAppAction(0);
            }
        });
        create.setButton(-3, (CharSequence) getResources().getString(C2466R.string.hs__feedback_button), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                HSReviewFragment.this.sendReviewActionEvent("feedback");
                HSReviewFragment.this.sendAlertToRateAppAction(1);
                AppSessionConstants.Screen screen = (AppSessionConstants.Screen) IMAppSessionStorage.getInstance().get(AppSessionConstants.CURRENT_OPEN_SCREEN);
                if (screen != AppSessionConstants.Screen.NEW_CONVERSATION && screen != AppSessionConstants.Screen.CONVERSATION && screen != AppSessionConstants.Screen.CONVERSATION_INFO && screen != AppSessionConstants.Screen.SCREENSHOT_PREVIEW) {
                    Intent intent = new Intent(HSReviewFragment.this.getContext(), ParentActivity.class);
                    intent.putExtra(SupportFragment.SUPPORT_MODE, 1);
                    intent.putExtra(SupportFragmentConstants.DECOMPOSED, true);
                    intent.putExtra(MainActivity.SHOW_IN_FULLSCREEN, ActivityUtil.isFullScreen(HSReviewFragment.this.getActivity()));
                    intent.putExtra("isRoot", true);
                    intent.putExtra(NewConversationFragment.SEARCH_PERFORMED, true);
                    HSReviewFragment.this.getActivity().startActivity(intent);
                }
            }
        });
        create.setButton(-2, (CharSequence) getResources().getString(C2466R.string.hs__review_close_button), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                HSReviewFragment.this.sendReviewActionEvent("later");
                HSReviewFragment.this.sendAlertToRateAppAction(2);
            }
        });
        FontApplier.apply((Dialog) create);
        return create;
    }

    public static void setAlertToRateAppListener(AlertToRateAppListener alertToRateAppListener2) {
        alertToRateAppListener = alertToRateAppListener2;
    }

    public void gotoApp(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str.trim()));
            try {
                getContext().startActivity(intent);
            } catch (Exception e) {
                HSLogger.m3238d("Helpshift_ReviewFrag", "Unable to resolve activity", (Throwable) e);
                HSToast.makeText(getContext(), (CharSequence) getResources().getString(C2466R.string.hs__could_not_open_attachment_msg), 0).show();
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        sendReviewActionEvent("later");
        sendAlertToRateAppAction(2);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            this.disableReview = extras.getBoolean("disableReview", true);
            this.rurl = extras.getString("rurl");
        }
        return initAlertDialog(activity);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.disableReview) {
            HelpshiftContext.getCoreApi().getSDKConfigurationDM().setAppReviewed(true);
        }
        getActivity().finish();
    }

    public void sendAlertToRateAppAction(int i) {
        AlertToRateAppListener alertToRateAppListener2 = alertToRateAppListener;
        if (alertToRateAppListener2 != null) {
            alertToRateAppListener2.onAction(i);
        }
        alertToRateAppListener = null;
    }

    public void sendReviewActionEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "periodic");
        hashMap.put(AnalyticsEventKey.RESPONSE, str);
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.REVIEWED_APP, (Map<String, Object>) hashMap);
    }
}
