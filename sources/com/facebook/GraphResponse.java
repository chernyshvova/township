package com.facebook;

import android.util.Log;
import com.android.billingclient.api.zzam;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: GraphResponse.kt */
public final class GraphResponse {
    public static final String BODY_KEY = "body";
    public static final String CODE_KEY = "code";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    public static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    public static final String TAG = GraphResponse.class.getCanonicalName();
    public final HttpURLConnection connection;
    public final FacebookRequestError error;
    public final JSONObject graphObject;
    public final JSONArray graphObjectArray;
    public final JSONArray jsonArray;
    public final JSONObject jsonObject;
    public final String rawResponse;
    public final GraphRequest request;

    /* compiled from: GraphResponse.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
            Boolean bool = null;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                FacebookRequestError checkResponseAndCreateError = FacebookRequestError.Companion.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
                if (checkResponseAndCreateError != null) {
                    Log.e(GraphResponse.TAG, checkResponseAndCreateError.toString());
                    if (checkResponseAndCreateError.getErrorCode() == 190) {
                        Utility utility = Utility.INSTANCE;
                        if (Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                            if (checkResponseAndCreateError.getSubErrorCode() != 493) {
                                AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
                            } else {
                                AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                                if (currentAccessToken != null) {
                                    bool = Boolean.valueOf(currentAccessToken.isExpired());
                                }
                                if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                                    AccessToken.Companion.expireCurrentAccessToken();
                                }
                            }
                        }
                    }
                    return new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
                }
                Utility utility2 = Utility.INSTANCE;
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, jSONObject2.toString(), jSONObject2);
                } else if (stringPropertyAsJSON instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, jSONArray.toString(), jSONArray);
                } else {
                    obj = JSONObject.NULL;
                    Intrinsics.checkNotNullExpressionValue(obj, "NULL");
                }
            }
            if (obj == JSONObject.NULL) {
                return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
            }
            throw new FacebookException(Intrinsics.stringPlus("Got unexpected object type in response, class: ", obj.getClass().getSimpleName()));
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.List<com.facebook.GraphResponse> createResponsesFromObject(java.net.HttpURLConnection r9, java.util.List<com.facebook.GraphRequest> r10, java.lang.Object r11) throws com.facebook.FacebookException, org.json.JSONException {
            /*
                r8 = this;
                int r0 = r10.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
                r3 = 1
                if (r0 != r3) goto L_0x0051
                java.lang.Object r3 = r10.get(r2)
                com.facebook.GraphRequest r3 = (com.facebook.GraphRequest) r3
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                r4.<init>()     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                java.lang.String r5 = "body"
                r4.put(r5, r11)     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                if (r9 != 0) goto L_0x0022
                r5 = 200(0xc8, float:2.8E-43)
                goto L_0x0026
            L_0x0022:
                int r5 = r9.getResponseCode()     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
            L_0x0026:
                java.lang.String r6 = "code"
                r4.put(r6, r5)     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                r5.<init>()     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                r5.put(r4)     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                goto L_0x0052
            L_0x0034:
                r4 = move-exception
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r3, r9, r6)
                r1.add(r5)
                goto L_0x0051
            L_0x0043:
                r4 = move-exception
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r3, r9, r6)
                r1.add(r5)
            L_0x0051:
                r5 = r11
            L_0x0052:
                boolean r3 = r5 instanceof org.json.JSONArray
                if (r3 == 0) goto L_0x00a4
                r3 = r5
                org.json.JSONArray r3 = (org.json.JSONArray) r3
                int r4 = r3.length()
                if (r4 != r0) goto L_0x00a4
                int r0 = r3.length()
                if (r0 <= 0) goto L_0x00a3
            L_0x0065:
                int r3 = r2 + 1
                java.lang.Object r4 = r10.get(r2)
                com.facebook.GraphRequest r4 = (com.facebook.GraphRequest) r4
                r6 = r5
                org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                java.lang.Object r2 = r6.get(r2)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                java.lang.String r6 = "obj"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                com.facebook.GraphResponse r2 = r8.createResponseFromObject(r4, r9, r2, r11)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                r1.add(r2)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                goto L_0x009e
            L_0x0081:
                r2 = move-exception
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r2)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
                goto L_0x009e
            L_0x0090:
                r2 = move-exception
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r2)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
            L_0x009e:
                if (r3 < r0) goto L_0x00a1
                goto L_0x00a3
            L_0x00a1:
                r2 = r3
                goto L_0x0065
            L_0x00a3:
                return r1
            L_0x00a4:
                com.facebook.FacebookException r9 = new com.facebook.FacebookException
                java.lang.String r10 = "Unexpected number of results"
                r9.<init>((java.lang.String) r10)
                goto L_0x00ad
            L_0x00ac:
                throw r9
            L_0x00ad:
                goto L_0x00ac
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.Companion.createResponsesFromObject(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
        }

        public final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
            Intrinsics.checkNotNullParameter(list, "requests");
            ArrayList arrayList = new ArrayList(zzam.collectionSizeOrDefault(list, 10));
            for (GraphRequest graphResponse : list) {
                arrayList.add(new GraphResponse(graphResponse, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) facebookException)));
            }
            return arrayList;
        }

        public final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Utility utility = Utility.INSTANCE;
            String readStreamToString = Utility.readStreamToString(inputStream);
            Logger.Companion.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, GraphResponse.RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
            return createResponsesFromString$facebook_core_release(readStreamToString, httpURLConnection, graphRequestBatch);
        }

        public final List<GraphResponse> createResponsesFromString$facebook_core_release(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
            Intrinsics.checkNotNullParameter(str, "responseString");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Object nextValue = new JSONTokener(str).nextValue();
            Intrinsics.checkNotNullExpressionValue(nextValue, "resultObject");
            List<GraphResponse> createResponsesFromObject = createResponsesFromObject(httpURLConnection, graphRequestBatch, nextValue);
            Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject);
            return createResponsesFromObject;
        }

        public final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            List<GraphResponse> constructErrorResponses;
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            InputStream inputStream = null;
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.isFullyInitialized()) {
                    if (httpURLConnection.getResponseCode() >= 400) {
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    constructErrorResponses = createResponsesFromStream$facebook_core_release(inputStream, httpURLConnection, graphRequestBatch);
                    Utility utility = Utility.INSTANCE;
                    Utility.closeQuietly(inputStream);
                    return constructErrorResponses;
                }
                Log.e(GraphResponse.TAG, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
            } catch (FacebookException e) {
                Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e);
                constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, e);
            } catch (Exception e2) {
                Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
                constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException((Throwable) e2));
            } catch (Throwable th) {
                Utility utility2 = Utility.INSTANCE;
                Utility.closeQuietly((Closeable) null);
                throw th;
            }
        }
    }

    /* compiled from: GraphResponse.kt */
    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
        this.jsonObject = jSONObject;
        this.jsonArray = jSONArray;
    }

    public static final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        return Companion.constructErrorResponses(list, httpURLConnection, facebookException);
    }

    public static final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        return Companion.createResponsesFromStream$facebook_core_release(inputStream, httpURLConnection, graphRequestBatch);
    }

    public static final List<GraphResponse> createResponsesFromString$facebook_core_release(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        return Companion.createResponsesFromString$facebook_core_release(str, httpURLConnection, graphRequestBatch);
    }

    public static final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.fromHttpConnection$facebook_core_release(httpURLConnection, graphRequestBatch);
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    public final JSONArray getJsonArray() {
        return this.jsonArray;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final String getRawResponse() {
        return this.rawResponse;
    }

    public final GraphRequest getRequest() {
        return this.request;
    }

    public final GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String str;
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(pagingDirection, "direction");
        JSONObject jSONObject = this.graphObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("paging")) == null) {
            str = null;
        } else {
            str = pagingDirection == PagingDirection.NEXT ? optJSONObject.optString("next") : optJSONObject.optString("previous");
        }
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(str)) {
            return null;
        }
        if (str != null && Intrinsics.areEqual(str, this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new GraphRequest(this.request.getAccessToken(), new URL(str));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.connection;
            objArr[0] = Integer.valueOf(httpURLConnection == null ? 200 : httpURLConnection.getResponseCode());
            str = String.format(locale, "%d", Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response: " + " responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, (JSONArray) null, (FacebookRequestError) null);
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(str, "rawResponse");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, (JSONObject) null, jSONArray, (FacebookRequestError) null);
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(str, "rawResponse");
        Intrinsics.checkNotNullParameter(jSONArray, "graphObjects");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, (String) null, (JSONObject) null, (JSONArray) null, facebookRequestError);
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(facebookRequestError, "error");
    }
}
