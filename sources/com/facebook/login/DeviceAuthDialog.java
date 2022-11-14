package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.DialogFragment;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.C1541R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginClient;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceAuthDialog.kt */
public class DeviceAuthDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    public static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    public static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    public static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    public static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    public static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    public static final String REQUEST_STATE_KEY = "request_state";
    public final AtomicBoolean completed = new AtomicBoolean();
    public TextView confirmationCode;
    public volatile GraphRequestAsyncTask currentGraphRequestPoll;
    public volatile RequestState currentRequestState;
    public DeviceAuthMethodHandler deviceAuthMethodHandler;
    public TextView instructions;
    public boolean isBeingDestroyed;
    public boolean isRetry;
    public View progressBar;
    public LoginClient.Request request;
    public volatile ScheduledFuture<?> scheduledPoll;

    /* compiled from: DeviceAuthDialog.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations() {
        }

        @VisibleForTesting
        /* renamed from: getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations */
        public static /* synthetic */ void m2717x325a321() {
        }

        @VisibleForTesting
        /* renamed from: getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations */
        public static /* synthetic */ void m2718x25858264() {
        }

        /* access modifiers changed from: private */
        public final PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
            String optString;
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("permission");
                    Intrinsics.checkNotNullExpressionValue(optString2, "permission");
                    if (!(optString2.length() == 0) && !Intrinsics.areEqual(optString2, "installed") && (optString = optJSONObject.optString("status")) != null) {
                        int hashCode = optString.hashCode();
                        if (hashCode != -1309235419) {
                            if (hashCode != 280295099) {
                                if (hashCode == 568196142 && optString.equals("declined")) {
                                    arrayList2.add(optString2);
                                }
                            } else if (optString.equals("granted")) {
                                arrayList.add(optString2);
                            }
                        } else if (optString.equals("expired")) {
                            arrayList3.add(optString2);
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return new PermissionsLists(arrayList, arrayList2, arrayList3);
        }

        public final String getDEVICE_LOGIN_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_ENDPOINT;
        }

        public final String getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_STATUS_ENDPOINT;
        }

        /* renamed from: getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release */
        public final int mo13881xe18b7be4() {
            return DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING;
        }
    }

    /* compiled from: DeviceAuthDialog.kt */
    public static final class PermissionsLists {
        public List<String> declinedPermissions;
        public List<String> expiredPermissions;
        public List<String> grantedPermissions;

        public PermissionsLists(List<String> list, List<String> list2, List<String> list3) {
            Intrinsics.checkNotNullParameter(list, "grantedPermissions");
            Intrinsics.checkNotNullParameter(list2, "declinedPermissions");
            Intrinsics.checkNotNullParameter(list3, "expiredPermissions");
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final void setExpiredPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.expiredPermissions = list;
        }

        public final void setGrantedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.grantedPermissions = list;
        }
    }

    /* compiled from: DeviceAuthDialog.kt */
    public static final class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new DeviceAuthDialog$RequestState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public String authorizationUri;
        public long interval;
        public long lastPoll;
        public String requestCode;
        public String userCode;

        /* compiled from: DeviceAuthDialog.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RequestState() {
        }

        public int describeContents() {
            return 0;
        }

        public final String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final String getRequestCode() {
            return this.requestCode;
        }

        public final String getUserCode() {
            return this.userCode;
        }

        public final void setInterval(long j) {
            this.interval = j;
        }

        public final void setLastPoll(long j) {
            this.lastPoll = j;
        }

        public final void setRequestCode(String str) {
            this.requestCode = str;
        }

        public final void setUserCode(String str) {
            this.userCode = str;
            String format = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            this.authorizationUri = format;
        }

        public final boolean withinLastRefreshWindow() {
            if (this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                return true;
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }

        public RequestState(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }
    }

    /* renamed from: _get_pollRequest_$lambda-5  reason: not valid java name */
    public static final void m3652_get_pollRequest_$lambda5(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                int subErrorCode = error.getSubErrorCode();
                boolean z = true;
                if (!(subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING || subErrorCode == 1349172)) {
                    z = false;
                }
                if (z) {
                    deviceAuthDialog.schedulePoll();
                } else if (subErrorCode == 1349152) {
                    RequestState requestState = deviceAuthDialog.currentRequestState;
                    if (requestState != null) {
                        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                        DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                    }
                    LoginClient.Request request2 = deviceAuthDialog.request;
                    if (request2 != null) {
                        deviceAuthDialog.startLogin(request2);
                    } else {
                        deviceAuthDialog.onCancel();
                    }
                } else if (subErrorCode == 1349173) {
                    deviceAuthDialog.onCancel();
                } else {
                    FacebookRequestError error2 = graphResponse.getError();
                    FacebookException exception = error2 == null ? null : error2.getException();
                    if (exception == null) {
                        exception = new FacebookException();
                    }
                    deviceAuthDialog.onError(exception);
                }
            } else {
                try {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    String string = jSONObject.getString("access_token");
                    Intrinsics.checkNotNullExpressionValue(string, "resultObject.getString(\"access_token\")");
                    deviceAuthDialog.onSuccess(string, jSONObject.getLong(AccessToken.EXPIRES_IN_KEY), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                } catch (JSONException e) {
                    deviceAuthDialog.onError(new FacebookException((Throwable) e));
                }
            }
        }
    }

    private final void completeLogin(String str, PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler2 != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            deviceAuthMethodHandler2.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, (Date) null, date2);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final GraphRequest getPollRequest() {
        Bundle bundle = new Bundle();
        RequestState requestState = this.currentRequestState;
        bundle.putString("code", requestState == null ? null : requestState.getRequestCode());
        return GraphRequest.Companion.newPostRequestWithBundle((AccessToken) null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, new GraphRequest.Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m3652_get_pollRequest_$lambda5(DeviceAuthDialog.this, graphResponse);
            }
        });
    }

    /* renamed from: initializeContentView$lambda-2  reason: not valid java name */
    public static final void m3653initializeContentView$lambda2(DeviceAuthDialog deviceAuthDialog, View view) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        deviceAuthDialog.onCancel();
    }

    private final void onSuccess(String str, long j, Long l) {
        Date date;
        Bundle outline5 = GeneratedOutlineSupport.outline5("fields", "id,permissions,name");
        Date date2 = null;
        if (j != 0) {
            date = new Date((j * 1000) + new Date().getTime());
        } else {
            date = null;
        }
        if ((l == null || l.longValue() != 0) && l != null) {
            date2 = new Date(l.longValue() * 1000);
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, (Collection) null, (Collection) null, (Collection) null, (AccessTokenSource) null, date, (Date) null, date2, (String) null, 1024, (DefaultConstructorMarker) null), "me", new GraphRequest.Callback(str, date, date2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Date f$2;
            public final /* synthetic */ Date f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m3654onSuccess$lambda10(DeviceAuthDialog.this, this.f$1, this.f$2, this.f$3, graphResponse);
            }
        });
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(outline5);
        newGraphPathRequest.executeAsync();
    }

    /* renamed from: onSuccess$lambda-10  reason: not valid java name */
    public static final void m3654onSuccess$lambda10(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2, GraphResponse graphResponse) {
        EnumSet<SmartLoginOption> smartLoginOptions;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(str, "$accessToken");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                FacebookException exception = error.getException();
                if (exception == null) {
                    exception = new FacebookException();
                }
                deviceAuthDialog.onError(exception);
                return;
            }
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String string = jSONObject.getString("id");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"id\")");
                PermissionsLists access$handlePermissionResponse = Companion.handlePermissionResponse(jSONObject);
                String string2 = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"name\")");
                RequestState requestState = deviceAuthDialog.currentRequestState;
                if (requestState != null) {
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                }
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                Boolean bool = null;
                if (!(appSettingsWithoutQuery == null || (smartLoginOptions = appSettingsWithoutQuery.getSmartLoginOptions()) == null)) {
                    bool = Boolean.valueOf(smartLoginOptions.contains(SmartLoginOption.RequireConfirm));
                }
                if (!Intrinsics.areEqual(bool, Boolean.TRUE) || deviceAuthDialog.isRetry) {
                    deviceAuthDialog.completeLogin(string, access$handlePermissionResponse, str, date, date2);
                    return;
                }
                deviceAuthDialog.isRetry = true;
                deviceAuthDialog.presentConfirmation(string, access$handlePermissionResponse, str, string2, date, date2);
            } catch (JSONException e) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e));
            }
        }
    }

    private final void poll() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.setLastPoll(new Date().getTime());
        }
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    private final void presentConfirmation(String str, PermissionsLists permissionsLists, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(C1541R.string.com_facebook_smart_login_confirmation_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
        String string2 = getResources().getString(C1541R.string.com_facebook_smart_login_confirmation_continue_as);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
        String string3 = getResources().getString(C1541R.string.com_facebook_smart_login_confirmation_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
        String outline21 = GeneratedOutlineSupport.outline21(new Object[]{str3}, 1, string2, "java.lang.String.format(format, *args)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(outline21, new DialogInterface.OnClickListener(str, permissionsLists, str2, date, date2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ DeviceAuthDialog.PermissionsLists f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ Date f$4;
            public final /* synthetic */ Date f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.m3655presentConfirmation$lambda6(DeviceAuthDialog.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, dialogInterface, i);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.m3656presentConfirmation$lambda8(DeviceAuthDialog.this, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* renamed from: presentConfirmation$lambda-6  reason: not valid java name */
    public static final void m3655presentConfirmation$lambda6(DeviceAuthDialog deviceAuthDialog, String str, PermissionsLists permissionsLists, String str2, Date date, Date date2, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(str, "$userId");
        Intrinsics.checkNotNullParameter(permissionsLists, "$permissions");
        Intrinsics.checkNotNullParameter(str2, "$accessToken");
        deviceAuthDialog.completeLogin(str, permissionsLists, str2, date, date2);
    }

    /* renamed from: presentConfirmation$lambda-8  reason: not valid java name */
    public static final void m3656presentConfirmation$lambda8(DeviceAuthDialog deviceAuthDialog, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        View initializeContentView = deviceAuthDialog.initializeContentView(false);
        Dialog dialog = deviceAuthDialog.getDialog();
        if (dialog != null) {
            dialog.setContentView(initializeContentView);
        }
        LoginClient.Request request2 = deviceAuthDialog.request;
        if (request2 != null) {
            deviceAuthDialog.startLogin(request2);
        }
    }

    private final void schedulePoll() {
        RequestState requestState = this.currentRequestState;
        Long valueOf = requestState == null ? null : Long.valueOf(requestState.getInterval());
        if (valueOf != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.Companion.getBackgroundExecutor().schedule(new Runnable() {
                public final void run() {
                    DeviceAuthDialog.m3657schedulePoll$lambda3(DeviceAuthDialog.this);
                }
            }, valueOf.longValue(), TimeUnit.SECONDS);
        }
    }

    /* renamed from: schedulePoll$lambda-3  reason: not valid java name */
    public static final void m3657schedulePoll$lambda3(DeviceAuthDialog deviceAuthDialog) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        deviceAuthDialog.poll();
    }

    private final void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        TextView textView = this.confirmationCode;
        if (textView != null) {
            textView.setText(requestState.getUserCode());
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri()));
            TextView textView2 = this.instructions;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
                TextView textView3 = this.confirmationCode;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    View view = this.progressBar;
                    if (view != null) {
                        view.setVisibility(8);
                        if (!this.isRetry) {
                            DeviceRequestsHelper deviceRequestsHelper2 = DeviceRequestsHelper.INSTANCE;
                            if (DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
                                new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
                            }
                        }
                        if (requestState.withinLastRefreshWindow()) {
                            schedulePoll();
                        } else {
                            poll();
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("instructions");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
            throw null;
        }
    }

    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final void m3658startLogin$lambda1(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        if (!deviceAuthDialog.isBeingDestroyed) {
            if (graphResponse.getError() != null) {
                FacebookRequestError error = graphResponse.getError();
                FacebookException exception = error == null ? null : error.getException();
                if (exception == null) {
                    exception = new FacebookException();
                }
                deviceAuthDialog.onError(exception);
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            RequestState requestState = new RequestState();
            try {
                requestState.setUserCode(jSONObject.getString("user_code"));
                requestState.setRequestCode(jSONObject.getString("code"));
                requestState.setInterval(jSONObject.getLong("interval"));
                deviceAuthDialog.setCurrentRequestState(requestState);
            } catch (JSONException e) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e));
            }
        }
    }

    public Map<String, String> additionalDeviceInfo() {
        return null;
    }

    @LayoutRes
    public int getLayoutResId(boolean z) {
        if (z) {
            return C1541R.layout.com_facebook_smart_device_dialog_fragment;
        }
        return C1541R.layout.com_facebook_device_auth_dialog_fragment;
    }

    public View initializeContentView(boolean z) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "requireActivity().layoutInflater");
        View inflate = layoutInflater.inflate(getLayoutResId(z), (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View findViewById = inflate.findViewById(C1541R.C1543id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = findViewById;
        View findViewById2 = inflate.findViewById(C1541R.C1543id.confirmation_code);
        if (findViewById2 != null) {
            this.confirmationCode = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(C1541R.C1543id.cancel_button);
            if (findViewById3 != null) {
                ((Button) findViewById3).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DeviceAuthDialog.m3653initializeContentView$lambda2(DeviceAuthDialog.this, view);
                    }
                });
                View findViewById4 = inflate.findViewById(C1541R.C1543id.com_facebook_device_auth_instructions);
                if (findViewById4 != null) {
                    TextView textView = (TextView) findViewById4;
                    this.instructions = textView;
                    if (textView != null) {
                        textView.setText(Html.fromHtml(getString(C1541R.string.com_facebook_device_auth_instructions)));
                        return inflate;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("instructions");
                    throw null;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public void onBackButtonPressed() {
    }

    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onCancel();
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        DeviceAuthDialog$onCreateDialog$dialog$1 deviceAuthDialog$onCreateDialog$dialog$1 = new DeviceAuthDialog$onCreateDialog$dialog$1(this, requireActivity(), C1541R.style.com_facebook_auth_dialog);
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        deviceAuthDialog$onCreateDialog$dialog$1.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return deviceAuthDialog$onCreateDialog$dialog$1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        LoginClient loginClient;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) requireActivity()).getCurrentFragment();
        LoginMethodHandler loginMethodHandler = null;
        if (!(loginFragment == null || (loginClient = loginFragment.getLoginClient()) == null)) {
            loginMethodHandler = loginClient.getCurrentHandler();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) loginMethodHandler;
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) == null)) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onError(FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "ex");
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onError(facebookException);
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void startLogin(LoginClient.Request request2) {
        Intrinsics.checkNotNullParameter(request2, "request");
        this.request = request2;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request2.getPermissions()));
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ServerProtocol.DIALOG_PARAM_REDIRECT_URI, request2.getDeviceRedirectUriString());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, DeviceRequestsHelper.DEVICE_TARGET_USER_ID, request2.getDeviceAuthTargetUserId());
        StringBuilder sb = new StringBuilder();
        Validate validate = Validate.INSTANCE;
        sb.append(Validate.hasAppID());
        sb.append('|');
        Validate validate2 = Validate.INSTANCE;
        sb.append(Validate.hasClientToken());
        bundle.putString("access_token", sb.toString());
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        Map<String, String> additionalDeviceInfo = additionalDeviceInfo();
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo(additionalDeviceInfo == null ? null : zzam.toMutableMap(additionalDeviceInfo)));
        GraphRequest.Companion.newPostRequestWithBundle((AccessToken) null, DEVICE_LOGIN_ENDPOINT, bundle, new GraphRequest.Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m3658startLogin$lambda1(DeviceAuthDialog.this, graphResponse);
            }
        }).executeAsync();
    }
}
