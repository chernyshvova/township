package com.swrve.sdk;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTClient;
import com.swrve.sdk.rest.RESTResponse;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class CampaignDeliveryManager {
    public static final String KEY_BODY = "BODY";
    public static final String KEY_END_POINT = "END_POINT";
    public static final int MAX_ATTEMPTS = 3;
    public static final int REST_CLIENT_TIMEOUT_MILLIS = 30000;
    public final Context context;
    public OneTimeWorkRequest workRequest;

    public class RESTResponseListener implements IRESTResponseListener {
        public final String batchEvent;
        public ListenableWorker.Result result = ListenableWorker.Result.failure();
        public final int runNumber;

        public RESTResponseListener(int i, String str) {
            this.runNumber = i;
            this.batchEvent = str;
        }

        public void onException(Exception exc) {
            SwrveLogger.m2753e("SwrveSDK: Error sending post request for campaign delivery event.", exc, new Object[0]);
        }

        public void onResponse(RESTResponse rESTResponse) {
            if (SwrveHelper.successResponseCode(rESTResponse.responseCode)) {
                SwrveLogger.m2755i("SwrveSDK:PushDelivery event sent to Swrve", new Object[0]);
                this.result = ListenableWorker.Result.success();
                CampaignDeliveryManager.this.sendQaEvent(this.batchEvent);
                return;
            }
            SwrveLogger.m2754e("SwrveSDK:Error sending PushDelivery event to Swrve. responseCode: %s\tresponseBody:%s", Integer.valueOf(rESTResponse.responseCode), rESTResponse.responseBody);
            if (SwrveHelper.userErrorResponseCode(rESTResponse.responseCode)) {
                this.result = ListenableWorker.Result.failure();
            } else if (SwrveHelper.serverErrorResponseCode(rESTResponse.responseCode)) {
                int i = this.runNumber;
                if (i >= 3) {
                    SwrveLogger.m2754e("SwrveSDK: Attempts to resend campaign delivery has maxed out %s times. No more retries.", 3);
                    this.result = ListenableWorker.Result.failure();
                    CampaignDeliveryManager.this.saveEvent(this.batchEvent, this.runNumber + 1);
                    return;
                }
                SwrveLogger.m2755i("SwrveSDK: Will retry sending campaign delivery. runNumber:%s", Integer.valueOf(i));
                this.result = ListenableWorker.Result.retry();
            }
        }
    }

    public CampaignDeliveryManager(Context context2) {
        this.context = context2;
    }

    private String addRunNumberToPayload(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject(EventHelper.extractEventFromBatch(str));
            if (!jSONObject.has("payload")) {
                return str;
            }
            jSONObject.getJSONObject("payload").put(ISwrveCommon.GENERIC_EVENT_PAYLOAD_RUN_NUMBER, i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("data", jSONArray);
            return jSONObject2.toString();
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Exception in addRunNumberToPayload", e, new Object[0]);
            return str;
        }
    }

    public synchronized void enqueueWorkRequest(Context context2, OneTimeWorkRequest oneTimeWorkRequest) {
        WorkManager.getInstance(context2).enqueue((WorkRequest) oneTimeWorkRequest);
    }

    public IRESTClient getRestClient(int i) {
        return new RESTClient(i);
    }

    public IRESTResponseListener getRestResponseListener(int i, String str) {
        return new RESTResponseListener(i, str);
    }

    public OneTimeWorkRequest getRestWorkRequest(String str, String str2) {
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        return (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(SwrveCampaignDeliveryWorker.class).setConstraints(build)).setInputData(new Data.Builder().putString(KEY_END_POINT, str).putString(KEY_BODY, str2).build())).setBackoffCriteria(BackoffPolicy.LINEAR, 10000, TimeUnit.MILLISECONDS)).build();
    }

    public ListenableWorker.Result post(Data data, int i) {
        if (i >= 3) {
            SwrveLogger.m2754e("SwrveSDK: SwrveCampaignDelivery error. Exit. Attempts to resend campaign delivery has maxed out %s times", 3);
            return ListenableWorker.Result.failure();
        }
        String string = data.getString(KEY_END_POINT);
        String string2 = data.getString(KEY_BODY);
        if (SwrveHelper.isNullOrEmpty(string) || SwrveHelper.isNullOrEmpty(string2)) {
            SwrveLogger.m2754e("SwrveSDK: SwrveCampaignDelivery error. Exit. Invalid endpoint:%s body:%s", string, string2);
            return ListenableWorker.Result.failure();
        }
        int i2 = i + 1;
        if (i2 > 1) {
            string2 = addRunNumberToPayload(string2, i2);
        }
        IRESTClient restClient = getRestClient(30000);
        SwrveLogger.m2756v("SwrveSDK: runNumber %s, sending campaign delivery post request with body:\n %s", Integer.valueOf(i2), string2);
        RESTResponseListener rESTResponseListener = (RESTResponseListener) getRestResponseListener(i2, string2);
        restClient.post(string, string2, rESTResponseListener);
        return rESTResponseListener.result;
    }

    public void saveEvent(String str, int i) {
        try {
            SwrveCommon.getInstance().saveEvent(EventHelper.extractEventFromBatch(addRunNumberToPayload(str, i)));
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Exception saving campaign delivery event to storage.", e, new Object[0]);
        }
    }

    public void sendCampaignDelivery(String str, String str2) {
        try {
            OneTimeWorkRequest restWorkRequest = getRestWorkRequest(str, str2);
            this.workRequest = restWorkRequest;
            enqueueWorkRequest(this.context, restWorkRequest);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Error trying to queue campaign delivery event.", e, new Object[0]);
        }
    }

    public void sendQaEvent(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(EventHelper.extractEventFromBatch(str));
            QaUser.wrappedEvents(arrayList);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Exception sending QA campaign delivery wrapped event.", e, new Object[0]);
        }
    }
}
