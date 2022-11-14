package com.facebook.bolts;

import android.net.Uri;

/* compiled from: AppLinkResolver.kt */
public interface AppLinkResolver {
    Task<AppLink> getAppLinkFromUrlInBackground(Uri uri);
}
