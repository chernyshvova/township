package com.helpshift.redaction;

public interface RedactionDAO {
    void deleteRedactionDetail(long j);

    RedactionDetail getRedactionDetail(long j);

    void insertRedactionDetail(RedactionDetail redactionDetail);

    void updateRedactionRedail(RedactionDetail redactionDetail);

    void updateRedactionState(long j, RedactionState redactionState);
}
