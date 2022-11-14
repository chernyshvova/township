package com.facebook.share.model;

import com.facebook.share.ShareBuilder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* compiled from: ShareModelBuilder.kt */
public interface ShareModelBuilder<M extends ShareModel, B extends ShareModelBuilder<M, B>> extends ShareBuilder<M, B> {
    B readFrom(M m);
}
