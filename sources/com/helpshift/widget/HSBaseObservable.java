package com.helpshift.widget;

import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;

public abstract class HSBaseObservable {
    public Domain domain;
    public HSObserver viewObserver;

    public void notifyChange(final Object obj) {
        Domain domain2;
        if (this.viewObserver != null && (domain2 = this.domain) != null) {
            domain2.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    if (HSBaseObservable.this.viewObserver != null) {
                        HSBaseObservable.this.viewObserver.onChanged(obj);
                    }
                }
            });
        }
    }

    public abstract void notifyInitialState();

    public void subscribe(Domain domain2, HSObserver hSObserver) {
        this.domain = domain2;
        this.viewObserver = hSObserver;
        notifyInitialState();
    }

    public void unsubscribe() {
        this.viewObserver = null;
    }
}
