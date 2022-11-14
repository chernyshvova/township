package com.facebook.share;

/* compiled from: Sharer.kt */
public interface Sharer {

    /* compiled from: Sharer.kt */
    public static final class Result {
        public final String postId;

        public Result(String str) {
            this.postId = str;
        }

        public final String getPostId() {
            return this.postId;
        }
    }

    boolean getShouldFailOnDataError();

    void setShouldFailOnDataError(boolean z);
}
