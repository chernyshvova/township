package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.p003os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10 */
    public static /* synthetic */ class C023910 {

        /* renamed from: $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State */
        public static final /* synthetic */ int[] f20xe493b431;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20xe493b431 = r0
                r1 = 1
                r2 = 2
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 3
                int[] r3 = f20xe493b431     // Catch:{ NoSuchFieldError -> 0x0016 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r2 = f20xe493b431     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 0
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20xe493b431     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.C023910.<clinit>():void");
        }
    }

    public static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        public FragmentAnim.AnimationOrAnimator mAnimation;
        public boolean mLoadedAnim = false;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            super(operation, cancellationSignal);
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    public static class SpecialEffectsInfo {
        @NonNull
        public final SpecialEffectsController.Operation mOperation;
        @NonNull
        public final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isVisibilityUnchanged() {
            /*
                r3 = this;
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r3.mOperation
                androidx.fragment.app.Fragment r0 = r0.getFragment()
                android.view.View r0 = r0.mView
                androidx.fragment.app.SpecialEffectsController$Operation$State r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.from((android.view.View) r0)
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r3.mOperation
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = r1.getFinalState()
                if (r0 == r1) goto L_0x001d
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                if (r0 == r2) goto L_0x001b
                if (r1 == r2) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r0 = 0
                goto L_0x001e
            L_0x001d:
                r0 = 1
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.SpecialEffectsInfo.isVisibilityUnchanged():boolean");
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (AnimationInfo next : list) {
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        final SpecialEffectsController.Operation operation = next.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            final boolean z3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z3) {
                                list3.remove(operation);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            C02402 r13 = r0;
                            final ViewGroup viewGroup = container;
                            final AnimationInfo animationInfo = next;
                            C02402 r0 = new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    viewGroup.endViewTransition(view);
                                    if (z3) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            };
                            animator.addListener(r13);
                            animator.setTarget(view);
                            animator.start();
                            next.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() {
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            container.post(new Runnable() {
                                public void run() {
                                    C02424 r0 = C02424.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() {
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v28, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r33, boolean r34, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r35, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r36) {
        /*
            r32 = this;
            r6 = r32
            r7 = r34
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.Iterator r0 = r33.iterator()
            r1 = 0
            r15 = r1
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r2 = r1.isVisibilityUnchanged()
            if (r2 == 0) goto L_0x0022
            goto L_0x000f
        L_0x0022:
            androidx.fragment.app.FragmentTransitionImpl r2 = r1.getHandlingImpl()
            if (r15 != 0) goto L_0x002a
            r15 = r2
            goto L_0x000f
        L_0x002a:
            if (r2 == 0) goto L_0x000f
            if (r15 != r2) goto L_0x002f
            goto L_0x000f
        L_0x002f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r1.getOperation()
            androidx.fragment.app.Fragment r3 = r3.getFragment()
            r2.append(r3)
            java.lang.String r3 = " returned Transition "
            r2.append(r3)
            java.lang.Object r1 = r1.getTransition()
            r2.append(r1)
            java.lang.String r1 = " which uses a different Transition  type than other Fragments."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x005b:
            if (r15 != 0) goto L_0x007b
            java.util.Iterator r0 = r33.iterator()
        L_0x0061:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            androidx.fragment.app.SpecialEffectsController$Operation r2 = r1.getOperation()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r8.put(r2, r3)
            r1.completeSpecialEffect()
            goto L_0x0061
        L_0x007a:
            return r8
        L_0x007b:
            android.view.View r14 = new android.view.View
            android.view.ViewGroup r0 = r32.getContainer()
            android.content.Context r0 = r0.getContext()
            r14.<init>(r0)
            android.graphics.Rect r13 = new android.graphics.Rect
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            java.util.Iterator r17 = r33.iterator()
            r0 = 0
            r1 = 0
            r2 = 0
            r2 = r36
            r9 = r1
            r18 = 0
            r1 = r35
        L_0x00aa:
            boolean r3 = r17.hasNext()
            if (r3 == 0) goto L_0x0326
            java.lang.Object r3 = r17.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r3 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r3
            boolean r4 = r3.hasSharedElementTransition()
            if (r4 == 0) goto L_0x030d
            if (r1 == 0) goto L_0x030d
            if (r2 == 0) goto L_0x030d
            java.lang.Object r0 = r3.getSharedElementTransition()
            java.lang.Object r0 = r15.cloneTransition(r0)
            java.lang.Object r5 = r15.wrapTransitionInSet(r0)
            androidx.fragment.app.Fragment r0 = r36.getFragment()
            java.util.ArrayList r4 = r0.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r0 = r35.getFragment()
            java.util.ArrayList r0 = r0.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r1 = r35.getFragment()
            java.util.ArrayList r1 = r1.getSharedElementTargetNames()
            r2 = 0
        L_0x00e5:
            int r3 = r1.size()
            if (r2 >= r3) goto L_0x0104
            java.lang.Object r3 = r1.get(r2)
            int r3 = r4.indexOf(r3)
            r16 = r1
            r1 = -1
            if (r3 == r1) goto L_0x00ff
            java.lang.Object r1 = r0.get(r2)
            r4.set(r3, r1)
        L_0x00ff:
            int r2 = r2 + 1
            r1 = r16
            goto L_0x00e5
        L_0x0104:
            androidx.fragment.app.Fragment r0 = r36.getFragment()
            java.util.ArrayList r3 = r0.getSharedElementTargetNames()
            if (r7 != 0) goto L_0x011f
            androidx.fragment.app.Fragment r0 = r35.getFragment()
            androidx.core.app.SharedElementCallback r0 = r0.getExitTransitionCallback()
            androidx.fragment.app.Fragment r1 = r36.getFragment()
            androidx.core.app.SharedElementCallback r1 = r1.getEnterTransitionCallback()
            goto L_0x012f
        L_0x011f:
            androidx.fragment.app.Fragment r0 = r35.getFragment()
            androidx.core.app.SharedElementCallback r0 = r0.getEnterTransitionCallback()
            androidx.fragment.app.Fragment r1 = r36.getFragment()
            androidx.core.app.SharedElementCallback r1 = r1.getExitTransitionCallback()
        L_0x012f:
            int r2 = r4.size()
            r16 = 0
            r19 = r5
            r5 = 0
        L_0x0138:
            if (r5 >= r2) goto L_0x0158
            java.lang.Object r16 = r4.get(r5)
            r20 = r2
            r2 = r16
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r16 = r3.get(r5)
            r21 = r9
            r9 = r16
            java.lang.String r9 = (java.lang.String) r9
            r10.put(r2, r9)
            int r5 = r5 + 1
            r2 = r20
            r9 = r21
            goto L_0x0138
        L_0x0158:
            r21 = r9
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            androidx.fragment.app.Fragment r2 = r35.getFragment()
            android.view.View r2 = r2.mView
            r6.findNamedViews(r9, r2)
            r9.retainAll(r4)
            if (r0 == 0) goto L_0x01ad
            r0.onMapSharedElements(r4, r9)
            int r0 = r4.size()
            int r0 = r0 + -1
        L_0x0176:
            if (r0 < 0) goto L_0x01aa
            java.lang.Object r2 = r4.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r9.get(r2)
            android.view.View r5 = (android.view.View) r5
            if (r5 != 0) goto L_0x018c
            r10.remove(r2)
            r16 = r4
            goto L_0x01a5
        L_0x018c:
            r16 = r4
            java.lang.String r4 = androidx.core.view.ViewCompat.getTransitionName(r5)
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x01a5
            java.lang.Object r2 = r10.remove(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r4 = androidx.core.view.ViewCompat.getTransitionName(r5)
            r10.put(r4, r2)
        L_0x01a5:
            int r0 = r0 + -1
            r4 = r16
            goto L_0x0176
        L_0x01aa:
            r16 = r4
            goto L_0x01b6
        L_0x01ad:
            r16 = r4
            java.util.Set r0 = r9.keySet()
            r10.retainAll(r0)
        L_0x01b6:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            androidx.fragment.app.Fragment r0 = r36.getFragment()
            android.view.View r0 = r0.mView
            r6.findNamedViews(r5, r0)
            r5.retainAll(r3)
            java.util.Collection r0 = r10.values()
            r5.retainAll(r0)
            if (r1 == 0) goto L_0x020d
            r1.onMapSharedElements(r3, r5)
            int r0 = r3.size()
            int r0 = r0 + -1
        L_0x01d9:
            if (r0 < 0) goto L_0x0210
            java.lang.Object r1 = r3.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.get(r1)
            android.view.View r2 = (android.view.View) r2
            if (r2 != 0) goto L_0x01f3
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.findKeyForValue(r10, r1)
            if (r1 == 0) goto L_0x020a
            r10.remove(r1)
            goto L_0x020a
        L_0x01f3:
            java.lang.String r4 = androidx.core.view.ViewCompat.getTransitionName(r2)
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x020a
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.findKeyForValue(r10, r1)
            if (r1 == 0) goto L_0x020a
            java.lang.String r2 = androidx.core.view.ViewCompat.getTransitionName(r2)
            r10.put(r1, r2)
        L_0x020a:
            int r0 = r0 + -1
            goto L_0x01d9
        L_0x020d:
            androidx.fragment.app.FragmentTransition.retainValues(r10, r5)
        L_0x0210:
            java.util.Set r0 = r10.keySet()
            r6.retainMatchingViews(r9, r0)
            java.util.Collection r0 = r10.values()
            r6.retainMatchingViews(r5, r0)
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x023a
            r12.clear()
            r11.clear()
            r0 = 0
            r1 = r35
            r9 = r1
            r2 = r36
            r4 = r10
            r5 = r11
            r7 = r12
            r3 = r15
            r10 = r2
        L_0x0235:
            r15 = r8
            r8 = r14
            r14 = r13
            goto L_0x0319
        L_0x023a:
            androidx.fragment.app.Fragment r0 = r36.getFragment()
            androidx.fragment.app.Fragment r1 = r35.getFragment()
            r2 = 1
            androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(r0, r1, r7, r9, r2)
            android.view.ViewGroup r4 = r32.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$6 r2 = new androidx.fragment.app.DefaultSpecialEffectsController$6
            r1 = 0
            r0 = r2
            r7 = 0
            r1 = r32
            r7 = r2
            r2 = r36
            r22 = r3
            r3 = r35
            r23 = r16
            r16 = r10
            r10 = r4
            r4 = r34
            r24 = r8
            r8 = r19
            r19 = r5
            r0.<init>(r2, r3, r4, r5)
            androidx.core.view.OneShotPreDrawListener.add(r10, r7)
            java.util.Collection r0 = r9.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x0273:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0283
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            r6.captureTransitioningViews(r12, r1)
            goto L_0x0273
        L_0x0283:
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x029e
            r0 = r23
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.get(r0)
            r9 = r0
            android.view.View r9 = (android.view.View) r9
            r15.setEpicenter((java.lang.Object) r8, (android.view.View) r9)
            r21 = r9
        L_0x029e:
            java.util.Collection r0 = r19.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x02a6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02b6
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            r6.captureTransitioningViews(r11, r1)
            goto L_0x02a6
        L_0x02b6:
            boolean r0 = r22.isEmpty()
            if (r0 != 0) goto L_0x02dd
            r0 = r22
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r1 = r19
            java.lang.Object r0 = r1.get(r0)
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x02dd
            android.view.ViewGroup r1 = r32.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$7 r2 = new androidx.fragment.app.DefaultSpecialEffectsController$7
            r2.<init>(r15, r0, r13)
            androidx.core.view.OneShotPreDrawListener.add(r1, r2)
            r18 = 1
        L_0x02dd:
            r15.setSharedElementTargets(r8, r14, r12)
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r9 = r15
            r4 = r16
            r10 = r8
            r5 = r11
            r11 = r0
            r7 = r12
            r12 = r1
            r0 = r13
            r13 = r2
            r1 = r14
            r14 = r3
            r3 = r15
            r15 = r8
            r16 = r5
            r9.scheduleRemoveTargets(r10, r11, r12, r13, r14, r15, r16)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r9 = r35
            r15 = r24
            r15.put(r9, r2)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r10 = r36
            r15.put(r10, r2)
            r14 = r0
            r0 = r8
            r2 = r10
            r8 = r1
            r1 = r9
            goto L_0x0319
        L_0x030d:
            r21 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r3 = r15
            r9 = r35
            r10 = r36
            goto L_0x0235
        L_0x0319:
            r10 = r4
            r11 = r5
            r12 = r7
            r13 = r14
            r9 = r21
            r7 = r34
            r14 = r8
            r8 = r15
            r15 = r3
            goto L_0x00aa
        L_0x0326:
            r21 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r3 = r15
            r15 = r8
            r8 = r14
            r14 = r13
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r17 = r33.iterator()
            r9 = 0
            r10 = 0
            r12 = r9
            r11 = r10
        L_0x033c:
            boolean r9 = r17.hasNext()
            if (r9 == 0) goto L_0x0466
            java.lang.Object r9 = r17.next()
            r19 = r9
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r19 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r19
            boolean r9 = r19.isVisibilityUnchanged()
            if (r9 == 0) goto L_0x035d
            androidx.fragment.app.SpecialEffectsController$Operation r9 = r19.getOperation()
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r15.put(r9, r10)
            r19.completeSpecialEffect()
            goto L_0x033c
        L_0x035d:
            java.lang.Object r9 = r19.getTransition()
            java.lang.Object r10 = r3.cloneTransition(r9)
            androidx.fragment.app.SpecialEffectsController$Operation r9 = r19.getOperation()
            if (r0 == 0) goto L_0x0372
            if (r9 == r1) goto L_0x036f
            if (r9 != r2) goto L_0x0372
        L_0x036f:
            r16 = 1
            goto L_0x0374
        L_0x0372:
            r16 = 0
        L_0x0374:
            if (r10 != 0) goto L_0x038a
            if (r16 != 0) goto L_0x0380
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r15.put(r9, r10)
            r19.completeSpecialEffect()
        L_0x0380:
            r16 = r8
            r9 = r14
            r14 = r15
            r15 = r13
            r13 = r11
            r11 = r21
            goto L_0x045c
        L_0x038a:
            r24 = r15
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r34 = r11
            androidx.fragment.app.Fragment r11 = r9.getFragment()
            android.view.View r11 = r11.mView
            r6.captureTransitioningViews(r15, r11)
            if (r16 == 0) goto L_0x03a7
            if (r9 != r1) goto L_0x03a4
            r15.removeAll(r7)
            goto L_0x03a7
        L_0x03a4:
            r15.removeAll(r5)
        L_0x03a7:
            boolean r11 = r15.isEmpty()
            if (r11 == 0) goto L_0x03c0
            r3.addTarget(r10, r8)
            r26 = r34
            r35 = r9
            r27 = r12
            r28 = r13
            r29 = r14
            r11 = r15
            r25 = r21
            r30 = r24
            goto L_0x0414
        L_0x03c0:
            r3.addTargets(r10, r15)
            r16 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r35 = r9
            r11 = r21
            r9 = r3
            r36 = r10
            r26 = r34
            r25 = r11
            r11 = r36
            r27 = r12
            r12 = r15
            r28 = r13
            r13 = r16
            r29 = r14
            r14 = r20
            r31 = r15
            r30 = r24
            r15 = r22
            r16 = r23
            r9.scheduleRemoveTargets(r10, r11, r12, r13, r14, r15, r16)
            androidx.fragment.app.SpecialEffectsController$Operation$State r9 = r35.getFinalState()
            androidx.fragment.app.SpecialEffectsController$Operation$State r10 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
            if (r9 != r10) goto L_0x0410
            androidx.fragment.app.Fragment r9 = r35.getFragment()
            android.view.View r9 = r9.mView
            r10 = r36
            r11 = r31
            r3.scheduleHideFragmentView(r10, r9, r11)
            android.view.ViewGroup r9 = r32.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$8 r12 = new androidx.fragment.app.DefaultSpecialEffectsController$8
            r12.<init>(r11)
            androidx.core.view.OneShotPreDrawListener.add(r9, r12)
            goto L_0x0414
        L_0x0410:
            r10 = r36
            r11 = r31
        L_0x0414:
            androidx.fragment.app.SpecialEffectsController$Operation$State r9 = r35.getFinalState()
            androidx.fragment.app.SpecialEffectsController$Operation$State r12 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r9 != r12) goto L_0x042b
            r15 = r28
            r15.addAll(r11)
            r9 = r29
            if (r18 == 0) goto L_0x0428
            r3.setEpicenter((java.lang.Object) r10, (android.graphics.Rect) r9)
        L_0x0428:
            r11 = r25
            goto L_0x0434
        L_0x042b:
            r11 = r25
            r15 = r28
            r9 = r29
            r3.setEpicenter((java.lang.Object) r10, (android.view.View) r11)
        L_0x0434:
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r13 = r35
            r14 = r30
            r14.put(r13, r12)
            boolean r12 = r19.isOverlapAllowed()
            if (r12 == 0) goto L_0x0450
            r12 = 0
            r13 = r26
            java.lang.Object r10 = r3.mergeTransitionsTogether(r13, r10, r12)
            r16 = r8
            r13 = r10
            r12 = r27
            goto L_0x045c
        L_0x0450:
            r13 = r26
            r12 = 0
            r16 = r8
            r8 = r27
            java.lang.Object r8 = r3.mergeTransitionsTogether(r8, r10, r12)
            r12 = r8
        L_0x045c:
            r21 = r11
            r11 = r13
            r13 = r15
            r8 = r16
            r15 = r14
            r14 = r9
            goto L_0x033c
        L_0x0466:
            r8 = r12
            r14 = r15
            r15 = r13
            r13 = r11
            java.lang.Object r8 = r3.mergeTransitionsInSequence(r13, r8, r0)
            java.util.Iterator r9 = r33.iterator()
        L_0x0472:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x04af
            java.lang.Object r10 = r9.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r10 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r10
            boolean r11 = r10.isVisibilityUnchanged()
            if (r11 == 0) goto L_0x0485
            goto L_0x0472
        L_0x0485:
            java.lang.Object r11 = r10.getTransition()
            androidx.fragment.app.SpecialEffectsController$Operation r12 = r10.getOperation()
            if (r0 == 0) goto L_0x0495
            if (r12 == r1) goto L_0x0493
            if (r12 != r2) goto L_0x0495
        L_0x0493:
            r12 = 1
            goto L_0x0496
        L_0x0495:
            r12 = 0
        L_0x0496:
            if (r11 != 0) goto L_0x049a
            if (r12 == 0) goto L_0x0472
        L_0x049a:
            androidx.fragment.app.SpecialEffectsController$Operation r11 = r10.getOperation()
            androidx.fragment.app.Fragment r11 = r11.getFragment()
            androidx.core.os.CancellationSignal r12 = r10.getSignal()
            androidx.fragment.app.DefaultSpecialEffectsController$9 r13 = new androidx.fragment.app.DefaultSpecialEffectsController$9
            r13.<init>(r10)
            r3.setListenerForTransitionEnd(r11, r8, r12, r13)
            goto L_0x0472
        L_0x04af:
            r1 = 4
            androidx.fragment.app.FragmentTransition.setViewVisibility(r15, r1)
            java.util.ArrayList r13 = r3.prepareSetNameOverridesReordered(r5)
            android.view.ViewGroup r1 = r32.getContainer()
            r3.beginDelayedTransition(r1, r8)
            android.view.ViewGroup r10 = r32.getContainer()
            r9 = r3
            r11 = r7
            r12 = r5
            r1 = r14
            r14 = r4
            r9.setNameOverridesReordered(r10, r11, r12, r13, r14)
            r2 = 0
            androidx.fragment.app.FragmentTransition.setViewVisibility(r15, r2)
            r3.swapSharedElementTargets(r0, r7, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.startTransitions(java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    captureTransitioningViews(arrayList, childAt);
                }
            }
            return;
        }
        arrayList.add(view);
    }

    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation next : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(next.getFragment().mView);
            int ordinal = next.getFinalState().ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (from != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = next;
                }
            }
            if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = next;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation next2 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            next2.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(next2, cancellationSignal));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next2.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (next2 != operation) {
                    arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                    next2.addCompletionListener(new Runnable() {
                        public void run() {
                            if (arrayList3.contains(next2)) {
                                arrayList3.remove(next2);
                                DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                            }
                        }
                    });
                }
            } else if (next2 != operation2) {
                arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                next2.addCompletionListener(new Runnable() {
                    public void run() {
                        if (arrayList3.contains(next2)) {
                            arrayList3.remove(next2);
                            DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                        }
                    }
                });
            }
            z2 = true;
            arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
            next2.addCompletionListener(new Runnable() {
                public void run() {
                    if (arrayList3.contains(next2)) {
                        arrayList3.remove(next2);
                        DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges((SpecialEffectsController.Operation) it.next());
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public static class TransitionInfo extends SpecialEffectsInfo {
        public final boolean mOverlapAllowed;
        @Nullable
        public final Object mSharedElementTransition;
        @Nullable
        public final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object obj;
            Object obj2;
            boolean z3;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    obj2 = operation.getFragment().getReenterTransition();
                } else {
                    obj2 = operation.getFragment().getEnterTransition();
                }
                this.mTransition = obj2;
                if (z) {
                    z3 = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    z3 = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = z3;
            } else {
                if (z) {
                    obj = operation.getFragment().getReturnTransition();
                } else {
                    obj = operation.getFragment().getExitTransition();
                }
                this.mTransition = obj;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            outline24.append(getOperation().getFragment());
            outline24.append(" returned Transition ");
            outline24.append(this.mTransition);
            outline24.append(" which uses a different Transition  type than its shared element transition ");
            outline24.append(this.mSharedElementTransition);
            throw new IllegalArgumentException(outline24.toString());
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
