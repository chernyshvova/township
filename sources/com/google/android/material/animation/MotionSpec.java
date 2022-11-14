package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {
    public final SimpleArrayMap<String, MotionTiming> timings = new SimpleArrayMap<>();

    @Nullable
    public static MotionSpec createFromAttribute(Context context, TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return createFromResource(context, resourceId);
    }

    @Nullable
    public static MotionSpec createFromResource(Context context, @AnimatorRes int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return createSpecFromAnimators(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return createSpecFromAnimators(arrayList);
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Can't load animation resource ID #0x");
            outline24.append(Integer.toHexString(i));
            Log.w("MotionSpec", outline24.toString(), e);
            return null;
        }
    }

    public static MotionSpec createSpecFromAnimators(List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        int i = 0;
        while (i < size) {
            Animator animator = list.get(i);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
                }
                MotionTiming motionTiming = new MotionTiming(startDelay, duration, interpolator);
                motionTiming.repeatCount = objectAnimator.getRepeatCount();
                motionTiming.repeatMode = objectAnimator.getRepeatMode();
                motionSpec.timings.put(propertyName, motionTiming);
                i++;
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return motionSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionSpec.class != obj.getClass()) {
            return false;
        }
        return this.timings.equals(((MotionSpec) obj).timings);
    }

    public MotionTiming getTiming(String str) {
        if (this.timings.get(str) != null) {
            return this.timings.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public String toString() {
        return 10 + MotionSpec.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
