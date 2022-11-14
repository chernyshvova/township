package com.helpshift.support.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import com.helpshift.C2466R;
import com.helpshift.support.util.Styles;

public class CSATDialog extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener, View.OnClickListener, RatingBar.OnRatingBarChangeListener {
    public EditText addtionalFeedback;
    public Context context;
    public CSATView csatView;
    public RatingBar dialogRatingBar;
    public TextView likeStatus;
    public float rating;
    public boolean submitted = false;

    public CSATDialog(Context context2) {
        super(context2);
        this.context = context2;
    }

    private void setDialogRatingAndDescription(float f) {
        this.dialogRatingBar.setRating(f);
        double d = (double) f;
        if (d > 4.0d) {
            this.likeStatus.setText(C2466R.string.hs__csat_like_message);
        } else if (d > 3.0d) {
            this.likeStatus.setText(C2466R.string.hs__csat_liked_rating_message);
        } else if (d > 2.0d) {
            this.likeStatus.setText(C2466R.string.hs__csat_ok_rating_message);
        } else if (d > 1.0d) {
            this.likeStatus.setText(C2466R.string.hs__csat_disliked_rating_message);
        } else {
            this.likeStatus.setText(C2466R.string.hs__csat_dislike_message);
        }
        int i = (int) f;
        this.dialogRatingBar.setContentDescription(this.context.getResources().getQuantityString(C2466R.plurals.hs__csat_rating_value, i, new Object[]{Integer.valueOf(i)}));
    }

    public void onClick(View view) {
        if (view.getId() == C2466R.C2468id.submit) {
            this.csatView.sendCSATSurvey(this.dialogRatingBar.getRating(), this.addtionalFeedback.getText().toString());
            this.submitted = true;
            dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(C2466R.layout.hs__csat_dialog);
        setOnShowListener(this);
        setOnDismissListener(this);
        this.dialogRatingBar = (RatingBar) findViewById(C2466R.C2468id.ratingBar);
        Styles.setAccentColor(getContext(), this.dialogRatingBar.getProgressDrawable());
        this.dialogRatingBar.setOnRatingBarChangeListener(this);
        this.likeStatus = (TextView) findViewById(C2466R.C2468id.like_status);
        this.addtionalFeedback = (EditText) findViewById(C2466R.C2468id.additional_feedback);
        ((Button) findViewById(C2466R.C2468id.submit)).setOnClickListener(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.submitted) {
            this.csatView.dismiss();
            return;
        }
        this.csatView.getRatingBar().setRating(0.0f);
        this.csatView.onCSATSurveyCancelled();
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (z) {
            if (f < 1.0f) {
                f = 1.0f;
            }
            setDialogRatingAndDescription(f);
        }
    }

    public void onShow(DialogInterface dialogInterface) {
        setDialogRatingAndDescription(this.rating);
        this.csatView.onCSATSurveyStarted();
    }

    public void show(CSATView cSATView) {
        this.csatView = cSATView;
        this.rating = cSATView.getRatingBar().getRating();
        show();
    }
}
