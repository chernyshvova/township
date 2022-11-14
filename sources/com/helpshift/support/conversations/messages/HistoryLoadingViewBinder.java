package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.util.Styles;

public class HistoryLoadingViewBinder {
    public Context context;
    public HistoryLoadingClickListener historyLoadingClickListener;

    /* renamed from: com.helpshift.support.conversations.messages.HistoryLoadingViewBinder$1 */
    public static /* synthetic */ class C27661 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$HistoryLoadingState */
        public static final /* synthetic */ int[] f3359xfa6c3dcc;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.HistoryLoadingState[] r0 = com.helpshift.conversation.activeconversation.message.HistoryLoadingState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3359xfa6c3dcc = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.HistoryLoadingState r2 = com.helpshift.conversation.activeconversation.message.HistoryLoadingState.NONE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3359xfa6c3dcc     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.conversation.activeconversation.message.HistoryLoadingState r3 = com.helpshift.conversation.activeconversation.message.HistoryLoadingState.LOADING     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f3359xfa6c3dcc     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.activeconversation.message.HistoryLoadingState r2 = com.helpshift.conversation.activeconversation.message.HistoryLoadingState.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.HistoryLoadingViewBinder.C27661.<clinit>():void");
        }
    }

    public interface HistoryLoadingClickListener {
        void onHistoryLoadingRetryClicked();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View errorStateView = this.itemView.findViewById(C2466R.C2468id.loading_error_state_view);
        public final View layoutView = this.itemView.findViewById(C2466R.C2468id.history_loading_layout_view);
        public final View loadingErrorTapToRetry;
        public final View loadingStateView = this.itemView.findViewById(C2466R.C2468id.loading_state_view);
        public final ProgressBar progress;

        public ViewHolder(View view) {
            super(view);
            View findViewById = this.itemView.findViewById(C2466R.C2468id.loading_error_tap_to_retry);
            this.loadingErrorTapToRetry = findViewById;
            findViewById.setOnClickListener(this);
            this.progress = (ProgressBar) this.itemView.findViewById(C2466R.C2468id.loading_progressbar);
            Styles.setAccentColor(HistoryLoadingViewBinder.this.context, this.progress.getIndeterminateDrawable());
        }

        public void onClick(View view) {
            if (HistoryLoadingViewBinder.this.historyLoadingClickListener != null) {
                HistoryLoadingViewBinder.this.historyLoadingClickListener.onHistoryLoadingRetryClicked();
            }
        }
    }

    public HistoryLoadingViewBinder(Context context2) {
        this.context = context2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.helpshift.support.conversations.messages.HistoryLoadingViewBinder.ViewHolder r6, com.helpshift.conversation.activeconversation.message.HistoryLoadingState r7) {
        /*
            r5 = this;
            int r7 = r7.ordinal()
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0015
            if (r7 == r0) goto L_0x0013
            r2 = 2
            if (r7 == r2) goto L_0x0010
            r7 = 0
        L_0x000e:
            r2 = 0
            goto L_0x0018
        L_0x0010:
            r7 = 0
            r2 = 1
            goto L_0x0018
        L_0x0013:
            r7 = 1
            goto L_0x000e
        L_0x0015:
            r7 = 0
            r0 = 0
            goto L_0x000e
        L_0x0018:
            android.view.View r3 = r6.layoutView
            r4 = 8
            if (r0 == 0) goto L_0x0022
            r0 = 0
            goto L_0x0024
        L_0x0022:
            r0 = 8
        L_0x0024:
            r3.setVisibility(r0)
            android.view.View r0 = r6.loadingStateView
            if (r7 == 0) goto L_0x002f
            r7 = 0
            goto L_0x0031
        L_0x002f:
            r7 = 8
        L_0x0031:
            r0.setVisibility(r7)
            android.view.View r6 = r6.errorStateView
            if (r2 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r1 = 8
        L_0x003d:
            r6.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.messages.HistoryLoadingViewBinder.bind(com.helpshift.support.conversations.messages.HistoryLoadingViewBinder$ViewHolder, com.helpshift.conversation.activeconversation.message.HistoryLoadingState):void");
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__history_loading_view_layout, viewGroup, false));
    }

    public void setHistoryLoadingClickListener(HistoryLoadingClickListener historyLoadingClickListener2) {
        this.historyLoadingClickListener = historyLoadingClickListener2;
    }
}
