package androidx.browser.browseractions;

import android.app.PendingIntent;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class BrowserActionItem {
    public final PendingIntent mAction;
    @DrawableRes
    public final int mIconId;
    public final String mTitle;

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i;
    }

    public PendingIntent getAction() {
        return this.mAction;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
