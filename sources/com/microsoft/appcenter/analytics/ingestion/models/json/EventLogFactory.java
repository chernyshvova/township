package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;
import com.microsoft.appcenter.ingestion.models.one.AppExtension;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.Data;
import com.microsoft.appcenter.ingestion.models.one.DeviceExtension;
import com.microsoft.appcenter.ingestion.models.one.Extensions;
import com.microsoft.appcenter.ingestion.models.one.LocExtension;
import com.microsoft.appcenter.ingestion.models.one.MetadataExtension;
import com.microsoft.appcenter.ingestion.models.one.NetExtension;
import com.microsoft.appcenter.ingestion.models.one.OsExtension;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.ingestion.models.one.ProtocolExtension;
import com.microsoft.appcenter.ingestion.models.one.SdkExtension;
import com.microsoft.appcenter.ingestion.models.one.UserExtension;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class EventLogFactory extends AbstractLogFactory {
    public Log create() {
        return new EventLog();
    }

    public Collection<CommonSchemaLog> toCommonSchemaLogs(Log log) {
        LinkedList linkedList;
        Iterator<String> it;
        MetadataExtension metadataExtension;
        String str;
        MetadataExtension metadataExtension2;
        Iterator<TypedProperty> it2;
        String str2;
        LinkedList linkedList2 = new LinkedList();
        Iterator<String> it3 = log.getTransmissionTargetTokens().iterator();
        while (it3.hasNext()) {
            String next = it3.next();
            CommonSchemaEventLog commonSchemaEventLog = new CommonSchemaEventLog();
            EventLog eventLog = (EventLog) log;
            PartAUtils.setName(commonSchemaEventLog, eventLog.name);
            Device device = log.getDevice();
            commonSchemaEventLog.ver = "3.0";
            commonSchemaEventLog.timestamp = log.getTimestamp();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("o:");
            outline24.append(next.split("-")[0]);
            commonSchemaEventLog.iKey = outline24.toString();
            synchronized (commonSchemaEventLog) {
                commonSchemaEventLog.transmissionTargetTokens.add(next);
            }
            if (commonSchemaEventLog.ext == null) {
                commonSchemaEventLog.ext = new Extensions();
            }
            commonSchemaEventLog.ext.protocol = new ProtocolExtension();
            Extensions extensions = commonSchemaEventLog.ext;
            ProtocolExtension protocolExtension = extensions.protocol;
            protocolExtension.devModel = device.model;
            protocolExtension.devMake = device.oemName;
            extensions.user = new UserExtension();
            UserExtension userExtension = commonSchemaEventLog.ext.user;
            String userId = log.getUserId();
            if (userId != null && !userId.contains(CertificateUtil.DELIMITER)) {
                userId = GeneratedOutlineSupport.outline16("c:", userId);
            }
            userExtension.localId = userId;
            commonSchemaEventLog.ext.user.locale = device.locale.replace("_", "-");
            commonSchemaEventLog.ext.f3584os = new OsExtension();
            OsExtension osExtension = commonSchemaEventLog.ext.f3584os;
            osExtension.name = device.osName;
            osExtension.ver = device.osVersion + "-" + device.osBuild + "-" + device.osApiLevel;
            commonSchemaEventLog.ext.app = new AppExtension();
            AppExtension appExtension = commonSchemaEventLog.ext.app;
            appExtension.ver = device.appVersion;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("a:");
            outline242.append(device.appNamespace);
            appExtension.f3582id = outline242.toString();
            commonSchemaEventLog.ext.net = new NetExtension();
            Extensions extensions2 = commonSchemaEventLog.ext;
            extensions2.net.provider = device.carrierName;
            extensions2.sdk = new SdkExtension();
            commonSchemaEventLog.ext.sdk.libVer = device.sdkName + "-" + device.sdkVersion;
            commonSchemaEventLog.ext.loc = new LocExtension();
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = device.timeZoneOffset.intValue() >= 0 ? "+" : "-";
            objArr[1] = Integer.valueOf(Math.abs(device.timeZoneOffset.intValue() / 60));
            objArr[2] = Integer.valueOf(Math.abs(device.timeZoneOffset.intValue() % 60));
            String format = String.format(locale, "%s%02d:%02d", objArr);
            Extensions extensions3 = commonSchemaEventLog.ext;
            extensions3.loc.f3585tz = format;
            extensions3.device = new DeviceExtension();
            List<TypedProperty> list = eventLog.typedProperties;
            String str3 = "baseData";
            if (list != null) {
                try {
                    Data data = new Data();
                    commonSchemaEventLog.data = data;
                    MetadataExtension metadataExtension3 = new MetadataExtension();
                    Iterator<TypedProperty> it4 = list.iterator();
                    while (true) {
                        int i = null;
                        if (!it4.hasNext()) {
                            break;
                        }
                        TypedProperty next2 = it4.next();
                        try {
                            Object validateProperty = zzam.validateProperty(next2);
                            if (next2 instanceof LongTypedProperty) {
                                i = 4;
                            } else if (next2 instanceof DoubleTypedProperty) {
                                i = 6;
                            } else if (next2 instanceof DateTimeTypedProperty) {
                                i = 9;
                            }
                            String[] split = next2.name.split("\\.", -1);
                            int length = split.length - 1;
                            JSONObject jSONObject = data.mProperties;
                            JSONObject jSONObject2 = metadataExtension3.mMetadata;
                            it = it3;
                            it2 = it4;
                            int i2 = 0;
                            while (true) {
                                linkedList = linkedList2;
                                if (i2 >= length) {
                                    break;
                                }
                                MetadataExtension metadataExtension4 = metadataExtension3;
                                try {
                                    String str4 = split[i2];
                                    JSONObject optJSONObject = jSONObject.optJSONObject(str4);
                                    if (optJSONObject == null) {
                                        if (jSONObject.has(str4)) {
                                            str2 = str3;
                                            AppCenterLog.warn("AppCenter", "Property key '" + str4 + "' already has a value, the old value will be overridden.");
                                        } else {
                                            str2 = str3;
                                        }
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject.put(str4, jSONObject3);
                                        jSONObject = jSONObject3;
                                    } else {
                                        str2 = str3;
                                        jSONObject = optJSONObject;
                                    }
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("f");
                                    if (optJSONObject2 == null) {
                                        optJSONObject2 = new JSONObject();
                                        jSONObject2.put("f", optJSONObject2);
                                    }
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(str4);
                                    if (optJSONObject3 == null) {
                                        optJSONObject3 = new JSONObject();
                                        optJSONObject2.put(str4, optJSONObject3);
                                    }
                                    jSONObject2 = optJSONObject3;
                                    i2++;
                                    linkedList2 = linkedList;
                                    metadataExtension3 = metadataExtension4;
                                    str3 = str2;
                                } catch (JSONException unused) {
                                }
                            }
                            str = str3;
                            metadataExtension2 = metadataExtension3;
                            String str5 = split[length];
                            if (jSONObject.has(str5)) {
                                AppCenterLog.warn("AppCenter", "Property key '" + str5 + "' already has a value, the old value will be overridden.");
                            }
                            jSONObject.put(str5, validateProperty);
                            JSONObject optJSONObject4 = jSONObject2.optJSONObject("f");
                            if (i != null) {
                                if (optJSONObject4 == null) {
                                    optJSONObject4 = new JSONObject();
                                    jSONObject2.put("f", optJSONObject4);
                                }
                                optJSONObject4.put(str5, i);
                            } else if (optJSONObject4 != null) {
                                optJSONObject4.remove(str5);
                            }
                        } catch (IllegalArgumentException e) {
                            linkedList = linkedList2;
                            it = it3;
                            str = str3;
                            metadataExtension2 = metadataExtension3;
                            it2 = it4;
                            AppCenterLog.warn("AppCenter", e.getMessage());
                        }
                        it3 = it;
                        it4 = it2;
                        linkedList2 = linkedList;
                        metadataExtension3 = metadataExtension2;
                        str3 = str;
                    }
                    linkedList = linkedList2;
                    it = it3;
                    MetadataExtension metadataExtension5 = metadataExtension3;
                    JSONObject jSONObject4 = data.mProperties;
                    String optString = jSONObject4.optString("baseType", (String) null);
                    String str6 = str3;
                    JSONObject optJSONObject5 = jSONObject4.optJSONObject(str6);
                    if (optString != null || optJSONObject5 == null) {
                        metadataExtension = metadataExtension5;
                    } else {
                        AppCenterLog.warn("AppCenter", "baseData was set but baseType is missing.");
                        jSONObject4.remove(str6);
                        metadataExtension = metadataExtension5;
                        metadataExtension.mMetadata.optJSONObject("f").remove(str6);
                    }
                    if (optString != null && optJSONObject5 == null) {
                        AppCenterLog.warn("AppCenter", "baseType was set but baseData is missing.");
                        jSONObject4.remove("baseType");
                    }
                    if (!zzam.cleanUpEmptyObjectsInMetadata(metadataExtension.mMetadata)) {
                        if (commonSchemaEventLog.ext == null) {
                            commonSchemaEventLog.ext = new Extensions();
                        }
                        commonSchemaEventLog.ext.metadata = metadataExtension;
                    }
                } catch (JSONException unused2) {
                }
                linkedList2 = linkedList;
                linkedList2.add(commonSchemaEventLog);
                commonSchemaEventLog.tag = log.getTag();
                it3 = it;
            }
            linkedList = linkedList2;
            it = it3;
            linkedList2 = linkedList;
            linkedList2.add(commonSchemaEventLog);
            commonSchemaEventLog.tag = log.getTag();
            it3 = it;
        }
        return linkedList2;
    }
}
