package com.facebook.appevents.eventdeactivation;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: EventDeactivationManager.kt */
public final class EventDeactivationManager {
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();
    public static final Set<String> deprecatedEvents = new HashSet();
    public static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    public static boolean enabled;

    /* compiled from: EventDeactivationManager.kt */
    public static final class DeprecatedParamFilter {
        public List<String> deprecateParams;
        public String eventName;

        public DeprecatedParamFilter(String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(list, "deprecateParams");
            this.eventName = str;
            this.deprecateParams = list;
        }

        public final List<String> getDeprecateParams() {
            return this.deprecateParams;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.deprecateParams = list;
        }

        public final void setEventName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventName = str;
        }
    }

    public static final void enable() {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enabled = true;
                INSTANCE.initialize();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final synchronized void initialize() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                boolean z = false;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null) {
                    String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                    if (restrictiveDataSetting != null) {
                        if (restrictiveDataSetting.length() > 0) {
                            z = true;
                        }
                        if (z) {
                            JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                            deprecatedParamFilters.clear();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                                if (jSONObject2 != null) {
                                    if (jSONObject2.optBoolean("is_deprecated_event")) {
                                        Set<String> set = deprecatedEvents;
                                        Intrinsics.checkNotNullExpressionValue(next, "key");
                                        set.add(next);
                                    } else {
                                        JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                                        Intrinsics.checkNotNullExpressionValue(next, "key");
                                        DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(next, new ArrayList());
                                        if (optJSONArray != null) {
                                            Utility utility = Utility.INSTANCE;
                                            deprecatedParamFilter.setDeprecateParams(Utility.convertJSONArrayToList(optJSONArray));
                                        }
                                        deprecatedParamFilters.add(deprecatedParamFilter);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void processDeprecatedParameters(Map<String, String> map, String str) {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(map, "parameters");
                Intrinsics.checkNotNullParameter(str, "eventName");
                if (enabled) {
                    ArrayList<String> arrayList = new ArrayList<>(map.keySet());
                    for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                        if (Intrinsics.areEqual(deprecatedParamFilter.getEventName(), str)) {
                            for (String str2 : arrayList) {
                                if (deprecatedParamFilter.getDeprecateParams().contains(str2)) {
                                    map.remove(str2);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void processEvents(List<AppEvent> list) {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(list, "events");
                if (enabled) {
                    Iterator<AppEvent> it = list.iterator();
                    while (it.hasNext()) {
                        if (deprecatedEvents.contains(it.next().getName())) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
