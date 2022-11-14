package com.helpshift.redaction;

public class RedactionDetail {
    public final RedactionState redactionState;
    public final RedactionType redactionType;
    public final long userLocalId;

    public RedactionDetail(long j, RedactionState redactionState2, RedactionType redactionType2) {
        this.userLocalId = j;
        this.redactionState = redactionState2;
        this.redactionType = redactionType2;
    }
}
