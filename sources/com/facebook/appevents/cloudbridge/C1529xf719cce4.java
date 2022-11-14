package com.facebook.appevents.cloudbridge;

import com.facebook.internal.Utility;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1 */
/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
public final class C1529xf719cce4 extends Lambda implements Function2<String, Integer, Unit> {
    public final /* synthetic */ List<Map<String, Object>> $processedEvents;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1529xf719cce4(List<? extends Map<String, ? extends Object>> list) {
        super(2);
        this.$processedEvents = list;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m3568invoke$lambda0(Integer num, List list) {
        Intrinsics.checkNotNullParameter(list, "$processedEvents");
        if (!CollectionsKt__CollectionsKt.contains(AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE, num)) {
            AppEventsConversionsAPITransformerWebRequests.INSTANCE.handleError$facebook_core_release(num, list, 5);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Integer) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Integer num) {
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new Runnable(num, this.$processedEvents) {
            public final /* synthetic */ Integer f$0;
            public final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                C1529xf719cce4.m3568invoke$lambda0(this.f$0, this.f$1);
            }
        });
    }
}
