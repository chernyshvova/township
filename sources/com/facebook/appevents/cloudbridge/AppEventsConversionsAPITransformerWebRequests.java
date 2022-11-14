package com.facebook.appevents.cloudbridge;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
public final class AppEventsConversionsAPITransformerWebRequests {
    public static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = zzam.hashSetOf(200, 202);
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    public static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;
    public static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = zzam.hashSetOf(503, 504, 429);
    public static final String TAG = "CAPITransformerWebRequests";
    public static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    public static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    /* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
    public static final class CloudBridgeCredentials {
        public final String accessKey;
        public final String cloudBridgeURL;
        public final String datasetID;

        public CloudBridgeCredentials(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "datasetID");
            Intrinsics.checkNotNullParameter(str2, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(str3, "accessKey");
            this.datasetID = str;
            this.cloudBridgeURL = str2;
            this.accessKey = str3;
        }

        public static /* synthetic */ CloudBridgeCredentials copy$default(CloudBridgeCredentials cloudBridgeCredentials, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudBridgeCredentials.datasetID;
            }
            if ((i & 2) != 0) {
                str2 = cloudBridgeCredentials.cloudBridgeURL;
            }
            if ((i & 4) != 0) {
                str3 = cloudBridgeCredentials.accessKey;
            }
            return cloudBridgeCredentials.copy(str, str2, str3);
        }

        public final String component1() {
            return this.datasetID;
        }

        public final String component2() {
            return this.cloudBridgeURL;
        }

        public final String component3() {
            return this.accessKey;
        }

        public final CloudBridgeCredentials copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "datasetID");
            Intrinsics.checkNotNullParameter(str2, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(str3, "accessKey");
            return new CloudBridgeCredentials(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return Intrinsics.areEqual(this.datasetID, cloudBridgeCredentials.datasetID) && Intrinsics.areEqual(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && Intrinsics.areEqual(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        public final String getAccessKey() {
            return this.accessKey;
        }

        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        public final String getDatasetID() {
            return this.datasetID;
        }

        public int hashCode() {
            return this.accessKey.hashCode() + GeneratedOutlineSupport.outline4(this.cloudBridgeURL, this.datasetID.hashCode() * 31, 31);
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("CloudBridgeCredentials(datasetID=");
            outline24.append(this.datasetID);
            outline24.append(", cloudBridgeURL=");
            outline24.append(this.cloudBridgeURL);
            outline24.append(", accessKey=");
            outline24.append(this.accessKey);
            outline24.append(')');
            return outline24.toString();
        }
    }

    public static final void configure(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "datasetID");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "accessKey");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", str, str2, str3);
        INSTANCE.setCredentials$facebook_core_release(new CloudBridgeCredentials(str, str2, str3));
        INSTANCE.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    public static final String getCredentials() {
        try {
            CloudBridgeCredentials credentials$facebook_core_release = INSTANCE.getCredentials$facebook_core_release();
            if (credentials$facebook_core_release == null) {
                return null;
            }
            return credentials$facebook_core_release.toString();
        } catch (UninitializedPropertyAccessException unused) {
            return null;
        }
    }

    public static /* synthetic */ void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, Integer num, List list, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 5;
        }
        appEventsConversionsAPITransformerWebRequests.handleError$facebook_core_release(num, list, i);
    }

    public static /* synthetic */ void makeHttpRequest$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, String str, String str2, String str3, Map map, int i, Function2 function2, int i2, Object obj) {
        appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, str2, str3, map, (i2 & 16) != 0 ? 60000 : i, function2);
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest graphRequest) {
        JSONObject graphObject = graphRequest.getGraphObject();
        if (graphObject == null) {
            return null;
        }
        Utility utility = Utility.INSTANCE;
        Map<String, Object> mutableMap = zzam.toMutableMap(Utility.convertJSONObjectToHashMap(graphObject));
        Object tag = graphRequest.getTag();
        if (tag != null) {
            ((HashMap) mutableMap).put("custom_events", tag);
            StringBuilder sb = new StringBuilder();
            LinkedHashMap linkedHashMap = (LinkedHashMap) mutableMap;
            for (String str : linkedHashMap.keySet()) {
                sb.append(str);
                sb.append(" : ");
                sb.append(linkedHashMap.get(str));
                sb.append(System.getProperty("line.separator"));
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb);
            return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(mutableMap);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public static final void transformGraphRequestAndSendToCAPIGEndPoint(GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new Runnable() {
            public final void run() {
                AppEventsConversionsAPITransformerWebRequests.m3567transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest.this);
            }
        });
    }

    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0  reason: not valid java name */
    public static final void m3567transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest graphRequest) {
        List<T> list;
        Intrinsics.checkNotNullParameter(graphRequest, "$request");
        String graphPath = graphRequest.getGraphPath();
        List split$default = graphPath == null ? null : CharsKt__CharKt.split$default(graphPath, new String[]{"/"}, false, 0, 6);
        if (split$default == null || split$default.size() != 2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", graphRequest);
            return;
        }
        try {
            String str = INSTANCE.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + INSTANCE.getCredentials$facebook_core_release().getDatasetID() + "/events";
            List<Map<String, Object>> transformAppEventRequestForCAPIG = INSTANCE.transformAppEventRequestForCAPIG(graphRequest);
            if (transformAppEventRequestForCAPIG != null) {
                INSTANCE.appendEvents$facebook_core_release(transformAppEventRequestForCAPIG);
                int min = Math.min(INSTANCE.getTransformedEvents$facebook_core_release().size(), 10);
                List<Map<String, Object>> transformedEvents$facebook_core_release = INSTANCE.getTransformedEvents$facebook_core_release();
                IntRange intRange = new IntRange(0, min - 1);
                Intrinsics.checkNotNullParameter(transformedEvents$facebook_core_release, "$this$slice");
                Intrinsics.checkNotNullParameter(intRange, "indices");
                if (intRange.isEmpty()) {
                    list = EmptyList.INSTANCE;
                } else {
                    list = CollectionsKt__CollectionsKt.toList(transformedEvents$facebook_core_release.subList(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
                }
                INSTANCE.getTransformedEvents$facebook_core_release().subList(0, min).clear();
                JSONArray jSONArray = new JSONArray(list);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONArray);
                linkedHashMap.put("accessKey", INSTANCE.getCredentials$facebook_core_release().getAccessKey());
                JSONObject jSONObject = new JSONObject(linkedHashMap);
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String jSONObject2 = jSONObject.toString(2);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonBodyStr.toString(2)");
                companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, graphRequest, jSONObject2);
                AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
                String jSONObject3 = jSONObject.toString();
                Pair pair = new Pair("Content-Type", "application/json");
                Intrinsics.checkNotNullParameter(pair, "pair");
                Map singletonMap = Collections.singletonMap(pair.first, pair.second);
                Intrinsics.checkNotNullExpressionValue(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
                appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, "POST", jSONObject3, singletonMap, 60000, new C1529xf719cce4(list));
            }
        } catch (UninitializedPropertyAccessException e) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e);
        }
    }

    public final void appendEvents$facebook_core_release(List<? extends Map<String, ? extends Object>> list) {
        List<T> list2;
        if (list != null) {
            getTransformedEvents$facebook_core_release().addAll(list);
        }
        boolean z = false;
        int max = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (max > 0) {
            List<Map<String, Object>> transformedEvents$facebook_core_release = getTransformedEvents$facebook_core_release();
            Intrinsics.checkNotNullParameter(transformedEvents$facebook_core_release, "$this$drop");
            if (max >= 0) {
                z = true;
            }
            if (z) {
                if (max == 0) {
                    list2 = CollectionsKt__CollectionsKt.toList(transformedEvents$facebook_core_release);
                } else {
                    int size = transformedEvents$facebook_core_release.size() - max;
                    if (size <= 0) {
                        list2 = EmptyList.INSTANCE;
                    } else if (size == 1) {
                        Intrinsics.checkNotNullParameter(transformedEvents$facebook_core_release, "$this$last");
                        list2 = zzam.listOf(CollectionsKt__CollectionsKt.last(transformedEvents$facebook_core_release));
                    } else {
                        ArrayList arrayList = new ArrayList(size);
                        if (transformedEvents$facebook_core_release instanceof RandomAccess) {
                            int size2 = transformedEvents$facebook_core_release.size();
                            while (max < size2) {
                                arrayList.add(transformedEvents$facebook_core_release.get(max));
                                max++;
                            }
                        } else {
                            ListIterator<Map<String, Object>> listIterator = transformedEvents$facebook_core_release.listIterator(max);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        list2 = arrayList;
                    }
                }
                Class<TypeIntrinsics> cls = TypeIntrinsics.class;
                if (list2 instanceof KMappedMarker) {
                    ClassCastException classCastException = new ClassCastException(GeneratedOutlineSupport.outline17(list2.getClass().getName(), " cannot be cast to ", "kotlin.collections.MutableList"));
                    Intrinsics.sanitizeStackTrace(classCastException, cls.getName());
                    throw classCastException;
                }
                setTransformedEvents$facebook_core_release(list2);
                return;
            }
            throw new IllegalArgumentException(("Requested element count " + max + " is less than zero.").toString());
        }
    }

    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        Intrinsics.throwUninitializedPropertyAccessException("credentials");
        throw null;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return currentRetryCount;
    }

    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(Integer num, List<? extends Map<String, ? extends Object>> list, int i) {
        Intrinsics.checkNotNullParameter(list, "processedEvents");
        if (!CollectionsKt__CollectionsKt.contains(RETRY_EVENTS_HTTP_RESPONSE, num)) {
            return;
        }
        if (currentRetryCount >= i) {
            getTransformedEvents$facebook_core_release().clear();
            currentRetryCount = 0;
            return;
        }
        getTransformedEvents$facebook_core_release().addAll(0, list);
        currentRetryCount++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        com.android.billingclient.api.zzam.closeFinally(r10, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        com.android.billingclient.api.zzam.closeFinally(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b A[Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e1 A[Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeHttpRequest$facebook_core_release(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, int r12, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> r13) {
        /*
            r7 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "CAPITransformerWebRequests"
            java.lang.String r2 = "urlStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.lang.String r2 = "requestMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            r2 = 0
            r3 = 0
            r4 = 1
            java.net.URL r5 = new java.net.URL     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r5.<init>(r8)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.net.URLConnection r8 = r5.openConnection()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r8 == 0) goto L_0x00ed
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r8.setRequestMethod(r9)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r11 != 0) goto L_0x0024
            goto L_0x0045
        L_0x0024:
            java.util.Set r9 = r11.keySet()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r9 != 0) goto L_0x002b
            goto L_0x0045
        L_0x002b:
            java.util.Iterator r9 = r9.iterator()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
        L_0x002f:
            boolean r5 = r9.hasNext()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r9.next()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.Object r6 = r11.get(r5)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r8.setRequestProperty(r5, r6)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            goto L_0x002f
        L_0x0045:
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r11 = "POST"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r9 != 0) goto L_0x0060
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r11 = "PUT"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r9 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r9 = 0
            goto L_0x0061
        L_0x0060:
            r9 = 1
        L_0x0061:
            r8.setDoOutput(r9)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r8.setConnectTimeout(r12)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.io.OutputStream r11 = r8.getOutputStream()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r9.<init>(r11)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r12.<init>(r9, r0)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r11.<init>(r12)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r11.write(r10)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r11.flush()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r11.close()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r9.close()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r9.<init>()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.util.HashSet<java.lang.Integer> r10 = ACCEPTABLE_HTTP_RESPONSE     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            int r11 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            boolean r10 = r10.contains(r11)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r10 == 0) goto L_0x00be
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.io.InputStream r12 = r8.getInputStream()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r11.<init>(r12, r0)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r10.<init>(r11)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
        L_0x00a9:
            java.lang.String r11 = r10.readLine()     // Catch:{ all -> 0x00b7 }
            if (r11 == 0) goto L_0x00b3
            r9.append(r11)     // Catch:{ all -> 0x00b7 }
            goto L_0x00a9
        L_0x00b3:
            com.android.billingclient.api.zzam.closeFinally(r10, r2)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            goto L_0x00be
        L_0x00b7:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r9 = move-exception
            com.android.billingclient.api.zzam.closeFinally(r10, r8)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            throw r9     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
        L_0x00be:
            java.lang.String r9 = r9.toString()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r10 = "connResponseSB.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            com.facebook.LoggingBehavior r11 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r12 = "\nResponse Received: \n%s\n%s"
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r0[r3] = r9     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            int r5 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r0[r4] = r5     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r10.log((com.facebook.LoggingBehavior) r11, (java.lang.String) r1, (java.lang.String) r12, (java.lang.Object[]) r0)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            if (r13 == 0) goto L_0x0125
            int r8 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            r13.invoke(r9, r8)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            goto L_0x0125
        L_0x00ed:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            java.lang.String r9 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r8.<init>(r9)     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
            throw r8     // Catch:{ UnknownHostException -> 0x0108, IOException -> 0x00f5 }
        L_0x00f5:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Send to server failed: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            goto L_0x0125
        L_0x0108:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Connection failed, retrying: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            if (r13 == 0) goto L_0x0125
            r8 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r13.invoke(r2, r8)
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.functions.Function2):void");
    }

    public final void setCredentials$facebook_core_release(CloudBridgeCredentials cloudBridgeCredentials) {
        Intrinsics.checkNotNullParameter(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final void setCurrentRetryCount$facebook_core_release(int i) {
        currentRetryCount = i;
    }

    public final void setTransformedEvents$facebook_core_release(List<Map<String, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        transformedEvents = list;
    }
}
