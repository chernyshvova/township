package com.helpshift.logger;

import android.text.TextUtils;
import android.util.Log;
import com.helpshift.logger.database.LogStorage;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.model.LogModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Logger */
public class WorkerThread implements Runnable {
    public LogMessage logMessage;
    public LogStorage logStorage;
    public SimpleDateFormat simpleDateFormat;

    public WorkerThread(LogMessage logMessage2, LogStorage logStorage2, SimpleDateFormat simpleDateFormat2) {
        this.logMessage = logMessage2;
        this.logStorage = logStorage2;
        this.simpleDateFormat = simpleDateFormat2;
    }

    private String convertExtrasToJSON(ILogExtrasModel[] iLogExtrasModelArr) {
        JSONArray jSONArray = new JSONArray();
        if (iLogExtrasModelArr == null || iLogExtrasModelArr.length == 0) {
            return jSONArray.toString();
        }
        for (ILogExtrasModel iLogExtrasModel : iLogExtrasModelArr) {
            if (iLogExtrasModel != null) {
                if (jSONArray.length() > 20) {
                    break;
                }
                JSONObject jSONObject = (JSONObject) iLogExtrasModel.toJSONObject();
                if (jSONObject.toString().length() <= 5000) {
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray.toString();
    }

    public void run() {
        try {
            if (this.logMessage != null) {
                String format = this.simpleDateFormat.format(new Date(this.logMessage.timeStamp));
                if (!TextUtils.isEmpty(this.logMessage.message) && this.logMessage.message.length() > 5000) {
                    this.logMessage.message = this.logMessage.message.substring(0, 5000);
                }
                this.logStorage.insert(new LogModel(format, this.logMessage.level, this.logMessage.message, this.logMessage.stacktrace, convertExtrasToJSON(this.logMessage.extras), this.logMessage.sdkVersion));
            }
        } catch (Exception e) {
            Log.e("LogWorkerThread", "Exception in log messages worker : ", e);
        }
    }
}
