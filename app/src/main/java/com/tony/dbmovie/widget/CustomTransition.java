package com.tony.dbmovie.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dev on 4/2/18.
 */

public class CustomTransition extends Transition {

    private static final String TOP = "top";
    private static final String HEIGHT = "height";

    @Override
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        Rect rect = new Rect();
        view.getHitRect(rect);
        transitionValues.values.put(TOP,rect.top);
        transitionValues.values.put(HEIGHT,view.getHeight());
    }

    @Override
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        transitionValues.values.put(TOP,view.getTop());
        transitionValues.values.put(HEIGHT,view.getHeight());

    }

    @Nullable
    @Override
    public Animator createAnimator(@NonNull ViewGroup sceneRoot, @Nullable TransitionValues startValues, @Nullable TransitionValues endValues) {
        if (startValues == null || endValues == null)
        {
            return null;
        }

        final int startTop = (int) startValues.values.get(TOP);
        final int startHeight = (int) startValues.values.get(HEIGHT);
        final int endTop = (int) endValues.values.get(TOP);
        final int endHeight = (int) endValues.values.get(HEIGHT);


        final View endView = endValues.view;
        endView.getLayoutParams().height = startHeight;
        endView.requestLayout();

        final ValueAnimator animator = ValueAnimator.ofFloat(startTop,endTop);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                endView.setTranslationY((float)animator.getAnimatedValue());
            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator);
        return set;

    }
}
