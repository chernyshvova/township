package com.facebook.internal.logging.dumpsys;

import java.io.PrintWriter;

/* compiled from: EndToEndDumper.kt */
public interface EndToEndDumper {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: EndToEndDumper.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static EndToEndDumper instance;

        public final EndToEndDumper getInstance() {
            return instance;
        }

        public final void setInstance(EndToEndDumper endToEndDumper) {
            instance = endToEndDumper;
        }
    }

    boolean maybeDump(String str, PrintWriter printWriter, String[] strArr);
}
