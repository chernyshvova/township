package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTab.kt */
public class CustomTab {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Uri uri;

    /* compiled from: CustomTab.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Uri getURIForAction(String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "action");
            Utility utility = Utility.INSTANCE;
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            sb.append(FacebookSdk.getGraphApiVersion());
            sb.append("/dialog/");
            sb.append(str);
            return Utility.buildUri(dialogAuthority, sb.toString(), bundle);
        }
    }

    public CustomTab(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "action");
        this.uri = Companion.getURIForAction(str, bundle == null ? new Bundle() : bundle);
    }

    public static Uri getURIForAction(String str, Bundle bundle) {
        Class<CustomTab> cls = CustomTab.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getURIForAction(str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final Uri getUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean openCustomTab(Activity activity, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            CustomTabsIntent build = new CustomTabsIntent.Builder(CustomTabPrefetchHelper.Companion.getPreparedSessionOnce()).build();
            build.intent.setPackage(str);
            try {
                build.launchUrl(activity, this.uri);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final void setUri(Uri uri2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(uri2, "<set-?>");
                this.uri = uri2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
