package com.unity3d.services.core.request;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class SDKMetrics {
    public static ISDKMetrics _instance = new NullInstance();

    public static final class MetricInstance implements ISDKMetrics {
        public final ExecutorService _executorService = Executors.newSingleThreadExecutor();
        public final String _metricsUrl;

        public MetricInstance(String str) {
            this._metricsUrl = str;
        }

        public void sendEvent(String str) {
            sendEventWithTags(str, (Map<String, String>) null);
        }

        public void sendEventWithTags(final String str, final Map<String, String> map) {
            if (TextUtils.isEmpty(str)) {
                DeviceLog.debug("Metric event not sent due to being nil or empty: " + str);
            } else if (TextUtils.isEmpty(this._metricsUrl)) {
                StringBuilder outline27 = GeneratedOutlineSupport.outline27("Metric: ", str, " was not sent to nil or empty endpoint: ");
                outline27.append(this._metricsUrl);
                DeviceLog.debug(outline27.toString());
            } else if (this._executorService.isShutdown()) {
                DeviceLog.debug("Metric " + str + " was not sent due to misconfiguration");
            } else {
                this._executorService.submit(new Runnable() {
                    public void run() {
                        String str = "";
                        try {
                            if (map != null) {
                                JSONObject jSONObject = new JSONObject(map);
                                str = ",\"t\":" + jSONObject.toString();
                            }
                            WebRequest webRequest = new WebRequest(MetricInstance.this._metricsUrl, "POST", (Map<String, List<String>>) null);
                            webRequest.setBody("{\"m\":[{\"n\":\"" + str + "\"" + str + "}],\"t\":{\"iso\":\"" + Device.getNetworkCountryISO() + "\",\"plt\":\"android\",\"sdv\":\"" + SdkProperties.getVersionName() + "\"}}");
                            webRequest.makeRequest();
                            if (webRequest.getResponseCode() / 100 == 2) {
                                DeviceLog.debug("Metric " + str + " sent to " + MetricInstance.this._metricsUrl);
                                return;
                            }
                            DeviceLog.debug("Metric " + str + " failed to send with response code: " + webRequest.getResponseCode());
                        } catch (Exception e) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Metric ");
                            outline24.append(str);
                            outline24.append(" failed to send from exception: ");
                            outline24.append(e.getMessage());
                            DeviceLog.debug(outline24.toString());
                        }
                    }
                });
            }
        }

        public void shutdown() {
            this._executorService.shutdown();
        }
    }

    public static final class NullInstance implements ISDKMetrics {
        public NullInstance() {
        }

        public void sendEvent(String str) {
            DeviceLog.debug("Metric " + str + " was skipped from being sent");
        }

        public void sendEventWithTags(String str, Map<String, String> map) {
            sendEvent(str);
        }
    }

    public static ISDKMetrics getInstance() {
        return _instance;
    }

    public static void setConfiguration(Configuration configuration) {
        if (configuration == null) {
            DeviceLog.debug("Metrics will not be sent from the device for this session due to misconfiguration");
            return;
        }
        ISDKMetrics iSDKMetrics = _instance;
        if (iSDKMetrics instanceof MetricInstance) {
            ((MetricInstance) iSDKMetrics).shutdown();
        }
        if (configuration.getMetricSampleRate() >= ((double) (new Random().nextInt(99) + 1))) {
            _instance = new MetricInstance(configuration.getMetricsUrl());
            return;
        }
        DeviceLog.debug("Metrics will not be sent from the device for this session");
        _instance = new NullInstance();
    }
}
