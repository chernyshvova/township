package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContentUriTriggers {
    public final Set<Trigger> mTriggers = new HashSet();

    public static final class Trigger {
        public final boolean mTriggerForDescendants;
        @NonNull
        public final Uri mUri;

        public Trigger(@NonNull Uri uri, boolean z) {
            this.mUri = uri;
            this.mTriggerForDescendants = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Trigger.class != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            if (this.mTriggerForDescendants != trigger.mTriggerForDescendants || !this.mUri.equals(trigger.mUri)) {
                return false;
            }
            return true;
        }

        @NonNull
        public Uri getUri() {
            return this.mUri;
        }

        public int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }

        public boolean shouldTriggerForDescendants() {
            return this.mTriggerForDescendants;
        }
    }

    public void add(@NonNull Uri uri, boolean z) {
        this.mTriggers.add(new Trigger(uri, z));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentUriTriggers.class != obj.getClass()) {
            return false;
        }
        return this.mTriggers.equals(((ContentUriTriggers) obj).mTriggers);
    }

    @NonNull
    public Set<Trigger> getTriggers() {
        return this.mTriggers;
    }

    public int hashCode() {
        return this.mTriggers.hashCode();
    }

    public int size() {
        return this.mTriggers.size();
    }
}
