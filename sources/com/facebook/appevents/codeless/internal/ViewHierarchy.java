package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RestrictTo;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ViewHierarchy.kt */
public final class ViewHierarchy {
    public static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    public static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    public static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    public static final int ICON_MAX_EDGE_LENGTH = 44;
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    public static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    public static WeakReference<View> RCTRootViewReference = new WeakReference<>((Object) null);
    public static final String TAG = ViewHierarchy.class.getCanonicalName();
    public static Method methodFindTouchTargetView;

    public static final View findRCTRootView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        while (view != null) {
            try {
                if (!INSTANCE.isRCTRootView(view)) {
                    ViewParent parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static final List<View> getChildrenOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                int i = 0;
                if (childCount > 0) {
                    while (true) {
                        int i2 = i + 1;
                        arrayList.add(((ViewGroup) view).getChildAt(i));
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final int getClassTypeBitmask(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            int i = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i |= 32;
            }
            if (isAdapterViewItem(view)) {
                i |= 512;
            }
            if (view instanceof TextView) {
                int i2 = i | 1024 | 1;
                if (view instanceof Button) {
                    i2 |= 4;
                    if (view instanceof Switch) {
                        i2 |= 8192;
                    } else if (view instanceof CheckBox) {
                        i2 |= 32768;
                    }
                }
                if (view instanceof EditText) {
                    return i2 | 2048;
                }
                return i2;
            }
            if (!(view instanceof Spinner)) {
                if (!(view instanceof DatePicker)) {
                    if (view instanceof RatingBar) {
                        return i | 65536;
                    }
                    if (view instanceof RadioGroup) {
                        return i | 16384;
                    }
                    return (!(view instanceof ViewGroup) || !INSTANCE.isRCTButton(view, (View) RCTRootViewReference.get())) ? i : i | 64;
                }
            }
            return i | 4096;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    public static final JSONObject getDictionaryOfView(View view) {
        JSONObject jSONObject;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            if (Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            jSONObject = new JSONObject();
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            int i = 0;
            int size = childrenOfView.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for view.", e);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return jSONObject;
    }

    private final JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
        return jSONObject;
    }

    private final Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final View.OnClickListener getExistingOnClickListener(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField = Class.forName(ExploreByTouchHelper.DEFAULT_CLASS_NAME).getDeclaredField("mListenerInfo");
            Intrinsics.checkNotNullExpressionValue(declaredField, "forName(\"android.view.View\").getDeclaredField(\"mListenerInfo\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "forName(\"android.view.View\\$ListenerInfo\").getDeclaredField(\"mOnClickListener\")");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final View.OnTouchListener getExistingOnTouchListener(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField = Class.forName(ExploreByTouchHelper.DEFAULT_CLASS_NAME).getDeclaredField("mListenerInfo");
            Intrinsics.checkNotNullExpressionValue(declaredField, "forName(\"android.view.View\").getDeclaredField(\"mListenerInfo\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "forName(\"android.view.View\\$ListenerInfo\").getDeclaredField(\"mOnTouchListener\")");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 != null) {
                return (View.OnTouchListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
        } catch (NoSuchFieldException e) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e);
        } catch (ClassNotFoundException e2) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e2);
        } catch (IllegalAccessException e3) {
            Utility utility3 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return null;
    }

    public static final String getHintOfView(View view) {
        CharSequence charSequence;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                charSequence = ((EditText) view).getHint();
            } else {
                charSequence = view instanceof TextView ? ((TextView) view).getHint() : null;
            }
            if (charSequence == null) {
                return "";
            }
            String obj = charSequence.toString();
            if (obj == null) {
                return "";
            }
            return obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final ViewGroup getParentOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String getTextOfView(View view) {
        Object obj;
        Object selectedItem;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                obj = ((TextView) view).getText();
                if (view instanceof Switch) {
                    obj = ((Switch) view).isChecked() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
            } else {
                if (!(view instanceof Spinner)) {
                    int i = 0;
                    if (view instanceof DatePicker) {
                        obj = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(((DatePicker) view).getYear()), Integer.valueOf(((DatePicker) view).getMonth()), Integer.valueOf(((DatePicker) view).getDayOfMonth())}, 3));
                        Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof TimePicker) {
                        Integer currentHour = ((TimePicker) view).getCurrentHour();
                        Intrinsics.checkNotNullExpressionValue(currentHour, "view.currentHour");
                        int intValue = currentHour.intValue();
                        Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                        Intrinsics.checkNotNullExpressionValue(currentMinute, "view.currentMinute");
                        obj = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(currentMinute.intValue())}, 2));
                        Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof RadioGroup) {
                        int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                        int childCount = ((RadioGroup) view).getChildCount();
                        if (childCount > 0) {
                            while (true) {
                                int i2 = i + 1;
                                View childAt = ((RadioGroup) view).getChildAt(i);
                                if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                    obj = ((RadioButton) childAt).getText();
                                    break;
                                } else if (i2 >= childCount) {
                                    break;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                    } else if (view instanceof RatingBar) {
                        obj = String.valueOf(((RatingBar) view).getRating());
                    }
                } else if (((Spinner) view).getCount() > 0 && (selectedItem = ((Spinner) view).getSelectedItem()) != null) {
                    obj = selectedItem.toString();
                }
                obj = null;
            }
            if (obj == null) {
                return "";
            }
            String obj2 = obj.toString();
            if (obj2 == null) {
                return "";
            }
            return obj2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            if (!(methodFindTouchTargetView == null || view == null)) {
                Method method = methodFindTouchTargetView;
                if (method != null) {
                    Object invoke = method.invoke((Object) null, new Object[]{fArr, view});
                    if (invoke != null) {
                        View view2 = (View) invoke;
                        if (view2.getId() > 0) {
                            ViewParent parent = view2.getParent();
                            if (parent != null) {
                                return (View) parent;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        } catch (IllegalAccessException e) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e);
        } catch (InvocationTargetException e2) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
        return null;
    }

    private final float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new float[]{(float) iArr[0], (float) iArr[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (methodFindTouchTargetView == null) {
                    Class<?> cls = Class.forName(CLASS_TOUCHTARGETHELPER);
                    Intrinsics.checkNotNullExpressionValue(cls, "forName(CLASS_TOUCHTARGETHELPER)");
                    Method declaredMethod = cls.getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, new Class[]{float[].class, ViewGroup.class});
                    methodFindTouchTargetView = declaredMethod;
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } catch (ClassNotFoundException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (NoSuchMethodException e2) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final boolean isAdapterViewItem(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            Class<?> existingClass = INSTANCE.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = INSTANCE.getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 == null || !existingClass2.isInstance(parent)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private final boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setOnClickListener(android.view.View r5, android.view.View.OnClickListener r6) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch:{ all -> 0x004d }
            r1 = 0
            java.lang.String r2 = "android.view.View"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0028 }
            java.lang.String r3 = "mListenerInfo"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0028 }
            java.lang.String r3 = "android.view.View$ListenerInfo"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0029 }
            java.lang.String r4 = "mOnClickListener"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0029 }
            goto L_0x002a
        L_0x0028:
            r2 = r1
        L_0x0029:
            r3 = r1
        L_0x002a:
            if (r2 == 0) goto L_0x0049
            if (r3 != 0) goto L_0x002f
            goto L_0x0049
        L_0x002f:
            r4 = 1
            r2.setAccessible(r4)     // Catch:{ Exception -> 0x004c }
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x004c }
            r2.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x003e }
            java.lang.Object r1 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x003e }
            goto L_0x003f
        L_0x003e:
        L_0x003f:
            if (r1 != 0) goto L_0x0045
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004c }
            return
        L_0x0045:
            r3.set(r1, r6)     // Catch:{ Exception -> 0x004c }
            goto L_0x004c
        L_0x0049:
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            return
        L_0x004d:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener(android.view.View, android.view.View$OnClickListener):void");
    }

    public static final void updateAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        Typeface typeface;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                JSONObject jSONObject2 = new JSONObject();
                if ((view instanceof TextView) && (typeface = ((TextView) view).getTypeface()) != null) {
                    jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, (double) ((TextView) view).getTextSize());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject2);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        float f2 = (float) 44;
                        if (((float) view.getHeight()) / f <= f2 && ((float) view.getWidth()) / f <= f2 && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                        }
                    }
                }
            } catch (JSONException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                Intrinsics.checkNotNullParameter(jSONObject, GraphRequest.FORMAT_JSON);
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
                jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                SensitiveUserDataUtils sensitiveUserDataUtils = SensitiveUserDataUtils.INSTANCE;
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    Utility utility = Utility.INSTANCE;
                    Utility utility2 = Utility.INSTANCE;
                    jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    jSONObject.put("text", "");
                    jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                Utility utility3 = Utility.INSTANCE;
                Utility utility4 = Utility.INSTANCE;
                jSONObject.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    Utility utility5 = Utility.INSTANCE;
                    Utility utility6 = Utility.INSTANCE;
                    jSONObject.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    Utility utility7 = Utility.INSTANCE;
                    Utility utility8 = Utility.INSTANCE;
                    jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                jSONObject.put(ViewHierarchyConstants.DIMENSION_KEY, INSTANCE.getDimensionOfView(view));
            } catch (JSONException e) {
                Utility utility9 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            String name = view.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "view.javaClass.name");
            if (!Intrinsics.areEqual(name, CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null || touchReactView.getId() != view.getId()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
