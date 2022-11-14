package com.helpshift.account;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.delegate.AuthenticationFailureReason;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationFailureDM {
    public Domain domain;
    public List<AuthenticationFailureObserver> observerList = new ArrayList();

    public interface AuthenticationFailureObserver {
        void onAuthenticationFailure();
    }

    public AuthenticationFailureDM(Domain domain2) {
        this.domain = domain2;
    }

    private void notifyObservers() {
        for (AuthenticationFailureObserver next : this.observerList) {
            if (next != null) {
                next.onAuthenticationFailure();
            }
        }
    }

    public void notifyAuthenticationFailure(UserDM userDM, ExceptionType exceptionType) {
        if (userDM.isActiveUser()) {
            AuthenticationFailureReason authenticationFailureReason = null;
            if (exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                authenticationFailureReason = AuthenticationFailureReason.AUTH_TOKEN_NOT_PROVIDED;
            } else if (exceptionType == NetworkException.INVALID_AUTH_TOKEN) {
                authenticationFailureReason = AuthenticationFailureReason.INVALID_AUTH_TOKEN;
            }
            if (authenticationFailureReason != null) {
                notifyObservers();
                this.domain.getDelegate().authenticationFailed(userDM, authenticationFailureReason);
            }
        }
    }

    public void registerListener(AuthenticationFailureObserver authenticationFailureObserver) {
        if (authenticationFailureObserver != null) {
            this.observerList.add(authenticationFailureObserver);
        }
    }

    public void unregisterListener(AuthenticationFailureObserver authenticationFailureObserver) {
        if (authenticationFailureObserver != null) {
            this.observerList.remove(authenticationFailureObserver);
        }
    }
}
