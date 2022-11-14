package com.facebook.appevents.cloudbridge;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.cloudbridge.AppEventType;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventsConversionsAPITransformer.kt */
public final class AppEventsConversionsAPITransformer {
    public static final AppEventsConversionsAPITransformer INSTANCE = new AppEventsConversionsAPITransformer();
    public static final String TAG = "AppEventsConversionsAPITransformer";
    public static final Map<CustomEventField, SectionCustomEventFieldMapping> customEventTransformations = zzam.mapOf(new Pair(CustomEventField.EVENT_TIME, new SectionCustomEventFieldMapping((ConversionsAPISection) null, ConversionsAPICustomEventField.EVENT_TIME)), new Pair(CustomEventField.EVENT_NAME, new SectionCustomEventFieldMapping((ConversionsAPISection) null, ConversionsAPICustomEventField.EVENT_NAME)), new Pair(CustomEventField.VALUE_TO_SUM, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.VALUE_TO_SUM)), new Pair(CustomEventField.CONTENT_IDS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENT_IDS)), new Pair(CustomEventField.CONTENTS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENTS)), new Pair(CustomEventField.CONTENT_TYPE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENT_TYPE)), new Pair(CustomEventField.CURRENCY, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CURRENCY)), new Pair(CustomEventField.DESCRIPTION, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.DESCRIPTION)), new Pair(CustomEventField.LEVEL, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.LEVEL)), new Pair(CustomEventField.MAX_RATING_VALUE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.MAX_RATING_VALUE)), new Pair(CustomEventField.NUM_ITEMS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.NUM_ITEMS)), new Pair(CustomEventField.PAYMENT_INFO_AVAILABLE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.PAYMENT_INFO_AVAILABLE)), new Pair(CustomEventField.REGISTRATION_METHOD, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.REGISTRATION_METHOD)), new Pair(CustomEventField.SEARCH_STRING, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.SEARCH_STRING)), new Pair(CustomEventField.SUCCESS, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.SUCCESS)), new Pair(CustomEventField.ORDER_ID, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.ORDER_ID)), new Pair(CustomEventField.AD_TYPE, new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.AD_TYPE)));
    public static final Map<String, ConversionsAPIEventName> standardEventTransformations = zzam.mapOf(new Pair(AppEventsConstants.EVENT_NAME_UNLOCKED_ACHIEVEMENT, ConversionsAPIEventName.UNLOCKED_ACHIEVEMENT), new Pair(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, ConversionsAPIEventName.ACTIVATED_APP), new Pair(AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO, ConversionsAPIEventName.ADDED_PAYMENT_INFO), new Pair(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, ConversionsAPIEventName.ADDED_TO_CART), new Pair(AppEventsConstants.EVENT_NAME_ADDED_TO_WISHLIST, ConversionsAPIEventName.ADDED_TO_WISHLIST), new Pair(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, ConversionsAPIEventName.COMPLETED_REGISTRATION), new Pair(AppEventsConstants.EVENT_NAME_VIEWED_CONTENT, ConversionsAPIEventName.VIEWED_CONTENT), new Pair(AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT, ConversionsAPIEventName.INITIATED_CHECKOUT), new Pair(AppEventsConstants.EVENT_NAME_ACHIEVED_LEVEL, ConversionsAPIEventName.ACHIEVED_LEVEL), new Pair(AppEventsConstants.EVENT_NAME_PURCHASED, ConversionsAPIEventName.PURCHASED), new Pair(AppEventsConstants.EVENT_NAME_RATED, ConversionsAPIEventName.RATED), new Pair(AppEventsConstants.EVENT_NAME_SEARCHED, ConversionsAPIEventName.SEARCHED), new Pair(AppEventsConstants.EVENT_NAME_SPENT_CREDITS, ConversionsAPIEventName.SPENT_CREDITS), new Pair(AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL, ConversionsAPIEventName.COMPLETED_TUTORIAL));
    public static final Map<AppEventUserAndAppDataField, SectionFieldMapping> topLevelTransformations = zzam.mapOf(new Pair(AppEventUserAndAppDataField.ANON_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.ANON_ID)), new Pair(AppEventUserAndAppDataField.APP_USER_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.FB_LOGIN_ID)), new Pair(AppEventUserAndAppDataField.ADVERTISER_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.MAD_ID)), new Pair(AppEventUserAndAppDataField.PAGE_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.PAGE_ID)), new Pair(AppEventUserAndAppDataField.PAGE_SCOPED_USER_ID, new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.PAGE_SCOPED_USER_ID)), new Pair(AppEventUserAndAppDataField.ADV_TE, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.ADV_TE)), new Pair(AppEventUserAndAppDataField.APP_TE, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.APP_TE)), new Pair(AppEventUserAndAppDataField.CONSIDER_VIEWS, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.CONSIDER_VIEWS)), new Pair(AppEventUserAndAppDataField.DEVICE_TOKEN, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.DEVICE_TOKEN)), new Pair(AppEventUserAndAppDataField.EXT_INFO, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.EXT_INFO)), new Pair(AppEventUserAndAppDataField.INCLUDE_DWELL_DATA, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INCLUDE_DWELL_DATA)), new Pair(AppEventUserAndAppDataField.INCLUDE_VIDEO_DATA, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INCLUDE_VIDEO_DATA)), new Pair(AppEventUserAndAppDataField.INSTALL_REFERRER, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INSTALL_REFERRER)), new Pair(AppEventUserAndAppDataField.INSTALLER_PACKAGE, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INSTALLER_PACKAGE)), new Pair(AppEventUserAndAppDataField.RECEIPT_DATA, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.RECEIPT_DATA)), new Pair(AppEventUserAndAppDataField.URL_SCHEMES, new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.URL_SCHEMES)), new Pair(AppEventUserAndAppDataField.USER_DATA, new SectionFieldMapping(ConversionsAPISection.USER_DATA, (ConversionsAPIUserAndAppDataField) null)));

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public enum DataProcessingParameterName {
        OPTIONS(FacebookSdk.DATA_PROCESSION_OPTIONS),
        COUNTRY(FacebookSdk.DATA_PROCESSION_OPTIONS_COUNTRY),
        STATE(FacebookSdk.DATA_PROCESSION_OPTIONS_STATE);
        
        public static final Companion Companion = null;
        public final String rawValue;

        /* compiled from: AppEventsConversionsAPITransformer.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final DataProcessingParameterName invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "rawValue");
                for (DataProcessingParameterName dataProcessingParameterName : DataProcessingParameterName.values()) {
                    if (Intrinsics.areEqual(dataProcessingParameterName.getRawValue(), str)) {
                        return dataProcessingParameterName;
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        DataProcessingParameterName(String str) {
            this.rawValue = str;
        }

        public final String getRawValue() {
            return this.rawValue;
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class SectionCustomEventFieldMapping {
        public ConversionsAPICustomEventField field;
        public ConversionsAPISection section;

        public SectionCustomEventFieldMapping(ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField) {
            Intrinsics.checkNotNullParameter(conversionsAPICustomEventField, "field");
            this.section = conversionsAPISection;
            this.field = conversionsAPICustomEventField;
        }

        public static /* synthetic */ SectionCustomEventFieldMapping copy$default(SectionCustomEventFieldMapping sectionCustomEventFieldMapping, ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField, int i, Object obj) {
            if ((i & 1) != 0) {
                conversionsAPISection = sectionCustomEventFieldMapping.section;
            }
            if ((i & 2) != 0) {
                conversionsAPICustomEventField = sectionCustomEventFieldMapping.field;
            }
            return sectionCustomEventFieldMapping.copy(conversionsAPISection, conversionsAPICustomEventField);
        }

        public final ConversionsAPISection component1() {
            return this.section;
        }

        public final ConversionsAPICustomEventField component2() {
            return this.field;
        }

        public final SectionCustomEventFieldMapping copy(ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField) {
            Intrinsics.checkNotNullParameter(conversionsAPICustomEventField, "field");
            return new SectionCustomEventFieldMapping(conversionsAPISection, conversionsAPICustomEventField);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionCustomEventFieldMapping)) {
                return false;
            }
            SectionCustomEventFieldMapping sectionCustomEventFieldMapping = (SectionCustomEventFieldMapping) obj;
            return this.section == sectionCustomEventFieldMapping.section && this.field == sectionCustomEventFieldMapping.field;
        }

        public final ConversionsAPICustomEventField getField() {
            return this.field;
        }

        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public int hashCode() {
            ConversionsAPISection conversionsAPISection = this.section;
            return this.field.hashCode() + ((conversionsAPISection == null ? 0 : conversionsAPISection.hashCode()) * 31);
        }

        public final void setField(ConversionsAPICustomEventField conversionsAPICustomEventField) {
            Intrinsics.checkNotNullParameter(conversionsAPICustomEventField, "<set-?>");
            this.field = conversionsAPICustomEventField;
        }

        public final void setSection(ConversionsAPISection conversionsAPISection) {
            this.section = conversionsAPISection;
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("SectionCustomEventFieldMapping(section=");
            outline24.append(this.section);
            outline24.append(", field=");
            outline24.append(this.field);
            outline24.append(')');
            return outline24.toString();
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class SectionFieldMapping {
        public ConversionsAPIUserAndAppDataField field;
        public ConversionsAPISection section;

        public SectionFieldMapping(ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            Intrinsics.checkNotNullParameter(conversionsAPISection, "section");
            this.section = conversionsAPISection;
            this.field = conversionsAPIUserAndAppDataField;
        }

        public static /* synthetic */ SectionFieldMapping copy$default(SectionFieldMapping sectionFieldMapping, ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField, int i, Object obj) {
            if ((i & 1) != 0) {
                conversionsAPISection = sectionFieldMapping.section;
            }
            if ((i & 2) != 0) {
                conversionsAPIUserAndAppDataField = sectionFieldMapping.field;
            }
            return sectionFieldMapping.copy(conversionsAPISection, conversionsAPIUserAndAppDataField);
        }

        public final ConversionsAPISection component1() {
            return this.section;
        }

        public final ConversionsAPIUserAndAppDataField component2() {
            return this.field;
        }

        public final SectionFieldMapping copy(ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            Intrinsics.checkNotNullParameter(conversionsAPISection, "section");
            return new SectionFieldMapping(conversionsAPISection, conversionsAPIUserAndAppDataField);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionFieldMapping)) {
                return false;
            }
            SectionFieldMapping sectionFieldMapping = (SectionFieldMapping) obj;
            return this.section == sectionFieldMapping.section && this.field == sectionFieldMapping.field;
        }

        public final ConversionsAPIUserAndAppDataField getField() {
            return this.field;
        }

        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public int hashCode() {
            int hashCode = this.section.hashCode() * 31;
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = this.field;
            return hashCode + (conversionsAPIUserAndAppDataField == null ? 0 : conversionsAPIUserAndAppDataField.hashCode());
        }

        public final void setField(ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            this.field = conversionsAPIUserAndAppDataField;
        }

        public final void setSection(ConversionsAPISection conversionsAPISection) {
            Intrinsics.checkNotNullParameter(conversionsAPISection, "<set-?>");
            this.section = conversionsAPISection;
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("SectionFieldMapping(section=");
            outline24.append(this.section);
            outline24.append(", field=");
            outline24.append(this.field);
            outline24.append(')');
            return outline24.toString();
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public enum ValueTransformationType {
        ARRAY,
        BOOL,
        INT;
        
        public static final Companion Companion = null;

        /* compiled from: AppEventsConversionsAPITransformer.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ValueTransformationType invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "rawValue");
                if (Intrinsics.areEqual(str, AppEventUserAndAppDataField.EXT_INFO.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual(str, AppEventUserAndAppDataField.URL_SCHEMES.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual(str, CustomEventField.CONTENT_IDS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual(str, CustomEventField.CONTENTS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual(str, DataProcessingParameterName.OPTIONS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (Intrinsics.areEqual(str, AppEventUserAndAppDataField.ADV_TE.getRawValue())) {
                    return ValueTransformationType.BOOL;
                }
                if (Intrinsics.areEqual(str, AppEventUserAndAppDataField.APP_TE.getRawValue())) {
                    return ValueTransformationType.BOOL;
                }
                if (Intrinsics.areEqual(str, CustomEventField.EVENT_TIME.getRawValue())) {
                    return ValueTransformationType.INT;
                }
                return null;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ValueTransformationType.values().length];
            ValueTransformationType valueTransformationType = ValueTransformationType.ARRAY;
            iArr[0] = 1;
            ValueTransformationType valueTransformationType2 = ValueTransformationType.BOOL;
            iArr[1] = 2;
            ValueTransformationType valueTransformationType3 = ValueTransformationType.INT;
            iArr[2] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConversionsAPISection.values().length];
            ConversionsAPISection conversionsAPISection = ConversionsAPISection.APP_DATA;
            iArr2[1] = 1;
            ConversionsAPISection conversionsAPISection2 = ConversionsAPISection.USER_DATA;
            iArr2[0] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AppEventType.values().length];
            AppEventType appEventType = AppEventType.MOBILE_APP_INSTALL;
            iArr3[0] = 1;
            AppEventType appEventType2 = AppEventType.CUSTOM;
            iArr3[1] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private final List<Map<String, Object>> combineAllTransformedDataForCustom(Map<String, ? extends Object> map, List<? extends Map<String, ? extends Object>> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map putAll : list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.putAll(putAll);
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    private final List<Map<String, Object>> combineAllTransformedDataForMobileAppInstall(Map<String, ? extends Object> map, Object obj) {
        if (obj == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_NAME.getRawValue(), OtherEventConstants.MOBILE_APP_INSTALL.getRawValue());
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_TIME.getRawValue(), obj);
        return zzam.listOf(linkedHashMap);
    }

    private final AppEventType splitAppEventParameters(Map<String, ? extends Object> map, Map<String, Object> map2, Map<String, Object> map3, ArrayList<Map<String, Object>> arrayList, Map<String, Object> map4) {
        Object obj = map.get(OtherEventConstants.EVENT.getRawValue());
        AppEventType.Companion companion = AppEventType.Companion;
        if (obj != null) {
            AppEventType invoke = companion.invoke((String) obj);
            if (invoke == AppEventType.OTHER) {
                return invoke;
            }
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                AppEventUserAndAppDataField invoke2 = AppEventUserAndAppDataField.Companion.invoke(str);
                if (invoke2 != null) {
                    INSTANCE.transformAndUpdateAppAndUserData$facebook_core_release(map2, map3, invoke2, value);
                } else {
                    boolean areEqual = Intrinsics.areEqual(str, ConversionsAPISection.CUSTOM_EVENTS.getRawValue());
                    boolean z = value instanceof String;
                    if (invoke == AppEventType.CUSTOM && areEqual && z) {
                        ArrayList<Map<String, Object>> transformEvents$facebook_core_release = transformEvents$facebook_core_release((String) value);
                        if (transformEvents$facebook_core_release != null) {
                            arrayList.addAll(transformEvents$facebook_core_release);
                        }
                    } else if (DataProcessingParameterName.Companion.invoke(str) != null) {
                        map4.put(str, value);
                    }
                }
            }
            return invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void transformAndUpdateAppData(Map<String, Object> map, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
        ConversionsAPIUserAndAppDataField field = sectionFieldMapping == null ? null : sectionFieldMapping.getField();
        if (field != null) {
            map.put(field.getRawValue(), obj);
        }
    }

    private final void transformAndUpdateUserData(Map<String, Object> map, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        if (appEventUserAndAppDataField == AppEventUserAndAppDataField.USER_DATA) {
            try {
                Utility utility = Utility.INSTANCE;
                map.putAll(Utility.convertJSONObjectToHashMap(new JSONObject((String) obj)));
            } catch (JSONException e) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", obj, e);
            }
        } else {
            SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
            ConversionsAPIUserAndAppDataField field = sectionFieldMapping == null ? null : sectionFieldMapping.getField();
            if (field != null) {
                map.put(field.getRawValue(), obj);
            }
        }
    }

    private final String transformEventName(String str) {
        if (!standardEventTransformations.containsKey(str)) {
            return str;
        }
        ConversionsAPIEventName conversionsAPIEventName = standardEventTransformations.get(str);
        return conversionsAPIEventName == null ? "" : conversionsAPIEventName.getRawValue();
    }

    public static final ArrayList<Map<String, Object>> transformEvents$facebook_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "appEvents");
        ArrayList<Map> arrayList = new ArrayList<>();
        try {
            Utility utility = Utility.INSTANCE;
            for (String jSONObject : Utility.convertJSONArrayToList(new JSONArray(str))) {
                Utility utility2 = Utility.INSTANCE;
                arrayList.add(Utility.convertJSONObjectToHashMap(new JSONObject(jSONObject)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            ArrayList<Map<String, Object>> arrayList2 = new ArrayList<>();
            for (Map map : arrayList) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (String str2 : map.keySet()) {
                    CustomEventField invoke = CustomEventField.Companion.invoke(str2);
                    SectionCustomEventFieldMapping sectionCustomEventFieldMapping = customEventTransformations.get(invoke);
                    if (!(invoke == null || sectionCustomEventFieldMapping == null)) {
                        ConversionsAPISection section = sectionCustomEventFieldMapping.getSection();
                        if (section == null) {
                            try {
                                String rawValue = sectionCustomEventFieldMapping.getField().getRawValue();
                                if (invoke == CustomEventField.EVENT_NAME && ((String) map.get(str2)) != null) {
                                    AppEventsConversionsAPITransformer appEventsConversionsAPITransformer = INSTANCE;
                                    Object obj = map.get(str2);
                                    if (obj != null) {
                                        linkedHashMap2.put(rawValue, appEventsConversionsAPITransformer.transformEventName((String) obj));
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (invoke == CustomEventField.EVENT_TIME && ((Integer) map.get(str2)) != null) {
                                    Object obj2 = map.get(str2);
                                    if (obj2 != null) {
                                        Object transformValue$facebook_core_release = transformValue$facebook_core_release(str2, obj2);
                                        if (transformValue$facebook_core_release != null) {
                                            linkedHashMap2.put(rawValue, transformValue$facebook_core_release);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                }
                            } catch (ClassCastException e) {
                                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents ClassCastException: \n %s ", zzam.stackTraceToString(e));
                            }
                        } else if (section == ConversionsAPISection.CUSTOM_DATA) {
                            String rawValue2 = sectionCustomEventFieldMapping.getField().getRawValue();
                            Object obj3 = map.get(str2);
                            if (obj3 != null) {
                                Object transformValue$facebook_core_release2 = transformValue$facebook_core_release(str2, obj3);
                                if (transformValue$facebook_core_release2 != null) {
                                    linkedHashMap.put(rawValue2, transformValue$facebook_core_release2);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put(ConversionsAPISection.CUSTOM_DATA.getRawValue(), linkedHashMap);
                }
                arrayList2.add(linkedHashMap2);
            }
            return arrayList2;
        } catch (JSONException e2) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", str, e2);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:24|25|26|29|30|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5 = com.facebook.internal.Utility.INSTANCE;
        r1 = com.facebook.internal.Utility.convertJSONArrayToList(new org.json.JSONArray(r1));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0085 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object transformValue$facebook_core_release(java.lang.String r6, java.lang.Object r7) {
        /*
            java.lang.String r0 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$ValueTransformationType$Companion r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$ValueTransformationType r6 = r0.invoke(r6)
            boolean r0 = r7 instanceof java.lang.String
            r1 = 0
            if (r0 == 0) goto L_0x0019
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            if (r6 == 0) goto L_0x009f
            if (r0 != 0) goto L_0x0020
            goto L_0x009f
        L_0x0020:
            int r6 = r6.ordinal()
            r2 = 0
            r3 = 2
            r4 = 1
            if (r6 == 0) goto L_0x004e
            if (r6 == r4) goto L_0x003c
            if (r6 != r3) goto L_0x0036
            java.lang.String r6 = r7.toString()
            java.lang.Integer r6 = kotlin.text.CharsKt__CharKt.toIntOrNull(r6)
            return r6
        L_0x0036:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x003c:
            java.lang.Integer r6 = kotlin.text.CharsKt__CharKt.toIntOrNull(r0)
            if (r6 == 0) goto L_0x004d
            int r6 = r6.intValue()
            if (r6 == 0) goto L_0x0049
            r2 = 1
        L_0x0049:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
        L_0x004d:
            return r1
        L_0x004e:
            com.facebook.internal.Utility r6 = com.facebook.internal.Utility.INSTANCE     // Catch:{ JSONException -> 0x008a }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x008a }
            r6.<init>(r0)     // Catch:{ JSONException -> 0x008a }
            java.util.List r6 = com.facebook.internal.Utility.convertJSONArrayToList(r6)     // Catch:{ JSONException -> 0x008a }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x008a }
            r0.<init>()     // Catch:{ JSONException -> 0x008a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x008a }
        L_0x0062:
            boolean r1 = r6.hasNext()     // Catch:{ JSONException -> 0x008a }
            if (r1 == 0) goto L_0x0089
            java.lang.Object r1 = r6.next()     // Catch:{ JSONException -> 0x008a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x008a }
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ JSONException -> 0x007a }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007a }
            r5.<init>(r1)     // Catch:{ JSONException -> 0x007a }
            java.util.Map r1 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r5)     // Catch:{ JSONException -> 0x007a }
            goto L_0x0085
        L_0x007a:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ JSONException -> 0x0085 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0085 }
            r5.<init>(r1)     // Catch:{ JSONException -> 0x0085 }
            java.util.List r1 = com.facebook.internal.Utility.convertJSONArrayToList(r5)     // Catch:{ JSONException -> 0x0085 }
        L_0x0085:
            r0.add(r1)     // Catch:{ JSONException -> 0x008a }
            goto L_0x0062
        L_0x0089:
            return r0
        L_0x008a:
            r6 = move-exception
            com.facebook.internal.Logger$Companion r0 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r7
            r3[r4] = r6
            java.lang.String r6 = "AppEventsConversionsAPITransformer"
            java.lang.String r7 = "\n transformEvents JSONException: \n%s\n%s"
            r0.log((com.facebook.LoggingBehavior) r1, (java.lang.String) r6, (java.lang.String) r7, (java.lang.Object[]) r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x009f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.transformValue$facebook_core_release(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public final List<Map<String, Object>> combineAllTransformedData$facebook_core_release(AppEventType appEventType, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, List<? extends Map<String, ? extends Object>> list, Object obj) {
        Intrinsics.checkNotNullParameter(appEventType, "eventType");
        Intrinsics.checkNotNullParameter(map, "userData");
        Intrinsics.checkNotNullParameter(map2, "appData");
        Intrinsics.checkNotNullParameter(map3, "restOfData");
        Intrinsics.checkNotNullParameter(list, "customEvents");
        Map<String, Object> combineCommonFields$facebook_core_release = combineCommonFields$facebook_core_release(map, map2, map3);
        int ordinal = appEventType.ordinal();
        if (ordinal == 0) {
            return combineAllTransformedDataForMobileAppInstall(combineCommonFields$facebook_core_release, obj);
        }
        if (ordinal != 1) {
            return null;
        }
        return combineAllTransformedDataForCustom(combineCommonFields$facebook_core_release, list);
    }

    public final Map<String, Object> combineCommonFields$facebook_core_release(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(map, "userData");
        Intrinsics.checkNotNullParameter(map2, "appData");
        Intrinsics.checkNotNullParameter(map3, "restOfData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(OtherEventConstants.ACTION_SOURCE.getRawValue(), OtherEventConstants.APP.getRawValue());
        linkedHashMap.put(ConversionsAPISection.USER_DATA.getRawValue(), map);
        linkedHashMap.put(ConversionsAPISection.APP_DATA.getRawValue(), map2);
        linkedHashMap.putAll(map3);
        return linkedHashMap;
    }

    public final List<Map<String, Object>> conversionsAPICompatibleEvent$facebook_core_release(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "parameters");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        AppEventType splitAppEventParameters = splitAppEventParameters(map, linkedHashMap, linkedHashMap2, arrayList, linkedHashMap3);
        if (splitAppEventParameters == AppEventType.OTHER) {
            return null;
        }
        return combineAllTransformedData$facebook_core_release(splitAppEventParameters, linkedHashMap, linkedHashMap2, linkedHashMap3, arrayList, map.get(OtherEventConstants.INSTALL_EVENT_TIME.getRawValue()));
    }

    public final void transformAndUpdateAppAndUserData$facebook_core_release(Map<String, Object> map, Map<String, Object> map2, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        Intrinsics.checkNotNullParameter(map, "userData");
        Intrinsics.checkNotNullParameter(map2, "appData");
        Intrinsics.checkNotNullParameter(appEventUserAndAppDataField, "field");
        Intrinsics.checkNotNullParameter(obj, "value");
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
        if (sectionFieldMapping != null) {
            int ordinal = sectionFieldMapping.getSection().ordinal();
            if (ordinal == 0) {
                transformAndUpdateUserData(map, appEventUserAndAppDataField, obj);
            } else if (ordinal == 1) {
                transformAndUpdateAppData(map2, appEventUserAndAppDataField, obj);
            }
        }
    }
}
