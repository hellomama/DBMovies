package com.tony.dbmovie.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.tony.dbmovie.R;

import static android.graphics.Paint.Style.STROKE;

/**
 * Created by dev on 3/23/18.
 */

public class LoadingView extends View implements View.OnClickListener{

    private Paint paint;
    private float center_x,center_y,radius,start_x,start_y;
    private  Path path;
    private int angle =0;
    private ValueAnimator animator;
    private boolean finish = false;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init()
    {
        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        paint.setStyle(STROKE);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        path = new Path();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        path.addArc(center_x - radius,center_y - radius,center_x +radius,center_y + radius, 0,angle);
        canvas.drawPath(path,paint);
        if (finish) {
            path.moveTo(center_x - radius / 2, center_y);
            path.moveTo(center_x, center_y + radius / 2);
            path.moveTo(center_x, center_y + radius / 2);
            canvas.drawLine(center_x - radius / 2, center_y, center_x, center_y + radius / 2, paint);
            path.lineTo(center_x + radius / 2, center_y - radius / 2);
            canvas.drawPath(path,paint);

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        center_x = getMeasuredWidth()/2;
        center_y = getMeasuredHeight()/2;
        radius = center_x>center_y?center_y/2:center_x/2;
        start_x =center_x - radius;
        start_y = radius;
    }

    private void startAnimation()
    {
        animator = new ValueAnimator();
        animator.setIntValues(0,360);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                angle = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                finish = true;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    private void start()
    {
        if (animator == null)
        {
            startAnimation();
        }else {
            if (animator.isRunning())
            {
                animator.cancel();
                animator.start();
            }else {
                animator.start();
            }
        }
    }

    @Override
    public void onClick(View v) {
        start();
    }
}
