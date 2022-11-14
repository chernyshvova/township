package com.facebook;

import android.content.Intent;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.CallbackManagerImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallbackManager.kt */
public interface CallbackManager {

    /* compiled from: CallbackManager.kt */
    public static final class ActivityResultParameters {
        public final Intent data;
        public final int requestCode;
        public final int resultCode;

        public ActivityResultParameters(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }

        public static /* synthetic */ ActivityResultParameters copy$default(ActivityResultParameters activityResultParameters, int i, int i2, Intent intent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = activityResultParameters.requestCode;
            }
            if ((i3 & 2) != 0) {
                i2 = activityResultParameters.resultCode;
            }
            if ((i3 & 4) != 0) {
                intent = activityResultParameters.data;
            }
            return activityResultParameters.copy(i, i2, intent);
        }

        public final int component1() {
            return this.requestCode;
        }

        public final int component2() {
            return this.resultCode;
        }

        public final Intent component3() {
            return this.data;
        }

        public final ActivityResultParameters copy(int i, int i2, Intent intent) {
            return new ActivityResultParameters(i, i2, intent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityResultParameters)) {
                return false;
            }
            ActivityResultParameters activityResultParameters = (ActivityResultParameters) obj;
            return this.requestCode == activityResultParameters.requestCode && this.resultCode == activityResultParameters.resultCode && Intrinsics.areEqual(this.data, activityResultParameters.data);
        }

        public final Intent getData() {
            return this.data;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public int hashCode() {
            int i = ((this.requestCode * 31) + this.resultCode) * 31;
            Intent intent = this.data;
            return i + (intent == null ? 0 : intent.hashCode());
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("ActivityResultParameters(requestCode=");
            outline24.append(this.requestCode);
            outline24.append(", resultCode=");
            outline24.append(this.resultCode);
            outline24.append(", data=");
            outline24.append(this.data);
            outline24.append(')');
            return outline24.toString();
        }
    }

    /* compiled from: CallbackManager.kt */
    public static final class Factory {
        public static final Factory INSTANCE = new Factory();

        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int i, int i2, Intent intent);
}
