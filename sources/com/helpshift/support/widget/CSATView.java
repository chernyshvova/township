package com.helpshift.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.helpshift.C2466R;
import com.helpshift.support.util.Styles;

public class CSATView extends RelativeLayout implements RatingBar.OnRatingBarChangeListener {
    public CSATDialog csatDialog;
    public CSATListener csatListener = null;
    public RatingBar ratingBar;

    public interface CSATListener {
        void onCSATSurveyCancelled();

        void onCSATSurveyStarted();

        void sendCSATSurvey(int i, String str);
    }

    public CSATView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, C2466R.layout.hs__csat_view, this);
        this.csatDialog = new CSATDialog(context);
    }

    public void dismiss() {
        setVisibility(8);
        this.csatDialog = null;
    }

    public RatingBar getRatingBar() {
        return this.ratingBar;
    }

    public void hideCSATDialog() {
        CSATDialog cSATDialog = this.csatDialog;
        if (cSATDialog != null && cSATDialog.isShowing()) {
            this.csatDialog.dismiss();
        }
    }

    public void onCSATSurveyCancelled() {
        CSATListener cSATListener = this.csatListener;
        if (cSATListener != null) {
            cSATListener.onCSATSurveyCancelled();
        }
    }

    public void onCSATSurveyStarted() {
        CSATListener cSATListener = this.csatListener;
        if (cSATListener != null) {
            cSATListener.onCSATSurveyStarted();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.ratingBar = (RatingBar) findViewById(C2466R.C2468id.ratingBar);
        Styles.setAccentColor(getContext(), this.ratingBar.getProgressDrawable());
        this.ratingBar.setOnRatingBarChangeListener(this);
    }

    public void onRatingChanged(RatingBar ratingBar2, float f, boolean z) {
        if (z) {
            this.csatDialog.show(this);
        }
    }

    public void sendCSATSurvey(float f, String str) {
        CSATListener cSATListener = this.csatListener;
        if (cSATListener != null) {
            cSATListener.sendCSATSurvey(Math.round(f), str);
        }
    }

    public void setCSATListener(CSATListener cSATListener) {
        this.csatListener = cSATListener;
    }

    public CSATView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public CSATView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
