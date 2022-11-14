package com.helpshift.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.helpshift.C2466R;
import com.helpshift.support.util.Styles;
import com.helpshift.views.HSButton;

public class AdminCSATBotView extends RelativeLayout implements RatingBar.OnRatingBarChangeListener {
    public AdminCSATBotViewListener adminCSATBotListener = null;
    public RatingBar ratingBar;
    public HSButton sendFeedbackButton;

    public interface AdminCSATBotViewListener {
        void onCSATSurveyRequested();

        void onRatingChanged(int i);

        void sendCSATSurvey(int i);
    }

    public AdminCSATBotView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, C2466R.layout.hs__csat_bot_view, this);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.ratingBar = (RatingBar) findViewById(C2466R.C2468id.ratingBar);
        this.sendFeedbackButton = (HSButton) findViewById(C2466R.C2468id.csat_sendfeedback_btn);
        Styles.setAccentColor(getContext(), this.ratingBar.getProgressDrawable());
        this.ratingBar.setOnRatingBarChangeListener(this);
        this.sendFeedbackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AdminCSATBotView.this.adminCSATBotListener != null) {
                    AdminCSATBotView.this.adminCSATBotListener.sendCSATSurvey(Math.round(AdminCSATBotView.this.ratingBar.getRating()));
                }
            }
        });
    }

    public void onRatingChanged(RatingBar ratingBar2, float f, boolean z) {
        if (z && this.adminCSATBotListener != null) {
            int round = Math.round(f);
            if (round < 1) {
                ratingBar2.setRating(1.0f);
                round = 1;
            }
            this.adminCSATBotListener.onRatingChanged(round);
        }
    }

    public void reset() {
        this.sendFeedbackButton.setVisibility(8);
        this.ratingBar.setRating(0.0f);
    }

    public void setAdminCSATBotListener(AdminCSATBotViewListener adminCSATBotViewListener) {
        this.adminCSATBotListener = adminCSATBotViewListener;
        adminCSATBotViewListener.onCSATSurveyRequested();
    }

    public AdminCSATBotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public AdminCSATBotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
