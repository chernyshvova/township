package com.facebook.bolts;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import java.util.Collections;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLink.kt */
public final class AppLink {
    public final Uri sourceUrl;
    public final List<Target> targets;
    public final Uri webUrl;

    /* compiled from: AppLink.kt */
    public static final class Target {
        public final String appName;
        public final String className;
        public final String packageName;
        public final Uri url;

        public Target(String str, String str2, Uri uri, String str3) {
            Intrinsics.checkNotNullParameter(str, InAppPurchaseBillingClientWrapper.PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(str2, "className");
            Intrinsics.checkNotNullParameter(uri, "url");
            Intrinsics.checkNotNullParameter(str3, "appName");
            this.packageName = str;
            this.className = str2;
            this.url = uri;
            this.appName = str3;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final Uri getUrl() {
            return this.url;
        }
    }

    public AppLink(Uri uri, List<Target> list, Uri uri2) {
        Intrinsics.checkNotNullParameter(uri, "sourceUrl");
        Intrinsics.checkNotNullParameter(uri2, "webUrl");
        this.sourceUrl = uri;
        this.webUrl = uri2;
        this.targets = list == null ? EmptyList.INSTANCE : list;
    }

    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    public final List<Target> getTargets() {
        List<Target> unmodifiableList = Collections.unmodifiableList(this.targets);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(field)");
        return unmodifiableList;
    }

    public final Uri getWebUrl() {
        return this.webUrl;
    }
}
