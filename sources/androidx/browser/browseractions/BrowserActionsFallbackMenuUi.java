package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.C0133R;
import androidx.core.widget.TextViewCompat;
import java.util.List;

public class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {
    public static final String TAG = "BrowserActionskMenuUi";
    public BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
    public final Context mContext;
    public final List<BrowserActionItem> mMenuItems;
    public BrowserActionsFallMenuUiListener mMenuUiListener;
    public final Uri mUri;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public interface BrowserActionsFallMenuUiListener {
        void onMenuShown(View view);
    }

    public BrowserActionsFallbackMenuUi(Context context, Uri uri, List<BrowserActionItem> list) {
        this.mContext = context;
        this.mUri = uri;
        this.mMenuItems = list;
    }

    private BrowserActionsFallbackMenuView initMenuView(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(C0133R.C0135id.browser_actions_menu_view);
        final TextView textView = (TextView) view.findViewById(C0133R.C0135id.browser_actions_header_text);
        textView.setText(this.mUri.toString());
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextViewCompat.getMaxLines(textView) == Integer.MAX_VALUE) {
                    textView.setMaxLines(1);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    return;
                }
                textView.setMaxLines(Integer.MAX_VALUE);
                textView.setEllipsize((TextUtils.TruncateAt) null);
            }
        });
        ListView listView = (ListView) view.findViewById(C0133R.C0135id.browser_actions_menu_items);
        listView.setAdapter(new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.mContext));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void displayMenu() {
        final View inflate = LayoutInflater.from(this.mContext).inflate(C0133R.layout.browser_actions_context_menu_page, (ViewGroup) null);
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = new BrowserActionsFallbackMenuDialog(this.mContext, initMenuView(inflate));
        this.mBrowserActionsDialog = browserActionsFallbackMenuDialog;
        browserActionsFallbackMenuDialog.setContentView(inflate);
        if (this.mMenuUiListener != null) {
            this.mBrowserActionsDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    BrowserActionsFallbackMenuUi.this.mMenuUiListener.onMenuShown(inflate);
                }
            });
        }
        this.mBrowserActionsDialog.show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            this.mMenuItems.get(i).getAction().send();
            this.mBrowserActionsDialog.dismiss();
        } catch (PendingIntent.CanceledException e) {
            Log.e(TAG, "Failed to send custom item action", e);
        }
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMenuUiListener(BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener) {
        this.mMenuUiListener = browserActionsFallMenuUiListener;
    }
}
