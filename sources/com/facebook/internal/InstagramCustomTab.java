package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstagramCustomTab.kt */
public final class InstagramCustomTab extends CustomTab {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* compiled from: InstagramCustomTab.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Uri getURIForAction(String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "action");
            if (Intrinsics.areEqual(str, "oauth")) {
                Utility utility = Utility.INSTANCE;
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
            }
            Utility utility2 = Utility.INSTANCE;
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            String instagramDialogAuthority = ServerProtocol.getInstagramDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            sb.append(FacebookSdk.getGraphApiVersion());
            sb.append("/dialog/");
            sb.append(str);
            return Utility.buildUri(instagramDialogAuthority, sb.toString(), bundle);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstagramCustomTab(String str, Bundle bundle) {
        super(str, bundle);
        Intrinsics.checkNotNullParameter(str, "action");
        setUri(Companion.getURIForAction(str, bundle == null ? new Bundle() : bundle));
    }
}
