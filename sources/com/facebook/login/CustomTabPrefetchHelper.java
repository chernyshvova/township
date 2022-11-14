package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabPrefetchHelper.kt */
public final class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static CustomTabsClient client;
    public static final ReentrantLock lock = new ReentrantLock();
    public static CustomTabsSession session;

    /* compiled from: CustomTabPrefetchHelper.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void prepareSession() {
            CustomTabsClient access$getClient$cp;
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null && (access$getClient$cp = CustomTabPrefetchHelper.client) != null) {
                Companion companion = CustomTabPrefetchHelper.Companion;
                CustomTabPrefetchHelper.session = access$getClient$cp.newSession((CustomTabsCallback) null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        public final CustomTabsSession getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession access$getSession$cp = CustomTabPrefetchHelper.session;
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return access$getSession$cp;
        }

        public final void mayLaunchUrl(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession access$getSession$cp = CustomTabPrefetchHelper.session;
            if (access$getSession$cp != null) {
                access$getSession$cp.mayLaunchUrl(uri, (Bundle) null, (List<Bundle>) null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }
    }

    public static final CustomTabsSession getPreparedSessionOnce() {
        return Companion.getPreparedSessionOnce();
    }

    public static final void mayLaunchUrl(Uri uri) {
        Companion.mayLaunchUrl(uri);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(customTabsClient, "newClient");
        customTabsClient.warmup(0);
        Companion companion = Companion;
        client = customTabsClient;
        companion.prepareSession();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
    }
}
