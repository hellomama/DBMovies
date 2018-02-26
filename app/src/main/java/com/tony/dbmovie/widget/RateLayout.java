package com.tony.dbmovie.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.tony.dbmovie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bushi on 2018/2/3.
 */

public class RateLayout extends View {

    private int starSize;
    private int LinePadding;
    private int lineLength;
    private int startX,startY;
    private List<Integer> dataPercentage = new ArrayList<>();

    private Drawable fadeStar;
    private Drawable lightStar;

    private Paint fadePaint;
    private Paint lightPaint;

    public RateLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RateLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs)
    {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RateLayout);
        fadeStar = ta.getDrawable(R.styleable.RateLayout_fadeStar);
        lightStar = ta.getDrawable(R.styleable.RateLayout_lightStar);
        starSize = (int)ta.getDimension(R.styleable.RateLayout_starSize,40);

        ta.recycle();

        fadePaint = new Paint();
        fadePaint.setColor(getResources().getColor(R.color.grey));
        fadePaint.setAntiAlias(true);
        lightPaint = new Paint();
        lightPaint.setColor(getResources().getColor(R.color.black));
        lightPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (fadeStar == null || lightStar == null)
        {
            return;
        }

        if (dataPercentage.size()>0) {
            for (int i = 5; i > 0; i--) {
                draw(i, dataPercentage.get(i-1), canvas);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int MAX_WIDTH = measure(widthMeasureSpec, true);
        int MAX_HEIGHT = measure(heightMeasureSpec, false);
        setMeasuredDimension(MAX_WIDTH, MAX_HEIGHT);
        LinePadding = (MAX_HEIGHT - 5*starSize)/10;
        lineLength = MAX_WIDTH - 5*starSize;
        startX = (MAX_WIDTH - lineLength - 5*starSize)/2;
        startY = (MAX_HEIGHT - 5*(starSize+LinePadding))/2;
    }

    private int measure(int measureSpec, boolean isWidth) {
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int padding = isWidth ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = isWidth ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
            result += padding;
            if (mode == MeasureSpec.AT_MOST) {
                if (isWidth) {
                    result = Math.max(result, size);
                } else {
                    result = Math.min(result, size);
                }
            }
        }
        return result;
    }

    private void draw(int starCount,int percent,Canvas canvas)
    {
        for (int i = 0;i<5-starCount;i++)
        {
            fadeStar.setBounds(startX+i * starSize,(5-starCount)*(starSize+LinePadding)+startY,(i+1) * starSize+startX,(5-starCount)*(starSize+LinePadding)+starSize+startY);
            fadeStar.draw(canvas);
        }
        for (int i=5-starCount;i<5;i++)
        {
            lightStar.setBounds(startX+i * starSize,(5-starCount)*(starSize+LinePadding)+startY,(i+1) * starSize+startX,(5-starCount)*(starSize+LinePadding)+starSize+startY);
            lightStar.draw(canvas);
        }
        canvas.drawLine(startX+5 * starSize,(5-starCount)*(starSize+LinePadding)+startY + starSize/2,lineLength+5*starSize,(5-starCount)*(starSize+LinePadding)+startY + starSize/2,fadePaint);
        canvas.drawLine(startX+5 * starSize,(5-starCount)*(starSize+LinePadding)+startY + starSize/2,(int)(lineLength * percent /100)+5*starSize,(5-starCount)*(starSize+LinePadding)+startY + starSize/2,lightPaint);
    }

    public void setData(List<Double> data)
    {
        double sum = 0;
        for (double p:data)
        {
            sum += p;
        }
        dataPercentage.clear();
        for (int i = 0;i<5;i++)
        {

            dataPercentage.add((int)(data.get(i)/sum*100));
        }
        invalidate();
    }
}
