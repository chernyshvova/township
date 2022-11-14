package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SuggestedEventViewHierarchy.kt */
public final class SuggestedEventViewHierarchy {
    public static final SuggestedEventViewHierarchy INSTANCE = new SuggestedEventViewHierarchy();
    public static final List<Class<? extends View>> blacklistedViews = CollectionsKt__CollectionsKt.listOf(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class);

    public static final List<View> getAllClickableViews(View view) {
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            ArrayList arrayList = new ArrayList();
            for (Class<? extends View> isInstance : blacklistedViews) {
                if (isInstance.isInstance(view)) {
                    return arrayList;
                }
            }
            if (view.isClickable()) {
                arrayList.add(view);
            }
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            for (View allClickableViews : ViewHierarchy.getChildrenOfView(view)) {
                arrayList.addAll(getAllClickableViews(allClickableViews));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final JSONObject getDictionaryOfView(View view, View view2) {
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(view2, "clickedView");
            JSONObject jSONObject = new JSONObject();
            if (view == view2) {
                try {
                    jSONObject.put(ViewHierarchyConstants.IS_INTERACTED_KEY, true);
                } catch (JSONException unused) {
                }
            }
            updateBasicInfo(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            for (View dictionaryOfView : ViewHierarchy.getChildrenOfView(view)) {
                jSONArray.put(getDictionaryOfView(dictionaryOfView, view2));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final List<String> getTextOfChildren(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            for (View next : ViewHierarchy.getChildrenOfView(view)) {
                ViewHierarchy viewHierarchy2 = ViewHierarchy.INSTANCE;
                String textOfView = ViewHierarchy.getTextOfView(next);
                if (textOfView.length() > 0) {
                    arrayList.add(textOfView);
                }
                arrayList.addAll(getTextOfChildren(next));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final String getTextOfViewRecursively(View view) {
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "hostView");
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            String textOfView = ViewHierarchy.getTextOfView(view);
            if (textOfView.length() > 0) {
                return textOfView;
            }
            String join = TextUtils.join(" ", INSTANCE.getTextOfChildren(view));
            Intrinsics.checkNotNullExpressionValue(join, "join(\" \", childrenText)");
            return join;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void updateBasicInfo(View view, JSONObject jSONObject) {
        Class<SuggestedEventViewHierarchy> cls = SuggestedEventViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                try {
                    ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                    String textOfView = ViewHierarchy.getTextOfView(view);
                    ViewHierarchy viewHierarchy2 = ViewHierarchy.INSTANCE;
                    String hintOfView = ViewHierarchy.getHintOfView(view);
                    jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getSimpleName());
                    ViewHierarchy viewHierarchy3 = ViewHierarchy.INSTANCE;
                    jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, ViewHierarchy.getClassTypeBitmask(view));
                    boolean z = true;
                    if (textOfView.length() > 0) {
                        jSONObject.put("text", textOfView);
                    }
                    if (hintOfView.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        jSONObject.put("hint", hintOfView);
                    }
                    if (view instanceof EditText) {
                        jSONObject.put(ViewHierarchyConstants.INPUT_TYPE_KEY, ((EditText) view).getInputType());
                    }
                } catch (JSONException unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
