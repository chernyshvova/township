package com.helpshift.account.dao;

import com.helpshift.redaction.RedactionDAO;
import com.helpshift.redaction.RedactionDetail;
import com.helpshift.redaction.RedactionState;

public class AndroidRedactionDAO implements RedactionDAO {
    public final UserDB userDB;

    public AndroidRedactionDAO(UserDB userDB2) {
        this.userDB = userDB2;
    }

    public void deleteRedactionDetail(long j) {
        if (j > 0) {
            this.userDB.deleteRedactionDetail(j);
        }
    }

    public RedactionDetail getRedactionDetail(long j) {
        if (j < 0) {
            return null;
        }
        return this.userDB.fetchRedactionDetail(j);
    }

    public void insertRedactionDetail(RedactionDetail redactionDetail) {
        if (redactionDetail != null) {
            this.userDB.insertRedactionDetail(redactionDetail);
        }
    }

    public void updateRedactionRedail(RedactionDetail redactionDetail) {
        if (redactionDetail != null) {
            this.userDB.updateRedactionDetail(redactionDetail);
        }
    }

    public void updateRedactionState(long j, RedactionState redactionState) {
        if (j >= 0 && redactionState != null) {
            this.userDB.updateRedactionState(j, redactionState);
        }
    }
}
