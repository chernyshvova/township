package androidx.transition;

import android.view.View;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("TransitionValues@");
        outline24.append(Integer.toHexString(hashCode()));
        outline24.append(":\n");
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(outline24.toString(), "    view = ");
        outline26.append(this.view);
        outline26.append("\n");
        String outline16 = GeneratedOutlineSupport.outline16(outline26.toString(), "    values:");
        for (String next : this.values.keySet()) {
            outline16 = outline16 + "    " + next + ": " + this.values.get(next) + "\n";
        }
        return outline16;
    }
}
