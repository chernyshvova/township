package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.swrve.sdk.conversations.C1694R;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.ConversationInputChangedListener;
import com.swrve.sdk.conversations.engine.model.StarRating;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationRatingBar */
public class ConversationRatingBar extends LinearLayout implements RatingBar.OnRatingBarChangeListener, IConversationInput {
    public HtmlSnippetView htmlSnippetView;
    public ConversationInputChangedListener inputChangedListener;
    public StarRating model;
    public RatingBar ratingBar;

    public ConversationRatingBar(Context context, StarRating starRating, File file) {
        super(context);
        this.model = starRating;
        setOrientation(1);
        setTag(starRating.getTag());
        initHtmlSnippetView(file);
        initRatingBar();
    }

    private void initHtmlSnippetView(File file) {
        this.htmlSnippetView = new HtmlSnippetView(getContext(), new Content(this.model.getTag(), ConversationAtom.TYPE.CONTENT_HTML, this.model.getStyle(), this.model.getValue(), ""), file);
        this.htmlSnippetView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.htmlSnippetView.setBackgroundColor(0);
        SwrveConversationHelper.setBackgroundDrawable(this.htmlSnippetView, this.model.getStyle().getBg().getPrimaryDrawable());
        addView(this.htmlSnippetView);
    }

    private void initRatingBar() {
        RatingBar ratingBar2 = new RatingBar(getContext(), (AttributeSet) null, C1694R.attr.conversationContentRatingBarStyle);
        this.ratingBar = ratingBar2;
        ratingBar2.setNumStars(5);
        this.ratingBar.setStepSize(0.01f);
        this.ratingBar.setOnRatingBarChangeListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.ratingBar.setLayoutParams(layoutParams);
        setStarColor(Color.parseColor(this.model.getStarColor()));
        RelativeLayout relativeLayout = new RelativeLayout(getContext(), (AttributeSet) null, C1694R.attr.conversationContentRatingBarContainerStyle);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        relativeLayout.addView(this.ratingBar);
        addView(relativeLayout);
    }

    private void setStarColor(int i) {
        LayerDrawable layerDrawable = (LayerDrawable) this.ratingBar.getProgressDrawable();
        layerDrawable.getDrawable(0).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(1).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(2).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    public HtmlSnippetView getHtmlSnippetView() {
        return this.htmlSnippetView;
    }

    public StarRating getModel() {
        return this.model;
    }

    public RatingBar getRatingBar() {
        return this.ratingBar;
    }

    public void onRatingChanged(RatingBar ratingBar2, float f, boolean z) {
        if (z) {
            if (f < 1.0f) {
                ratingBar2.setRating(1.0f);
            } else {
                ratingBar2.setRating((float) Math.ceil((double) f));
            }
            if (this.inputChangedListener != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(this.model.getTag(), Float.valueOf(ratingBar2.getRating()));
                this.inputChangedListener.onContentChanged(hashMap, this.model);
            }
        }
    }

    public void setContentChangedListener(ConversationInputChangedListener conversationInputChangedListener) {
        this.inputChangedListener = conversationInputChangedListener;
    }

    public void setUserInput(UserInputResult userInputResult) {
        if (userInputResult.getResult() != null && (userInputResult.getResult() instanceof Float)) {
            this.ratingBar.setRating(((Float) userInputResult.getResult()).floatValue());
        }
    }
}
