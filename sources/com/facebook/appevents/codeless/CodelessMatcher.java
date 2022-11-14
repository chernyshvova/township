package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: CodelessMatcher.kt */
public final class CodelessMatcher {
    public static final String CURRENT_CLASS_NAME = ".";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARENT_CLASS_NAME = "..";
    public static final String TAG = CodelessMatcher.class.getCanonicalName();
    public static CodelessMatcher codelessMatcher;
    public final Set<Activity> activitiesSet;
    public final HashMap<Integer, HashSet<String>> activityToListenerMap;
    public HashSet<String> listenerSet;
    public final Handler uiThreadHandler;
    public final Set<ViewMatcher> viewMatchers;

    /* compiled from: CodelessMatcher.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized CodelessMatcher getInstance() {
            CodelessMatcher access$getCodelessMatcher$cp;
            if (CodelessMatcher.access$getCodelessMatcher$cp() == null) {
                CodelessMatcher.access$setCodelessMatcher$cp(new CodelessMatcher((DefaultConstructorMarker) null));
            }
            access$getCodelessMatcher$cp = CodelessMatcher.access$getCodelessMatcher$cp();
            if (access$getCodelessMatcher$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
            }
            return access$getCodelessMatcher$cp;
        }

        @UiThread
        public final Bundle getParameters(EventBinding eventBinding, View view, View view2) {
            List<ParameterComponent> viewParameters;
            List<MatchedView> list;
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(view2, "hostView");
            Bundle bundle = new Bundle();
            if (!(eventBinding == null || (viewParameters = eventBinding.getViewParameters()) == null)) {
                for (ParameterComponent next : viewParameters) {
                    if (next.getValue() != null) {
                        if (next.getValue().length() > 0) {
                            bundle.putString(next.getName(), next.getValue());
                        }
                    }
                    if (next.getPath().size() > 0) {
                        if (Intrinsics.areEqual(next.getPathType(), Constants.PATH_TYPE_RELATIVE)) {
                            ViewMatcher.Companion companion = ViewMatcher.Companion;
                            List<PathComponent> path = next.getPath();
                            String simpleName = view2.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName, "hostView.javaClass.simpleName");
                            list = companion.findViewByPath(eventBinding, view2, path, 0, -1, simpleName);
                        } else {
                            ViewMatcher.Companion companion2 = ViewMatcher.Companion;
                            List<PathComponent> path2 = next.getPath();
                            String simpleName2 = view.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName2, "rootView.javaClass.simpleName");
                            list = companion2.findViewByPath(eventBinding, view, path2, 0, -1, simpleName2);
                        }
                        Iterator<MatchedView> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MatchedView next2 = it.next();
                            if (next2.getView() != null) {
                                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                String textOfView = ViewHierarchy.getTextOfView(next2.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(next.getName(), textOfView);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return bundle;
        }
    }

    /* compiled from: CodelessMatcher.kt */
    public static final class MatchedView {
        public final WeakReference<View> view;
        public final String viewMapKey;

        public MatchedView(View view2, String str) {
            Intrinsics.checkNotNullParameter(view2, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "viewMapKey");
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
        }

        public final View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        }

        public final String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    @UiThread
    /* compiled from: CodelessMatcher.kt */
    public static final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public final String activityName;
        public List<EventBinding> eventBindings;
        public final Handler handler;
        public final HashSet<String> listenerSet;
        public final WeakReference<View> rootView;

        /* compiled from: CodelessMatcher.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final List<View> findVisibleChildren(ViewGroup viewGroup) {
                ArrayList arrayList = new ArrayList();
                int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getVisibility() == 0) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            arrayList.add(childAt);
                        }
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                return arrayList;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual(r6.getClass().getSimpleName(), (java.lang.String) r8.get(r8.size() - 1)) == false) goto L_0x0062;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final boolean isTheSameView(android.view.View r6, com.facebook.appevents.codeless.internal.PathComponent r7, int r8) {
                /*
                    r5 = this;
                    int r0 = r7.getIndex()
                    r1 = 0
                    r2 = -1
                    if (r0 == r2) goto L_0x000f
                    int r0 = r7.getIndex()
                    if (r8 == r0) goto L_0x000f
                    return r1
                L_0x000f:
                    java.lang.Class r8 = r6.getClass()
                    java.lang.String r8 = r8.getCanonicalName()
                    java.lang.String r0 = r7.getClassName()
                    boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
                    r0 = 1
                    if (r8 != 0) goto L_0x0063
                    java.lang.String r8 = r7.getClassName()
                    kotlin.text.Regex r2 = new kotlin.text.Regex
                    java.lang.String r3 = ".*android\\..*"
                    r2.<init>((java.lang.String) r3)
                    boolean r8 = r2.matches(r8)
                    if (r8 == 0) goto L_0x0062
                    java.lang.String r8 = r7.getClassName()
                    java.lang.String r2 = "."
                    java.lang.String[] r2 = new java.lang.String[]{r2}
                    r3 = 6
                    java.util.List r8 = kotlin.text.CharsKt__CharKt.split$default(r8, r2, r1, r1, r3)
                    boolean r2 = r8.isEmpty()
                    r2 = r2 ^ r0
                    if (r2 == 0) goto L_0x0062
                    int r2 = r8.size()
                    int r2 = r2 - r0
                    java.lang.Object r8 = r8.get(r2)
                    java.lang.String r8 = (java.lang.String) r8
                    java.lang.Class r2 = r6.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r8)
                    if (r8 != 0) goto L_0x0063
                L_0x0062:
                    return r1
                L_0x0063:
                    int r8 = r7.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.ID
                    int r2 = r2.getValue()
                    r8 = r8 & r2
                    if (r8 <= 0) goto L_0x007b
                    int r8 = r7.getId()
                    int r2 = r6.getId()
                    if (r8 == r2) goto L_0x007b
                    return r1
                L_0x007b:
                    int r8 = r7.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TEXT
                    int r2 = r2.getValue()
                    r8 = r8 & r2
                    java.lang.String r2 = ""
                    if (r8 <= 0) goto L_0x00ab
                    java.lang.String r8 = r7.getText()
                    com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                    java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r6)
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r3)
                    if (r3 != 0) goto L_0x00ab
                    boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)
                    if (r8 != 0) goto L_0x00ab
                    return r1
                L_0x00ab:
                    int r8 = r7.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.DESCRIPTION
                    int r3 = r3.getValue()
                    r8 = r8 & r3
                    if (r8 <= 0) goto L_0x00e3
                    java.lang.String r8 = r7.getDescription()
                    java.lang.CharSequence r3 = r6.getContentDescription()
                    if (r3 != 0) goto L_0x00c4
                    r3 = r2
                    goto L_0x00cc
                L_0x00c4:
                    java.lang.CharSequence r3 = r6.getContentDescription()
                    java.lang.String r3 = r3.toString()
                L_0x00cc:
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r3)
                    if (r3 != 0) goto L_0x00e3
                    boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)
                    if (r8 != 0) goto L_0x00e3
                    return r1
                L_0x00e3:
                    int r8 = r7.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.HINT
                    int r3 = r3.getValue()
                    r8 = r8 & r3
                    if (r8 <= 0) goto L_0x0111
                    java.lang.String r8 = r7.getHint()
                    com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                    java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r6)
                    com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r3)
                    if (r3 != 0) goto L_0x0111
                    boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)
                    if (r8 != 0) goto L_0x0111
                    return r1
                L_0x0111:
                    int r8 = r7.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TAG
                    int r3 = r3.getValue()
                    r8 = r8 & r3
                    if (r8 <= 0) goto L_0x0149
                    java.lang.String r7 = r7.getTag()
                    java.lang.Object r8 = r6.getTag()
                    if (r8 != 0) goto L_0x012a
                    r6 = r2
                    goto L_0x0132
                L_0x012a:
                    java.lang.Object r6 = r6.getTag()
                    java.lang.String r6 = r6.toString()
                L_0x0132:
                    com.facebook.internal.Utility r8 = com.facebook.internal.Utility.INSTANCE
                    java.lang.String r8 = com.facebook.internal.Utility.sha256hash((java.lang.String) r6)
                    java.lang.String r8 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r8, r2)
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r6)
                    if (r6 != 0) goto L_0x0149
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                    if (r6 != 0) goto L_0x0149
                    return r1
                L_0x0149:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
            }

            public final List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
                List<View> findVisibleChildren;
                int size;
                List<View> findVisibleChildren2;
                int size2;
                Intrinsics.checkNotNullParameter(list, "path");
                Intrinsics.checkNotNullParameter(str, "mapKey");
                String str2 = str + '.' + i2;
                ArrayList arrayList = new ArrayList();
                if (view == null) {
                    return arrayList;
                }
                if (i >= list.size()) {
                    arrayList.add(new MatchedView(view, str2));
                } else {
                    PathComponent pathComponent = list.get(i);
                    if (Intrinsics.areEqual(pathComponent.getClassName(), "..")) {
                        ViewParent parent = view.getParent();
                        if ((parent instanceof ViewGroup) && (size2 = findVisibleChildren2.size()) > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                arrayList.addAll(findViewByPath(eventBinding, (findVisibleChildren2 = findVisibleChildren((ViewGroup) parent)).get(i3), list, i + 1, i3, str2));
                                if (i4 >= size2) {
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                        return arrayList;
                    } else if (Intrinsics.areEqual(pathComponent.getClassName(), CodelessMatcher.CURRENT_CLASS_NAME)) {
                        arrayList.add(new MatchedView(view, str2));
                        return arrayList;
                    } else if (!isTheSameView(view, pathComponent, i2)) {
                        return arrayList;
                    } else {
                        if (i == list.size() - 1) {
                            arrayList.add(new MatchedView(view, str2));
                        }
                    }
                }
                if ((view instanceof ViewGroup) && (size = findVisibleChildren.size()) > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        arrayList.addAll(findViewByPath(eventBinding, (findVisibleChildren = findVisibleChildren((ViewGroup) view)).get(i5), list, i + 1, i5, str2));
                        if (i6 >= size) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                return arrayList;
            }
        }

        public ViewMatcher(View view, Handler handler2, HashSet<String> hashSet, String str) {
            Intrinsics.checkNotNullParameter(handler2, "handler");
            Intrinsics.checkNotNullParameter(hashSet, "listenerSet");
            Intrinsics.checkNotNullParameter(str, "activityName");
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.listenerSet = hashSet;
            this.activityName = str;
            handler2.postDelayed(this, 200);
        }

        private final void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding != null) {
                try {
                    View view2 = matchedView.getView();
                    if (view2 != null) {
                        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                        View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                        if (findRCTRootView == null || !ViewHierarchy.INSTANCE.isRCTButton(view2, findRCTRootView)) {
                            String name = view2.getClass().getName();
                            Intrinsics.checkNotNullExpressionValue(name, "view.javaClass.name");
                            if (!CharsKt__CharKt.startsWith$default(name, "com.facebook.react", false, 2)) {
                                if (!(view2 instanceof AdapterView)) {
                                    attachOnClickListener(matchedView, view, eventBinding);
                                } else if (view2 instanceof ListView) {
                                    attachOnItemClickListener(matchedView, view, eventBinding);
                                }
                            }
                        } else {
                            attachRCTListener(matchedView, view, eventBinding);
                        }
                    }
                } catch (Exception e) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(CodelessMatcher.access$getTAG$cp(), e);
                }
            }
        }

        private final void attachOnClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                if (existingOnClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnClickListener) {
                    if (existingOnClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                    } else if (((CodelessLoggingEventListener.AutoLoggingOnClickListener) existingOnClickListener).getSupportCodelessLogging()) {
                        z = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z) {
                            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                            view2.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void attachOnItemClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            AdapterView adapterView = (AdapterView) matchedView.getView();
            if (adapterView != null) {
                String viewMapKey = matchedView.getViewMapKey();
                AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
                if (onItemClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnItemClickListener) {
                    if (onItemClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                    } else if (((CodelessLoggingEventListener.AutoLoggingOnItemClickListener) onItemClickListener).getSupportCodelessLogging()) {
                        z = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z) {
                            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                            adapterView.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding, view, adapterView));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
                if (existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) {
                    if (existingOnTouchListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                    } else if (((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                        z = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z) {
                            RCTCodelessLoggingEventListener rCTCodelessLoggingEventListener = RCTCodelessLoggingEventListener.INSTANCE;
                            view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void findView(EventBinding eventBinding, View view) {
            if (eventBinding != null && view != null) {
                String activityName2 = eventBinding.getActivityName();
                if ((activityName2 == null || activityName2.length() == 0) || Intrinsics.areEqual(eventBinding.getActivityName(), this.activityName)) {
                    List<PathComponent> viewPath = eventBinding.getViewPath();
                    if (viewPath.size() <= 25) {
                        for (MatchedView attachListener : Companion.findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                            attachListener(attachListener, view, eventBinding);
                        }
                    }
                }
            }
        }

        public static final List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            return Companion.findViewByPath(eventBinding, view, list, i, i2, str);
        }

        private final void startMatch() {
            List<EventBinding> list = this.eventBindings;
            if (list != null && this.rootView.get() != null) {
                int i = 0;
                int size = list.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        findView(list.get(i), (View) this.rootView.get());
                        if (i2 <= size) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public void onGlobalLayout() {
            startMatch();
        }

        public void onScrollChanged() {
            startMatch();
        }

        public void run() {
            View view;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String applicationId = FacebookSdk.getApplicationId();
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                    if (appSettingsWithoutQuery == null) {
                        return;
                    }
                    if (appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        List<EventBinding> parseArray = EventBinding.Companion.parseArray(appSettingsWithoutQuery.getEventBindings());
                        this.eventBindings = parseArray;
                        if (parseArray != null && (view = (View) this.rootView.get()) != null) {
                            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.addOnGlobalLayoutListener(this);
                                viewTreeObserver.addOnScrollChangedListener(this);
                            }
                            startMatch();
                        }
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    public CodelessMatcher() {
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        Set<Activity> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = newSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }

    public /* synthetic */ CodelessMatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ CodelessMatcher access$getCodelessMatcher$cp() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return codelessMatcher;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$setCodelessMatcher$cp(CodelessMatcher codelessMatcher2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                codelessMatcher = codelessMatcher2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final synchronized CodelessMatcher getInstance() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        synchronized (cls) {
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return null;
            }
            try {
                CodelessMatcher instance = Companion.getInstance();
                return instance;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        }
    }

    @UiThread
    public static final Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getParameters(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final void matchViews() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                for (Activity next : this.activitiesSet) {
                    if (next != null) {
                        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                        View rootView = AppEventUtility.getRootView(next);
                        String simpleName = next.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                        this.viewMatchers.add(new ViewMatcher(rootView, this.uiThreadHandler, this.listenerSet, simpleName));
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void startTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    matchViews();
                } else {
                    this.uiThreadHandler.post(new Runnable() {
                        public final void run() {
                            CodelessMatcher.m3572startTracking$lambda1(CodelessMatcher.this);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: startTracking$lambda-1  reason: not valid java name */
    public static final void m3572startTracking$lambda1(CodelessMatcher codelessMatcher2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(codelessMatcher2, "this$0");
                codelessMatcher2.matchViews();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @UiThread
    public final void add(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                InternalSettings internalSettings = InternalSettings.INSTANCE;
                if (!InternalSettings.isUnityApp()) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.activitiesSet.add(activity);
                        this.listenerSet.clear();
                        HashSet<String> hashSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
                        if (hashSet != null) {
                            this.listenerSet = hashSet;
                        }
                        startTracking();
                        return;
                    }
                    throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @UiThread
    public final void destroy(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                this.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @UiThread
    public final void remove(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                InternalSettings internalSettings = InternalSettings.INSTANCE;
                if (!InternalSettings.isUnityApp()) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.activitiesSet.remove(activity);
                        this.viewMatchers.clear();
                        this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
                        this.listenerSet.clear();
                        return;
                    }
                    throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
